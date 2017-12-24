package cn.nju.service;

import cn.nju.vo.SymptomTypeDetailVO;
import cn.nju.vo.SymptomTypeVO;

import java.util.List;

public interface SymptomTypeService {

    /**
     * 获取所有的分类包括其子分类
     * @return
     */
    List<SymptomTypeVO> findAll();

    /**
     * 根据symptomTypeId获得该symptomType所有信息和其子类型
     * @param sid
     * @return
     */
    SymptomTypeVO findSymptomById(String sid);

    /**
     * 添加父类型
     * @param symptomTypeVO
     * @return
     */
    boolean addSymptomType(SymptomTypeVO symptomTypeVO);

    /**
     * 添加子类型
     * @param subSymptomTypeVO
     * @return
     */
    boolean addSubSymptomType(SymptomTypeVO subSymptomTypeVO);

    /**
     * 删除父类型分类
     * @param sid
     * @return
     */
    boolean deleteSymptomType(String sid);

    /**
     * 删除子类型分类
     * @param sid
     * @return
     */
    boolean deleteSubSymptomType(String sid);

    /**
     * 更新父类型
     * @param symptomTypeVO
     * @return
     */
    boolean updateSymptomType(SymptomTypeVO symptomTypeVO);

    /**
     * 更新子类型
     * @param subSymptomTypeVO
     * @return
     */
    boolean updateSubSymptomType(SymptomTypeVO subSymptomTypeVO);

}
