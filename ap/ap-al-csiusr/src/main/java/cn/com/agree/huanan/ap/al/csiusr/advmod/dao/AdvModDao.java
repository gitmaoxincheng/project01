package cn.com.agree.huanan.ap.al.csiusr.advmod.dao;

import java.util.List;

import cn.com.agree.huanan.ap.al.csiusr.advmod.po.AdvMod;


public interface AdvModDao {
	
	/**
	 * 广告模板表新增
	 * @param advMod 广告模板表bean
	 * @return
	 */
	public int addAdvMod(AdvMod advMod);

	/**
	 * 广告模板表修改
	 * @param advMod 广告模板表bean
	 * @return
	 */
	public int updateAdvMod(AdvMod advMod);

	/**
	 * 根据广告模板编码删除广告模板表信息
	 * @param adtempid 广告模板编码
	 * @return
	 */
	public int deleteAdvMod(String adtempid);

	
	/**
	 * 根据广告模板编码查询广告模板表信息
	 * @param adtempid   广告模板编码
	 * @return
	 */
	public List<AdvMod> findAdvModByAdtempId(String adtempid);

	
	
	/**
	 * 根据广告模板编码和类别查询广告模板表信息
	 * @param adtempid   广告模板编码
	 * @param type    类别
	 * @param adid    广告编号
	 * @return
	 */
	public AdvMod findAdvMod(String adtempid, String type ,String adid);
}
