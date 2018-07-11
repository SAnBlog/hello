package cn.sanii.hello.Controller;

import cn.sanii.hello.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shouliang.wang
 * @Description:
 */
@RestController
public class HelloConterller {



    @Autowired
    private UserBean user;

    /**
     * 获取application定义的info属性值
     * @param name
     * @return
     */
    @GetMapping(value = "info")
    public String hello(String name){
        return user.getName()+user.getDomian()+user.getAge();
    }


    @PostMapping(value = "domain")
    public String getDomain(@RequestParam(value = "name",required =false) String name){
        return name;
    }

    @GetMapping(value = "/get/{id}")
    public String getID(@PathVariable("id") int id){
        return "id:"+id;
    }

}
