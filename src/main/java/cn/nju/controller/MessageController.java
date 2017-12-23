package cn.nju.controller;

import cn.nju.common.config.UserDetails;
import cn.nju.common.enumeration.RequestStatus;
import cn.nju.service.MessageService;
import cn.nju.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 照片的所有回复
     * @param pid
     * @return
     */
    @GetMapping("{pid}")
    public List<MessageVO> getMessagesByPhotoId(@PathVariable("pid") String pid){
        return messageService.findAllByPhotoId(pid);
    }

    /**
     * 创建一条新的回复
     * @param authentication 认证信息
     * @param info
     * @param pid
     * @return
     */
    @PostMapping()
    public RequestStatus createMessage(String info, String pid, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return messageService.addMessage(userDetails.getUserId(), info, pid) ? RequestStatus.SUCCESS : RequestStatus.FAIL;

    }
}
