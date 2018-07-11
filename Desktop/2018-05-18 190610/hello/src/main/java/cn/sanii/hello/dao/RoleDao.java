package cn.sanii.hello.dao;

import cn.sanii.hello.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 16:30
 * @Description:
 */
public interface RoleDao extends JpaRepository<Role,Integer> {


//    @Query(value = "select r.name from UserRole ur,Role r where ur.roleID=r.id and ur.userID=?1")
    @Query(value = "select r.* from user_role ur,Role r where ur.roleID=r.id and ur.userID=?1",nativeQuery = true)
    List<Role> getRole(int userId);
}