package cn.nju.vo;

import cn.nju.model.Message;

public class MessageVO {

    //消息ID
    private String mid;

    //发送者ID
    private String senderId;

    //发送者名字
    private String senderName;

    //接收者ID
    private String receiveId;

    //照片ID
    private String pid;

    //内容
    private String content;

    public MessageVO(){}

    public MessageVO(Message message){
        this.setMid(message.getMid());
        this.setSenderId(message.getSenderId());
        this.setReceiveId(message.getReceiveId());
        this.setPid(message.getPid());
        this.setContent(message.getContent());
    }
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
