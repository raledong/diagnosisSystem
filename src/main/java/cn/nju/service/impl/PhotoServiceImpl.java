package cn.nju.service.impl;

import cn.nju.dao.PhotoRepository;
import cn.nju.dao.SymptomTypeRepository;
import cn.nju.model.Photo;
import cn.nju.model.SymptomType;
import cn.nju.service.PhotoService;
import cn.nju.vo.PhotoDetailVO;
import cn.nju.vo.SymptomTypeDetailVO;
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

    @Override
    public boolean changeSymptom(String pid, String tid) {
        Photo photo = photoRepository.findOne(pid);
        if (photo == null) return false;
        if (symptomTypeRepository.findOne(tid)==null) return false;
        photo.setTid(tid);
        photoRepository.save(photo);
        return true;
    }

    private PhotoDetailVO wrapPhotoToPhotoDetailVO(Photo photo){
        if (photo != null){
            PhotoDetailVO photoDetailVO = new PhotoDetailVO(photo);
            //更新照片的标签细节
            String[] tids = photo.getTids();
            List<SymptomTypeDetailVO> symptomTypeDetailVOS = wrapSymptomToSymptomTypeDetailVO(tids);
            photoDetailVO.setSymptomTypeDetails(symptomTypeDetailVOS);
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

    private List<SymptomTypeDetailVO> wrapSymptomToSymptomTypeDetailVO(String[] tids){
        List<SymptomTypeDetailVO> symptomTypeDetailVOS = new ArrayList<>();
        if (tids != null && tids.length > 0){
            for (String tid : tids){
                SymptomType symptomType = symptomTypeRepository.findOne(tid);
                SymptomType pSymptomType = symptomTypeRepository.findOne(symptomType.getUperId());
                SymptomType ppSymptomType = symptomTypeRepository.findOne(pSymptomType.getUperId());
                SymptomTypeDetailVO symptomTypeDetailVO = new SymptomTypeDetailVO(symptomType.getTid(), symptomType.getTname(), pSymptomType.getTname(), ppSymptomType.getTname());
                symptomTypeDetailVOS.add(symptomTypeDetailVO);
            }
        }
        return symptomTypeDetailVOS;
    }
}
