package cn.com.agree.huanan.ap.al.csitrd.card.po;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csitrd.card.po.Trainfomain;
import cn.com.agree.huanan.ap.al.csitrd.card.po.Trainfomain.tradeinfo_matter_main;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 信用卡po类
 * @author zhonggp
 *
 */
@Setter
@Getter
@ToString
@Table(tradeinfo_matter_main.class)
public class Trainfomain implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4846801751722585424L;
	//公共部分
			private String tradeDate;	//平台交易日期
			private String serialNo;	//平台交易流水
			private String tradeTime;	//平台交易时间
			private String subtransFlag;	//子交易事务标识,0不适用1强事务2弱事务
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
	
			private String cust_num;	//客户号
			private String cust_nm;		//客户名称
			private String docs_catg;	//证件种类
			private String docs_num;	//证件号码
			private String cust_acct_num;	//客户账号
			private String sub_acct_serl_num;	//子账户序号
			private String acctNo;	//金融账户卡号
			private String operateChannel;	//操作渠道 非柜面渠道必输 PB:个人网银,MB:手机银行
			private String pref_exmpt_svc_fee_oprn_flg;		//优免操作标志 1-维护;2-查询;3-修改;4-删除;
			private String pref_exmpt_svc_fee_tp;	//优免类型 1-按账号;2-按客户;
			private String pref_exmpt_svc_fee_flg;		//优免标志 0-不优免;1-优免;
			private String no_anul_fee_flg;		//免年费标志 0-不优免; 1-优免;
			private String cncl_card_reason;		//销卡原因 1-正常销卡;2-挂失销卡;3-损坏销卡;4-强制销卡;5-未激活销卡;
			private String cncl_card_way;	//销卡方式 1-主卡销卡;2-附卡销卡;3-主卡销附卡;
			private String loss_num;	//挂失编号 
			private String cptl_drcn;	//资金去向 0-现金;1-转账;2-待销账;3-内部账;9-组合交易;
			private String cntpr_acct_num;	//对方账号
			private String cntpr_sub_acct_serl_num;		//对方子账户序号
			private String cncl_card_mode;  //销卡模式 0-销卡留折;1-销卡销户;
	public static class tradeinfo_matter_main{
		
	}
	
	public static Trainfomain instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(Trainfomain trainfomain){
		 Map<String, Object> map = new HashMap<>();
		 map.put("tradedate",trainfomain.getTradeDate());
		 map.put("serialno",trainfomain.getSerialNo());
		 map.put("tradetime",trainfomain.getTradeTime());
		 map.put("subtransflag",trainfomain.getSubtransFlag());
		 map.put("bussceno",trainfomain.getBussceNo());
		 map.put("servecode_out",trainfomain.getServecode_out());
		 map.put("scenecode_out",trainfomain.getScenecode_out());
		 map.put("servecode",trainfomain.getServeCode());
		 map.put("scenecode",trainfomain.getSceneCode());
		 map.put("reqsysid",trainfomain.getReqSysId());
		 map.put("reqcalcod",trainfomain.getReqCalCod());
		 map.put("reqdate",trainfomain.getReqDate());
		 map.put("reqtime",trainfomain.getReqTime());
		 map.put("reqserialno",trainfomain.getReqSerialNo());
		 map.put("scrsysid",trainfomain.getScrSysId());
		 map.put("scrcalcod",trainfomain.getScrCalCod());
		 map.put("golseqno",trainfomain.getGolSeqNo());
		 map.put("tellerno",trainfomain.getTellerNo());
		 map.put("tellertp",trainfomain.getTellerTp());
		 map.put("mybank",trainfomain.getMyBank());
		 map.put("zoneno",trainfomain.getZoneNo());
		 map.put("mbrno",trainfomain.getMbrNo());
		 map.put("brno",trainfomain.getBrNo());
		 map.put("devno",trainfomain.getDevNo());
		 map.put("authtellerno",trainfomain.getAuthTellerNo());
		 map.put("respsts",trainfomain.getRespSts());
		 map.put("errorcode",trainfomain.getErrorCode());
		 map.put("errormsg",trainfomain.getErrorMsg());
		 map.put("backservecode",trainfomain.getBackServeCode());
		 map.put("backscenecode",trainfomain.getBackSceneCode());
		 map.put("backsysdate",trainfomain.getBackSysDate());
		 map.put("backsysno",trainfomain.getBackSysNo());
		 map.put("backsyssts",trainfomain.getBackSysSts());
		 map.put("backsyserrorcode",trainfomain.getBackSysErrorCode());
		 map.put("backsyserrormsg",trainfomain.getBackSysErrorMsg());
		 map.put("upddate",trainfomain.getUpdDate());
		 map.put("updtime",trainfomain.getUpdTime());
		 map.put("cust_num",trainfomain.getCust_num());
		 map.put("cust_nm",trainfomain.getCust_nm());
		 map.put("docs_catg",trainfomain.getDocs_catg());
		 map.put("docs_num",trainfomain.getDocs_num());
		 map.put("cust_acct_num",trainfomain.getCust_acct_num());
		 map.put("sub_acct_serl_num",trainfomain.getSub_acct_serl_num());
		 map.put("acctno",trainfomain.getAcctNo());
		 map.put("operatechannel",trainfomain.getOperateChannel());
		 map.put("pref_exmpt_svc_fee_oprn_flg",trainfomain.getPref_exmpt_svc_fee_oprn_flg());
		 map.put("pref_exmpt_svc_fee_tp",trainfomain.getPref_exmpt_svc_fee_tp());
		 map.put("pref_exmpt_svc_fee_flg",trainfomain.getPref_exmpt_svc_fee_flg());
		 map.put("no_anul_fee_flg",trainfomain.getNo_anul_fee_flg());
		 map.put("cncl_card_reason",trainfomain.getCncl_card_reason());
		 map.put("cncl_card_way",trainfomain.getCncl_card_way());
		 map.put("loss_num",trainfomain.getLoss_num());
		 map.put("cptl_drcn",trainfomain.getCptl_drcn());
		 map.put("cntpr_acct_num",trainfomain.getCntpr_acct_num());
		 map.put("cntpr_sub_acct_serl_num",trainfomain.getCntpr_sub_acct_serl_num());
		 map.put("cncl_card_mode",trainfomain.getCncl_card_mode());

		return map;

	}

}
