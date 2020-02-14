package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsPerChangemeg;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 客户信息变更申请表dao层实现层
 * 
 * @author guyulong
 */
@Component
public class MbsPerChangemegDaoImpl implements MbsPerChangemegDao {
	private static String TABLE = "CSIS_MBS_PER_CHANGEMEG";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	/** 根据申请编号查询记录 */
	@Override
	public MbsPerChangemeg findByAppId(String appId) {
		return ormOper.getOrmSelecter(MbsPerChangemeg.class).where(w -> {
			w.setApp_id(appId);
		}).fetchOne();
	}

	/** 客户信息变更申请信息查询 */
	@Override
	public List<Map<String, Object>> findClientChangeApplicationInformations(String idtftp, String idtfno,
			String app_id, String gloseqNo) {
		return dbo.getSelecter()
				.select("photop", "photog", "photoc", "contentno", "modelno", "idtftp", "idtfno", "tranac", "nowadd",
						"offpho", "othpho", "postno", "profee", "othpro as prooth", "workun", "workad",
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

	/** 客户信息变更申请信息总数 */
	@Override
	public int findClientChangeApplicationInformationsCount(String idtftp, String idtfno, String app_id,
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

	/** 修改客户信息变更申请 */
	@Override
	public int updPerChangeInfo(String appId, Map<String, Object> updInfo) {
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w -> {
			if (!StringUtils.isEmpty(appId)) {
				w.eq("app_id", appId);
			}
		}).execute();
	}

	/** 新增客户信息变更申请表记录 */
	@Override
	public int insertPerChangeInfo(Map<String, Object> perChangeInfo) {
		return dbo.getInserter().insertInto(TABLE).values(perChangeInfo).execute();
	}

	/** 查询客户信息变更明细 */
	@Override
	public Map<String, Object> findChangemegDetails(String serialno) {
		return MbsPerChangemeg.getMap(ormOper.getOrmSelecter(MbsPerChangemeg.class).where(w -> {
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
