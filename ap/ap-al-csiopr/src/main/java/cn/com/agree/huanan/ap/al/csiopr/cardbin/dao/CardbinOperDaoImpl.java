package cn.com.agree.huanan.ap.al.csiopr.cardbin.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinDetail;
import cn.com.agree.huanan.ap.al.csiopr.cardbin.po.CardbinOper;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CardbinOperDaoImpl implements CardbinOperDao{
	private static String TABLE="csis_crd_bin_oper";
	private static String TABLE1="csis_crdbin_batimport";
	public final Logger logger = Logger.getLogger(CardbinOperDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	//根据cardbin和审批状态获取卡bin审批信息
	public CardbinOper FindCardbinOperByCardbin(String cardbin,String audStatus) {
		logger.info("获取卡bin审批信息开始");
		OrmSelecter<CardbinOper> ormSelecter = ormOper.getOrmSelecter(CardbinOper.class);
		CardbinOper cardbinOper=ormSelecter.where(w ->{
			w.setCardbin(cardbin);
			w.setAudStatus(audStatus);
		}).fetchOne();
		logger.info("获取卡bin审批信息结束");
		return cardbinOper;
	}

	@Override
	//插入卡bin信息到审批表中
	public int insertCardbinToOper(CardbinOper cardbinOper) {
		logger.info("插入卡bin信息到审批表开始");
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(CardbinOper.getMap(cardbinOper)).execute();
		dbo.commit();
		logger.info("插入卡bin信息到审批表结束");
		return count;
	}
	
	//查询获取卡bin变更审批信息列表
	@Override
	public Map<String, Object> getCardbinOperList(String pageFlag, String maxNum, String cardbin, String beginDate, String endDate,
			String optType, String bankCode, String audStatus) {
		// 查询总记录数
	    long rowcnt = dbo.getSelecter().from(TABLE).where(w -> {
	    	//查询条件
			if (!StringUtils.isEmpty(cardbin)&&!"".equals(cardbin)) {
				w.eq("cardbin", cardbin);
			}
			if (!StringUtils.isEmpty(optType)&&!"".equals(optType)) {
				w.eq("optType", optType);
			}
			if (!StringUtils.isEmpty(bankCode)&&!"".equals(bankCode)) {
				w.eq("bankCode", bankCode);
			}
			if (!StringUtils.isEmpty(audStatus)&&!"".equals(audStatus)) {
				w.eq("audStatus", audStatus);
			}
			if(!StringUtils.isEmpty(beginDate)&&!"".equals(beginDate)) {
				w.op("crtdate", ">=", beginDate);
			}
			if(!StringUtils.isEmpty(endDate)&&!"".equals(endDate)) {
				w.op("crtdate", "<=", endDate);
			}
			w.op("optType", "!=", "3");
			}).count();

	    //按页码查询
	    int startPage = Integer.parseInt(pageFlag);
	    int pageSize = Integer.parseInt(maxNum);
	    // 查询返回记录
		Selecter selecter = dbo.getSelecter().select(
				"serino","opttype","cardbin","cardtype","cardbinstbyte",
				"cardbintrack","chgflag","bankcode","bankname","cardname",
				"amtflag","posflag","trackno","trackstbyte","tracklen",
				"cardstbyte","cardlen","cardno","cardtrack","crtdate",
				"crttime","crtbrno","crttlr","audate","audtime",
				"audbrno","audtlr","audstatus","audremarks" ).from(TABLE).where(w ->{
				if (!StringUtils.isEmpty(cardbin)&&!"".equals(cardbin)) {
					w.eq("cardbin", cardbin);
				}
				if (!StringUtils.isEmpty(optType)&&!"".equals(optType)) {
					w.eq("optType", optType);
				}
				if (!StringUtils.isEmpty(bankCode)&&!"".equals(bankCode)) {
					w.eq("bankCode", bankCode);
				}
				if (!StringUtils.isEmpty(audStatus)&&!"".equals(audStatus)) {
					w.eq("audStatus", audStatus);
				}
				if(!StringUtils.isEmpty(beginDate)&&!"".equals(beginDate)) {
					w.op("crtdate", ">=", beginDate);
				}
				if(!StringUtils.isEmpty(endDate)&&"".equals(endDate)) {
					w.op("crtdate", "<=", endDate);
				}
				w.op("optType", "!=", "3");
		}).orderBy("serino asc");
		
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage,pageSize);						
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("oper_list", iPage.getRecords());// 返回数据
		return resultMap;
	}

	//根据流水号查询卡bin审批信息
	@Override
	public CardbinOper getCardbinOperStatus(String seriNo) {
		logger.info("获取卡bin审批信息开始");
		OrmSelecter<CardbinOper> ormSelecter = ormOper.getOrmSelecter(CardbinOper.class);
		CardbinOper cardbinOper=ormSelecter.where(w ->{
			w.setSeriNo(seriNo);
		}).fetchOne();
		logger.info("获取卡bin审批信息结束");
		return cardbinOper;
	}

	//更新审批表中的数据
	@Override
	public int doUpdateCardbinOper(CardbinOper cardbinOper) {
		int count=dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("serino", cardbinOper.getSeriNo());
			}).set(CardbinOper.getMap(cardbinOper)).execute();
		return count;
	}

	//查询获取卡bin批量导入信息列表
	@Override
	public Map<String, Object> getCardbinMulOperList(String pageFlag, String maxNum, String cardbin, String beginDate,
			String endDate, String audStatus) {
		// 查询总记录数
	    long rowcnt = dbo.getSelecter().from(TABLE).where(w -> {
	    	//查询条件
	    	if (!StringUtils.isEmpty(cardbin)) {
	    		w.eq("cardbin", cardbin);
	    	}
	    	if (!StringUtils.isEmpty(audStatus)) {
	    		w.eq("audStatus", audStatus);
	    	}
			if (!StringUtils.isEmpty(beginDate)) {
				w.op("beginDate",">=", beginDate);
			}
			if (!StringUtils.isEmpty(endDate)) {
				w.op("endDate","<=", endDate);
			}
			w.op("opttype", "=", "3");
			}).count();
	    // 查询返回记录
	    //按页码查询
	    int startPage = Integer.parseInt(pageFlag);
	    int pageSize = Integer.parseInt(maxNum);
		Selecter selecter = dbo.getSelecter().select(
				"serino","opttype","tot_num","filename","crtdate",
				"crttime","crtbrno","crttlr","audate","audtime",
				"audbrno","audtlr","audstatus","audremarks" ).from(TABLE).where(w ->{
			   	if (!StringUtils.isEmpty(cardbin)) {
			   		w.eq("cardbin", cardbin);
			   	}
		    	if (!StringUtils.isEmpty(audStatus)) {
		    		w.eq("audStatus", audStatus);
		    	}
				if (!StringUtils.isEmpty(beginDate)) {
					w.op("beginDate",">=", beginDate);
				}
				if (!StringUtils.isEmpty(endDate)) {
					w.op("endDate","<=", endDate);
				}
				w.op("opttype", "=", "3");
		}).orderBy("serino asc");
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage,pageSize);						
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("oper_list", iPage.getRecords());// 返回数据
		return resultMap;
	}

	//查询卡bin批量导入明细信息
	@Override
	public Map<String, Object> findCardMulDetailInfo(String pageflag, String maxNum, String audSeriNo) {

		// 查询总记录数
	    long rowcnt = dbo.getSelecter().from(TABLE1).where(w -> {
	    	if (!StringUtils.isEmpty(audSeriNo)) {
	    		w.eq("audSeriNo", audSeriNo);
	    	}
			}).count();
	    // 查询返回记录
	    int startPage = Integer.parseInt(pageflag);
	    int pageSize = Integer.parseInt(maxNum);
		Selecter selecter = dbo.getSelecter().select(
				"serino","audserino","cardbin","cardtype",
				"cardbinstbyte","crdbinlen","cardbintrack","chgflag","bankcode",
				"bankname","cardname","amtflag","posflag",
				"trackno","trackstbyte","tracklen","cardstbyte",
				"cardlen","cardno","cardtrack").from(TABLE1).where(w ->{
				if (!StringUtils.isEmpty(audSeriNo)) {
					w.eq("audSeriNo", audSeriNo);
				}
	
		}).orderBy("audSeriNo asc");
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage,pageSize);						
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("cardbin_list", iPage.getRecords());// 返回数据
		return resultMap;
	}

	
	@Override
	public CardbinOper getCardbinOperInfo(String serino) {
		OrmSelecter<CardbinOper> ormSelecter = ormOper.getOrmSelecter(CardbinOper.class);
		CardbinOper cardbinOper=ormSelecter.where(w ->{
			w.setSeriNo(serino);
		}).fetchOne();
		return cardbinOper;
	}

	@Override
	public List<Map<String, Object>> getCardbinDetailList(String serino) {
		List<Map<String, Object>> fetchAll = dbo.getSelecter().select("cardbin","cardtype",
				"cardbinstbyte","crdbinlen","cardbintrack","chgflag","bankcode",
				"bankname","cardname","amtflag","posflag",
				"trackno","trackstbyte","tracklen","cardstbyte",
				"cardlen","cardno","cardtrack").from(TABLE1).where(w ->{
					w.eq("audserino", serino);
				}).fetchAll();
		return fetchAll;
	}
}
