package tc.platform.context;

import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

import java.util.List;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaListUtil;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaList;

/**
 * JavaList容器
 * 
 * @date 2018-08-22 15:26:28
 */
@ComponentGroup(level = "平台", groupName = "JavaList容器")
public class P_JavaListUtils {

	/**
	 * @category List转JavaList
	 * @param list
	 *            入参|待转化list|{@link Object}
	 * @param javalist
	 *            出参|JavaList转换结果|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = { @Param(name = "list", comment = "待转化list", type = Object.class) })
	@OutParams(param = { @Param(name = "javalist", comment = "JavaList转换结果", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "List转JavaList", style = "判断型", type = "同步组件", author = "JUN", date = "2019-04-01 05:07:37")
	public static TCResult P_ListToJavaList(Object list) {
		return TechComp.call(() -> {
			JavaList rs = null;
			if (list instanceof List) {
				rs = JavaListUtil.listToJavaList((List<Object>) list);
			}
			return new Object[] { rs };
		});
	}

	/**
	 * @category JavaList添加元素
	 * @param target
	 *            入参|目标list|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @param source
	 *            入参|源list|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "target", comment = "目标list", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class),
			@Param(name = "source", comment = "源list", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "JavaList添加元素", style = "判断型", type = "同步组件", author = "JUN", date = "2019-04-01 06:44:28")
	public static TCResult P_AddElement(JavaList target, JavaList source) {
		return TechComp.call(() -> {
//			if(tar)
			target.addAll(source);
			return null;
		});
	}

}
