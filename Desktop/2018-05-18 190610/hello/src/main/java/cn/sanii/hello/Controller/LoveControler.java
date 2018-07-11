package cn.sanii.hello.Controller;

import cn.sanii.hello.bean.BaseResponse;
import cn.sanii.hello.bean.Lover;
import cn.sanii.hello.dao.LoverDao;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author sanii.cn
 * @Description: biaobai
 * @date 2018/5/19 15:15
 */
@Controller
public class LoveControler {
    private static final Logger logger = LoggerFactory.getLogger(LoveControler.class);

    //token one hour expres
    private static final long MAX_AGE = 60L * 60L * 1000L;

    @Autowired
    private LoverDao loverDao;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/")
    private String index() {
        return "/index";
    }

    @GetMapping("/start/{url}")
    private String getStart(Model model, @PathVariable(value = "url") String url) throws UnsupportedEncodingException {
        String redisRrl = stringRedisTemplate.opsForValue().get(url);
        if (StringUtils.isBlank(redisRrl)) {
            List<Lover> loverList = loverDao.getLoverByUrl(url);
            if (!loverList.isEmpty()) {
                Lover lover = loverList.get(0);
                if (StringUtils.equals(lover.getIsOpen(), "true")) {
                    String json = JSON.toJSONString(lover);
                    ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
                    ops.set(lover.getUrl(), json, MAX_AGE, TimeUnit.MINUTES);
                    logger.info("set redis url success:{}", json);
                    model.addAttribute("lover", lover);
                    return "/start";
                }
            }
            return "/index";
        }
        Lover lover = JSON.parseObject(redisRrl, Lover.class);
        logger.info("get redis url success:{}", redisRrl);
        model.addAttribute("lover", lover);
        return "/start";
    }

    @PostMapping(value = "/520/add")
    @ResponseBody
    public BaseResponse<Lover> add(@RequestBody@Valid Lover lover, BindingResult result) {
        BaseResponse<Lover> baseResponse = new BaseResponse<>();
        if (result.hasErrors()) {
            logger.info("add lover error  :{}", result.getFieldError().getDefaultMessage());
            return baseResponse.setError(result.getFieldError().getDefaultMessage());
        }
        if (loverDao.getLoverByUrl(lover.getUrl()).isEmpty()) {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set(lover.getUrl(), JSON.toJSONString(lover), MAX_AGE, TimeUnit.MINUTES);
            logger.info("lover add success:{}", JSON.toJSONString(lover));
            return baseResponse.setSuccess(loverDao.save(lover));
        }
        return baseResponse.setError("该URL已被使用，请更换一个吧");
    }

    @GetMapping("/one/{url}")
    private String getOne(Model model, @PathVariable(value = "url") String url) {
        String redisRrl = stringRedisTemplate.opsForValue().get(url);
        if (StringUtils.isBlank(redisRrl)) {
            List<Lover> loverList = loverDao.getLoverByUrl(url);
            if (!loverList.isEmpty()) {
                Lover lover = loverList.get(0);
                if (StringUtils.equals(lover.getIsOpen(), "true")) {
                    String json = JSON.toJSONString(lover);
                    ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
                    ops.set(lover.getUrl(), json, MAX_AGE, TimeUnit.MINUTES);
                    logger.info("set redis url success:{}", json);
                    model.addAttribute("lover", lover);
                    return "/one";
                }
            }
            return "/index";
        }
        Lover lover = JSON.parseObject(redisRrl, Lover.class);
        logger.info("get redis url success:{}", redisRrl);
        model.addAttribute("lover", lover);
        return "/one";
    }

    @GetMapping("/two/{url}")
    private String getTwo(Model model, @PathVariable(value = "url") String url) {
        String redisRrl = stringRedisTemplate.opsForValue().get(url);
        if (StringUtils.isBlank(redisRrl)) {
            List<Lover> loverList = loverDao.getLoverByUrl(url);
            if (!loverList.isEmpty()) {
                Lover lover = loverList.get(0);
                if (StringUtils.equals(lover.getIsOpen(), "true")) {
                    String json = JSON.toJSONString(lover);
                    ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
                    ops.set(lover.getUrl(), json, MAX_AGE, TimeUnit.MINUTES);
                    logger.info("set redis url success:{}", json);
                    model.addAttribute("lover", lover);
                    return "/two";
                }
            }
            return "/index";
        }
        Lover lover = JSON.parseObject(redisRrl, Lover.class);
        logger.info("get redis url success:{}", redisRrl);
        model.addAttribute("lover", lover);
        return "/two";
    }

    @GetMapping("/three/{url}")
    private String getThree(Model model, @PathVariable(value = "url") String url) {
        String redisRrl = stringRedisTemplate.opsForValue().get(url);
        if (StringUtils.isBlank(redisRrl)) {
            List<Lover> loverList = loverDao.getLoverByUrl(url);
            if (!loverList.isEmpty()) {
                Lover lover = loverList.get(0);
                if (StringUtils.equals(lover.getIsOpen(), "true")) {
                    String json = JSON.toJSONString(lover);
                    ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
                    ops.set(lover.getUrl(), json, MAX_AGE, TimeUnit.MINUTES);
                    logger.info("set redis url success:{}", json);
                    model.addAttribute("lover", lover);
                    return "/three";
                }
            }
            return "/index";
        }
        Lover lover = JSON.parseObject(redisRrl, Lover.class);
        logger.info("get redis url success:{}", redisRrl);
        model.addAttribute("lover", lover);
        return "/three";
    }
}
