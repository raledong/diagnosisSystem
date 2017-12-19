package service;

import cn.nju.Application;
import cn.nju.common.UUIDGenerator;
import cn.nju.model.Photo;
import cn.nju.service.PhotoService;
import cn.nju.vo.PhotoDetailVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PhotoServiceTest {

    @Autowired
    private PhotoService photoService;

    @Test
    public void testFind(){

        System.out.println(photoService.findRepliedPhotos("1").size());
    }
}
