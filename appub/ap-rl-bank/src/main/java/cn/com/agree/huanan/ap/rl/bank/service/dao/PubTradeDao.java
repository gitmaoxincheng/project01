package cn.com.agree.huanan.ap.rl.bank.service.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.service.po.AtomicServiceBean;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author acz
 *
 */
@Component
public class PubTradeDao {
    /**
     * 
     */
    public final Logger logger = Logger.getLogger(PubTradeDao.class);
    @Autowired
    DbOperator dbo;
/*
    *//**
     * 获取交易类型
     *
     * @param serviceCode 服务
     * @param senceCode 场景码
     * @return 返回服务类型码 00 组合服务; 01 渠道协同 ; 02 普通服务/原子服务/公共服务
     *//*
    public String getTradeType(String serviceCode, String senceCode) {
        Map<String, Object> map = dbo.getSelecter()
            .select("SVC_PROERTY")
            .from(ServiceBean.TableName)
            .where(w -> w.eq("SVC_CODE", serviceCode))
            .where(w -> w.eq("SCN_CODE", senceCode))
            .fetchOne();

        if (map.isEmpty()) {
            logger.error("服务类型查询结果为空:[" + serviceCode + "." + senceCode + "]");
            return "";
        } else {
            return map.get("SVC_PROERTY").toString();
        }
    }

    *//**
     * 获取服务ID
     * 
     * @param serviceCode 服务
     * @param senceCode 场景码
     * @return 返回服务ID
     *//*
    public String getServiceID(String serviceCode, String senceCode) {
        Map<String, Object> map = dbo.getSelecter()
            .select("SVC_ID")
            .from(ServiceBean.TableName)
            .where(w -> w.eq("SVC_CODE", serviceCode))
            .where(w -> w.eq("SCN_CODE", senceCode))
            .fetchOne();
        if (map.isEmpty()) {
            logger.error("服务ID查询结果为空:[" + serviceCode + "." + senceCode + "]");
            return "";
        } else {
            return map.get("SVC_ID").toString();
        }
    }*/
/*

    *//**
     * 获取服务
     * 
     * @param serviceCode 服务码
     * @param senceCode 场景码
     * @return serviceBean
     *//*
    public ServiceBean getServiceByCode(String serviceCode, String senceCode) {
        Map<String, Object> service = dbo.getSelecter()
            .select("SVC_ID", "CC_ID", "SVC_CODE", "SCN_CODE", "RPC_SVCCODE", "RPC_SCNCODE",
                    "SVC_PROERTY", "STATUS", "REMARK")
            .from(ServiceBean.TableName)
            .where(w -> w.eq("SVC_CODE", serviceCode))
            .where(w -> w.eq("SCN_CODE", senceCode))
            .fetchOne();
        if (service.isEmpty()) {
            return null;
        }
        return ServiceBean.initInstance(service);
    }*/

    /**
     * 获取原子服务
     * 
     * @param ServiceID 原子服务ID
     * @return 原子服务列表
     */
    public AtomicServiceBean getAtomicService(String ServiceID) {
        Map<String, Object> map = dbo.getSelecter()
            .select("AT_SVCID", "AT_SVCCODE", "AT_SVCNAME", "AT_SCNCODE", "AT_SCNNAME", "SYS_CODE",
                    "SYS_NAME", "SYS_SVCCODE", "SYS_SVCNAME", "SYS_SCNCODE", "SYS_SCNNAME",
                    "IS_ECTIP", "STATUS", "REMARK")
            .from(AtomicServiceBean.TableName)
            .where(w -> w.eq("AT_SVCID", ServiceID))
            .fetchOne();
        if (map.isEmpty()) {
            return null;
        }
        return AtomicServiceBean.initInstance(map);
    }

    /**
     * @param ServiceCode 原子服务代码
     * @param ServiceSubCode 原子服务子代码
     * @return 原子服务列表
     */
    @ApCacheable
    public AtomicServiceBean getAtomicService(String ServiceCode, String ServiceSubCode) {
        Map<String, Object> map = dbo.getSelecter()
            .select("AT_SVCID", "AT_SVCCODE", "AT_SVCNAME", "AT_SCNCODE", "AT_SCNNAME", "SYS_CODE",
                    "SYS_NAME", "SYS_SVCCODE", "SYS_SVCNAME", "SYS_SCNCODE","EXT_CODE", "SYS_SCNNAME",
                    "IS_ECTIP", "STATUS", "REMARK")
            .from(AtomicServiceBean.TableName)
            .where(w -> w.eq("AT_SVCCODE", ServiceCode))
            .where(w -> w.eq("AT_SCNCODE", ServiceSubCode))
            .fetchOne();
        if (map.isEmpty()) {
            return null;
        }
        return AtomicServiceBean.initInstance(map);
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
