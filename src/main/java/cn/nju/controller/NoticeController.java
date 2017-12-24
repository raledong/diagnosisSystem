package cn.nju.controller;

import cn.nju.common.config.UserDetails;
import cn.nju.common.enumeration.RequestStatus;
import cn.nju.service.NoticeService;
import cn.nju.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 获取所有的通知
     * @return
     */
    @GetMapping("")
    public @ResponseBody List<NoticeVO> findAll(){
        return noticeService.findAll();
    }

    @PostMapping("")
    public @ResponseBody RequestStatus addNotice(@RequestParam String title, @RequestParam String content, Authentication authentication){
        UserDetails userDetails  = (UserDetails) authentication.getPrincipal();
        String did = userDetails.getUserId();
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setContent(content);
        noticeVO.setTitle(title);
        return noticeService.addNotice(noticeVO, did) ? RequestStatus.SUCCESS : RequestStatus.FAIL;
    }
}
