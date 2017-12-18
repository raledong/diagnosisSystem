package cn.nju.dao;

import cn.nju.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, String> {

}
