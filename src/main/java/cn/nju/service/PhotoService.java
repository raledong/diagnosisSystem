package cn.nju.service;

import cn.nju.model.Photo;
import cn.nju.vo.PhotoDetailVO;

import java.util.List;

public interface PhotoService {

    PhotoDetailVO findPhotoDetailById(String pid);
}
