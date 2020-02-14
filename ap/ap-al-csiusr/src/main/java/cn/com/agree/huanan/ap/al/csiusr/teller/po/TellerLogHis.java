package cn.com.agree.huanan.ap.al.csiusr.teller.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLogHis.csis_tellerlog_his;
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
@Table(csis_tellerlog_his.class)
public class TellerLogHis implements Serializable {
	private String transStatus;//交易结果
	private String transMsg;//结果信息
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


    public static class csis_tellerlog_his {
        
    }
    
    public static Map<String, Object> getMap(TellerLogHis tellerLogHis) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("transStatus", tellerLogHis.getTransStatus());
    	map.put("transMsg", tellerLogHis.getTransMsg());
    	map.put("chgTellernoBrno", tellerLogHis.getChgTellernoBrno());
    	map.put("chgTellernoName", tellerLogHis.getChgTellernoName());
    	map.put("adjDate", tellerLogHis.getAdjDate());
    	map.put("serialNo", tellerLogHis.getSerialNo());
    	map.put("optDate", tellerLogHis.getOptDate());
    	map.put("optTime", tellerLogHis.getOptTime());
    	map.put("optZoneNo", tellerLogHis.getOptZoneNo());
    	map.put("optMbrNo", tellerLogHis.getOptMbrNo());
    	map.put("optBrNo", tellerLogHis.getOptBrNo());
    	map.put("optTellerNo", tellerLogHis.getOptTellerNo());
    	map.put("optDutyNo", tellerLogHis.getOptDutyNo());
    	map.put("authTellerNo", tellerLogHis.getAuthTellerNo());
    	map.put("sysId", tellerLogHis.getSysId());
    	map.put("chnlCode", tellerLogHis.getChnlCode());
    	map.put("svrId", tellerLogHis.getSvrId());
    	map.put("scnCode", tellerLogHis.getScnCode());
    	map.put("platCode", tellerLogHis.getPlatCode());
    	map.put("svrCode", tellerLogHis.getSvrCode());
    	map.put("bfData0", tellerLogHis.getBfData0());
    	map.put("bfData1", tellerLogHis.getBfData1());
    	map.put("afData0", tellerLogHis.getAfData0());
    	map.put("afData1", tellerLogHis.getAfData1());
    	map.put("tellerBrNo", tellerLogHis.getTellerBrNo());
    	map.put("opType", tellerLogHis.getOpType());
    	map.put("chgTellerNo", tellerLogHis.getChgTellerNo());	
    	return map;
    }
    
}
