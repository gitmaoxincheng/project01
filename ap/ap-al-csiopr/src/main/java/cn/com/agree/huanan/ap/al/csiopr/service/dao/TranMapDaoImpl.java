package cn.com.agree.huanan.ap.al.csiopr.service.dao;

import cn.com.agree.huanan.ap.al.csiopr.service.po.TranMapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;

/**
 * @author hcp
 * 交易映射信息操作Dao层
 */
@Component
public class TranMapDaoImpl implements TranMapDao {

    @Autowired OrmOperator  ormOper;

    /**
     * 获取交易映射信息
     * @param svcOutCode 对外服务码
     * @param scnOutCode 对外场景码
     * @return 返回服务类型码
     */
    @ApCacheable
    public TranMapp selectTranMap(String svcOutCode, String scnOutCode){
//    	if (null == status) {
//			status = "0";
//		}
        //XXX
    	OrmSelecter<TranMapp> ormSelecter = ormOper.getOrmSelecter(TranMapp.class);
    	TranMapp tranMapBean = ormSelecter.where(w ->{
    		w.setSvcOutCode(svcOutCode);
    		w.setScnOutCode(scnOutCode);
    	}).fetchOne();
    	return tranMapBean;
    }

}
