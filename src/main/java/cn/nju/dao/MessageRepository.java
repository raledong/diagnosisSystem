package cn.nju.dao;

import cn.nju.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String>{

    /**
     * 找到照片的所有评论
     * @param pid
     * @return
     */
    List<Message> findAllByPidOrderByTime(String pid);
}
