package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
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
public class DutyinfoDaoImpl implements DutyinfoDao{

	private static String TABLE1="csis_dutyinfo";
    public final Logger logger = Logger.getLogger(DutyinfoDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;

	
	@Override
	public DutyInfo queryByDutyNo(String dutyNo) {
		OrmSelecter<DutyInfo> ormSelecter = ormOper.getOrmSelecter(DutyInfo.class);
		DutyInfo dutyInfo = ormSelecter.where(w ->{
    		w.setDutyNo(dutyNo);
    	}).fetchOne();
    	return dutyInfo;
	}
	
	@Override
	public int updateDutyInfo(String dutyNo, Map<String, Object> paramMap) {
		if (StringUtils.isEmpty(dutyNo)) {
			throw new ApIllegalParamException("dutyNo");	
		}
		int count = dbo.getUpdater().update(TABLE1).where(w -> {w.eq("DUTYNO", dutyNo);}).set(paramMap).execute();
		return count;
	}
	
	@Override
	public List<DutyInfo> queryByBrno(String brno) {
		
		OrmSelecter<DutyInfo> ormSelecter = ormOper.getOrmSelecter(DutyInfo.class);
		List<DutyInfo> list = ormSelecter.where(w ->{
    		w.setCityNo(brno);
    	}).fetchAll();
    	return list;
	}

	@Override
	public String getMaxNo(String brno) {
		
		Map<String, Object> map = dbo.getSelecter().from(TABLE1).select("max(dutyno) as maxno").where(w ->{
    		w.op("cityno", "is", SqlUtil.getSqlExp("not null"));
    		if (!StringUtils.isEmpty(brno) && "001".equals(brno.substring(0,3))) {
        		w.op("cityno", "like", brno.substring(0,3)+"%");
			}
    	}) .fetchOne();
		
		String maxno = "000";
		if (null != map && map.size() > 0) {
			String temp = String.valueOf(map.get("maxno"));
			if (!StringUtils.isEmpty(temp)) {
				maxno = String.valueOf((Integer.valueOf(temp.substring(0,3)) + 1));
			}
		}
		
		return maxno;
	}

	@Override
	public int insertDutyInfo(DutyInfo dutyInfo) {

		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(DutyInfo.getMap(dutyInfo)).execute();
		return count;
	}

	@Override
	public String getMaxParaCode(String updutyno) {
		Map<String, Object> map = dbo.getSelecter().from(TABLE1).select("max(DUTYNO) as maxno").where(w ->{
    		w.op("cityno", "is", SqlUtil.getSqlExp("not null"));
    		w.op("updutyno", "like", updutyno.substring(0,3)+"%");
    	}).fetchOne();
		String maxParaCode = updutyno.substring(0,3)+"001";
		if (null != map && map.size() > 0) {
			String temp = String.valueOf(map.get("maxno"));
			if (!StringUtils.isEmpty(temp)) {
				maxParaCode = String.valueOf((Integer.valueOf(temp) + 1));
				while (maxParaCode.length() < 6) {
					maxParaCode = "0" + maxParaCode;
				}
			}
		}
		return maxParaCode;
	}

	@Override
	public int dutyAdd(DutyInfo dutyInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(DutyInfo.getMap(dutyInfo)).execute();
		dbo.commit();
		return count;
	}
	
	@Override
	public String getEntdutyName(String dutyno) {
		Map<String, Object> result = dbo.getSelecter().select("dutyname").from(TABLE1).where(w ->{
			w.eq("dutyno", dutyno);
		}).fetchOne();
		return (String)result.get("dutyname");
	}
	
	
	@Override
	public IPage<Map<String, Object>> getDutyInfoPageList(int pageFlag, int pageSize, String strZoneno, String strDutyno,
			String status, String strupdutyno, String myBnak, String branchType){
		
		Selecter selecter =  dbo.getSelecter().select("type","dutyno","dutyname","dutydesc","status","propty","dutylevel","updutyno","cityno",
				   "branchtype","cshboxflg","vchboxflg","mobmktflg","cashflg","warehouserflg","specialflg","authlevel","adminflg")
							.from(TABLE1)
							.where(w -> {
								if (!StringUtils.isEmpty(branchType)) {
									w.in("branchtype", new String[] {branchType,"3"});
								}
								w.op("CITYNO", "like", myBnak + "%");
								if (!StringUtils.isEmpty(strZoneno)) {
									w.eq("CITYNO", strZoneno);
								}
								if (!StringUtils.isEmpty(strDutyno)) {
									w.eq("DUTYNO", strDutyno);
								}
								if (!StringUtils.isEmpty(status)) {
									w.eq("STATUS", status);
								}
								if (!StringUtils.isEmpty(strupdutyno)) {
									w.op("UPDUTYNO", "like", "%"+strupdutyno+"%");
								}
							});
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag,pageSize);						
		
		return iPage;
	}


	@Override
	public boolean isBrnoAdmin(String dutyno) {
		
		OrmSelecter<DutyInfo> ormSelecter = ormOper.getOrmSelecter(DutyInfo.class);
		DutyInfo dutyInfo = ormSelecter.where(w ->{
    		w.setDutyNo(dutyno);
    		w.setType("C");
    		w.setDutyLevel("A");
    		w.setStatus("1");
    	}).fetchOne();
		
		if (null == dutyInfo) {
			return false;
		}else {
			return true;
		}
	}


	@Override
	public long getDutyInfoSum() {
		return dbo.getSelecter().from(TABLE1).count();
	}


	@Override
	public Map<String, Object> getDutyInfoOnPageList(String strbrno) {
		// TODO 自动生成的方法存根
		//查询分行号
		OrmSelecter<Branch> ormSelecter2 = ormOper.getOrmSelecter(Branch.class);
		Branch upbranch = ormSelecter2.where(w ->{
			if(!StringUtils.isEmpty(strbrno)) {
				w.setBrno(strbrno);
			}
    	}).fetchOne();
		String upbrno=upbranch.getUpBrno();
		logger.debug("支行号："+upbrno);
		
		
		OrmSelecter<Branch> ormSelecter3 = ormOper.getOrmSelecter(Branch.class);
		Branch branch = ormSelecter3.where(w ->{
			if(!StringUtils.isEmpty(upbrno)) {
				w.setBrno(upbrno);
			}
    	}).fetchOne();
		String superBrno=branch.getUpBrno();
		logger.debug("分行号："+superBrno);
		
		
		
		OrmSelecter<DutyInfo> ormSelecter = ormOper.getOrmSelecter(DutyInfo.class);
		Map<String, Object> resultMap=new HashMap<>();
		//查询updutyno列表
		Consumer<WhereExp> whereExp= new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("cityNo", superBrno)
				.op("updutyno", "is not", SqlUtil.getSqlExp(null));
				};
		};
		Selecter selecter=dbo.getSelecter().select("distinct updutyno").from(TABLE1).where(whereExp);
		List<Map<String, Object>> list=selecter.fetchAll();
		List<String> updutyList=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		for(int i=0;i<list.size();i++) {
			map=list.get(i);
			Iterator<String> iterator=map.keySet().iterator();
			String[] arrupdutyno=((String)map.get(iterator.next())).split(";");
			for(String tempdutyno:arrupdutyno) {
				updutyList.add(tempdutyno);
			}
		}
		//查询上级岗位信息
		if(updutyList.size()==0) {
			resultMap.put("rowcnt", 0);
			resultMap.put("listnm", 0);
			//updatylist为空
			resultMap.put("bodrcd_list",updutyList);
			return resultMap;
		}
		String[] selsectList=new String[] {"dutyno","dutyname","dutydesc","status","propty","dutylevel",
				"updutyno","cityno","branchtype","cshboxflg" ,"vchboxflg","mobmktflg"};
		Consumer<WhereExp> whereExp2= new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.in("dutyno", updutyList);
				w.eq("status", "1");
			}
		};
		Selecter selecter2=dbo.getSelecter().select(selsectList).from(TABLE1).where(whereExp2).orderBy("dutyno");
		List<Map<String,Object>> list2=selecter2.fetchAll();
		resultMap.put("rowcnt", list2.size());
		resultMap.put("listnm", list2.size());
		resultMap.put("bodrcd_list",list2);
		logger.debug("-------结束坐班岗位类型查询---------");
		return resultMap;
	}
}
