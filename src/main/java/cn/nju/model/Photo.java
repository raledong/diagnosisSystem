package cn.nju.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "photo")
@EntityListeners(AuditingEntityListener.class)
public class Photo {
    //照片id
    @Id
    @Column(name = "pid")
    private String pid;

    //用户id
    @Column(name = "uid")
    private String uid;

    //医生id
    @Column(name = "did")
    private String did;

    //症状id
    @Column(name = "tid")
    private String tid;

    //照片存储位置
    @Column(name = "position")
    private String position;

    //照片类型
    @Column(name = "photo_type")
    private int photoType;

    //上传时间
    @Column(name = "upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date updateDate;

    //拍摄时间 0-早 1-中 2-晚
    @Column(name = "time")
    private int time;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPhotoType() {
        return photoType;
    }

    public void setPhotoType(int photoType) {
        this.photoType = photoType;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
