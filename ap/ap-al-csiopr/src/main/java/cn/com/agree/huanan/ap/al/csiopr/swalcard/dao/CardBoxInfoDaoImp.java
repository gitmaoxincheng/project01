package cn.com.agree.huanan.ap.al.csiopr.swalcard.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.CardBoxInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
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

	// 设备卡箱卡类型查询
	@Override
	public Map<String, Object> selectCardBoxInfo(Map<String, Object> paramMap) {
		logger.info("DAO层的入参paramMap:" + paramMap);
		// 获取值
		int pageFlag = Integer.valueOf((String) paramMap.get("pageflag"));
		int pageSize = Integer.valueOf((String) paramMap.get("pagesize"));
		String devid = (String) paramMap.get("devid");
		String cardboxnum = (String) paramMap.get("cardboxnum");
		String boxtype = (String) paramMap.get("boxtype");
		// 检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			throw new ApIllegalParamException("pageSize");
		} else if (StringUtils.isEmpty(devid)) {
			throw new ApIllegalParamException("devid");
		} else if (!StringUtils.isEmpty(devid)) {
			if (!"0".equals(boxtype) && !"1".equals(boxtype)) {
				throw new ApIllegalParamException("boxtype必须为0或者1");
			}
		}

		// 查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("t1.devid", devid);
				if (!StringUtils.isEmpty(cardboxnum)) {
					w.eq("t1.cardboxnum", cardboxnum);
				}
				if (!StringUtils.isEmpty(boxtype)) {
					w.eq("t1.boxtype", boxtype);
				}
			};
		};
		// 查询条件
		String[] tables = new String[] { "csis_aums_dev_cardboxinfo t1" };
		String selectString = "t1.devid as devid,t1.cardboxnum as cardboxnum,t1.boxtype as boxtype,"
				+ "t1.cardtype as cardtype,t1.totnum as totnum,t1.strtnum as strtnum,t1.oritotnum as oritotnum,"
				+ "t1.endnum as endnum,t1.cardphotopath as cardphotopath,t1.cardname as cardname,"
				+ "t1.carddesc as carddesc,t1.rsv1 as rsv1,t1.rsv2 as rsv2,t1.rsv3 as rsv3";

		Selecter selecter = dbo.getSelecter().from(tables).select(selectString.split(",")).where(whereExp);
		// 获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag, pageSize);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("box_list", iPage.getRecords());// 返回数据

		logger.info("DAO层的返回结果resultMap:" + resultMap);
		return resultMap;

	}

	// 根据ID查询
	@Override
	public CardBoxInfo selectCardBoxInfoById(String devid, String cardboxnum) {
		if (StringUtils.isEmpty(devid)) {
			throw new ApIllegalParamException("devid");
		}
		if (StringUtils.isEmpty(cardboxnum)) {
			throw new ApIllegalParamException("cardboxnum");
		}
		OrmSelecter<CardBoxInfo> ormSelecter = ormOper.getOrmSelecter(CardBoxInfo.class);
		CardBoxInfo cardBoxInfo = ormSelecter.where(w -> {
			w.setDevId(devid);
			w.setCardBoxNum(cardboxnum);
		}).fetchOne();
		return cardBoxInfo;
	}

	// 更新数据
	@Override
	public int updateCardBoxInfo(Map<String, Object> boxMap) {
		if (StringUtils.isEmpty(boxMap.get("devid"))) {
			throw new ApIllegalParamException("devid");
		}
		if (StringUtils.isEmpty(boxMap.get("cardboxnum"))) {
			throw new ApIllegalParamException("cardboxnum");
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("devid", boxMap.get("devid"));
			w.eq("cardboxnum", boxMap.get("cardboxnum"));
		}).set(boxMap).execute();
		return count;
	}

	// 卡箱数减1
	@Override
	public int updateTakeCard(Map<String, Object> card) {
		
		if (StringUtils.isEmpty(card.get("devid"))) {
			throw new ApIllegalParamException("devid");
		}
		if (StringUtils.isEmpty(card.get("cardboxnum"))) {
			throw new ApIllegalParamException("cardboxnum");
		}
		if (StringUtils.isEmpty(card.get("boxtype"))) {
			throw new ApIllegalParamException("boxtype");
		}
		if (StringUtils.isEmpty(card.get("card"))) {
			throw new ApIllegalParamException("card");
		}
		
		//更新卡箱记录
		int  count = dbo.getUpdater().update(TABLE).where(
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

}
