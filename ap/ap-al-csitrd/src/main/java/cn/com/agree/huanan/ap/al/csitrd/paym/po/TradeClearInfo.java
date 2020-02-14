package cn.com.agree.huanan.ap.al.csitrd.paym.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.paym.po.TradeClearInfo.TRADEINFO_CLEAR_DETAIL;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 收支清分登记簿bean
 * @author zengs
 *
 */
@Getter
@Setter
@ToString
@Table(TRADEINFO_CLEAR_DETAIL.class)
public class TradeClearInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tradeDate;//平台交易日期
	private String serialNo;//平台交易流水
	private String coltDate;//汇总日期
	private String coltSerialNo;//汇总流水
	private String projCode;//项目代码
	private String projName;//项目名称
	private String subProjCode;//子项目代码
	private String subProjName;//子项目代码名称
	private String cleanBegDate;//清分开始日期
	private String cleanEndDate;//清分结束日期
	private String relateAmt;//涉及金额
	private String acctAmt;//记账金额
	private String outAcctNo;//出账账号
	private String outAcctName;//出账账号名称
	private String myBank;//法人号
	private String expdFlag;//收支标识   0-收 1-支
	private String subJect;//入账科目代码
	private String subJectName;//入账科目名称
	private String inAcctNo;//入账内部账号
	private String inAcctName;//入账内部账户名称
	private String txccy;//币种
	private String status;//状态 00-核心记账中 01-核心记账成功 02-核心记账失败 03-核心记账超时 04-核心冲正中 05-核心冲正06-核心冲正超时 10-总账记账中 11-总账记账成功 12-总账记账失败 13-总账记账超时  14-总账冲正中  15-总账冲正  16-总账冲正超时
	private String regTlrNo;//录入柜员
	private String checkTlrNo;//复核柜员
	private String batchName;//批次名称
	private String brNo;//机构号
	
	public static class TRADEINFO_CLEAR_DETAIL{
		
	}
	
	public static Map<String,Object> getMap(TradeClearInfo tradeClearInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tradedate",tradeClearInfo.getTradeDate());
		map.put("serialno",tradeClearInfo.getSerialNo());
		map.put("coltdate",tradeClearInfo.getColtDate());
		map.put("coltserialno",tradeClearInfo.getColtSerialNo());
		map.put("projcode",tradeClearInfo.getProjCode());
		map.put("projname",tradeClearInfo.getProjName());
		map.put("subprojcode",tradeClearInfo.getSubProjCode());
		map.put("subprojname",tradeClearInfo.getSubProjName());
		map.put("cleanbegdate",tradeClearInfo.getCleanBegDate());
		map.put("cleanenddate",tradeClearInfo.getCleanEndDate());
		map.put("relateamt",tradeClearInfo.getRelateAmt());
		map.put("acctamt",tradeClearInfo.getAcctAmt());
		map.put("outacctno",tradeClearInfo.getOutAcctNo());
		map.put("outacctname",tradeClearInfo.getOutAcctName());
		map.put("mybank",tradeClearInfo.getMyBank());
		map.put("expdflag",tradeClearInfo.getExpdFlag());
		map.put("subject",tradeClearInfo.getSubJect());
		map.put("subjectname",tradeClearInfo.getSubJectName());
		map.put("inacctno",tradeClearInfo.getInAcctNo());
		map.put("inacctname",tradeClearInfo.getInAcctName());
		map.put("txccy",tradeClearInfo.getTxccy());
		map.put("status",tradeClearInfo.getStatus());
		map.put("regtlrno",tradeClearInfo.getRegTlrNo());
		map.put("checktlrno",tradeClearInfo.getCheckTlrNo());
		map.put("batchname",tradeClearInfo.getBatchName());
		map.put("brno",tradeClearInfo.getBrNo());

		return map;
	}
}
