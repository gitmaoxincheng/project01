/*
package cn.com.agree.huanan.ap.rl.bank.service.dao;

import cn.com.agree.huanan.ap.rl.bank.service.po.*;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/**
 * @author acz
 *
 *//*

@Component
public class ServiceRelationDao2 {
    */
/**
     *
     *//*

    public final Logger logger = Logger.getLogger(ServiceRelationDao2.class);
    @Autowired
    DbOperator dbo;

    */
/**
     * 获取交易类型
     *
     * @param serviceCode 服务
     * @param senceCode 场景码
     * @return 返回服务类型码 00 组合服务; 01 渠道协同 ; 02 普通服务/原子服务/公共服务
     *//*

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
    }

    */
/**
     * 获取服务ID
     *
     * @param serviceCode 服务
     * @param senceCode 场景码
     * @return 返回服务ID
     *//*

    public String getServiceID(String serviceCode, String senceCode) {
        Map<String, Object> map = dbo.getSelecter()
            .select("SVC_ID")
            .from(ServiceRelation.TableName)
            .where(w -> w.eq("SVC_CODE", serviceCode))
            .where(w -> w.eq("SCN_CODE", senceCode))
            .fetchOne();
        if (map.isEmpty()) {
            logger.error("服务ID查询结果为空:[" + serviceCode + "." + senceCode + "]");
            return "";
        } else {
            return map.get("SVC_ID").toString();
        }
    }

    */
/**
     * 获取服务组合规则
     *
     * @param serviceID 服务ID
     * @return 服务映射规则列表
     *//*

    public List<ServiceMapBean> getTradeRole(String serviceID) {
        List<Map<String, Object>> result = dbo.getSelecter()
            .select("SVC_ID", "ATSVC_ID", "STEP_INDEX", "REMARK")
            .from(ServiceMapBean.TableName)
            .where(w -> w.eq("SVC_ID", serviceID))
            .orderBy("to_number(STEP_INDEX) asc")
            .fetchAll();
        if (result.isEmpty()) {
            return null;
        }
        List<ServiceMapBean> list = new ArrayList<ServiceMapBean>();
        result.forEach(res -> {
            list.add(ServiceMapBean.initInstance(res));
        });
        return list;
    }

    */
/**
     * 获取服务
     *
     * @param serviceCode 服务码
     * @param senceCode 场景码
     * @return serviceBean
     *//*

    public ServiceRelation getServiceByCode(String serviceCode, String senceCode) {
        Map<String, Object> service = dbo.getSelecter()
            .select("SVC_ID", "CC_ID", "SVC_CODE", "SCN_CODE", "RPC_SVCCODE", "RPC_SCNCODE",
                    "SVC_PROERTY", "STATUS", "REMARK")
            .from(ServiceRelation.TableName)
            .where(w -> w.eq("SVC_CODE", serviceCode))
            .where(w -> w.eq("SCN_CODE", senceCode))
            .fetchOne();
        if (service.isEmpty()) {
            return null;
        }
        return ServiceRelation.initInstance(service);
    }

    */
/**
     * 获取原子服务
     *
     * @param ServiceID 原子服务ID
     * @return 原子服务列表
     *//*

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

    */
/**
     * @param ServiceCode 原子服务代码
     * @param ServiceSubCode 原子服务子代码
     * @return 原子服务列表
     *//*

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

    */
/**
     * 获取能力中心配置信息
     *
     * @param CompID 能力中心ID
     * @return CompBean
     *//*

    public CompBean getComp(String CompID) {
        Map<String, Object> map = dbo.getSelecter()
            .select("CC_ID", "SVC_PORT", "IS_SYNC", "OUT_ADAPTER", "IS_REMOTETRADE", "TIME_OUT",
                    "STATUS", "REMARK")
            .from(CompBean.TableName)
            .where(w -> w.eq("CC_ID", CompID))
            .fetchOne();
        if (map.isEmpty()) {
            return null;
        }
        return CompBean.initInstance(map);
    }

    */
/**
     * 获取服务权限
     *
     * @param serviceID 服务码
     * @param chlCode 渠道代码
     * @param chlSubCode 渠道细分代码
     * @return ServicePowerBean
     *//*

    public ServicePowerBean getServicePower(String serviceID, String chlCode, String chlSubCode) {
        Map<String, Object> map = dbo.getSelecter()
            .select("SVCAUTH_ID", "CHL_CODE", "CHL_SUBCODE", "SVC_ID", "STATUS", "REMARK")
            .from(ServicePowerBean.TableName)
            .where(w -> {
                w.eq("SVC_ID", serviceID);
                w.eq("CHL_CODE", chlCode);
                w.eq("CHL_SUBCODE", chlSubCode);
            })
            .fetchOne();
        if (map.isEmpty()) {
            return null;
        }
        return ServicePowerBean.initInstance(map);
    }

    */
/**
     * 根据渠道流水号查询服务事件表记录
     *
     * @param chl_serno 流水号
     * @return 该流水号记录数
     *//*

    public long getSvcEventBySerno(String chl_serno) {
        long count = dbo.getSelecter()
            .from(SvcEventBean.TableName)
            .where(w -> w.eq("CHL_SERNO", chl_serno))
            .count();
        return count;
    }

    */
/**
     * @param seqName 序列名
     * @param len 序列长度,长度不够 自动左补0
     * @return 序列号
     *//*

    public String getSequence(String seqName, int len) {
        Map<String, Object> map = dbo.getSelecter()
            .select("lpad(" + seqName + ".Nextval," + len + ",'0') as seq")
            .from("dual")
            .fetchOne();
        return map.get("seq").toString();
    }

    */
/**
     * 插入服务事件表
     *
     * @param seb {@link SvcEventBean}
     * @return 插入记录数
     *//*

    public int insertSvcEvent(SvcEventBean seb) {
        Map<String, Object> map = SvcEventBean.initData(seb);
        int count = dbo.getInserter().insertInto(SvcEventBean.TableName).values(map).execute();
        if (count > 0) {
            commit();
        }
        return count;
    }

    */
/**
     * 更新服务事件
     *
     * @param updateMap 更新的字段和值
     * @param expMap 条件字段和值
     * @return 更新记录数
     *//*

    public int updateSvcEvent(Map<String, Object> updateMap, Map<String, Object> expMap) {
        int count = dbo.getUpdater().update(SvcEventBean.TableName).set(updateMap).where(w -> {
            w.eqAll(expMap);
        }).execute();
        if (count > 0) {
            commit();
        }
        return count;
    }

    */
/**
     * 提交
     *//*

    public void commit() {
        dbo.commit();
    }

    */
/**
     * 回滚
     *//*

    public void rollback() {
        dbo.rollback();
    }
}
*/
