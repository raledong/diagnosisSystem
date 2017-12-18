package cn.nju.vo;

import cn.nju.model.SymptomType;

import java.util.ArrayList;
import java.util.List;

public class SymptomTypeVO {
    //父类信息
    //分类的id
    private String tid;

    //分类名称
    private String tname;

    //分类详细描述
    private String description;

    //子类信息
    private List<SubSymptomTypeVO> subSymptomTypes;

    public SymptomTypeVO(SymptomType symptomType, List<SymptomType> subSymptomTypes){
        this(symptomType);
        if (subSymptomTypes!=null && !subSymptomTypes.isEmpty()){
            for (SymptomType subSymptomType : subSymptomTypes){
                addSubSymptomTypes(subSymptomType);
            }
        }
    }

    public SymptomTypeVO(SymptomType symptomType){
        this();
        this.setTid(symptomType.getTid());
        this.setTname(symptomType.getTname());
        this.setDescription(symptomType.getDescription());
    }

    public SymptomTypeVO(){
        this.subSymptomTypes = new ArrayList<>();
    }
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public List<SubSymptomTypeVO> getSubSymptomTypes() {
        return subSymptomTypes;
    }

    public void setSubSymptomTypes(List<SubSymptomTypeVO> subSymptomTypes) {
        this.subSymptomTypes = subSymptomTypes;
    }

    public void addSubSymptomTypes(SymptomType symptomType){
        SubSymptomTypeVO subSymptomTypeVO = new SubSymptomTypeVO(symptomType);
        subSymptomTypes.add(subSymptomTypeVO);
    }

    public void addSubSymptomTypes(List<SymptomType> symptomTypes){
        if (symptomTypes!=null && !symptomTypes.isEmpty()){
            for (SymptomType symptomType : symptomTypes){
                addSubSymptomTypes(symptomType);
            }
        }
    }
}
