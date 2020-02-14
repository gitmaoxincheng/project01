package cn.com.agree.huanan.ap.al.csitrd.voch.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApDataExistException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
@Component
public class CardboxinfoDaoImpl implements CardboxinfoDao {
	private static String TABLE = "csis_aums_dev_cardboxinfo";
	@Autowired
	DbOperator dbOperator;
	@Override 
	public int updateCardboxinfo(String devid,String cardboxnum,String totnum,String strtnum,String endnum) {
		int count = 0;
		// 查询返回记录
		Selecter selecter = dbOperator.getSelecter();
		Map<String, Object> mapList = selecter.select("totnum")
				.from(TABLE).where(w -> {
					w.eq("devid", devid);
					w.eq("cardboxnum", cardboxnum);
					w.op("strtnum", "<=", strtnum);
					w.op("endnum", ">=", endnum);
				}).fetchOne();
		if(mapList.isEmpty()) {
			throw new ApDataExistException("卡箱信息");
		}
		if("0".equals((String)mapList.get("totnum"))) {
			throw new ApIllegalParamException("卡箱总数[totNum]");
		}
		else {
		count = dbOperator.getUpdater().update(TABLE).where(w -> {
			w.eq("devid", devid);
			w.eq("cardboxnum", cardboxnum);
			w.op("strtnum", "<=", strtnum);
			w.op("endnum", ">=", endnum);
		}).set("totnum", SqlUtil.getSqlExp("totnum - 1")).execute();
		return count;
		}
	}

}
