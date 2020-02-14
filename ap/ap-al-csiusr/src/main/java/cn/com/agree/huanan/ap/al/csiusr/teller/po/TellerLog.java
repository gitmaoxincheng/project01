package cn.com.agree.huanan.ap.al.csiusr.teller.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog.csis_tellerlog;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员操作流水表Bean
 * @author maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_tellerlog.class)
public class TellerLog implements Serializable {
	private String transStatus;//交易状态:F-失败,S-成功,U-未知,I-处理中,W-待处理,C-已撤销 
	private String errorCode;//错误码
	private String errorMsg;//错误信息
	private String chgTellernoBrno;//变更柜员所属机构
	private String chgTellernoName;//变更柜员名称
	private String adjDate;//调出日期
	private String serialNo;//操作流水号
	private String optDate;//操作日期
	private String optTime;//操作时间
	private String optZoneNo;//操作地区号
	private String optMbrNo;//操作支行号
	private String optBrNo;//操作网点号
	private String optTellerNo;//操作柜员号
	private String optDutyNo;//操作岗位编号
	private String authTellerNo;//授权柜员
	private String sysId;//应用系统标识
	private String chnlCode;//渠道代码
	private String svrId;//服务ID
	private String scnCode;//场景码
	private String platCode;//模板码
	private String svrCode;//交易结果
	private String bfData0;//变更前数据
	private String bfData1;//变更前数据
	private String afData0;//变更后数据
	private String afData1;//变更后数据
	private String tellerBrNo;//调动机构
	private String opType;//操作类型
	private String chgTellerNo;//变更柜员
	private String tradeName;//交易名称
	private String srcDate;//请求方日期
	private String reqNo;//请求方流水


    public static class csis_tellerlog {
        
    }
    
    public static Map<String, Object> getMap(TellerLog tellerLog) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("transStatus", tellerLog.getTransStatus());
    	map.put("errorCode", tellerLog.getErrorCode());
    	map.put("errorMsg", tellerLog.getErrorMsg());
    	map.put("chgTellernoBrno", tellerLog.getChgTellernoBrno());
    	map.put("chgTellernoName", tellerLog.getChgTellernoName());
    	map.put("adjDate", tellerLog.getAdjDate());
    	map.put("serialNo", tellerLog.getSerialNo());
    	map.put("optDate", tellerLog.getOptDate());
    	map.put("optTime", tellerLog.getOptTime());
    	map.put("optZoneNo", tellerLog.getOptZoneNo());
    	map.put("optMbrNo", tellerLog.getOptMbrNo());
    	map.put("optBrNo", tellerLog.getOptBrNo());
    	map.put("optTellerNo", tellerLog.getOptTellerNo());
    	map.put("optDutyNo", tellerLog.getOptDutyNo());
    	map.put("authTellerNo", tellerLog.getAuthTellerNo());
    	map.put("sysId", tellerLog.getSysId());
    	map.put("chnlCode", tellerLog.getChnlCode());
    	map.put("svrId", tellerLog.getSvrId());
    	map.put("scnCode", tellerLog.getScnCode());
    	map.put("platCode", tellerLog.getPlatCode());
    	map.put("svrCode", tellerLog.getSvrCode());
    	map.put("bfData0", tellerLog.getBfData0());
    	map.put("bfData1", tellerLog.getBfData1());
    	map.put("afData0", tellerLog.getAfData0());
    	map.put("afData1", tellerLog.getAfData1());
    	map.put("tellerBrNo", tellerLog.getTellerBrNo());
    	map.put("opType", tellerLog.getOpType());
    	map.put("chgTellerNo", tellerLog.getChgTellerNo());	
    	map.put("tradeName", tellerLog.getTradeName());	
    	map.put("srcDate", tellerLog.getSrcDate());
    	map.put("reqNo", tellerLog.getReqNo());
    	return map;
    }
    
}
