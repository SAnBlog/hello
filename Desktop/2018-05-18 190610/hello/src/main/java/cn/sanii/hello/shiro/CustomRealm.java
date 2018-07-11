package cn.sanii.hello.shiro;

import cn.sanii.hello.bean.Permisson;
import cn.sanii.hello.bean.Role;
import cn.sanii.hello.bean.User;
import cn.sanii.hello.dao.PermissionDao;
import cn.sanii.hello.dao.RoleDao;
import cn.sanii.hello.dao.UserDao;
import cn.sanii.hello.util.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @Author sanii.cn
 * @Description 自定义 Realm
 * @Date 2018-04-09
 * @Time 16:58
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private  UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public CustomRealm(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("Token Authentication Error！");
        }
        //这里加上redis判断token是否移除或者失效
        //获取token中的用户信息
        //通过UUID KEY查redis是否存在token（是否过期）
        String tokenInfo = stringRedisTemplate.opsForValue().get(username);
        //如果tokenInfo没有过期
        if (StringUtils.isBlank(tokenInfo)) {
            throw new AuthenticationException("Token TimeOut！");
        }
        if (!tokenInfo.equals(token)) {
            throw new AuthenticationException("Token Inconsistent");
        }

        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("————权限认证————");
        String username = JWTUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        User user = userDao.findByName(username).get(0);
        //user owon role
        List<Role> roleList = roleDao.getRole(user.getId());
        //每个用户可以设置新的权限
        List<Permisson> permissonList = permissionDao.getRole(user.getId());

        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
        for (Role r:roleList){
            roleSet.add(r.getName());
        }
        for (Permisson p: permissonList){
            permissionSet.add(p.getName());
        }
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }
}
