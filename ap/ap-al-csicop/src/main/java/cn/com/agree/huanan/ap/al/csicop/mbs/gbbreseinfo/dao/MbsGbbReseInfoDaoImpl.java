package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 亲子卡信息录入表dao
 * 
 * @author xuzhen
 *
 */
@Component
public class MbsGbbReseInfoDaoImpl implements MbsGbbReseInfoDao {
	private static String TABLE = "CSIS_MBS_GBB_RESERVEDINFO";

	@Autowired
	private DbOperator dbo;

	/** 亲子卡申请信息录入 */
	public int insertInfo(Map<String, Object> mbsGbbMap) {
		return dbo.getInserter().insertInto(TABLE).values(mbsGbbMap).execute();
	}

	/** 查询用户所有开卡记录 */
	public List<Map<String, Object>> findAllRese(String idtftp, String idtfno) {
		return dbo.getSelecter().select("status").from(TABLE).where(w -> {
			w.eq("idtftp", idtftp);
			w.eq("idtfno", idtfno);
		}).fetchAll();
	}

	/** 亲子卡申请信息查询 */
	@Override
	public List<Map<String, Object>> findParentChildCardApplyInformations(String tobrno, String status,
			String card_type, String idtfno, String phone, String pagesize, String pagenum) {
		int intPagesize = Integer.parseInt(pagesize);
		int intPagenumber = Integer.parseInt(pagenum);
		return dbo.getSelecter().select("serialno", "name", "idtfno", "phone", "card_type", "tobrno", "branchnames",
				"rese_date", "tradedate", "tradetime", "status").from(TABLE).where(w -> {
					w.eq("tobrno", tobrno);
					if (!StringUtils.isEmpty(phone)) {
						w.eq("phone", phone);
					}
					if (!StringUtils.isEmpty(idtfno)) {
						w.eq("idtfno", idtfno);
					}
					if (!StringUtils.isEmpty(card_type)) {
						w.eq("card_type", card_type);
					}
					if (!StringUtils.isEmpty(status)) {
						w.eq("status", status);
					}
				}).orderBy("upddate desc", "updtime desc").fetch((intPagenumber - 1) * intPagesize, intPagesize);
	}

	/** 查询亲子卡申请信息条数 */
	@Override
	public int findParentChildCardApplyInformationCount(String tobrno, String status, String card_type, String idtfno,
			String phone) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("tobrno", tobrno);
			if (!StringUtils.isEmpty(phone)) {
				w.eq("phone", phone);
			}
			if (!StringUtils.isEmpty(idtfno)) {
				w.eq("idtfno", idtfno);
			}
			if (!StringUtils.isEmpty(card_type)) {
				w.eq("card_type", card_type);
			}
			if (!StringUtils.isEmpty(status)) {
				w.eq("status", status);
			}
		}).count();
	}

	/** 查询是否办理过亲子卡 */
	@Override
	public List<Map<String, Object>> findGBB_TYPE(String date) {
		return dbo.getSelecter().select("tradedate", "serialno", "gbb_type").from(TABLE).where(w -> {
			w.eq("status", "0");
			w.op("en_card_date", "<=", date);
		}).fetchAll();
	}

	/** 亲子卡申请状态录入 */
	@Override
	public int updateStatus(String tradedate, String serialno, String status) {
		return dbo.getUpdater().update(TABLE).set("status", status).where(w -> {
			w.eq("tradedate", tradedate);
			w.eq("serialno", serialno);
		}).execute();
	}

	/** 亲子卡申请状态更新 */
	@Override
	public int updateStatus(String name, String idtfno, String fileDate, String sdate) {
		return dbo.getUpdater().update(TABLE).set("status", "2").where(w -> {
			w.eq("name", name);
			w.eq("idtfno", idtfno);
			w.eq("status", "0");
			w.op("tradedate", "<=", fileDate);
			w.op("tradedate", ">=", sdate);
		}).execute();
	}

}
