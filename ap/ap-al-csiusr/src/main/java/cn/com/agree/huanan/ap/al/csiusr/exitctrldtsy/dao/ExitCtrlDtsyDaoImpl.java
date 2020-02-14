package cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.exitctrldtsy.po.ExitCtrlDtsy;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class ExitCtrlDtsyDaoImpl implements ExitCtrlDtsyDao{
	private static String TABLE="csis_exitctrldtsy";
    public final Logger logger = Logger.getLogger(ExitCtrlDtsyDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
	@Override
	public ExitCtrlDtsy queryByNoAndStatus(String dutyNo, String status) {
		OrmSelecter<ExitCtrlDtsy> ormSelecter = ormOper.getOrmSelecter(ExitCtrlDtsy.class);
		ExitCtrlDtsy exitCtrlDtsy = ormSelecter.where(w ->{
    		w.setDutyNo(dutyNo);
    		w.setStatus(status);
    	}).fetchOne();
    	return exitCtrlDtsy;
	}
	
	
	@Override
	//多表查询
	public Map<String, Object> selectExitCtrlDtsy(int pageFlag, int pageSize, String dutyno, String myBank) {
		
		//查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>(){
			@Override
			public void accept(WhereExp w) {		
				 if(!StringUtils.isEmpty(dutyno)) {w.eq("t1.dutyno", dutyno);}	
				 w.eq("t1.status", "1");
				 w.eq("t1.dutyno", SqlUtil.getSqlExp("t2.dutyno"));
				 w.op("t2.cityno", "like", myBank + "%");
				};
		};
		
		//查询
		String[] tables = new String[] {"csis_exitctrldtsy t1","csis_dutyinfo t2"};
		Selecter selecter = dbo.getSelecter().from(tables)
						 .select("t1.dutyno as strdutyno,t1.sysidbuf as strsysid,t1.status as status,t2.dutyname as dutyname".split(","))
						 .where(whereExp);	
		
		
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag,pageSize);						
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("bodrcd_list", iPage.getRecords());// 返回数据
		return resultMap;
		
	}


	@Override
	//增加
	public int insertExitCtrlDtsy(ExitCtrlDtsy exitCtrlDtsy) {
		//检验参数
		if(StringUtils.isEmpty(ExitCtrlDtsy.getMap(exitCtrlDtsy))) {
			throw new ApIllegalParamException("ExitCtrlDtsy.getMap(exitCtrlDtsy)");
		}
		Inserter inserter = dbo.getInserter();	
		int count = inserter.insertInto(TABLE).values(ExitCtrlDtsy.getMap(exitCtrlDtsy)).execute();
		return count;	
	}


	@Override
	//修改
	public int updateExitCtrlDtsy(String strdutyno,  Map<String, Object> map) {
		//检验参数
		if(StringUtils.isEmpty(strdutyno)) {
			throw new ApIllegalParamException("strdutyno");
		}
		
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("dutyno", strdutyno);})
				.set(map).execute();
		return count;
	}

	@Override
	//查询受控系统表
	public ExitCtrlDtsy selectExitCtrlDtsy(String strdutyno) {
		//检验参数
		if(StringUtils.isEmpty(strdutyno)) {
			throw new ApIllegalParamException("strdutyno");
		}	
		OrmSelecter<ExitCtrlDtsy> ormSelecter = ormOper.getOrmSelecter(ExitCtrlDtsy.class);
		ExitCtrlDtsy exitCtrlDtsy = ormSelecter.where(w ->{w.setDutyNo(strdutyno);}).fetchOne();
		return exitCtrlDtsy;
	}
	
}
