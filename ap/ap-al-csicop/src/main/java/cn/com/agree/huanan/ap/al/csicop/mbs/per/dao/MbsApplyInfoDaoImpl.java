package cn.com.agree.huanan.ap.al.csicop.mbs.per.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csicop.mbs.per.po.MbsApplyInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 申请记录流水表dao层实现层
 * 
 * @author guyulong
 */
@Component
public class MbsApplyInfoDaoImpl implements MbsApplyInfoDao {
	private static String TABLE = "CSIS_MBS_APPLY_INFO";

	@Autowired
	private OrmOperator ormOper;
	@Autowired
	private DbOperator dbo;

	/** 根据申请编号查询信息 */
	@Override
	public MbsApplyInfo findApplyInfo(String appId) {
		return ormOper.getOrmSelecter(MbsApplyInfo.class).where(w -> {
			w.setApp_id(appId);
		}).fetchOne();
	}

	/** 更新申请记录流水表 */
	@Override
	public int updApplyInfo(String appId, Map<String, Object> updInfo) {
		return dbo.getUpdater().update(TABLE).set(updInfo).where(w -> {
			if (!StringUtils.isEmpty(appId)) {
				w.eq("app_id", appId);
			}
		}).execute();
	}

	/** 查询所有申请记录 */
	@Override
	public List<Map<String, Object>> findApplyInfoList(String operphone, String tradecode, String status,
			String idtfno) {
		return dbo.getSelecter().select("serialno", "tradecode", "tradename", "status", "tradedate", "tradetime",
				"custname as opername", "operphone", "cardno", "id_no", "app_id").from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(operphone)) {
						w.eq("operphone", operphone);
					}
					if (!StringUtils.isEmpty(tradecode)) {
						w.eq("tradecode", tradecode);
					}
					if (!StringUtils.isEmpty(status)) {
						w.eq("status", status);
					}
					if (!StringUtils.isEmpty(idtfno)) {
						w.eq("id_no", idtfno);
					}
				}).orderBy("tradedate desc","tradetime desc").fetchAll();
	}

	/** 新增申请记录流水表记录 */
	@Override
	public int insertApplyInfo(Map<String, Object> applyInfo) {
		return dbo.getInserter().insertInto(TABLE).values(applyInfo).execute();
	}

	/** 查询子表 */
	@Override
	public Map<String, Object> findSubTable(String requno, String trancode) {
		return dbo.getSelecter().select("rel_table").from(TABLE).where(w -> {
			if (!StringUtils.isEmpty(requno)) {
				w.eq("app_id", requno);
			}
			if (!StringUtils.isEmpty(trancode)) {
				w.eq("trancode", trancode);
			}
		}).fetchOne();
	}

	/** 查询记录总表获取子表信息 */
	@Override
	public Map<String, Object> getSonTableInformation(String serialno) {
		return dbo.getSelecter()
				.select("tradedate", "tradetime", "finishdate", "finishtime", "status", "app_id", "tradecode")
				.from(TABLE).where(w -> {
					w.eq("serialno", serialno);
				}).fetchOne();

	}

	/** 微网点影像信息查询(个人) */
	@Override
	public List<Map<String, Object>> findApplyInfos(String app_id, String applystdt, String applyendt, String custname,
			String operphone, String id_no, String serialno, String tradedate, String status) {
		return dbo.getSelecter()
				.select("app_id as requno", "tradedate as applydt", "custname as custna", "operphone as mobitl",
						"id_no as idtfno", "tradecode as busitype", "status", "serialno", "tradedate", "contentno",
						"modelno", "cardno", "busistartdate")
				.from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(applyendt) || !StringUtils.isEmpty(applystdt)) {
						w.op("tradedate", ">", applystdt);
						w.op("tradedate", "<", applyendt);
					} else {
						w.eq("tradedate", tradedate);
						w.eq("serialno", serialno);
					}
					if (!StringUtils.isEmpty(app_id)) {
						w.eq("app_id", app_id);
					}
					if (!StringUtils.isEmpty(custname)) {
						w.eq("custname", custname);
					}
					if (!StringUtils.isEmpty(operphone)) {
						w.eq("operphone", operphone);
					}
					if (!StringUtils.isEmpty(id_no)) {
						w.eq("id_no", id_no);
					}
					if (!StringUtils.isEmpty(status)) {
						w.eq("status", status);
					}
				}).orderBy("tradedate desc", "serialno desc").fetchAll();
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
