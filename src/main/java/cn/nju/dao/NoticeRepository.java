package cn.nju.dao;

import cn.nju.model.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, String>{
}
