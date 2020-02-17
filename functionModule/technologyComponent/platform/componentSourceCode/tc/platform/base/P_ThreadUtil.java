package tc.platform.base;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 
 * @date 2019-09-21 16:44:44
 */
@ComponentGroup(level = "平台", groupName = "基础组件类")
public class P_ThreadUtil {

	/**
	 * @category 线程睡眠
	 * @param time
	 *            入参|睡眠时间|long
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "time", comment = "睡眠时间", type = long.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "线程休眠", style = "判断型", type = "同步组件", comment = "线程睡眠，参数毫秒", author = "bodadmin", date = "2019-09-21 06:21:19")
	public static TCResult P_ThreadSleep(long time) {
	 return TechComp.call(() ->{
			try {
				Thread.sleep(time);
				return null;
			} catch (InterruptedException e) {
				throw new ApSystemException(e);
			}
	 });

	}

}
