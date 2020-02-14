package cn.com.agree.huanan.ap.al.csiopr.mutitable.dao;

import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface ChlServiceMutiDao {
	/**
	 * 根据条件获得渠道服务分页列表
	 * @param pageFlag 页码
	 * @param pageSize 分页长度
	 * @param platCode 模板码
	 * @param svrCode 应用码
	 * @param svrName 应用名称
	 * @param svrType 交易类型
	 * @param svrCentCode 服务中心码
	 * @param svrStatus 状态z
	 * @param rowcnt 查询结果总数
	 * @return 总笔数，返回记录数，循环体
	 */
	public IPage<Map<String,Object>> getChlServicePageList(int curPage,int pageSize, String svccodeout, String scncodeout,
			String status);

}
