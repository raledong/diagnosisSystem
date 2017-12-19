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
//    /**
//     * 登录页面
//     * @return
//     */
//    @GetMapping("/login")
//    public @ResponseBody String login(HttpSession httpSession){
//        logger.info(LOGGED_IN_USER);
//        if (httpSession.getAttribute(LOGGED_IN_USER) != null){
//            LoggedInUser loggedInUser = (LoggedInUser) httpSession.getAttribute(LOGGED_IN_USER);
//            logger.info(loggedInUser.getUid());
//            //已经登录 进入主界面
//        }
//        //返回到登录界面
//        return "greeting my friend";
//    }
//
//    /**
//     * 登录请求
//     * @return
//     */
//    @PostMapping("/login")
//    public @ResponseBody RequestStatus login(String uname, String passwd, HttpSession httpSession){
//        User user = loginService.login(uname, passwd);
//        logger.info(uname + ":" + passwd);
//        if (user != null){
////            httpSession.setAttribute("USER_NAME", user.getUname());
////            httpSession.setAttribute("USER_ID", user.getUid());
//            Authentication auth = SecurityContextHolder.getContext()
//                    .getAuthentication();
//            model.addAttribute("uri", request.getRequestURI())
//                    .addAttribute("user", auth.getName())
//                    .addAttribute("roles", auth.getAuthorities());
//            return RequestStatus.SUCCESS;
//        }
//        return RequestStatus.FAIL;
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }
    @RequestMapping("/login")
    public String login() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "login";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "home";
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
        logger.info((httpSession.getAttribute(LOGGED_IN_USER) != null)?"success":"fail");
        if (httpSession.getAttribute(LOGGED_IN_USER) != null){
            httpSession.removeAttribute(LOGGED_IN_USER);
            httpSession.invalidate();
        }
        return null;
    }

}
