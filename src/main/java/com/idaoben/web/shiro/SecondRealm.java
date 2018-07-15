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

public class SecondRealm extends AuthenticatingRealm {
    Logger logger = LoggerFactory.getLogger(AuthenticatingRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("SecondRealm+密码验证");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();

        if ("unknow".equals(username)) {
            throw new UnknownAccountException("用户不存在");
        } else if ("monster".equals(username)) {
            throw new UnknownAccountException("用户被锁定");
        }
        Object principal = username;
        Object credentials = new SimpleHash("SHA1", "123456", username, 1024);
        logger.info(credentials.toString());

        ByteSource salt = ByteSource.Util.bytes(username);
        AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, salt, this.getName());
        return info;
    }
}
