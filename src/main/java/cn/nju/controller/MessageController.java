package cn.nju.controller;

import cn.nju.service.MessageService;
import cn.nju.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("{pid}")
    public List<MessageVO> getMessagesByPhotoId(@PathVariable("pid") String pid){
        return messageService.findAllByPhotoId(pid);
    }
}
