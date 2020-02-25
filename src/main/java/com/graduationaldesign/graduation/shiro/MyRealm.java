package com.graduationaldesign.graduation.shiro;

import com.graduationaldesign.graduation.shiro.JwtToken.JWTToken;
import com.graduationaldesign.graduation.shiro.utils.JWTUtil;
import java.util.Map;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

//import com.example.shiro_jwt.core.shiro.JwtToken.JWTToken;
//import com.example.shiro_jwt.core.shiro.utils.JWTUtil;
//import com.example.shiro_jwt.model.User;
//import com.example.shiro_jwt.service.IUserService;

/**
 * Created by Administrator on 2017/10/11.
 */
public class MyRealm extends AuthorizingRealm {

//    @Autowired
//    private IUserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        return null;
    }

    /**
     * 授权:获取用户角色与权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        String userName = JWTUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        Map<String, Object> map = null;
        //从数据库查询role和permission
        try {
//            map = this.userService.getRolesAndPermissionsByUserName(userName);
            auth.setRoles((Set<String>) map.get("allRoles"));
            auth.setStringPermissions((Set<String>) map.get("allPermissions"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auth;
    }

    /**
     * 认证
     * 在post的时候先进行认证
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    /*@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)
            throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得userName，用于和数据库进行对比
        String userName = JWTUtil.getUsername(token);
        User vo = this.userService.getUserByUserName(userName);
        String redisUserInfo = (String) redisTemplate.opsForValue().get("token_jwt_" + userName);

        Map result = JWTUtil.verify(token, userName, vo.getPassword());
        Exception exception = (Exception) result.get("exception");

        if (vo == null) {
            throw new UnknownAccountException("该帐号不存在！");
        } else if (exception != null && exception instanceof SignatureVerificationException) {
            throw new AuthenticationException("Token错误(Token incorrect.)！");
        } else if (exception != null && exception instanceof TokenExpiredException) {
            throw new AuthenticationException("Token已过期(Token expired.)！");
            //被T
        } else if (StringUtils.isEmpty(redisUserInfo)) {
            throw new AuthenticationException("Token已失效(Token invalid.)！");
        } else {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token, token,
                    vo.getUserName());
            return authcInfo;
        }
    }*/
}
