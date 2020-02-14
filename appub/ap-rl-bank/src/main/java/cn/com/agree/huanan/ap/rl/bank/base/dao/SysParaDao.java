package cn.com.agree.huanan.ap.rl.bank.base.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara;

/**
 * 参数操作Dao
 * @author lixq
 *
 */
public interface SysParaDao {
	
	/**
	 * 查询参数列表
	 * @param tellerNo
	 * @return
	 */
    public List<Syspara> queryByItem(String paraItem);
    
   /**
    * 查询参数列表
    * @param paraItem
    * @param paraCode
    * @return
    */
    public List<Syspara> queryList(String paraItem,String paraCode);
    /**
     * 更新信息
     * @param map
     * @return
     */
    public int updateInfo(Map<String, Object> map);
}
