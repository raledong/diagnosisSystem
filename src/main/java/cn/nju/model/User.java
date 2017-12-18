package cn.nju.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public static final int USER = 0;
    public static final int DOCTOR = 1;

    //用户id
    @Id
    @Column(name = "uid")
    private String uid;

    //用户姓名
    @Column(name = "uname")
    private String uname;

    //用户性别，0代表男，1代表女
    @Column(name = "gender")
    private int gender;

    //用户年龄
    @Column(name = "age")
    private int age;

    //病史
    @Column(name = "medical_history")
    private String medicalHistory;

    //最近症状
    @Column(name = "symptom")
    private String symptom;

    //用户类型 0代表用户 1代表医生
    @Column(name = "type")
    private int type;

    @Column(name = "account")
    private String account;
    //密码
    @Column(name = "passwd")
    private String passwd;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}