package cn.nju.service;


import cn.nju.vo.ApplicationVO;

import java.util.List;

public interface ApplicationService {
    /**
     * 通过审核
     * @param appId 审核的ID
     * @return
     */
    boolean approve(String appId);

    /**
     * 没有通过审核
     * @param appId
     * @return
     */
    boolean disapprove(String appId);

    /**
     * 获得所有等待审核的申请
     * @return
     */
    List<ApplicationVO> findAllPendingApplications();
}
