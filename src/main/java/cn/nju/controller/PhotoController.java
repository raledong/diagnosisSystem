package cn.nju.controller;

import cn.nju.dao.PhotoRepository;
import cn.nju.service.PhotoService;
import cn.nju.vo.PhotoDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    /**
     * 查看所有照片
     */
    @GetMapping()
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

    /**
     * 查看编号为PID的照片的详情
     * @param pid
     * @return
     */
    @GetMapping("/{id}")
    public PhotoDetailVO getPhotoDetail(@PathVariable("id") String pid){
        return photoService.findPhotoDetailById(pid);
    }

}
