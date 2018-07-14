package com.idaoben.web.shiro.controller;

import com.idaoben.web.shiro.ResultStatus;
import com.idaoben.web.shiro.commom.Result;
import com.idaoben.web.shiro.service.LoginApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sherman 2018/7/14 22:14
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private LoginApplicationService loginService;
    @RequestMapping("/login")
    public String applylogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        Result result = loginService.login(username, password);
        ResultStatus status = result.getStatus();
        if (status == ResultStatus.SUCCESS) {
            return "index";
        }
        return "redirect:login";
    }


}
