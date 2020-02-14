package cn.com.agree.huanan.ap.al.csicop.mbs.referrerinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;

/**
 * 推荐人信息表
 * 
 * @author GYL
 */
@Data
@Table(ReferrerInfo.CSIS_NAC_REFERRER_INFO.class)
public class ReferrerInfo implements Serializable {
	private static final long serialVersionUID = 8180262962996728699L;

	private String upddate; // 更新日期
	private String updtime; // 更新时间
	private String reftype; // 身份类型 01-客户 02-行员 03-项目
	private String refname; // 姓名
	private String certnumber; // 证件号码
	private String refphone; // 手机号
	private String persno; // 人事编号
	private String projno; // 项目编号
	private String refid; // 推荐人ID
	private String projna; // 项目名称
	private String remark1; // 保留字段1
	private String remark2; // 保留字段2
	private String remark3; // 保留字段3
	private String projbrno; // 项目建项网点
	private String projbrna; // 项目建项网点名称
	private String workdate; // 创建日期
	private String worktime; // 创建时间
	private String brno; // 机构号
	private String serialno; // 交易流水号
	private String tradedate; // 交易日期
	private String tradetime; // 交易时间
	private String entename; // 代发企业名称
	private String branchnames; // 网点简称
	private String businesstype; // 业务类型 3000-网申信用卡;2400-分期;3100-分期加办卡
	private String stagductcode; // 分期产品代码
	private String stagductname; // 分期产品名称
	private String instjectcode; // 分期项目代码
	private String instjectname; // 分期项目名称
	private String insttemplate; // 分期模板 0-分期模板;1-扫码分期
	private String recochannel; // 推荐渠道 0-PAD移动营销;1-其他
	private String cardbranch; // 固定机构网点号
	private String cardbranchname; // 固定机构网点名称

	public static class CSIS_NAC_REFERRER_INFO {
	}

	public static Map<String, Object> getMap(ReferrerInfo referrerInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("upddate", referrerInfo.getUpddate());
		map.put("updtime", referrerInfo.getUpdtime());
		map.put("reftype", referrerInfo.getReftype());
		map.put("refname", referrerInfo.getRefname());
		map.put("certnumber", referrerInfo.getCertnumber());
		map.put("refphone", referrerInfo.getRefphone());
		map.put("persno", referrerInfo.getPersno());
		map.put("projno", referrerInfo.getProjno());
		map.put("refid", referrerInfo.getRefid());
		map.put("projna", referrerInfo.getProjna());
		map.put("remark1", referrerInfo.getRemark1());
		map.put("remark2", referrerInfo.getRemark2());
		map.put("remark3", referrerInfo.getRemark3());
		map.put("projbrno", referrerInfo.getProjbrno());
		map.put("projbrna", referrerInfo.getProjbrna());
		map.put("workdate", referrerInfo.getWorkdate());
		map.put("worktime", referrerInfo.getWorktime());
		map.put("brno", referrerInfo.getBrno());
		map.put("serialno", referrerInfo.getSerialno());
		map.put("tradedate", referrerInfo.getTradedate());
		map.put("tradetime", referrerInfo.getTradetime());
		map.put("entename", referrerInfo.getEntename());
		map.put("branchnames", referrerInfo.getBranchnames());
		map.put("businesstype", referrerInfo.getBusinesstype());
		map.put("stagductcode", referrerInfo.getStagductcode());
		map.put("stagductname", referrerInfo.getStagductname());
		map.put("instjectcode", referrerInfo.getInstjectcode());
		map.put("instjectname", referrerInfo.getInstjectname());
		map.put("insttemplate", referrerInfo.getInsttemplate());
		map.put("recochannel", referrerInfo.getRecochannel());
		map.put("cardbranch", referrerInfo.getCardbranch());
		map.put("cardbranchname", referrerInfo.getCardbranchname());
		return map;
	}
}
