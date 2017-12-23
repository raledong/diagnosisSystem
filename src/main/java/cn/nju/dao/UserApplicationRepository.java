package cn.nju.dao;

import cn.nju.model.UserApplication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserApplicationRepository extends CrudRepository<UserApplication, String>{

    /**
     * 根据申请的状态查找申请
     * @param state 0：未审核 1：审核通过 2：审核未通过
     * @return
     */
    List<UserApplication> findAllByState(int state);

    /**
     * 根据申请的状态和角色查找申请
     * @param state
     * @param type
     * @return
     */
    List<UserApplication> findAllByStateAndType(int state, int type);
}
