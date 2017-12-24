package cn.nju.service.impl;

import cn.nju.common.UUIDGenerator;
import cn.nju.dao.NoticeRepository;
import cn.nju.model.Notice;
import cn.nju.service.NoticeService;
import cn.nju.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<NoticeVO> findAll() {
        Iterable<Notice> iterable = noticeRepository.findAll();
        List<NoticeVO> noticeVOS = new ArrayList<>();
        if (iterable!=null){
            Iterator<Notice> iterator = iterable.iterator();
            while (iterator.hasNext()){
                NoticeVO noticeVO = new NoticeVO(iterator.next());
                noticeVOS.add(noticeVO);
            }
        }

        return noticeVOS;
    }

    @Override
    public boolean addNotice(NoticeVO noticeVO, String userId) {
        if (noticeVO==null || userId==null || userId.isEmpty()) return false;
        Notice notice = new Notice(noticeVO);
        notice.setNid(UUIDGenerator.getShortUUID());
        notice.setUid(userId);
        noticeRepository.save(notice);
        return true;
    }
}
