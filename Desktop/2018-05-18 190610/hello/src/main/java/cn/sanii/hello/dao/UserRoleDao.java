package cn.sanii.hello.dao;

import cn.sanii.hello.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 17:26
 * @Description:
 */
public interface UserRoleDao extends JpaRepository<UserRole,Integer> {

//    @Query(value = "select ur.id,ur.roleID,ur.permissionID from user_role ur where ur.roleID=?1")
    List<UserRole> getUserRolesByUserID(int id);



}
