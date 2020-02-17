package tc.bank.base.util;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * @date 2019-03-22 11:44:20
 */
@ComponentGroup(level = "银行", groupName = "流水号组件")
public class B_SernoUtil {

	/**
	 * @category 流水号生成
	 * @param seqName
	 *            入参|流水标识|{@link java.lang.String}
	 * @since serNo 出参|流水号|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "seqName", comment = "流水标识", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "serNo", comment = "流水号", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "流水号生成", style = "判断型", type = "同步组件", date = "2019-09-04 09:28:07")
	public static TCResult B_genSerno(String seqName) {
		return TechComp.call(() -> {
			return new Object[] { SernoGenUtil.getSerno(seqName) };
		});
	}

	/**
	 * @category 登记簿流水生成
	 * @param seqName
	 *            入参|流水标识|{@link java.lang.String}
	 * @since serNo 出参|流水号|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "seqName", comment = "流水标识", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "serNo", comment = "流水号", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "登记簿流水生成", style = "判断型", type = "同步组件", date = "2019-09-04 09:28:07")
	public static TCResult B_genRegistSerno(String seqName) {
		return TechComp.call(() -> {
			return new Object[] { SernoGenUtil.getSerno(seqName) };
		});
	}

	/**
	 * @category 全局流水号生成
	 * @param seqName
	 *            入参|流水标识|{@link java.lang.String}
	 * @since serNo 出参|流水号|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "seqName", comment = "流水标识", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "serNo", comment = "流水号", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "全局流水号生成", style = "判断型", type = "同步组件", author = "HCP", date = "2019-03-22 11:47:06")
	public static TCResult B_genGSerno(String seqName) {
		return TechComp.call(() -> {
			return new Object[] { SernoGenUtil.getGSerno(seqName) };
		});
	}

}
