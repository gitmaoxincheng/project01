package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 二维码信息表dao实现层
 * 
 * @author guyulong
 */
@Component
public class QRCodeInfoDaoImpl implements QRCodeInfoDao {
	private static String TABLE = "CSIS_NAC_QRCODE_INFO";

	@Autowired
	private DbOperator dbo;

	/** 二维码参数查询 */
	@Override
	public Map<String, Object> findParamas(String key, String funcid, String patype) {
		return dbo.getSelecter().select("paramas", "stat", "stdate", "endate", "patype").from(TABLE).where(w -> {
			w.eq("tradedate", key.substring(0, 8));
			w.eq("serialno", key.substring(8));
			w.eq("funcid", funcid);
			w.eq("patype", patype);
		}).fetchOne();
	}

	/** 二维码信息更新 */
	@Override
	public int updateQRInfo(String serialno, String tradedate, Map<String, Object> updateMap) {
		return dbo.getUpdater().update(TABLE).set(updateMap).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).execute();
	}

	/** 二维码信息删除 */
	@Override
	public int deleteQRInfo(String serialno, String tradedate) {
		return dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).execute();
	}

	/** 查询推荐人id */
	@Override
	public Map<String, Object> findRefid(String serialno, String tradedate) {
		return dbo.getSelecter().select("refid").from(TABLE).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).fetchOne();
	}

	/** 查询二维码 */
	@Override
	public Map<String, Object> findQRCode(String paramas) {
		return dbo.getSelecter().select("tcodeimg", "stat").from(TABLE).where(w -> {
			w.eq("paramas", paramas);
		}).fetchOne();
	}

	/** 根据paramas更新二维码 */
	@Override
	public int updateQRCode(String paramas, Map<String, Object> updateMap) {
		return dbo.getUpdater().update(TABLE).set(updateMap).where(w -> {
			w.eq("paramas", paramas);
		}).execute();
	}

	/** 查询二维码 */
	@Override
	public Map<String, Object> findQRCode(String paramas, String patype, String funcid) {
		return dbo.getSelecter()
				.select("tcodeimg", "tcodeurl", "paramas", "serialno", "tradedate", "stdate", "endate", "stat")
				.from(TABLE).where(w -> {
					if (!StringUtils.isEmpty(paramas)) {
						w.eq("paramas", paramas);
					}
					if (!StringUtils.isEmpty(patype)) {
						w.eq("patype", patype);
					}
					if (!StringUtils.isEmpty(funcid)) {
						w.eq("funcid", funcid);
					}
				}).fetchOne();
	}

	/** 更新二维码 */
	@Override
	public int updateQRCode(String paramas, String patype, String funcid, Map<String, Object> updateMap) {
		return dbo.getUpdater().update(TABLE).set(updateMap).where(w -> {
			if (!StringUtils.isEmpty(paramas)) {
				w.eq("paramas", paramas);
			}
			if (!StringUtils.isEmpty(patype)) {
				w.eq("patype", patype);
			}
			if (!StringUtils.isEmpty(funcid)) {
				w.eq("funcid", funcid);
			}
		}).execute();
	}

	/** 生成二维码 */
	@Override
	public int insertQRCode(Map<String, Object> insertMap) {
		return dbo.getInserter().insertInto(TABLE).values(insertMap).execute();
	}

	/** 查询二维码 */
	@Override
	public int findQRCode(String serialno, String tradedate) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("serialno", serialno);
			w.eq("tradedate", tradedate);
		}).count();
	}

	@Override
	public Map<String, Object> findQRCodeInfo(String refid) {
		return dbo.getSelecter().select("serialno", "stdate", "endate", "stat", "perpetual").from(TABLE).where(w -> {
			w.eq("refid", refid);
		}).fetchOne();
	}
}
