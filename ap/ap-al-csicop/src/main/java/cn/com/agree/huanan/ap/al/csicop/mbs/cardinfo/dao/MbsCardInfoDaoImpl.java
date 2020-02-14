package cn.com.agree.huanan.ap.al.csicop.mbs.cardinfo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

@Component
public class MbsCardInfoDaoImpl implements MbsCardInfoDao {
	private static String TABLE = "CSIS_MBS_CARDINFO";

	@Autowired
	private DbOperator dbo;

	/** 卡产品信息查询 */
	@Override
	public List<Map<String, Object>> findCardInformations(String product_type, String findDate) {
		return dbo.getSelecter()
				.select("product_code", "product_name", "product_simple_name", "feetype", "feetype_name",
						"card_photo_path", "cardback_photo_path", "card_content_desc", "card_content_desc2", "upddate",
						"updtime", "createdate", "createtime")
				.from(TABLE).where(w -> {
					w.eq("product_type", product_type);
					w.eq("valid_ind", "Y");
					w.op("st_date", "<=", findDate);
					w.op("up_date", ">=", findDate);
				}).fetchAll();
	}

	/** 卡产品信息总数查询 */
	@Override
	public int findCardInformationsCount(String product_type, String findDate) {
		return (int) dbo.getSelecter().from(TABLE).where(w -> {
			w.eq("product_type", product_type);
			w.eq("valid_ind", "Y");
			w.op("st_date", "<=", findDate);
			w.op("up_date", ">=", findDate);
		}).count();
	}
}
