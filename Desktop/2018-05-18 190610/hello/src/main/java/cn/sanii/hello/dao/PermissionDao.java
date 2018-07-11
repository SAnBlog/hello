package cn.sanii.hello.dao;

import cn.sanii.hello.bean.Permisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 16:31
 * @Description:
 */
public interface PermissionDao extends JpaRepository<Permisson,Integer> {

    @Query(value = "SELECT p.* FROM role_permission rp,permission p WHERE rp.permissionid=p.id AND rp.roleid=?1",nativeQuery = true)
    List<Permisson> getRole(int Id);
}
