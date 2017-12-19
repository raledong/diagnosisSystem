package cn.nju.service.impl;

import cn.nju.dao.PhotoRepository;
import cn.nju.dao.SymptomTypeRepository;
import cn.nju.model.Photo;
import cn.nju.model.SymptomType;
import cn.nju.service.PhotoService;
import cn.nju.vo.PhotoDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private SymptomTypeRepository symptomTypeRepository;

    @Override
    public PhotoDetailVO findPhotoDetailById(String pid) {
        Photo photo = photoRepository.findOne(pid);
        PhotoDetailVO photoDetailVO = wrapPhotoToPhotoDetailVO(photo);
        return photoDetailVO;
    }

    @Override
    public List<PhotoDetailVO> findAllPhotos(String did) {
        List<Photo> photos = photoRepository.findAllByDidOrderByTime(did);
        return wrapPhotoToPhotoDetailVO(photos);
    }

    @Override
    public List<PhotoDetailVO> findRepliedPhotos(String did) {
        List<Photo> photos = photoRepository.findAllByDidAndTidIsNotNull(did);
        return wrapPhotoToPhotoDetailVO(photos);
    }

    @Override
    public List<PhotoDetailVO> findUnrepliedPhotos(String did) {
        List<Photo> photos = photoRepository.findAllByDidAndTidIsNull(did);
        System.out.println(photos.size());
        return wrapPhotoToPhotoDetailVO(photos);
    }

    private PhotoDetailVO wrapPhotoToPhotoDetailVO(Photo photo){
        if (photo != null){
            PhotoDetailVO photoDetailVO = new PhotoDetailVO(photo);

            //更新照片的标签细节
            String tid = photo.getTid();
            if (tid!=null && !tid.isEmpty()){
                SymptomType subSymptomType = symptomTypeRepository.findOne(tid);
                SymptomType symptomType = symptomTypeRepository.findOne(subSymptomType.getUperId());
                photoDetailVO.setRootClass(symptomType);
                photoDetailVO.setChildClass(subSymptomType);
            }
            return photoDetailVO;
        }
        return null;
    }

    private List<PhotoDetailVO> wrapPhotoToPhotoDetailVO(List<Photo> photos){
        List<PhotoDetailVO> photoDetailVOS = new ArrayList<>();
        if (photos!=null && !photos.isEmpty()){
            for (Photo photo : photos){
                PhotoDetailVO photoDetailVO = wrapPhotoToPhotoDetailVO(photo);
                if (photoDetailVO != null){
                    photoDetailVOS.add(photoDetailVO);
                }
            }
        }
        return photoDetailVOS;
    }
}
