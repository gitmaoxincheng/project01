package cn.com.agree.huanan.ap.al.csitrd.auth.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.auth.po.TradeInfoAuthCheckMaim.TRADEINFO_AUTHCHECK_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 审核授权登记簿 
 * chents
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_AUTHCHECK_MAIN.class)
public class TradeInfoAuthCheckMaim implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3943299332062517664L;

	// 公共部分
	private String tradeDate; // 平台交易日期
	private String serialNo; // 平台交易流水
	private String tradeTime; // 平台交易时间
	private String subtransFlag; // 子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo; // 业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
	private String servecode_out; // 外部服务码
	private String scenecode_out; // 外部场景码
	private String servecode; // 服务码
	private String scenecode; // 场景码
	private String reqSysId; // 请求方系统标识
	private String reqCalCod; // 请求方渠道编码
	private String reqDate; // 请求方日期
	private String reqTime; // 请求方时间
	private String reqSerialNo; // 请求方流水号
	private String scrSysId; // 源请求方系统标识
	private String scrCalCod; // 源请求方渠道编码
	private String golSeqNo; // 全局流水号
	private String tellerNo; // 柜员号
	private String tellerTp; // 柜员类型
	private String myBank; // 法人号
	private String zoneNo; // 分行号
	private String mBrno; // 支行号
	private String brno; // 网点号
	private String devno; // 设备编号
	private String authTellerNo; // 授权柜员
	private String respSts; // 交易状态
	private String errorCode; // 消息码
	private String errorMsg; // 消息码描述
	private String backServeCode; // 后台服务码
	private String backSceneCode; // 后台场景码
	private String backSysDate; // 后台交易日期
	private String backSysNo; // 后台交易流水
	private String backSysSts; // 后台交易状态
	private String backSysErrorCode; // 后台消息码
	private String backSysErrorMsg; // 后台消息码描述
	private String updDate; // 最后更新日期
	private String updTime; // 最后更新时间

	// APPBody部分
	public String taskId;// 任务号
	public String opType;// 操作类型
	public String custNa;// 客户姓名
	public String idTftp;// 证件类型
	public String idtfNo;// 证件号码
	public String yy_guid;// 验印影像ID
	public String caseId;// 影像批次号
	public String autoResult;// 授权结果
	public String autoNoPassMsg;// 授权不通过原因
	
	public String templet; //影像模板
	public String txtType; //文档部件名
	public String printType; //验印类型1-公章2-预留印鉴3-公章+预留印鉴
	public String isSmallCode; //是否小码章0-是1-否
	public String printBrno; //验印网点
	public String printUser1; //验印柜员1
	public String printUser2; //验印柜员2
	public String printNoPass1; //验印不通过原因
	public String printFlag; //验印完成标志0-完成1-处理中2-撤销;
	public String printResult; //验印结果0-通过1-不通过

	public static class TRADEINFO_AUTHCHECK_MAIN {

	}

	public static Map<String, Object> getMap(TradeInfoAuthCheckMaim info) {
		
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
		
		map.put("taskId",info.getTaskId());
		map.put("opType",info.getOpType());
		map.put("custNa",info.getCustNa());
		map.put("idTftp",info.getIdTftp());
		map.put("idtfNo",info.getIdtfNo());
		map.put("yy_guid",info.getYy_guid());
		map.put("caseId",info.getCaseId());
		map.put("autoResult",info.getAutoResult());
		map.put("autoNoPassMsg",info.getAutoNoPassMsg());
		
		map.put("templet",info.getTemplet());
		map.put("txtType",info.getTxtType());
		map.put("printType",info.getPrintType());
		map.put("isSmallCode",info.getIsSmallCode());
		map.put("printBrno",info.getPrintBrno());
		map.put("printUser1",info.getPrintUser1());
		map.put("printUser2",info.getPrintUser2());
		map.put("printNoPass1",info.getPrintNoPass1());
		map.put("printFlag",info.getPrintFlag());
		map.put("printResult",info.getPrintResult());
		
		return map;
	}

}
