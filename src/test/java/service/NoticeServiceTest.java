package service;

import cn.nju.Application;
import cn.nju.service.NoticeService;
import cn.nju.vo.NoticeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class NoticeServiceTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void testAdd(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setContent("what??");
        noticeVO.setTitle("hello world again");
        noticeService.addNotice(noticeVO, "rd3LAPOQ");
    }

//    @Test
    public void testFindAll(){
        System.out.println(noticeService.findAll().size());
    }

}
