package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevInfo;
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
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

@Component
public class DevInfoDaoImp implements  DevInfoDao{
	public final Logger logger = Logger.getLogger(DevInfoDaoImp.class);
	private static String TABLE="csis_channel_devinfo";
	private static String TABLE2="csis_branch";
	@Autowired OrmOperator  ormOper;
	@Autowired DbOperator dbo;
	
	
	
	@Override
	//自助设备查询
	public IPage<Map<String,Object>> selectDevInfo(int pageFlag, int pageSize,String devtype,String devno,
			String status, String devtellerno,String admbrno, String dstbrno, String myBank) {
		logger.info("开始查询数据");	
		//检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");	
		}else if(pageSize<1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}	
		//查询条件
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if(!StringUtils.isEmpty(devtype)) {
					w.eq("t.devtype", devtype);
				}
				if(!StringUtils.isEmpty(devno)) {
					w.eq("t.devno", devno);
				}
				if(!StringUtils.isEmpty(status)) {
					w.eq("t.status", status);	
				}			
				if(!StringUtils.isEmpty(devtellerno)) {
					w.eq("t.devtellerno", devtellerno);		
				}
				if(!StringUtils.isEmpty(admbrno)) {
					w.eq("t.admbrno", admbrno);		
				}		
				if(!StringUtils.isEmpty(dstbrno)) {
					w.eq("t.dstbrno", dstbrno);							
				}
				w.eq("t.myBank", myBank);//法人号限制		
			};
		};
			
		//查询
		String[] selectList = new String[]{"devno as devno","devtype as devtype","status as status",
				                           "devtypeno as devtypeno","devtellerno as devtellerno","devip as devip",
				                           "admbrno as admbrno","dstbrno as dstbrno","cshboxflg as cshboxflg",
				                           "vchboxflg as vchboxflg","cshboxno as cshboxno","vchboxno as vchboxno",
				                           "areacode as areacode","offlineflg as offlineflg","admtellerno as admtellerno",
				                           "telephone as telephone"};
		Selecter selecter = dbo.getSelecter().select(selectList).from("csis_channel_devinfo t").where(whereExp).orderBy("t.devno").orderBy("t.devtype");
		
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag,pageSize);	
		logger.info("结束查询数据");
		return iPage;	
		
		
	}

	
	//根据APPlyID 查询设备信息
	@Override
	public DevInfo queryDevInfo(String applyid) {
		OrmSelecter<DevInfo> ormSelecter = ormOper.getOrmSelecter(DevInfo.class);
		DevInfo devInfo = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(applyid)) {
				w.setApplyId(applyid);
			}
		}).fetchOne();		
		return devInfo;
	}

	
	@Override
	public int saveDevInfo(DevInfo devInfo) {
		
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(DevInfo.getMap(devInfo)).execute();
		return count;
	}
	
	@Override
	public DevInfo CheckDevInfo(String devno, String devtype) {
		OrmSelecter<DevInfo> select =ormOper.getOrmSelecter(DevInfo.class);
		DevInfo info = select.where(w ->{
			w.setDevNo(devno);
		}).fetchOne();
		return info;
	}
	
	@Override
	public int updateDevInfo(String devno,String devtype) {
		Map<String,Object> map= new HashMap<String,Object>();
		//TODO  是否需要更新尾箱信息
		/*map.put("cshboxflg","0");
		map.put("vchboxflg","0");
		map.put("cshboxno","");
		map.put("vchboxno","");*/
		map.put("updatedate", DateTimeUtil.getSysDate());
		map.put("updatetime", DateTimeUtil.getSysTime());
		map.put("status","2");
		map.put("devtellerno", "");
		int count = dbo.getUpdater().update(TABLE).set(map).where(w ->{
			w.eq("devno", devno);
			w.eq("devtype", devtype);
			}).execute();
		
		return count;
	}
	@Override
	public int updateSelfDev(Map<String, Object> map,String devno ,String devtype ) {
		int count = dbo.getUpdater().update(TABLE).set(map).where(w ->{
			w.eq("devno", devno);
			w.eq("devtype", devtype);
		}
			
		).execute();
		
		return count;
	}
	@Override
	public int selfdevUsing(String status) {
		int count = dbo.getUpdater().update(TABLE).set("status", status).execute();
		return count;
	}
	
	@Override
	public int selfDevDelete(String devno, String devtype) {
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w ->{
			w.eq("devno", devno);
			w.eq("devtype", devtype);
		}).execute();
		return count;
	}

	@Override
	public Map<String, Object> findDevInfo(String devno) {
		Map<String, Object> fetchOne = dbo.getSelecter().from(TABLE).select("admbrno").where(w->{
			w.eq("devno", devno);
		}).fetchOne();
		
		
		return fetchOne;
	}

	@Override
	public int selfDevProperty(String devno, String devtype,Map<String, Object> map) {
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("devno", devno);
			w.eq("devtype", devtype);
		}).set(map).execute();
		return count; 
	}

	@Override
	public int selfDevManage(Map<String, Object> map,String devno,String devtype) {
		int count = dbo.getUpdater().update(TABLE).where(w ->{
			w.eq("devno", devno);
			w.eq("devtype", devtype);
		}).set(map).execute();
		return count;
	}





	@Override
	public List<DevInfo> queryDevInfoByDeTelNo(String tellerno) {
		OrmSelecter<DevInfo> ormSelecter = ormOper.getOrmSelecter(DevInfo.class);
		List<DevInfo> devInfoList = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(tellerno)) {
				w.setDevTellerNo(tellerno);
			}
		}).fetchAll();		
		return devInfoList;
	}

	/**
	 * 更新管理归属机构
	 * @param oldBrno 被撤并机构
	 * @param newBrno 合并机构
	 * @return
	 */
	public int updAdmBrno(String oldBrno,String newBrno) {
		return dbo.getUpdater().update(TABLE).set("admbrno",newBrno).where(w->{
			w.eq("admbrno", oldBrno);
		}).execute();
	}
	
	/**
	 * 更新资产归属机构
	 * @param oldBrno 被撤并机构
	 * @param newBrno 合并机构
	 * @return
	 */
	public int updDstrBrno(String oldBrno,String newBrno) {
		return dbo.getUpdater().update(TABLE).set("dstbrno",newBrno).where(w->{
			w.eq("dstbrno", oldBrno);
		}).execute();		
	}

	@Override
	public int findDevInfoByTellerno(String tellerno) {
		  long count = dbo.getSelecter().select("devno","devtype").from(TABLE).where(w ->{
			w.eq("devtellerno", tellerno);
			w.op("status", "!=", "2");
		}).count();
		
		return (int)count;
	}

	/**
	 * 查询管理归属机构下设备数量
	 * @param strBrNo 机构号
	 * @return
	 */
	@Override
	public int queryDevCountByAdmBrNo(String strBrNo) {
		long count = dbo.getSelecter().from(TABLE).where(w->{
			w.eq("admbrno", strBrNo);
		}).count();
		return (int)count;
	}
	
	/**
	 * 查询资产归属机构下设备数量
	 * @param strBrNo 机构号
	 * @return
	 */
	@Override
	public int queryDevCountByDstBrNo(String strBrNo) {
		long count = dbo.getSelecter().from(TABLE).where(w->{
			w.eq("dstbrno", strBrNo);
		}).count();
		return (int)count;
	}


	@Override
	public DevInfo SelectDevInfo(String devno) {
		OrmSelecter<DevInfo> ormSelecter = ormOper.getOrmSelecter(DevInfo.class);
		DevInfo devInfo = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(devno)) {
				w.setDevNo(devno);
			}
		}).fetchOne();		
		return devInfo;
	}

	

}
