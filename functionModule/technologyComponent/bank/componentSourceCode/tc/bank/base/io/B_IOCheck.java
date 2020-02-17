package tc.bank.base.io;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * I表校验
 * 
 * @date 2019-07-04 19:53:16
 */
@ComponentGroup(level = "银行", groupName = "IOP化")
public class B_IOCheck {
	private static Logger logger = Logger.getLogger(B_IOCheck.class);

	/**
	 * @category I表校验
	 * @param inDict
	 *            入参|入参字典|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param opt
	 *            入参|操作|{@link java.lang.String}
	 * @param systemID
	 *            入参|系统ID|{@link java.lang.String}
	 * @param mc
	 *            入参|服务码|{@link java.lang.String}
	 * @param tc
	 *            入参|场景码|{@link java.lang.String}
	 * @since outDict
	 *        出参|出参容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "inDict", comment = "入参字典", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "opt", comment = "操作", type = java.lang.String.class),
			@Param(name = "systemID", comment = "系统ID", type = java.lang.String.class),
			@Param(name = "mc", comment = "服务码", type = java.lang.String.class),
			@Param(name = "tc", comment = "场景码", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "outDict", comment = "出参容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "I表校验", style = "判断型", type = "同步组件", date = "2019-07-05 01:10:00")
	public static TCResult B_checkInput(JavaDict inDict, String opt, String systemID, String mc, String tc) {

		return TechComp.call(() -> {
//			String sysId = null == systemID ? "csis" : systemID;
			//XXX HCP
/*			if ("OPRCNTER".equals(mc) && "CHLN0005".equals(tc)) {
				logger.debug("进入IO校验");
				IOService ioService = IOServiceUtil.newServiceInstance(systemID, mc, tc);
				Map<String, Object> messageContext = JavaDictUtil.dictToMap(inDict, String.class, Object.class);
				Map<String, Object> outMap = ioService.buildInMessageContext(messageContext).initInContent().getMessageContext();
				JavaDict outDict = JavaDictUtil.mapToDict(outMap);
				return new Object[] { outDict };				
			}else {
				return null;
			}*/
			return null;

		});
	}

	/**
	 * @category O表校验
	 * @param inDict
	 *            入参|入参字典|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param opt
	 *            入参|操作|{@link java.lang.String}
	 * @param systemID
	 *            入参|系统ID|{@link java.lang.String}
	 * @param mc
	 *            入参|服务码|{@link java.lang.String}
	 * @param tc
	 *            入参|场景码|{@link java.lang.String}
	 * @since outDict
	 *        出参|出参容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "inDict", comment = "入参字典", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "opt", comment = "操作", type = java.lang.String.class),
			@Param(name = "systemID", comment = "系统ID", type = java.lang.String.class),
			@Param(name = "mc", comment = "服务码", type = java.lang.String.class),
			@Param(name = "tc", comment = "场景码", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "outDict", comment = "出参容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "O表校验", style = "判断型", type = "同步组件", date = "2019-07-05 01:10:00")
	public static TCResult B_checkOuput(JavaDict inDict, String opt, String systemID, String mc, String tc) {

		return TechComp.call(() -> {
/*			String sysId = null == systemID ? "csis" : systemID;
			IOService ioService = IOServiceUtil.newServiceInstance(sysId, mc, tc);
			Map<String, Object> messageContext = JavaDictUtil.dictToMap(inDict, String.class, Object.class);
			Map<String, Object> outMap = ioService.buildMessageContext(messageContext).initOutContent();
			JavaDict outDict = JavaDictUtil.mapToDict(outMap);
			return new Object[] { outDict };*/
			return null;
		});
	}
}
