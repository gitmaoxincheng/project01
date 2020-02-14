package cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.chlclrdtl.po.Chlclrdtl;

/**
 * 
 * 清机维护明细数据Dao层接口定义
 * @author 江展锋
 *
 */

public interface ChlclrdtlDao{
	
	/**
	 * 修改清机维护明细数据
	 * @param map
	 * @return 修改条目
	 */
	public int updateChlclrdtl(Chlclrdtl ccl);
	
	/**
	 * 修改清机维护明细数据
	 * @param map
	 * @return 修改条目
	 */
	public int updateChlclrdtl(Map<String, Object> map,String updateChlclrdtl);

	/**
	 * 清机维护明细数据删除  已废弃
	 * 
	 * @param atmtellerno
	 *            ATM柜员号
	 * @param devno
	 *            ATM设备号
	 * @param cleandate
	 *            清机日期
	 * @return int
	 */
	@Deprecated
	public int deleteChannelclrdtlInfo(String atmtellerno, String devno, String cleandate);

	/**
	 * 校验清机日期和ATM设备号
	 * 
	 * @param cleandate 清机日期
	 *            
	 * @param devno
	 *            ATM设备号
	 *  @param atmtellerno ATM柜员号
	 * @return  int
	 */
	public long checkChannelclrdtlInfo(String cleandate, String devno,String atmtellerno);

	/**
	 * 清机维护明细数据查询
	 * 
	 * @param pageflag
	 *            页码
	 * @param maxnum
	 *            每页最多记录数
	 * @param cleandate
	 *            起始清机日期
	 * @param lastcleantime
	 *            截止清机日期
	 * @param atmtellerno
	 *            ATM柜员号
	 * @param devno
	 *            ATM设备号
	 * @return map
	 */
	public Map<String, Object> selectChannelclrdtlInfo(String pageflag, String maxnum, String cleandate,
			String lastcleantime, String atmtellerno, String devno);
	/**
	 * 清机维护明细数据新增
	 * @param Chlclrdtl
	 *
	 */
	public int insertChlClrdtl(Chlclrdtl chlclrdtl);
	/**
	 * 查询上次清机时间  --  暂不需要的交易
	 * @param Chlclrdtl
	 *
	 */
	@Deprecated
	public Map<String, Object> getLastCleanTimeAndDevno(String atmtellerno);
}