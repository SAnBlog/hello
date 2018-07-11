package cn.sanii.hello.dao;

import cn.sanii.hello.bean.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 17:27
 * @Description:
 */
public interface RolePermissionDao extends JpaRepository<RolePermission,Integer> {
    /**
     * @author shouliang.wang
     * @date 2018/4/12 9:49
     * @param id 角色ID
     * @return ist<User> 符合条件的用户
     */
    List<RolePermission> findByRoleID(int id);

}
