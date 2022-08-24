package com.example.test.controller;

import com.example.test.pojo.Admin;
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

    /**
     * 查询所有用户信息
     * @param modelMap
     * @return
     */
    @RequestMapping("/users")
    public String showUsers(ModelMap modelMap){
        List<Admin> users = userService.queryAllUser();
        modelMap.addAttribute("users",users);
        return "users";
    }
    @RequestMapping("/users1")
    public String showUsers1(ModelMap modelMap){
        List<Admin> users = userService.queryAllUser();
        modelMap.addAttribute("users",users);
        return "users1";
    }

    /**
     * 新增用户
     * remark：这里未做用户名是否重复校验
     * @param admin
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public Map addUser(Admin admin){
        int flag = userService.addUser(admin);
        Map<String,Object> map = new HashMap<String,Object>();
        if(flag == 1){
            map.put("msg","新增用户成功");
            return map;
        }else {
            map.put("msg","新增用户失败");
            return map;
        }
    }


    /**
     * 根据用户ID删除用户信息
     * @param id
     * @param modelMap
     * @return
     */
//    @RequestMapping(value = "/deleteUser+{id}")
//    public String dropUser(@PathVariable("id") String id,ModelMap modelMap){
//        int flag = userService.dropUser(id);
//        List<Admin> userList = userService.queryAllUser();
//        modelMap.addAttribute("userList",userList);
//        if(flag == 1){
//            return "users";
//        }else {
//            return "error";
//        }
//    }

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/user+{id}")
    public String queryUser(@PathVariable("id") String id,ModelMap modelMap){
        Admin admin = userService.queryUserById(id);
        modelMap.addAttribute("user", admin);
        return "userInfo";
    }

    /**
     * 根据用户ID修改用户信息
     * remark：这里未做用户名是否重复校验
     * @param admin
     * @return
     */
//    @RequestMapping("/modifyUser")
//    @ResponseBody
//    public Map modifyUser(Admin admin){
//        int flag = userService.modifyUser(admin);
//        Map<String,Object> map = new HashMap<>();
//        if(flag == 1){
//            map.put("msg","修改用户信息成功");
//            return map;
//        }else {
//            map.put("msg","修改用户信息失败");
//            return map;
//        }
//    }

}
