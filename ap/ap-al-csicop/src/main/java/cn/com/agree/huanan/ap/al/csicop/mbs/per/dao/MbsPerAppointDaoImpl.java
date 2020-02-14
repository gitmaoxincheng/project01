package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsPerAppoint;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 统一签约申请表dao层实现层
 * 
 * @author guyulong
 */
@Component
public class MbsPerAppointDaoImpl implements MbsPerAppointDao {
	private static String TABLE = "CSIS_MBS_PER_APPOINT";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	/** 统一签约申请信息查询 */
	@Override
	public List<Map<String, Object>> findPersonalUnifySignApplicationInformations(String idtftp, String idtfno,
			String app_id, String gloseqNo) {
		return dbo.getSelecter().select("photop", "photog", "photoc", "photor", "contentno", "modelno", "idtftp",
				"idtfno", "tranac", "isinb as perpnb", "wpphone as mobpnb", "yxtsigned as powyxt", "keyapply as keyshe",
				"rry as rryyyy", "debit_self as jjserv", "yxtphone1 as phono1", "yxtphone2 as phono2",
				"yxtphone3 as phono3", "yxtphone4 as phono4", "yxtphone5 as phono5", "numyu1", "numyu2", "numyu3",
				"numyu4", "numyu5", "owned_key as usekey", "keytype as ukeytp", "keychannel as keycha",
				"busitype as busitp", "depositterm as savedt", "rese_amount as saveam", "settransfer as istram",
				"tran_amount as tranam", "transfer_date as trandt", "hn_transfer as tranhn", "hn_tran_quota as dsumhn",
				"kh_transfer as trankh", "kh_tran_quota as dsumkh", "territory_quota as chdsum",
				"overseas_quota as ovdsum", "overseas_ench as ovcash", "app_id as requno", "phone as mobitl",
				"custna as pename", "status", "busistartdate").from(TABLE).where(w -> {
					w.eq("idtftp", idtftp);
					w.eq("idtfno", idtfno);
					if (!StringUtils.isEmpty(gloseqNo)) {
						w.eq("gloseqno", gloseqNo);
					} else if (!StringUtils.isEmpty(app_id)) {
						w.eq("app_id", app_id);
					}
				}).orderBy("tradedate desc", "tradetime desc").fetch(0, 10);
	}

	/** 统一签约申请信息总数 */
	@Override
	public int findPersonalUnifySignApplicationInformationsCount(String idtftp, String idtfno, String app_id,
			String gloseqNo) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("idtftp", idtftp);
			w.eq("idtfno", idtfno);
			if (!StringUtils.isEmpty(gloseqNo)) {
				w.eq("gloseqno", gloseqNo);
			} else if (!StringUtils.isEmpty(app_id)) {
				w.eq("app_id", app_id);
			}
		}).count();
	}

	/** 根据申请编号更新信息 */
	@Override
	public int updPerAppoInfo(String appId, Map<String, Object> updInfo) {
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w -> {
			if (!StringUtils.isEmpty(appId)) {
				w.eq("app_id", appId);
			}
		}).execute();
	}

	/** 根据申请编号查询申请信息 */
	@Override
	public int findAppoInfoByAppId(String appId) {
		return (int) dbo.getSelecter().select().from(TABLE).where(w -> {
			w.eq("app_id", appId);
		}).count();
	}

	/** 录入统一签约申请信息 */
	@Override
	public int insertInfo(Map<String, Object> appoInfo) {
		return dbo.getInserter().insertInto(TABLE).values(appoInfo).execute();
	}

	/** 查询统一签约申请明细 */
	@Override
	public Map<String, Object> findAppointDetails(String serialno) {
		return MbsPerAppoint.getMap(ormOper.getOrmSelecter(MbsPerAppoint.class).where(w -> {
			w.setSerialno(serialno);
		}).fetchOne());
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
