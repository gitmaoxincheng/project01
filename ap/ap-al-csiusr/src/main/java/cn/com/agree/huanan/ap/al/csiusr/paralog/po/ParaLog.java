package cn.com.agree.huanan.ap.al.csiusr.paralog.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.paralog.po.ParaLog.csis_paralog;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 岗位管理操作流水表Bean
 * @author maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_paralog.class)
public class ParaLog implements Serializable {
	private String optDutyNo;//编号
	private String chnlCode;//渠道代码
	private String svrId;//服务id
	private String scnCode;//场景码
	private String platCode;//模板码
	private String svrCode;//应用码
	private String bfData0;//变更前数据
	private String bfData1;//变更前数据1
	private String afData0;//变更后数据
	private String afData1;//变更后数据1
	private String transStatus;//交易结果
	private String transMsg;//结果信息
	private String opType;//操作类型
	private String chgDutyNo;//变更岗位编号
	private String serialNo;//操作流水号
	private String optDate;//操作日期
	private String optZoneNo;//操作地区号
	private String optMbrNo;//操作支行号
	private String optBrNo;//操作网点号
	private String optTellerNo;//操作柜员号
	private String optTime;//操作时间
	private String authTellerNo;//授权柜员
	private String sysId;//系统标识
	

    public static class csis_paralog {
        
    }
    
    public static Map<String, Object> getMap(ParaLog paraLog) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("optDutyNo", paraLog.getOptDutyNo());
    	map.put("chnlCode", paraLog.getChnlCode());
    	map.put("svrId", paraLog.getSvrId());
    	map.put("scnCode", paraLog.getScnCode());
    	map.put("platCode", paraLog.getPlatCode());
    	map.put("svrCode", paraLog.getSvrCode());
    	map.put("bfData0", paraLog.getBfData0());
    	map.put("bfData1", paraLog.getBfData1());
    	map.put("afData0", paraLog.getAfData0());
    	map.put("afData1", paraLog.getAfData1());
    	map.put("transStatus", paraLog.getTransStatus());
    	map.put("transMsg", paraLog.getTransMsg());
    	map.put("opType", paraLog.getOpType());
    	map.put("chgDutyNo", paraLog.getChgDutyNo());
    	map.put("serialNo", paraLog.getSerialNo());
    	map.put("optDate", paraLog.getOptDate());
    	map.put("optZoneNo", paraLog.getOptZoneNo());
    	map.put("optMbrNo", paraLog.getOptMbrNo());
    	map.put("optBrNo", paraLog.getOptBrNo());
    	map.put("optTellerNo", paraLog.getOptTellerNo());
    	map.put("optTime", paraLog.getOptTime());
    	map.put("authTellerno", paraLog.getAuthTellerNo());
    	map.put("sysId", paraLog.getSysId());
    	return map;
    }
    
}
