package cn.nju.common.interceptor;

import cn.nju.vo.LoggedInUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${session.loggedin.user}")
    private String LOGGED_IN_USER;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("pre login handler");
        LoggedInUser loggedin_user = (LoggedInUser) httpServletRequest.getSession().getAttribute(LOGGED_IN_USER);
        if (loggedin_user == null){
            logger.info("have not logged in, redirect to login page");
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        logger.info("have logged in");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("after login handler");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("after login completion");
    }
}
