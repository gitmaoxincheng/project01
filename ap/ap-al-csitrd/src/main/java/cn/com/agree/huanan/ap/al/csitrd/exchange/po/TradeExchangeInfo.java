package cn.com.agree.huanan.ap.al.csitrd.exchange.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.exchange.po.TradeExchangeInfo.TRADEINFO_EXCHANGE_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 外汇业务登记Bean
 * @author bodadmin
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_EXCHANGE_MAIN.class)
public class TradeExchangeInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5254541694714816784L;
	
	private String tradeDate;         //平台交易日期
	private String serialNo;          //平台交易流水
	private String tradeTime;         //平台交易时间
	private String subTransFlag;      //子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;          //业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String serveCodeOut;     //外部服务码
	private String sceneCodeOut;     //外部场景码
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
	
	private String bizTypeCode;//业务类型代码01-占用额度的结汇,02-个人贸易结汇,03-提供凭证的经常项目其他结汇,04-资本项目结汇
	private String tradeType;//结购汇类型0-个人结汇1-个人购汇
	private String idTypeCode;//证件类型代码,参见证件类型代码表
	private String idCode;//证件号码
	private String ctyCode;//国家/地区代码,参见国家/地区代码表
	private String personName;//姓名
	private String txccy;//币种
	private String txnAmt;//交易金额
	private String lcyacctnocny;//结汇购汇人民币账户
	private String salefxsettleCode;//结汇资金形态
	private String lcyacctNo;//个人外汇账户账号
	private String custType;//客户类型,0-非居民，1-居民
	private String acctNo;//转入账号
	private String tranTp;//转出类型,TR-转账，CS-现金
	private String dcmtTp;//凭证类型
	private String dcmtNo;//凭证号码
	private String totrTp;//转入类型
	private String trexrt;//成交价
	private String toTram;//转入金额
	private String toAcNa;//转入户名
	private String toCrCy;//转入币种
	private String opbrNo;//外汇账户开户行号
	private String yjghTime;//业务种类编号
	private String busicatgsbtp;//业务种类子类
	private String trfroutacctnumorgnum;//转出账号机构号
	private String trfroutacctnumtp;//转出账号类型,0-对公一般账户;1-卡;2-活期一本通;3-定期一本通;4-活期存折;5-存单;7-股金账户;8-贷款账户;
									//9-内部账;A-组合账户;B-一号通;F-个人一本通存折;G-国债;N-电子储蓄国债;X-待销账;K-会计账户;D-电子账户;J-快捷账户;"
	private String trfroutcusTtp;//转出客户类型,""1-个人客户;2-一般公司客户;3-同业客户;""
	private String trfroutcusTacctNum;//转出客户账号
	private String trfroutsubacctserlnum;//转出子账户序号
	private String trfroutacctnm;//转出账户名称
	private String trfrinacctnumorgnum;//转入账号机构号
	private String trfrinacctnumtp;//转入账号类型,""0-对公一般账户;1-卡;2-活期一本通;3-定期一本通;4-活期存折;5-存单;7-股金账户;8-贷款账户;
									//9-内部账;A-组合账户;B-一号通;F-个人一本通存折;G-国债;N-电子储蓄国债;X-待销账;K-会计账户;D-电子账户;J-快捷账户;""
	private String trfrincusttp;//转入客户类型""1-个人客户;2-一般公司客户;3-同业客户;""
	private String trfrincustacctnum;//转入客户账号
	private String trfrinsubacctserlnum;//转入子账户序号
	private String trfrinacctnm;//转入账户名称
	
	
	public static class TRADEINFO_EXCHANGE_MAIN {
        
    }

	public static Map<String, Object> getMap(TradeExchangeInfo trade) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("reqserialno",trade.getReqSerialNo());
		map.put("scrsysid",trade.getScrSysId());
		map.put("scrcalcod",trade.getScrCalCod());
		map.put("golseqno",trade.getGolSeqNo());
		map.put("tellerno",trade.getTellerNo());
		map.put("tellertp",trade.getTellerTp());
		map.put("mybank",trade.getMyBank());
		map.put("zoneno",trade.getZoneNo());
		map.put("mbrno",trade.getMbrno());
		map.put("brno",trade.getBrNo());
		map.put("devno",trade.getDevno());
		map.put("authtellerno",trade.getAuthTellerNo());
		map.put("respsts",trade.getRespsts());
		map.put("errorcode",trade.getErrorCode());
		map.put("errormsg",trade.getErrorMsg());
		map.put("backservecode",trade.getBackServeCode());
		map.put("backscenecode",trade.getBackSceneCode());
		map.put("backsysdate",trade.getBackSysDate());
		map.put("backsysno",trade.getBackSysNo());
		map.put("backsyssts",trade.getBackSysSts());
		map.put("backsyserrorcode",trade.getBackSysErrorCode());
		map.put("backsyserrormsg",trade.getBackSysErrorMsg());
		map.put("upddate",trade.getUpdDate());
		map.put("updtime",trade.getUpdTime());
		map.put("biz_type_code",trade.getBizTypeCode());
		map.put("tradetype",trade.getTradeType());
		map.put("idtype_code",trade.getIdTypeCode());
		map.put("idcode",trade.getIdCode());
		map.put("ctycode",trade.getCtyCode());
		map.put("person_name",trade.getPersonName());
		map.put("txccy",trade.getTxccy());
		map.put("txn_amt",trade.getTxnAmt());
		map.put("lcyacctnocny",trade.getLcyacctnocny());
		map.put("salefxsettlecode",trade.getSalefxsettleCode());
		map.put("lcyacctno",trade.getLcyacctNo());
		map.put("custtype",trade.getCustType());
		map.put("acctno",trade.getAcctNo());
		map.put("trantp",trade.getTranTp());
		map.put("dcmttp",trade.getDcmtTp());
		map.put("dcmtno",trade.getDcmtNo());
		map.put("totrtp",trade.getTotrTp());
		map.put("trexrt",trade.getTrexrt());
		map.put("totram",trade.getToTram());
		map.put("toacna",trade.getToAcNa());
		map.put("tocrcy",trade.getToCrCy());
		map.put("opbrno",trade.getOpbrNo());
		map.put("yjghtime",trade.getYjghTime());
		map.put("busicatgsbtp",trade.getBusicatgsbtp());
		map.put("trfroutacctnumorgnum",trade.getTrfroutacctnumorgnum());
		map.put("trfroutacctnumtp",trade.getTrfroutacctnumtp());
		map.put("trfroutcusttp",trade.getTrfroutcusTtp());
		map.put("trfroutcustacctnum",trade.getTrfroutcusTacctNum());
		map.put("trfroutsubacctserlnum",trade.getTrfroutsubacctserlnum());
		map.put("trfroutacctnm",trade.getTrfroutacctnm());
		map.put("trfrinacctnumorgnum",trade.getTrfrinacctnumorgnum());
		map.put("trfrinacctnumtp",trade.getTrfrinacctnumtp());
		map.put("trfrincusttp",trade.getTrfrincusttp());
		map.put("trfrincustacctnum",trade.getTrfrincustacctnum());
		map.put("trfrinsubacctserlnum",trade.getTrfrinsubacctserlnum());
		map.put("trfrinacctnm",trade.getTrfrinacctnm());
		map.put("tradedate",trade.getTradeDate());
		map.put("serialno",trade.getSerialNo());
		map.put("tradetime",trade.getTradeTime());
		map.put("subtransflag",trade.getSubTransFlag());
		map.put("bussceno",trade.getBussceNo());
		map.put("servecode_out",trade.getServeCodeOut());
		map.put("scenecode_out",trade.getSceneCodeOut());
		map.put("servecode",trade.getServeCode());
		map.put("scenecode",trade.getSceneCode());
		map.put("reqsysid",trade.getReqSysId());
		map.put("reqcalcod",trade.getReqCalCod());
		map.put("reqdate",trade.getReqDate());
		map.put("reqtime",trade.getReqTime());

		return map;
	}

}
