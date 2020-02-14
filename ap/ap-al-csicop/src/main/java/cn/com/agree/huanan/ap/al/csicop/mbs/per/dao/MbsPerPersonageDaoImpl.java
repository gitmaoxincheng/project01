package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsPerPersonage;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 个人开卡申请表dao层实现层
 * 
 * @author guyulong
 */
@Component 
public class MbsPerPersonageDaoImpl implements MbsPerPersonageDao {
	private static String TABLE = "CSIS_MBS_PER_PERSONAGE";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	/** 个人开卡申请信息查询 */
	@Override
	public List<Map<String, Object>> findPersonalCardApplicationInformations(String idtftp, String idtfno,
			String app_id, String gloseqNo) {
		return dbo.getSelecter()
				.select("photop", "photog", "photor", "contentno", "modelno", "idtftp", "idtfno", "isnewc",
						"yxtsigned as isyxqy", "keyapply as keysli", "rry as rryyyy", "debit_self as jjcard",
						"office_phone as offpho", "family_phone as othpho", "postcode as postno",
						"pres_address as nowadd", "wkduty as profee", "wkduty_remark as othpro", "unitna as workun",
						"unitaddress as workad", "revenue as taxsta", "owned_key as zibkey", "keytype as kkeytp",
						"keychannel as keychan", "busitype as busitp", "depositterm as savedt", "rese_amount as saveam",
						"settransfer as istram", "tran_amount as tranam", "transfer_date as trandt",
						"hn_transfer as tranhn", "hn_tran_quota as dsumhn", "kh_transfer as trankh",
						"kh_tran_quota as dsumkh", "territory_quota as chdsum", "overseas_quota as ovdsum",
						"overseas_ench as ovcash", "vastdt as efctdt", "issuer as idinst", "vaeddt as inefdt",
						"app_id as requno", "phone as mobitl", "custna as pename", "status", "busistartdate")
				.from(TABLE).where(w -> {
					w.eq("idtftp", idtftp);// 必送字段
					w.eq("idtfno", idtfno);// 必送字段
					if (!StringUtils.isEmpty(gloseqNo)) {
						w.eq("gloseqno", gloseqNo);
					} else if (!StringUtils.isEmpty(app_id)) {
						w.eq("app_id", app_id);
					}
				}).orderBy("tradedate desc", "tradetime desc").fetch(0, 10);
	}

	/** 个人开卡申请信息总数 */
	@Override
	public int findPersonalCardApplicationInformationsCount(String idtftp, String idtfno, String app_id,
			String gloseqNo) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("idtftp", idtftp);// 必送字段
			w.eq("idtfno", idtfno);// 必送字段
			if (!StringUtils.isEmpty(gloseqNo)) {
				w.eq("gloseqno", gloseqNo);
			} else if (!StringUtils.isEmpty(app_id)) {
				w.eq("app_id", app_id);
			}
		}).count();
	}

	/** 个人开卡申请 */
	@Override
	public int insertPersonalCardApplicationInformation(Map<String, Object> informationMap) {
		return dbo.getInserter().insertInto(TABLE).values(informationMap).execute();
	}

	/** 个人开卡更新 */
	@Override
	public int updPersonalInfo(String appId, Map<String, Object> updInfo) {
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w -> {
			if (!StringUtils.isEmpty(appId)) {
				w.eq("app_id", appId);
			}
		}).execute();
	}

	/**
	 * 查询个人开卡申请明细
	 */
	@Override
	public Map<String, Object> findPersonageDetails(String serialno) {
		return MbsPerPersonage.getMap(ormOper.getOrmSelecter(MbsPerPersonage.class).where(w -> {
			w.setSerialno(serialno);
		}).fetchOne());
	}

	/** 根据申请编号查询记录 */
	@Override
	public int findPersonageInfo(String appId) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("app_id", appId);
		}).count();
	}
	
	/**
	 * 更新所有超期记录状态
	 * @param nowDate 最后有效期
	 * @param updInfo 更新信息
	 * @return
	 */
	@Override
	public int updateOutOfDate(String nowDate, Map<String, Object> updInfo){
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w->{
			w.eq("status", "02");
			w.op("tradedate", "<", nowDate);
		}).execute();
	}
}
