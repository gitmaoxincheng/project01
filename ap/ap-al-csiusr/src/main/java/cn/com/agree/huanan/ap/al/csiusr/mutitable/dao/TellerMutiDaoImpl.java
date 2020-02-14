package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 柜员模块多表查询
 * @author HCP
 *
 */
@Component
public class TellerMutiDaoImpl implements TellerMutiDao{
	@Autowired OrmOperator  ormOper;
	public final Logger logger = Logger.getLogger(TellerMutiDaoImpl.class);
	@Autowired DbOperator dbo;
	
	public Map<String, Object> selectTellerDutyInfo(String tellerNo, String tellerType, String name, String brNo, int pageSize, int pageFlag, String devtype, String myBank, String userst){
		
		final  String orderColum = "t2.tellerno";
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("t2.myBank", myBank);
				 if (!StringUtils.isEmpty(tellerNo)) 
					w.eq("t2.tellerno", tellerNo);
				 if (!StringUtils.isEmpty(tellerType)) 
					w.eq("t2.tellertype", tellerType);
				 if (!StringUtils.isEmpty(name))
					w.eq("t2.name", name);
				 if (!StringUtils.isEmpty(brNo))
					w.eq("t2.brno", brNo);
				 if (!StringUtils.isEmpty(devtype))
					w.eq("t4.devtype", devtype);
				 if (!StringUtils.isEmpty(userst))
					w.eq("t2.loginstatus", userst);
				};
		};
		//String[] tables = new String[] {"csis_dutyinfo t1","csis_tellerinfo t2","csis_entduty t3"};
		Consumer<WhereExp> whereExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t2.tellerno ", SqlUtil.getSqlExp("t3.tellerno"));
				 w.eq("t2.brno ", SqlUtil.getSqlExp("t3.brno"));
				};
		};
		
		Consumer<WhereExp> whereExp2 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t3.dutyno ", SqlUtil.getSqlExp("t1.dutyno"));
				};
		};
		
		Consumer<WhereExp> whereExp3 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t4.devtellerno ", SqlUtil.getSqlExp("t2.tellerno"));
				};
		};
		
		Selecter selecter = dbo.getSelecter();
		if (!StringUtils.isEmpty(devtype)) {
			selecter.from("csis_channel_devinfo t4")
			.join(JoinType.LeftJoin, "csis_tellerinfo t2", whereExp3)
			.join(JoinType.LeftJoin, "csis_entduty t3", whereExp1)
			.join(JoinType.LeftJoin, "csis_dutyinfo t1", whereExp2); 
		} else {
			selecter.from("csis_tellerinfo t2")
			.join(JoinType.LeftJoin, "csis_entduty t3", whereExp1)
			.join(JoinType.LeftJoin, "csis_dutyinfo t1", whereExp2); 
		}
		String select = "t1.propty as realflag, t2.tellerno as usepid, t2.brno as qrbrch, t2.name as userna, t2.tellertype as usertp, t2.loginstatus as userst, t3.entdutyno as entdutyno,t3.entdutyname as entdutyname,t3.status as entdutystatus,t1.dutyno as dutyno,t1.dutyname as dutyname,t2.status as tellerstatus";
		if (!StringUtils.isEmpty(devtype)) {
			select += ",t4.devtype as devtype";
		}
		selecter.select(select.split(","))
		 .where(whereExp);
		
		long count = selecter.count();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		if ((pageFlag - 1) *  pageSize < count) {
			list = selecter.orderBy(orderColum).fetch((pageFlag - 1) *  pageSize,pageSize);
		}
		
//		List<Map<String, Object>> backList = new ArrayList<>();
//		for (Map<String, Object> map : list) {
//			
//			Map<String, Object> tmpMap = new HashMap<>();
//			for (Map.Entry<String, Object> entry : map.entrySet()) {
//				
//				if ("userst".equalsIgnoreCase(entry.getKey())) {
//					String string = String.valueOf(map.get("tellerstatus"));
//					if ("0".equals(string)) {
//						tmpMap.put(entry.getKey(), "2");
//					}else {
//						tmpMap.put(entry.getKey(), entry.getValue());
//					}
//					
//				}else if ("tellerstatus".equalsIgnoreCase(entry.getKey())) {
//					continue;
//				}else {
//					tmpMap.put(entry.getKey(), entry.getValue());
//				}
//			}
//			backList.add(tmpMap);
//		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("rowcnt", count);
		resultMap.put("listnm", list.size());
		resultMap.put("bodrcd_list", list);
		
		return resultMap;
	}

	@Override
	public Map<String, Object> selectTellerByTellerNo(String tellerNo){
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
	
					w.eq("t1.tellerno", tellerNo);
				};
		};
		Consumer<WhereExp> whereExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t1.tellerno ", SqlUtil.getSqlExp("t2.tellerno"));
				};
		};
		Consumer<WhereExp> whereExp2 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t2.tellerno ", SqlUtil.getSqlExp("t3.tellerno"));
				};
		};
		Consumer<WhereExp> whereExp3 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t3.dutyno ", SqlUtil.getSqlExp("t4.dutyno"));
				};
		};
		String[] selectList = new String[] {
				"t1.tellerno as usepid","t1.name as userna","t1.tellertype as usertp","t1.loginstatus as useronlinest",
				"t2.status as userstatus","t3.entdutyno as entdutyno","t3.entdutyname as entdutyname","t4.propty as realflag",
				"t4.dutyno as dutyno","t4.dutyname as dutyname"};
		Map<String, Object> resultMap = dbo.getSelecter()
				.from("csis_tellerinfo t1")
				.join(JoinType.LeftJoin, "csis_tellersys t2", whereExp1)
				.join(JoinType.LeftJoin, "csis_entduty t3", whereExp2)
				.join(JoinType.LeftJoin, "csis_dutyinfo t4", whereExp3)
				.select(selectList)
				.where(whereExp).fetchOne();
		

		return resultMap;
	}

	@Override
	public IPage<Map<String,Object>> selectTelrChaRecs(int curPage, int pageSize, String bgDate, String edDate,
			String strTellerNo, String transStatus, String brNo, String myBank) {
		List<String> transTypeList = new ArrayList<>();
		transTypeList.add("TELR0007");
		transTypeList.add("TELR0008");
		transTypeList.add("TELR0018");
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("tl.PLATCODE", SqlUtil.getSqlExp("se.PLATCODE"));
				 w.eq("tl.SVRCODE", SqlUtil.getSqlExp("se.SVRCODE"));
				};
		};
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(strTellerNo))
					w.eq("tl.CHGTELLERNO", strTellerNo);
				if (!StringUtils.isEmpty(transStatus))
					w.eq("tl.TRANSSTATUS", transStatus);
				if (!StringUtils.isEmpty(brNo))
					w.eq("tl.OPTBRNO", brNo);
				w.op("tl.OPTDATE", ">=", bgDate);
				w.op("tl.OPTDATE", "<=", edDate);
				w.in("tl.SVRCODE", transTypeList);
				w.op("tl.OPTBRNO", "like", myBank + "%");
			};
		};
		
		String[] tables = new String[] {"csis_tellerlog tl"
										//,"csis_service se"
										};
		String[] selectList = new String[] {"tl.SERIALNO as serialno","tl.OPTDATE as optdate","tl.OPTTIME as opttime","tl.OPTBRNO as optbrno",
				"tl.OPTTELLERNO as opttellerno","tl.ADJDATE as adjdate","tl.TRADENAME as svrname","tl.CHGTELLERNO as chgtellerno",
				"tl.CHGTELLERNOBRNO as chgtellernobrno","tl.CHGTELLERNONAME as chgtellernoname","tl.BFDATA0 as bfdata","tl.AFDATA0 as afdata",
				"tl.TRANSSTATUS as transstatus","tl.ERRORMSG as transmsg"};
		Selecter selecter = dbo.getSelecter()
						 .select(selectList)
						 .from(tables[0])
						 //.join(JoinType.LeftJoin, tables[1], onExp)
						 .where(whereExp)
						 .orderBy("tl.serialno")
						 .orderBy("tl.optdate");
		
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}
	
    /**
     * 柜员管理交易流水查询
     */
	@Override
	public IPage<Map<String,Object>> selectTelManTraSeri(int curPage, int pageSize, String bgDate, String edDate,
			String bgSerialNo, String edSerialNo, String strTellerNo, String brNo, String myBank) {
		List<String> transTypeList = new ArrayList<>();
		transTypeList.add("TELR0001");
		transTypeList.add("TELR0002");
		transTypeList.add("TELR0004");
		transTypeList.add("TELR0007");
		transTypeList.add("TELR0008");
		transTypeList.add("TELR0018");
		transTypeList.add("TELR0011");
		transTypeList.add("TELR0005");
		transTypeList.add("TELR0012");
		transTypeList.add("TELR0014");
		transTypeList.add("TELR0021");
		//条件
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("tl.PLATCODE", SqlUtil.getSqlExp("se.PLATCODE"));
				 w.eq("tl.SVRCODE", SqlUtil.getSqlExp("se.SVRCODE"));
				};
		};
		//条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(bgSerialNo))
					w.op("tl.SERIALNO", ">=", bgSerialNo);
				if (!StringUtils.isEmpty(edSerialNo))
					w.op("tl.SERIALNO", "<=", edSerialNo);
				if (!StringUtils.isEmpty(strTellerNo))
					w.eq("tl.OPTTELLERNO", strTellerNo);
				if (!StringUtils.isEmpty(brNo))
					w.eq("tl.OPTBRNO", brNo);
				w.op("tl.OPTDATE", ">=", bgDate);
				w.op("tl.OPTDATE", "<=", edDate);
				w.in("tl.SVRCODE", transTypeList);
				w.op("tl.OPTBRNO", "like", myBank + "%");
			};
		};
		//查询
		String[] tables = new String[] {"csis_tellerlog tl"
										//,"csis_service se"
										};
		String[] selectList = new String[] {"tl.SERIALNO as serialno","tl.OPTDATE as optdate","tl.OPTTIME as opttime","tl.OPTTELLERNO as opttellerno",
				"tl.AUTHTELLERNO as authtellerno","tl.TRADENAME as svrname","tl.CHGTELLERNO as strtellerno","tl.CHGTELLERNONAME as strtellernoname",
				"tl.OPTBRNO as strtbrno"};
		Selecter selecter = dbo.getSelecter()
						 .select(selectList)
						 .from(tables[0])
						 //.join(JoinType.LeftJoin, tables[1], onExp)
						 .where(whereExp)
						 .orderBy("tl.serialno")
						 .orderBy("tl.optdate");
		
		//返回
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);	
		return iPage;
	}

	@Override
	public Map<String, Object> queryMobTellerInfo(String tellerno, String brno) {

		
		final  String orderColum = "t4.menuno";
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
	
				 if (!StringUtils.isEmpty(tellerno)) 
					w.eq("t2.tellerno", tellerno);
				 if (!StringUtils.isEmpty(brno)) 
					w.eq("t2.brno", brno);
				};
		};
		//String[] tables = new String[] {"csis_dutyinfo t1","csis_tellerinfo t2","csis_entduty t3"};
		
		Consumer<WhereExp> whereExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t2.dutyno ", SqlUtil.getSqlExp("t3.dutyno"));
				};
		};
		
		Consumer<WhereExp> whereExp2 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t4.menuno ", SqlUtil.getSqlExp("t3.menuno"));
				};
		};
		String[] selectList = new String[] {
				"t2.entdutyno as entdutyno"," t4.menuno as menuno"," t4.menutype as menutype"," t4.menuparno as menuparno",
				" t4.menusort as menusort"," t4.menulevel as menulevel","t4.menuabtype as menuabtype",
				" t4.appid as appid"," t4.menuname as menuname"," t4.menuimg1 as menuimg1"," t4.menuimg2 as menuimg2",
				"t4.menudesc as menudesc"," t4.menustatus as menustatus"," t4.upddate as upddate","t4.updtime as updtime"};
		Selecter selecter = dbo.getSelecter().from("csis_entduty t2")
				.join(JoinType.LeftJoin, "csis_mobi_rol_menu t3", whereExp1)
				.join(JoinType.LeftJoin, "csis_mobi_menu t4", whereExp2)
				.select(selectList)
				.where(whereExp);

		long count = selecter.count();
		List<Map<String, Object>> list = selecter.orderBy(orderColum).fetchAll();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("rowcnt", count);
		resultMap.put("listnm", list.size());
		resultMap.put("convt_list", list);
		
		return resultMap;

	}

	@Override
	public Map<String, Object> queryLoginTellerList(String tellerno,String brno) {

		//final String orderColum = "a.tellerno";
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
	
				 if (!StringUtils.isEmpty(tellerno))
					w.eq("a.tellerno", tellerno);
				 if (!StringUtils.isEmpty(brno))
						w.eq("a.brno", brno);
				 w.eq("b.status", "1");
				 w.eq("a.brno", SqlUtil.getSqlExp("b.brno"));
				 w.eq("a.tellerno", SqlUtil.getSqlExp("b.tellerno"));
			};
		};
		String[] tables = new String[] {"csis_tellerinfo a","csis_entduty b"};
		String[] selectList = new String[] {
				"a.tellerno as tellerNo","a.zoneno as zoneNo","a.mbrno as mBrNo",
				"a.brno as brNo","a.name as name","a.tellertype as tellerType","a.mybank as myBank"};
		Selecter selecter = dbo.getSelecter().from(tables)
						 .select(selectList)
						 .where(whereExp);
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(1,100);	
		Map<String, Object> resultMap = new HashMap<String, Object>();	
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("list", iPage.getRecords());// 返回数据
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> queryTellerTypeList(String tradeDate, String brno, String status, String dutylevel) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 if (!StringUtils.isEmpty(tradeDate))
					w.eq("et.tradedate", tradeDate);
				 if (!StringUtils.isEmpty(brno))
					w.eq("et.brno", brno);
				 if (!StringUtils.isEmpty(status))
					w.eq("et.status", status);
				 if (!StringUtils.isEmpty(dutylevel))
					w.eq("du.dutylevel", dutylevel);
				 w.eq("du.type", "C");
				 w.eq("du.status", SqlUtil.getSqlExp("'1' or du.dutyno='000006'"));
			};
		};
		
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("et.dutyno", SqlUtil.getSqlExp("du.dutyno"));
			};
		};
		String[] tables = new String[] {"csis_exittellerno et","csis_dutyinfo du"};
		String[] selectList = new String[] {"et.tellerno as tellerno","et.brno as brno","et.status as status",
												"du.dutylevel as dutylevel","et.dutyno as dutyno"};
		List<Map<String, Object>> exitTellerNoList = dbo.getSelecter()
														.select(selectList)
														.from(tables[0])
														.join(JoinType.LeftJoin, tables[1], onExp)
														.groupBy("et.tellerno, et.brno, et.status , du.dutylevel, et.dutyno")
														.where(whereExp)
														.fetchAll();
								
		return exitTellerNoList;
	}
}
