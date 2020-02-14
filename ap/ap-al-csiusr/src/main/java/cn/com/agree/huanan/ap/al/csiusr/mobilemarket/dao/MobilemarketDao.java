package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.dao;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.MobiRol;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.Mobilemarket;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface MobilemarketDao {
	/**
	 * 根据菜单编号查询实体岗
	 * @param menuno 菜单编号
	 * @return
	 */
	public Mobilemarket queryByMenuno(String menuno);
	
	/**
	 * 插入一条实体岗记录
	 * @return
	 */
	public int addMobilemarket(Mobilemarket mobilemarket);
	
	/**
	 * 更新一条记录
	 * @return
	 */
	public int updateMobilemarket(HashMap<String, Object> map,String menuno);
	
	/**
	 * 
	 * @param Menuparno 上级菜单编号
	 * @return
	 */
	public Mobilemarket queryByMenuparno(String menuparno);
	
	/**
	 * 根据菜单编号删除
	 * @param menuno 菜单编号
	 * @return
	 */
	public int deleteByMenuno(String menuno);
	
	/**
	 * 根据菜单编号 删除客户端菜单角色关联表 相关信息
	 * @param menuno
	 * @return
	 */
	public int deleteMobilRolBy(String menuno);
	
	/**
	 * 插入一条实体岗记录
	 * @return
	 */
	public int addMobiRol(MobiRol mobiRol);
	
	/**
	 * 判断该菜单编号是否以及存在
	 * @param menuno 菜单编号
	 * @return
	 */
	public MobiRol getMobiRolByMenuno(String menuno);

	/**
	 * 移动营销菜单查询
	 * @param map
	 * @return  分页查询数据
	 */
	public IPage<Map<String, Object>> getMobiPageList(HashMap<String, Object> map);

	/**
	 * 移动营销菜单权限查询
	 * @param map
	 * @return   分页查询数据
	 */
	public IPage<Map<String, Object>> getMobiRolPageList(HashMap<String, Object> map);


}
