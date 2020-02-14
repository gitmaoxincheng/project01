package cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.resenumber.po.MbsReseNumInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 预约信息编号表dao
 * 
 * @author xuzhen
 *
 */
@Component
public class MbsReseNumInfoDaoImpl implements MbsReseNumInfoDao {
	private static String TABLE = "CSIS_MBS_RESENUMBER_INFO";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	/** 新增预约编号表记录 */
	@Override
	public int insert(Map<String, Object> reseNumInfoMap) {
		return dbo.getInserter().insertInto(TABLE).values(reseNumInfoMap).execute();
	}

	/** 查询所有预约操作记录 */
	@Override
	public List<Map<String, Object>> findReseNumInfoList(String phone, String appisval, String trantype,
			String numberType, String tradedate) {
		return dbo.getSelecter()
				.select("rese_status", "queue_num", "tradedate", "tradetime", "trantype", "maamoney", "trandate",
						"trantime", "custno", "serialno", "bs_name_ch", "rese_date", "rese_time", "branch_name",
						"tradewin", "custtypes_ch", "hand_product", "phone_status", "reserv_begin_date",
						"reserv_end_date", "reserv_begin_time", "reserv_end_time", "reserv_bs_id", "custinfo_type",
						"custinfo_num", "branchno", "phone")
				.from(TABLE).where(w -> {
					w.eq("phone", phone);
					if (!StringUtils.isEmpty(appisval)) {
						w.eq("appisval", appisval);
					}
					if (!StringUtils.isEmpty(trantype)) {
						w.eq("trantype", trantype);
					}
					if (!StringUtils.isEmpty(numberType)) {
						w.eq("number_type", numberType);
					}
					if (!StringUtils.isEmpty(tradedate)) {
						w.eq("tradedate", tradedate);
					}
				}).fetchAll();
	}

	/** 修改预约编号表信息 */
	@Override
	public int updReseInfo(String serialno, String tradedate, Map<String, Object> updInfo) {
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).execute();
	}

	/** 查询预约记录 */
	@Override
	public Map<String, Object> findCancelRese(String serialno, String phone, String appisval) {
		return dbo.getSelecter().select("rese_date", "branch_name", "bs_name_ch", "queue_num").from(TABLE).where(w -> {
			w.eq("serialno", serialno);
			w.eq("phone", phone);
			w.eq("appisval", appisval);
		}).fetchOne();
	}

	/** 查询预约记录 */
	@Override
	public MbsReseNumInfo findReseNumInfo(String serialno, String tradedate) {
		return ormOper.getOrmSelecter(MbsReseNumInfo.class).where(w -> {
			w.setSerialno(serialno);
			w.setTradedate(tradedate);
		}).fetchOne();
	}

	/** 更新过期状态 */
	@Override
	public int updOverdue(String phone, String nowDate, String nowTime, Map<String, Object> updInfo) {
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w -> {
			w.eq("phone", phone);
			w.eq("rese_status", "0");
			w.op("reserv_end_date||reserv_end_time", "<=", nowDate+nowTime);
		}).execute();
	}
}
