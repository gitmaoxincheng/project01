package cn.com.agree.huanan.ap.al.csiusr.entduty.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyDeleteError;
import cn.com.agree.huanan.ap.al.csiusr.entduty.exception.EntdutyOnException;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class EntdutyDaoImpl implements EntdutyDao{

	private static String TABLE1="csis_entduty";
    public final Logger logger = Logger.getLogger(EntdutyDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
	
	@Override
	public List<Entduty> queryEntdutysByTellerNo(String tellerNo,String status) {
		
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
    	List<Entduty> list = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
    		w.setStatus(status);
    	}).fetchAll();
    	return list;
	}

	@Override
	public Entduty queryEntdutyByCond(String tellerNo, String brno) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		
		Entduty entduty = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
    		w.setBrNo(brno);
    	}).fetchOne();
		
		return entduty;
	}

	@Override
	public List<Entduty> queryEntdutyBybrNo(String brNo, String status) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
    	List<Entduty> list = ormSelecter.where(w ->{
    		w.setBrNo(brNo);
    		w.setStatus(status);
    	}).fetchAll();
    	return list;
	}
	
	@Override
	public Entduty queryEntdutyByEntdutyNo(String entdutyNo) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		
		Entduty entduty = ormSelecter.where(w ->{
    		w.setEntDutyNo(entdutyNo);
    	}).fetchOne();
		
		return entduty;
	}

	@Override
	public int updateEntduty(String entdutyNo, Map<String, Object> map) {
		if (StringUtils.isEmpty(entdutyNo)) {
			throw new ApIllegalParamException("entdutyNo");	
		}
		Updater updater = dbo.getUpdater();
		int count = updater.update(TABLE1).where(w -> {w.eq("ENTDUTYNO", entdutyNo);}).set(map).execute();
		return count;
	}
	
	


	//实体岗新增
	@Override
	public int insertEntduty(Entduty entdutyMap) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(Entduty.getMap(entdutyMap)).execute();
		if(count!=1) {
			dbo.rollback();
			throw new EntdutyOnException("新增失败！");
		}
		dbo.commit();
		return count;
	
	}
	
	//查询最大的岗位名称
	@Override
	public int getMaxEntName(String entdutyname, String substring) {
		Map<String, Object> result = dbo.getSelecter().select("max(substr(entdutyname,-2,2)) as maxNum").from(TABLE1).where(w ->{
			w.op("entdutyname", "like",entdutyname+substring+"%");
		}).fetchOne();
		if(null==result.get("maxNum")||"".equals((String)result.get("maxNum"))) {
			return 0;
		}
		return Integer.parseInt((String)result.get("maxNum"));
	}

	//查询本机构最大的岗位编号的后四位
	@Override
	public String getEntNumber(String brno) {
		Map<String, Object> map = dbo.getSelecter().select("max(substr(entdutyno,-4,4)) as entdutyno").from(TABLE1).where(w ->{
			w.eq("brno", brno);
		}).fetchOne();
		if(map==null) {
			return null;
		}
		 return (String)map.get("entdutyno");
	}

	//实体岗删除
	@Override
	public int entdutyDelete(String entdutyno) {
		logger.info("entdutynoDaoImpl starat");
		int result = dbo.getDeleter().deleteFrom(TABLE1).where( w ->{
			w.eq("entdutyno", entdutyno);
		}).execute();
		if(result!=1) {
			throw new EntdutyDeleteError("实体岗删除失败！");
		}
		logger.info("entdutynoDaoImpl end");
		return result;
	}

	//查询实体岗信息列表
	@Override
	public IPage<Map<String, Object>> FindEntdutyList(String pageflag, String maxnum, String zoneno, String mbrno, String brno, 
			String userst, String status,String entdutyno, String myBank,String tellerno) {

	    // 查询返回记录
	    //按页码查询
	    int startPage = Integer.parseInt(pageflag);
	    int pageSize = Integer.parseInt(maxnum);
		Consumer<WhereExp> whereExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t1.tellerno ", SqlUtil.getSqlExp("t2.tellerno"));
				 w.eq("t1.brno", SqlUtil.getSqlExp("t2.brno"));

				};
		};
		Consumer<WhereExp> whereExp2 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t1.dutyno ", SqlUtil.getSqlExp("t3.dutyno"));

				};
		};
		Selecter selecter = dbo.getSelecter().select(
				"t1.entdutyno as entdutyno" , "t1.entdutyname as entdutyname" , "t1.entdutydesc as entdutydesc","t1.dutyno as strdutyno",    
				"t1.brno as strbrno", "t1.cshboxno1 as strcshboxno1", "t1.vchboxno1 as strvchboxno1", "t1.tellerno as userid",
				"t2.name as userna", "t1.status as status", "t2.loginstatus as userst","t1.warehouserflg as warehouseflg",
				"t3.specialflg as specialflg","t3.authlevel as authlevel","t3.dutyno as dutyno","t3.dutyname as dutyname"
				).from("csis_entduty t1").join(JoinType.LeftJoin, "csis_tellerinfo t2",whereExp1)
										.join(JoinType.LeftJoin, "csis_dutyinfo t3",whereExp2)
				.where(w ->{
				w.op("t1.brno", "like", myBank + "%");
				if (!StringUtils.isEmpty(zoneno)) {
					w.eq("t1.zoneno", zoneno);
				}
				if (!StringUtils.isEmpty(mbrno)) {
					w.eq("t1.mbrno", mbrno);
				}
				if (!StringUtils.isEmpty(brno)) {
					w.eq("t1.brno", brno);					
				}
				if (!StringUtils.isEmpty(status)) {
					w.eq("t1.status", status);
				}
				if (!StringUtils.isEmpty(userst)) {
					w.eq("t2.loginstatus", userst);
				}
				if (!StringUtils.isEmpty(entdutyno)) {
					w.eq("t1.entdutyno", entdutyno);
				}
				if (!StringUtils.isEmpty(tellerno)) {
					w.eq("t1.tellerno", tellerno);
				}
		});
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(startPage, pageSize);
		
		return iPage;
	}


	//根据网点号查询该网点实体岗的岗位数量
	@Override
	public int SelectEntdutyCountByBrno(String strbrno) {
		long count = dbo.getSelecter().select("entdutyno").from(TABLE1).where(w ->{
			if(!StringUtils.isEmpty(strbrno)) {
				w.eq("brno", strbrno);
			}
		}).count();
		return (int)count;
		
	}

	@Override
	public int findCountEntduty(String zoneno,String mbrno,String brno,String status) {
		// 查询总记录数
	    long rowcnt = dbo.getSelecter().from(TABLE1).where(w -> {
	    	//查询条件
			if (!StringUtils.isEmpty(zoneno)) {
				w.eq("zoneno", zoneno);
			}
			if (!StringUtils.isEmpty(mbrno)) {
				w.eq("mbrno", mbrno);
			}
			if (!StringUtils.isEmpty(brno)&&!"7701".equals(brno)) {
				w.eq("brno", brno);
			}
			if (!StringUtils.isEmpty(status)) {
				w.eq("status", status);
			}
			}).count();
	    return (int)rowcnt;
	}

	@Override
	public List<Entduty> queryEntdutyByTelNoAndBrNo(String tellerNo, String brNo, String status) {

		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		List<Entduty> list = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
    		w.setBrNo(brNo);
    		w.setStatus(status);
    	}).fetchAll();
    	return list;
	}

	@Override
	public Entduty queryEntdutyByBrNoAndWarFlg(String brNo, String wareHouserFlg) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		Entduty entduty = ormSelecter.where(w ->{
    		w.setBrNo(brNo);
    		w.setWareHouserFlg(wareHouserFlg);
    	}).fetchOne();
		return entduty;
	}


    /**
     * 删除机构下属所有岗位信息
     * @param brno 机构号
     * @return
     */
	@Override
    public int deleteEntdutyInfoByBrno(String brno) {
    	int count = dbo.getDeleter().deleteFrom(TABLE1).where(w->{
    		w.eq("brno", brno);
    	}).execute();
		return count ;
    }
	

	@Override
	public List<Entduty> queryByStrdutyno(String strDutyNo) {
		OrmSelecter<Entduty> ormSelecter = ormOper.getOrmSelecter(Entduty.class);
		List<Entduty> list = ormSelecter.where(w ->{
    		w.setDutyNo(strDutyNo);
    	}).fetchAll();
    	return list;
	}

}
