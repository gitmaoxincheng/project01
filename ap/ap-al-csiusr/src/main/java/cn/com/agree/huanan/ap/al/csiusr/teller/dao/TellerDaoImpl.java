package cn.com.agree.huanan.ap.al.csiusr.teller.dao;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

@Component
public class TellerDaoImpl implements TellerDao{
	private static String TABLE1="csis_tellerinfo";
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    

    @Override
	public List<TellerInfo> selectTellerByTellerNo(String tellerNo) {
		OrmSelecter<TellerInfo> ormSelecter = ormOper.getOrmSelecter(TellerInfo.class);
    	List<TellerInfo> List = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
    	}).fetchAll();
    	return List;
	}


	@Override
	public List<TellerInfo> selectTellerByBrNo(String brNo) {
		OrmSelecter<TellerInfo> ormSelecter = ormOper.getOrmSelecter(TellerInfo.class);
    	List<TellerInfo> List = ormSelecter.where(w ->{
    		w.setBrNo(brNo);
    	}).fetchAll();
    	return List;
	}


	@Override
	public TellerInfo queryTellerByNo(String tellerNo,String brno) {
		OrmSelecter<TellerInfo> ormSelecter = ormOper.getOrmSelecter(TellerInfo.class);
    	TellerInfo  tellerInfo = ormSelecter.where(w ->{
    		w.setTellerNo(tellerNo);
			w.setBrNo(brno);
    	}).fetchOne();
    	return tellerInfo;
	}
	
	
	@Override
	public TellerInfo isExistTeller(String tellerNo) {
		return null;
	}


	@Override
	public int insertTeller(TellerInfo tellerInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TellerInfo.getMap(tellerInfo)).execute();
		return count;
	}


	@Override
	public int deleteByCon(String tellerNo, String brno) {
		
		if (StringUtils.isEmpty(tellerNo)) {
			throw new ApIllegalParamException("tellerNo");	
		}
		
		if (StringUtils.isEmpty(brno)) {
			throw new ApIllegalParamException("brno");	
		}
		
		int count = dbo.getDeleter().deleteFrom(TABLE1).where(w -> {w.eq("tellerno", tellerNo);w.eq("brno", brno);}).execute();
		return count;
	}


	@Override
	public int updateTelInfoByTeNoABrNo(String tellerNo, String brNo, Map<String, Object> map) {
		if(StringUtils.isEmpty(tellerNo) || StringUtils.isEmpty(brNo)) {
			throw new ApIllegalParamException("TellerNo/BrNo");	
		}
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
				w.eq("tellerno", tellerNo);
				w.eq("brno", brNo);
			}
		).set(map).execute();
		return count;
	}

	/**
	 * 根据网点号查询柜员信息表，获取该网点的柜员数量
	 */
	@Override
	public int selectTellerCountByTellerno(String brno) {
		long result = dbo.getSelecter().select("tellerno").from(TABLE1).where(w ->{
			if(!StringUtils.isEmpty(brno)) {
				w.eq("brno", brno);
			}
		}).count();
		return (int)result;
	}

    /**
     * 更新柜员网点类型
     */
	@Override
	public int updateTellerByTellerNo(String strTellerNo,String tellertype,String strbrno) {
		//参数检验
		if(StringUtils.isEmpty(strTellerNo)) {
			throw new ApIllegalParamException("strTellerNo");
		}else if(StringUtils.isEmpty(tellertype)) {
			throw new ApIllegalParamException("tellertype");
		}
		
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
				w.eq("tellerno", strTellerNo);
				w.eq("brno", strbrno);
			}
		).set("tellertype", tellertype).execute();
		return count;
	}

	@Override
	public int updateTellerInfo(String tellerno,String admBrno) {
		int count =dbo.getUpdater().update(TABLE1).where( w ->{
			w.eq("tellerno", tellerno);
			w.eq("brno", admBrno);
		}).set("status", "0").execute();
		return count;
	}
	
	/**
	 * 更新柜员所属机构号,支行号,分行号
	 * @param oldBrno 被并机构号
	 * @param newBrno 主机构行属信息
	 * @return 
	 * @author xuzhen
	 */
	@Override
    public int updateTellerBrno(String oldBrno,Map<String,Object> newBrno) {
    	return dbo.getUpdater().update(TABLE1).set(newBrno).where(w->{
    		w.eq("brno", oldBrno);
    	}).execute();
    }
	
    /**
     * 查询网点正常柜员数量
     * @param brno 机构号
     * @return
     */
	@Override
    public int queryNormalTellerByBrNo(String brno) {
    	long count = dbo.getSelecter().select("tellerno").from(TABLE1).where(w->{
    		w.eq("brno", brno);
    		w.eq("status", "1");
    	}).count();
    	
    	return (int)count;
    }
}
