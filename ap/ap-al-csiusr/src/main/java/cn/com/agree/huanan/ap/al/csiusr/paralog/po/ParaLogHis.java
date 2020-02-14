package cn.com.agree.huanan.ap.al.csiusr.paralog.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.paralog.po.ParaLogHis.csis_paralog_his;
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
@Table(csis_paralog_his.class)
public class ParaLogHis implements Serializable {
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
	

    public static class csis_paralog_his {
        
    }
    
    public static Map<String, Object> getMap(ParaLogHis paraLogHis) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("optDutyNo", paraLogHis.getOptDutyNo());
    	map.put("chnlCode", paraLogHis.getChnlCode());
    	map.put("svrId", paraLogHis.getSvrId());
    	map.put("scnCode", paraLogHis.getScnCode());
    	map.put("platCode", paraLogHis.getPlatCode());
    	map.put("svrCode", paraLogHis.getSvrCode());
    	map.put("bfData0", paraLogHis.getBfData0());
    	map.put("bfData1", paraLogHis.getBfData1());
    	map.put("afData0", paraLogHis.getAfData0());
    	map.put("afData1", paraLogHis.getAfData1());
    	map.put("transStatus", paraLogHis.getTransStatus());
    	map.put("transMsg", paraLogHis.getTransMsg());
    	map.put("opType", paraLogHis.getOpType());
    	map.put("chgDutyNo", paraLogHis.getChgDutyNo());
    	map.put("serialNo", paraLogHis.getSerialNo());
    	map.put("optDate", paraLogHis.getOptDate());
    	map.put("optZoneNo", paraLogHis.getOptZoneNo());
    	map.put("optMbrNo", paraLogHis.getOptMbrNo());
    	map.put("optBrNo", paraLogHis.getOptBrNo());
    	map.put("optTellerNo", paraLogHis.getOptTellerNo());
    	map.put("optTime", paraLogHis.getOptTime());
    	map.put("authTellerno", paraLogHis.getAuthTellerNo());
    	map.put("sysId", paraLogHis.getSysId());
    	return map;
    }
    
}
