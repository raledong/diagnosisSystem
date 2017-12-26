package cn.nju.controller;

import cn.nju.common.config.UserDetails;
import cn.nju.common.enumeration.RequestStatus;
import cn.nju.dao.PhotoRepository;
import cn.nju.model.SymptomType;
import cn.nju.service.PhotoService;
import cn.nju.vo.PhotoDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    /**
     * 查看所有照片
     */
    @GetMapping()
    public @ResponseBody List<PhotoDetailVO> all(Authentication authentication){
//        UserDetails userDetails  = (UserDetails) authentication.getPrincipal();
//        String did = userDetails.getUserId();
        return photoService.findAllPhotos();
    }

    /**
     * 查看已经回复的照片
     */
    @GetMapping("/replied")
    public @ResponseBody List<PhotoDetailVO> getRepliedPhotos(Authentication authentication){
//        UserDetails userDetails  = (UserDetails) authentication.getPrincipal();
//        String did = userDetails.getUserId();
        return photoService.findRepliedPhotos();
    }

    /**
     * 查看未回复的照片
     */
    @GetMapping("/notreplied")
    public @ResponseBody List<PhotoDetailVO> getNotRepliedPhotos(Authentication authentication){
//        UserDetails userDetails  = (UserDetails) authentication.getPrincipal();
//        String did = userDetails.getUserId();
        return photoService.findUnrepliedPhotos();
    }

    /**
     * 查看编号为PID的照片的详情
     * @param pid
     * @return
     */
    @GetMapping("/{id}")
    public @ResponseBody PhotoDetailVO getPhotoDetail(@PathVariable("id") String pid){
        return photoService.findPhotoDetailById(pid);
    }



    /**
     * 添加照片的分类
     * @param pid
     * @param tid
     * @return
     */
    @PutMapping("/{id}")
    public @ResponseBody
    RequestStatus addPhotoSymptom(@PathVariable("id")String pid, String tid){
        return photoService.addSymptomType(pid, tid) ? RequestStatus.SUCCESS : RequestStatus.FAIL;
    }

    /**
     * 根据分类获取照片
     * @param tid
     * @return
     */
    @GetMapping("/tid/{id}")
    public @ResponseBody
    List<PhotoDetailVO> getPhotosBySymptomType(@PathVariable("id") String tid){
        return photoService.findPhotosBySymptomType(tid);
    }

}
