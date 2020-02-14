package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 机构模块多表查询
 * @author lixq
 *
 */
@Component
public class BranchMutiDaoImpl implements BranchMutiDao{

	public final Logger logger = Logger.getLogger(BranchMutiDaoImpl.class);
	@Autowired DbOperator dbo;
	
	@Override
	public Map<String, Object> selectBranchExitInfo( String brNo,String idxBrno, int pageSize, int pageFlag) {			
		
		final  String orderColum = "ae.brno";
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
	
				 if (!StringUtils.isEmpty(brNo))
					w.eq("ae.brno", brNo);
				 w.eq("ae.tradedate", DateTimeUtil.getSysDate());
				 w.eq("ae.status", "1");
				 w.eq("ae.brno", SqlUtil.getSqlExp("ab.brno"));
				};
		};
		String[] tables = new String[] {"csis_exitbrno ae","csis_branch ab"};
		String[] selectList = new String[] {
				"ae.tradedate as tradedate","ae.brno as strbrno","ae.syscname as syscname","ae.status as sysstatus",
				"ab.brnas as branchname","ab.dutyna as dutyna","ab.dutyph as branchphone"};
		Selecter selecter = dbo.getSelecter().from(tables)
						 .select(selectList)
						 .where(whereExp);
		//获取返回数量
		  IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag,pageSize);						
		  Map<String, Object> resultMap = new HashMap<String, Object>();		
		  resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		  resultMap.put("listnm", iPage.getSize());// 返回记录数
		  resultMap.put("bodrcd_list", iPage.getRecords());// 返回数据
		  return resultMap;
	}

}
