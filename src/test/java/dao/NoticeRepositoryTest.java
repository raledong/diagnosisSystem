package dao;

import cn.nju.Application;
import cn.nju.dao.NoticeRepository;
import cn.nju.model.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class NoticeRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    public void testAdd(){
        Notice notice = new Notice();
        notice.setNid("1");
        notice.setContent("hello world");
        notice.setTitle("first post");
        notice.setUid("rd3LAPOQ");
        noticeRepository.save(notice);
    }
}
