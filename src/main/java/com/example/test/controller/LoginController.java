package com.example.test.controller;

import com.example.test.pojo.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String account, String password) {
        User user = userService.loginIn(account, password);
        if (user != null) {
            if (user.getRoleId() == 1) {
                return "success";
            }
            if (user.getRoleId() == 2) {
                return "success1";
            }
        } else {
            return "error";
        }
        return "error";
    }
}