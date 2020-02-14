package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuthOper;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 * 渠道服务权限待审核dao
 * @author lanshaojun
 *
 */
public interface ChlSvcAuthOperDao {
	/**
	 * 查询渠道服务权限审批记录是否存在
	 * @param sysId 系统标识
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @return 渠道服务权限审批记录
	 *
	 */
	public ChlSvcAuthOper queryChlSvcAuthOper(String sysId, String svcOutCode, String scnOutCode);

	/**
	 * 插入渠道服务权限审批记录
	 * @param svrAuthOper 渠道服务权限审批记录
	 * @return 成功执行的操作数
	 *
	 */
	public int insertChlSvcAuthOper(ChlSvcAuthOper svrAuthOper);

	/**
	 * 更新渠道服务权限审批记录
	 * @param svrAuthOper
	 * @return 成功执行的操作数
	 *
	 */
	public int updateChlSvcAuthOper(ChlSvcAuthOper svrAuthOper);
	
	/**
	 * 删除渠道服务权限审批记录
	 * @param svrAuthOper 渠道服务权限审批记录
	 * @return 成功执行的操作数
	 *
	 */
	public int deleteChlSvcAuthOper(ChlSvcAuthOper svrAuthOper);
	
	/**
	 * 分页查询渠道访问服务待审批记录
	 * @param curPage 页码
	 * @param pageSize 页大小
	 * @param sysId 系统ID
	 * @param chnlCode 渠道代码
	 * @param beginDate 起始日期
	 * @param endDate 截止日期
	 * @param optType 操作类型
	 * @param audStatus 审批状态
	 * @return 渠道访问服务待审批记录
	 *
	 */
	public IPage<Map<String,Object>> getChlSvcAuthOper(int curPage, int pageSize, String sysId, String chnlCode, String beginDate, String endDate,
													String optType, String audStatus);

	/**
	 * seriNo查询渠道服务权限审批记录是否存在
	 * @param seriNo
	 * @return 渠道服务权限审批记录
	 *
	 */
	public ChlSvcAuthOper queryChlSvcAuthOperBySeriNo(String seriNo);
	
	/**
	 * 服务访问申请变更撤销
	 * @param serino
	 * @return
	 */
	public int deleteChlSvcAuthOper(String serino);

}
