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

}
