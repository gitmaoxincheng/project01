package tc.platform.component.commom;

import java.util.Iterator;
import java.util.List;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.TechUtils;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.tl.exception.busi.ApNullArgsException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTooLongException;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseException;
import tc.platform.util.ConvertUtils;

/**
 * 参数检查
 * 
 * @date 2019-05-27 12:8:33
 */
@ComponentGroup(level = "平台", groupName = "参数检查组件")
public class P_ParameterCheck {

	/**
	 * @category 必传参数检查
	 * @param params
	 *            入参|必传参数|{@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @param dict
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "params", comment = "必传参数", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class),
			@Param(name = "dict", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "必传参数检查", style = "判断型", type = "同步组件", comment = "检查前端上传参数值是否为空", date = "2019-06-03 11:51:24")
	@SuppressWarnings("unlikely-arg-type")
	public static TCResult P_chkValIsEmpty(JavaList params, JavaDict dict) {
		AppLogger.debug(String.format("-- 入参(params): %s", params));
		try {
			if (params == null || params.size() == 0) {
				return TCResult.newSuccessResult();
			}
			JavaDict __REQ__ = dict;
			Iterator<Object> iterator = params.iterator();
			while (iterator.hasNext()) {
				Object p = iterator.next();
				if (!(p instanceof List)) {
					String errorCode = CommonErrorCodeEnum.PAPAMETER_INTERNSL_NOT_JAVALIST.getCode();
					String errorMsg = String.format("传入参数[%s]类型不是LIST", p.toString());
					AppLogger.error("-P_chkValIsEmpty(): " + errorMsg);
					return TCResult.newFailureResult(errorCode, errorMsg);
				}
				if ("Y".equals(__REQ__.getStringItem("Iphone_DgsysId"))) {
					if (((List) p).size() != 2) {
						String errorCode = CommonErrorCodeEnum.PAPAMETER_INTERNSL_LENGTH_ERROR.getCode();
						String errorMsg = String.format("传入参数[%s]长度不对", p.toString());
						AppLogger.error("-P_chkValIsEmpty(): " + errorMsg);
						return TCResult.newFailureResult(errorCode, errorMsg);
					}
					String iphoneValue = ((JavaList) p).getStringItem(0);
					if ("".equals(__REQ__.getItem(iphoneValue, ""))) {
						String errorCode = CommonErrorCodeEnum.PARAMETER_ISEMPTY.getCode();
						String errorMsg = String.format("传入参数[%s]不能为空", iphoneValue);
						AppLogger.error("-P_chkValIsEmpty(): " + errorMsg);
						return TCResult.newFailureResult(errorCode, errorMsg);
					}
				} else {
					String colName = "";
					if (((List) p).size() == 3) {
						colName = ((JavaList) p).getStringItem(2);
					} else {
						colName = ((JavaList) p).getStringItem(0);
					}
					if (!__REQ__.hasKey(((JavaList) p).getStringItem(0))
							|| TechUtils.len(__REQ__.getItem(((JavaList) p).getStringItem(0))) == 0) {
						AppLogger.error(
								String.format("-P_chkValIsEmpty()没有上传参数[%s]", ((JavaList) p).getStringItem(0)));
						return TCResult.newFailureResult(CommonErrorCodeEnum.PARAMETER_ISEMPTY.getCode(),
								String.format("没有上传参数[%s]", colName));
					}
					if ("X".equals(((JavaList) p).getStringItem(1).substring(0, 1))) {
						Object req = __REQ__.getItem(((JavaList) p).getStringItem(0));
						if (req instanceof String) {
							if (((String) req).length() > Integer
									.parseInt(((JavaList) p).getStringItem(1).substring(1))) {
								AppLogger.error(String.format("-P_chkValIsEmpty()上传参数[%s]长度超过最大长度[%s]",
										((JavaList) p).getStringItem(0), ((JavaList) p).getStringItem(1).substring(1)));
								return TCResult.newFailureResult(
										CommonErrorCodeEnum.PAPAMETER_INTERNSL_LENGTH_ERROR.getCode(),
										String.format("参数[%s]长度超过最大长度[%s]", colName,
												((JavaList) p).getStringItem(1).substring(1)));
							}
						}
						if (req instanceof List) {
							Iterator<String> interator = ((List) req).iterator();
							while (iterator.hasNext()) {
								String r = (String) iterator.next();
								if (r.length() > Integer.parseInt(((JavaList) p).getStringItem(1).substring(1))) {
									AppLogger.error(String.format("-P_chkValIsEmpty()上传参数[%s]长度超过最大长度[%s]",
											((JavaList) p).getStringItem(0),
											((JavaList) p).getStringItem(1).substring(1)));
									return TCResult.newFailureResult(
											CommonErrorCodeEnum.PAPAMETER_INTERNSL_LENGTH_ERROR.getCode(),
											String.format("参数[%s]长度超过最大长度[%s]", colName,
													((JavaList) p).getStringItem(1).substring(1)));
								}
							}
						}
					}
					if ("T".equals(((JavaList) p).getStringItem(1).substring(0, 1))) {
						Object req = __REQ__.getItem(((JavaList) p).getStringItem(0));
						if (req instanceof String) {
							try {
								if (ConvertUtils.toDoubleByte((String) req).length() > Integer
										.parseInt(((JavaList) p).getStringItem(1).substring(1))) {
									AppLogger.error(String.format("-P_chkValIsEmpty()上传参数[%s]长度超过最大长度[%s]",
											((JavaList) p).getStringItem(0),
											((JavaList) p).getStringItem(1).substring(1)));
									return TCResult.newFailureResult(
											CommonErrorCodeEnum.PAPAMETER_INTERNSL_LENGTH_ERROR.getCode(),
											String.format("参数[%s]长度超过最大长度[%s]", colName,
													((JavaList) p).getStringItem(1).substring(1)));
								}
							} catch (BaseException e) {
								String errorMsg = String.format("-toDoubleByte()字符编码错误,[%s]存在生僻字,请修改", colName);
								AppLogger.error(errorMsg);
								return TCResult.newFailureResult(e.getErrorCode().getCode(), errorMsg);
							}
						}
						if (req instanceof List) {
							Iterator<String> interator = ((List) req).iterator();
							while (iterator.hasNext()) {
								String r = (String) iterator.next();
								try {
									if (ConvertUtils.toDoubleByte((String) req).length() > Integer
											.parseInt(((JavaList) p).getStringItem(1).substring(1))) {
										AppLogger.error(String.format("-P_chkValIsEmpty()上传参数[%s]长度超过最大长度[%s]",
												((JavaList) p).getStringItem(0),
												((JavaList) p).getStringItem(1).substring(1)));
										return TCResult.newFailureResult(
												CommonErrorCodeEnum.PAPAMETER_INTERNSL_LENGTH_ERROR.getCode(),
												String.format("参数[%s]长度超过最大长度[%s]", colName,
														((JavaList) p).getStringItem(1).substring(1)));
									}
								} catch (BaseException e) {
									String errorMsg = String.format("-toDoubleByte()字符编码错误,[%s]存在生僻字,请修改",
											colName);
									AppLogger.error(errorMsg);
									return TCResult.newFailureResult(e.getErrorCode().getCode(), errorMsg);
								}
							}
						}
					}
				}
			}
			return TCResult.newSuccessResult();
		} catch (Exception e) {
			AppLogger.error(String.format("-chkValIsEmpty(): ", e));
			AppLogger.error(e);
			return TCResult.newFailureResult(CommonErrorCodeEnum.CHKVAL_IS_EMPTY_ERROR.getCode(),
					CommonErrorCodeEnum.CHKVAL_IS_EMPTY_ERROR.getMsg());
		}
	}

	/**
	 * @category 请求参数校验
	 * @param reqDict
	 *            入参|请求容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param chkList
	 *            入参|需要检验的参数值,
	 *            如[[参数字段名1,是否必传1(Y/N),参数长度1,参数中文名1],[参数字段名2,是否必传2(Y/N),参数长度2,参数中文名2]...]|{@link cn.com.agree.afa.svc.javaengine.context.JavaList}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "reqDict", comment = "请求容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "chkList", comment = "需要检验的参数值, 如[[参数字段名1,是否必传1(Y/N),参数长度1,参数中文名1],[参数字段名2,是否必传2(Y/N),参数长度2,参数中文名2]...]", type = cn.com.agree.afa.svc.javaengine.context.JavaList.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "请求参数校验", style = "判断型", type = "同步组件", comment = "请求参数校验,需要检验的参数值, 如[[参数字段名1,是否必传1(Y/N),参数长度1,参数中文名1],[参数字段名2,是否必传2(Y/N),参数长度2,参数中文名2]...]", date = "2019-06-06 10:19:34")
	public static TCResult P_paramsCheck(JavaDict reqDict, JavaList chkList) {
		return TechComp.call(() -> {
			if (chkList == null || reqDict ==null) {
				throw new ApNullArgsException("chkList或reqDict", "需要检验的参数值");
			}
			for (int i = 0; i < chkList.size(); i++) {
				JavaList st = (JavaList) chkList.get(i);
				String inputParamName = st.getItem(0);
				String checkString = reqDict.getStringItem(inputParamName, "");
				int maxLength = Integer.valueOf(st.getItem(2));
				if (st.getStringItem(1).toUpperCase().equals("Y")) {
					if (checkString.isEmpty()) {
						throw new ApNullArgsException(st.getItem(0), st.getItem(3));
					}
				}
				int checkStringLength = checkString.getBytes().length;
				if (checkStringLength > maxLength) {
					throw new ApValueTooLongException(checkStringLength, maxLength, st.getItem(3));
				}
			}
			return null;
		});
	}

}
