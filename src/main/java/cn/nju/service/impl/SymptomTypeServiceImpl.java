package cn.nju.service.impl;

import cn.nju.dao.SymptomTypeRepository;
import cn.nju.model.SymptomType;
import cn.nju.service.SymptomTypeService;
import cn.nju.vo.SubSymptomTypeVO;
import cn.nju.vo.SymptomTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("SymptomTypeService")
@Transactional
public class SymptomTypeServiceImpl implements SymptomTypeService {
    @Autowired
    private SymptomTypeRepository symptomTypeRepository;


    @Override
    public List<SymptomTypeVO> findAll() {
        //找到所有父类型
        List<SymptomType> symptomTypes = symptomTypeRepository.findByUperIdIsNull();
        List<SymptomTypeVO> symptomTypeVOS = new ArrayList<>();

        for (SymptomType symptomType : symptomTypes){
            //获得父节点的id
            String symptomTypeId = symptomType.getTid();
            List<SymptomType> subSymptoms = symptomTypeRepository.findByUperId(symptomTypeId);

            //封装成VO
            SymptomTypeVO symptomTypeVO = new SymptomTypeVO(symptomType);
            symptomTypeVO.addSubSymptomTypes(subSymptoms);
            symptomTypeVOS.add(symptomTypeVO);
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
        return false;
    }

    @Override
    public boolean addSubSymptomType(SubSymptomTypeVO subSymptomTypeVO) {
        return false;
    }

    @Override
    public boolean deleteSymptomType(String sid) {
        return false;
    }

    @Override
    public boolean deleteSubSymptomType(String sid) {
        return false;
    }

    @Override
    public boolean updateSymptomType(SymptomTypeVO symptomTypeVO) {
        return false;
    }

    @Override
    public boolean updateSubSymptomType(SubSymptomTypeVO subSymptomTypeVO) {
        return false;
    }
}
