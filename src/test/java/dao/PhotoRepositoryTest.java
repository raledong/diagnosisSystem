package dao;

import cn.nju.Application;
import cn.nju.common.UUIDGenerator;
import cn.nju.dao.PhotoRepository;
import cn.nju.model.Photo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PhotoRepositoryTest {

    @Autowired
    private PhotoRepository photoRepository;

    @Test
    public void testAddPhoto(){
        Photo photo = new Photo();
        photo.setPid(UUIDGenerator.getShortUUID());
        photo.setDid("1");
        photo.setTid("3");
        photo.setPosition("/img/患者照片.jpg");
        photo.setTime(1);
        photoRepository.save(photo);
    }

    @Test
    public void testAllPhoto(){
        System.out.println(photoRepository.findAllByDidOrderByTime("1").size());
        System.out.println(photoRepository.findAllByDidAndTidIsNotNull("1").size());
        System.out.println(photoRepository.findAllByDidAndTidIsNull("1").size());
    }
}
