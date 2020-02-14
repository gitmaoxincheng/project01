package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDev;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

import java.util.List;
import java.util.Map;

public interface ChlDevDao {

	
	
	/**
	 * 根据渠道代码查找渠道白名单表
	 * @param chnlcode 渠道代码
	 * @return
	 */	
	public List<ChlDev> selectChlDevBySysId(String sysId);
	
	
	/**
	 * 根据渠道代码、渠道IP、渠道编号查找渠道白名单表
	 * @param chnlcode 渠道代码
	 * @param devip 渠道IP
	 * @param devno 渠道编号 
	 * @return
	 */
	public ChlDev findChlDev(String sysId, String devip, String devno,String status);


	/**
	 * 渠道白名单查询
	 * @param startPage 页码
	 * @param pageSize 每页记录数
	 * @param chnlcode 渠道代码
	 * @param devip 设备IP
	 * @param devno 设备编号
	 * @param status 状态
	 * @return
	 */
	public IPage<Map<String, Object>> queryChlDev(int startPage, int pageSize, String chnlcode, String devip, String devno,
												  String status);
	
	/**
	 * 新增渠道白名单
	 * @param chlDev 渠道白名单bean
	 * @return
	 */
	public int addChlDev(ChlDev chlDev);

	/**
	 * 修改渠道白名单
	 * @param chlDev 渠道白名单bean
	 * @return
	 */
	public int updateChlDev(ChlDev chlDev);

	/**
	 * 删除渠道白名单
	 * @param chlDev 渠道白名单bean
	 * @return
	 */
	public int deleteChlDev(ChlDev chlDev);

	

}
