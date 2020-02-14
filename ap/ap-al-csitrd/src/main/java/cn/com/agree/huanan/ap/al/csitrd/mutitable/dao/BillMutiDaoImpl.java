package cn.com.agree.huanan.ap.al.csitrd.mutitable.dao;

import java.sql.Clob;
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
@Component
public class BillMutiDaoImpl implements BillMutiDao{
	private static String TABLE = "tradeinfo_bill";
	@Autowired
	DbOperator dbo;
	@Autowired 
	OrmOperator  ormOper;
	@Autowired 
	Logger logger;

	@Override
	public HashMap<String, Object> selectTradeBillInfo(Map<String, String> map) {
			//连接单据表
			Consumer<WhereExp> onExp1 = new Consumer<WhereExp>() {
				@Override
				public void accept(WhereExp w) {
					w.eq("t1.bill", SqlUtil.getSqlExp("t2.bill"));
				}
			};
			//拼接查询条件参数
			Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
				@Override
				public void accept(WhereExp w) {
						if (!StringUtils.isEmpty(map.get("bill"))&&!"".equals(map.get("bill"))) {
							w.eq("t1.bill", map.get("bill"));
						}
						if (!StringUtils.isEmpty(map.get("reqsysid"))&&!"".equals(map.get("reqsysid"))) {
							w.eq("t2.ScrSysid", map.get("reqsysid"));
						}
						if (!StringUtils.isEmpty(map.get("serialno"))&&!"".equals(map.get("serialno"))) {
							w.eq("t1.serialno", map.get("serialno"));
						}
						w.eq("t2.mainFlag", map.get("mainFlag"));
						if (!StringUtils.isEmpty(map.get("tellerNo"))&&!"".equals(map.get("tellerNo"))) {
							w.eq("t1.tlrno", map.get("tellerNo"));
						}
						//交易状态判断
						if (!StringUtils.isEmpty(map.get("transtatus"))&&!"".equals(map.get("transtatus"))) {
							w.eq("t1.status",map.get("transtatus"));
						}else {
							//如果为空
							List list=new ArrayList<>();
							list.add("01");
							list.add("02");
							w.in("t1.status",list);
						}
						//单据状态判断
						if (!StringUtils.isEmpty(map.get("billstatus"))&&!"".equals(map.get("billstatus"))) {
							String status=map.get("billstatus");
							//签名成功
							if(status.equals("1"))
								w.eq("t2.status", "05");
							else if(status.equals("0")){
								//未签名
								List list=new ArrayList<>();
								list.add("02");
								list.add("03");
								list.add("04");
								list.add("06");
								w.in("t2.status",list);
							}
						}else {
							//如果为空
							List list=new ArrayList<>();
							list.add("02");
							list.add("03");
							list.add("04");
							list.add("05");
							list.add("06");
							w.in("t2.status",list);
						}
						//时间判断
						if((!StringUtils.isEmpty(map.get("begdate")))&(!StringUtils.isEmpty(map.get("endate")))) {
							w.between("t1.tradeDate", map.get("begdate"), map.get("endate"));
						}
						if((StringUtils.isEmpty(map.get("begdate")))&(!StringUtils.isEmpty(map.get("endate")))) {
							w.op("t1.tradeDate", "<=", map.get("endate"));
						}
						if((!StringUtils.isEmpty(map.get("begdate")))&(StringUtils.isEmpty(map.get("endate")))) {
							w.op("t1.tradeDate", ">=", map.get("begdate"));
						}
						//客户名称
						if (!StringUtils.isEmpty(map.get("acctname"))&&!"".equals(map.get("acctname"))) {
							w.op("t1.acctname", "like","%"+map.get("acctname")+"%");
						}	
					};
		};
		//查找字段
		String[] tables= new String[] {"tradeinfo_bill_sub t1", "tradeinfo_bill t2"};
		String[] selectList = new String[] {
				"t1.tradeDate as tradedate",
				"t1.serialno as serialno",
				"t1.tlrno as tellerno",
				"t1.authTlrno as authtellerno",
				"t1.bill as bill",
				"t1.tranType as trantype",
				"t1.tranname as tranname",
				"t1.status as transtatus",
				"t1.acctname as acctname",
				"t2.scrSysId  as scrsysid",
				"t2.myBank as mybank",
				"t2.brNo as brno",
				"t2.status as billstatus",
				"t2.BizSerialNo as BizSerialNo"
		};
		Selecter selecter = dbo.getSelecter()
				.select(selectList)
				.from(tables[0])
				.join(JoinType.InnerJoin, tables[1], onExp1)
				.where(whereExp)
				.orderBy("t1.bill")
				.orderBy("t1.serialno");
		//查询总记录数
		long rowcnt =selecter.count();
		//按页码查询
	    int startPage = Integer.parseInt(map.get("pageflag"));
	    int pageSize = Integer.parseInt(map.get("maxnum"));
	    //分页查询
	    IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage, pageSize);
	    //创建返回数据对象
	    HashMap<String, Object> resultMap = new HashMap<String, Object>();	
	    resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		for(Map<String,Object> billMap:iPage.getRecords()) {
			Map<String, Object> hashmap = new HashMap<String, Object>();
	    	hashmap.putAll(billMap);
			if(billMap.get("billstatus").equals("05"))
				hashmap.put("billstatus", "1");
			else
			    hashmap.put("billstatus", "0");
			list.add(hashmap);
		}
		resultMap.put("bill_list", list);// 返回数据
		return resultMap;
	}

}
