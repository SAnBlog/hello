package cn.sanii.hello.Controller;

import cn.sanii.hello.bean.BaseResponse;
import cn.sanii.hello.bean.User;
import cn.sanii.hello.dao.UserDao;
import cn.sanii.hello.util.CookieUtils;
import cn.sanii.hello.util.JWTUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shouliang.wang
 * @Description: 操作user
 * 以下采用RESTful风格API
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //token三十分钟失效
    private static final long TOKEN_MAX_AGE = 30L * 60L * 1000L;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

/*    @Resource
    private RedisTemplate<String,User> redisTemplate;
     数据量不大，可以使用stringRedisTemplate存储，将对象转成json
     百万级数据采用redisTemplate
    */

    @Autowired
    private UserDao userDao;



    /**
     * @param
     * @return 添加一条信息
     * @author shouliang.wang
     * @date 2018/4/11 19:20
     */
    @PostMapping(value = "/add")
    public BaseResponse<User> add(@Valid User user, BindingResult result) {
        BaseResponse<User> baseResponse = new BaseResponse<>();
        if (result.hasErrors()) {
            logger.info("添加失败 msg :{}", result.getFieldError().getDefaultMessage());
            return baseResponse.setError(result.getFieldError().getDefaultMessage());
        }
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //存入redis，一个小时后过期返回null
        ops.set(String.valueOf(user.getId()), JSON.toJSONString(user), 1, TimeUnit.HOURS);
        logger.info("存入redis成功 id :{},user :{}", user.getId(), JSON.toJSONString(user));
        //UUID
        user.setUuid(UUID.randomUUID().toString());
        return baseResponse.setSuccess(userDao.save(user));
    }

    /**
     * @param
     * @return 删除一条信息
     * @author shouliang.wang
     * @date 2018/4/11 19:20
     */
    @GetMapping(value = "/delete/{id}")
    public BaseResponse<String> delete(@PathVariable(value = "id") Integer id) {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        stringRedisTemplate.delete(String.valueOf(id));
        userDao.deleteById(id);
        logger.info("删除用户信息成功,id:{}", id);
        return baseResponse.setSuccess("删除用户信息成功 id:" + id);
    }


    /**
     * @param
     * @return 更新一条信息
     * @author shouliang.wang
     * @date 2018/4/11 19:20
     */
    @PostMapping(value = "/update")
    public BaseResponse<User> update(User user) {
        BaseResponse<User> baseResponse = new BaseResponse<>();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //存入redis，一个小时后过期返回null
        ops.set(String.valueOf(user.getId()), JSON.toJSONString(user), 1, TimeUnit.HOURS);
        logger.info("更新用户信息成功:id{},user:{}", user.getId(), JSON.toJSONString(user));
        return baseResponse.setSuccess(userDao.save(user));
    }

    /**
     * @param
     * @return 通过name查询
     * @author shouliang.wang
     * @date 2018/4/11 19:20
     */
    @GetMapping(value = "/findbyname/{name}")
    public BaseResponse<List<User>> update(@PathVariable(value = "name") String name) {
        BaseResponse<List<User>> baseResponse = new BaseResponse<>();
        List<User> userList = userDao.findByName(name);
        logger.info("findbyname result:{}", JSON.toJSONString(userList));
        return baseResponse.setSuccess(userList);
    }

    /**
     * @param
     * @return 用户登录
     * @author shouliang.wang
     * @date 2018/5/8 10:15
     */
    @PostMapping(value = "/login")
    public BaseResponse<Map<String, Object>> login(User user, HttpServletResponse response) {
        BaseResponse<Map<String, Object>> baseResponse = new BaseResponse<>();
        Map<String, Object> map = Maps.newHashMap();
        List<User> userList = userDao.findByName(user.getName());
        if (userList.isEmpty()) {
            baseResponse.setError("用户名不存在!");
        } else {
            User info = userList.get(0);
            if (info.getPwd().equals(user.getPwd())) {
                //生产环境可以移除密码
//                info.setPwd("");
                //生成token 30分钟失效
//                String token = JWT.sign(info, TOKEN_MAX_AGE);
                String token = JWTUtil.createToken(info.getName());
                map.put("user", info);
                map.put("token", token);
                baseResponse.setSuccess(map);
                //存入redis，30后过期返回null
                ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
                //使用 jjwt 生成 Token ，保存在 Redis 中，以UUID作为token key
                ops.set(info.getName(), token, 30, TimeUnit.MINUTES);
                //token存入Cookie
                Cookie cookie = new Cookie("token", token);
                // 设置为30min
                cookie.setMaxAge(30 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
                logger.info("token存入Cookie&Redis:{}", token);
            } else {
                baseResponse.setError("密码有误!");
            }
        }

        return baseResponse;
    }

    /**
     * @param request 从Cookie中获取token
     * @return 用户退出
     * @author shouliang.wang
     * @date 2018/5/8 15:01
     */
    @GetMapping(value = "/logout")
    public BaseResponse<String> logout(HttpServletRequest request) {
        //获取Cookie中的token
        String token = CookieUtils.getCookieValue(request, "token", true);
        if (!StringUtils.isBlank(token)) {
            //获取token中用户信息
//            User user = JWT.unsign(token, User.class);
            String username = JWTUtil.getUsername(token);
            //通过UUID key删除Redis中的token
//            Boolean delete = stringRedisTemplate.delete(user.getUuid());
            Boolean delete = stringRedisTemplate.delete(username);
            if (delete) {
                logger.info("用户已退出登录:{}", username);
            }
        }
        BaseResponse<String> response = new BaseResponse<>();
        response.setSuccess("OK");
        return response;
    }

    @GetMapping(value = "/error")
    public BaseResponse<String> error() {
        BaseResponse<String> response = new BaseResponse<>();
        response.setError("请重新登录");
        return response;
    }

/*  转移到全局异常处理Controller中处理
  @GetMapping(value = "/unauthorized/{message}")
    public BaseResponse<String> unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        BaseResponse<String> response = new BaseResponse<>();
        response.setError(message);
        return response;
    }*/
}