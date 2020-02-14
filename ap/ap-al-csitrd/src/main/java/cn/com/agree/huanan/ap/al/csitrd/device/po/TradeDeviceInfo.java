package cn.com.agree.huanan.ap.al.csitrd.device.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.device.po.TradeDeviceInfo.TRADEINFO_DEVICE_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 设备信息登记簿Bean
 * @author bodadmin
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_DEVICE_MAIN.class)
public class TradeDeviceInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5545255665782786079L;
	
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
	
	private String csbxId;           //凭证箱ID
	private String opType;           //0-加凭证 1-清机 2-清回收箱 4-清吞卡箱
	private String num;           //凭证数
	
	public static class TRADEINFO_DEVICE_MAIN {
        
    }
	
	public static Map<String, Object> getMap(TradeDeviceInfo trade){
		
		Map<String, Object> map = new HashMap<>();
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
		map.put("csbxid", trade.getCsbxId());
		map.put("optype", trade.getOpType());
		map.put("num", trade.getNum());
		return map;
	}

}
