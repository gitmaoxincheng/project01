package cn.com.agree.huanan.ap.al.csitrd.nbnt.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.nbnt.po.Nbnt.tradeinfo_finlinsu_main;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 理财保险业务
 * @author jiangzf
 *
 */
@Setter
@Getter
@ToString
@Table(tradeinfo_finlinsu_main.class)
public class Nbnt implements Serializable {
	
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
	
	public static Map<String, Object> getMap(Nbnt nbnt){
		 Map<String, Object> map = new HashMap<>();
		 map.put("servecode_out",nbnt.getServecode_out());
		 map.put("scenecode_out",nbnt.getScenecode_out());
		 map.put("serveCode",nbnt.getServeCode());
		 map.put("sceneCode",nbnt.getSceneCode());
		 map.put("reqSysId",nbnt.getReqSysId());
		 map.put("reqCalCod",nbnt.getReqCalCod());
		 map.put("reqDate",nbnt.getReqDate());
		 map.put("reqTime",nbnt.getReqTime());
		 map.put("reqSerialNo",nbnt.getReqSerialNo());
		 map.put("scrsysid",nbnt.getScrSysId());
		 map.put("scrCalCod",nbnt.getScrCalCod());
		 map.put("golSeqNo",nbnt.getGolSeqNo());
		 map.put("tellerNo",nbnt.getTellerNo());
		 map.put("tellerTp",nbnt.getTellerTp());
		 map.put("myBank",nbnt.getMyBank());
		 map.put("zoneNo",nbnt.getZoneNo());
		 map.put("mbrNo",nbnt.getMbrNo());
		 map.put("brNo",nbnt.getBrNo());
		 map.put("devNo",nbnt.getDevNo());
		 map.put("authTellerNo",nbnt.getAuthTellerNo());
		 map.put("respSts",nbnt.getRespSts());
		 map.put("errorCode",nbnt.getErrorCode());
		 map.put("errorMsg",nbnt.getErrorMsg());
		 map.put("backServeCode",nbnt.getBackServeCode());
		 map.put("backSceneCode",nbnt.getBackSceneCode());
		 map.put("backSysDate",nbnt.getBackSysDate());
		 map.put("backSysNo",nbnt.getBackSysNo());
		 map.put("backSysSts",nbnt.getBackSysSts());
		 map.put("backsysErrorCode",nbnt.getBackSysErrorCode());
		 map.put("backSysErrorMsg",nbnt.getBackSysErrorMsg());
		 map.put("updDate",nbnt.getUpdDate());
		 map.put("updTime",nbnt.getUpdTime());
		 map.put("openBranch",nbnt.getOpenBranch());
		 map.put("bankAcc",nbnt.getBankAcc());
		 map.put("accType",nbnt.getAccType());
		 map.put("account",nbnt.getAccount());
		 map.put("clientGroup",nbnt.getClientGroup());
		 map.put("clientType",nbnt.getClientType());
		 map.put("cifNo",nbnt.getCifNo());
		 map.put("cstNo",nbnt.getCstNo());
		 map.put("cstName",nbnt.getCstName());
		 map.put("idType",nbnt.getIdType());
		 map.put("idCode",nbnt.getIdCode());
		 map.put("taCode",nbnt.getTACode());
		 map.put("assetAcc",nbnt.getAssetAcc());
		 map.put("clientManager",nbnt.getClientManager());
		 map.put("oprType",nbnt.getOprType());
		 map.put("prdType",nbnt.getPrdType());
		 map.put("sellerCode",nbnt.getSellerCode());
		 map.put("prdKind",nbnt.getPrdKind());
		 map.put("prdCode",nbnt.getPrdCode());
		 map.put("amount",nbnt.getAmount());
		 map.put("vol",nbnt.getVol());
		 map.put("bxgslsh",nbnt.getBxgslsh());
		 map.put("bxgsjydm",nbnt.getBxgsjydm());
		 map.put("cardType",nbnt.getCardType());
		 map.put("recordEseqNo",nbnt.getRecordEseqNo());
		 map.put("assoSerial",nbnt.getAssoSerial());
		 map.put("flag",nbnt.getFlag());
		 map.put("largredFlag",nbnt.getLargredFlag());
		 map.put("cfmNo",nbnt.getCfmNo());
		 map.put("endAmt",nbnt.getEndAmt());
		 map.put("startInvestDate",nbnt.getStartInvestDate());
		 map.put("transChannel",nbnt.getTransChannel());
		 map.put("orderNum",nbnt.getOrderNum());
		 map.put("payAccount",nbnt.getAccount());
		 map.put("payName",nbnt.getPayName());
		 map.put("bankCode",nbnt.getBankCode());
		 map.put("tbrxm",nbnt.getTbrxm());
		 map.put("tbrxb",nbnt.getTbrxb());
		 map.put("tbrzjhm",nbnt.getTbrzjhm());
		 map.put("tbrjtlxdz",nbnt.getTbrjtlxdz());
		 map.put("tbrsjhm",nbnt.getTbrsjhm());
		 map.put("tbrEmail",nbnt.getTbrEmail());
		 map.put("tbrdwmc",nbnt.getTbrdwmc());
		 map.put("cpdm",nbnt.getCpdm());
		 map.put("zfxbz",nbnt.getZfxbz());
		 map.put("bxxxxzgs",nbnt.getBxxxxzgs());
		 map.put("bxxxcpid",nbnt.getBxxxcpid());
		 map.put("bxxxtbfs",nbnt.getBxxxtbfs());
		 map.put("bxxxzxbe",nbnt.getBxxxzxbe());
		 map.put("yjyje",nbnt.getYjyje());
		 map.put("yjylsh",nbnt.getYjylsh());
		 map.put("ybxlsh",nbnt.getYbxlsh());
		 map.put("tradeDate",nbnt.getTradeDate());
		 map.put("serialNo",nbnt.getSerialNo());
		 map.put("tradeTime",nbnt.getTradeTime());
		 map.put("subtransFlag",nbnt.getSubtransFlag());
		 map.put("bussceNo",nbnt.getBussceNo());


		return map;

	}

}