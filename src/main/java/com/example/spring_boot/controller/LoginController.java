package com.example.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController{


//    @RequestMapping( value = "/use/login" , method = RequestMethod.POST )
    @PostMapping( value = "/use/login")
    public String login(@RequestParam("username") String username ,
                        @RequestParam("password") String password ,
                        Map<String , Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)&&"123456".equals(password)){
            //登陆成功以后，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUname",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码错误");
        return "login";
    }
}
