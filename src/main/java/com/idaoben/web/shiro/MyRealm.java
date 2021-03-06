package com.idaoben.web.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sherman 2018/7/14 19:48
 */

public class MyRealm extends AuthenticatingRealm {
    Logger logger = LoggerFactory.getLogger(AuthenticatingRealm.class);
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("MyRealm+密码验证");
        // 1.将参数authenticationToken强转为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        // 2.获取username
        String username = usernamePasswordToken.getUsername();
        // 3.调用数据库方法，查询username的对应用户信息
        // 4.若用户不存在,抛出UnknownAccountException异常
        if ("unknow".equals(username)) {
            throw new UnknownAccountException("用户不存在");
        } else if ("monster".equals(username)) {
            throw new UnknownAccountException("用户被锁定");
        }
        //5. 根据用户情况，来构建AuthenTicationInfo 对象并返回，通常使用的实现类为SimpleAuthenTicationInfo
        // 1).principal:认证的实体信息，可以是username,也可以是数据库表对应的实体对象
        Object principal = username;
        // 2) credentials:密码,通过MD5哈希加密
        Object credentials = new SimpleHash("MD5", "123456", username, 1024);
        logger.info(credentials.toString());
        // 3) realmName; 当前realm 的name,调用父类的getName方法。
        // 4) 盐值生成方法
        ByteSource salt = ByteSource.Util.bytes(username);
        AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, salt, this.getName());
        return info;
    }
}
