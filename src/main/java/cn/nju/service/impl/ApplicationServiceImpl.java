package cn.nju.service.impl;

import cn.nju.dao.UserApplicationRepository;
import cn.nju.dao.UserRepository;
import cn.nju.model.User;
import cn.nju.model.UserApplication;
import cn.nju.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
    private UserApplicationRepository userApplicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean approve(String appId) {
        UserApplication userApplication = userApplicationRepository.findOne(appId);
        if (userApplication !=null){
            userApplication.setState(UserApplication.APPROVE);
            userApplicationRepository.save(userApplication);
            User user = new User(userApplication);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean disapprove(String appId) {
        UserApplication userApplication = userApplicationRepository.findOne(appId);
        if (userApplication !=null){
            userApplication.setState(UserApplication.DISAPPROVE);
            userApplicationRepository.save(userApplication);
            return true;
        }
        return false;
    }
}
