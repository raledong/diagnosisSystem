package dao;

import cn.nju.Application;
import cn.nju.common.UUIDGenerator;
import cn.nju.dao.UserRepository;
import cn.nju.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUid(UUIDGenerator.getShortUUID());
        user.setAge(25);
        user.setGender(1);
        user.setMedicalHistory("nothing2");
        user.setPasswd("hello");
        user.setSymptom("nothing");
        user.setUname("rale");
        user.setType(1);
        userRepository.save(user);
    }

    @Test
    public void testAddDoctor(){
        User user = new User();
        user.setUid(UUIDGenerator.getShortUUID());
        user.setAge(18);
        user.setGender(0);
        user.setMedicalHistory("nothing2");
        user.setPasswd("rale");
        user.setSymptom("nothing");
        user.setUname("rale");
        user.setType(1);
        userRepository.save(user);
    }
//    @Test
//    public void testFind(){
//        User user = userRepository.findDistinctByUnameAndPasswdAndType("rale", "hello", 1);
//        System.out.println(user.getMedicalHistory());
//    }

}
