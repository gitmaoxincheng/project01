package tc.platform.context;

import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

import java.util.Map;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;

/**
 * JavaDict容器
 * 
 * @date 2018-08-22 15:25:53
 */
@ComponentGroup(level = "平台", groupName = "JavaDict容器")
public class P_JavaDictUtils {

	/**
	 * @category JavaDict字典转MAP(String-String)
	 * @param dict
	 *            入参|JavaDict容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = { @Param(name = "dict", comment = "JavaDict容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "map", comment = "Map字典", type = java.util.Map.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "JavaDict字典转MAP(String-String)", style = "判断型", type = "同步组件", comment = "JavaDict字典转MAP(String-String)", author = "luo.hp", date = "2018-08-22 04:11:40")
	public static TCResult P_DictToMapSS(JavaDict dict) {
		return TechComp.call(() -> {
			return new Object[] { JavaDictUtil.dictToMap(dict, String.class,
					Object.class) };
		});
	}

	/**
	 * @category JavaDict字典转MAP(String-Object)
	 * @param dict
	 *            入参|JavaDict容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = { @Param(name = "dict", comment = "JavaDict容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "map", comment = "Map字典", type = java.util.Map.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "JavaDict字典转MAP(String-Object)", style = "判断型", type = "同步组件", comment = "JavaDict字典转MAP(String-Object)", author = "luo.hp", date = "2018-08-22 04:12:22")
	public static TCResult P_DictToMapSO(JavaDict dict) {
		return TechComp.call(() -> {
			return new Object[] { JavaDictUtil.dictToMap(dict, String.class,
					Object.class) };
		});
	}

	/**
	 * @category JavaDict字典转MAP(Object-Object)
	 * @param dict
	 *            入参|JavaDict容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = { @Param(name = "dict", comment = "JavaDict容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "map", comment = "Map字典", type = java.util.Map.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "JavaDict字典转MAP(Object-Object)", style = "判断型", type = "同步组件", comment = "JavaDict字典转MAP(Object-Object)", author = "luo.hp", date = "2018-08-22 04:12:15")
	public static TCResult P_DictToMapOO(JavaDict dict) {
		return TechComp.call(() -> {
			return new Object[] { JavaDictUtil.dictToMap(dict, String.class,
					Object.class) };
		});
	}

	/**
	 * @category MAP转JavaDict字典
	 * @param map
	 *            入参|Map字典|{@link java.util.Map}
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = { @Param(name = "map", comment = "Map字典", type = java.util.Map.class) })
	@OutParams(param = { @Param(name = "dict", comment = "JavaDict字典", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "MAP转JavaDict字典", style = "判断型", type = "同步组件", comment = "MAP转JavaDict字典", author = "luo.hp", date = "2018-08-22 04:20:53")
	public static TCResult P_MapToDictSS(Map<?, ?> map) {
		return TechComp.call(() -> {
			return new Object[] { JavaDictUtil.mapToDict(map) };
		});
	}

	/**
	 * @category 容器添加值KeyValue
	 * @param javaDict
	 *            入参|JavaDict容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param key
	 *            入参|键|{@link Object}
	 * @param value
	 *            入参|值|{@link Object}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "javaDict", comment = "JavaDict容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "key", comment = "键", type = Object.class),
			@Param(name = "value", comment = "值", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "容器添加值KeyValue", style = "判断型", type = "同步组件", comment = "容器添加值KeyValue", author = "Administrator", date = "2018-08-22 04:59:21")
	public static TCResult P_Put(JavaDict javaDict, Object key, Object value) {
		return TechComp.call(() -> {
			JavaDictUtil.put(javaDict, key, value);
			return new Object[] {};
		});
	}

	/**
	 * @category 容器添加值JavaList
	 * @param javaDict
	 *            入参|JavaDict字典|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param javaList
	 *            入参|JavaList列表|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "javaDict", comment = "JavaDict字典", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "javaList", comment = "JavaList列表", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "容器添加值JavaList", style = "判断型", type = "同步组件", comment = "容器添加值JavaList", author = "Administrator", date = "2018-08-22 05:00:12")
	public static TCResult P_PutJavaList(JavaDict javaDict, JavaList javaList) {
		return TechComp.call(() -> {
			JavaDictUtil.put(javaDict, javaList);
			return new Object[] {};
		});
	}

	/**
	 * @category 容器添加值JavaDict
	 * @param destJavaDict
	 *            入参|JavaDict目标字典|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param srcJavaDict
	 *            入参|JavaDict源字典|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param argvsJavaList
	 *            入参|JavaList过滤参数列表|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "destJavaDict", comment = "JavaDict目标字典", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "srcJavaDict", comment = "JavaDict源字典", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "argvsJavaList", comment = "JavaList过滤参数列表", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "容器添加值JavaDict", style = "判断型", type = "同步组件", comment = "容器添加值JavaDict", author = "Administrator", date = "2018-09-06 05:44:09")
	public static TCResult P_PutJavaDict(JavaDict destJavaDict,
			JavaDict srcJavaDict, JavaList argvsJavaList) {
		return TechComp.call(() -> {
			JavaDictUtil.put(destJavaDict, srcJavaDict, argvsJavaList);
			return new Object[] {};
		});
	}

	/**
	 * @category 容器变量赋值
	 * @param inContext
	 *            入参|请求容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param paramList
	 *            入参|变量赋值列表，如：[[key1,value1],[key2,value2],[key3,value3]...]|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "inContext", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "paramList", comment = "变量赋值列表，如：[[key1,value1],[key2,value2],[key3,value3]...]", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "容器变量赋值", style = "判断型", type = "同步组件", comment = "容器变量赋值, 例如入参inContext={\'key1\':value1}, 当入参paramList=[[\'key1\',value1_1],[\'key2\',value2]]时, 则处理后inContext={\'key1\':value1_1, \'key2\':value2}; 当入参inContext={\'key1\':value1}, paramList=[\'key2\', value2]时, 则处理后inContext={\'key1\':\'value1\', \'key2\', value2}", author = "lenovo", date = "2018-09-08 10:57:17")
	public static TCResult P_setValue(JavaDict inContext, JavaList paramList) {
		return TechComp.call(() -> {
			JavaDictUtil.setValue(inContext, paramList);
			return new Object[] {};
		});
	}

	/**
	 * @category 容器变量合并
	 * @param resultDict
	 *            入参|目的容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param inDict
	 *            入参|源容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "resultDict", comment = "目的容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "inDict", comment = "源容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "容器变量合并", style = "判断型", type = "同步组件", author = "lenovo", date = "2018-09-08 11:43:32")
	public static TCResult P_DictPutAll(JavaDict resultDict, JavaDict inDict) {
		return TechComp.call(() -> {
			JavaDictUtil.DictPutAll(resultDict, inDict);
			return new Object[] {};
		});
	}

	/**
	 * @category 创建数据对象
	 * @param argContext
	 *            入参|数据字典容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param dataObjList
	 *            入参|数据对象描述list|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "argContext", comment = "数据字典容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "dataObjList", comment = "数据对象描述list", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "创建数据对象", style = "判断型", type = "同步组件", comment = "按照数据对象的描述list创建数据对象,数据对象描述list的格式为[['名称',类型(JavaDict, JavaList)], ...]。例如想要创建一个名称为container的JavaDict，则参数为[['container', {}]]，若为JavaList，则参数为[['container', []]]", author = "lenovo", date = "2018-09-18 03:02:22")
	public static TCResult P_createObject(JavaDict argContext,
			JavaList dataObjList) {
		return TechComp.call(() -> {
			JavaDictUtil.CreatNewObject(argContext, dataObjList);
			return new Object[] {};
		});
	}

}
