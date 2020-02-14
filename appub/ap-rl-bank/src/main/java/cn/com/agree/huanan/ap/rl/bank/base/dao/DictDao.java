package cn.com.agree.huanan.ap.rl.bank.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.bank.base.po.DictBean;
import cn.com.agree.huanan.ap.tl.cache.ApCacheable;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author acz,hcp字典表操作类
 */
@Component
public class DictDao {
	@Autowired
	DbOperator dbo;
	Logger logger = Logger.getLogger(DictDao.class);
	private static final String MAIN_DICT = "CSIS_MAIN_DICT";
	private static final String SUB_DICT = "CSIS_SUB_DICT";

	/**
	 * @param key 主字典ENAME
	 * @return 子字典值列表
	 */
	public List<String> select(String key) {
		List<Map<String, Object>> maps = dbo.getSelecter()
				.from(MAIN_DICT + " m", SUB_DICT + " n")
				.select("n.KEYVALUE")
				.where(w -> {
					w.eq("m.ITEM", SqlUtil.getSqlExp("n.ITEM"));
					w.eq("n.ENAME", key);
				})
				.fetchAll();

		if (maps.isEmpty()) {
			return null;
		}
		List<String> values = new ArrayList<>();
		for (int i = 0; i < maps.size(); i++) {
			values.add(maps.get(i).get("n.KEYVALUE").toString());
		}
		return values;
	}

	/**
	 * @param key 主字典分类名
	 * @param code 子字典代码
	 * @return 单个子字典Bean
	 */
	@ApCacheable
	public DictBean select(String eName, String key) {
		Map<String, Object> map = dbo.getSelecter()
				.from(MAIN_DICT + " m", SUB_DICT + " n")
				.select("m.ENAME","n.KEYNAME","n.KEYVALUE","n.REMARK")
				.where(w -> {
					w.eq("m.ITEM", SqlUtil.getSqlExp("n.ITEM"));
					w.eq("m.ENAME", eName);
					w.eq("n.KEYNAME", key);
				})
				.fetchOne();
		if (map.isEmpty()) {
			return null;
		}
		DictBean db = new DictBean();
		db.setEName(map.get("m.ENAME").toString());
		db.setKeyName(map.get("n.KEYNAME").toString());
		db.setKeyValue(map.get("n.KEYVALUE").toString());
		db.setRemark(map.get("n.REMARK").toString());
		return db;

	}

	/**
	 * 
	 * @param eName 主字典分类名
	 * @param key 子字典key
	 * @return 子字典value
	 */
	public String getStringItem(String eName ,String key) {
		Map<String, Object> map = dbo.getSelecter()
				.from(MAIN_DICT + " m", SUB_DICT + " n")
				.select("n.KEYVALUE")
				.where(w -> {
					w.eq("m.ITEM", SqlUtil.getSqlExp("n.ITEM"));
					w.eq("m.ENAME", eName);
					w.eq("n.KEYNAME", key);
				})
				.fetchOne();
		if (map.isEmpty()) {
			return null;
		}
		return map.get("n.KEYVALUE").toString();
	}

	/**
	 * @param key 主字典分类名
	 * @return 全部子字典Bean
	 */
	public List<DictBean> selectDictItems(String eName) {
		List<Map<String, Object>> maps = dbo.getSelecter()
				.from(MAIN_DICT + " m", SUB_DICT + " n")
				.select("m.ENAME","n.KEYNAME","n.KEYVALUE","n.REMARK")
				.where(w -> {
					w.eq("m.ITEM", SqlUtil.getSqlExp("n.ITEM"));
					w.eq("m.ENAME", eName);
				})
				.fetchAll();
		if (maps.isEmpty()) {
			return null;
		}
		List<DictBean> dictBeans = new ArrayList<>();
		DictBean db = null;
		for (int i = 0; i < maps.size(); i++) {
			db = new DictBean();
			db.setEName(maps.get(i).get("m.ENAME").toString());
			db.setKeyName(maps.get(i).get("n.KEYNAME").toString());
			db.setKeyValue(maps.get(i).get("n.KEYVALUE").toString());
			db.setRemark(maps.get(i).get("n.REMARK").toString());
			dictBeans.add(db);
		}
		return dictBeans;
	}
	
	/**
	 * @param key 主字典分类名
	 * @return 全部子字典Map
	 */
	public Map<String, Object> selectDict(String eName) {
		List<Map<String, Object>> maps = dbo.getSelecter()
				.from(MAIN_DICT + " m", SUB_DICT + " n")
				.select("n.KEYNAME","n.KEYVALUE","n.REMARK")
				.where(w -> {
					w.eq("m.ITEM", SqlUtil.getSqlExp("n.ITEM"));
					w.eq("m.ENAME", eName);
				})
				.fetchAll();
		
		if (maps.isEmpty()) {
			return null;
		}
		Map<String, Object>  dict = new HashMap<>();
		for (int i = 0; i < maps.size(); i++) {
			dict.put(maps.get(i).get("n.KEYNAME").toString(),maps.get(i).get("n.KEYVALUE"));
		}
		return dict;
	}
	
	/**
	 * 查询文件生成路径
	 * @param keyName
	 * @return
	 */
	public  Map<String, Object> queryPath(String keyName) {
		Map<String, Object> result = dbo.getSelecter().select("KEYVALUE as keyValue").from(SUB_DICT)
				.where(w ->{
					w.eq("KEYNAME", keyName);
				}).fetchOne();
		return result;
	}
	

}
