package cn.com.agree.huanan.ap.al.csitrd.amgt.dao;

import java.util.Map;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CardBoxInfoDaoImp implements CardBoxInfoDao {
	public final Logger logger = Logger.getLogger(CardBoxInfoDaoImp.class);
	private static String TABLE = "csis_aums_dev_cardboxinfo";
	@Autowired
	OrmOperator ormOper;
	@Autowired
	DbOperator dbo;


	// 卡箱数减1
	@Override
	public int updateTakeCard(Map<String, Object> card) {
		
		//更新卡箱记录
		int count = dbo.getUpdater().update(TABLE).where(
				new Consumer<WhereExp>(){
					public void accept(WhereExp w) {
						w.eq("devid", card.get("devid"));
						w.eq("cardboxnum", card.get("cardboxnum"));
						w.eq("boxtype", card.get("boxtype"));
						w.op("strtnum", "<=", card.get("card"));
						w.op("endnum", ">=", card.get("card"));
					};
				}
			).set("totnum", SqlUtil.getSqlExp("totnum - 1")).execute();
		
		return count;
	}


	@Override
	public Map<String, Object> selectTakeCard(Map<String, Object> card) {
		//封装查询参数
		String[] selectList = new String[] {
				"devId as devId",
				"boxType as boxType",
				"cardBoxNum as cardBoxNum",
				"cardType as cardType",
				"cardPhotoPath as cardPhotoPath",
				"cardName as cardName",
				"cardDesc  as cardDesc",
				"totNum as totNum",
				"oriTotNum as oriTotNum",
				"strtNum as strtNum",
				"endNum as endNum",
				"rsv1 as rsv1",
				"rsv2 as rsv2",
				"rsv3 as rsv3"
		}; 
		
		Map<String, Object> map = dbo.getSelecter().select(selectList).from(TABLE).where(
										new Consumer<WhereExp>(){
											public void accept(WhereExp w) {
												w.eq("devid", card.get("devid"));
												w.eq("cardboxnum", card.get("cardboxnum"));
												w.eq("boxtype", card.get("boxtype"));
												w.op("strtnum", "<=", card.get("card"));
												w.op("endnum", ">=", card.get("card"));
											};
										}
									).fetchOne();
		return map;
	}


	

}
