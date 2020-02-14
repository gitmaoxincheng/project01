package cn.com.agree.huanan.ap.al.csiusr.parasyn.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csiusr.parasyn.po.Parasyn;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 综合后管同步登记表Dao
 * @author xuzhen
 *
 */
@Component
public class ParasynDaoImpl implements ParasynDao {

	private static String TABLE="csis_parasyn";
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    @Autowired DbConnection dbcon;
	@Autowired Logger logger;
	
	@Override
	public int insert(Map<String, Object> parasysMap) {
		//插入数据
		int count = dbo.getInserter().insertInto(TABLE).values(parasysMap).execute();
		return count;
	}


	@Override
	public int updateParasynInfo(String serialNo, Map<String, Object> parasynMap) {
		//根据交易流水号更新登记表信息
		int count = dbo.getUpdater().update(TABLE).set(parasynMap).where(w->{
			if(!StringUtils.isEmpty(serialNo)) {
				w.eq("serialNo", serialNo);
			}
		}).execute();
		return count;
	}


	@Override
	public Parasyn queryBySerialNo(String serialNo) {
		OrmSelecter<Parasyn> ormSelecter = ormOper.getOrmSelecter(Parasyn.class);
		Parasyn parasynInfo = ormSelecter.where(w ->{
    		w.setSerialNo(serialNo);
    	}).fetchOne();
    	return parasynInfo;
	}

//	@Override
//	public Parasyn queryByBatchNo(String batchNo) {
//		OrmSelecter<Parasyn> ormSelecter = ormOper.getOrmSelecter(Parasyn.class);
//		Parasyn parasynInfo = ormSelecter.where(w ->{
//    		w.setBatchno(batchNo);
//    	}).fetchOne();
//    	return parasynInfo;
//	}
	
	/**
	 * 查询机构撤并明细列表
	 * @param strbrno 被撤并机构号
	 * @param unbrno 并入机构号
	 * @param strdate 日期
	 * @param strstatus 处理状态
	 * @param pagenum 查询页码
	 * @param pagesize 查询条数
	 * @return
	 */
	@Override
	public IPage<Map<String,Object>>queryDetailInfo(String strbrno,String unbrno,
			String strdate,String strstatus,int pagenum,int pagesize){
		Selecter selecter = dbo.getSelecter().select(
				"serialno","optdate","brno as strbrno","brna as strbrnona",
				"unbranchno as unbrno","unbranchna as unbrnona","brdate",
				"status as strstatus","wtstat","wtnum","rspcode","rspmsg"
				).from(TABLE).where(w->{
					w.eq("syntype", "0");
					w.eq("opttype", "6");
					if(!StringUtils.isEmpty(strbrno)) {
						w.eq("brno", strbrno);
					}
					if(!StringUtils.isEmpty(unbrno)) {
						w.eq("unbranchno", unbrno);
					}
					if(!StringUtils.isEmpty(strdate)) {
						w.eq("brdate", strdate);
					}
					if(!StringUtils.isEmpty(strstatus)) {
						w.eq("status", strstatus);
					}
				}).orderBy("brdate desc");
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pagenum,pagesize);
		return iPage;
	}

	/**
	 * 更新撤并状态
	 * @param serialno 流水号
	 * @param optdate 操作日期
	 * @param updInfo 状态信息
	 */
	@Override
	public int updateMergeSta(String serialno, String optdate, Map<String, Object> updInfo) {
		int count = dbo.getUpdater().update(TABLE).set(updInfo).where(w->{
			w.eq("serialno", serialno);
			w.eq("optdate", optdate);
		}).execute();
		return count;
	}


	@Override
	public List<Parasyn> queryByBrNoAndOptType(String brNo, String optType) {
		OrmSelecter<Parasyn> ormSelecter = ormOper.getOrmSelecter(Parasyn.class);
		List<Parasyn> parasynList = ormSelecter.where(w ->{
    		w.setBrNo(brNo);
    		w.setOptType(optType);
    	}).fetchAll();
		return parasynList;
	}
	
	/**
	 * 查询被并机构撤并记录数
	 * @param strBrNo 被并机构
	 * @return
	 */
	@Override
	public int queryParaInfoNum(String strBrNo) {
		long count = dbo.getSelecter().from(TABLE).where(w->{
			w.eq("brno", strBrNo);
			w.eq("opttype", "6");
			w.in("status", "0","1","5");
		}).count();
		return (int)count ;
	}
	
	/**
	 * 查询所有需回写的同步记录
	 * @param wtnum 回写次数
	 * @return
	 */
	@Override
	public List<Map<String,Object>>queryBackWriteList(int wtnum){
		return dbo.getSelecter().select(
				"serialno","optdate","batchno",
				"status","wtstat","wtnum","rspmsg"
				).from(TABLE).where(w->{
			w.in("status", "3","4");
			w.in("wtstat","0","2");
			w.op("wtnum", "<", wtnum);
		}).fetchAll();
	}
	
	/**
	 * 获取所有当日待执行的撤并记录
	 * @param nowDate 当前日期
	 * @return
	 */
	public List<Map<String,Object>>queryBackoutList(String nowDate){
		return dbo.getSelecter().select(
				"serialno","optdate","opttype","brno",
				"unbranchno","brdate","batchno"
				).from(TABLE).where(w->{
			w.eq("brdate", nowDate);
			w.eq("syntype", "0");
			w.in("opttype", "4","6","7");
			w.eq("status", "1");
		}).fetchAll();
	}
	
	/**
	 * 更新超期未处理状态
	 * @param nowDate 当前日期
	 * @return
	 */
	public int updOutOfDate(String nowDate) {
		return dbo.getUpdater().update(TABLE).set("status", "4").where(w->{
			w.op("brdate","<",nowDate);
			w.in("status", "0","1","5");
			w.eq("syntype", "0");
			w.in("opttype", "4","6","7");
		}).execute();
	}


}
