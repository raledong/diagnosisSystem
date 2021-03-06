package cn.nju.service.impl;

import cn.nju.common.UUIDGenerator;
import cn.nju.dao.PhotoRepository;
import cn.nju.dao.SymptomTypeRepository;
import cn.nju.model.SymptomType;
import cn.nju.service.SymptomTypeService;
import cn.nju.vo.SymptomTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("SymptomTypeService")
@Transactional
public class SymptomTypeServiceImpl implements SymptomTypeService {
    @Autowired
    private SymptomTypeRepository symptomTypeRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<SymptomTypeVO> findAll() {
        //找到所有父类型
        List<SymptomType> symptomTypes = symptomTypeRepository.findByUperIdIsNull();
        List<SymptomTypeVO> symptomTypeVOS = new ArrayList<>();

        if (symptomTypes != null && !symptomTypes.isEmpty()){
            for (SymptomType symptomType : symptomTypes){
                //获得父节点的id
                String symptomTypeId = symptomType.getTid();
                //获得一级节点下所有的二级节点
                List<SymptomType> subSymptoms = symptomTypeRepository.findByUperId(symptomTypeId);
                //将父节点封装成VO
                SymptomTypeVO symptomTypeVO = new SymptomTypeVO(symptomType);

                if (subSymptoms!=null && !subSymptoms.isEmpty()){
                    for (SymptomType subSymptom : subSymptoms){
                        SymptomTypeVO subSymptomVO = new SymptomTypeVO(subSymptom);
                        List<SymptomType> subSubSymptoms = symptomTypeRepository.findByUperId(subSymptom.getTid());
                        subSymptomVO.addSubSymptomTypes(subSubSymptoms);

                        symptomTypeVO.addSubSymptomType(subSymptomVO);
                    }
                }
                symptomTypeVOS.add(symptomTypeVO);
            }
        }


        return symptomTypeVOS;
    }

    @Override
    public SymptomTypeVO findSymptomById(String sid) {
        SymptomType symptomType = symptomTypeRepository.findOne(sid);
        return symptomType==null ? null : new SymptomTypeVO(symptomType);
    }

    @Override
    public boolean addSymptomType(SymptomTypeVO symptomTypeVO) {
        if (symptomTypeVO != null){
            SymptomType symptomType = new SymptomType(symptomTypeVO);
            symptomType.setTid(UUIDGenerator.getShortUUID());
            symptomType.setUperId(null);
            symptomTypeRepository.save(symptomType);
            return true;
        }
        return false;
    }

    @Override
    public boolean addSubSymptomType(SymptomTypeVO subSymptomTypeVO) {
        if (subSymptomTypeVO != null && symptomTypeRepository.findOne(subSymptomTypeVO.getUperId())!=null){
            subSymptomTypeVO.setTid(UUIDGenerator.getShortUUID());
            SymptomType symptomType = new SymptomType(subSymptomTypeVO);
            symptomTypeRepository.save(symptomType);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSymptomType(String sid) {
        List<SymptomType> subSymptomTypes = symptomTypeRepository.findByUperId(sid);

        //删除所有的子分类
        if (subSymptomTypes!=null && !subSymptomTypes.isEmpty()){
            for (SymptomType subSymptomType : subSymptomTypes){
                deleteSubSymptomType(subSymptomType);
            }
        }
        symptomTypeRepository.delete(sid);
        return true;
    }

    @Override
    public boolean deleteSubSymptomType(String sid) {
        symptomTypeRepository.delete(sid);
        return true;
    }

    private boolean deleteSubSymptomType(SymptomType subSymptomType){
        String tid = subSymptomType.getTid();
        int count = photoRepository.countAllByTid(tid);
        if (count != 0) return false;
        return deleteSubSymptomType(subSymptomType.getTid());
    }
    @Override
    public boolean updateSymptomType(SymptomTypeVO symptomTypeVO) {
        if (symptomTypeVO!=null){
            SymptomType symptomType = new SymptomType(symptomTypeVO);
            symptomTypeRepository.save(symptomType);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSubSymptomType(SymptomTypeVO subSymptomTypeVO) {
        if (subSymptomTypeVO!=null){
            SymptomType symptomType = new SymptomType(subSymptomTypeVO);
            symptomTypeRepository.save(symptomType);
            return true;
        }
        return false;
    }

}
