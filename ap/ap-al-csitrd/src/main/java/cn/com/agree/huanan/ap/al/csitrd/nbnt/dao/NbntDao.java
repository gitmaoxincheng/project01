package cn.com.agree.huanan.ap.al.csitrd.nbnt.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.nbnt.po.Nbnt;

/**
 * 
 * @author jiangzf
 */
public interface NbntDao {
	
		/**
		 * 新增一条贵金属相关记录
		 * @param nbnt
		 */
		public int addNbnt(Nbnt nbnt);
	
		/**
		 * 修改一条贵金属相关记录
		 * @param nbnt
		 */
		public int editNbnt(Map<String,Object> nbnt);
}
