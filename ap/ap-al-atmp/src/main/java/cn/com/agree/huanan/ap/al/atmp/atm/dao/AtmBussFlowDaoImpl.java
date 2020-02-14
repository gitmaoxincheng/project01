package cn.com.agree.huanan.ap.al.atmp.atm.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.atmp.atm.po.ATMPBussFlow;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class AtmBussFlowDaoImpl implements AtmBussFlowDao{
	
	private static String TABLE="ATMP_BUSS_FLOW";
	public final Logger logger = Logger.getLogger(AtmBussFlowDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
	public int insertBuss(Map<String, Object> atmpMap) {
		// 向数据库中插入数据
		logger.info("新增atm特色p交易业务流水表记录");
		int count = dbo.getInserter().insertInto(TABLE).values(atmpMap).execute();
		logger.info("atmpMap:"+atmpMap);
		logger.info("新增atm特色p交易业务流水表记录  结束");
		return count;
	}

	@Override
	public ATMPBussFlow queryBuss(String serialNo) {
		// 通过交易日期和交易流水查询交易表记录
		logger.info("查询atm特色p交易流水表记录");
		OrmSelecter<ATMPBussFlow> ormSelecter = ormOper.getOrmSelecter(ATMPBussFlow.class);
		ATMPBussFlow atmpBussFlow = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(serialNo)) {
				w.setReqSerialNo(serialNo);
			}
		}).fetchOne();
		return atmpBussFlow;
	}

	@Override
	public int updateBuss(String serialNo, Map<String, Object> atmpBuss) {
		// 根据交易日期和交易流水更新交易记录
		logger.info("更新atm特色p交易流水表");
		int count = dbo.getUpdater().update(TABLE).set(atmpBuss).where(w->{
			if(!StringUtils.isEmpty(serialNo)) {
				w.eq("ReqSerialNo", serialNo);
			}
		}).execute();
		logger.info("count:"+count);
		return count;
	}

	@Override
	public int deleteBuss(String reqserialno) {
		// TODO 自动生成的方法存根
		if(StringUtils.isEmpty(reqserialno)) {
			throw new ApIllegalParamException("reqserialno");
		}
		int count=dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("REQSERIALNO", reqserialno);}).execute();
		return count;
	}

	@Override
	public ATMPBussFlow queryBySerinal(String serialno ) {
		// 根据流水号查询客户账号
		OrmSelecter<ATMPBussFlow>  ormSelecter=ormOper.getOrmSelecter(ATMPBussFlow.class);
		ATMPBussFlow atmpBussFlow=ormSelecter.where(w->{
			if(!StringUtils.isEmpty(serialno)) {
				w.setSerialNo(serialno);
			}
		}).fetchOne();
		return atmpBussFlow;
	}
	
	
	
	
}
