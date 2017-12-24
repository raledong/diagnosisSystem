package cn.nju.controller;

import cn.nju.common.enumeration.RequestStatus;
import cn.nju.service.ApplicationService;
import cn.nju.vo.ApplicationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class UserApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * 通过用户申请
     * @param id 申请id
     * @return
     */
    @PutMapping("approve/{id}")
    public RequestStatus approve(@PathVariable("id")String id){
        return applicationService.approve(id) ? RequestStatus.SUCCESS : RequestStatus.FAIL;
    }

    /**
     * 拒绝通过用户申请
     * @param id 申请id
     * @return
     */
    @PutMapping("disapprove/{id}")
    public RequestStatus disapprove(@PathVariable("id") String id){
        return applicationService.disapprove(id) ? RequestStatus.SUCCESS : RequestStatus.FAIL;
    }

    /**
     * 获得所有等待审核的申请
     * @return
     */
    @GetMapping
    public List<ApplicationVO> getAllPendingApplications(){
        return applicationService.findAllPendingApplications();
    }

}
