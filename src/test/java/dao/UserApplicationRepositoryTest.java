package dao;

import cn.nju.Application;
import cn.nju.common.UUIDGenerator;
import cn.nju.dao.UserApplicationRepository;
import cn.nju.model.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserApplicationRepositoryTest {

    @Autowired
    private UserApplicationRepository userApplicationRepository;

    @Test
    public void testAdd(){
        UserApplication userApplication = new UserApplication();
        userApplication.setAid(UUIDGenerator.getShortUUID());
        userApplication.setAge(21);
        userApplication.setGender(1);
        userApplication.setJob("工人");
        userApplication.setMedicalHistory("无");
        userApplication.setPasswd("123456");
        userApplication.setSymptom("无");
        userApplication.setUname("testuser1");
        userApplication.setState(1);
        userApplicationRepository.save(userApplication);
    }
    @Test
    public void testFind(){

        System.out.println(userApplicationRepository.findAllByState(1).size());
    }
}
