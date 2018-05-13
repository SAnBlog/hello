package cn.sanii.hello.Controller;

import cn.sanii.hello.bean.BaseResponse;
import cn.sanii.hello.bean.User;
import cn.sanii.hello.dao.UserDao;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/11 10:19
 * @Description:
 * 显示个人模板Controller
 */
@RequestMapping(value = "/show")
@Controller
public class FreemarkerController {

    private static final Logger logger = LoggerFactory.getLogger(FreemarkerController.class);

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
     * @return 查询一条信息
     * @author shouliang.wang
     * @date 2018/4/11 19:20
     */
    @GetMapping(value = "/find/{id}")
    @RequiresAuthentication
    public String update(@PathVariable(value = "id") Integer id, Model model) {
        BaseResponse<User> baseResponse = new BaseResponse<>();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //Json转成对象
        User result = JSON.parseObject(ops.get(String.valueOf(id)), User.class);
        if (Objects.equal(result, null)) {
            User user = userDao.findById(id).get();
            //存入redis，一个小时后过期返回null
            ops.set(String.valueOf(id), JSON.toJSONString(user), 1, TimeUnit.HOURS);
            logger.info("根据用户查询用户信息存入redis成功:{}", JSON.toJSONString(user));
            result = user;
        }
        logger.info("从redis查询用户信息成功 :{}", JSON.toJSONString(result));
        baseResponse.setSuccess(result);
        model.addAttribute("user", result);
        return "/san";
    }


    /**
     * @param
     * @return 获取User表信息
     * @author shouliang.wang
     * @date 2018/4/11 19:20
     */
    @GetMapping(value = "/getAll")
    @RequiresRoles(logical = Logical.OR, value = {"admin"})
    public String getAll(Model model) {
        BaseResponse<List<User>> baseResponse = new BaseResponse<>();
        //先查redis是否存在
        String list = stringRedisTemplate.opsForValue().get("userList");
        if (Strings.isNullOrEmpty(list)) {
            //没有则查询数据库并存入redis
            List<User> userList = userDao.findAll();
            //存入redis，一个小时后过期返回null
            stringRedisTemplate.opsForValue().set("userList", JSON.toJSONString(userList), 1, TimeUnit.HOURS);
            //对象转json
            logger.info("所有表信息已存入redis :{}", JSON.toJSONString(userList));
            baseResponse.setSuccess(userList);
            model.addAttribute("list", baseResponse);
            return "/index";
        }
        logger.info("从redis获取User信息成功 :{}", list);
        List<User> result = Lists.newArrayList();
        //json转对象
        baseResponse.setSuccess(JSON.parseObject(list, result.getClass()));
        model.addAttribute("list", baseResponse);
        return "/index";
    }

}
