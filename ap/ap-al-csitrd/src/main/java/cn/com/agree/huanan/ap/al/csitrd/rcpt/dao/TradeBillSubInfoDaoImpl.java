package cn.com.agree.huanan.ap.al.csitrd.rcpt.dao;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;

import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.ConvertBothClobToString;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillImageInfo;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillInfo;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillSubInfo;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Component
public  class TradeBillSubInfoDaoImpl implements TradeBillSubInfoDao{
	private static String TABLE = "tradeinfo_bill_sub";
	@Autowired
	DbOperator dbo;
	@Autowired OrmOperator  ormOper;
	@Autowired
	private DictDao dictDao;
	@Override
	public int insertTradeBillInfo(TradeBillSubInfo tradeBillSubInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(TradeBillSubInfo.getMap(tradeBillSubInfo)).execute();
		return count;
	}

	@Override
	public int updateTradeBillSubInfo(Map<String, Object> map) {
		// 检验参数
		if (StringUtils.isEmpty(map)) {
			throw new ApIllegalParamException("map");
		}
		
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("bill", map.get("bill"));
		w.eq("tranType", map.get("tranType"));}).set(map).execute();
		return count;
	}

	@Override
	public List<Map<String, Object>> queryTradeBillSubInfos(String bill) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
					w.eq("bill", bill);
				}
				List list=new ArrayList<>();
				list.add("01");
				list.add("02");
				w.in("status",list);
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"tradeDate as tradeDate",
				"serialNo as serialNo",
				"tranType as tranType",
				"serveCode as serveCode",
				"sceneCode as sceneCode",
				"updTime as updTime",
				"updDate as updDate",
				"bill as bill",
				"status as status",
				"tranname as tranname",
				"brno as brno",
				"tlrno as tlrno",
				"authTlrno as authTlrno",
				"vochType as vochType",
				"vochNo as vochNo",
				"amount as amount",
				"acctno as acctno",
				"acctname as acctname",
				"oppAcctno as oppAcctno",
				"oppAcctname as oppAcctname",
				"remarks as remarks",
				"ielecData as ielecData",
				"mainSerialNo as mainSerialNo",
				"myBank as myBank",
				"txCcy as txCcy"
		};
		//查询返回数据
		List<Map<String, Object>> maps = dbo.getSelecter()
									.select(selectList)
									.from(TABLE)
									.where(whereExp)
									.fetchAll();
		List<Map<String, Object>> infos=new ArrayList<Map<String,Object>>();
		for(Map map:maps) {
			Map<String, Object> temp=new HashMap<String, Object>();
			temp.putAll(map);
			try {
				temp.put("ielecData", ConvertBothClobToString.ClobToString((Clob) map.get("ielecData")));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			infos.add(temp);
		}
		return infos;
	}

	@Override
	public List<Map<String, Object>> selectBillSubInfo(String bill) {
		//拼接查询条件参数
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {

			@Override
			public void accept(WhereExp w) {
				// TODO 自动生成的方法存根
				if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
					w.eq("bill", bill);
				}
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"tranType as trantype",
				"tradeDate as tradedate",
				"serialNo as serialno",
				"ielecData as SubBillJson"
		};
		//查询返回数据
		List<Map<String, Object>> billSubList = dbo.getSelecter()
													.select(selectList)
													.from(TABLE)
													.where(whereExp)
													.fetchAll();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		//获取交易名称
		Map<String,Object> name=dictDao.selectDict("rcpt");
		for(Map<String,Object> map:billSubList) {
			Map<String,Object> item=new HashMap<String, Object>();
			item.putAll(map);
			item.put("subtranname", name.get(map.get("trantype")));
			try {
				String billJson=ConvertBothClobToString.ClobToString((Clob) map.get("SubBillJson"));
				if(billJson==null)
					item.put("SubBillJson","");
				else
					item.put("SubBillJson",billJson);
			} catch (SQLException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();      
			}
			list.add(item);
		}
		return list;
	}

	@Override
	public TradeBillSubInfo selectBillSubInfoByBillAndType(String bill,String type) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				// TODO 自动生成的方法存根
				if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
					w.eq("bill", bill);
				}
				if(!StringUtils.isEmpty(type) && !"".equals(type)) {
					w.eq("tranType",type);
				}
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"tradeDate as tradeDate",
				"serialNo as serialNo",
				"tranType as tranType",
				"serveCode as serveCode",
				"sceneCode as sceneCode",
				"updTime as updTime",
				"updDate as updDate",
				"bill as bill",
				"status as status",
				"tranname as tranname",
				"brno as brno",
				"tlrno as tlrno",
				"authTlrno as authTlrno",
				"vochType as vochType",
				"vochNo as vochNo",
				"amount as amount",
				"acctno as acctno",
				"acctname as acctname",
				"oppAcctno as oppAcctno",
				"oppAcctname as oppAcctname",
				"remarks as remarks",
				"ielecData as ielecData",
				"mainSerialNo as mainSerialNo",
				"myBank as myBank",
				"txCcy as txCcy"
		};
		//查询返回数据
		Map<String, Object> map = dbo.getSelecter()
									.select(selectList)
									.from(TABLE)
									.where(whereExp)
									.fetchOne();
		TradeBillSubInfo billSubs=TradeBillSubInfo.getInstance(map);
		return billSubs;
	}

	@Override
	public List<Map<String, Object>> selectBillSubInfoDetail(String bill) {
		//拼接查询条件参数
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {

			@Override
			public void accept(WhereExp w) {
				// TODO 自动生成的方法存根
				if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
					w.eq("bill", bill);
				}
				List<String> list=new ArrayList<String>();
				list.add("01");
				list.add("02");
				w.in("status", list);
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"tranType as trantype",
				"tradeDate as tradedate",
				"serialNo as serialno",
				"ielecData as subbill",
				"status as subtranstatus",
				"tranname as tranname",
		};
		//查询返回数据
		List<Map<String, Object>> billSubList = dbo.getSelecter()
													.select(selectList)
													.from(TABLE)
													.where(whereExp).orderBy("serialNo")
													.fetchAll();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		//获取交易名称
		Map<String,Object> name=dictDao.selectDict("rcpt");
		for(Map<String,Object> map:billSubList) {
			Map<String,Object> item=new HashMap<String, Object>();
			item.putAll(map);
			try {
				String billJson=ConvertBothClobToString.ClobToString((Clob) map.get("subbill"));
				if(billJson.equals(""))
					item.put("subbill","");
				else {
					List<Map<String,Object>> textJ=(List<Map<String, Object>>) JSONArray.parse(billJson);	
					item.put("subbill",textJ);
				}
			} catch (SQLException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();      
			}
			list.add(item);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> queryBillSubInfosByStatus(String bill,String status) {
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
					w.eq("bill", bill);
					w.eq("status", status);
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"tradeDate as tradeDate",
				"serialNo as serialNo",
				"tranType as tranType",
				"serveCode as serveCode",
				"sceneCode as sceneCode",
				"bill as bill",
				"status as status",
				"tranname as tranname"
		};
		//查询返回数据
		List<Map<String, Object>> maps = dbo.getSelecter()
									.select(selectList)
									.from(TABLE)
									.where(whereExp)
									.fetchAll();
		return maps;
	}

}
