
package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.po.Chlclrdtl.csis_channel_clrdtl;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Table(csis_channel_clrdtl.class)
public class Chlclrdtl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8717099204893433839L;

	private String matramt;//实物清点总额
	private String hostamt1;//加钞前主机金额
	private String addamt;//本次加钞金额
	private String adjamt;//本次减钞金额
	private String hostamt2;//加钞后主机金额
	private String remark;//备注
	private String diffflag;//长短款标识01-长款02-短款
	private String diffamt;//长短款金额
	private String diffreason;//长短款原因
	private String diffsummary;//长短款摘要信息
	private String diffnum;//长短款序号
	private String writeacctno;//待销账序号
	private String upddate;//更新日期
	private String updtime;//更新时间
	private String otheramt;//其他清点钞箱金额
	private String tradedate;//平台交易日期
	private String serialno;//平台交易流水
	private String tradetime;//平台交易时间
	private String branchno;//网点
	private String atmtellerno;//ATM柜员号
	private String devno;//ATM设备号
	private String cleantime;//清机时间
	private String lastcleantime;//上次清机时间
	private String txccy;//币种
	private String rboxamt;//回钞清点金额
	private String tboxamt;//废钞清点金额

	
	public static class csis_channel_clrdtl{
		
	}
	
	public static Chlclrdtl instance(Map<String, Object> map) {
		return null;
	}
	
	public static Map<String, Object> getMap(Chlclrdtl chlClrdtlInfo){
		 Map<String, Object> map = new HashMap<>();
		 map.put("matramt",chlClrdtlInfo.getMatramt());
		 map.put("hostamt1",chlClrdtlInfo.getHostamt1());
		 map.put("addamt",chlClrdtlInfo.getAddamt());
		 map.put("adjamt",chlClrdtlInfo.getAdjamt());
		 map.put("hostamt2",chlClrdtlInfo.getHostamt2());
		 map.put("remark",chlClrdtlInfo.getRemark());
		 map.put("diffflag",chlClrdtlInfo.getDiffflag());
		 map.put("diffamt",chlClrdtlInfo.getDiffamt());
		 map.put("diffreason",chlClrdtlInfo.getDiffreason());
		 map.put("diffsummary",chlClrdtlInfo.getDiffsummary());
		 map.put("diffnum",chlClrdtlInfo.getDiffnum());
		 map.put("writeacctno",chlClrdtlInfo.getWriteacctno());
		 map.put("upddate",chlClrdtlInfo.getUpddate());
		 map.put("updtime",chlClrdtlInfo.getUpdtime());
		 map.put("otheramt",chlClrdtlInfo.getOtheramt());
		 map.put("tradedate",chlClrdtlInfo.getTradedate());
		 map.put("serialno",chlClrdtlInfo.getSerialno());
		 map.put("tradetime",chlClrdtlInfo.getTradetime());
		 map.put("branchno",chlClrdtlInfo.getBranchno());
		 map.put("atmtellerno",chlClrdtlInfo.getAtmtellerno());
		 map.put("devno",chlClrdtlInfo.getDevno());
		 map.put("cleantime",chlClrdtlInfo.getCleantime());
		 map.put("lastcleantime",chlClrdtlInfo.getLastcleantime());
		 map.put("txccy",chlClrdtlInfo.getTxccy());
		 map.put("rboxamt",chlClrdtlInfo.getRboxamt());
		 map.put("tboxamt",chlClrdtlInfo.getTboxamt());


		return map;

	}

}
