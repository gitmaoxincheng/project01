package cn.com.agree.huanan.ap.al.csitrd.sign.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.sign.po.TradeSignInfo.TRADEINFO_SIGN_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 签约信息Bean
 * @author bodadmin
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_SIGN_MAIN.class)
public class TradeSignInfo implements Serializable{
	
	private static final long serialVersionUID = -3041760289391068568L;
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subtransFlag;//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String servecode_out;//外部服务码
	private String scenecode_out;//外部场景码
	private String serveCode;//服务码
	private String sceneCode;//场景码
	private String reqsysId;//请求方系统标识
	private String reqcalCod;//请求方渠道编码
	private String reqDate;//请求方日期
	private String reqTime;//请求方时间
	private String reqserialNo;//请求方流水号
	private String scrsysId;//源请求方系统标识
	private String scrcalCod;//源请求方渠道编码
	private String golseqNo;//全局流水号
	private String tellerNo;//柜员号
	private String tellerTp;//柜员类型
	private String myBank;//法人号
	private String zoneNo;//分行号
	private String mbrNo;//支行号
	private String brNo;//网点号
	private String devNo;//设备编号
	private String authtellerNo;//授权柜员
	private String respSts;//交易状态
	private String errorCode;//消息码
	private String errorMsg;//消息码描述
	private String backserveCode;//后台服务码
	private String backsceneCode;//后台场景码
	private String backsysDate;//后台交易日期
	private String backsysNo;//后台交易流水
	private String backsysSts;//后台交易状态
	private String backsyserrorCode;//后台消息码
	private String backsyserrorMsg;//后台消息码描述
	private String updDate;//最后更新日期
	private String updTime;//最后更新时间
	private String custType;//客户类型,1个人客户2对公客户3同业客户
	private String signmainType;//签约主体,1客户号2卡号3账号
	private String signproduType;//签约产品类型
	private String cifNo;//核心客户号
	private String acctNo;//卡号
	private String acctrl;//核心客户账号
	private String custName;//客户姓名
	private String idType;//证件类型
	private String idCode;//证件号码
	private String sex;//客户性别,M男性F女性N非个人U未知的性别Z未说明
	private String signBrno;//签约网点
	
	public static class TRADEINFO_SIGN_MAIN{
		
	}
	
	public static Map<String,Object> getMap(TradeSignInfo tradeSignInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tradeDate",tradeSignInfo.getTradeDate());
		map.put("serialNo",tradeSignInfo.getSerialNo());
		map.put("tradeTime",tradeSignInfo.getTradeTime());
		map.put("subtransFlag",tradeSignInfo.getSubtransFlag());
		map.put("bussceNo",tradeSignInfo.getBussceNo());
		map.put("servecode_out",tradeSignInfo.getServecode_out());
		map.put("scenecode_out",tradeSignInfo.getScenecode_out());
		map.put("serveCode",tradeSignInfo.getServeCode());
		map.put("sceneCode",tradeSignInfo.getSceneCode());
		map.put("reqSysId",tradeSignInfo.getReqsysId());
		map.put("reqCalCod",tradeSignInfo.getReqcalCod());
		map.put("reqDate",tradeSignInfo.getReqDate());
		map.put("reqTime",tradeSignInfo.getReqTime());
		map.put("reqSerialNo",tradeSignInfo.getReqserialNo());
		map.put("scrSysId",tradeSignInfo.getScrsysId());
		map.put("scrCalCod",tradeSignInfo.getScrcalCod());
		map.put("golSeqNo",tradeSignInfo.getGolseqNo());
		map.put("tellerNo",tradeSignInfo.getTellerNo());
		map.put("tellerTp",tradeSignInfo.getTellerTp());
		map.put("myBank",tradeSignInfo.getMyBank());
		map.put("zoneNo",tradeSignInfo.getZoneNo());
		map.put("mbrNo",tradeSignInfo.getMbrNo());
		map.put("brNo",tradeSignInfo.getBrNo());
		map.put("devNo",tradeSignInfo.getDevNo());
		map.put("authtellerNo",tradeSignInfo.getAuthtellerNo());
		map.put("respSts",tradeSignInfo.getRespSts());
		map.put("errorCode",tradeSignInfo.getErrorCode());
		map.put("errorMsg",tradeSignInfo.getErrorMsg());
		map.put("backServeCode",tradeSignInfo.getBackserveCode());
		map.put("backSceneCode",tradeSignInfo.getBacksceneCode());
		map.put("backSysDate",tradeSignInfo.getBacksysDate());
		map.put("backSysNo",tradeSignInfo.getBacksysNo());
		map.put("backSysSts",tradeSignInfo.getBacksysSts());
		map.put("backSysErrorCode",tradeSignInfo.getBacksyserrorCode());
		map.put("backSysErrorMsg",tradeSignInfo.getBacksyserrorMsg());
		map.put("updDate",tradeSignInfo.getUpdDate());
		map.put("updTime",tradeSignInfo.getUpdTime());
		map.put("custType",tradeSignInfo.getCustType());
		map.put("signMainType",tradeSignInfo.getSignmainType());
		map.put("signProduType",tradeSignInfo.getSignproduType());
		map.put("cifNo",tradeSignInfo.getCifNo());
		map.put("acctNo",tradeSignInfo.getAcctNo());
		map.put("acctrl",tradeSignInfo.getAcctrl());
		map.put("custName",tradeSignInfo.getCustName());
		map.put("idType",tradeSignInfo.getIdType());
		map.put("idCode",tradeSignInfo.getIdCode());
		map.put("sex",tradeSignInfo.getSex());
		map.put("signBrno",tradeSignInfo.getSignBrno());
		
		return map;

	}

}
