package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao.DevModDaoImp;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.exception.DevInfoAddFailException;
import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevMod;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class DevModService{
	@Autowired DevModDaoImp devModDaoImp;
	@Autowired Logger logger;
	@Autowired DbOperator dbo;
	
	//增加数据
	public int addDevMod(DevMod devMod) {
		return devModDaoImp.insertDevMod(devMod);
		
	}
	
	//回滚
	public void RollBack() {
		dbo.rollback();
		
	}
	
	//提交
	public void Commit() {
		dbo.commit();
	}
	
    //删除数据
    public void removeDevMod(String devtypeno) {
    	devModDaoImp.deleteDevMod(devtypeno);
		
	}
    
    //删除数据
	public void removeDevMod(String devtypeno, String devmodulenum) {
		devModDaoImp.deleteDevMod(devtypeno,devmodulenum);
		
	}

	
}
