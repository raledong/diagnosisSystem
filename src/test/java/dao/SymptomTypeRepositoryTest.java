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
        symptomType.setTid("1");
        symptomType.setUperId(null);
        symptomType.setTname("parent");
        symptomTypeRepository.save(symptomType);

        SymptomType symptomType1 = new SymptomType();
        symptomType1.setTid("2");
        symptomType1.setUperId("1");
        symptomType1.setTname("second level tag");
        symptomTypeRepository.save(symptomType1);

        SymptomType symptomType2 = new SymptomType();
        symptomType2.setTid("3");
        symptomType2.setUperId("2");
        symptomType2.setTname("third level tag");
        symptomTypeRepository.save(symptomType2);
    }
}
