package cn.com.agree.huanan.ap.al.csiusr.advinfo.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.AdvInfo;
import cn.com.agree.huanan.ap.al.csiusr.advinfo.po.DevAdv;
import cn.com.agree.huanan.ap.al.csiusr.advmod.po.AdvMod;


public interface AdvInfoDao {

	/**
	 * 插入数据,广告文件信息表
	 * @param map
	 * @return
	 * @author Maoxc
	 */
	public int insertAdvInfo(AdvInfo advInfo);	
	
	/**
	 * 更新数据,广告文件信息表
	 * @param map
	 * @return
	 * @author Maoxc
	 */
	public int updateAdvInfo(Map<String, Object> advMap);
 
   /**
    * 删除数据,广告文件信息表
    * @param map
    * @return
    */
   public int deleteAdvInfo(String adid);
   
   /**
    * 查询数据,广告文件信息表
    * @param adid
    * @return
    */
   public AdvInfo selectAdvInfo(String adid);
   
   /**
    * 插入数据,广告发布表
    * @param devAdv
    * @return
    */
   public int insertDevAdv(DevAdv devAdv);
   
   /**
    * 查询，广告发布表
    * @param devid
    * @param adtempid
    * @return
    */
   public DevAdv selectDevAdv(String devid, String adtempid);	
   
   /**
    *  删除,广告发布表
    * @param devid
    * @param adtempid
    * @return
    */
   public int deleteDevAdv(String devid);	
   
   /**
	 * 根据设备id查询广告
	 * @param devid
	 * @return
	 */
	public DevAdv getDevAdvByDevid(String devid);
	
	/**
	 * 根据广告模板编号查询广告发布表
	 * @param adtempid  广告模板编号
	 * @return
	 */
	public DevAdv queryAdvByAdtempid(String adtempid);
	
	/**
	 * 根据adid查询广告模板表
	 * @param adid
	 * @return
	 */
	public AdvMod selectAdvmodByAdid(String adid);
	
	/**
	 * 根据adtempid查询广告模板表
	 * @param adtempid
	 * @return
	 */
	public AdvMod selectAdvmodByAdtempid(String adtempid);
	
	
}
