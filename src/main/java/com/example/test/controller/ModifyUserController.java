package com.example.test.controller;

import com.example.test.pojo.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ModifyUserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String showUsers(ModelMap modelMap){
        List<User> users = userService.findAllUser();
        modelMap.addAttribute("users",users);
        return "users";
    }
    @RequestMapping("/users1")
    public String showUsers1(ModelMap modelMap){
        List<User> users = userService.findAllUser();
        modelMap.addAttribute("users",users);
        return "users1";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map addUser(User user){
        int flag = userService.addUser(user);
        Map<String,Object> map = new HashMap<String,Object>();
        if(flag == 1){
            map.put("msg","新增用户成功");
            return map;
        }else {
            map.put("msg","新增用户失败");
            return map;
        }
    }


    @RequestMapping(value = "/delUser+{userId}")
    public String delUser(@PathVariable("userId") String id,ModelMap modelMap){
        int flag = userService.deleteUser(id);
        List<User> users = userService.findAllUser();
        modelMap.addAttribute("users",users);
        if(flag == 1){
            return "users";
        }else {
            return "error";
        }
    }

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/user+{userId}")
    public String queryUser(@PathVariable("userId") String id,ModelMap modelMap){
        User user = userService.queryUserById(id);
        modelMap.addAttribute("user", user);
        return "userInfo";
    }

    /**
     * 根据用户ID修改用户信息
     * remark：这里未做用户名是否重复校验
     * @param admin
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public Map updateUser(User admin){
        int flag = userService.updateUser(admin);
        Map<String,Object> map = new HashMap<>();
        if(flag == 1){
            map.put("msg","修改用户信息成功");
            return map;
        }else {
            map.put("msg","修改用户信息失败");
            return map;
        }
    }

}
