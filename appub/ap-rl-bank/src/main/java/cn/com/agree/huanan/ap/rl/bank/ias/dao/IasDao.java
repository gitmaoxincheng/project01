package cn.com.agree.huanan.ap.rl.bank.ias.dao;

import java.util.Map;

public interface IasDao {
	/**
	 * 根据枚举值查询内容模型编码
	 * 00-渠道整合01-微网点02-无纸化03-信审平台04-集中作业
	 * */
	public String queryModelCodeFromSysPara(String modetype ,String paraitem);
	
	/**
	 * 根据法人号查询入账内部账户和入账内部账户名称
	 * @return
	 */
	public Map<String,Object> queryOutAcctNoAndName(String mybank);
	
}
