package cn.com.agree.huanan.ap.al.csitrd.finaadjust.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.cert.dao.TradeInfoCertDao;
import cn.com.agree.huanan.ap.al.csitrd.cert.exception.InsertTradeInfoCertFailException;
import cn.com.agree.huanan.ap.al.csitrd.finaadjust.dao.FinaAdjustDao;
import cn.com.agree.huanan.ap.al.csitrd.finaadjust.exception.AdjustOprException;
import cn.com.agree.huanan.ap.al.csitrd.finaadjust.po.FinaAdjust;
import cn.com.agree.huanan.ap.al.csitrd.finaadjust.po.FinaAdjust.AdjustStatus;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.al.csitrd.cert.po.TradeInfoCert;
import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.po.Chlclrdtl;
import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.dao.ChlclrdtlDao;
/**
 * 资金调剂服务层
 * @author JZF
 *
 */
@Service
public class FinaAdjustService {

	@Autowired DbOperator dbOperator;
	@Autowired Logger logger;
	@Autowired TradeInfoCertDao TradeInfoCertDao;
	@Autowired FinaAdjustDao FinaAdjustDao;
	@Autowired ChlclrdtlDao ChlclrdtlDao;

	/**
	 * 自助设备现金调入
	 * @param fa  资金调剂po
	 * @param tc	凭证尾箱信息po
	 */
	public void doAdjustTakeIn(FinaAdjust fa,TradeInfoCert tc) {

		doAddCert(tc);
		fa.setStatus(AdjustStatus.ON_WAY_ACCOUNTING.getStatus());			//登记状态01-在途记账中
		doAddAdjust(fa);
		dbOperator.commit();
	}

	/**
	 * 登记凭证尾箱
	 * @param 凭证尾箱信息po
	 */
	private void doAddCert(TradeInfoCert tc) {
		//登记流水：TRADEINFO_CERT_MAIN凭证尾箱信息登记簿
		int count = TradeInfoCertDao.insertTradeInfoCert(tc);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("插入 凭证信息登记簿失败！");
			throw new InsertTradeInfoCertFailException();
		}
	}

	/**
	 * 资金调剂
	 * @param fa 自增资金调剂方法
	 */
	private void doAddAdjust(FinaAdjust fa) {
		int count = FinaAdjustDao.addAdjust(fa);
		if(count == 0) {
			dbOperator.rollback();
			logger.error("插入 设备资金调剂表失败！");
			throw new AdjustOprException("插入 设备资金调剂表失败！");
		}
	}

	/**
	 * 自助设备现金调出
	 * @param fa 资金调剂po
	 * @param ccl 
	 */
	public void doAdjustTakeOut(FinaAdjust fa,TradeInfoCert tc) {
		//登记凭证尾箱
		doAddCert(tc);

		//修改设备资金调剂表
		Map<String, Object> adjResult = FinaAdjustDao.getAdjust(fa, 1, 1, null, null);
		if ((int)adjResult.get("listnm") < 1) {
			dbOperator.rollback();
			throw new AdjustOprException("没有找到该流水资金调剂记录");
		}

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> adjMap = (List<Map<String, Object>>)adjResult.get("datas");
		Map<String, Object> adj = adjMap.get(0);
		String status = (String) adj.get("status");
		String adjtype = (String) adj.get("adjtype");
		//非00-在途、类型为：1-减钞不可以调出
		if (!status.equals(FinaAdjust.AdjustStatus.ON_WAY.getStatus()) || !adjtype.equals("1")) {
			dbOperator.rollback();
			throw new AdjustOprException("非在途资金不可调入到实体柜员");
		}

		fa.setStatus(FinaAdjust.AdjustStatus.STORED_ACCOUNTING.getStatus());	//状态更新03-入库记账中
		int count  = FinaAdjustDao.editAdjust(fa);
		if (count == 0) {
			dbOperator.rollback();
			throw new AdjustOprException("自助设备现金调出失败");
		}

		//登记清机维护表
		dbOperator.commit();
	}

	/**
	 * 查询现金调度信息
	 * @param fa 查询条件资金调剂po
	 * @param pageflag 页码
	 * @param maxnum	查询数量
	 * @param startDate	开始日期
	 * @param endDate	结束日期
	 * @return
	 */
	public Map<String, Object> doGetFinaAdjusts(FinaAdjust fa,int pageflag,int maxnum,String startDate,String endDate,int mod) {
		Map<String, Object> result = null;
		if (mod == 0) {
			result = FinaAdjustDao.getAdjust(fa, pageflag, maxnum, startDate, endDate);
		}else {
			result = FinaAdjustDao.getAdjustDev(fa, pageflag, maxnum, startDate, endDate);
		}
		
		return result;
	}
	
	/**
	 * 查找资金调剂交易记录
	 * @param serialno 	流水号
	 * @param tradeDate		交易日期
	 * @return
	 */
	public FinaAdjust doGetFinaAdjust(String serialno, String tradeDate ) {
		return FinaAdjustDao.getBySerialAndTrade(serialno,tradeDate);
	}

	/**
	 * 更新资金调剂信息
	 * @param fa
	 */
	public void doEditFinaAdjust(FinaAdjust fa) {
		doEditFinaAdjust(fa,true);
	}
	
	/**
	 * 更新清机加钞
	 * @param clearTIC
	 * @param clear
	 * @param add
	 */
	public void doUpdateClearAddMoney(boolean isAdd,boolean isClear,TradeInfoCert clearTIC,FinaAdjust clear,FinaAdjust add) {
		
		//清机
		if (isClear) {
			//尾箱凭证
			TradeInfoCertDao.updateTradeInfoCert(TradeInfoCert.getMap(clearTIC));
			//修改清机明细
			doEditFinaAdjust(clear,false);
		}
		//加钞
		if (isAdd) {
			doEditFinaAdjust(add,false);
		}
		dbOperator.commit();
	}
	
	/**
	 * 
	 * @param fa
	 * @param commit  是否提交
	 */
	private void doEditFinaAdjust(FinaAdjust fa,boolean commit) {
		int count  = FinaAdjustDao.editAdjust(fa);
		if (count == 0) {
			dbOperator.rollback();
			throw new AdjustOprException("更新资金调剂信息失败");
		}
		if (commit) {
			dbOperator.commit();			
		}
	}
	
	/**
	 * 更新资金调剂状态
	 * @param serialNo
	 * @param tradeDate
	 * @param status
	 */
	public void changeFinaAdjust(String serialNo,String tradeDate,String status) {
		logger.info("开始更新资金调剂状态");
		int count = FinaAdjustDao.updateAdjustStatus(serialNo, tradeDate, status);
		if(count != 1) {
			dbOperator.rollback();
			throw new AdjustOprException("更新资金调剂状态失败");
		}
		dbOperator.commit();
		logger.info("更新资金调剂状态结束");
	}

	/**
	 * 执行清机
	 * @param ccl 清机实体po
	 * @param fa	资金调剂po
	 * @param tc	凭证明细po
	 */
	private void doClear(Chlclrdtl ccl,FinaAdjust fa,TradeInfoCert tc) {
		doAddClear(ccl);
		fa.setAdjtype("1");	//减钞
		fa.setStatus(FinaAdjust.AdjustStatus.ON_WAY_ACCOUNTING.getStatus());	//生成在途记账中...
		doAddAdjust(fa);
		doAddCert(tc);
	}

	/**
	 * 执行加钞
	 * @param fa
	 * @param tc
	 */
	private void doAddMoney(FinaAdjust fa,TradeInfoCert tc) {
		
		doAddCert(tc);
		
		if (!fa.getStatus().equals(FinaAdjust.AdjustStatus.ON_WAY.getStatus()) || !fa.getAdjtype().equals("0")) {
			dbOperator.rollback();
			throw new AdjustOprException("非在途、加钞现金不可调入到设备中");
		}

		//准备入账
		fa.setStatus(FinaAdjust.AdjustStatus.STORED_ACCOUNTING.getStatus());
		doEditFinaAdjust(fa,false);
	}
	
	/**
	 * 
	 * @param clear	是否需要清机
	 * @param add	是否需要加钞
	 * @param clearCCL	清机记录
	 * @param clearFA 	清机时资金调剂记录
	 * @param clearTIC	清机时尾箱记录
	 * @param addFA		加钞时资金调剂记录
	 * @param addFIC		加钞时尾箱记录
	 */
	public void doClearAddMoney(boolean clear,boolean add,Chlclrdtl clearCCL,FinaAdjust clearFA,TradeInfoCert clearTIC,FinaAdjust addFA,TradeInfoCert addFIC) {
		if (clear) {
			doClear(clearCCL,clearFA,clearTIC);
		}
		if (add) {
			doAddMoney(addFA,addFIC);
		}
		dbOperator.commit();
	}
	
	/**
	 * 新增清机记录
	 * @param ccl	 清机对象
	 */
	private void doAddClear(Chlclrdtl ccl) {
		//登记清机维护表
		int count = ChlclrdtlDao.insertChlClrdtl(ccl);
		if (count < 1) {	
			dbOperator.rollback();
			throw new AdjustOprException("录入清机记录失败");
		}
	}

	
	/**
	 * 获取凭证尾箱信息对象
	 * @param String 交易流水
	 * @param String 交易日期
	 */
	public TradeInfoCert doGetCert(String tradedate, String serialno) {
		
		return TradeInfoCertDao.getCert(tradedate, serialno);
	}
	
	
	/**
	 * 更新资金调出交易
	 * @param ccl		待更新清机数据
	 * @param fa		资金调剂更新
	 */
	public void doUpdateTakeOut(Chlclrdtl ccl,FinaAdjust fa) {
		int count = ChlclrdtlDao.updateChlclrdtl(ccl);
		if (count < 1) {
			dbOperator.rollback();
			throw new AdjustOprException("资金调出失败");
		}
		
		doEditFinaAdjust(fa);
		dbOperator.commit();
	}
	
	/**
	 * 更新资金调入交易
	 * @param tic
	 * @param fa
	 */
	public	void doUpdateTakeIn(TradeInfoCert tic,FinaAdjust fa) {
		int count = TradeInfoCertDao.updateTradeInfoCert(TradeInfoCert.getMap(tic));
		
		if (count < 1) {
			dbOperator.rollback();
			throw new AdjustOprException("资金调入失败");
		}
		
		doEditFinaAdjust(fa);
		dbOperator.commit();
	}
	
}
 