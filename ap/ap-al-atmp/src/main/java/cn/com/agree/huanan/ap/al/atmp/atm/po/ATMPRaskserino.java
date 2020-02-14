package cn.com.agree.huanan.ap.al.atmp.atm.po;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPRaskserino.ATMP_RASKSERINO;
@Setter
@Getter
@ToString
@Table(ATMP_RASKSERINO.class)
/**
 * ATM定时任务（本代本延时入账）
 */
public class ATMPRaskserino {
	private String serialno;	//流水号
	private String trfr_out_acct_num_src;	//转出账号来源
	private String trfr_out_cust_acct_num;	//转出客户账号
	private String trfr_in_acct_num_src;	//转入账号来源
	private String trfr_in_cust_acct_num;	//转入客户账号
	private String pswd_vrfy_way;	//密码校验方式
	private String ccy_code_num;	//货币代号
	private String cash_rmtc_flg;	//钞汇标志
	private String txn_amt;			//交易金额
	private String ctrl_dectrl_flg;	//控制解控标志
	private String ctrl_num;		//控制编号
	private String need_ctrl_dectrl_amt;	//需控制/解控金额
	private String controller_date_time;	//控制日期时间
	
	public static class ATMP_RASKSERINO{
		
	}
	public static ATMPRaskserino instance(Map<String, Object> map) {
		return null;
	}
	public static Map<String, Object> getMap(ATMPRaskserino aTMPRaskserino){
		 Map<String, Object> map = new HashMap<>();
		 map.put("serialno", aTMPRaskserino.getSerialno());
		 map.put("trfr_out_acct_num_src", aTMPRaskserino.getTrfr_out_acct_num_src());
		 map.put("trfr_out_cust_acct_num", aTMPRaskserino.getTrfr_out_cust_acct_num());
		 map.put("trfr_in_acct_num_src", aTMPRaskserino.getTrfr_in_acct_num_src());
		 map.put("trfr_in_cust_acct_num", aTMPRaskserino.getTrfr_in_cust_acct_num());
		 map.put("pswd_vrfy_way", aTMPRaskserino.getPswd_vrfy_way());
		 map.put("ccy_code_num", aTMPRaskserino.getCcy_code_num());
		 map.put("cash_rmtc_flg", aTMPRaskserino.getCash_rmtc_flg());
		 map.put("txn_amt", aTMPRaskserino.getTxn_amt());
		 map.put("ctrl_dectrl_flg", aTMPRaskserino.getCtrl_dectrl_flg());
		 map.put("ctrl_num", aTMPRaskserino.getCtrl_num());
		 map.put("need_ctrl_dectrl_amt", aTMPRaskserino.getNeed_ctrl_dectrl_amt());
		 map.put("controller_date_time", aTMPRaskserino.getController_date_time());
		return map;
	}
	
}
