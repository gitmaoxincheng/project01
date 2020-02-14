package cn.com.agree.huanan.ap.al.csiopr.mutitable.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.logging.Logger;
@Component
public class ChlServiceMutiDaoImpl implements ChlServiceMutiDao{
	private static String TABLE="csis_tran_mapp";
	public final Logger logger = Logger.getLogger(ChlServiceMutiDaoImpl.class);
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	@Override
	public IPage<Map<String, Object>> getChlServicePageList(int curPage,int pageSize, String svccodeout, String scncodeout,
			String status) {
			
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(svccodeout)) {
					w.eq("SVCOUTCODE", svccodeout);
				}
				if (!StringUtils.isEmpty(scncodeout)) {
					w.eq("SCNOUTCODE", scncodeout);
				}
				if (!StringUtils.isEmpty(status)) {
					w.eq("STATUS", status);
				}
			}
		};
		
		String[] selectList = new String[] {
				"SVCOUTCODE as svcoutcode",
				"SVCOUTNAME as svcoutname",
				"SCNOUTCODE as scnoutcode",
				"SCNOUTNAME as scnoutname",
				"SVCCODE as svccode",
				"SCNCODE as scncode",
				"TYPE as type",
				"STATUS as status"
		};
		
		Selecter selecter = dbo.getSelecter().select(selectList).from(TABLE).where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(curPage, pageSize);
		
		return iPage;
	}
}
