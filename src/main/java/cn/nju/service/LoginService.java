package cn.nju.service;

import cn.nju.model.User;

public interface LoginService {

    /**
     * 医生登录系统
     * @param uname 用户名
     * @param passwd 密码
     * @return 用户是否登录成功
     */
    User login(String uname, String passwd);

}
