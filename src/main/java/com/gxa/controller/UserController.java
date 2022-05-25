package com.gxa.controller;

import com.gxa.entity.User;
import com.gxa.service.UserSerice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserSerice userSerice;

//    @RequestMapping("/insert")
//
//    public String insert(User user, Map  map){
//
//        this.userSerice.insert(user);
//
//        List<User> list = new ArrayList<>();
//        list.add(new User(1,"11","22"));
//        list.add(new User(2,"22","33"));
//        list.add(new User(3,"44","55"));
//
//        map.put("users",list);
//
//        //return "suc";
//        return "main";
//    }
//    @RequestMapping("/login")
//    public String login(User user, HttpSession session,Map map){
//        User login = this.userSerice.login(user);
//        if (login!=null){
//            session.setAttribute("user",login);
//            return "main";
//        }
//        map.put("error","用户名或者密码不正确!");
//        return "defult";
//    }

    @RequestMapping("/login")
    public String shiroLogin(User user,Map map){

        System.out.println("name:--->" + user.getName());
        System.out.println("pwd:--->" + user.getPwd());

        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPwd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            map.put("user",user);
            return "main";
        }catch (Exception e){
            map.put("error","登录失败");
            return "login";
        }
    }
}
