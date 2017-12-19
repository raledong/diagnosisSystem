package cn.nju.vo;

import cn.nju.model.Photo;
import cn.nju.model.SymptomType;

public class PhotoDetailVO {

    //照片id
    private String pid;

    //照片路径
    private String position;

    //照片拍摄时间
    private String time;

     //父类id
    private String rootClassName;

    //父类名称
    private String rootClassId;

    //子类id
    private String childClassName;

    //子类名称
    private String childClassId;

    public PhotoDetailVO(Photo photo){
        this.setPid(photo.getPid());
        this.setPosition(photo.getPosition());
        this.setTime(photo.getTime());
    }
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTime(int time){
        switch (time){
            case 0 : this.time = "早上";break;
            case 1 : this.time = "中午";break;
            case 2 : this.time = "晚上";break;
            default: this.time = "无";
        }
    }
    public String getRootClassName() {
        return rootClassName;
    }

    public void setRootClassName(String rootClassName) {
        this.rootClassName = rootClassName;
    }

    public String getRootClassId() {
        return rootClassId;
    }

    public void setRootClassId(String rootClassId) {
        this.rootClassId = rootClassId;
    }

    public void setRootClass(SymptomType symptomType){
        this.setRootClassId(symptomType.getTid());
        this.setRootClassName(symptomType.getTname());
    }

    public String getChildClassName() {
        return childClassName;
    }

    public void setChildClassName(String childClassName) {
        this.childClassName = childClassName;
    }

    public String getChildClassId() {
        return childClassId;
    }

    public void setChildClassId(String childClassId) {
        this.childClassId = childClassId;
    }

    public void setChildClass(SymptomType symptomType){
        this.setChildClassId(symptomType.getTid());
        this.setChildClassName(symptomType.getTname());
    }
}
