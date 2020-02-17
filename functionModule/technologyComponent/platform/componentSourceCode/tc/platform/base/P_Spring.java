package tc.platform.base;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 字符操作库
 * 
 * @date 2018-08-21 20:36:21
 */
@ComponentGroup(level = "平台", groupName = "Spring操作")
public class P_Spring {

	/**
	 * @category Spring初始化
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "Spring初始化", style = "判断型", type = "同步组件", comment = "初始化Spring", date = "2019-12-04 09:14:50")
	public static TCResult P_initSpring() {
		// 初始化类加载器
		Thread.currentThread().setContextClassLoader(P_Spring.class.getClassLoader());
		AppLogger.info("init spring...");
		SpringUtil.initContext();
		AppLogger.info("init spring done");
		return TCResult.newSuccessResult();
	}
}
