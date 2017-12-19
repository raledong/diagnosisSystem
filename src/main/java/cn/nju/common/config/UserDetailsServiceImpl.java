package cn.nju.common.config;

import cn.nju.dao.UserRepository;
import cn.nju.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findDistinctByUnameAndType(username, User.DOCTOR);
        System.out.println("in security " + username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find user!");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getType()==1?"Doctor" : "User");
        return new UserDetails(user.getUid(), user.getUname(), user.getPasswd(), authority);
    }
}
