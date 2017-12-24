package cn.nju.vo;

import cn.nju.model.Notice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeVO {

    private String nid;

    private String content;

    private String date;

    private String title;

    public NoticeVO() {
    }

    public NoticeVO(Notice notice){
        this.setNid(notice.getNid());
        this.setContent(notice.getContent());
        this.setDate(notice.getDate());
        this.setTitle(notice.getTitle());
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

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(date);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
