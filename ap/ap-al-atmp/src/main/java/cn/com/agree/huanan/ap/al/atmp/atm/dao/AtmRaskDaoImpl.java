package cn.com.agree.huanan.ap.al.atmp.atm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class AtmRaskDaoImpl implements AtmRaskDao{
	private static String TABLE="ATMP_RASKSERINO";
	public final Logger logger = Logger.getLogger(AtmRaskDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	@Override
	public List<Map<String, Object>> delayedPaid() {
		List<Map<String, Object>> list = dbo.getSelecter().select("serialno","trfr_out_acct_num_src", "trfr_out_cust_acct_num",
				"trfr_in_acct_num_src","trfr_in_cust_acct_num","pswd_vrfy_way","ccy_code_num","cash_rmtc_flg",
				"txn_amt","ctrl_dectrl_flg","ctrl_num","need_ctrl_dectrl_amt","controller_date_time").from(TABLE).where(w ->{
					w.eq("ctrl_dectrl_flg", "1");
					
				}).fetchAll();
		return list;
	}
	@Override
	public int updateRaskSerino(Map<String,Object> map) {
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("serialno", map.get("serialno"));
		}).set("ctrl_dectrl_flg", "2").execute();
		return count;
	}


	
}
