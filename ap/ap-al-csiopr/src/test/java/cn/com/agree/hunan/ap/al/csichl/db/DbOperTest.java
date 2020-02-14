package cn.com.agree.hunan.ap.al.csichl.db;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.agree.huanan.ap.al.csiopr.chlinfo.po.ChlInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

public class DbOperTest {
	
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	@Test
	public void testJoin() {
		
		logger.info("测试代码生效");
		List<ChlInfo> chlInfoList = new ArrayList<>();
		logger.info("普通Select连表查询getSqlExp");
		dbo.getSelecter().select("a.brno","b.upbrno").from("CSIS_BRANCH a","CSIS_BRANCH b").where(w-> w.eq("a.brno",SqlUtil.getSqlExp("b.upbrno"))).fetchOne();
		logger.info("Join连表查询getSqlExp");
		dbo.getSelecter().select("a.brno","b.upbrno").from("CSIS_BRANCH  a").join(JoinType.InnerJoin, "CSIS_BRANCH  b", w->{ 
			w.eq("a.brno", SqlUtil.getSqlExp("b.upbrno"));
		}).fetchOne();
		logger.info("普通Select连表查询参数化");
		dbo.getSelecter().select("a.brno","b.upbrno").from("CSIS_BRANCH a","CSIS_BRANCH b").where(w-> w.eq("a.brno","b.upbrno")).fetchOne();
		logger.info("Join连表查询参数化");
		dbo.getSelecter().select("a.brno","b.upbrno").from("CSIS_BRANCH  a").join(JoinType.InnerJoin, "CSIS_BRANCH  b", w->{ 
			w.eq("a.brno", "b.upbrno");
		}).fetchOne();
	}

}
