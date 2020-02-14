package cn.com.agree.huanan.ap.al.csitrd.base.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.base.po.Drowboard.TRADEINFO_DROW_BOARD;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(TRADEINFO_DROW_BOARD.class)
public class Drowboard implements Serializable {
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
	//private String tellerNo; // 柜员号
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
	public String createdate;// 创建日期
	public String imagepath;// 图片路径
	public String rmarks;// 图片备注
	public String tellerno;// 创建柜员
	//public String brno;// 创建机构
	public String createtime;// 创建时间

	public static class TRADEINFO_DROW_BOARD{
		
	}
	public static Map<String, Object> getMap(Drowboard drow){
		Map<String, Object> map = new HashMap<>();
		map.put("TradeDate",drow.getTradeDate());
		map.put("SerialNo",drow.getSerialNo());
		map.put("tradeTime",drow.getTradeTime());
		map.put("subtransFlag",drow.getSubtransFlag());
		map.put("bussceNo",drow.getBussceNo());
		map.put("servecodeOut",drow.getServecode_out());
		map.put("scenecodeOut",drow.getScenecode_out());
		map.put("servecode",drow.getServecode());
		map.put("scenecode",drow.getScenecode());
		map.put("reqSysId",drow.getReqSysId());
		map.put("reqCalCod",drow.getReqCalCod());
		map.put("reqDate",drow.getReqDate());
		map.put("reqTime",drow.getReqTime());
		map.put("reqSerialNo",drow.getReqSerialNo());
		map.put("scrSysId",drow.getScrSysId());
		map.put("scrCalCod",drow.getScrCalCod());
		map.put("golSeqNo",drow.getGolSeqNo());
		//map.put("tellerNo",drow.getTellerNo());
		map.put("tellerTp",drow.getTellerTp());
		map.put("myBank",drow.getMyBank());
		map.put("zoneNo",drow.getZoneNo());
		map.put("mBrno",drow.getMBrno());
		map.put("brno",drow.getBrno());
		map.put("devno",drow.getDevno());
		map.put("authTellerNo",drow.getAuthTellerNo());
		map.put("respSts",drow.getRespSts());
		map.put("errorCode",drow.getErrorCode());
		map.put("errorMsg",drow.getErrorMsg());
		map.put("backServeCode",drow.getBackServeCode());
		map.put("backSceneCode",drow.getBackSceneCode());
		map.put("backSysDate",drow.getBackSysDate());
		map.put("backSysNo",drow.getBackSysNo());
		map.put("backSysSts",drow.getBackSysSts());
		map.put("backSysErrorCode",drow.getBackSysErrorCode());
		map.put("backSysErrorMsg",drow.getBackSysErrorMsg());
		map.put("updDate",drow.getUpdDate());
		map.put("updTime",drow.getUpdTime());
		
		map.put("createdate",drow.getCreatedate());
		map.put("imagepath",drow.getImagepath());
		map.put("rmarks",drow.getRmarks());
		map.put("tellerno",drow.getTellerno());
		map.put("createtime",drow.getCreatetime());
		return map;
	}
}
