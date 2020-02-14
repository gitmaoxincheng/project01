package cn.com.agree.huanan.ap.al.csitrd.fina.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradriskmain.tradeinfo_risk_tmain;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 风险评估
 * @author zhonggp
 *
 */
@Setter
@Getter
@ToString
@Table(tradeinfo_risk_tmain.class)
public class Tradriskmain implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1111819510030068310L;
	
	
	//公共部分
			private String tradeDate;	//平台交易日期
			private String serialNo;	//平台交易流水
			private String tradeTime;	//平台交易时间
			private String subTransFlag;	//子交易事务标识,0不适用1强事务2弱事务
			private String bussceNo;	//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
			private String servecode_out;	//外部服务码
			private String scenecode_out;	//外部场景码
			private String serveCode;	//服务码
			private String sceneCode;	//场景码
			private String reqSysId;	//请求方系统标识
			private String reqCalCod;	//请求方渠道编码
			private String reqDate;	//请求方日期
			private String reqTime;	//请求方时间
			private String reqSerialNo;	//请求方流水号
			private String scrSysId;	//源请求方系统标识
			private String scrCalCod;	//源请求方渠道编码
			private String golSeqNo;	//全局流水号
			private String tellerNo;	//柜员号
			private String tellerTp;	//柜员类型
			private String myBank;	//法人号
			private String zoneNo;	//分行号
			private String mbrNo;	//支行号
			private String brNo;	//网点号
			private String devNo;	//设备编号
			private String authTellerNo;	//授权柜员
			private String respSts;		//交易状态
			private String errorCode;	//消息码
			private String errorMsg;	//消息码描述
			private String backServeCode;	//后台服务码
			private String backSceneCode;	//后台场景码
			private String backSysDate;	//后台交易日期
			private String backSysNo;	//后台交易流水
			private String backSysSts;	//后台交易状态
			private String backSysErrorCode;	//后台消息码
			private String backSysErrorMsg;	//后台消息码描述
			private String updDate;	//最后更新日期
			private String updTime;	//最后更新时间
	
	
	private String accType;    //客户标识类型 
	private String account;    //客户标志 
	private String idType;    //证件类型
	private String idCode;    //证件号码
	private String clientNo;    //客户号
	private String openBranch;    //银行账号开户机构
	private String bankAcc;    //银行账号
	private String clientType;    //客户类型
	private String clientGroup;    //客户组别
	private String paperType;    //问卷类型0  风险等级卷子                   1 风险适合度卷子, 必输
	private String paperNo;    //试卷编号
	private String riskLevel;    //风险等级
	private String riskMonths;    //风险有效期月数
	private String channelAbleFlag;    //高风险产品柜台以外渠道允许购买标志0-不允许 1-允许不填认为不允许，可空"
	private String prdManager;    //产品管理人
	private String lastScore;    //风险评估总分
	
	

	
	public static class tradeinfo_risk_tmain{
		
	}
	
	public static Tradriskmain instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(Tradriskmain tradriskmain){
		 Map<String, Object> map = new HashMap<>();
		 map.put("scenecode_out",tradriskmain.getScenecode_out());
		 map.put("servecode",tradriskmain.getServeCode());
		 map.put("sceneCode",tradriskmain.getSceneCode());
		 map.put("reqSysId",tradriskmain.getReqSysId());
		 map.put("reqCalCod",tradriskmain.getReqCalCod());
		 map.put("reqDate",tradriskmain.getReqDate());
		 map.put("reqTime",tradriskmain.getReqTime());
		 map.put("reqSerialNo",tradriskmain.getReqSerialNo());
		 map.put("scrSysId",tradriskmain.getScrSysId());
		 map.put("scrCalCod",tradriskmain.getScrCalCod());
		 map.put("golSeqNo",tradriskmain.getGolSeqNo());
		 map.put("tellerNo",tradriskmain.getTellerNo());
		 map.put("tellerTp",tradriskmain.getTellerTp());
		 map.put("myBank",tradriskmain.getMyBank());
		 map.put("zoneNo",tradriskmain.getZoneNo());
		 map.put("mbrNo",tradriskmain.getMbrNo());
		 map.put("brNo",tradriskmain.getBrNo());
		 map.put("devNo",tradriskmain.getDevNo());
		 map.put("authTellerNo",tradriskmain.getAuthTellerNo());
		 map.put("respSts",tradriskmain.getRespSts());
		 map.put("errorCode",tradriskmain.getErrorCode());
		 map.put("errorMsg",tradriskmain.getErrorMsg());
		 map.put("backServeCode",tradriskmain.getBackServeCode());
		 map.put("backSceneCode",tradriskmain.getBackSceneCode());
		 map.put("backSysDate",tradriskmain.getBackSysDate());
		 map.put("backSysNo",tradriskmain.getBackSysNo());
		 map.put("backSysSts",tradriskmain.getBackSysSts());
		 map.put("backSysErrorCode",tradriskmain.getBackSysErrorCode());
		 map.put("backSysErrorMsg",tradriskmain.getBackSysErrorMsg());
		 map.put("updDate",tradriskmain.getUpdDate());
		 map.put("updTime",tradriskmain.getUpdTime());
		 map.put("accType",tradriskmain.getAccType());
		 map.put("account",tradriskmain.getAccount());
		 map.put("idType",tradriskmain.getIdType());
		 map.put("idCode",tradriskmain.getIdCode());
		 map.put("clientNo",tradriskmain.getClientNo());
		 map.put("openBranch",tradriskmain.getOpenBranch());
		 map.put("bankAcc",tradriskmain.getBankAcc());
		 map.put("clientType",tradriskmain.getClientType());
		 map.put("clientGroup",tradriskmain.getClientGroup());
		 map.put("paperType",tradriskmain.getPaperType());
		 map.put("paperNo",tradriskmain.getPaperNo());
		 map.put("riskLevel",tradriskmain.getRiskLevel());
		 map.put("riskMonths",tradriskmain.getRiskMonths());
		 map.put("channelAbleFlag",tradriskmain.getChannelAbleFlag());
		 map.put("prdManager",tradriskmain.getPrdManager());
		 map.put("lastScore",tradriskmain.getLastScore());
		 map.put("tradeDate",tradriskmain.getTradeDate());
		 map.put("serialNo",tradriskmain.getSerialNo());
		 map.put("tradeTime",tradriskmain.getTradeTime());
		 map.put("subtransFlag",tradriskmain.getSubTransFlag());
		 map.put("bussceNo",tradriskmain.getBussceNo());
		 map.put("servecode_out",tradriskmain.getServecode_out());



		return map;

	}

}