package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevMod;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

@Component
public class DevModDaoImp implements  DevModDao{
	private static String TABLE="csis_channel_devmod";
	@Autowired DbOperator dbo;
	
	//插入
	@Override
	public int insertDevMod(DevMod devMod) {
		//检验
		if (StringUtils.isEmpty(devMod)) {
			throw new ApIllegalParamException("devMod");
		}	
		int count = dbo.getInserter().insertInto(TABLE).values(DevMod.getMap(devMod)).execute();
		return count;
	}
	
	//删除，
	@Override
	public int deleteDevMod(String devtypeno) {
		 //检验
		 if (StringUtils.isEmpty(devtypeno)) {
			 throw new ApIllegalParamException("devtypeno");	
		 }
		 int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("devtypeno", devtypeno);}).execute();
	     return count;
	}
	
	@Override
	public int deleteDevMod(String devtypeno, String devmodulenum) {
		 //检验
		 if (StringUtils.isEmpty(devtypeno)) {
			 throw new ApIllegalParamException("devtypeno");	
		 }else if(StringUtils.isEmpty(devmodulenum)) {
			 throw new ApIllegalParamException("devmodulenum");	
		 }
		 int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {w.eq("devtypeno", devtypeno);w.eq("devmodulenum", devmodulenum);}).execute();
	     return count;
		
	}

	

}
