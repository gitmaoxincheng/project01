package cn.com.agree.huanan.ap.al.csitrd.voch.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.voch.po.TradeinfoFee.TRADEINFO_FEE_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 费用信息登记簿bean
 * @author HZP
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_FEE_MAIN.class)
public class TradeinfoFee implements Serializable{
	private static final long serialVersionUID = -2457141363737150711L;
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String tradeTime;//平台交易时间
	private String subTransFlag;//子交易事务标识,0不适用1强事务2弱事务
	private String bussceNo;//业务场景流水号,用于标识一笔业务场景的流水,由渠道端上送.一笔业务场景的流水一般可对应多笔请求方流水号.
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
	private String respSts;//交易状态
	private String errorCode;//消息码
	private String errorMsg;//消息码描述
	private String backServeCode;//后台服务码
	private String backSceneCode;//后台场景码
	private String backSysDate;//后台交易日期
	private String backSysNo;//后台交易流水
	private String backSysSts;//后台交易状态
	private String backSysErrorCode;//后台消息码
	private String backSysErrorMsg;//后台消息码描述
	private String updDate;//最后更新日期
	private String updTime;//最后更新时间
	private String sfSerialNo;//唯一流水号
	private String svcdCl;//收费大类
	private String chrgTp;//收费种类 10100022（二代Ukey工本费） 10100035 （蓝牙Ukey工本费） 10100001（IC卡开卡工本费）
	private String subTyp;//收费子类 IC卡填02  领key填 %
	private String jkType;//交易类型0-借记卡，1-Ukey
	private String currType;//币种
	private String acctNo;//账号
	private String acctNa;//账号户名
	private String dcmtTp;//凭证类型
	private String dcmtNo;//凭证号码
	private String idtfTp;//证件类别
	private String idtfNo;//证件号码
	private String amount;//应收金额

	
	public static class TRADEINFO_FEE_MAIN{
		
	}
	
	public static Map<String, Object> getMap(TradeinfoFee tradeinfoFee){
		Map<String, Object> map = new HashMap<>();
		map.put("tradedate",tradeinfoFee.getTradeDate());
		map.put("serialno",tradeinfoFee.getSerialNo());
		map.put("tradetime",tradeinfoFee.getTradeTime());
		map.put("subtransflag",tradeinfoFee.getSubTransFlag());
		map.put("bussceno",tradeinfoFee.getBussceNo());
		map.put("servecode_out",tradeinfoFee.getServeCode_out());
		map.put("scenecode_out",tradeinfoFee.getSceneCode_out());
		map.put("servecode",tradeinfoFee.getServeCode());
		map.put("scenecode",tradeinfoFee.getSceneCode());
		map.put("reqsysid",tradeinfoFee.getReqSysId());
		map.put("reqcalcod",tradeinfoFee.getReqCalCod());
		map.put("reqdate",tradeinfoFee.getReqDate());
		map.put("reqtime",tradeinfoFee.getReqTime());
		map.put("reqserialno",tradeinfoFee.getReqSerialNo());
		map.put("scrsysid",tradeinfoFee.getScrSysId());
		map.put("scrcalcod",tradeinfoFee.getScrCalCod());
		map.put("golseqno",tradeinfoFee.getGolSeqNo());
		map.put("tellerno",tradeinfoFee.getTellerNo());
		map.put("tellertp",tradeinfoFee.getTellerTp());
		map.put("mybank",tradeinfoFee.getMyBank());
		map.put("zoneno",tradeinfoFee.getZoneNo());
		map.put("mbrno",tradeinfoFee.getMbrNo());
		map.put("brno",tradeinfoFee.getBrNo());
		map.put("devno",tradeinfoFee.getDevNo());
		map.put("authtellerno",tradeinfoFee.getAuthTellerNo());
		map.put("respsts",tradeinfoFee.getRespSts());
		map.put("errorcode",tradeinfoFee.getErrorCode());
		map.put("errormsg",tradeinfoFee.getErrorMsg());
		map.put("backservecode",tradeinfoFee.getBackServeCode());
		map.put("backscenecode",tradeinfoFee.getBackSceneCode());
		map.put("backsysdate",tradeinfoFee.getBackSysDate());
		map.put("backsysno",tradeinfoFee.getBackSysNo());
		map.put("backsyssts",tradeinfoFee.getBackSysSts());
		map.put("backsyserrorcode",tradeinfoFee.getBackSysErrorCode());
		map.put("backsyserrormsg",tradeinfoFee.getBackSysErrorMsg());
		map.put("upddate",tradeinfoFee.getUpdDate());
		map.put("updtime",tradeinfoFee.getUpdTime());
		map.put("sfserialno",tradeinfoFee.getSfSerialNo());
		map.put("svcdcl",tradeinfoFee.getSvcdCl());
		map.put("chrgtp",tradeinfoFee.getChrgTp());
		map.put("subtyp",tradeinfoFee.getSubTyp());
		map.put("jktype",tradeinfoFee.getJkType());
		map.put("currtype",tradeinfoFee.getCurrType());
		map.put("acctno",tradeinfoFee.getAcctNo());
		map.put("acctna",tradeinfoFee.getAcctNa());
		map.put("dcmttp",tradeinfoFee.getDcmtTp());
		map.put("dcmtno",tradeinfoFee.getDcmtNo());
		map.put("idtftp",tradeinfoFee.getIdtfTp());
		map.put("idtfno",tradeinfoFee.getIdtfNo());
		map.put("amount",tradeinfoFee.getAmount());
		return map;
	}
}
