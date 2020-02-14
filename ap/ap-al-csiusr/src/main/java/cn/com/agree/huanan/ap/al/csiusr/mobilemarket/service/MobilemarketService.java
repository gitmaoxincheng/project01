package cn.com.agree.huanan.ap.al.csiusr.mobilemarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.dao.MobilemarketDao;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception.CheckNoMenunoException;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception.MenuabTypeException;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception.MobilemarketDeleteException;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception.MobilemarketInsertException;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception.MobilemarketUpdateException;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.exception.TiaoJiException;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.MobiRol;
import cn.com.agree.huanan.ap.al.csiusr.mobilemarket.po.Mobilemarket;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApInsertFailException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApUpdateFailException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * @author liaowen
 *
 */
@Service
public class MobilemarketService {

	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired MobilemarketDao mobilemarketDao;
	
	/**
	 * 移动营销菜单新增
	 * 新增规则
	 * 判断上级菜单必须输入且上级菜单必须存在且不允许跳级，新增菜单的菜单AB类型和上级菜单的菜单AB类型必须一致
	 * @param mobilemarket 实体bean
	 * 
	 */
	public void getInfoConsistent(Mobilemarket mobilemarket) {
		
		Mobilemarket mobi = mobilemarketDao.queryByMenuno(mobilemarket.getMenuno());
		if(mobi != null) {
			logger.info("移动营销菜单新增---此菜单编号已存在");
			throw new ApInsertFailException("此菜单编号已存在,移动营销菜单");
		}

		String menulevel=mobilemarket.getMenulevel(); //菜单等级
		String menuparno=mobilemarket.getMenuparno(); //上级菜单编号
		String menuabtype=mobilemarket.getMenuabtype(); //菜单AB类型
		//菜单等级为1 不需要上级菜单编号，直接入库
		if(menulevel.equals("1")) {
			if(!menuparno.equals("00000")) {
				logger.info("移动营销菜单新增---此菜单编号错误");
				throw new ApInsertFailException("菜单编号错误:"+menuparno+",移动营销菜单");
			}
			insertMobilemarket(mobilemarket);
		}else {
			Mobilemarket queryByMenuno = mobilemarketDao.queryByMenuno(menuparno);
			if(queryByMenuno==null) {
				logger.info("移动营销菜单新增---无此上级菜单");
				throw new CheckNoMenunoException(1,"无此上级菜单");//无此上级菜单
			}
			//上级菜单必须输入且上级菜单必须存在且不允许跳级
			if(!(Integer.parseInt(menulevel)-Integer.parseInt(queryByMenuno.getMenulevel())==1)) {
				logger.info("移动营销菜单新增---上级菜单不允许跳级");
				throw new TiaoJiException(2,"上级菜单不允许跳级");//跳级了
			}
			//新增菜单的菜单AB类型和上级菜单的菜单AB类型必须一致
			if(!queryByMenuno.getMenuabtype().equals(menuabtype)) {
				logger.info("移动营销菜单新增----新增菜单的菜单AB类型和上级菜单的菜单AB类型必须一致");
				throw new MenuabTypeException(3,"菜单AB类型和上级菜单的菜单AB类型必须一致");
			}
			insertMobilemarket(mobilemarket);
		}
		dbo.commit();
	}
	
	
	/**
	 * 移动营销菜单新增
	 * @param mobilemarket  实体bean
	 * 
	 */
	public void insertMobilemarket(Mobilemarket mobilemarket) {
		int count = mobilemarketDao.addMobilemarket(mobilemarket);
		if(count<1) {
			logger.info("移动营销菜单新增----实体岗新增失败");
			dbo.rollback();
			throw new MobilemarketInsertException(4,"实体岗新增失败");
		}
		dbo.commit();
	}
	
	/**
	 * 移动营销菜单修改
	 * @param map
	 *
	 */
	public void updateMobilemarket(HashMap<String, Object> map) {
		String menuno = (String)map.get("menuno");
		int count = mobilemarketDao.updateMobilemarket(map, menuno);
		if(count<1) {
			logger.info("移动营销菜单修改----实体岗更新失败");
			dbo.rollback();
			throw new MobilemarketUpdateException(5,"实体岗更新失败");
		}
		dbo.commit();
	}
	
	/**
	 * 移动营销菜单修改
	 * 修改规则：
	 * 1）如果菜单为一级菜单，上级菜单不允许修改；
	 * 2）如果菜单为非一级菜单，上级菜单必须存在且不允许跳级，修改菜单的菜单AB类型和上级菜单的菜单AB类型必须一致；
	 * @param map 入参集合
	 * 
	 */
	public void judgeUpdate(HashMap<String, Object> map) {
		
		Mobilemarket mobi = mobilemarketDao.queryByMenuno((String)map.get("menuno"));
		if(mobi == null) {
			logger.info("移动营销菜单修改---此菜单编号不存在");
			throw new ApUpdateFailException("此菜单编号不存在,移动营销菜单");
		}
		
		String menulevel=(String) map.get("menulevel"); //菜单等级
		if(menulevel.equals("1")) {
			map.remove("menuparno");
			updateMobilemarket(map);
		}else {
			String menuparno=(String) map.get("menuparno"); //上级菜单编号
			String menuabtype=(String) map.get("menuabtype"); //菜单AB类型
			Mobilemarket queryByMenuno = mobilemarketDao.queryByMenuno(menuparno);
			if(queryByMenuno==null) {
				logger.info("移动营销菜单修改---无此上级菜单");
				throw new CheckNoMenunoException(1,"无此上级菜单");//无此上级菜单
			}
			//上级菜单必须输入且上级菜单必须存在且不允许跳级
			if(!(Integer.parseInt(menulevel)-Integer.parseInt(queryByMenuno.getMenulevel())==1)) {
				logger.info("移动营销菜单修改---上级菜单不允许跳级");
				throw new TiaoJiException(2,"上级菜单不允许跳级");//跳级了
			}
			//修改菜单的菜单AB类型和上级菜单的菜单AB类型必须一致
			if(!queryByMenuno.getMenuabtype().equals(menuabtype)) {
				logger.info("移动营销菜单修改-----修改菜单的菜单AB类型和上级菜单的菜单AB类型必须一致");
				throw new MenuabTypeException(3,"菜单AB类型和上级菜单的菜单AB类型必须一致");
			}
			updateMobilemarket(map);
		}
		dbo.commit();
	}
	
	/**
	 * 移动营销菜单删除
	 * 删除规则
	 * 如果菜单存在上下级关系，必须遵循从下级到上级的顺序删除，删除的菜单不能有下级菜单，删除时将对应的关联关系删除；
	 * @param menuno 菜单编号 
	 * 
	 */
	public void judgeDelete(String menuno) {
		Mobilemarket mobilemarket = getMobilemarketByMenuparno(menuno);
		if(mobilemarket==null) {
			int count = mobilemarketDao.deleteByMenuno(menuno);
			if(count<1) {
				logger.info("移动营销菜单删除----无此菜单");
				throw new MobilemarketDeleteException("无此菜单");
			}
			//删除关联关系
			mobilemarketDao.deleteMobilRolBy(menuno);
		}else {
			dbo.rollback();
			logger.info("移动营销菜单删除------删除的菜单有下级菜单，必须遵循从下级到上级的顺序删除");
			throw new MobilemarketDeleteException("删除的菜单有下级菜单，必须遵循从下级到上级的顺序删除");
		}
		dbo.commit();
	}
	
	/**
	 * 根据上级菜单编号查询
	 * 删除规则
	 * 如果菜单存在上下级关系，必须遵循从下级到上级的顺序删除，删除的菜单不能有下级菜单，删除时将对应的关联关系删除；
	 * @param menuparno 上级菜单编号
	 * @return 查询结果
	 */
	public Mobilemarket getMobilemarketByMenuparno(String menuparno) {
		Mobilemarket mobilemarket=mobilemarketDao.queryByMenuparno(menuparno);
		return mobilemarket;
	}
	
	/**
	 * @summary 移动营销菜单权限分配 插入
	 * @param list 插入的数据集合 
	 * @return
	 */
	public void insertMobiRol(List<Map<String,String>> list) {

		for(Map<String, String> map : list) {
			if(map.get("dutyno").isEmpty() || map.get("menuno").isEmpty()) {
				logger.error("菜单编号与岗位编号不能为空");
				throw new ApIllegalParamException("dutyno | menuno");
			}
			
			MobiRol mobiRol = new MobiRol();
			mobiRol.setDutyno(map.get("dutyno"));
			mobiRol.setMenuno(map.get("menuno"));
			mobiRol.setUpddate(DateTimeUtil.getSysDate());
			mobiRol.setUpdtime(DateTimeUtil.getSysTime());
			
			//插入之前要判断这个菜单编号是否以及存在了。
			MobiRol mobi = mobilemarketDao.getMobiRolByMenuno(mobiRol.getMenuno());
			if(mobi==null) {
				//不存在  则插入
				mobilemarketDao.addMobiRol(mobiRol);
			}else {
				logger.info("移动营销菜单权限分配 插入-----该菜单编号已存在，不插入，不抛错误");
			}	
		}
		dbo.commit();
	}
	
	/**
	 * @summary 移动营销菜单权限删除
	 * @param menuno 菜单编号 
	 * @return
	 */
	public void deleteMobiRol(String menuno) {
		Mobilemarket mobilemarket= mobilemarketDao.queryByMenuparno(menuno);
		if(mobilemarket==null) {
			//进行删除操作
			int count=mobilemarketDao.deleteMobilRolBy(menuno); //删除权限
			int count2=mobilemarketDao.deleteByMenuno(menuno); //删除菜单
			if(count==0||count2==0) {
				dbo.rollback();
				logger.info("移动营销菜单权限删除失败");
				throw new MobilemarketDeleteException("删除失败");
			}
		}else {
			logger.info("移动营销菜单权限删除----删除的菜单有下级菜单，必须遵循从下级到上级的循序删除");
			throw new MobilemarketDeleteException("删除的菜单有下级菜单，必须遵循从下级到上级的顺序删除");
		}
		dbo.commit();
	}

	/**
	 * 移动营销菜单查询
	 * @param map
	 * @return 查询结果
	 */
	public Map<String, Object> judgeQuery(HashMap<String, Object> map) {
		
		//检验参数
		if((int)map.get("pagenum")<1) {
			logger.error("页码不可小于1");
			throw new ApIllegalParamException("pagenum");
		}
		if((int)map.get("pagesize")<1) {
			logger.error("每页查询条数不可小于1");
			throw new ApIllegalParamException("pagesize");
		}
		
		Map<String, Object> result = new HashMap<>();
		IPage<Map<String,Object>> pageInfo = mobilemarketDao.getMobiPageList(map);
		
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("menu_list", pageInfo.getRecords());// 返回数据
		return result;
	}

	/**
	 * 移动营销菜单权限查询
	 * @param map
	 * @return 查询结果
	 */
	public Map<String, Object> QueryMobiRol(HashMap<String, Object> map) {
		//检验参数
		if((int)map.get("pagenum")<1) {
			logger.error("页码不可小于1");
			throw new ApIllegalParamException("pagenum");
		}
		if((int)map.get("pagesize")<1) {
			logger.error("每页查询条数不可小于1");
			throw new ApIllegalParamException("pagesize");
		}
		Map<String, Object> result = new HashMap<>();
		IPage<Map<String,Object>> pageInfo = mobilemarketDao.getMobiRolPageList(map);
		
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("menu_list", pageInfo.getRecords());// 返回数据
			return result;
}
}
