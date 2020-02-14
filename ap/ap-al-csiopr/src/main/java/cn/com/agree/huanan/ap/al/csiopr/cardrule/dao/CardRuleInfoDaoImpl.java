package cn.com.agree.huanan.ap.al.csiopr.cardrule.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CardRuleInfoDaoImpl implements CardRuleInfoDao{
	private static String TABLE="csis_crd_rule";
	public final Logger logger = Logger.getLogger(CardRuleInfoDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public CardRuleInfo findCardRuleInfo(String cardtype) {
		logger.info("获取行内卡规则信息开始");
		OrmSelecter<CardRuleInfo> ormSelecter = ormOper.getOrmSelecter(CardRuleInfo.class);
		CardRuleInfo cardRuleOper=ormSelecter.where(w ->{
			w.setCardType(cardtype);
		}).fetchOne();
		logger.info("获取行内卡规则信息结束");
		return cardRuleOper;
	}

	@Override
	public IPage<Map<String, Object>> findCardRuleList(String pageflag, String maxnum, String cardtype, String cardname) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(cardtype)&&!"".equals(cardtype)) {
					w.eq("cardtype", cardtype);
				}
				if (!StringUtils.isEmpty(cardname)&&!"".equals(cardname)) {
					w.eq("cardname", cardname);
				}
			};
		};
		int curPage=Integer.parseInt(pageflag);
		int pageSize=Integer.parseInt(maxnum);
	    String[] selectList= new String[]{"cardtype","cardname","cardlen","featcode1",
				"featpos1","featlen1","featcode2","featpos2",
				"featlen2","featcode3","featpos3","featlen3",
				"featcode4","featpos4","featlen4","featcode5",
				"featpos5","featlen5"};
	    Selecter selecter= dbo.getSelecter().select(selectList).from(TABLE).where(whereExp).orderBy("cardtype asc");
	    IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}

	@Override
	public int insertCardRule(CardRuleInfo cardRuleMap) {
		int count = dbo.getInserter().insertInto(TABLE).values(CardRuleInfo.getMap(cardRuleMap)).execute();
		return count;
	}

	@Override
	public int updateCardRule(CardRuleInfo cardRuleMap) {
		String cardType=cardRuleMap.getCardType();
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			if(!StringUtils.isEmpty(cardType)&&!"".equals(cardType)) {
				w.eq("cardtype", cardType);
			}
		}).set(CardRuleInfo.getMap(cardRuleMap)).execute();
		return count;
	}

	@Override
	public int deleteCardRule(String cardType) {
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w ->{
			if(!StringUtils.isEmpty(cardType)&&!"".equals(cardType)) {
				w.eq("cardtype", cardType);
			}
		}).execute();
		return count;
	}
}
