package cn.com.agree.huanan.ap.rl.bank.base.constant;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import cn.com.agree.huanan.ap.tl.exception.busi.ApEumnNotExistException;

public class CommParam {

	
	/**
	 * 序列字段<Key: 序列名，value: 序列长度>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Integer> SeqItems = new HashedMap();
	public static Integer suffixLen = 3;
	public static String svcCode = null;
	
	static {
		/**
		 * 客户登记簿序列号
		 */
		/*public static final String  = "";*/
		SeqItems.put("TRD_CUST_REGI_SEQ",12);
		/**
		 * 返回流水序列号
		 */
		SeqItems.put("CSI_RSP_SEQ",12);
		SeqItems.put("ATMP_RSP_SEQ",12);
		SeqItems.put("COMP_REQ_SEQ",10);
		SeqItems.put("COMP_SCHE_SEQ",10); //调度作业流水生成序列
		SeqItems.put("TRD_BILL_SEQ",10); //单据流水生成序列
		SeqItems.put("ATOM_SVC_SEQ",10);
		SeqItems.put("USR_BUSI_SEQ",10);
		SeqItems.put("TRD_BUSI_SEQ",10);
		SeqItems.put("CSIS_SEQ",10);
		SeqItems.put("ATMP_SEQ",10);
		SeqItems.put("COP_BUSI_SEQ",10);
		SeqItems.put("OPR_BUSI_SEQ",10);
		SeqItems.put("ATMP_GREQ_SEQ",10);
		
		//XXX 考虑每个服务都初始常量池是否有影响
	}
	
	/**
	 * 原子服务序列
	 */
	public static final String ATOM_SEQ = "ATOM_SVC_SEQ";
	/**
	 * 用户中心序列
	 */
	public static final String USR_SEQ = "USR_BUSI_SEQ";
	
	/**
	 * 交易中心序列
	 */
	public static final String TRD_SEQ = "TRD_BUSI_SEQ";
	/**
	 * CSIS平台序列
	 */
	public static final String CSIS_SEQ = "CSIS_SEQ";

	/**
	 * ATMP服务序列
	 */
	public static final String ATMP_SEQ = "ATMP_SEQ";
	
	/**
	 * 协同中心序列
	 */
	public static final String COP_SEQ = "COP_BUSI_SEQ";

	
	/**
	 * 协同中心序列
	 */
	public static final String OPR_SEQ = "OPR_BUSI_SEQ";
	
	
	/**
	 * 渠道整合返回流水序列
	 */
	public static final String CSIS_RSP_SEQ = "CSI_RSP_SEQ";
	/**
	 * ATMP全局流水序列
	 */
	public static final String ATMP_GREQ_SEQ = "ATMP_GREQ_SEQ";
	
	public static final String TRDNO = "01";
	public static final String USRNO = "02";
	public static final String OPRNO = "03";
	public static final String COPNO = "04";
	public static final String BASNO = "05";
	public static final String CNTPNO = "06";
	public static final String STMPNO = "07";
	public static final String ATMPNO = "08";
	public static final String COMPNO = "09";
	public static final String MMKPNO = "10";
	public static final String ESBPNO = "11";
	
	public static String transferCode(String svcName) {
		switch (svcName) {
		case "TRDCNTER":
			return TRDNO;
		case "USRCNTER":
			return USRNO;
		case "OPRCNTER":
			return OPRNO;
		case "COPCNTER":
			return COPNO;
		case "BASESVC":
			return BASNO;
		case "CNTP":
			return CNTPNO;			
		case "STMP":
			return STMPNO;
		case "ATMP":
			return ATMPNO;
		case "COMP":
			return COMPNO;
		case "MMPP":
			return MMKPNO;
		case "ESBP":
			return ESBPNO;
		default:
			throw new ApEumnNotExistException(svcName);
		}
	}

	
}
