package cn.nju.controller;

import cn.nju.model.SymptomType;
import cn.nju.service.SymptomTypeService;
import cn.nju.vo.SymptomTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path="/symptom")
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

    @DeleteMapping(value = "/{id}")
    public @ResponseBody String deleteSymptom(@PathVariable("id") String sid){
        return symptomTypeService.deleteSymptomType(sid) ? "success" : "fail";
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody SymptomTypeVO findSymptomById(@PathVariable("id") String sid){
        return symptomTypeService.findSymptomById(sid);
    }


}
