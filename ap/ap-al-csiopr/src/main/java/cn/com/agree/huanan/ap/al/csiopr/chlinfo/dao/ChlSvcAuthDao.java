package cn.com.agree.huanan.ap.al.csiopr.chlinfo.dao;


import java.util.Map;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlSvcAuth;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 * 渠道服务权限记录dao
 * @author lanshaojun
 *
 */
public interface ChlSvcAuthDao {

	/**
	 * 查询渠道服务权限记录是否存在
	 * @param sysId 系统Id
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @return 渠道服务权限审批记录
	 *
	 */
	public ChlSvcAuth selectChlSvcAuth(String sysId, String svcOutCode, String scnOutCode);
	
	/**
	 * 分页查询渠道访问服务记录
	 * @param curPage 页码
	 * @param pageSize 页大小
	 * @param sysId 系统Id
	 * @param svcOutCode 对外发布服务码
	 * @param scnOutCode 对外发布场景码
	 * @param svrType 服务类型
	 * @return 渠道访问服务记录
	 *
	 */
	public IPage<Map<String,Object>> getChlSvcAuth(int curPage, int pageSize, String sysId, String svcOutCode,
												String scnOutCode);

	/**
	 * 插入渠道访问服务数据
	 * @param svrAuth 渠道访问服务
	 * @return 成功执行的操作数
	 *
	 */
	public int insertChlSvcAuth(ChlSvcAuth svrAuth);

	/**
	 * 删除渠道访问服务数据
	 * @param svrAuth 渠道访问服务
	 * @return 成功执行的操作数
	 *
	 */
	public int deleteChlSvcAuth(ChlSvcAuth svrAuth);

	/**
	 * 更新渠道访问服务数据
	 * @param svrAuth 渠道访问服务
	 * @return 成功执行的操作数
	 *
	 */
	public int updateChlSvcAuth(ChlSvcAuth svrAuth);

}
