package dao;

import cn.nju.Application;
import cn.nju.common.UUIDGenerator;
import cn.nju.dao.SymptomTypeRepository;
import cn.nju.model.SymptomType;
import org.assertj.core.util.Compatibility;
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

    @Test
    public void testFindByName(){
        System.out.println(symptomTypeRepository.findDistinctByTname("test tag").getTid());
    }

    @Test
    public void testAddSubSymptoms(){
        SymptomType symptomType = new SymptomType();
        symptomType.setTid(UUIDGenerator.getShortUUID());
        symptomType.setUperId("1");
        symptomType.setTname("sub");
        symptomTypeRepository.save(symptomType);

    }
}
