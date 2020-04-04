package com.graduationaldesign.graduation.controller.shiro;

import com.graduationaldesign.graduation.controller.Api;
import com.graduationaldesign.graduation.pojo.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(Pojo = "Shiro", description = "shiro控制层")
public class ShiroController {

    //    @RequestMapping("/login1")
    public String login(Admin user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getAdminId(),
                user.getAdminPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }
        return "login success";
    }

    //注解验角色和权限
//    @RequiresRoles("admin")
//    @RequiresPermissions("add")
//    @RequestMapping("/index")
    public String index() {
        return "index!";
    }
}