package tc.bank.dict;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 获取字典表参数
 * 
 * @date 2019-10-10 9:24:5
 */
@ComponentGroup(level = "银行", groupName = "查询字典表")
public class B_DictItem {

	/**
	 * @category 获取字典表参数
	 * @param eName
	 *            入参|主字典分类名|{@link java.lang.String}
	 * @param key
	 *            入参|子字典key|{@link java.lang.String}
	 * @since value 出参|子字典value|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "eName", comment = "主字典分类名", type = java.lang.String.class),
			@Param(name = "key", comment = "子字典key", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "value", comment = "子字典value", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "获取字典表参数", style = "判断型", type = "同步组件", author = "bodadmin", date = "2019-10-10 09:26:49")
	public static TCResult B_getDictItem(String eName, String key) {
		AppLogger.info("获取字典表参数");
		return TechComp.callWithBean(DictDao.class, (dictDao)->{
			String item = dictDao.getStringItem(eName, key);
			return new Object[] {item};
		});
	}

}
