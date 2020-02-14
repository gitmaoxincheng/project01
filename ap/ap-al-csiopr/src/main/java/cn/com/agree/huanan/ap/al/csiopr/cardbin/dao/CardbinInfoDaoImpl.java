package cn.com.agree.huanan.ap.al.csiopr.cardbin.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CardbinInfoDaoImpl implements CardbinInfoDao{
	private static String TABLE="csis_crd_bin";
	public final Logger logger = Logger.getLogger(CardbinInfoDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	//根据cardbin获取卡bin信息
	public CardbinInfo FindCardbinInfoByCardbin(String cardbin) {
		logger.info("获取卡bin信息开始");
		OrmSelecter<CardbinInfo> ormSelecter = ormOper.getOrmSelecter(CardbinInfo.class);
		CardbinInfo cardbinInfo=ormSelecter.where(w ->{
			w.setCardbin(cardbin);
		}).fetchOne();
		logger.info("获取卡bin信息结束");
		return cardbinInfo;
	}

	@Override
	//获取卡bin信息列表
	public Map<String, Object> getCardbinInfoList(String pageFlag, String maxNum, String cardbin, String cardType, String bankCode,
			String bankName) {
			// 查询总记录数
		  long rowcnt = dbo.getSelecter().from(TABLE).where(w -> {
		    	//查询条件
				if (!StringUtils.isEmpty(cardbin)&&!"".equals(cardbin)) {
					w.eq("cardbin", cardbin);
				}
				if (!StringUtils.isEmpty(cardType)&&!"".equals(cardType)) {
					w.eq("cardType", cardType);
				}
				if (!StringUtils.isEmpty(bankCode)&&!"".equals(bankCode)) {
					w.eq("bankCode", bankCode);
				}
				if (!StringUtils.isEmpty(bankName)&&!"".equals(bankName)) {
					w.eq("bankName", bankName);
				}
				}).count();
		    //按页码查询
		    int startPage = Integer.parseInt(pageFlag);
		    int pageSize = Integer.parseInt(maxNum);
		    // 查询返回记录
			Selecter selecter = dbo.getSelecter().select(
					"cardbin" , "cardtype" ,   "cardbinstbyte","crdbinlen",    
					"cardbintrack", "chgflag",      "bankcode",     "bankname",    
					"cardname",     "amtflag",      "posflag",      "trackno",
					"trackstbyte",  "tracklen",     "cardstbyte",   "cardlen",      
					"cardno",  "cardtrack"  ).from(TABLE).where(w ->{
					if (!StringUtils.isEmpty(cardbin)&&!"".equals(cardbin)) {
						w.eq("cardbin", cardbin);
					}
					if (!StringUtils.isEmpty(cardType)&&!"".equals(cardType)) {
						w.eq("cardType", cardType);
					}
					if (!StringUtils.isEmpty(bankCode)&&!"".equals(bankCode)) {
						w.eq("bankCode", bankCode);
					}
					if (!StringUtils.isEmpty(bankName)&&!"".equals(bankName)) {
						w.eq("bankName", bankName);
					}
			}).orderBy("cardbin asc");
			
			//获取返回数量
			IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage,pageSize);						
			Map<String, Object> resultMap = new HashMap<String, Object>();		
			resultMap.put("rowcnt", iPage.getTotal());// 总笔数
			resultMap.put("listnm", iPage.getSize());// 返回记录数
			resultMap.put("chnl_list", iPage.getRecords());// 返回数据
			return resultMap;
	}
	
	//将审批表中的卡bin信息新增到卡bin信息表
	@Override
	public int insertCardbinInfo(CardbinInfo cardInfo) {
		logger.info("新增卡bin 开始");
		int count = dbo.getInserter().insertInto(TABLE).values(CardbinInfo.getMap(cardInfo)).execute();
		logger.info("新增卡bin 结束");
		return count;
	}
	
	//将审批表中的卡bin信息更新到卡bin信息表
	@Override
	public int updateCardbinInfo(CardbinInfo cardInfo) {
		logger.info("更新卡bin 开始");
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("cardbin", cardInfo.getCardbin());}).set(CardbinInfo.getMap(cardInfo)).execute();
		logger.info("更新卡bin 结束");
		return count;
	}

	//根据审批表中的cardbin信息删除卡bin信息
	@Override
	public int deleteCardbinInfo(String cardbin) {
		logger.info("删除卡bin 开始");
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("cardbin", cardbin);
		}).execute();
		logger.info("删除卡bin 结束");
		return count;
	}

	@Override
	public int deleteCardbinInfoAll() {
		logger.info("删除卡bin所有信息 开始");
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w ->{
			w.eq("1", "1");
		}).execute();
		return count;
		
	}

	
	@Override
	public int insertAllDetailToCardbin(Map map) {
		int count = dbo.getInserter().insertInto(TABLE).values(map).execute();
		return count;
	}
	
}
