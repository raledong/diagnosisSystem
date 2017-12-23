package cn.nju.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户申请表单
 */
@Entity
@Table(name = "application")
public class UserApplication {
    public static final int PENDING = 0;
    public static final int APPROVE = 1;
    public static final int DISAPPROVE = 2;

    //用户id
    @Id
    private String aid;

    //用户名
    @Column(name = "uname")
    private String uname;

    //用户性别（0代表男，1代表女）
    @Column(name = "gender")
    private int gender;

    //用户年龄
    @Column(name = "age")
    private int age;

    //职业
    @Column(name = "job")
    private String job;

    //病史
    @Column(name = "medical_history")
    private String medicalHistory;

    //最近症状
    @Column(name = "symptom")
    private String symptom;

    //用户类型（0表示用户，1表示医生）
    @Column(name = "type")
    private int type;

    @Column(name = "account")
    private String account;

    //密码
    @Column(name = "passwd")
    private String passwd;

    //申请状态（0表示未审核，1表示审核通过，2表示审核未通过）
    @Column(name = "state")
    private int state;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
