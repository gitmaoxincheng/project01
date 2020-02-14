package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * 功能表dao实现层
 * 
 * @author guyulong
 */
@Component
public class FunctionInfoDaoImpl implements FunctionInfoDao {
	private static String TABLE = "CSIS_NAC_FUNCTION_INFO";

	@Autowired
	private DbOperator dbo;

	/** 根据funcid查询url */
	@Override
	public Map<String, Object> findUrl(String funcid) {
		return dbo.getSelecter().select("url").from(TABLE).where(w -> {
			w.eq("funcid", funcid);
		}).fetchOne();
	}

}
