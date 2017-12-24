package cn.nju.vo;

import cn.nju.model.Photo;
import cn.nju.model.SymptomType;

import java.util.ArrayList;
import java.util.List;

public class PhotoDetailVO {

    //照片id
    private String pid;

    //照片路径
    private String[] positions;

    //照片拍摄时间
    private String time;

    //照片的标签
    private List<SymptomTypeDetailVO> symptomTypeDetails;

    public PhotoDetailVO(){
        symptomTypeDetails = new ArrayList<>();
    }

    public PhotoDetailVO(Photo photo){
        this();
        this.setPid(photo.getPid());
        this.setPositions(photo.getPositions());
        this.setTime(photo.getTime());
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String[] getPositions() {
        return positions;
    }

    public void setPositions(String[] positions) {
        this.positions = positions;
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

    public List<SymptomTypeDetailVO> getSymptomTypeDetails() {
        return symptomTypeDetails;
    }

    public void setSymptomTypeDetails(List<SymptomTypeDetailVO> symptomTypeDetails) {
        this.symptomTypeDetails = symptomTypeDetails;
    }

    public void addSymptomTypeDetail(SymptomTypeDetailVO symptomTypeDetailVO){
        this.symptomTypeDetails.add(symptomTypeDetailVO);
    }
}
