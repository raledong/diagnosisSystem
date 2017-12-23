package cn.nju.service;


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

}
