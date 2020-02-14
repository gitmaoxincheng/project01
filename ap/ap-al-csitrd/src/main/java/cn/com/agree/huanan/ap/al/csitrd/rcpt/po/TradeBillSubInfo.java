package cn.com.agree.huanan.ap.al.csitrd.rcpt.po;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillSubInfo.TRADEINFO_BILL_SUB;;



/**
 * 单据子表
 * @author WB
 *
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_BILL_SUB.class)
public class TradeBillSubInfo {
	//公共部分
	private String tradeDate; //平台交易日期
	private String serialNo;//平台交易流水
	private String tranType;//交易类型
	private String serveCode;//服务码
	private String sceneCode;//场景码
	private String updTime;           //最后更新时间
	private String updDate;           //最后更新日期
	
	private String bill;//单据号
	private String status;//交易状态状态（01-数据申请，02-合成申请，03-合成完成，04-合成失败，05-已签章,06-签章失败）
	private String tranname;//交易名称
	private String brno;//交易机构
	private String tlrno;//交易柜员（移动营销-登陆柜员、STM-授权柜员）
	private String authTlrno;//授权柜员
	private String vochType;//凭证类型
	private String vochNo;//凭证号
	private String amount;//交易金额
	private String acctno;//账户
	private String acctname;//户名
	private String oppAcctno;//对方账户
	private String oppAcctname;//对方户名
	private String remarks;//备注信息和单据要素一样，一行一个要素。
	
	private String ielecData;//无纸化凭证前台数据
	
	private String mainSerialNo;//主表平台交易流水
	
	private String myBank;//法人号
	private String txCcy;//币种
	public static class  TRADEINFO_BILL_SUB{
		
	} 
	public static Map<String, Object> getMap(TradeBillSubInfo info) {
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",info.getTradeDate());
		map.put("serialNo",info.getSerialNo());
		map.put("tranType",info.getTranType());
		map.put("updDate",info.getUpdDate());
		map.put("updTime",info.getUpdTime());
		map.put("sceneCode",info.getSceneCode());
		map.put("serveCode",info.getServeCode());
		map.put("serialNo",info.getSerialNo());
		
		map.put("bill", info.getBill());
		map.put("status", info.getStatus());
		map.put("tranname", info.getTranname());
		map.put("brno", info.getBrno());
		map.put("tlrno", info.getTlrno());
		map.put("authTlrno", info.getAuthTlrno());
		map.put("vochType", info.getVochType());
		map.put("vochNo", info.getVochNo());
		map.put("amount", info.getAmount());
		map.put("acctno", info.getAcctno());
		map.put("acctname", info.getAcctname());
		map.put("oppAcctno", info.getOppAcctno());
		map.put("oppAcctname", info.getOppAcctname());
		
		map.put("ielecData", info.getIelecData());
		map.put("mainSerialNo",info.getMainSerialNo());
		
		map.put("myBank",info.getMyBank());
		map.put("txCcy",info.getTxCcy());
		return map;
	}
	public static TradeBillSubInfo getInstance(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()) {
			TradeBillSubInfo info=new TradeBillSubInfo();
			info.setTradeDate((String) map.get("tradeDate"));
			info.setSerialNo((String) map.get("serialNo"));
			info.setSceneCode((String) map.get("sceneCode"));
			info.setServeCode((String) map.get("serveCode"));
			info.setUpdDate((String) map.get("updDate"));
			info.setUpdTime((String) map.get("updTime"));
			info.setTranType((String) map.get("tranType"));
			
			info.setBill((String) map.get("bill"));
			info.setStatus((String) map.get("status"));
			info.setTranname((String) map.get("tranname"));
			info.setBrno((String) map.get("brno"));
			info.setTlrno((String) map.get("tlrno"));
			info.setAuthTlrno((String) map.get("authTlrno"));
			info.setVochType((String) map.get("vochType"));
			info.setVochNo((String) map.get("vochNo"));
			info.setAmount((String) map.get("amount"));
			info.setAcctno((String) map.get("acctno"));
			info.setAcctname((String) map.get("acctname"));
			info.setOppAcctno((String) map.get("oppAcctno"));
			info.setOppAcctname((String) map.get("oppAcctname"));
			
			try {
				info.setIelecData(ConvertBothClobToString.ClobToString((Clob) map.get("ielecData")));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			info.setMainSerialNo((String) map.get("mainSerialNo"));
			info.setMyBank((String) map.get("myBank"));
			info.setTxCcy((String) map.get("txCcy"));
			return info;	
		}else
			return null;
	}
}
