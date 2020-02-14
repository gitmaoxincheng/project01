package cn.com.agree.huanan.ap.al.csiopr.swalcard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.SwalCard;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class SwalCardDaoImpl implements SwalCardDao{
	private static String TABLE="csis_swall_card";
	private static String TABLE1="csis_branch";
	private static String TABLE2="csis_holiday";
	public final Logger logger = Logger.getLogger(SwalCardDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	/**
	 * 吞没卡信息录入
	 * @param swalCard 吞没卡信息
	 * @return 操作状态
	 * @author jiangzf
	 */
	@Override
	public int insertSwalCard(SwalCard swalCard) {
		int count = dbo.getInserter().insertInto(TABLE).values(SwalCard.getMap(swalCard)).execute();
		return count;
	}
	
	/**
	 * 柜员吞没卡调出  
	 * @param swalCard 吞没卡信息
	 */
	@Override
	public int saveSwalCard(SwalCard swalCard) {
		//参数校验
		if(StringUtils.isEmpty(swalCard.getSerialNo())) {
			throw new ApIllegalParamException("缺少流水号");
		}
		//更新
		int count = dbo.getUpdater().set(SwalCard.getMap(swalCard)).update(TABLE)
				    .where((w)->{
				    	w.eq("serialno", swalCard.getSerialNo());
				    }).execute();	
		return count;
	}
	
	
	/**
	 * 柜员吞没卡调入
	 */
	@Override
	public int callinSwalCardupdate(Map<String ,Object> map,List<String> list) {
		int count =dbo.getUpdater().update(TABLE).where(w ->{ w.in("serialno", list);}).set(map).execute();
		return count;
	}

    /**
     * 柜员吞没卡作废上缴信息更新
     */
	@Override
	public int turninSwalCardupdate(Map<String, Object> map, List<String> serialno_list) {
		int count =dbo.getUpdater().update(TABLE).where(w ->{w.in("serialno", serialno_list);}).set(map).execute();
		return count;
	}

    /**
     * 柜员吞没卡作废接收信息更新
     *  @author Maoxc
     */
	@Override
	public int updateSwalCard(Map<String, Object> map, JavaList serialno) {
		int count =dbo.getUpdater().update(TABLE).where(w ->{w.in("serialno", serialno);}).set(map).execute();
	   return count;
	}
	  
	/**
	 * 吞没卡作废接收查询
	 * @author Maoxc
	 */
	@Override
	public Map<String, Object> selectRecordSwalCard( Map<String, Object> paramMap){
		logger.info("DAO层的入参paramMap:"+paramMap);
	    //获取值
		int  pageFlag =  Integer.valueOf((String) paramMap.get("pageflag")) ;
		int  pageSize =  Integer.valueOf((String) paramMap.get("pagesize")) ;
		String  keepbranch = (String) paramMap.get("keepbranch");
		// 检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}
		// 查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(keepbranch)) {
					w.eq("t1.keepbranch", keepbranch);
				}
				w.eq("t1.status", "01");
			};
		};
		// 查询条件
		String[] tables = new String[] { "csis_swall_card t1" };
		String selectString = "t1.serialno as serialno,t1.recordbranch as recordbranch,t1.keepbranch as keepbranch,"
				+ "t1.keeptellerno as keeptellerno,t1.swalldate as swalldate,t1.recoardtype as recoardtype,"
				+ "t1.swalltime as swalltime,t1.banktype as banktype,t1.cardtype as cardtype,"
				+ "t1.card as card,t1.cardname as cardname,t1.status as status,"
				+ "t1.devno as devno,t1.devname as devname,t1.devbranch as devbranch,"
				+ "t1.recordtellerno as recordtellerno,t1.checkinfo as checkinfo,t1.remarks as remarks,"
				+ "t1.reciidtype as reciidtype,t1.reciidno as reciidno,t1.reciname as reciname,"
				+ "t1.turndate as turndate,t1.recvdate as recvdate,t1.outdate as outdate,"
				+ "t1.indate as indate,t1.inbranch as inbranch";
		
		Selecter selecter = dbo.getSelecter().from(tables).select(selectString.split(",")).where(whereExp).orderBy("swalldate desc","swalltime desc");
		
		// 获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag, pageSize);
		long total = iPage.getTotal();// 总笔数
		long size =  iPage.getSize();// 返回记录数
		List<Map<String, Object>> records =  iPage.getRecords();// 返回数据
		
		// 整数倍时，超过页数，返回记录数为0。前端根据“返回记录数<每页页数”判断是否能下一页。
		if(total%pageSize == 0 && total/pageSize<pageFlag) {
			size = 0;
			records = null;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt",total);
		resultMap.put("listnm", size);
		resultMap.put("card_list", records);// 返回数据	
		logger.info("DAO层的返回结果resultMap:"+resultMap);
		return resultMap;
			
	}
	
	/**
	 * 吞没卡作废上缴查询
	 * @author Maoxc
	 */
	@Override
	public Map<String, Object> selectUpSwalCard( Map<String, Object> paramMap){
		logger.info("DAO层的入参paramMap:"+paramMap);
		 //获取值
		int  pageFlag =  Integer.valueOf((String) paramMap.get("pageflag")) ;
		int  pageSize =  Integer.valueOf((String) paramMap.get("pagesize")) ;
		String  turndate = (String) paramMap.get("turndate");	
		String  keepbranch = (String) paramMap.get("keepbranch");	
		logger.info("--DAO_turndate--"+turndate);
		// 检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}else if (StringUtils.isEmpty(turndate)) {
			throw new ApIllegalParamException("turndate");
		}else if (StringUtils.isEmpty(keepbranch)) {
			throw new ApIllegalParamException("keepbranch");
		}	
		// 查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.op("t1.swalldate", "<=", turndate);//日期为吞卡日期，不是上缴日期
				w.eq("t1.status", "00");
				w.eq("t1.keepbranch", keepbranch);//保管机构号
			};
		};
		// 查询条件
		String[] tables = new String[] { "csis_swall_card t1" };
		String selectString = "t1.serialno as serialno,t1.recordbranch as recordbranch,t1.keepbranch as keepbranch,"
				+ "t1.keeptellerno as keeptellerno,t1.swalldate as swalldate,t1.recoardtype as recoardtype,"
				+ "t1.swalltime as swalltime,t1.banktype as banktype,t1.cardtype as cardtype,"
				+ "t1.card as card,t1.cardname as cardname,t1.status as status,"
				+ "t1.devno as devno,t1.devname as devname,t1.devbranch as devbranch,"
				+ "t1.recordtellerno as recordtellerno,t1.checkinfo as checkinfo,t1.remarks as remarks,"
				+ "t1.reciidtype as reciidtype,t1.reciidno as reciidno,t1.reciname as reciname,"
				+ "t1.turndate as turndate,t1.recvdate as recvdate,t1.outdate as outdate,"
				+ "t1.indate as indate,t1.inbranch as inbranch";	
		Selecter selecter = dbo.getSelecter().from(tables).select(selectString.split(",")).where(whereExp).orderBy("swalldate desc","swalltime desc");	
		// 获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag, pageSize);
		long total = iPage.getTotal();// 总笔数
		long size =  iPage.getSize();// 返回记录数
		List<Map<String, Object>> records =  iPage.getRecords();// 返回数据
		
		// 整数倍时，超过页数，返回记录数为0。前端根据“返回记录数<每页页数”判断是否能下一页。
		if(total%pageSize == 0 && total/pageSize<pageFlag) {
			size = 0;
			records = null;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt",total);
		resultMap.put("listnm", size);
		resultMap.put("card_list", records);// 返回数据	
		logger.info("DAO层的返回结果resultMap:"+resultMap);
		return resultMap;			
	}
	
	/**
	 * 吞没卡作废调入查询
	 * @author Maoxc
	 */
	@Override
	public Map<String, Object> selectIntSwalCard( Map<String, Object> paramMap){
		logger.info("DAO层的入参paramMap:"+paramMap);
		//获取值
		int  pageFlag =  Integer.valueOf((String) paramMap.get("pageflag")) ;
		int  pageSize =  Integer.valueOf((String) paramMap.get("pagesize")) ;
		String  outdate = (String) paramMap.get("outdate");
		String  outbranch = (String) paramMap.get("outbranch");
		String  inbranch = (String) paramMap.get("inbranch");
		// 检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}
		// 查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(outdate)) {
					w.eq("t1.outdate", outdate);
				}
				if (!StringUtils.isEmpty(outbranch)) {
					w.eq("t1.outbranch", outbranch);
				}
				w.eq("t1.inbranch", inbranch);
				w.eq("t1.status", 03);
			};
		};
		String[] tables = new String[] { "csis_swall_card t1" };
		String selectString = "t1.serialno as serialno,t1.recordbranch as recordbranch,t1.keepbranch as keepbranch,"
				+ "t1.keeptellerno as keeptellerno,t1.swalldate as swalldate,t1.recoardtype as recoardtype,"
				+ "t1.swalltime as swalltime,t1.banktype as banktype,t1.cardtype as cardtype,"
				+ "t1.card as card,t1.cardname as cardname,t1.status as status,"
				+ "t1.devno as devno,t1.devname as devname,t1.devbranch as devbranch,"
				+ "t1.recordtellerno as recordtellerno,t1.checkinfo as checkinfo,t1.remarks as remarks,"
				+ "t1.reciidtype as reciidtype,t1.reciidno as reciidno,t1.reciname as reciname,"
				+ "t1.turndate as turndate,t1.recvdate as recvdate,t1.outdate as outdate,"
				+ "t1.indate as indate,t1.inbranch as inbranch";		
		Selecter selecter = dbo.getSelecter().from(tables).select(selectString.split(",")).where(whereExp).orderBy("swalldate desc","swalltime desc");		
		// 获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag, pageSize);
		long total = iPage.getTotal();// 总笔数
		long size =  iPage.getSize();// 返回记录数
		List<Map<String, Object>> records =  iPage.getRecords();// 返回数据
		
		// 整数倍时，超过页数，返回记录数为0。前端根据“返回记录数<每页页数”判断是否能下一页。
		if(total%pageSize == 0 && total/pageSize<pageFlag) {
			size = 0;
			records = null;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt",total);
		resultMap.put("listnm", size);
		resultMap.put("card_list", records);// 返回数据	
		logger.info("DAO层的返回结果resultMap:"+resultMap);
		return resultMap;		
	}
	
	
	/**
     *  吞没卡信息查询
     *  @author Maoxc
     */
	@Override
	public Map<String, Object> querySwalCard(Map<String, Object> paramMap,List listBranch){
		logger.info("DAO层的入参paramMap:"+paramMap);
		logger.info("DAO层的入参listBranch:"+listBranch);
		//获取参数
		int  pageFlag =  Integer.valueOf((String) paramMap.get("pageflag")) ;
		int  pageSize =  Integer.valueOf((String) paramMap.get("pagesize")) ;	
		String swalldatestr = (String) paramMap.get("swalldatestr");
		String swalldateend = (String) paramMap.get("swalldateend");
		String recvdatestr = (String) paramMap.get("recvdatestr");
		String recvdateend = (String) paramMap.get("recvdateend");		
		String  card = (String) paramMap.get("card");
		String  devno = (String) paramMap.get("devno");
		String  recordtellerno = (String) paramMap.get("recordtellerno");
		String  strstatus = (String) paramMap.get("strstatus");
		String  strbranch = (String) paramMap.get("strbranch");
		//校验
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}    		
		// 查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(swalldatestr)) {
					w.op("swalldate", ">=", swalldatestr);
				}
				if (!StringUtils.isEmpty(swalldateend)) {
					w.op("swalldate", "<=", swalldateend);
				}
				if (!StringUtils.isEmpty(recvdatestr)) {
					w.op("recvdate", ">=", recvdatestr);
				}
				if (!StringUtils.isEmpty(recvdateend)) {
					w.op("recvdate", "<=", recvdateend);
				}				
				if (!StringUtils.isEmpty(card)) {
					w.eq("t1.card", card);
				}
				if (!StringUtils.isEmpty(devno)) {
					w.eq("t1.devno", devno);
				}
				if (!StringUtils.isEmpty(recordtellerno)) {
					w.eq("t1.recordtellerno", recordtellerno);
				}			
				if(!StringUtils.isEmpty(strstatus)) {
					w.eq("t1.status", strstatus);
				}
				if(listBranch != null) {
					w.in("t1.keepbranch", listBranch);
				}
			};
		};
		String[] tables = new String[] { "csis_swall_card t1" };
		String selectString = "t1.serialno as serialno,t1.recordbranch as recordbranch,t1.keepbranch as keepbranch,"
				+ "t1.keeptellerno as keeptellerno,t1.swalldate as swalldate,t1.recoardtype as recoardtype,"
				+ "t1.swalltime as swalltime,t1.banktype as banktype,t1.cardtype as cardtype,"
				+ "t1.card as card,t1.cardname as cardname,t1.status as status,"
				+ "t1.devno as devno,t1.devname as devname,t1.devbranch as devbranch,"
				+ "t1.recordtellerno as recordtellerno,t1.checkinfo as checkinfo,t1.remarks as remarks,"
				+ "t1.reciidtype as reciidtype,t1.reciidno as reciidno,t1.reciname as reciname,"
				+ "t1.turndate as turndate,t1.recvdate as recvdate,t1.outdate as outdate,"
				+ "t1.indate as indate,t1.inbranch as inbranch,t1.outlrno as outlrno,t1.outbranch as outbranch";	
		Selecter selecter = dbo.getSelecter().from(tables).select(selectString.split(",")).where(whereExp).orderBy("swalldate desc","swalltime desc");	
		// 获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag, pageSize);
		long total = iPage.getTotal();// 总笔数
		long size =  iPage.getSize();// 返回记录数
		List<Map<String, Object>> records =  iPage.getRecords();// 返回数据
		
		// 整数倍时，超过页数，返回记录数为0。前端根据“返回记录数<每页页数”判断是否能下一页。
		if(total%pageSize == 0 && total/pageSize<pageFlag) {
			size = 0;
			records = null;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rowcnt",total);
		resultMap.put("listnm", size);
		resultMap.put("card_list", records);// 返回数据	
		logger.info("DAO层的返回结果resultMap:"+resultMap);
		return resultMap;
	}
	 
	
	/**
	 * 查询机构号及其下属机构
     * @author Maoxc
	 */
	@Override
	public IPage<Map<String, Object>> selectBranchInfo(int curPage, int pageSize, String strBrNo) {
		if (StringUtils.isEmpty(curPage)) {
			throw new ApIllegalParamException("pageFlag");
		} else if (pageSize < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		} 
		final  String orderColum = "BRNO";
		String sql = "";
		sql += (" start with brno=" + strBrNo + " connect by prior brno=upbrno");
		Selecter selecter = dbo.getSelecter().select("BRNO as strbrno").from(TABLE1+sql).orderBy(orderColum);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}
	
	
	/**
	 * 根据流水号查询吞没
	 */
	@Override
	public SwalCard selectSwalCardBySerialno(String serialno) {
		logger.info("-----开始查询数据-----");
		// 检验参数
		if (StringUtils.isEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");
		}
		OrmSelecter<SwalCard> ormSelecter = ormOper.getOrmSelecter(SwalCard.class);
		SwalCard chlAuth = ormSelecter.where(w -> {
			w.setSerialNo(serialno);
		}).fetchOne();
		logger.info("-----结束查询数据-----");
		return chlAuth;
	}
	
	
	/**
	 * 更新吞没卡状态
	 * @author Maoxc
	 */
	@Override
	public int updateSwalCard(Map<String, Object> updateMap){
		if (StringUtils.isEmpty(updateMap.get("serialno"))) {
			throw new ApIllegalParamException("serialno");
		}
		if (StringUtils.isEmpty(updateMap.get("status"))) {
			throw new ApIllegalParamException("status");
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("serialno", updateMap.get("serialno"));}).set(updateMap).execute();
		return count;
	}

	@Override
	public Map<String,Object> queryOutBranch(String serialno) {
		Map<String,Object> outBranch=dbo.getSelecter().from(TABLE).select("outbranch").where(w->{
			w.eq("serialno",serialno);
		}).fetchOne();
		
		return outBranch;
	}

	@Override
	public long querySerialno(String serialno) {
		long count=dbo.getSelecter().from(TABLE).where(w->{
			w.eq("serialno",serialno);
		}).count();
		return count;
	}

	@Override
	public Map<String,Object> checkTellerNo(String serialno) {
		Map<String,Object> keeptellerno =dbo.getSelecter().from(TABLE).select("keeptellerno","keepbranch","status","outbranch","outlrno").where(w->{
			w.eq("serialno", serialno);
		}).fetchOne();
		return keeptellerno;
	}

	@Override
	public int updateSwalCard(String status,SwalCard data) {
		// TODO 自动生成的方法存根
		
		if (StringUtils.isEmpty(data.getDevNo()) || StringUtils.isEmpty(data.getCard())) {
			throw new ApIllegalParamException("卡号或设备号为空");
		}
		
		int count = dbo.getUpdater().update(TABLE).set("status",status).where((w)->{
			w.eq("card",data.getCard());
			w.eq("status",data.getStatus());
			w.eq("devno",data.getDevNo());
			w.eq("recoardtype",data.getRecoardType());
		}).execute();
		
		return count;
	}

	@Override
	public IPage<Map<String, Object>> selectHoliday(String timeDay) {
		Selecter selecter = dbo.getSelecter().select("count(*)").from(TABLE2).where(w->{
			w.eq("workDate", timeDay);
		});
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(1,10);	
		return iPage;
	}

}
