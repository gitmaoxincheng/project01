package cn.com.agree.huanan.ap.rl.bank.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.rl.bank.base.po.Syspara;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class SysParaDaoImpl implements SysParaDao{

	private static String TABLE1="csis_syspara";
    public final Logger logger = Logger.getLogger(SysParaDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;
    
    
	@Override
	@ApCacheable
	public List<Syspara> queryByItem(String paraItem) {
		
		OrmSelecter<Syspara> ormSelecter = ormOper.getOrmSelecter(Syspara.class);
    	List<Syspara> tellerInfo = ormSelecter.where(w ->{
    		w.setParaItem(paraItem);
    	}).fetchAll();
    	return tellerInfo;
	}
	 
		@Override
		public List<Syspara> queryList(String paraItem,String paraCode) {
			
			OrmSelecter<Syspara> ormSelecter = ormOper.getOrmSelecter(Syspara.class);
	    	List<Syspara> tellerInfo = ormSelecter.where(w ->{
	    		w.setParaItem(paraItem);
	    		
	    		if (!StringUtils.isEmpty(paraCode)) {
	    			w.setParaCode(paraCode);
				}
	    		
	    	}).fetchAll();
	    	return tellerInfo;
		}

		@Override
		public int updateInfo(Map<String, Object> map) {
			int count = dbo.getUpdater().update(TABLE1).where(w -> {
				if (null != map.get("paraItem") && !StringUtils.isEmpty(map.get("paraItem"))) {
					w.eq("paraItem", map.get("paraItem"));
				}
				if (null != map.get("paraCode") && !StringUtils.isEmpty(map.get("paraCode"))) {
					w.eq("paraCode", map.get("paraCode"));
				}
				})
					.set(map).execute();
			return count;
		}

}
