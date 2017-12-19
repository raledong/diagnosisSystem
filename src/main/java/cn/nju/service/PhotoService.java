package cn.nju.service;

import cn.nju.model.Photo;
import cn.nju.vo.PhotoDetailVO;

import java.util.List;

public interface PhotoService {

    /**
     * 获取编号为pid的照片的详情
     * @param pid
     * @return
     */
    PhotoDetailVO findPhotoDetailById(String pid);

    /**
     * 获得提交给编号为did的医生的所有照片
     * @param did
     * @return
     */
    List<PhotoDetailVO> findAllPhotos(String did);

    /**
     * 获得提交给编号为did的医生的所有已经回复的照片
     * @param did
     * @return
     */
    List<PhotoDetailVO> findRepliedPhotos(String did);

    /**
     * 获得提交给编号为did的医生的所有尚未回复的照片
     * @param did
     * @return
     */
    List<PhotoDetailVO> findUnrepliedPhotos(String did);

    /**
     * 更改照片的舌苔类别分类
     * @param pid 照片id
     * @param tid 分类id
     * @return
     */
    boolean changeSymptom(String pid, String tid);
}
