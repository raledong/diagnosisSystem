package cn.nju.controller;

import cn.nju.dao.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/photo")
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;

    /**
     * 查看所有照片
     */
    @GetMapping("all")
    public void index(){

    }

    /**
     * 查看尚未回复的照片
     */
    @GetMapping("replied")
    public void getRepliedPhotos(){

    }

    /**
     * 查看已经回复的照片
     */
    @GetMapping("notreplied")
    public void getNotRepliedPhotos(){

    }

}
