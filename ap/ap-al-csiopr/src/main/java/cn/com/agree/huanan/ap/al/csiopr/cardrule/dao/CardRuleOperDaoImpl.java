package cn.com.agree.huanan.ap.al.csiopr.cardrule.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinOper;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleOper;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CardRuleOperDaoImpl implements CardRuleOperDao {
	private static String TABLE="csis_crd_rule_oper";
	public final Logger logger = Logger.getLogger(CardRuleOperDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public int findCardRuleOperInfo(String cardtype, String audstatus) {
		long count = dbo.getSelecter().from(TABLE).where(w ->{
			w.eq("cardtype", cardtype);
			w.eq("audstatus", audstatus);
		}).count();
		return (int)count;
	}

	@Override
	public int insertCardRuleToOper(Map<String, Object> map) {
		int count = 0;
		if(map.size() != 0) {
			count = dbo.getInserter().insertInto(TABLE).values(map).execute();
		}
		return count;
	}

	@Override
	public Map<String, Object> findCardRuleOperList(Map<String, Object> map) {
		String pageflag= (String) map.get("pageflag");
		String maxnum = (String) map.get("maxnum");
		String cardtype = (String) map.get("cardtype");
		String audstatus = (String) map.get("audstatus");
		String opttype = (String) map.get("opttype");
		String begindate = (String) map.get("begindate");
		String enddate = (String) map.get("enddate");
		//查询总记录数
	    long rowcnt = dbo.getSelecter().from(TABLE).where(w -> {
	    	//查询条件
			if (!StringUtils.isEmpty(cardtype)&&!"".equals(cardtype)) {
				w.eq("cardtype", cardtype);
			}
			if (!StringUtils.isEmpty(audstatus)&&!"".equals(audstatus)) {
				w.eq("audstatus", audstatus);
			}
			if (!StringUtils.isEmpty(opttype)&&!"".equals(opttype)) {
				w.eq("opttype", opttype);
			}
			if (!StringUtils.isEmpty(begindate)&&!"".equals(begindate)) {
				w.op("crtdate", ">=", begindate);
			}
			if (!StringUtils.isEmpty(enddate)&&!"".equals(enddate)) {
				w.op("crtdate", "<=", enddate);
			}	
			}).count();
	    //按页码查询
	    int startPage = Integer.parseInt(pageflag);
	    int pageSize = Integer.parseInt(maxnum);
/*	    if(((startPage-1)*pageSize+1)>=(int)rowcnt) {
	    	logger.info("没有对应的数据");
	    	throw new CheckNotDataException("没有对应的数据");
	    }*/
	    Selecter selecter  = dbo.getSelecter().select("serino","opttype","cardtype","cardname","cardlen","featcode1",
			"featpos1","featlen1","featcode2","featpos2",
			"featlen2","featcode3","featpos3","featlen3",
			"featcode4","featpos4","featlen4","featcode5",
			"featpos5","featlen5","crtdate","crttime",
			"crtbrno","crttlr","audate","audtime",
			"audbrno","audtlr","audstatus","audremarks").from(TABLE).where(w ->{
				if (!StringUtils.isEmpty(cardtype)&&!"".equals(cardtype)) {
					w.eq("cardtype", cardtype);
				}
				if (!StringUtils.isEmpty(audstatus)&&!"".equals(audstatus)) {
					w.eq("audstatus", audstatus);
				}
				if (!StringUtils.isEmpty(opttype)&&!"".equals(opttype)) {
					w.eq("opttype", opttype);
				}
				if (!StringUtils.isEmpty(begindate)&&!"".equals(begindate)) {
					w.op("crtdate", ">=", begindate);
				}
				if (!StringUtils.isEmpty(enddate)&&!"".equals(enddate)) {
					w.op("crtdate", "<=", enddate);
				}	
			}).orderBy("serino asc");
	  //获取返回数量
	  IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage,pageSize);						
	  Map<String, Object> resultMap = new HashMap<String, Object>();		
	  resultMap.put("rowcnt", iPage.getTotal());// 总笔数
	  resultMap.put("listnm", iPage.getSize());// 返回记录数
	  resultMap.put("oper_list", iPage.getRecords());// 返回数据
	  return resultMap;	
	}

	@Override
	public CardRuleOper checkCardRuleOper(String serino) {
		logger.info("获取行内卡规则审批信息开始");
		OrmSelecter<CardRuleOper> ormSelecter = ormOper.getOrmSelecter(CardRuleOper.class);
		CardRuleOper cardRuleOper=ormSelecter.where(w ->{
			w.setSeriNo(serino);
		}).fetchOne();
		logger.info("获取行内卡规则审批信息结束");
		return cardRuleOper;
	}

	@Override
	public int updateCardRuleOper(Map<String,Object> map) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("SERINO", map.get("serino"));}).set(map).execute();
		return count;
	}
}
