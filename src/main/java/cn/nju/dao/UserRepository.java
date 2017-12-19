package cn.nju.dao;

import cn.nju.model.User;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, String> {

    User findDistinctByUnameAndPasswdAndType(String uname, String passwd, int type);

    User findDistinctByUnameAndType(String uname, int type);

}