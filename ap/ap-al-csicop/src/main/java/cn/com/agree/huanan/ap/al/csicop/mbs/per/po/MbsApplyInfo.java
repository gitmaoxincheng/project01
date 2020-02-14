package cn.com.agree.huanan.ap.al.csicop.mbs.per.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 申请记录流水表Bean
 * 
 * @author XZ
 */
@Data
@Table(MbsApplyInfo.CSIS_MBS_APPLY_INFO.class)
public class MbsApplyInfo implements Serializable {
	private static final long serialVersionUID = -4816457826414699736L;

	private String serialno; // 流水号
	private String tradedate; // 交易日期
	private String tradetime; // 交易时间
	private String functioncode; // 交易大类,M-我的申请
	private String tradecode; // 交易类型,以前置为准：批量开户个人信息采集8819701 个人开卡8819702 统一签约8819703 客户信息变更8819704
	private String tradename; // 交易名称
	private String status; // 交易状态，01-已激活 02-待激活 03-已取消 04-已过期
	private String rel_table; // 关联明细表名
	private String operphone; // 交易手机号
	private String opername; // 交易操作人
	private String emp_id; // 交易柜员号
	private String brno; // 交易网点
	private String updatedate; // 交易修改日期
	private String updatetime; // 交易修改时间
	private String custno; // 客户编号
	private String id_no; // 证件号码
	private String id_type; // 证件类型
	private String custname; // 客户姓名
	private String app_id; // 申请编号
	private String finishdate; // 完成日期，申请已激活时的日期
	private String finishtime; // 完成时间，申请已激活时的时间
	private String gloseqno; // 全局流水
	private String upphone; // 登陆手机号
	private String mybank; // 法人号
	private String cardno; // 银行卡号
	private String contentno; // 图片批次号
	private String modelno; // 影像模型号
	private String busistartdate;// 影像上传时间

	public static class CSIS_MBS_APPLY_INFO {
	}

	public static Map<String, Object> getMap(MbsApplyInfo mbsApplyInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", mbsApplyInfo.getSerialno());
		map.put("tradedate", mbsApplyInfo.getTradedate());
		map.put("tradetime", mbsApplyInfo.getTradetime());
		map.put("functioncode", mbsApplyInfo.getFunctioncode());
		map.put("tradecode", mbsApplyInfo.getTradecode());
		map.put("tradename", mbsApplyInfo.getTradename());
		map.put("status", mbsApplyInfo.getStatus());
		map.put("rel_table", mbsApplyInfo.getRel_table());
		map.put("operphone", mbsApplyInfo.getOperphone());
		map.put("opername", mbsApplyInfo.getOpername());
		map.put("emp_id", mbsApplyInfo.getEmp_id());
		map.put("brno", mbsApplyInfo.getBrno());
		map.put("updatedate", mbsApplyInfo.getUpdatedate());
		map.put("updatetime", mbsApplyInfo.getUpdatetime());
		map.put("custno", mbsApplyInfo.getCustno());
		map.put("id_no", mbsApplyInfo.getId_no());
		map.put("id_type", mbsApplyInfo.getId_type());
		map.put("custname", mbsApplyInfo.getCustname());
		map.put("app_id", mbsApplyInfo.getApp_id());
		map.put("finishdate", mbsApplyInfo.getFinishdate());
		map.put("finishtime", mbsApplyInfo.getFinishtime());
		map.put("gloseqno", mbsApplyInfo.getGloseqno());
		map.put("upphone", mbsApplyInfo.getUpphone());
		map.put("mybank", mbsApplyInfo.getMybank());
		map.put("cardno", mbsApplyInfo.getCardno());
		map.put("contentno", mbsApplyInfo.getContentno());
		map.put("modelno", mbsApplyInfo.getModelno());
		map.put("busistartdate", mbsApplyInfo.getBusistartdate());
		return map;
	}
}
