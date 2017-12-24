package cn.nju.model;

import cn.nju.vo.NoticeVO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 公告PO
 */
@Entity
@Table(name = "notice")
@EntityListeners(AuditingEntityListener.class)
public class Notice {

    @Id
    @Column(name = "nid")
    private String nid;

    @Column(name = "content")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "date")
    private Date date;

    @Column(name = "uid")
    private String uid;

    @Column(name = "title")
    private String title;

    public Notice() {
    }

    public Notice(NoticeVO noticeVO){
        this.setTitle(noticeVO.getTitle());
        this.setContent(noticeVO.getContent());
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
