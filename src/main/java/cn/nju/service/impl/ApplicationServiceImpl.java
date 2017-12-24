package cn.nju.service.impl;

import cn.nju.dao.UserApplicationRepository;
import cn.nju.dao.UserRepository;
import cn.nju.model.User;
import cn.nju.model.UserApplication;
import cn.nju.service.ApplicationService;
import cn.nju.vo.ApplicationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        if (userApplication == null) return false;
        if (userApplication.getState() != UserApplication.PENDING) return false;

        userApplication.setState(UserApplication.APPROVE);
        userApplicationRepository.save(userApplication);
        User user = new User(userApplication);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean disapprove(String appId) {
        UserApplication userApplication = userApplicationRepository.findOne(appId);
        if (userApplication==null) return false;
        if (userApplication.getState() == UserApplication.PENDING) return false;

        userApplication.setState(UserApplication.DISAPPROVE);
        userApplicationRepository.save(userApplication);
        return true;
    }

    @Override
    public List<ApplicationVO> findAllPendingApplications() {
        List<UserApplication> applications = userApplicationRepository.findAllByState(UserApplication.PENDING);
        List<ApplicationVO> applicationVOS = new ArrayList<>();
        if (applications!=null && !applications.isEmpty()){
            for (UserApplication userApplication : applications){
                ApplicationVO applicationVO = new ApplicationVO(userApplication);
                applicationVOS.add(applicationVO);
            }
        }
        return applicationVOS;
    }
}
