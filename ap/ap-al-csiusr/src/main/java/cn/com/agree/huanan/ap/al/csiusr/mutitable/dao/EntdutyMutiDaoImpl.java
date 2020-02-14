package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 机构模块多表查询
 * @author heww
 *
 */
@Component
public class EntdutyMutiDaoImpl implements EntdutyMutiDao{

	public final Logger logger = Logger.getLogger(EntdutyMutiDaoImpl.class);
	@Autowired DbOperator dbo;
	

	@Override
	public List<Map<String, Object>> getUsnumbList(int pageFlag, int maxNum, String strZoneNo, String strMBrNo, String strBrNo,String strDutyNo) {

		final  String orderColum = "du.DUTYNO";
		
		String[] tables = new String[] {"csis_entduty en","csis_dutyinfo du"};
		
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("en.DUTYNO", SqlUtil.getSqlExp("du.DUTYNO"));
				w.eq("en.STATUS", "1");
			};
		};
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(strZoneNo)) {
					w.eq("en.ZONENO", strZoneNo);
				}
				if (!StringUtils.isEmpty(strMBrNo)) {
					w.eq("en.MBRNO", strMBrNo);
				}
				if (!StringUtils.isEmpty(strBrNo)) {
					w.eq("en.BRNO", strBrNo);
				}
				if (!StringUtils.isEmpty(strDutyNo)) {
					w.eq("en.DUTYNO", strDutyNo);
				}
			};
		};
		
		int start = (pageFlag - 1) * maxNum;
		
		List<Map<String, Object>> usnumbList = dbo.getSelecter()
												.select("du.DUTYNO as dutyno","count(en.ENTDUTYNO) as usnumb")
												.from(tables[0])
												.join(JoinType.RightJoin, tables[1], onExp)
												.where(whereExp)
												.groupBy("du.DUTYNO")
												.orderBy(orderColum+" asc")
												.fetch(start,maxNum);
		
		return usnumbList;
		
	}

	@Override
	public List<Map<String, Object>> getEntdutynumList(int pageFlag, int maxNum, String strZoneNo, String strMBrNo, String strBrNo,String strDutyNo) {

		final  String orderColum = "du.DUTYNO";
		
		String[] tables = new String[] {"csis_entduty en","csis_dutyinfo du"};
		
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("en.DUTYNO", SqlUtil.getSqlExp("du.DUTYNO"));
			};
		};

		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(strZoneNo)) {
					w.eq("en.ZONENO", strZoneNo);
				}
				if (!StringUtils.isEmpty(strMBrNo)) {
					w.eq("en.MBRNO", strMBrNo);
				}
				if (!StringUtils.isEmpty(strBrNo)) {
					w.eq("en.BRNO", strBrNo);
				}
				if (!StringUtils.isEmpty(strDutyNo)) {
					w.eq("en.DUTYNO", strDutyNo);
				}
			};
		};
		
		int start = (pageFlag - 1) * maxNum;
		
		List<Map<String, Object>> entdutynumList = dbo.getSelecter()
													 .select("du.DUTYNO as strdutyno","du.DUTYNAME as dutyname","count(en.ENTDUTYNO) as entdutynum")
													 .from(tables[0])
													 .join(JoinType.RightJoin, tables[1], onExp)
													 .groupBy("du.DUTYNO,du.DUTYNAME")
													 .where(whereExp)
													 .orderBy(orderColum+" asc")
													 .fetch(start,maxNum);
		
		return entdutynumList;
		
	}

	@Override
	public List<Map<String, Object>> getExitTellerNoList(String tradeDate, String tellerNo, String brNo, String status) {

		String[] tables = new String[] {"csis_exittellerno ex","csis_entduty en"};
		String[] selectList = new String[] {"ex.TRADEDATE as tradedate","ex.TELLERNO as tellerno","ex.SYSID as sysid",
				"ex.SYSCNAME as syscname","ex.STATUS as status","ex.ZONENO as zoneno","ex.MBRNO as mbrno","ex.BRNO as brno",
				"ex.DUTYNO as dutyno","ex.UPDDATE as upddate","ex.UPDTIME as updtime","ex.ENTDUTYNO as entdutyno"};
		
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("ex.ENTDUTYNO", SqlUtil.getSqlExp("en.ENTDUTYNO"));
			};
		};
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(tradeDate)) {
					w.eq("ex.TRADEDATE", tradeDate);
				}
				if (!StringUtils.isEmpty(tellerNo)) {
					w.eq("ex.TELLERNO", tellerNo);
				}
				if (!StringUtils.isEmpty(brNo)) {
					w.eq("ex.BRNO", brNo);
				}
				if (!StringUtils.isEmpty(status)) {
					w.eq("ex.STATUS", status);
				}
			};
		};
		
		List<Map<String, Object>> exitTellerNoList = dbo.getSelecter()
												.select(selectList)
												.from(tables[0])
												.join(JoinType.InnerJoin, tables[1], onExp)
												.where(whereExp)
												.fetchAll();
		
		return exitTellerNoList;
		
	}

	@Override
	public List<Map<String, Object>> getExitTellerBrNoList(String strDate, String strTellerNo, String strBrNo, String status) {
		String[] tables = new String[] {"csis_exittellerno ex","csis_branch br"};
		String[] selectList = new String[] {"ex.TELLERNO as tellerno","ex.BRNO as strbrno","br.BRNAS as brnoname"};
		
		Consumer<WhereExp> onExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("ex.BRNO", SqlUtil.getSqlExp("br.BRNO"));
			};
		};
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(strDate)) 
					w.eq("ex.TRADEDATE", strDate);
				
				if (!StringUtils.isEmpty(strTellerNo)) 
					w.eq("ex.TELLERNO", strTellerNo);
				
				if (!StringUtils.isEmpty(status)) 
					w.eq("ex.STATUS", status);
				
				w.op("ex.BRNO", "!=", strBrNo);
			};
		};
		
		List<Map<String, Object>> exitTellerNoList = dbo.getSelecter()
												.select(selectList)
												.from(tables[0])
												.join(JoinType.InnerJoin, tables[1], onExp)
												.where(whereExp)
												.groupBy("ex.TELLERNO,ex.BRNO,br.BRNAS")
												.fetchAll();
		
		return exitTellerNoList;
	}
}
