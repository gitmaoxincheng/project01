package cn.com.agree.huanan.ap.al.csiopr.service.dao;


import cn.com.agree.huanan.ap.al.csiopr.service.po.ServiceCenter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface ServiceCenterDao {

	/**
	 * 服务中心列表
	 * @param pageSize 一页记录数
	 * @param curPage 当前页
	 * @return
	 */
    public IPage<ServiceCenter> selectServiceCenterlist(int curPage, int pageSize);
}
