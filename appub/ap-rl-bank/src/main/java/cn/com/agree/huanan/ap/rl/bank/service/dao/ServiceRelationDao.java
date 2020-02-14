package cn.com.agree.huanan.ap.rl.bank.service.dao;

import cn.com.agree.huanan.ap.rl.bank.service.po.ServiceRelation;

/**
 * 服务调用关系表数据操作层
 * @author HCP
 */
public interface ServiceRelationDao {


    /**
     * 查询服务调度关系
     * @param serviceId 服务标识
     * @param srcSvc 消费方服务码
     * @param srcScn 消费方场景码
     * @return
     */
    public ServiceRelation selectServiceRelation(String serviceId, String srcSvc,String srcScn);

}
