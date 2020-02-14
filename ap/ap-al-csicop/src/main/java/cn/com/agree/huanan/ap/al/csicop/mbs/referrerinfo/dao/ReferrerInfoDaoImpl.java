package cn.com.agree.huanan.ap.al.csicop.mbs.referrerinfo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

/**
 * 推荐人信息表dao实现层
 * 
 * @author guyulong
 */
@Component
public class ReferrerInfoDaoImpl implements ReferrerInfoDao {
	private static String TABLE = "CSIS_NAC_REFERRER_INFO";
	@Autowired
	private DbOperator dbo;

	/** 新增推荐人信息 */
	@Override
	public Map<String, Object> findReferrerInfo(String reftype, String refname, String persno, String brno,
			String refphone, String stagductcode, String instjectcode, String rebankno, String reaccount,
			String reaccount_name, String projno, String entename, String cardbranch) {
		return dbo.getSelecter()
				.select("refid", "reftype", "refname", "persno", "projno", "entename", "refphone", "upddate", "updtime")
				.from(TABLE).where(w -> {
					w.eq("reftype", reftype);
					w.eq("refname", refname);
					w.eq("refphone", refphone);
					if (!"01".equals(reftype)) {
						w.eq("persno", persno);
						w.eq("brno", brno);
						if (StringUtils.isEmpty(stagductcode)) {
							w.op("stagductcode", "is", SqlUtil.getSqlExp("null"));
						} else {
							w.eq("stagductcode", stagductcode);
						}
						if (StringUtils.isEmpty(instjectcode)) {
							w.op("instjectcode", "is", SqlUtil.getSqlExp("null"));
						} else {
							w.eq("instjectcode", instjectcode);
						}
						if (StringUtils.isEmpty(rebankno)) {
							w.op("rebankno", "is", SqlUtil.getSqlExp("null"));
						} else {
							w.eq("rebankno", rebankno);
						}
						if (StringUtils.isEmpty(reaccount)) {
							w.op("reaccount", "is", SqlUtil.getSqlExp("null"));
						} else {
							w.eq("reaccount", reaccount);
						}
						if (StringUtils.isEmpty(reaccount_name)) {
							w.op("reaccount_name", "is", SqlUtil.getSqlExp("null"));
						} else {
							w.eq("reaccount_name", stagductcode);
						}
						if ("03".equals(reftype)) {
							if (StringUtils.isEmpty(projno)) {
								w.op("projno", "is", SqlUtil.getSqlExp("null"));
							} else {
								w.eq("projno", projno);
							}
							if (StringUtils.isEmpty(entename)) {
								w.op("entename", "is", SqlUtil.getSqlExp("null"));
							} else {
								w.eq("entename", entename);
							}
							if (StringUtils.isEmpty(cardbranch)) {
								w.op("cardbranch", "is", SqlUtil.getSqlExp("null"));
							} else {
								w.eq("cardbranch", cardbranch);
							}
						}
					}
				}).fetchOne();
	}

	/** 新增推荐人信息 */
	public int insertInfo(Map<String, Object> referrerInfo) {
		return dbo.getInserter().insertInto(TABLE).values(referrerInfo).execute();
	}

	/** 推荐人信息查询 */
	@Override
	public List<Map<String, Object>> findReferrerInfo(String reftype, String refname, String refphone, String refidno,
			String persno, String projno, String refid, String stagductcode, String instjectcode) {
		return dbo.getSelecter()
				.select("reftype", "refname", "refidno", "refphone", "persno", "projno", "refid", "projna", "brno",
						"businesstype", "stagductcode", "stagductname", "instjectcode", "instjectname", "insttemplate",
						"recochannel", "cardbranch", "cardbranchname", "reaccount", "reaccount_name", "rebankno",
						"rebankna", "upddate", "updtime")
				.from(TABLE).where(w -> {
					w.eq("reftype", reftype);
					if (!StringUtils.isEmpty(refname)) {
						w.eq("refname", refname);
					}
					if (!StringUtils.isEmpty(refphone)) {
						w.eq("refphone", refphone);
					}
					if (!StringUtils.isEmpty(refidno)) {
						w.eq("refidno", refidno);
					}
					if (!StringUtils.isEmpty(persno)) {
						w.eq("persno", persno);
					}
					if (!StringUtils.isEmpty(projno)) {
						w.eq("projno", projno);
					}
					if (!StringUtils.isEmpty(refid)) {
						w.eq("refid", refid);
					}
					if (!StringUtils.isEmpty(stagductcode)) {
						w.eq("stagductcode", stagductcode);
					}
					if (!StringUtils.isEmpty(instjectcode)) {
						w.eq("instjectcode", instjectcode);
					}
				}).fetchAll();
	}

	/** 推荐人信息查询(aweb) */
	@Override
	public Map<String, Object> findReferrerInfo(String refid) {
		return dbo.getSelecter()
				.select("refid", "reftype", "refname", "refidno", "persno", "projno", "projna", "refphone", "upddate",
						"updtime", "brno", "branchnames", "businesstype", "stagductcode", "instjectcode",
						"stagductname", "instjectname", "insttemplate", "recochannel", "cardbranch", "cardbranchname",
						"rebankno", "rebankna", "reaccount", "reaccount_name")
				.from(TABLE).where(w -> {
					w.eq("refid", refid);
				}).fetchOne();
	}

	/** 推荐人信息删除 */
	@Override
	public int deleteQRInfo(String refid) {
		return dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("refid", refid);
		}).execute();
	}

	/** 查询身份类型 */
	@Override
	public Map<String, Object> findReftype(String refid) {
		return dbo.getSelecter().select("reftype").from(TABLE).where(w -> {
			w.eq("refid", refid);
		}).fetchOne();
	}
}
