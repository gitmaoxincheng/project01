package cn.com.agree.huanan.ap.al.csitrd.base.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.base.po.CertarCode;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class CertarCodeDaoImpl implements CertarCodeDao {
	@Autowired DbOperator dbo;
	@Autowired OrmOperator ormOper;
	//private static String TABLE = "TRADEINFO_CERTAR_CODE";
	public final Logger logger = Logger.getLogger(CertarCodeDaoImpl.class);

	@Override
	public CertarCode queryCertarCode(String certarcode, String certarname) {
		return ormOper.getOrmSelecter(CertarCode.class).where(w -> {
			if (!StringUtils.isEmpty(certarcode)) {
				w.setCertarcode(certarcode);
			}
			if (!StringUtils.isEmpty(certarname)) {
				w.setCertarname(certarname);
			}
		}).fetchOne();
	}
	
	
	//查询所有发证机关代码数据
	@Override
	public List<CertarCode> queryCertarCodeAll() {
		List<CertarCode> result = ormOper.getOrmSelecter(CertarCode.class).fetchAll();
		return result;
	}

}
