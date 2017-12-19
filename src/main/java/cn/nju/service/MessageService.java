package cn.nju.service;

import cn.nju.vo.MessageVO;

import java.util.List;

public interface MessageService {

    /**
     * 根据照片ID找到照片的所有评论
     * @param pid
     * @return
     */
    List<MessageVO> findAllByPhotoId(String pid);

    /**
     * 添加一条回复
     * @param senderId 发送者id
     * @param info 回复内容
     * @param pid 照片id
     * @return
     */
    boolean addMessage(String senderId, String info, String pid);

}
