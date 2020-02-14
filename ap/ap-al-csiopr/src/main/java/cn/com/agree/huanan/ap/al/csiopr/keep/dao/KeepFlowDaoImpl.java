package cn.com.agree.huanan.ap.al.csiopr.keep.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.keep.po.KeepFlow;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class KeepFlowDaoImpl implements KeepFlowDao{
	
	private static String CSIS_KEEP_FLOW = "csis_keep_flow";
	public final Logger logger = Logger.getLogger(KeepFlowDaoImpl.class);
	
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	/**
	 * 登记代保管物品交接流水表
	 * */
	public int insertKeepFlow(KeepFlow keepFlow) {
		int count = dbo.getInserter().insertInto(CSIS_KEEP_FLOW).values(KeepFlow.getMap(keepFlow)).execute();
		return count ;
	}
	
	/**
	 * 查询保管物品交接流水表
	 * */
	public IPage<Map<String, Object>> getKeepFlowList(String pageflag, String maxnum, String keepno){
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(keepno)) {
					w.eq("KEEPNO", keepno);
				}
			};
		};
		
		String[] selectList = new String[] {
				"serino as serino",
				"keepno as keepno",
				"keeptype as keeptype",
				"keepnum as keepnum",
				"unit as unit", //代保管品状态
				"chgdate as chgdate",
				"chgtlrno  as chgtlrno",
				"chgname as chgname",
				"rcvtlrno as rcvtlrno",
				"rcvtlrname as rcvtlrname",
				"branchno as branchno"
		}; 
		
		Selecter selecter = dbo.getSelecter()
				.select(selectList)
				.from(CSIS_KEEP_FLOW)
				.where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(Integer.parseInt(pageflag),Integer.parseInt(maxnum));
		
		return iPage;
	}
	
}
