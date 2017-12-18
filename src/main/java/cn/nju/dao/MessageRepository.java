package cn.nju.dao;

import cn.nju.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String>{
}
