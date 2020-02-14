package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.TradeInfoImageMain.TRADEINFO_IMAGE_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 影像信息登记簿
 * chents
 * */
@Getter
@Setter
@ToString 
@Table(TRADEINFO_IMAGE_MAIN.class)
public class TradeInfoImageMain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7842623703999423407L;

	//公共部分
	private String tradeDate;	//平台交易日期
	private String serialNo;	//平台交易流水
	private String tradeTime;	//平台交易时间
	private String subtransFlag;	//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;	//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String servecode_out;	//外部服务码
	private String scenecode_out;	//外部场景码
	private String servecode;	//服务码
	private String scenecode;	//场景码
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
	private String mBrno;	//支行号
	private String brno;	//网点号
	private String devno;	//设备编号
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

	//特有部分
	private String optFlag;	//操作类型0上传1-更新
	private String modeType;	//模型TYPE00-渠道整合01-微网点02-无纸化03-信审平台04-集中作业
	private String billNo;	//单据号
	private String trandDate;	//日期
	private String serialNo1;	//流水号
	private String contentId;	//影像id
	private String tradeDate1;	//影像上传日期


	public static class TRADEINFO_IMAGE_MAIN{
		
	}

	public static Map<String, Object> getMap(TradeInfoImageMain info){
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",info.getTradeDate());
		map.put("serialNo",info.getSerialNo());
		map.put("tradeTime",info.getTradeTime());
		map.put("subtransFlag",info.getSubtransFlag());
		map.put("bussceNo",info.getBussceNo());
		map.put("servecode_out",info.getServecode_out());
		map.put("scenecode_out",info.getScenecode_out());
		map.put("servecode",info.getServecode());
		map.put("scenecode",info.getScenecode());
		map.put("reqSysId",info.getReqSysId());
		map.put("reqCalCod",info.getReqCalCod());
		map.put("reqDate",info.getReqDate());
		map.put("reqTime",info.getReqTime());
		map.put("reqSerialNo",info.getReqSerialNo());
		map.put("scrSysId",info.getScrSysId());
		map.put("scrCalCod",info.getScrCalCod());
		map.put("golSeqNo",info.getGolSeqNo());
		map.put("tellerNo",info.getTellerNo());
		map.put("tellerTp",info.getTellerTp());
		map.put("myBank",info.getMyBank());
		map.put("zoneNo",info.getZoneNo());
		map.put("mBrno",info.getMBrno());
		map.put("brno",info.getBrno());
		map.put("devno",info.getDevno());
		map.put("authTellerNo",info.getAuthTellerNo());
		map.put("respSts",info.getRespSts());
		map.put("errorCode",info.getErrorCode());
		map.put("errorMsg",info.getErrorMsg());
		map.put("backServeCode",info.getBackServeCode());
		map.put("backSceneCode",info.getBackSceneCode());
		map.put("backSysDate",info.getBackSysDate());
		map.put("backSysNo",info.getBackSysNo());
		map.put("backSysSts",info.getBackSysSts());
		map.put("backSysErrorCode",info.getBackSysErrorCode());
		map.put("backSysErrorMsg",info.getBackSysErrorMsg());
		map.put("updDate",info.getUpdDate());
		map.put("updTime",info.getUpdTime());
		
		map.put("optFlag", info.getOptFlag());
		map.put("modeType", info.getModeType());
		map.put("billNo", info.getBillNo());
		map.put("trandDate", info.getTrandDate());
		map.put("serialNo1", info.getSerialNo1());
		map.put("contentId", info.getContentId());
		map.put("tradeDate1", info.getTradeDate1());
		
		return map;
	}


}



























