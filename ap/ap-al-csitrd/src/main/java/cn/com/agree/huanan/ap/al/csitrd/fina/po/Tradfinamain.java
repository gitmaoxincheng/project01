package cn.com.agree.huanan.ap.al.csitrd.fina.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;
import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain.tradeinfo_finlinsu_main;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 理财保险业务
 * @author ZHONGGP
 *
 */
@Setter
@Getter
@ToString
@Table(tradeinfo_finlinsu_main.class)
public class Tradfinamain implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6695456533072154937L;
	
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
	
	//APPBody部分
	private String openBranch;	//银行账号开户机构
	private String bankAcc;	//银行账号
	private String accType;	//客户标识类型0-入帐账号 1-客户号 2-证件号 3－卡号（交易介质），一般查询交易可以送以上4项，购买交易由于必须出现帐号，一般使用0或3；签约开户类客户相关交易4项均可，必输
	private String account;	//客户标识
	private String clientGroup;	//客户分组
	private String clientType;	//客户类型
	private String cifNo;	//核心客户号
	private String cstNo;	//客户号
	private String cstName;	//客户名称
	private String idType;	//证件类型
	private String idCode;	//证件号码
	private String TACode;	//TA代码
	private String assetAcc;	//理财账号，理财用户编号
	private String clientManager;	//客户经理代码
	private String oprType;	//操作类型，0认购、1申购、2赎回、3撤销、4首次（保险）、5续保
	private String prdType;	//产品类型，0基金、1保险、2行内理财、3定活管家
	private String sellerCode;	//产品发售机构，保险公司代码
	private String prdKind;	//产品业务模式
	private String prdCode;	//产品代码，产品ID
	private String amount;	//交易金额，主险保费
	private String vol;	//交易份额
	private String bxgslsh;	//发售机构交易流水号，保险公司的交易流水号
	private String bxgsjydm;	//发售机构交易代码，保险公司交易代码
	private String cardType;	//卡种1、普通卡；2、金卡、3、市民卡；4、工资卡；当参与秒杀时必输，其他可空
	private String recordEseqNo;	//录音录像流水
	private String assoSerial;	//原（被撤）流水号
	private String flag;	//撤单补处理标志""1-?撤单补处理，0-其他情况撤单，可空若是撤单补处理，不根据系统参数RedoCancel判断是否允许重复撤单，Flag为1表示允许，暂不支持，为空
	private String largredFlag;	//巨额赎回处理标志
	private String cfmNo;	//原确认流水号，银行流水号
	private String endAmt;	//成功金额
	private String startInvestDate;	//定投初始日期
	private String transChannel;	//认购渠道
	private String orderNum;	//订单号
	private String payAccount;	//付款账号
	private String payName;	//付款名
	private String bankCode;	//银行代码
	private String tbrxm;	//投保人姓名
	private String tbrxb;	//投保人性别
	private String tbrzjhm;	//投保人证件号码
	private String tbrjtlxdz;	//投保人地址
	private String tbrsjhm;	//投保人手机号
	private String tbrEmail;	//投保人电子邮件
	private String tbrdwmc;	//投保人工作单位
	private String cpdm;	//主险险种代码
	private String zfxbz;	//主附险标志
	private String bxxxxzgs;	//险种个数
	private String bxxxcpid;	//险种编号
	private String bxxxtbfs;	//主险份数
	private String bxxxzxbe;	//主险保额
	private String yjyje;	//原交易金额（保费）
	private String yjylsh;	//原交易流水号
	private String ybxlsh;	//原保险公司流水号
	

	public static class tradeinfo_finlinsu_main{
		
	}
	
	public static Tradfinamain instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(Tradfinamain tradfinamain){
		 Map<String, Object> map = new HashMap<>();
		 map.put("servecode_out",tradfinamain.getServecode_out());
		 map.put("scenecode_out",tradfinamain.getScenecode_out());
		 map.put("serveCode",tradfinamain.getServeCode());
		 map.put("sceneCode",tradfinamain.getSceneCode());
		 map.put("reqSysId",tradfinamain.getReqSysId());
		 map.put("reqCalCod",tradfinamain.getReqCalCod());
		 map.put("reqDate",tradfinamain.getReqDate());
		 map.put("reqTime",tradfinamain.getReqTime());
		 map.put("reqSerialNo",tradfinamain.getReqSerialNo());
		 map.put("scrsysid",tradfinamain.getScrSysId());
		 map.put("scrCalCod",tradfinamain.getScrCalCod());
		 map.put("golSeqNo",tradfinamain.getGolSeqNo());
		 map.put("tellerNo",tradfinamain.getTellerNo());
		 map.put("tellerTp",tradfinamain.getTellerTp());
		 map.put("myBank",tradfinamain.getMyBank());
		 map.put("zoneNo",tradfinamain.getZoneNo());
		 map.put("mbrNo",tradfinamain.getMbrNo());
		 map.put("brNo",tradfinamain.getBrNo());
		 map.put("devNo",tradfinamain.getDevNo());
		 map.put("authTellerNo",tradfinamain.getAuthTellerNo());
		 map.put("respSts",tradfinamain.getRespSts());
		 map.put("errorCode",tradfinamain.getErrorCode());
		 map.put("errorMsg",tradfinamain.getErrorMsg());
		 map.put("backServeCode",tradfinamain.getBackServeCode());
		 map.put("backSceneCode",tradfinamain.getBackSceneCode());
		 map.put("backSysDate",tradfinamain.getBackSysDate());
		 map.put("backSysNo",tradfinamain.getBackSysNo());
		 map.put("backSysSts",tradfinamain.getBackSysSts());
		 map.put("backsysErrorCode",tradfinamain.getBackSysErrorCode());
		 map.put("backSysErrorMsg",tradfinamain.getBackSysErrorMsg());
		 map.put("updDate",tradfinamain.getUpdDate());
		 map.put("updTime",tradfinamain.getUpdTime());
		 map.put("openBranch",tradfinamain.getOpenBranch());
		 map.put("bankAcc",tradfinamain.getBankAcc());
		 map.put("accType",tradfinamain.getAccType());
		 map.put("account",tradfinamain.getAccount());
		 map.put("clientGroup",tradfinamain.getClientGroup());
		 map.put("clientType",tradfinamain.getClientType());
		 map.put("cifNo",tradfinamain.getCifNo());
		 map.put("cstNo",tradfinamain.getCstNo());
		 map.put("cstName",tradfinamain.getCstName());
		 map.put("idType",tradfinamain.getIdType());
		 map.put("idCode",tradfinamain.getIdCode());
		 map.put("taCode",tradfinamain.getTACode());
		 map.put("assetAcc",tradfinamain.getAssetAcc());
		 map.put("clientManager",tradfinamain.getClientManager());
		 map.put("oprType",tradfinamain.getOprType());
		 map.put("prdType",tradfinamain.getPrdType());
		 map.put("sellerCode",tradfinamain.getSellerCode());
		 map.put("prdKind",tradfinamain.getPrdKind());
		 map.put("prdCode",tradfinamain.getPrdCode());
		 map.put("amount",tradfinamain.getAmount());
		 map.put("vol",tradfinamain.getVol());
		 map.put("bxgslsh",tradfinamain.getBxgslsh());
		 map.put("bxgsjydm",tradfinamain.getBxgsjydm());
		 map.put("cardType",tradfinamain.getCardType());
		 map.put("recordEseqNo",tradfinamain.getRecordEseqNo());
		 map.put("assoSerial",tradfinamain.getAssoSerial());
		 map.put("flag",tradfinamain.getFlag());
		 map.put("largredFlag",tradfinamain.getLargredFlag());
		 map.put("cfmNo",tradfinamain.getCfmNo());
		 map.put("endAmt",tradfinamain.getEndAmt());
		 map.put("startInvestDate",tradfinamain.getStartInvestDate());
		 map.put("transChannel",tradfinamain.getTransChannel());
		 map.put("orderNum",tradfinamain.getOrderNum());
		 map.put("payAccount",tradfinamain.getAccount());
		 map.put("payName",tradfinamain.getPayName());
		 map.put("bankCode",tradfinamain.getBankCode());
		 map.put("tbrxm",tradfinamain.getTbrxm());
		 map.put("tbrxb",tradfinamain.getTbrxb());
		 map.put("tbrzjhm",tradfinamain.getTbrzjhm());
		 map.put("tbrjtlxdz",tradfinamain.getTbrjtlxdz());
		 map.put("tbrsjhm",tradfinamain.getTbrsjhm());
		 map.put("tbrEmail",tradfinamain.getTbrEmail());
		 map.put("tbrdwmc",tradfinamain.getTbrdwmc());
		 map.put("cpdm",tradfinamain.getCpdm());
		 map.put("zfxbz",tradfinamain.getZfxbz());
		 map.put("bxxxxzgs",tradfinamain.getBxxxxzgs());
		 map.put("bxxxcpid",tradfinamain.getBxxxcpid());
		 map.put("bxxxtbfs",tradfinamain.getBxxxtbfs());
		 map.put("bxxxzxbe",tradfinamain.getBxxxzxbe());
		 map.put("yjyje",tradfinamain.getYjyje());
		 map.put("yjylsh",tradfinamain.getYjylsh());
		 map.put("ybxlsh",tradfinamain.getYbxlsh());
		 map.put("tradeDate",tradfinamain.getTradeDate());
		 map.put("serialNo",tradfinamain.getSerialNo());
		 map.put("tradeTime",tradfinamain.getTradeTime());
		 map.put("subtransFlag",tradfinamain.getSubtransFlag());
		 map.put("bussceNo",tradfinamain.getBussceNo());


		return map;

	}

}
