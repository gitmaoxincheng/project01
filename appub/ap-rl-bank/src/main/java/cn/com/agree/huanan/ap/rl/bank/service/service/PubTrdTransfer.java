package cn.com.agree.huanan.ap.rl.bank.service.service;


import cn.com.agree.afa.jcomponent.TradeInvoker;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.util.future.IFuture;
import cn.com.agree.huanan.ap.rl.bank.service.dao.PubTradeDao;
import cn.com.agree.huanan.ap.rl.bank.service.exception.TradeExcuteFailException;
import cn.com.agree.huanan.ap.rl.bank.service.po.AtomicServiceBean;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import org.springframework.stereotype.Component;

/**
 * @author acz 公共交易转发类
 */
@Component
public class PubTrdTransfer {
    /**
     * logger
     */
    public final Logger logger = Logger.getLogger(PubTrdTransfer.class);
    PubTradeDao ptd = SpringUtil.getBean(PubTradeDao.class);


/*

    */
/**
     * @param seb {@link SvcEventBean}
     * @return 插入记录数
     *//*

    public int insertSvcEvent(SvcEventBean seb) {
        return ptd.insertSvcEvent(seb);
    }

    */
/**
     * @param updateMap 更新的字段和值
     * @param expMap 更新条件字段和值
     * @return 更新记录数
     *//*

    public int updateSvcEvent(Map<String, Object> updateMap,Map<String, Object> expMap){
        int count=ptd.updateSvcEvent(updateMap, expMap);
        return count;
    }
*/


    /**
     * @param serviceID 原子服务ID
     * @return AtomicServiceBean
     */
    public AtomicServiceBean getAtomicService(String serviceID) {
        return ptd.getAtomicService(serviceID);
    }

    /**
     * @param serviceCode 原子服务代码
     * @param serviceSubCode 原子服务子代码
     * @return AtomicServiceBean
     */
    public AtomicServiceBean getAtomicService(String serviceCode, String serviceSubCode) {
        return ptd.getAtomicService(serviceCode, serviceSubCode);
    }

    /**
     * @param mc 服务码
     * @param tc 场景码
     * @param requestData 请求数据
     * @param timeoutInSecs 超时时间(秒)
     * @param hasResponse 是否有响应
     * @param srvIdentifier 服务标识
     * @param flattenWhenDict 。
     * @param remoteTrade 是否为远程交易
     * @return 交易响应数据 javaDict
     */
    //远程调用trade
    public JavaDict invokeTrade(String mc, String tc, Object requestData, int timeoutInSecs,
                                boolean hasResponse, String srvIdentifier, boolean flattenWhenDict, boolean remoteTrade) {
        JavaDict futures = new JavaDict();
        JavaDict results = new JavaDict();
        TCResult result = TradeInvoker.asyncInvokeRemoteTrade(mc, tc, requestData, timeoutInSecs,
                hasResponse, srvIdentifier, flattenWhenDict, remoteTrade);
        logger.info("交易调用状态：" + result.getStatus());
        if (result.getStatus() == 0) {
            logger.error("调用交易失败!");
            throw new TradeExcuteFailException(String.format("%s.%s", mc, tc));
        } else if (result.getStatus() == 1) {
            IFuture future = (IFuture) result.getOutputParams().get(0);
            futures.setItem("subFuture", future);
            TCResult allFutureResults = TradeInvoker.doAllFutures(futures, results);
            int errorCount = (Integer) allFutureResults.getOutputParams().get(0);
            logger.info("ErrorCount:" + errorCount);
            results.setItem("errorCount", errorCount);
            logger.info("聚合结果:" + results.get("subFuture"));
        }

        return results;
    }
}
