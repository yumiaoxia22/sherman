package com.idaoben.web.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sherman 2018/7/14 22:18
 */

@Controller
public class IndexController {

    @RequestMapping("/user")
    public String login() {
        return "user";
    }
}
