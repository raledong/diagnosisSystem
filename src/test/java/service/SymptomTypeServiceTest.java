package service;

import cn.nju.Application;
import cn.nju.dao.SymptomTypeRepository;
import cn.nju.service.SymptomTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SymptomTypeServiceTest {

    @Autowired
    private SymptomTypeService symptomTypeService;

    @Test
    public void testSomeMethod() {
        System.out.println(symptomTypeService.findAll());
    }
}
