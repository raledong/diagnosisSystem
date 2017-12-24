package cn.nju.vo;

import cn.nju.model.SymptomType;

import java.util.ArrayList;
import java.util.List;

public class SymptomTypeVO {

    private String tid;

    private String uperId;

    private String tname;

    private String description;

    private List<SymptomTypeVO> subSymptomTypes;

    public SymptomTypeVO(){
        subSymptomTypes = new ArrayList<>();
    }

    public SymptomTypeVO(SymptomType symptomType){
        this();
        this.setTid(symptomType.getTid());
        this.setUperId(symptomType.getUperId());
        this.setTname(symptomType.getTname());
        this.setDescription(symptomType.getDescription());
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

    public List<SymptomTypeVO> getSubSymptomTypes() {
        return subSymptomTypes;
    }

    public void setSubSymptomTypes(List<SymptomTypeVO> subSymptomTypes) {
        this.subSymptomTypes = subSymptomTypes;
    }

    public void addSubSymptomType(SymptomType symptomType){
        SymptomTypeVO symptomTypeVO = new SymptomTypeVO(symptomType);
        subSymptomTypes.add(symptomTypeVO);
    }

    public void addSubSymptomTypes(List<SymptomType> symptomTypes){
        if (symptomTypes!=null && !symptomTypes.isEmpty()){
            for (SymptomType tempSymptomType : symptomTypes){
                addSubSymptomType(tempSymptomType);
            }
        }
    }

    public void addSubSymptomType(SymptomTypeVO symptomTypeVO){
        subSymptomTypes.add(symptomTypeVO);
    }
}
