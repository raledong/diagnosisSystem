package cn.nju.vo;
/**
 * 子类型VO
 */
import cn.nju.model.SymptomType;

public class SubSymptomTypeVO {

    //分类的id
    private String tid;

    //母分类id
    private String uperId;

    //分类名称
    private String tname;

    //分类详细描述
    private String description;

    public SubSymptomTypeVO(SymptomType symptomType){
        this.setTid(symptomType.getTid());
        this.setUperId(symptomType.getUperId());
        this.setTname(symptomType.getTname());
        this.setDescription(symptomType.getDescription());
    }

    public SubSymptomTypeVO(String tid, String uperId, String tname, String description){
        this.setTid(tid);
        this.setUperId(uperId);
        this.setTname(tname);
        this.setDescription(description);
    }

    public SubSymptomTypeVO(){

    }


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUperId() {
        return uperId;
    }

    public void setUperId(String uperId) {
        this.uperId = uperId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
