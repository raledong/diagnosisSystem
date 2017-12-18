package dao;

import cn.nju.Application;
import cn.nju.dao.SymptomTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SymptomTypeRepositoryTest {
    @Autowired
    private SymptomTypeRepository symptomTypeRepository;

    @Test
    public void testFindSymptoms(){
        System.out.println(symptomTypeRepository.findByUperIdIsNull());
    }
}
