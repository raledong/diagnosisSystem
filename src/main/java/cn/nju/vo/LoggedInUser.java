package cn.nju.vo;

/**
 * session中存储的用户信息
 */
public class LoggedInUser {

    //用户id
    private String uid;

    //用户姓名
    private String uname;


    public LoggedInUser(){}

    public LoggedInUser(String uid, String uname){
        this.setUid(uid);
        this.setUname(uname);
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
