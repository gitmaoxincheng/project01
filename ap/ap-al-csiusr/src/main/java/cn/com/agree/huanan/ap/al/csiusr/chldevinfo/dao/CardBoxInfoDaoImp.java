package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.CardBoxInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CardBoxInfoDaoImp implements  CardBoxInfoDao{
	public final Logger logger = Logger.getLogger(CardBoxInfoDaoImp.class);
	private static String TABLE="csis_aums_dev_cardboxinfo";
	@Autowired OrmOperator  ormOper;
	@Autowired DbOperator dbo;
	
	//设备卡箱卡类型查询
	@Override
	public Map<String, Object> selectCardBoxInfo(Map<String, Object> paramMap) {
		logger.info("DAO层selectCardBoxInfo方法的入参:"+paramMap);
	    //获取值
		int  pageFlag =  Integer.valueOf((String) paramMap.get("pageflag")) ;
		int  pageSize =  Integer.valueOf((String) paramMap.get("pagesize")) ;
		String  devid = (String) paramMap.get("devid");
		String  cardboxnum = (String) paramMap.get("cardboxnum");	
		String  boxtype = (String) paramMap.get("boxtype");
		// 检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			throw new ApIllegalParamException("pageSize");
		}else if (StringUtils.isEmpty(devid)) {
			throw new ApIllegalParamException("devid");
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
					if("9".equals(boxtype)) {
						w.in("t1.boxtype", "2","3","4");
					}else {
						w.eq("t1.boxtype", boxtype);
					}				
				}
			};
		};		
		// 查询的表与字段
		String[] tables = new String[] { "csis_aums_dev_cardboxinfo t1" };
		String selectString = "t1.devid as devid,t1.cardboxnum as cardboxnum,t1.boxtype as boxtype,"
				+ "t1.cardtype as cardtype,t1.totnum as totnum,t1.strtnum as strtnum,t1.oritotnum as oritotnum,"
				+ "t1.endnum as endnum,t1.cardphotopath as cardphotopath,t1.cardname as cardname,"
				+ "t1.carddesc as carddesc,t1.rsv1 as rsv1,t1.rsv2 as rsv2,t1.rsv3 as rsv3";	
		Selecter selecter = dbo.getSelecter().select(selectString.split(",")).from(tables).where(whereExp);	
		// 获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag, pageSize);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("box_list", iPage.getRecords());// 返回数据		
		logger.info("DAO层的返回结果resultMap:"+resultMap);
		return resultMap;
	}
    	
	//插入数据
	@Override
	public int insertCardBoxInfo(CardBoxInfo cardBoxInfo) {
		logger.info("DAO层insertCardBoxInfo方法的入参:"+cardBoxInfo);
		if (StringUtils.isEmpty(CardBoxInfo.getMap(cardBoxInfo))) {
			throw new ApIllegalParamException("cardBoxInfo");
		}
		int count = dbo.getInserter().insertInto(TABLE).values(CardBoxInfo.getMap(cardBoxInfo)).execute();
		logger.info("DAO层的返回结果count:"+count);
		return count;
	}
	
	// 删除数据
	@Override
	 public int deleteCardBoxInfo(Map<String, Object> deleteMap) {
		 logger.info("DAO层deleteCardBoxInfo方法的入参:"+deleteMap);
		 String devid = (String) deleteMap.get("devid");
		 String cardboxnum = (String) deleteMap.get("cardboxnum");
		 String boxtype = (String) deleteMap.get("boxtype");		 
		 //检验
		 if (StringUtils.isEmpty(devid)) {
			 throw new ApIllegalParamException("devid");	
		 }else if (StringUtils.isEmpty(cardboxnum)) {
			 throw new ApIllegalParamException("cardboxnum");	
		 }else if (StringUtils.isEmpty(boxtype)) {
			 throw new ApIllegalParamException("boxtype");	
		 }
		 // 删除
		 int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			             w.eq("devid", devid);// 设备id
			             w.eq("cardboxnum", cardboxnum);// 卡箱序列号
			             w.eq("boxtype", boxtype);// 卡箱类型		       
				      }).execute();
		 logger.info("DAO层的返回结果count:"+count); 
	     return count;
	 }
	
	// 卡箱库存修改
	@Override
	public int updateTakeCard(Map<String, Object> card, String optype) {
		String totnum = "";
		if("0".equals(optype)) {
			totnum = "totnum + "+card.get("totnum");
		}else if("1".equals(optype)) {
			totnum = "totnum - "+card.get("totnum");
		}
		//更新卡箱记录
		int count = dbo.getUpdater().update(TABLE).where(
				new Consumer<WhereExp>(){
					public void accept(WhereExp w) {
						w.eq("devid", card.get("devid"));
						w.eq("cardboxnum", card.get("cardboxnum"));
						w.eq("boxtype", card.get("boxtype"));
						w.op("strtnum", "<=", card.get("strtnum"));
						w.op("endnum", ">=", card.get("endnum"));
					};
				}
			).set("totnum", SqlUtil.getSqlExp(totnum)).execute();
		
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
												w.op("strtnum", "<=", card.get("strtnum"));
												w.op("endnum", ">=", card.get("endnum"));
											};
										}
									).fetchOne();
		return map;
	}

}
