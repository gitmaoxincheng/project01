package cn.com.agree.huanan.ap.al.csicop.mbs.zcd.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 政采贷预约信息表
 */
@Data
@Table(ZcdReservedInfo.CSIS_ZCD_RESERVED_INFO.class)
public class ZcdReservedInfo implements Serializable {
	private static final long serialVersionUID = 751070643706525407L;

	private String serialno;// 交易流水号
	private String tradedate;// 交易日期
	private String tradetime;// 交易时间
	private String status;// 状态:0待审批、1已审批
	private String busino;// 营业执照号码
	private String compname;// 企业名称
	private String finaname;// 融资联系人
	private String linkphone;// 联系人手机号码
	private String succitem;// 中标项目
	private String succmoney;// 中标金额
	private String finamoney;// 拟融资金额
	private String checktellerno;// 审核柜员号
	private String checkdate;// 审核日期
	private String checktime;// 审核时间
	private String checkmark;// 备注
	private String upddate;// 更新日期
	private String updtime;// 更新时间
	private String result;// 审批结果：0审批没通过、1审批通过

	public static class CSIS_ZCD_RESERVED_INFO {
	}

	public static Map<String, Object> getMap(ZcdReservedInfo zcdReservedInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", zcdReservedInfo.getSerialno());
		map.put("tradedate", zcdReservedInfo.getTradedate());
		map.put("tradetime", zcdReservedInfo.getTradetime());
		map.put("status", zcdReservedInfo.getStatus());
		map.put("busino", zcdReservedInfo.getBusino());
		map.put("compname", zcdReservedInfo.getCompname());
		map.put("finaname", zcdReservedInfo.getFinaname());
		map.put("linkphone", zcdReservedInfo.getLinkphone());
		map.put("succitem", zcdReservedInfo.getSuccitem());
		map.put("succmoney", zcdReservedInfo.getSuccmoney());
		map.put("finamoney", zcdReservedInfo.getFinamoney());
		map.put("checktellerno", zcdReservedInfo.getChecktellerno());
		map.put("checkdate", zcdReservedInfo.getCheckdate());
		map.put("checktime", zcdReservedInfo.getChecktime());
		map.put("checkmark", zcdReservedInfo.getCheckmark());
		map.put("upddate", zcdReservedInfo.getUpddate());
		map.put("updtime", zcdReservedInfo.getUpdtime());
		map.put("result", zcdReservedInfo.getResult());
		return map;
	}
}
