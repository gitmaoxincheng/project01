package tc.platform.component.commom;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.CIResult;

/**
 * 容器处理
 * 
 * @date 20190522 9:8:30
 */
@ComponentGroup(level = "平台", groupName = "容器处理组件")
public class P_CtnrHandler {


	public static TCResult P_DictSetValue(JavaDict ctnr, JavaList paramsList) {
		return TechComp.call(() -> {
			JavaDictUtil.setValue(ctnr,  paramsList);		
			return new Object[] {};
		});
	}


	/**
	 * @category 应答容器拼接
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "应答容器拼接", style = "判断型", type = "同步组件", comment = "应答容器拼接", author = "bodadmin", date = "20190603 09:27:58")
	public static TCResult P_RspDictPacket() {
		try {
			AppLogger.info("应答容器拼接 P_RspDictPacket() 开始");
			JavaDict __RSP__ = (JavaDict) EnvContextHolder.getHolder().getContext().getResponse();
			JavaDict __SNDPCK__ = __RSP__.getDictItem("__SNDPCK__", new JavaDict());
			if (!(__RSP__.getItem(CommConstant.HEADER) instanceof JavaDict)) {
				AppLogger.error("参数rspHeader格式错误，必须为dict");
				return CIResult.newFailureResult(CommonErrorCodeEnum.PARAMETER_ILLEGAL, "参数rspHeader格式错误");
			}
			if (!(__RSP__.getItem(CommConstant.APP_BODY) instanceof JavaDict)) {
				AppLogger.error("参数rspBody格式错误，必须为dict");
				return CIResult.newFailureResult(CommonErrorCodeEnum.PARAMETER_ILLEGAL, "参数rspBody格式错误");
			}

			// 设置返回流水号和服务方交易日期
			JavaDict csisHeader = __RSP__.getDictItem(CommConstant.CSIS_HEADER, new JavaDict());
			JavaDict snDict = __RSP__.getDictItem("snDict", new JavaDict());
			csisHeader.setItem("RspNo", snDict.getStringItem("serialno"));
			csisHeader.setItem("SrvTranDt", DateTimeUtil.getSysDate());
			__SNDPCK__.setItem(CommConstant.CSIS_HEADER, csisHeader);
			__SNDPCK__.setItem(CommConstant.HEADER, __RSP__.getDictItem(CommConstant.HEADER, new JavaDict()));
			__SNDPCK__.setItem(CommConstant.APP_HEADER, __RSP__.getDictItem(CommConstant.APP_HEADER, new JavaDict()));
			__SNDPCK__.setItem(CommConstant.APP_BODY, __RSP__.getDictItem(CommConstant.APP_BODY, new JavaDict()));

			__SNDPCK__.setItem("rspHeader", __RSP__.getDictItem("rspHeader", new JavaDict()));
			__SNDPCK__.setItem("rspBody", __RSP__.getDictItem("rspBody", new JavaDict()));

			return TCResult.newSuccessResult();
		} catch (Exception e) {
			AppLogger.info("应答容器拼接失败: " + e);
			AppLogger.info(e);
			return TCResult.newFailureResult(CommonErrorCodeEnum.DICT_SET_VALUE_ERROR.getCode(), "应答容器拼接失败");
		}
	}

	/**
	 * @category 查询容器转换
	 * @param target
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since to 出参|返回容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "target", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "to", comment = "返回容器", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "查询容器转换", style = "判断型", type = "同步组件", comment = "将查询结果集dict转换成符合返回查询结果格式的list，入参[请求容器]格式为{'key1': [...], {'key2': [...]}", date = "2019-07-09 03:29:00")
	public static TCResult P_Trans2QueryDict(JavaDict target) {
		AppLogger.info("查询容器转换 P_Trans2QueryDict() 开始");
		try {
			JavaList ret = new JavaList();
			if (target != null && target.size() != 0) {
				int vn = 0;
				for (Object key : target.keySet()) {
					vn = target.getListItem(key).size();
					break;
				}
				for (int v = 0; v < vn; v++) {
					JavaDict tmp = new JavaDict();
					for (Object key : target.keySet()) {
						tmp.setItem(key, target.getListItem(key).get(v));
					}
					ret.add(tmp);
				}
			}
			return CIResult.newSuccessResult(ret);
		} catch (Exception e) {
			AppLogger.info("查询容器转换失败: " + e);
			AppLogger.info(e);
			return TCResult.newFailureResult(CommonErrorCodeEnum.DICT_SET_VALUE_ERROR.getCode(), "查询容器转换失败");
		}
	}

}
