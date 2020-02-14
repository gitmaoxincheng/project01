
package cn.com.agree.huanan.ap.al.csitrd.cheq.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.cheq.po.ChequeDetail;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 支票業務登记簿dao实现类
 * @author lanshaojun
 *
 */
@Component
public class ChequeDetailDaoImpl implements ChequeDetailDao {
	private static String TABLE = "TRADEINFO_CHEQUE_DETAIL";
	@Autowired DbOperator dbOperator;
	@Autowired OrmOperator ormOper;
	
	public final Logger logger = Logger.getLogger(ChequeDetailDaoImpl.class);
	@Override
	public int insertChequeDetail(ChequeDetail chequeDetail) {
		// TODO 自动生成的方法存根
		int count = dbOperator.getInserter().insertInto(TABLE).values(ChequeDetail.getMap(chequeDetail)).execute();
		return count;
	}

	@Override
	public int updateChequeDetail(Map<String, Object> paramMap) {
		// TODO 自动生成的方法存根
		int count = dbOperator.getUpdater().update(TABLE).where(w->{
			w.eq("SERIALNO", paramMap.get("serialNo"));
			w.eq("TRADEDATE", paramMap.get("tradeDate"));
		}).set(paramMap).execute();
		return count;
	}

	@Override
	public ChequeDetail getChequeDetailByTaskId(String taskId) {
		// TODO 自动生成的方法存根
		OrmSelecter<ChequeDetail> ormSelecter = ormOper.getOrmSelecter(ChequeDetail.class);
		ChequeDetail chequeDetail = ormSelecter.where(w->{
			w.setTaskId(taskId);
		}).fetchOne();
		return chequeDetail;
	}

	@Override
	public ChequeDetail queryChequeDetail(String tradedate, String serialno) {
		// TODO 自动生成的方法存根
		OrmSelecter<ChequeDetail> ormSelecter = ormOper.getOrmSelecter(ChequeDetail.class);
		ChequeDetail chequeDetail = ormSelecter.where(w->{
			w.setTradeDate(tradedate);
			w.setSerialNo(serialno);
		}).fetchOne();
		return chequeDetail;
	}

	@Override
	public ChequeDetail queryChequeDetail(String tradedate, String serialno, String status) {
		// TODO 自动生成的方法存根
		OrmSelecter<ChequeDetail> ormSelecter = ormOper.getOrmSelecter(ChequeDetail.class);
		ChequeDetail chequeDetail = ormSelecter.where(w->{
			w.setTradeDate(tradedate);
			w.setSerialNo(serialno);
			w.setStatus(status);
		}).fetchOne();
		return chequeDetail;
	}

	@Override
	public ChequeDetail queryChequeDetailByCnttaskid(String cnttaskid) {
		// TODO 自动生成的方法存根
		OrmSelecter<ChequeDetail> ormSelecter = ormOper.getOrmSelecter(ChequeDetail.class);
		ChequeDetail chequeDetail = ormSelecter.where(w->{
			w.setTaskId(cnttaskid); //任务号
		}).fetchOne();
		return chequeDetail;
	}
}
