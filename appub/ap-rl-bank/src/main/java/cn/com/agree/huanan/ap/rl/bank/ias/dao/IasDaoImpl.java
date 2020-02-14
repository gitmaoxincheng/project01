package cn.com.agree.huanan.ap.rl.bank.ias.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class IasDaoImpl implements IasDao{
	private static String TABLE_CSIS_SYSPARA = "csis_syspara";
	private static String TABLE_TRADEINFO_IMAGE_LIST = "tradeinfo_image_list";
	private static String TABLE_TRADEINFO_IMAGE_MAIN = "tradeinfo_image_main";
	public final Logger logger = Logger.getLogger(IasDaoImpl.class);
	
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	
	/**
	 * 根据枚举值查询内容模型编码
	 * 00-渠道整合01-微网点02-无纸化03-信审平台04-集中作业
	 * */
	public String queryModelCodeFromSysPara(String modetype ,String paraitem) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE_CSIS_SYSPARA).select("PARAVALUE1").where((w)->{
			w.eq("paraitem", paraitem); //参数类别000011
			w.eq("PARACODE", modetype); //枚举类型
		}).fetchOne();

		return (String)para.get("PARAVALUE1");
	}
	
	/**
	 * 根据枚举值查询和参数码查询入账内部账户信息
	 */
	@Override
	public Map<String, Object> queryOutAcctNoAndName(String mybank) {
		Map<String,Object> para = dbo.getSelecter().from(TABLE_CSIS_SYSPARA).select("PARAVALUE1").select("PARAVALUE2").where((w)->{
			w.eq("paraitem", "000012"); //参数类别000011
			w.eq("PARACODE", mybank); //枚举类型
		}).fetchOne();

		return para;
	}
	
}
















