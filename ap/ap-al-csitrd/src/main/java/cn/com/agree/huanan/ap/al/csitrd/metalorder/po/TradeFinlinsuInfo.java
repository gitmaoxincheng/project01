package cn.com.agree.huanan.ap.al.csitrd.metalorder.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.metalorder.po.TradeFinlinsuInfo.TRADEINFO_FINLINSU_MAIN;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 理财保险业务登记Bean
 * @author bodadmin
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_FINLINSU_MAIN.class)
public class TradeFinlinsuInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5689398862601798004L;

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
	
	private String openBranch;//银行账号开户机构
	private String bankAcc;//银行账号
	private String accType;//客户标识类型 0-入帐账号 1-客户号 2-证件号 3－卡号（交易介质），一般查询交易可以送以上4项，购买交易由于必须出现帐号，一般使用0或3；签约开户类客户相关交易4项均可，必输"
	private String acCount;//客户标识
	private String clientGroup;//客户分组
	private String clientType;//客户类型
	private String cifNo;//核心客户号
	private String cstNo;//客户号
	private String cstName;//客户名称
	private String idType;//证件类型
	private String idCode;//证件号码
	private String taCode;//TA代码
	private String assetacc;//理财账号，理财用户编号
	private String clientManager;//客户经理代码
	private String oprType;//操作类型，0认购、1申购、2赎回、3撤销、4首次（保险）、5续保
	private String prdType;//产品类型，0基金、1保险、2行内理财、3定活管家
	private String sellerCode;//产品发售机构，保险公司代码
	private String prdkind;//产品业务模式
	private String prdCode;//产品代码，产品ID
	private String amount;//交易金额，主险保费
	private String vol;//交易份额
	private String bxgslsh;//发售机构交易流水号，保险公司的交易流水号
	private String bxgsjydm;//发售机构交易代码，保险公司交易代码
    private String cardType;//卡种1、普通卡；2、金卡、3、市民卡；4、工资卡；当参与秒杀时必输，其他可空
	private String recordeseqNo;//录音录像流水
	private String assoserial;//原（被撤）流水号
	private String flag;//撤单补处理标志""1-?撤单补处理，0-其他情况撤单，可空若是撤单补处理，不根据系统参数RedoCancel判断是否允许重复撤单，Flag为1表示允许，暂不支持，为空""
	private String largredFlag;//巨额赎回处理标志
	private String cfmNo;//原确认流水号，银行流水号
	private String endAmt;//成功金额
	private String startInvestDate;//定投初始日期
	private String transchannel;//认购渠道
	private String orderNum;//订单号
	private String payAccount;//付款账号
	private String payName;//付款名
	private String bankCode;//银行代码
	private String tbrxm;//投保人姓名
	private String tbrxb;//投保人性别
	private String tbrzjhm;//投保人证件号码
	private String tbrjtlxdz;//投保人地址
	private String tbrsjhm;//投保人手机号
	private String tbrEmail;//投保人电子邮件
	private String tbrdwmc;//投保人工作单位
	private String cpdm;//主险险种代码
	private String zfxbz;//主附险标志
	private String bxxxxzgs;//险种个数
	private String bxxxcpid;//险种编号
	private String bxxxtbfs;//主险份数
	private String bxxxzxbe;//主险保额
	private String yjyje;//原交易金额（保费）
	private String yjylsh;//原交易流水号
	private String ybxlsh;//原保险公司流水号

	
	public static class TRADEINFO_FINLINSU_MAIN {
        
    }
	
	
	public static Map<String, Object> getMap(TradeFinlinsuInfo trade) {
		
    	Map<String, Object> map = new HashMap<>();
    	map.put("servecode_out", trade.getServeCodeOut());
    	map.put("scenecode_out", trade.getSceneCodeOut());
    	map.put("servecode", trade.getServeCode());
    	map.put("scenecode", trade.getSceneCode());
    	map.put("reqsysid", trade.getReqSysId());
    	map.put("reqcalcod", trade.getReqCalCod());
    	map.put("reqdate", trade.getReqDate());
    	map.put("reqtime", trade.getReqTime());
    	map.put("reqserialno", trade.getReqSerialNo());
    	map.put("scrsysid", trade.getScrSysId());
    	map.put("scrcalcod", trade.getScrCalCod());
    	map.put("golseqno", trade.getGolSeqNo());
    	map.put("tellerno", trade.getTellerNo());
    	map.put("tellertp", trade.getTellerTp());
    	map.put("mybank", trade.getMyBank());
    	map.put("zoneno", trade.getZoneNo());
    	map.put("mbrno", trade.getMbrno());
    	map.put("brno", trade.getBrNo());
    	map.put("devno", trade.getDevno());
    	map.put("authtellerno", trade.getAuthTellerNo());
    	map.put("respsts", trade.getRespsts());
    	map.put("errorcode", trade.getErrorCode());
    	map.put("errormsg", trade.getErrorMsg());
    	map.put("backservecode", trade.getBackServeCode());
    	map.put("backscenecode", trade.getBackSceneCode());
    	map.put("backsysdate", trade.getBackSysDate());
    	map.put("backsysno", trade.getBackSysNo());
    	map.put("backsyssts", trade.getBackSysSts());
    	map.put("backsyserrorcode", trade.getBackSysErrorCode());
    	map.put("backsyserrormsg", trade.getBackSysErrorMsg());
    	map.put("upddate", trade.getUpdDate());
    	map.put("updtime", trade.getUpdTime());
    	map.put("openbranch", trade.getOpenBranch());
    	map.put("bankacc", trade.getBankAcc());
    	map.put("acctype", trade.getAccType());
    	map.put("account", trade.getAcCount());
    	map.put("clientgroup", trade.getClientGroup());
    	map.put("clienttype", trade.getClientType());
    	map.put("cifno", trade.getCifNo());
    	map.put("cstno", trade.getCstNo());
    	map.put("cstname", trade.getCstName());
    	map.put("idtype", trade.getIdType());
    	map.put("idcode", trade.getIdCode());
    	map.put("tacode", trade.getTaCode());
    	map.put("assetacc", trade.getAssetacc());
    	map.put("clientmanager", trade.getClientManager());
    	map.put("oprtype", trade.getOprType());
    	map.put("prdtype", trade.getPrdType());
    	map.put("sellercode", trade.getSellerCode());
    	map.put("prdkind", trade.getPrdkind());
    	map.put("prdcode", trade.getPrdCode());
    	map.put("amount", trade.getAmount());
    	map.put("vol", trade.getVol());
    	map.put("bxgslsh", trade.getBxgslsh());
    	map.put("bxgsjydm", trade.getBxgsjydm());
    	map.put("cardtype", trade.getCardType());
    	map.put("recordeseqno", trade.getRecordeseqNo());
    	map.put("assoserial", trade.getAssoserial());
    	map.put("flag", trade.getFlag());
    	map.put("largredflag", trade.getLargredFlag());
    	map.put("cfmno", trade.getCfmNo());
    	map.put("endamt", trade.getEndAmt());
    	map.put("startinvestdate", trade.getStartInvestDate());
    	map.put("transchannel", trade.getTranschannel());
    	map.put("ordernum", trade.getOrderNum());
    	map.put("payaccount", trade.getPayAccount());
    	map.put("payname", trade.getPayName());
    	map.put("bankcode", trade.getBankCode());
    	map.put("tbrxm", trade.getTbrxm());
    	map.put("tbrxb", trade.getTbrxb());
    	map.put("tbrzjhm", trade.getTbrzjhm());
    	map.put("tbrjtlxdz", trade.getTbrjtlxdz());
    	map.put("tbrsjhm", trade.getTbrsjhm());
    	map.put("tbremail", trade.getTbrEmail());
    	map.put("tbrdwmc", trade.getTbrdwmc());
    	map.put("cpdm", trade.getCpdm());
    	map.put("zfxbz", trade.getZfxbz());
    	map.put("bxxxxzgs", trade.getBxxxxzgs());
    	map.put("bxxxcpid", trade.getBxxxcpid());
    	map.put("bxxxtbfs", trade.getBxxxtbfs());
    	map.put("bxxxzxbe", trade.getBxxxzxbe());
    	map.put("yjyje", trade.getYjyje());
    	map.put("yjylsh", trade.getYjylsh());
    	map.put("ybxlsh", trade.getYbxlsh());
    	map.put("tradedate", trade.getTradeDate());
    	map.put("serialno", trade.getSerialNo());
    	map.put("tradetime", trade.getTradeTime());
    	map.put("subtransflag", trade.getSubTransFlag());
    	map.put("bussceno", trade.getBussceNo());

    	return map;
    }
	
}
