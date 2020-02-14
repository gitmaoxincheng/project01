package cn.com.agree.huanan.ap.al.csitrd.rcpt.po;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillInfo.TRADEINFO_BILL;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;;



/**
 * 单据表
 * @author WB
 *
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_BILL.class)
public class TradeBillInfo {
	//公共部分
	private String tradeDate; //平台交易日期
	private String serialNo;//平台交易流水
	private String serveCodeOut;//外部服务码
	private String sceneCodeOut;//外部场景码
	private String serveCode;//服务码
	
	private String sceneCode;//场景码
	private String scrSysId;//源请求方系统标识
	private String scrCalCod;//源请求方渠道编码
	private String golSeqNo;//全局流水号
	
	private String tellerNo;//柜员号
	private String myBank;//法人号
	private String brNo;//网点号
	private String authTellerNo;//授权柜员
	private String updTime;           //最后更新时间
	private String updDate;           //最后更新日期
	
	private String bill;//单据号
	private String billType;//单据类型0-组合1-原子
	private String status;//交易状态状态（01-数据申请，02-合成申请，03-合成完成，04-合成失败，05-已签章,06-签章失败）
	private String tranname;//交易名称
	private String ielecData;//无纸化凭证前台数据
	private String oelecData;//无纸化凭证后台数据
	private String mainFlag;//是否主交易0-主交易 1-非主交易
	
	private String BizSerialNo;//前置流水，单据签名时取得c端ReqNo
	public static class  TRADEINFO_BILL{
		
	} 
	public static Map<String, Object> getMap(TradeBillInfo info){
		Map<String, Object> map = new HashMap<>();
		map.put("tradeDate",info.getTradeDate());
		map.put("serialNo",info.getSerialNo());
		map.put("serveCodeOut",info.getServeCodeOut());
		map.put("sceneCodeOut",info.getSceneCodeOut());
		map.put("sceneCode",info.getSceneCode());
		map.put("serveCode",info.getServeCode());
		map.put("scrSysId",info.getScrSysId());
		map.put("scrCalCod",info.getScrCalCod());
		map.put("golSeqNo",info.getGolSeqNo());
		map.put("tellerNo",info.getTellerNo());
		map.put("myBank",info.getMyBank());
		map.put("authTellerNo",info.getAuthTellerNo());
		map.put("brNo",info.getBrNo());
		map.put("updDate",info.getUpdDate());
		map.put("updTime",info.getUpdTime());
		
		map.put("bill", info.getBill());
		map.put("billType", info.getBillType());
		map.put("status", info.getStatus());
		map.put("tranname", info.getTranname());
		map.put("mainFlag", info.getMainFlag());
		map.put("ielecData", info.getIelecData());
		map.put("oelecData", info.getOelecData());
		map.put("BizSerialNo", info.getBizSerialNo());
		return map;
		
	}
	public static TradeBillInfo getInstance(Map<String, Object> map){
		if(map!=null && !map.isEmpty()) {
			TradeBillInfo info=new TradeBillInfo();
			info.setTradeDate((String) map.get("tradeDate"));
			info.setSerialNo((String) map.get("serialNo"));
			info.setServeCodeOut((String) map.get("serveCodeOut"));
			info.setSceneCodeOut((String) map.get("sceneCodeOut"));
			info.setSceneCode((String) map.get("sceneCode"));
			info.setServeCode((String) map.get("serveCode"));
			info.setScrSysId((String) map.get("scrSysId"));
			info.setScrCalCod((String) map.get("scrCalCod"));
			info.setGolSeqNo((String) map.get("golSeqNo"));
			info.setTellerNo((String) map.get("tellerNo"));
			info.setMyBank((String) map.get("myBank"));
			info.setAuthTellerNo((String) map.get("authTellerNo"));
			info.setBrNo((String) map.get("brNo"));
			info.setUpdDate((String) map.get("updDate"));
			info.setUpdTime((String) map.get("updTime"));
			
			
			info.setBill((String) map.get("bill"));
			info.setBillType((String) map.get("billType"));
			info.setStatus((String) map.get("status"));
			info.setTranname((String) map.get("tranname"));
			info.setMainFlag((String) map.get("mainFlag"));
			try {
				info.setIelecData(ConvertBothClobToString.ClobToString((Clob) map.get("ielecData")));
				info.setOelecData(ConvertBothClobToString.ClobToString((Clob) map.get("oelecData")));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			info.setBizSerialNo((String) map.get("BizSerialNo"));
			return info;
		}else
			return null;
	}
}