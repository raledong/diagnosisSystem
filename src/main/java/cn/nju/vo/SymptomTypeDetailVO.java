package cn.nju.vo;

public class SymptomTypeDetailVO {

    //标签id
    private String tid;

    //标签内容
    private String tname;

    //标签的父标签内容
    private String pname;

    //标签的父父标签的内容
    private String ppname;

    public SymptomTypeDetailVO(){}

    public SymptomTypeDetailVO(String tid, String tname, String pname, String ppname) {
        this.tid = tid;
        this.tname = tname;
        this.pname = pname;
        this.ppname = ppname;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPpname(String ppname) {
        this.ppname = ppname;
    }
}
