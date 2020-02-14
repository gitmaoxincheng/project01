package cn.com.agree.huanan.ap.al.csitrd.branchcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.branchcode.po.BranchCode;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class BranchCodeDaoImpl implements BranchCodeDao{
	private static String TABLE = "csis_branch_code";
	public final Logger logger = Logger.getLogger(BranchCodeDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	@Override
	public BranchCode getBranchCode(String strbranch) {
		// TODO 自动生成的方法存根
		OrmSelecter<BranchCode> ormSelecter = ormOper.getOrmSelecter(BranchCode.class);
		BranchCode branchCode = ormSelecter.where(w->{
			w.setBr_No(strbranch);
		}).fetchOne();
		return branchCode;
	}

	@Override
	public int insertBranchCode(BranchCode branchCode) {
		// TODO 自动生成的方法存根
		int count = dbo.getInserter().insertInto(TABLE).values(BranchCode.getMap(branchCode)).execute();
		return count;
	}

	@Override
	public int updateBranchCode(BranchCode branchCode) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("BR_NO", branchCode.getBr_No());
		}).set(BranchCode.getMap(branchCode)).execute();
		return count;
	}

	@Override
	public int deleteBranchCode(BranchCode branchCode) {
		// TODO 自动生成的方法存根
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w->{
			w.eq("BR_NO", branchCode.getBr_No());
		}).execute();
		return count;
	}

}
