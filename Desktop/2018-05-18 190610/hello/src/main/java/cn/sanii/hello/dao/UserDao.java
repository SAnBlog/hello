package cn.sanii.hello.dao;

import cn.sanii.hello.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author shouliang.wang
 * @Description:
 */

public interface UserDao extends JpaRepository<User,Integer>{
    /**
     * @author shouliang.wang
     * @date 2018/4/12 9:49
     * @param name 用户名
     * @return ist<User> 符合条件的用户
     */
     List<User> findByName(String name);
}
