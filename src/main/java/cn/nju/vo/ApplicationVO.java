package cn.nju.vo;

import cn.nju.model.UserApplication;

public class ApplicationVO {

    private String aid;

    private String name;

    private String type;

    public ApplicationVO(UserApplication userApplication){
        this.setAid(userApplication.getAid());
        this.setName(userApplication.getUname());
        this.setType(userApplication.getType());
    }
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setType(int type){
        switch (type){
            case 0 : this.type = "用户"; break;
            case 1 : this.type = "医生"; break;
            default: this.type = "未知"; break;
        }
    }
}
