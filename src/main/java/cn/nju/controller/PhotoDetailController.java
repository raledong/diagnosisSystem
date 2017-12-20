package cn.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/photoDetail")
public class PhotoDetailController {

    @GetMapping("/{pid}")
    public String getPhotoDetail(@PathVariable("pid")String pid){
        return "Photodetail";
    }

}
