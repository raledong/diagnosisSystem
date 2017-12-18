package cn.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return null;
    }

    /**
     * 登录请求
     * @return
     */
    @PostMapping("/login")
    public String login(String u){
        return null;
    }


    /**
     * 退出登录
     */
    public void logout(){

    }

}
