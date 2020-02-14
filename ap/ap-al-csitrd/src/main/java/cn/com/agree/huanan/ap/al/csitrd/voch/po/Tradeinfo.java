package cn.com.agree.huanan.ap.al.csitrd.voch.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
//import cn.com.agree.huanan.ap.al.csitrd.voch.po.Tradeinfo.TRADEINFO_MATTER_MAIN;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 事故事项登记簿bean
 * @author HZP
 */
@Setter
@Getter
@ToString
// @Table(TRADEINFO_MATTER_MAIN.class)
public class Tradeinfo implements Serializable{

	/*private static final long serialVersionUID = 5807822203359540869L;
	private String tradeDate; //平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subtransFlag;//子交易事务标识
	private String bussceNo;//业务场景流水号
	private String serveCode_out;//外部服务码
	private String sceneCode_out;//外部场景码
	private String serveCode;//服务码
	private String sceneCode;//场景码
	private String reqSysId;//请求方系统标识
	private String reqCalCod;//请求方渠道编码
	private String reqDate;//请求方日期
	private String reqTime;//请求方时间
	private String reqSerialNo;//请求方流水号
	private String scrSysId;//源请求方系统标识
	private String scrCalCod;//源请求方渠道编码
	private String golSeqNo;//全局流水号
	private String tellerNo;//柜员号
	private String tellerTp;//柜员类型
	private String myBank;//法人号
	private String zoneNo;//分行号
	private String mbrNo;//支行号
	private String brNo;//网点号
	private String devNo;//设备编号
	private String authTellerNo;//授权柜员
	
	private String respSts;           //交易状态
	private String errorCode;         //消息码
	private String errorMsg;          //消息码描述
	private String backServeCode;     //后台服务码
	private String backSceneCode;     //后台场景码
	private String backSysDate;       //后台交易日期
	private String backSysNo;         //后台交易流水
	private String backSysSts;        //后台交易状态
	private String backSysErrorCode;  //后台消息码
	private String backSysErrorMsg;   //后台消息码描述
	private String updTime;           //最后更新时间
	private String updDate;           //最后更新日期
	
	private String cust_Num;//客户号
	private String cust_Nm;//客户名称
	private String docs_Catg;//证件种类
	private String docs_Num;//证件号码
	private String cust_Acct_Num;//客户账号卡号
	private String sub_Acct_Serl_Num;//子账户序号
	private String acctNo;//金融账户卡号
	private String operateChannel;//操作渠道
	private String pref_Exmpt_Svc_Fee_Oprn_Flg;//优免操作标志
	private String pref_Exmpt_Svc_Fee_Tp;//优免类型
	private String pref_Exmpt_Svc_Fee_Flg;//优免标志
	private String no_Anul_Fee_Flg;//免年费标志
	private String cncl_Card_Reason;//销卡原因
	private String cncl_Card_Way;//销卡方式
	private String loss_Num;//挂失编号
	private String cptl_Drcn;//资金去向
	private String cntpr_Acct_Num;//对方账号
	private String cntpr_Sub_Acct_Serl_Num;//对方子账户序号
	private String cncl_Card_Mode;//销卡模式
	
	public static class TRADEINFO_MATTER_MAIN{
		
	}
	
	public static Map<String, Object> getMap(Tradeinfo tradeinfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("tradedate", tradeinfo.getTradeDate());
		 map.put("serialno", tradeinfo.getSerialNo());
		 map.put("tradetime", tradeinfo.getTradeTime());
		 map.put("subtransflag", tradeinfo.getSubtransFlag());
		 map.put("bussceno", tradeinfo.getBussceNo());
		 map.put("servecode_out", tradeinfo.getServeCode_out());
		 map.put("scenecode_out", tradeinfo.getSceneCode_out());
		 map.put("servecode", tradeinfo.getServeCode());
		 map.put("scenecode", tradeinfo.getSceneCode());
		 map.put("reqsysid", tradeinfo.getReqSysId());
		 map.put("reqcalcod", tradeinfo.getReqCalCod());
		 map.put("reqdate", tradeinfo.getReqDate());
		 map.put("reqtime", tradeinfo.getReqTime());
		 map.put("reqserialno", tradeinfo.getReqSerialNo());
		 map.put("scrsysid", tradeinfo.getScrSysId());
		 map.put("scrcalcod", tradeinfo.getScrCalCod());
		 map.put("golseqno", tradeinfo.getGolSeqNo());
		 map.put("tellerno", tradeinfo.getTellerNo());
		 map.put("tellertp", tradeinfo.getTellerTp());
		 map.put("mybank", tradeinfo.getMyBank());
		 map.put("zoneno", tradeinfo.getZoneNo());
		 map.put("mbrno", tradeinfo.getMbrNo());
		 map.put("brno", tradeinfo.getBrNo());
		 map.put("devno", tradeinfo.getDevNo());
		 map.put("authtellerno", tradeinfo.getAuthTellerNo());
		 map.put("respsts", tradeinfo.getRespSts());
		 map.put("errorcode", tradeinfo.getErrorCode());
		 map.put("errormsg", tradeinfo.getErrorMsg());
		 map.put("backservecode", tradeinfo.getBackServeCode());
		 map.put("backscenecode", tradeinfo.getBackSceneCode());
		 map.put("backsysdate", tradeinfo.getBackSysDate());
		 map.put("backsysno", tradeinfo.getBackSysNo());
		 map.put("backsyssts", tradeinfo.getBackSysSts());
		 map.put("backsyserrorcode", tradeinfo.getBackSysErrorCode());
		 map.put("backsyserrormsg", tradeinfo.getBackSysErrorMsg());
		 map.put("upddate", tradeinfo.getUpdDate());
		 map.put("updtime", tradeinfo.getUpdTime());
		 map.put("cust_num", tradeinfo.getCust_Num());
		 map.put("cust_nm", tradeinfo.getCust_Nm());
		 map.put("docs_catg", tradeinfo.getDocs_Catg());
		 map.put("docs_num", tradeinfo.getDocs_Num());
		 map.put("cust_acct_num", tradeinfo.getCust_Acct_Num());
		 map.put("sub_acct_serl_num", tradeinfo.getSub_Acct_Serl_Num());
		 map.put("acctno", tradeinfo.getAcctNo());
		 map.put("operatechannel", tradeinfo.getOperateChannel());
		 map.put("pref_exmpt_svc_fee_oprn_flg", tradeinfo.getPref_Exmpt_Svc_Fee_Oprn_Flg());
		 map.put("pref_exmpt_svc_fee_tp", tradeinfo.getPref_Exmpt_Svc_Fee_Tp());
		 map.put("pref_exmpt_svc_fee_flg", tradeinfo.getPref_Exmpt_Svc_Fee_Flg());
		 map.put("no_anul_fee_flg", tradeinfo.getNo_Anul_Fee_Flg());
		 map.put("cncl_card_reason", tradeinfo.getCncl_Card_Reason());
		 map.put("cncl_card_way", tradeinfo.getCncl_Card_Way());
		 map.put("loss_num", tradeinfo.getLoss_Num());
		 map.put("cptl_drcn", tradeinfo.getCptl_Drcn());
		 map.put("cntpr_acct_num", tradeinfo.getCntpr_Acct_Num());
		 map.put("cntpr_sub_acct_serl_num", tradeinfo.getCntpr_Sub_Acct_Serl_Num());
		 map.put("cncl_card_mode", tradeinfo.getCncl_Card_Mode());
		 
		return map;

	}*/
}
