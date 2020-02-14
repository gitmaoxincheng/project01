package cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csicop.mbs.nacinfo.po.NacInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 网申信用卡信息表dao实现层
 * 
 * @author guyulong
 */
@Component
public class NacInfoDaoImpl implements NacInfoDao {
	private static String TABLE = "CSIS_NAC_INFORMATION_INFO";
	@Autowired
	private DbOperator dbo;
	@Autowired
	private OrmOperator orm;

	/** 新增网申办卡信息 */
	@Override
	public int insertNacInfo(Map<String, Object> nacInfo) {
		return dbo.getInserter().insertInto(TABLE).values(nacInfo).execute();
	}

	/** 查询网申申请信息 */
	@Override
	public List<Map<String, Object>> findNacInfo(String name, String idtftp, String idtfno) {
		return dbo.getSelecter().select("serialno", "tradedate", "tradetime", "applno", "appl_channel", "productcode",
				"productname", "suppind", "reqfeettp", "reqbrno", "cardfaceid", "identftp", "identfno", "validt",
				"fullname", "enname", "sex", "birthday", "phone", "card_no", "country", "cutycd", "cutyna", "orgnna",
				"marriage", "education", "hometyp", "hometype_other", "homeaddr_state", "homeaddr_city",
				"homeaddr_district", "homeaddr_addr", "home_tele_area", "home_tele_no", "homeli", "homeaddr_postcd",
				"regaddr_state", "regaddr_city", "regaddr_district", "regaddr_addr", "nativeplace_ind", "email",
				"wechat", "qq", "carbrand", "carno", "unitna", "wkdep", "wkpos", "wktime", "yincome", "profession",
				"unitchar", "unitaddr_state", "unitaddr_city", "unitaddr_district", "unitaddr_address",
				"unitaddr_postcd", "unitcallno", "unitcallnoext", "unitaddr_area", "wkduty", "wkduty_name", "ishaspc",
				"unitpno", "drname", "drtype", "drphone", "drcall_area", "drcall_no", "ecname", "ectype", "dcphone",
				"dccall_area", "dccall_no", "receipt_type", "postmtype", "webreceiptbrch", "billmedia", "billaddrtype",
				"isurgent", "autp_paym", "cpaymod", "caccnbr", "useyxt", "msg_free", "othbankcradno", "totalamount",
				"refidtp", "refidno", "refname", "refcardno", "refphone", "refid", "persno", "persna", "businesstype",
				"issigned", "ishadappldate", "needsign", "brno", "custgroupid", "giftid", "custid", "projno", "projna",
				"reftype", "resident_permit_no", "stagductcode", "stagductnumber", "requestippamount", "stagnumber",
				"feerate", "fee_charge_type", "payeebankid", "payeebankname", "payeeacctno", "payeeacctname",
				"payto_method", "instjectcode", "ipppurpose", "ipppurpose_other", "acceptbrchids", "branchnames",
				"purposea", "purposeaname", "purposeb", "purposebname", "ippconfigcode", "stagmatchingname", "refbrno",
				"installment", "repaymentdate", "padsend", "entrust_acct", "entrust_acctname", "entrust_bankid",
				"remark", "upddate", "updtime").from(TABLE).where(w -> {
					w.eq("fullname", name);
					w.eq("identftp", idtftp);
					w.eq("identfno", idtfno);
					w.eq("appl_channel", "MMP");
				}).orderBy("tradedate desc").fetchAll();
	}

	/** 根据申请编号查询网申进度查询本地数据 */
	@Override
	public Map<String, Object> findNacProgress(String applno) {
		return dbo.getSelecter().select("installment", "purposeaname", "purposebname", "stagmatchingname", "tradedate")
				.from(TABLE).where(w -> {
					w.eq("applno", applno);
				}).fetchOne();
	}

	/** 根据申请编号查询网申进度查询本地数据 */
	@Override
	public NacInfo findNacInfo(String serialno, String tradedate) {
		return orm.getOrmSelecter(NacInfo.class).where(w -> {
			w.setSerialno(serialno);
			w.setTradedate(tradedate);
		}).fetchOne();
	}

	/** 根据申请编号查询网申进度更新本地数据 */
	@Override
	public int updateNacInfo(String serialno, String tradedate, Map<String, Object> nacMap) {
		return dbo.getUpdater().update(TABLE).set(nacMap).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).execute();
	}
}
