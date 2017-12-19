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
        photo.setDid("123");
        photo.setTid("anIb6gJQ");
        photo.setPhotoType(1);
        photo.setPosition("/Users/rale/Downloads");
        photo.setTime(1);
        photoRepository.save(photo);
    }
}
