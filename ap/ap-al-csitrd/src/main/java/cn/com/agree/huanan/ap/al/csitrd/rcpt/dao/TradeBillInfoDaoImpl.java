package cn.com.agree.huanan.ap.al.csitrd.rcpt.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Component
public class TradeBillInfoDaoImpl implements TradeBillInfoDao{
	private static String TABLE = "tradeinfo_bill";
	@Autowired
	DbOperator dbo;
	@Autowired OrmOperator  ormOper;
	@Autowired
	Logger logger;
	@Override
	public int insertTradeBillInfo(TradeBillInfo tradeBillInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(TradeBillInfo.getMap(tradeBillInfo)).execute();
		return count;
	}
          
	
	
	
	@Override
	public int updateTradeBillInfo(Map<String, Object> map) {
	
		// 检验参数
		if (StringUtils.isEmpty(map)) {
			throw new ApIllegalParamException("map");
		}
		for(Map.Entry<String, Object> entry:map.entrySet()) {
			String key=entry.getKey();
			Object value=entry.getValue();
			logger.info("key="+key+"--------------------value="+value);
		}
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			if(map.containsKey("bill"))
				w.eq("bill", map.get("bill"));
			if(map.containsKey("serialNo"))
				w.eq("serialNo", map.get("serialNo"));
		}).set(map).execute();
		return count;
	}

	@Override
	public TradeBillInfo queryMainTradeBillInfoByBill(String bill) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {

			@Override
			public void accept(WhereExp w) {
				// TODO 自动生成的方法存根
				if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
					w.eq("bill", bill);
				}
				w.eq("mainflag", "0");
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"tradeDate as tradeDate",
				"serialNo as serialNo",
				"serveCodeOut as serveCodeOut",
				"sceneCodeOut as sceneCodeOut",
				"sceneCode as sceneCode",
				"serveCode as serveCode",
				"scrSysId as scrSysId",
				"scrCalCod as scrCalCod",
				"golSeqNo as golSeqNo",
				"tellerNo as tellerNo",
				"myBank as myBank",
				"authTellerNo as authTellerNo",
				"brNo as brNo",
				"updDate as updDate",
				"updTime as updTime",
				"bill as bill",
				"billType as billType",
				"status as status",
				"tranname as tranname",
				"mainFlag as mainFlag",
				"ielecData as ielecData",
				"oelecData as oelecData",
				"BizSerialNo as BizSerialNo"
		};
		Map<String, Object> map = dbo.getSelecter()
				.select(selectList)
				.from(TABLE)
				.where(whereExp)
				.fetchOne();
		TradeBillInfo billInfo=TradeBillInfo.getInstance(map);
		return billInfo;
	}


	@Override
	public HashMap<String, Object> selectTradeBillInfo(Map<String, String> map) throws SQLException, IOException {
		//拼接查询条件参数
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				
					if (!StringUtils.isEmpty(map.get("bill"))&&!"".equals(map.get("bill"))) {
						w.eq("bill", map.get("bill"));
					}
					if (!StringUtils.isEmpty(map.get("ScrCalCod"))&&!"".equals(map.get("ScrCalCod"))) {
						w.eq("ScrCalCod", map.get("ScrCalCod"));
					}
					if (!StringUtils.isEmpty(map.get("mainFlag"))&&!"".equals(map.get("mainFlag"))) {
						w.eq("mainFlag", map.get("mainFlag"));
					}
					if (!StringUtils.isEmpty(map.get("trantype"))&&!"".equals(map.get("trantype"))) {
						String trantype=map.get("trantype");
						String serveCodeOut=trantype.substring(0,10);
						String sceneCodeOut=trantype.substring(10);
						w.eq("serveCodeOut", serveCodeOut);
						w.eq("sceneCodeOut", sceneCodeOut);
					}
					if (!StringUtils.isEmpty(map.get("tellerNo"))&&!"".equals(map.get("tellerNo"))) {
						w.eq("tellerNo", map.get("tellerNo"));
					}
					if (!StringUtils.isEmpty(map.get("status"))&&!"".equals(map.get("status"))) {
						String status=map.get("status");
						//无单据状态
						if(status.equals("03"))
							w.eq("status", "01");
						else if(status.equals("01"))
							w.eq("status", "05");
						else {
							List list=new ArrayList<>();
							list.add("02");
							list.add("03");
							list.add("04");
							list.add("06");
							w.in("status",list);
						}
					}
					if((!StringUtils.isEmpty(map.get("begdate")))&(!StringUtils.isEmpty(map.get("endate")))) {
						w.between("tradeDate", map.get("begdate"), map.get("endate"));
					}
					if((StringUtils.isEmpty(map.get("begdate")))&(!StringUtils.isEmpty(map.get("endate")))) {
						w.op("tradeDate", "<=", map.get("endate"));
					}
					if((!StringUtils.isEmpty(map.get("begdate")))&(StringUtils.isEmpty(map.get("endate")))) {
						w.op("tradeDate", ">=", map.get("begdate"));
					}
						
				};
		};
		//查找字段
		String[] selectList = new String[] {
				"tradeDate as tradedate",
				"serialNo as serialno",
				"scrSysId  as scrsysid",
				"golSeqNo as golseqno",
				"tellerNo as tellerno",
				"myBank as mybank",
				"brNo as brno",
				"authTellerNo as authtellerno",
				"bill as bill",
				"billType as billtype",
				"status as status",
				"tranname as tranname",
				"ielecData as BillJson",
		};
		
		//查询总记录数
		long rowcnt = dbo.getSelecter()
							.select()
							.from(TABLE)
							.where(whereExp)
							.count();
		//按页码查询
	    int startPage = Integer.parseInt(map.get("pageflag"));
	    int pageSize = Integer.parseInt(map.get("maxnum"));
		//查询返回数量
	    Selecter selecter = dbo.getSelecter()
								.select(selectList)
								.from(TABLE)
								.where(whereExp);
	    //分页查询
	    IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage, pageSize);

	    //数据中Clob类型转String，重新封装list
	    List<HashMap<String, Object>> billList = new ArrayList<HashMap<String, Object>>();
	    List<Map<String, Object>> iPageList = iPage.getRecords();
	    for(Map<String, Object> iPageMap : iPageList) {
	    	HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    	hashmap.putAll(iPageMap);
	    	Clob clob = (Clob) hashmap.get("BillJson");
	    	String BillJsonStr = ClobToString(clob);	//Clob类型转String
	    	hashmap.put("BillJson", BillJsonStr);
	    	billList.add(hashmap);
	    }
	    //创建返回数据对象
	    HashMap<String, Object> resultMap = new HashMap<String, Object>();	
	    resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("bill_list", billList);// 返回数据
		return resultMap;
	}
	
	/**
	 * Clob类型转String
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String ClobToString(Clob clob) throws SQLException,IOException{
		String reString = "";
		Reader is = clob.getCharacterStream();	//得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while(s != null) {	//执行循环将字符串全部取出赋值给StringBuffer由StringBuffer转成String
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		if(br != null) {
			br.close();
		}
		if(is != null) {
			is.close();
		}
		return reString;
	}

}
