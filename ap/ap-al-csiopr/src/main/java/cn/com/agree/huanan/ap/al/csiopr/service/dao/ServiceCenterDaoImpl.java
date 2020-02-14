package cn.com.agree.huanan.ap.al.csiopr.service.dao;

import cn.com.agree.huanan.ap.al.csiopr.service.po.ServiceCenter;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceCenterDaoImpl implements ServiceCenterDao {
	@Autowired private  OrmOperator ormOper;

	@Override
	public IPage<ServiceCenter> selectServiceCenterlist(int curPage, int pageSize) {
		OrmSelecter<ServiceCenter> selecter = ormOper.getOrmSelecter(ServiceCenter.class);
		return selecter.selectPage(curPage,pageSize);
	}
}
