package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class IpPortDaoImpl implements IpPortDao{
	private static String TABLE = "CSIS_SYSPARA";
	public final Logger logger = Logger.getLogger(IpPortDaoImpl.class);
	@Autowired private DbOperator dbo;
	
	@Override
	public Map<String, Object> queryIpPortDao(String paraItem, String paraCode) {
		
		//按参数类别 参数码 查询参数值1 参数值2
		Map<String,Object> sysParaMap= dbo.getSelecter().select("paraValue1", "paraValue2").from(TABLE).where(w -> {
			w.eq("paraItem", paraItem);
			w.eq("paraCode", paraCode);
		}).fetchOne();
		return sysParaMap;
	}
}
