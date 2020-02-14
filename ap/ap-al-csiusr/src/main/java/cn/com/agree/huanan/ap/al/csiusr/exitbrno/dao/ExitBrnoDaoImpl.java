package cn.com.agree.huanan.ap.al.csiusr.exitbrno.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.exitbrno.po.ExitBrno;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.DbUtil;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Component
public class ExitBrnoDaoImpl implements ExitBrnoDao{

	private static String TABLE1="csis_exitbrno";
    public final Logger logger = Logger.getLogger(ExitBrnoDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbConnection  dbConnection;
    @Autowired DbOperator dbo;
	
	@Override
	public List<ExitBrno> queryExitBrNoByDate(String tradeDate,String brno) {
		OrmSelecter<ExitBrno> ormSelecter = ormOper.getOrmSelecter(ExitBrno.class);
    	List<ExitBrno> list = ormSelecter.where(w ->{
    		w.setTradeDate(tradeDate);
    		w.setBrno(brno);
    	}).fetchAll();
    	return list;
	}

	@Override
	public int updateExitBrNoInfo(String strBrNo, String tradeDate, String sysId, Map<String, Object> paramMap) {
		
		if (StringUtils.isEmpty(strBrNo))
			throw new ApIllegalParamException("strBrNo");	
		
		if (StringUtils.isEmpty(tradeDate))
			throw new ApIllegalParamException("tradeDate");	
		
		if (StringUtils.isEmpty(sysId))
			throw new ApIllegalParamException("sysId");	
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("brNo", strBrNo);
			w.eq("tradeDate", tradeDate);
			w.eq("sysId", sysId);
		}).set(paramMap).execute();
		
		return count;
	}
	
	@Override
	public int updateInfo(ExitBrno exitBrno) {
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			if (!StringUtils.isEmpty(exitBrno.getTradeDate())) {
				w.eq("tradedate", exitBrno.getTradeDate());
			}
			if (!StringUtils.isEmpty(exitBrno.getBrno())) {
				w.eq("brno", exitBrno.getBrno());
			}
			if (!StringUtils.isEmpty(exitBrno.getSysId())) {
				w.eq("sysid", exitBrno.getSysId());
			}
		}).set("status",exitBrno.getStatus()).execute();
		
		return count;
	}

	@Override
	public int insertExitBrnoInfo(ExitBrno exitBrno) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(ExitBrno.getMap(exitBrno)).execute();
		return count;
	}

	@Override
	public Map<String, Object> selectBranchExitInfo(String brNo, int pageSize, int pageFlag, String logBrNo) {
		
		final  String orderColum = "ae.brno,ae.status DESC";
		// final  String[] groupby = {"ae.brno","ae.tradedate"};
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.op("ae.brno", "like", logBrNo.substring(0, 3) + "%");
				 w.eq("ae.tradedate", DateTimeUtil.getSysDate());
				 if (!StringUtils.isEmpty(brNo))
					w.eq("ae.brno", brNo);
			};
		};
		
		Consumer<WhereExp> whereExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("cb.brno", SqlUtil.getSqlExp("ae.brno"));
				};
		};
		
		String[] tables = new String[] {"csis_exitbrno ae"};
		String[] selectList = new String[] {"distinct ae.tradedate as tradedate",
											"ae.brno as strbrno",
											"cb.brnas as branchname",
											"cb.dutyna as dutyna",
											"cb.dutyph as branchphone",
											"ae.status as sysstatus"};
//				"(select cb.brnas from csis_branch cb where cb.brno = ae.brno) as branchname",
//				"(select cb.dutyna from csis_branch cb where cb.brno = ae.brno) as dutyna",
//				"(select cb.dutyph from csis_branch cb where cb.brno = ae.brno) as branchphone",
//				"(select distinct ce.status from csis_exitbrno ce where ce.brno = ae.brno and ce.tradedate = ae.tradedate and ce.status = '1') as syssts1",
//				"(select distinct ce.status from csis_exitbrno ce where ce.brno = ae.brno and ce.tradedate = ae.tradedate and ce.status = '0') as syssts2"};
		Selecter selecter = dbo.getSelecter()
						 .from(tables[0])
						 .join(JoinType.LeftJoin, "csis_branch cb", whereExp1)
						 .select(selectList)
						 .where(whereExp);
						 // .groupBy(groupby);
		
		List<String> columns = new ArrayList<>();
		columns.add("countBrno");
		String countSql = "select count(1) from (select t.brno from csis_exitbrno t where t.tradedate = '"
							+ DateTimeUtil.getSysDate() + "'" + " and t.brno like '" + logBrNo.substring(0, 3) + "%'";
		if (!StringUtils.isEmpty(brNo))
			countSql += "and t.brno = '" + brNo + "'";
		countSql += " group by t.brno,t.tradedate) t";
		List<Map<String,Object>> result = DbUtil.transferDbMaps(columns, dbConnection.query(countSql));

		Map<String,Object> countMap = result.get(0);
		Integer brnoCount = Integer.parseInt(String.valueOf(countMap.get("countBrno")));
		
		List<Map<String, Object>> backList = new ArrayList<Map<String,Object>>();

		if ((pageFlag - 1) *  pageSize < brnoCount) {
			backList = selecter.orderBy(orderColum).fetch((pageFlag - 1) *  pageSize,pageSize);
		}
		
		
		//获取返回数量
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<>();
		list.addAll(backList);
		String lastBrNo = "";
		for (int i = 0; i < list.size(); i++) {
			if (lastBrNo.equals(list.get(i).get("strbrno")) && "0".equals(list.get(i).get("sysstatus"))) {
				list.remove(i);
				i--;
			}
			lastBrNo = (String)(list.get(i).get("strbrno"));
		}
//			for (Map<String, Object> map : list) {
//				Map<String, Object> tmpMap = new HashMap<>();				
//				for (Map.Entry<String, Object> entry : map.entrySet()) {
//					
//					if ("syssts1".equalsIgnoreCase(entry.getKey())) {
//						String string1 = String.valueOf(map.get("syssts1"));
//						String string2 = String.valueOf(map.get("syssts2"));
//						
//						if (!StringUtils.isEmpty(string1)) {
//							tmpMap.put("sysstatus", "0");
//						}else {
//							if (StringUtils.isEmpty(string2)) {
//								tmpMap.put("sysstatus", "0");
//							}else {
//								tmpMap.put("sysstatus", "1");
//							}
//						}						
//						
//					}else if ("syssts2".equalsIgnoreCase(entry.getKey())) {
//						continue;
//					}else {
//						tmpMap.put(entry.getKey(), entry.getValue());
//					}
//				}				
//				backList.add(tmpMap);
//			}
		  resultMap.put("rowcnt", brnoCount);// 总笔数
		  resultMap.put("listnm", list.size());// 返回记录数
		  resultMap.put("bodrcd_list", list);// 返回数据
		  return resultMap;
	}

	

}
