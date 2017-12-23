package service;

import cn.nju.Application;
import cn.nju.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    public void testApprove(){
        System.out.println(applicationService.approve("NZvnOhEl"));
    }
}
