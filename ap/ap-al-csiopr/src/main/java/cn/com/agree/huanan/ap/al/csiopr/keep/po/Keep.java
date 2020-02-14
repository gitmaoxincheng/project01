package cn.com.agree.huanan.ap.al.csiopr.keep.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep.csis_keep;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * csis_keep代保管物品表
 * 
 * @author chents
 * */


@Getter
@Setter
@ToString
@Table(csis_keep.class)
public class Keep implements Serializable{
	
	private static final long serialVersionUID = -5543049006624701652L;
	
	private String keepNo;//代保管编号
	private String keepType;//代保管品种类
	private String keepNum;//代保管品数量（金额）
	private String unit;//代保管品单位
	private String status;//代保管品状态
	private String keepDate;//保管日期
	private String keepName;//移交保管人
	private String keepPhone;//移交保管人联系方式
	private String insummary;//入库摘要
	private String outDate;//出库日期
	private String reciName;//领用人名称
	private String reciIdType;//领用人证件类型
	private String reciIdNo;//领用人证件号码
	private String reciPhone;//领用人联系方式
	private String outSummary;//出库摘要
	private String branchNo;//所属网点
	private String intellerNo;//入库登记柜员
	private String outtellerNo;//出库登记柜员
	private String authtellerNo;//出库授权柜员
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String keepTlrNo;//保管人
	private String myBank;//法人号
	
	
	public static class csis_keep{
		
	}
	
	public static Map<String, Object> getMap(Keep keep) {
		Map<String, Object> map = new HashMap<>();
		map.put("keepNo",keep.getKeepNo());
		map.put("keepType",keep.getKeepType());
		map.put("keepNum",keep.getKeepNum());
		map.put("unit",keep.getUnit());
		map.put("status",keep.getStatus());
		map.put("keepDate",keep.getKeepDate());
		map.put("keepName",keep.getKeepName());
		map.put("keepPhone",keep.getKeepPhone());
		map.put("insummary",keep.getInsummary());
		map.put("outDate",keep.getOutDate());
		map.put("reciName",keep.getReciName());
		map.put("reciIdType",keep.getReciIdType());
		map.put("reciIdNo",keep.getReciIdNo());
		map.put("reciPhone",keep.getReciPhone());
		map.put("outSummary",keep.getOutSummary());
		map.put("branchNo",keep.getBranchNo());
		map.put("intellerNo",keep.getIntellerNo());
		map.put("outtellerNo",keep.getOuttellerNo());
		map.put("authtellerNo",keep.getAuthtellerNo());
		map.put("updDate",keep.getUpdDate());
		map.put("updTime",keep.getUpdTime());
		map.put("keepTlrNo", keep.getKeepTlrNo());
		map.put("myBank", keep.getMyBank());
		return map;
	}
	

}
