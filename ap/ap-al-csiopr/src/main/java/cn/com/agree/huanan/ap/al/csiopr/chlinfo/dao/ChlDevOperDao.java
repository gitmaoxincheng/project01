package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlDevOper;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

import java.util.Map;

public interface ChlDevOperDao {

	/**
	 * 把对渠道白名单的添加、修改、删除操作添加到审核表中
	 * @param chlDevOper
	 * @return
	 */
	public int insertChlDevToOper(ChlDevOper chlDevOper);

	/**
	 * 根据渠道代码与审批状态查询渠道白名单审批信息
	 * @param chnlcode 渠道代码
	 * @param authstatus 审批状态
	 * @return
	 */
	public ChlDevOper findChlDevOperBySysId(String sysId, String authstatus);


	/**
	 * 查询渠道白名单审批数据
	 * @param curpage    页码        
	 * @param pageSize   每页最多记录    
	 * @param chnlCode   系统标识      
	 * @param beginDate  起始日期      
	 * @param endDate    截止日期      
	 * @param optType    操作类型      
	 * @param authStatus  审批状态
	 * @return
	 */
	public IPage<Map<String, Object>> queryChlDevOper(int curpage, int pageSize, String sysId, String beginDate,
													  String endDate, String optType, String authStatus);

	/**
	 * 根据流水号查询渠道白名单审批信息
	 * @param seriNo 流水号
	 * @return
	 */
	public ChlDevOper queryChlDevOperByseriNo(String seriNo);

	/**
	 * 更新渠道白名单审批表信息
	 * @param chlDevOper 渠道白名单审批bean
	 * @return
	 */
	public int updataChlDevOper(ChlDevOper chlDevOper);



}
