package cn.nju.controller;

import cn.nju.common.enumeration.RequestStatus;
import cn.nju.model.SymptomType;
import cn.nju.service.SymptomTypeService;
import cn.nju.vo.SymptomTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path="/api/symptom")
public class SymptomController {
    @Autowired
    private SymptomTypeService symptomTypeService;

    /**
     * 获取所有标签
     * @return
     */
    @GetMapping()
    public @ResponseBody List<SymptomTypeVO> findAllSymptoms(){
        return symptomTypeService.findAll();
    }

    /**
     * 删除父分类
     * @param sid
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    RequestStatus deleteSymptom(@PathVariable("id") String sid){
        return symptomTypeService.deleteSymptomType(sid) ? RequestStatus.SUCCESS : RequestStatus.FAIL;
    }

    /**
     * 删除子分类
     * @param sid
     * @return
     */
    @DeleteMapping(value = "/sub/{id}")
    public @ResponseBody
    RequestStatus deleteSubSymptom(@PathVariable("id")String sid){
        return symptomTypeService.deleteSubSymptomType(sid) ? RequestStatus.SUCCESS : RequestStatus.FAIL;
    }

    /**
     * 获得标记为sid的父标签
     * @param sid
     * @return
     */
    @GetMapping(value = "/{id}")
    public @ResponseBody SymptomTypeVO findSymptomById(@PathVariable("id") String sid){
        return symptomTypeService.findSymptomById(sid);
    }


}
