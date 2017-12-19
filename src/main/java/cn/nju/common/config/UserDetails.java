package cn.nju.common.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class UserDetails extends User{
	private static final long serialVersionUID = 1578155611248927311L;

	private String userId;
	public UserDetails(String userId, String username, String password, GrantedAuthority authorities) {
        super(username, password, Collections.singletonList(authorities));
        this.setUserId(userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
