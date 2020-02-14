package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfoOper;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface ChlInfoOperDao {

	/**
	 * 根据渠道信息代码查询渠道信息审批记录
	 * @param chnlCode
	 * @return 渠道信息审批记录
	 */
	public ChlInfoOper queryChlInfoOperById(String sysId);

	/**
	 * 插入渠道信息审批记录
	 * @param chlInfoOper 
	 * @return 操作状态
	 */
	public int insertChlInfoOper(ChlInfoOper chlInfoOper);
	
	/**
	 * 获取渠道信息审批记录分页列表
	 * @param curpage 页码
	 * @param pageSize 每页最多记录数
	 * @param sysid 系统标识
	 * @param beginDate 起始日期
	 * @param endDate 截止日期
	 * @param optType 操作类型
	 * @param audStatus 审批状态
	 * @return 渠道信息审批记录分页列表
	 *
	 */
	public IPage<Map<String, Object>> getChlInfoOperPageList(int curpage, int pageSize, String sysid, String beginDate, String endDate, 
			String optType, String audStatus);

	/**
	 * 获取渠道信息审批记录
	 * @param curpage 页码
	 * @param pageSize 每页最多记录数
	 * @param chnlCode 系统标识
	 * @param beginDate 起始日期
	 * @param endDate 截止日期
	 * @param optType 操作类型
	 * @param audStatus 审批状态
	 * @return 渠道信息审批记录
	 *
	 */
	public Map<String, Object> getChlInfoOperPageListBean(String curpage, String pageSize, String chnlCode, String beginDate, String endDate, 
			String optType, String audStatus, String condition, String idxSeriNo);

	/**
	 * 根据流水号查询渠道信息审批记录
	 * @param seriNo 全局流水号
	 * @return 渠道信息审批记录
	 */
	public ChlInfoOper queryChlInfoOperByseriNo(String seriNo);

	/**
	 * 审批更新渠道信息审批记录
	 * @param chlInfoOper
	 * @return 操作状态
	 */
	public int updateChlInfoOper(ChlInfoOper chlInfoOper);
	
	/**
	 * 渠道信息变更撤销
	 * @param serino
	 * @return 
	 */
	public int deleteChlInfoOper(String serino);
}
