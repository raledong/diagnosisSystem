package cn.nju.controller.login;

import cn.nju.common.enumeration.RequestStatus;
import cn.nju.model.User;
import cn.nju.service.LoginService;
import cn.nju.vo.LoggedInUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/login")
    public String login() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "TestLogin";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info(username);
        return "hello";
    }

    /**
     * 登录页面
     * @param info
     */
    @PostMapping("/register")
    public void register(String info){

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
