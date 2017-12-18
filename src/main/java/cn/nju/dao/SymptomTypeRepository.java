package cn.nju.dao;

import cn.nju.model.SymptomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SymptomTypeRepository extends CrudRepository<SymptomType, String>{

    /**
     * 根据父类型的Id找到所有的子类型
     * @param uperId
     * @return
     */
    List<SymptomType> findByUperId(String uperId);

    /**
     * 找到所有的父类型Id
     * @return
     */
    List<SymptomType> findByUperIdIsNull();
}
