package com.idaoben.web.shiro.service;

import com.idaoben.web.shiro.commom.Result;
import com.idaoben.web.shiro.commom.ResultStatusProcess;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Sherman 2018/7/15 1:33
 */
@Service
public class LoginApplicationService {
    Logger log = LoggerFactory.getLogger(LoginApplicationService.class);
    @Autowired
    private ResultStatusProcess resultStatusProcess;

    public Result login(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        Result result = null;
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);

            try {
                currentUser.login(token);
                result = resultStatusProcess.process(200, "登录成功，正在为您跳转");
            } catch (AuthenticationException ae) {
                log.error("登录失败");
                result = resultStatusProcess.process(400, "登录不通过");
            }
        } else {
            result = resultStatusProcess.process(200, "您已经登录了");
        }
        return result;
    }
}
