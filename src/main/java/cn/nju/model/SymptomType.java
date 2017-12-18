package cn.nju.model;

import cn.nju.vo.SubSymptomTypeVO;
import cn.nju.vo.SymptomTypeVO;

import javax.persistence.*;

@Entity
@Table(name = "symptom_type")
public class SymptomType {

    //分类的id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid")
    private String tid;

    //母分类id
    @Column(name = "uper_id")
    private String uperId;

    //分类名称
    @Column(name = "tname")
    private String tname;

    //分类详细描述
    @Column(name = "description")
    private String description;

    public SymptomType(SymptomTypeVO symptomTypeVO){
        this.setTid(symptomTypeVO.getTid());
        this.setUperId(null);
        this.setTname(symptomTypeVO.getTname());
        this.setDescription(symptomTypeVO.getDescription());
    }

    public SymptomType(SubSymptomTypeVO subSymptomTypeVO){
        this.setTid(subSymptomTypeVO.getTid());
        this.setUperId(subSymptomTypeVO.getUperId());
        this.setTname(subSymptomTypeVO.getTname());
        this.setDescription(subSymptomTypeVO.getDescription());
    }

    public SymptomType(){}

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
