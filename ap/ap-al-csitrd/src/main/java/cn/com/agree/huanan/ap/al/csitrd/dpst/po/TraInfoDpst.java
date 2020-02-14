package cn.com.agree.huanan.ap.al.csitrd.dpst.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.al.csitrd.dpst.po.TraInfoDpst.TRADEINFO_DEPOSIT_MAIN;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 存款业务登记簿bean
 *
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_DEPOSIT_MAIN.class)
public class TraInfoDpst implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3850130013726292230L;
	private String tradeDate;         //平台交易日期
	private String serialNo;          //平台交易流水
	private String tradeTime;         //平台交易时间
	private String subTransFlag;      //子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;          //业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String serveCode_out;     //外部服务码
	private String sceneCode_out;     //外部场景码
	private String serveCode;         //服务码
	private String sceneCode;         //场景码
	private String reqSysId;          //请求方系统标识
	private String reqCalCod;         //请求方渠道编码
	private String reqDate;           //请求方日期
	private String reqTime;           //请求方时间
	private String reqSerialNo;       //请求方流水号
	private String scrSysId;          //源请求方系统标识
	private String scrCalCod;         //源请求方渠道编码
	private String golSeqNo;          //全局流水号
	private String tellerNo;          //柜员号
	private String tellerTp;          //柜员类型
	private String myBank;            //法人号
	private String zoneNo;            //分行号
	private String mbrno;             //支行号
	private String brNo;              //网点号
	private String devno;             //设备编号
	private String authTellerNo;      //授权柜员
	
	private String respsts;           //交易状态
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
	//
	private String custTp;            //客户类型 3-同业客户;1-个人客户;2-一般公司客户;4-联名客户;9-潜在客户;
	private String custNum;           //客户号 
	private String custNm;            //客户名称
	private String vchrCatg;          //凭证种类
	private String vchrBtchNum;       //凭证批号
	private String vchrSerl_Num;      //凭证序号
	private String prodCode;          //产品代码
	private String prodNm;            //产品名称
	private String ccyCodeNum;        //货币代号
	private String deptPrd;           //存期
	private String sbcrpntotlamt;     //认购、转账、交易总金额
	private String ntcNum;            //通知编号
	private String pymtAcctNum;       //付款客户账号
	private String pymtSubAcctNum;    //付款子账户序号
	private String pymtAcctTp;        //付款账号类型0-对公一般账户;1-卡;2-活期一本通;3-定期一本通;4-活期存折;5-存单;7-股金账户;8-贷款账户;9-内部账;A-组合账户;B-一号通;F-个人一本通存折;G-国债;N-电子储蓄国债;X-待销账;K-会计账户;D-电子账户;J-快捷账户;E-大额存单专用账户;
	private String rce_AccNum;        //收款、转入客户账号
	private String payesubAcctNum;    //收款、转入人子账户序号
	//
	
	
	
	
	public static class TRADEINFO_DEPOSIT_MAIN{
		
	}
	
	public static Map<String, Object> getMap(TraInfoDpst traInfoDpst){
		 Map<String, Object> map = new HashMap<>();
		 map.put("scrcalcod",traInfoDpst.getScrCalCod());
		 map.put("golseqno",traInfoDpst.getGolSeqNo());
		 map.put("tellerno",traInfoDpst.getTellerNo());
		 map.put("tellertp",traInfoDpst.getTellerTp());
		 map.put("mybank",traInfoDpst.getMyBank());
		 map.put("zoneno",traInfoDpst.getZoneNo());
		 map.put("mbrno",traInfoDpst.getMbrno());
		 map.put("brno",traInfoDpst.getBrNo());
		 map.put("devno",traInfoDpst.getDevno());
		 map.put("authtellerno",traInfoDpst.getAuthTellerNo());
		 map.put("respsts",traInfoDpst.getRespsts());
		 map.put("errorcode",traInfoDpst.getErrorCode());
		 map.put("errormsg",traInfoDpst.getErrorMsg());
		 map.put("backservecode",traInfoDpst.getBackServeCode());
		 map.put("backscenecode",traInfoDpst.getBackSceneCode());
		 map.put("backsysdate",traInfoDpst.getBackSysDate());
		 map.put("backsysno",traInfoDpst.getBackSysNo());
		 map.put("backsyssts",traInfoDpst.getBackSysSts());
		 map.put("backsyserrorcode",traInfoDpst.getBackSysErrorCode());
		 map.put("backsyserrormsg",traInfoDpst.getBackSysErrorMsg());
		 map.put("updtime",traInfoDpst.getUpdTime());
		 map.put("upddate",traInfoDpst.getUpdDate());
		 map.put("custtp",traInfoDpst.getCustTp());
		 map.put("custnum",traInfoDpst.getCustNum());
		 map.put("custnm",traInfoDpst.getCustNm());
		 map.put("vchrcatg",traInfoDpst.getVchrCatg());
		 map.put("vchrbtchnum",traInfoDpst.getVchrBtchNum());
		 map.put("vchrserl_num",traInfoDpst.getVchrSerl_Num());
		 map.put("prodcode",traInfoDpst.getProdCode());
		 map.put("prodnm",traInfoDpst.getProdNm());
		 map.put("ccycodenum",traInfoDpst.getCcyCodeNum());
		 map.put("deptprd",traInfoDpst.getDeptPrd());
		 map.put("sbcrpntotlamt",traInfoDpst.getSbcrpntotlamt());
		 map.put("ntcnum",traInfoDpst.getNtcNum());
		 map.put("pymtacctnum",traInfoDpst.getPymtAcctNum());
		 map.put("pymtsubacctnum",traInfoDpst.getPymtSubAcctNum());
		 map.put("pymtaccttp",traInfoDpst.getPymtAcctTp());
		 map.put("rce_accnum",traInfoDpst.getRce_accnum());
		 map.put("payesubacctnum",traInfoDpst.getPayesubAcctNum());
		 map.put("tradedate",traInfoDpst.getTradeDate());
		 map.put("serialno",traInfoDpst.getSerialNo());
		 map.put("tradetime",traInfoDpst.getTradeTime());
		 map.put("subtransflag",traInfoDpst.getSubTransFlag());
		 map.put("bussceno",traInfoDpst.getBussceNo());
		 map.put("servecode_out",traInfoDpst.getServeCode_out());
		 map.put("scenecode_out",traInfoDpst.getSceneCode_out());
		 map.put("servecode",traInfoDpst.getServeCode());
		 map.put("scenecode",traInfoDpst.getSceneCode());
		 map.put("reqsysid",traInfoDpst.getReqSysId());
		 map.put("reqcalcod",traInfoDpst.getReqCalCod());
		 map.put("reqdate",traInfoDpst.getReqDate());
		 map.put("reqtime",traInfoDpst.getReqTime());
		 map.put("reqserialno",traInfoDpst.getReqSerialNo());
		 map.put("scrsysid",traInfoDpst.getScrSysId());

		 return map;
	}

	private Object getRce_accnum() {
		// TODO 自动生成的方法存根
		return null;
	}


}
