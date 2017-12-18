package cn.nju.controller.login;

import cn.nju.common.enumeration.RequestStatus;
import cn.nju.model.User;
import cn.nju.service.LoginService;
import cn.nju.vo.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Value("${session.loggedin.user}")
    private String LOGGED_IN_USER;

    @Autowired
    private LoginService loginService;

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(HttpSession httpSession){
        if (httpSession.getAttribute(LOGGED_IN_USER) != null){
            //已经登录
        }
        return null;
    }

    /**
     * 登录请求
     * @return
     */
    @PostMapping("/login")
    public @ResponseBody RequestStatus login(String uname, String passwd, HttpSession httpSession){
        User user = loginService.login(uname, passwd);
        if (user != null){
            LoggedInUser loggedInUser = new LoggedInUser(user.getUid(), user.getUname());
            httpSession.setAttribute(LOGGED_IN_USER, loggedInUser);
            return RequestStatus.SUCCESS;
        }
        return RequestStatus.FAIL;
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
    public String logout(HttpSession httpSession){
        if (httpSession.getAttribute(LOGGED_IN_USER) != null){
            httpSession.removeAttribute(LOGGED_IN_USER);
        }
        return null;
    }

}
