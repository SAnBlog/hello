package cn.sanii.hello.Controller;

import cn.sanii.hello.bean.*;
import cn.sanii.hello.dao.PermissionDao;
import cn.sanii.hello.dao.RoleDao;
import cn.sanii.hello.dao.RolePermissionDao;
import cn.sanii.hello.dao.UserRoleDao;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/15 16:35
 * @Description:
 */
@RestController
public class Test {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @PostMapping(value = "/insertRole")
    public BaseResponse<Role> insertRole(Role role) {
        BaseResponse<Role> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(roleDao.save(role));
    }

    @PostMapping(value = "/insertPermission")
    public BaseResponse<Permisson> insertPermission(Permisson permission) {
        BaseResponse<Permisson> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(permissionDao.save(permission));
    }

    @PostMapping(value = "/insertUR")
    public BaseResponse<UserRole> insertUR(UserRole userRole) {
        BaseResponse<UserRole> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(userRoleDao.save(userRole));
    }

    @GetMapping(value = "/findURByID/{id}")
    public BaseResponse<List<UserRole>> insertUR(@PathVariable(value = "id") int id) {
        BaseResponse<List<UserRole>> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(userRoleDao.getUserRolesByUserID(id));
    }

    @GetMapping(value = "/findRPByID/{id}")
    public BaseResponse<List<RolePermission>> insertRP(@PathVariable(value = "id") int id) {
        BaseResponse<List<RolePermission>> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(rolePermissionDao.findByRoleID(id));
    }

    @GetMapping(value = "/getRole/{id}")
    @RequiresAuthentication
    public BaseResponse<List<Role>> getRole(@PathVariable(value = "id") int id) {
        BaseResponse<List<Role>> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(roleDao.getRole(id));
    }

    @GetMapping(value = "/getPermisson/{id}")
    public BaseResponse<List<Permisson>> getPermisson(@PathVariable(value = "id") int id) {
        BaseResponse<List<Permisson>> baseResponse = new BaseResponse<>();
        return baseResponse.setSuccess(permissionDao.getRole(id));
    }
}
