package cn.nju.service;

import cn.nju.vo.NoticeVO;

import java.util.List;

public interface NoticeService {

    /**
     * 获得所有的通知
     * @return
     */
    List<NoticeVO> findAll();

    /**
     * 新建一条公告
     * @param noticeVO
     * @return
     */
    boolean addNotice(NoticeVO noticeVO, String userId);
}
