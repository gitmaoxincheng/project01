package cn.com.agree.huanan.ap.al.csiopr.keep.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.keep.po.KeepFlow.csis_keep_flow;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * csis_keep_flow代保管物品交接流水表
 * 
 * @author chents
 * */


@Getter
@Setter
@ToString
@Table(csis_keep_flow.class)
public class KeepFlow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6946285916634306107L;

	private String seriNo;//流水号
	private String keepNo;//代保管编号
	private String keepType;//代保管品种类
	private String keepNum;//代保管品数量（金额）
	private String unit;//代保管品单位
	private String chgDate;//交接日期
	private String chgTlrNo;//交接人操作员号
	private String chgName;//交接人名称
	private String rcvTlrNo;//接收人柜员号
	private String rcvTlrName;//接收人姓名
	private String branChNo;//所属网点
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String myBank;//法人号

	public static class csis_keep_flow{

	}

	public static Map<String, Object> getMap(KeepFlow keepFlow) {
		Map<String, Object> map = new HashMap<>();
		map.put("seriNo",keepFlow.getSeriNo());
		map.put("keepNo",keepFlow.getKeepNo());
		map.put("keepType",keepFlow.getKeepType());
		map.put("keepNum",keepFlow.getKeepNum());
		map.put("unit",keepFlow.getUnit());
		map.put("chgDate",keepFlow.getChgDate());
		map.put("chgTlrNo",keepFlow.getChgTlrNo());
		map.put("chgName",keepFlow.getChgName());
		map.put("rcvTlrNo",keepFlow.getRcvTlrNo());
		map.put("rcvTlrName",keepFlow.getRcvTlrName());
		map.put("branChNo",keepFlow.getBranChNo());
		map.put("updDate",keepFlow.getUpdDate());
		map.put("updTime",keepFlow.getUpdTime());
		map.put("myBank", keepFlow.getMyBank());
		return map;
	}

}
