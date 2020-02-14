package cn.com.agree.huanan.ap.al.csiopr.mutitable.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

;

/**
 * 
 * @author bodadmin
 *
 */
@Component
public class AtnAuthOperMutiDaoImpl implements AtnAuthOperMutiDao{
	public final Logger logger = Logger.getLogger(AtnAuthOperMutiDaoImpl.class);
	@Autowired DbOperator dbo;
	
	@Override
	public Map<String, Object> getAtnAuthOperPageList( int pageFlag, int pageSize, String chnlCode, String authType) {				

		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("co.CHNLCODE", SqlUtil.getSqlExp("ci.CHNLCODE"));
			};
		};
		Selecter selecter = dbo.getSelecter().from("csis_channel_auth co").join(JoinType.LeftJoin, "csis_channel_info ci",whereExp).select(
				"co.CHNLCODE as chnlcode,co.AUTHTYPE as authtype,ci.CHNLNAME as chnlname".split(",")
				).where(w ->{
				if (!org.springframework.util.StringUtils.isEmpty(chnlCode)) {
						w.eq("co.CHNLCODE", chnlCode);
				}
				if (!org.springframework.util.StringUtils.isEmpty(authType)) {
					w.eq("co.AUTHTYPE", authType);
				}
		});
		//获取返回数量
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageFlag,pageSize);
		logger.info("iPage"+iPage);
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		resultMap.put("rowcnt", iPage.getTotal());// 总笔数
		resultMap.put("listnm", iPage.getSize());// 返回记录数
		resultMap.put("oper_list", iPage.getRecords());// 返回数据
		return resultMap;
	}


}
