package cn.com.agree.huanan.ap.al.csiusr.parasyn.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.parasyn.po.Parasyn.csis_parasyn;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 综合后管同步登记表Bean
 * @author XZ
 */
@Getter
@Setter
@ToString
@Table(csis_parasyn.class)
public class Parasyn implements Serializable {

	private static final long serialVersionUID = 6426811752487379849L;
	
	private String serialNo; //操作流水号
	private String optDate; //操作日期
	private String synType; //同步类型 0-机构 1-机构树 2-柜员
	private String optType; //操作类型    机构同步：1-新增;2-修改;3-注销;4-停用;6-机构合并;7-机构撤销 机构树同步：1-新增;2-修改;3-删除 柜员同步：  1-新增;2-修改;3-注销;4-停用;5-激活
	private String tellerNo; //柜员号
	private String brNo; //机构号
	private String unBranchNo; //并入网点号
	private String brDate; //计划并入的日期
	private String status; //状态 0-待确认 1-待处理 3-处理成功 4-处理失败 5-处理中
	private String wtStat; //回写状态 0-待通知 1-通知成功 2-通知失败 3-通知中
	private int wtNum; //回写次数
	private String rspCode; //响应码
	private String rspMsg; //响应信息
	private String updDate; //更新日期
	private String updTime; //更新时间
	private String batchno; //推送批次号
	private String brNa; //机构名称
	private String unBranchNa; //合并网点名称

	public static class csis_parasyn {

	}

	public static Map<String, Object> getMap(Parasyn parasyn) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", parasyn.getSerialNo());
		map.put("optdate", parasyn.getOptDate());
		map.put("syntype", parasyn.getSynType());
		map.put("opttype", parasyn.getOptType());
		map.put("tellerno", parasyn.getTellerNo());
		map.put("brno", parasyn.getBrNo());
		map.put("unbranchno", parasyn.getUnBranchNo());
		map.put("brdate", parasyn.getBrDate());
		map.put("status", parasyn.getStatus());
		map.put("wtstat", parasyn.getWtStat());
		map.put("wtnum", parasyn.getWtNum());
		map.put("rspcode", parasyn.getRspCode());
		map.put("rspmsg", parasyn.getRspMsg());
		map.put("upddate", parasyn.getUpdDate());
		map.put("updtime", parasyn.getUpdTime());
		map.put("batchno", parasyn.getBatchno());
		map.put("brna", parasyn.getBrNa());
		map.put("unbranchna", parasyn.getUnBranchNa());
		return map;
	}

}
