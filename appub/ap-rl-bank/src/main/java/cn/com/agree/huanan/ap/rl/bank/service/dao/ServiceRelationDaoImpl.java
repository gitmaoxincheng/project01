package cn.com.agree.huanan.ap.rl.bank.service.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.service.po.ServiceRelation;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 服务调用关系表数据操作层
 * @author HCP
 */
@Component
public class ServiceRelationDaoImpl implements ServiceRelationDao{
    @Autowired private OrmOperator ormOperator;
    @Autowired private DbOperator dbo;

 /*   *//**
     * 获取交易类型
     * 
     * @param serviceCode 服务
     * @param senceCode 场景码
     * @return 返回服务类型码 00 组合服务; 01 渠道协同 ; 02 普通服务/原子服务/公共服务
     *//*
    @ApCacheable
    public String getTradeType(String serviceCode, String senceCode) {
        Map<String, Object> map = dbo.getSelecter()
            .select("SVC_PROERTY")
            .from(ServiceRelation.TableName)
            .where(w -> w.eq("SVC_CODE", serviceCode))
            .where(w -> w.eq("SCN_CODE", senceCode))
            .fetchOne();

        if (map.isEmpty()) {
            logger.error("服务类型查询结果为空:[" + serviceCode + "." + senceCode + "]");
            return "";
        } else {
            return map.get("SVC_PROERTY").toString();
        }
    }*/
    
	@Override
	public ServiceRelation selectServiceRelation(String serviceId, String srcSvc, String srcScn) {
		OrmSelecter<ServiceRelation> selecter =  ormOperator.getOrmSelecter(ServiceRelation.class);
		ServiceRelation serviceRelation = selecter.where(w->{
			w.setId(serviceId);
			w.setSrcSvcCode(srcSvc);
			w.setSrcScnCode(srcScn);
		}).fetchOne();
		return serviceRelation;
	}

    /**
     * 提交
     */
    public void commit() {
        dbo.commit();
    }

    /**
     * 回滚
     */
    public void rollback() {
        dbo.rollback();
    }



}
