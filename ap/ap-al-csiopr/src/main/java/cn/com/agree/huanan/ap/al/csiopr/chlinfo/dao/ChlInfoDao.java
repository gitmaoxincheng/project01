package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 */
public interface ChlInfoDao {
	/**
	 * 根据渠道信息代码查询渠道信息
	 * @param chnlCode
	 * @return 渠道信息
	 */
	public ChlInfo queryChlInfoByChnlCode(String chnlCode);

	/**
	 * @author hcp
	 * 根据渠道ID查询渠道信息
	 * @param sysId 渠道ID
	 * @return 渠道信息
	 */
	public ChlInfo selectChlInfoById(String sysId);


		/**
         * 获取渠道信息分页列表
         * @param curpage 页码
         * @param pageSize 每页最多记录数
         * @param chnlCode 系统标识
         * @param chnlName 渠道名称
         * @param chnlStatus 渠道状态
         * @return 总笔数，返回记录数，循环体
         */
	public IPage<Map<String,Object>> getChlInfoPageList(int curpage, int pageSize, String sysId, String chnlCode, String chnlName, String chnlStatus);

	/**
	 * 新增渠道信息
	 * @param chlInfo
	 * @return 操作状态
	 */
	public int addChlInfo(ChlInfo chlInfo);

	/**
	 * 修改渠道信息
	 * @param chlInfo
	 * @return 操作状态
	 */
	public int updateChlInfo(ChlInfo chlInfo);
	
	/**
	 * 删除渠道信息
	 * @param chlInfo
	 * @return 操作状态
	 */
	public int deleteChlInfo(ChlInfo chlInfo);

	/**
	 * 根据系统标识和渠道信息代码查询渠道信息
	 * @param sysId
	 * @param chnlCode
	 * @return 渠道信息
	 */
	public ChlInfo queryChlInfoBySysIdAndChnlCode(String sysId,String chnlCode);

}
