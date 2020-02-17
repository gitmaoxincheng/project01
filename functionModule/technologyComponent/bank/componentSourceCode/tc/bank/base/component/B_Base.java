package tc.bank.base.component;

import static cn.com.agree.afa.jcomponent.GlobalErrorHolder.setGlobalError;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 基础组件库
 * 
 * @date 2019-01-25 14:9:40
 */
@ComponentGroup(level = "银行", groupName = "基础组件库")
public class B_Base {

//	private static Logger logger = Logger.getLogger(B_Base.class);

	/**
	 * @category 服务响应结果判断
	 * @param msgDict
	 *            入参|服务响应报文容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 * 		2 异常<br>
	 * 		3 部分成功<br>
	 * 		4 处理中<br>
	 */
	@InParams(param = {
			@Param(name = "msgDict", comment = "服务响应报文容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"), @Return(id = "2", desp = "异常"),
			@Return(id = "3", desp = "部分成功"), @Return(id = "4", desp = "处理中") })
	@galaxy.ide.tech.cpt.Component(label = "服务响应结果判断", style = "选择型", type = "同步组件", comment = "处理服务调用响应报文，并根据结果状态处理", date = "2019-09-16 09:50:06")
	public static TCResult B_handleBaseRes(JavaDict msgDict) {
		return TechComp.call(true, () -> {
			// 根据响应状态选择分支
			JavaDict csisHeader = msgDict.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
			String respSts = csisHeader.getStringItem(CommConstant.STATUS, CommConstant.UNKNOWSTATUS);
			String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE, CommConstant.UNKNOWCODE);
			String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG, CommConstant.UNKNOWMSG);
			switch (respSts) {
			case CommConstant.FAILSTATUS:
				setGlobalError("F", errorCode, errorMsg);// 全部失败
				return new Object[] { 0 };
			case CommConstant.SUCCSTATUS:
//				setGlobalError("S", errorCode, errorMsg);// 全部成功
				return new Object[] { 1 };
			case CommConstant.UNKNOWSTATUS:
				setGlobalError("U", errorCode, errorMsg);// 異常，状态未知
				return new Object[] { 2 };
			case CommConstant.PARTSUCCSTATUS:
				setGlobalError("P", errorCode, errorMsg);// 部分成功
				return new Object[] { 3 };
			case CommConstant.HANDSTATUS:
				setGlobalError("I", errorCode, errorMsg);// 处理中
				return new Object[] { 4 };
			default:
				break;
			}
			return new Object[] { 2 };
		});
	}

}
