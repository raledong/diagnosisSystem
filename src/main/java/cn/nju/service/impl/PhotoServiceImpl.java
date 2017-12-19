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
        PhotoDetailVO photoDetailVO = null;
        if (photo != null){
            photoDetailVO = new PhotoDetailVO(photo);

            //更新照片的标签细节
            String tid = photo.getTid();
            if (tid!=null && !tid.isEmpty()){
                SymptomType subSymptomType = symptomTypeRepository.findOne(tid);
                SymptomType symptomType = symptomTypeRepository.findOne(subSymptomType.getUperId());
                photoDetailVO.setRootClass(symptomType);
                photoDetailVO.setChildClass(subSymptomType);
            }
        }
        return photoDetailVO;
    }
}
