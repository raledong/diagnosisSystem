package cn.nju.controller.login;

import cn.nju.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Value("${session.loggedin.user}")
    public String LOGGED_IN_USER;

    @Autowired
    private LoginService loginService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String home(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username!=null && !username.isEmpty()){
            return "FurPhotoGallery";
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username+"hello");
        return "login";
    }

    /**
     * 退出登录
     */
    @GetMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return null;
    }

}
