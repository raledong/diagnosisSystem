package cn.nju.service.impl;

import cn.nju.dao.UserRepository;
import cn.nju.model.User;
import cn.nju.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String uname, String passwd) {
        User user = userRepository.findDistinctByUnameAndPasswdAndType(uname, passwd, User.DOCTOR);
        return user;
    }
}
