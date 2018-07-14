package com.idaoben.web.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sherman 2018/7/14 22:14
 */
@Controller
@RequestMapping
public class LoginController {

    @RequestMapping("/login")
    public String applylogin() {
        return "index";
    }


}
