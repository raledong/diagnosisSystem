package dao;

import cn.nju.Application;
import cn.nju.common.UUIDGenerator;
import cn.nju.dao.MessageRepository;
import cn.nju.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testInsertMessage(){
        Message message = new Message();
        message.setContent("hello world");
        message.setMid(UUIDGenerator.getShortUUID());
        message.setPid("123");
        message.setReceiveId("2131");
        messageRepository.save(message);
    }
}
