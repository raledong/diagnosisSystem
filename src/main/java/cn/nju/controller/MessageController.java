package cn.nju.controller;

import cn.nju.common.enumeration.RequestStatus;
import cn.nju.service.MessageService;
import cn.nju.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param senderId
     * @param info
     * @param pid
     * @return
     */
    @PostMapping()
    public RequestStatus createMessage(String senderId, String info, String pid){
        return messageService.addMessage(senderId, info, pid) ? RequestStatus.SUCCESS : RequestStatus.FAIL;

    }
}
