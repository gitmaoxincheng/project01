package cn.com.agree.huanan.ap.al.csiusr.branch.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

@Component
public class BranchDaoImpl implements BranchDao{
	private static String TABLE="csis_branch";
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    @Autowired DbConnection dbcon;
    
	@Override
	public Branch queryBranchByNo(String branchNo) {
    	OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
    	Branch branch = ormSelecter.where(w ->{
    		w.setBrno(branchNo);
    	}).fetchOne();
    	return branch;
	}


	@Override
	public Branch isExistBranch(String branchNo) {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public Branch queryBranchByCond(String brno, String type, String busta) {
		OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
    	Branch branch = ormSelecter.where(w ->{
    		w.setBrno(brno);
    		w.setType(type);
    		w.setBusta(busta);
    	}).fetchOne();
    	return branch;
	}
	
	@Override
	public Branch queryBranchByCondBrsta(String brno, String brsta) {
		OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
    	Branch branch = ormSelecter.where(w ->{
    		if(!StringUtils.isEmpty(brno)) {
        		w.setBrno(brno);
    		}
    		if(!StringUtils.isEmpty(brsta)) {
        		w.setBrsta(brsta);
    		}
    	}).fetchOne();
    	return branch; 
	}

	//根据机构号查询上级支行
	@Override
	public String getSuperBranch(String strbrno) {
		OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
		Branch list = ormSelecter.where(w ->{
			if(!StringUtils.isEmpty(strbrno)) {
				w.setBrno(strbrno);
			}
    	}).fetchOne();
    	String mbrNo = list.getUpBrno();
		return mbrNo;
	}

	//根据上级支行查询上级分行
	@Override
	public String getLastSuperBranch(String mbrno) {
		OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
		Branch list = ormSelecter.where(w ->{
			if(!StringUtils.isEmpty(mbrno)) {
				w.setBrno(mbrno);
			}
    	}).fetchOne();
    	String zoneno = list.getUpBrno();
		return zoneno;
	}
	
	// 机构信息查询
	@Override
	public IPage<Map<String, Object>> queryBranchInfo(int curPage, int pageSize, String strBrNo) {
		final  String orderColum = "BRNO";
		String sql = "";
		sql += (" start with brno=" + strBrNo + " connect by prior brno=upbrno");
		Selecter selecter = dbo.getSelecter().select("BRNO as strbrno","MYBANK as mybank","TYPE as strtype","UPBRNO as upbrno",
								 "BRNAS as brnonames","BUSTA as bustat","BRSTA as brnostat","BRNA as brnoname",
								 "BRPRY as brnopry","BRTP as brnotype","LOGINSTATUS as loginstatus",
								 "BRADDR as brnoaddr","BKCOD as bankcode").from(TABLE+sql).orderBy(orderColum);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}


	
	@Override
	public int updateBranchInfo(String brNo, Map<String, Object> paramMap) {
		if (StringUtils.isEmpty(brNo)) {
			throw new ApIllegalParamException("brNo");	
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("brNo", brNo);}).set(paramMap).execute();
		return count;
	}



	@Override
	public int insertBranch(Map<String,Object>branchMap) {
		// 新增机构
		int count = dbo.getInserter().insertInto(TABLE).values(branchMap).execute();
		return count;
	}
	
	@Override
	public int updateBranchStatus(String brNo, String brSta) {
		//更新机构状态
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			if(!StringUtils.isEmpty(brNo)) {
				w.eq("brNo", brNo);
			}
		}).set("brSta", brSta).execute();
		return count;
	}

	
	
	//根据机构号修改机构类型和管辖机构号
	@Override
	public int insertBranchByNo(String brno, Map<String, Object> branchMap) {
		if (StringUtils.isEmpty(brno)) {
			throw new ApIllegalParamException("brno");	
		}
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("type", branchMap.get("type"));
			w.eq("upBrno", branchMap.get("upBrno"));
		}).set(branchMap).execute();
		return count;
	}	

	
	
	//根据机构号删除机构类型和管辖机构号
	@Override
	public int deleteBranchByNo(Map<String, Object> branchMap) {
		if (StringUtils.isEmpty(branchMap.get("type"))) {
			throw new ApIllegalParamException("type");	
		}
		if (StringUtils.isEmpty(branchMap.get("upBrno"))) {
			throw new ApIllegalParamException("upBrno");	
		}
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("type", branchMap.get("type"));w.eq("upBrno", branchMap.get("upBrno"));}).execute();
		return count;
	}	
	//删除机构号
	@Override
	public int deleteBrno(String brno) {
		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("brno", brno);}).execute();
		return count;
	}
	
	
	//根据机构号修改机构类型和管辖机构号
	@Override
	public int updateBranchNo(Map<String, Object> branchMap) {
		//修改数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {
			w.eq("brno", branchMap.get("brno"));
			}).set(branchMap).execute();
		return count;
	}
	//修改机构号
	@Override
	public int updateBrno(String brno) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("brno", brno);}).set("brno", brno).execute();
		return count;		
	}

	
	//查询所有分行信息
	@Override
	public IPage<Map<String, Object>> queryZoneBranchInfo(int curPage, int pageSize, String myBank) {
		final  String orderColum = "BRNO";
		Selecter selecter = dbo.getSelecter().select("BRNO as strbrno","MYBANK as mybank","TYPE as strtype","UPBRNO as upbrno",
								 "BRNAS as brnonames","BUSTA as bustat","BRSTA as brnostat","BRNA as brnoname",
								 "BRPRY as brnopry","BRTP as brnotype","LOGINSTATUS as loginstatus",
								 "BRADDR as brnoaddr","BKCOD as bankcode").from(TABLE)
								.where(w -> {w.eq("TYPE", "1");w.eq("MYBANK", myBank);}).orderBy(orderColum);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage,pageSize);
		return iPage;
	}


	@Override
	public int insertBrno(String brno) {
		
		return 0;
	}

	//查询[机构信息生成]所需要的字段数据
	@Override
	public List<Map<String, Object>> findBranchInfoGenerate() {
		List<Map<String, Object>> result = dbo.getSelecter().select("BRNO as brno","MYBANK as mybank",
				"TYPE as type","UPBRNO as upbrno","BRNAS as brnas",
				"BUSTA as busta","BRSTA as brsta","BRNA as brna","BRPRY as brpry",
				"BRADDR as braddr").from(TABLE).fetchAll();
		return result;
	}

	//查询网点
	@Override
	public Branch queryBranchOfNetWork(String brno, String brgp, String brsta) {
		OrmSelecter<Branch> ormSelecter = ormOper.getOrmSelecter(Branch.class);
    	Branch branch = ormSelecter.where(w ->{
    		if(!StringUtils.isEmpty(brno)) {
        		w.setBrno(brno);
    		}
    		if(!StringUtils.isEmpty(brgp)) {
        		w.setBrgp(brgp);
    		}
    		if(!StringUtils.isEmpty(brsta)) {
        		w.setBrsta(brsta);;
    		}
    	}).fetchOne();
    	return branch; 
	}
}
