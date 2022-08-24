package com.example.test.controller;

import com.example.test.pojo.Admin;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String account, String password) {
        Admin admin = userService.loginIn(account, password);
        if (admin != null) {
            if (admin.getRoleId() == 1) {
                return "success";
            }
            if (admin.getRoleId() == 2) {
                return "success1";
            }
        } else {
            return "error";
        }
        return "error";
    }
}