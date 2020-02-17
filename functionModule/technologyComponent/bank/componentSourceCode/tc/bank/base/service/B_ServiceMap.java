package tc.bank.base.service;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.rl.bank.service.exception.ServiceNotFoundException;
import cn.com.agree.huanan.ap.rl.bank.service.po.AtomicServiceBean;
import cn.com.agree.huanan.ap.rl.bank.service.service.PubTrdTransfer;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 服务映射
 * 
 * @date 2019-07-09 1:32:57
 */
@ComponentGroup(level = "银行", groupName = "服务治理")
public class B_ServiceMap {

	/**
	 * @category 原子交易映射
	 * @param __MC__
	 *            入参|服务码|{@link java.lang.String}
	 * @param __TC__
	 *            入参|场景码|{@link java.lang.String}
	 * @since AtSysSvc 出参|系统服务码|{@link java.lang.String}
	 * @since AtSysScn 出参|系统场景码|{@link java.lang.String}
	 * @since AtSysCode 出参|系统码|{@link java.lang.String}
	 * @since AtExtCode 出参|扩展编码|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "__MC__", comment = "服务码", defaultParam = "__REQ__['__MC__']", type = java.lang.String.class),
			@Param(name = "__TC__", comment = "场景码", defaultParam = "__REQ__['__TC__']", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "AtSysSvc", comment = "系统服务码", defaultParam = "__REQ__['AtSysSvc']", type = java.lang.String.class),
			@Param(name = "AtSysScn", comment = "系统场景码", defaultParam = "__REQ__['AtSysScn']", type = java.lang.String.class),
			@Param(name = "AtSysCode", comment = "系统码", defaultParam = "__REQ__['AtSysCode']", type = java.lang.String.class),
			@Param(name = "AtExtCode", comment = "扩展编码", defaultParam = "__REQ__['AtExtCode']", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "原子交易映射", style = "判断型", type = "同步组件", comment = "服务码，场景码映射原子服务", date = "2019-07-27 03:46:09")
	public static TCResult B_MapAtomService(String __MC__, String __TC__) {
		return TechComp.callWithBean(PubTrdTransfer.class, (ptt) -> {
			// 获取服务配置
			AtomicServiceBean asb = ptt.getAtomicService(__MC__, __TC__);
			if (asb == null) {
				throw new ServiceNotFoundException(String.format("%s.%s", __MC__, __TC__));
			}
			return new Object[] { asb.getSYS_SVCCODE(), asb.getSYS_SCNCODE(), asb.getSYS_CODE(), asb.getEXT_CODE() };
		});
	}

}
