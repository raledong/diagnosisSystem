package cn.nju.controller;

import cn.nju.common.enumeration.RequestStatus;
import cn.nju.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
