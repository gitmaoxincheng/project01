package cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 预约信息编号表dao
 * 
 * @author xuzhen
 *
 */
@Data
@Table(MbsReseNumInfo.CSIS_MBS_RESENUMBER_INFO.class)
public class MbsReseNumInfo implements Serializable {
	private static final long serialVersionUID = -120078123551304590L;

	private String serialno;// 交易流水号
	private String tradedate;// 交易日期
	private String tradetime;// 交易时间
	private String bs_name_ch;// 业务名称
	private String rese_date;// 预约日期
	private String rese_time;// 预约时间
	private String branch_name;// 机构名称
	private String rese_status;// 预约状态 0-已登记;1-已激活;2-已取消;3-已过期
	private String appisval;// 预约有效性标识 Y有效 N已失效
	private String queue_num;// 排队号
	private String wait_area;// 等待区域
	private String tradewin;// 可办窗口
	private String custtypes_ch;// 客户等级
	private String queue_times;// 取号时间
	private String hand_product;// 持有产品
	private String phone_status;// 手机号状态
	private String phone;// 手机号
	private String branchjd;// 机构经度
	private String branchwd;// 机构纬度
	private String createdate;// 创建日期
	private String createtime;// 创建时间
	private String upddate;// 修改日期
	private String updtime;// 修改时间
	private String trantype;// 办理状态 0-未办理 1-已办理
	private String maamoney;// 预约金额
	private String custno;// 客户号
	private String trantime;// 办理时间
	private String trandate;// 办理日期
	private String branchno;// 机构号
	private String number_type;// 编号类型 0-取号，1-预约
	private String custna;// 客户姓名
	private String reserv_begin_date;// 预约开始日期
	private String reserv_end_date;// 预约结束日期
	private String reserv_begin_time;// 预约开始时间
	private String reserv_end_time;// 预约结束时间
	private String reserv_bs_id;// 预约业务ID
	private String custinfo_type;// 证件类型:0 身份证，1银行卡卡号，2客户号，3护照号码，4账号（折号）
	private String custinfo_num;// 证件号码

	public static class CSIS_MBS_RESENUMBER_INFO {
	}

	public static Map<String, Object> getMap(MbsReseNumInfo mbsReseNumInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", mbsReseNumInfo.getSerialno());
		map.put("tradedate", mbsReseNumInfo.getTradedate());
		map.put("tradetime", mbsReseNumInfo.getTradetime());
		map.put("bs_name_ch", mbsReseNumInfo.getBs_name_ch());
		map.put("rese_date", mbsReseNumInfo.getRese_date());
		map.put("rese_time", mbsReseNumInfo.getRese_time());
		map.put("branch_name", mbsReseNumInfo.getBranch_name());
		map.put("rese_status", mbsReseNumInfo.getRese_status());
		map.put("appisval", mbsReseNumInfo.getAppisval());
		map.put("queue_num", mbsReseNumInfo.getQueue_num());
		map.put("wait_area", mbsReseNumInfo.getWait_area());
		map.put("tradewin", mbsReseNumInfo.getTradewin());
		map.put("custtypes_ch", mbsReseNumInfo.getCusttypes_ch());
		map.put("queue_times", mbsReseNumInfo.getQueue_times());
		map.put("hand_product", mbsReseNumInfo.getHand_product());
		map.put("phone_status", mbsReseNumInfo.getPhone_status());
		map.put("phone", mbsReseNumInfo.getPhone());
		map.put("branchjd", mbsReseNumInfo.getBranchjd());
		map.put("branchwd", mbsReseNumInfo.getBranchwd());
		map.put("createdate", mbsReseNumInfo.getCreatedate());
		map.put("createtime", mbsReseNumInfo.getCreatetime());
		map.put("upddate", mbsReseNumInfo.getUpddate());
		map.put("updtime", mbsReseNumInfo.getUpdtime());
		map.put("trantype", mbsReseNumInfo.getTrantype());
		map.put("maamoney", mbsReseNumInfo.getMaamoney());
		map.put("custno", mbsReseNumInfo.getCustno());
		map.put("trantime", mbsReseNumInfo.getTrantime());
		map.put("trandate", mbsReseNumInfo.getTrandate());
		map.put("branchno", mbsReseNumInfo.getBranchno());
		map.put("number_type", mbsReseNumInfo.getNumber_type());
		map.put("custna", mbsReseNumInfo.getCustna());
		map.put("reserv_begin_date", mbsReseNumInfo.getReserv_begin_date());
		map.put("reserv_end_date", mbsReseNumInfo.getReserv_end_date());
		map.put("reserv_begin_time", mbsReseNumInfo.getReserv_begin_time());
		map.put("reserv_end_time", mbsReseNumInfo.getReserv_end_time());
		map.put("reserv_bs_id", mbsReseNumInfo.getReserv_bs_id());
		map.put("custinfo_type", mbsReseNumInfo.getCustinfo_type());
		map.put("custinfo_num", mbsReseNumInfo.getCustinfo_num());
		return map;
	}
}
