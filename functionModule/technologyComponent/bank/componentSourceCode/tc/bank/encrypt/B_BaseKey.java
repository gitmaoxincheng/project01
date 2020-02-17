package tc.bank.encrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.union.api.UnionEsscAPI;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.encrypt.service.UnionAPIService;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 基础秘钥管理
 * 
 * @date 2019-08-29 19:34:58
 */
@ComponentGroup(level = "银行", groupName = "基础秘钥管理")
public class B_BaseKey {
	private static Logger logger = Logger.getLogger(B_BaseKey.class);

	/**
	 * @category 申请终端秘钥
	 * @param devno
	 *            入参|设备号|{@link java.lang.String}
	 * @since returnDict
	 *        出参|秘钥校验值|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "devno", comment = "设备号", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "returnDict", comment = "秘钥校验值", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "申请终端秘钥", style = "判断型", type = "同步组件", date = "2019-09-26 07:01:07")
	public static TCResult B_applyFinalKey(String devno) {
		return TechComp.callWithBean(UnionAPIService.class, (unionAPIService) -> {
			JavaDict returnData = new JavaDict();
			JavaDict body = new JavaDict();
			JavaDict header = new JavaDict();
			UnionEsscAPI shortApi = unionAPIService.getConnection();
			Map<String, Object> pin = unionAPIService.getWorkPinKey(devno, shortApi);
			Map<String, Object> mac = unionAPIService.getWorkMacKey(devno, shortApi);
			if (pin.get("ErrorCode") == null && pin.get("ErrorCode") == null) {
				body.put("pinmy", pin.get("my"));
				body.put("pinjyz", pin.get("jyz"));
				body.put("macmy", mac.get("my"));
				body.put("macjyz", mac.get("jyz"));
				header.put("ErrorCode", "AAAAAAAAAA");
			} else {
				header.put("ErrorCode", pin.get("ErrorCode").toString() + mac.get("ErrorCode").toString());
				if (pin.get("ErrorMsg") == null && mac.get("ErrorMsg") == null) {
					header.put("ErrorMsg", "连接服务器失败，交易失败");
				} else {
					header.put("ErrorMsg", (String) pin.get("ErrorMsg") + mac.get("ErrorMsg"));
				}
			}
			returnData.put("body", body);
			returnData.put("header", header);
			return new Object[] { returnData };
		});
	}

	/**
	 * @category 更新终端秘钥
	 * @param devno
	 *            入参|设备号|{@link java.lang.String}
	 * @param keyType
	 *            入参|秘钥类型|{@link java.lang.String}
	 * @since returnDict
	 *        出参|返回秘钥数据|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "devno", comment = "设备号", type = java.lang.String.class),
			@Param(name = "keyType", comment = "秘钥类型", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "returnDict", comment = "返回秘钥数据", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "更新终端秘钥", style = "判断型", type = "同步组件", date = "2019-09-26 07:02:19")
	public static TCResult B_updateKey(String devno, String keyType) {
		return TechComp.callWithBean(UnionAPIService.class, (unionAPIService) -> {
			// logger.info("开始 组件调用");
			JavaDict returnData = new JavaDict();
			Map<String, Object> pin = new HashMap<>();
			logger.info("keyType" + keyType);
			UnionEsscAPI shortApi = unionAPIService.getConnection();
			if (keyType.equals("zmk")) {
				pin = unionAPIService.getMainKey(devno, shortApi);
			} else if (keyType.equals("zpk")) {
				pin = unionAPIService.getWorkPinKey(devno, shortApi);
			} else if (keyType.equals("zak")) {
				pin = unionAPIService.getWorkMacKey(devno, shortApi);
			}
			JavaDict body = new JavaDict();
			JavaDict header = new JavaDict();
			if (pin.get("ErrorCode") == null) {
				body.put("keyValue", pin.get("my"));
				body.put("checkValue", pin.get("jyz"));
				header.put("ErrorCode", "AAAAAAAAAA");
			} else {
				header.put("ErrorCode", pin.get("ErrorCode"));
				if (pin.get("ErrorMsg") == null) {
					header.put("ErrorMsg", "连接服务器失败，交易失败");
				} else {
					header.put("ErrorMsg", pin.get("ErrorMsg"));
				}
			}
			returnData.put("body", body);
			returnData.put("header", header);
			return new Object[] { returnData };
		});
	}

	/**
	 * @category 秘钥公共字段赋值
	 * @param transFlag
	 *            入参|传输标志|{@link java.lang.String}
	 * @param userInfo
	 *            入参|用户信息|{@link java.lang.String}
	 * @param request
	 *            入参|渠道入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since returnData
	 *        出参|返回数据|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "transFlag", comment = "传输标志", defaultParam = "'1'", type = java.lang.String.class),
			@Param(name = "userInfo", comment = "用户信息", type = java.lang.String.class),
			@Param(name = "request", comment = "渠道入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "returnData", comment = "返回数据", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "秘钥公共字段赋值", style = "判断型", type = "同步组件", date = "2019-09-26 07:03:09")
	public static TCResult B_keyPublicParse(String transFlag, String userInfo, JavaDict request) {
		return TechComp.callWithBean(UnionAPIService.class, (unionAPIService) -> {
			JavaDict dict = new JavaDict();
			Map<String, Object> map = unionAPIService.getSysAndAppId();
			dict.put("sysID", map.get("sysID"));
			dict.put("appID", map.get("appID"));
			dict.put("userInfo", userInfo);
			dict.put("transFlag", transFlag);
			String Date = DateTimeUtil.getSysDate();
			String time = DateTimeUtil.getSysTime();
			String transTime = Date + time;
			dict.put("transTime", transTime);
			dict.put("clientIPAddr", request.getStringItem("__LOCAL_IP__"));
			return new Object[] { dict };
		});
	}

	/**
	 * @category 校验返回数据赋值
	 * @param ErrorCode
	 *            入参|后台成功标识|{@link java.lang.String}
	 * @param reqData
	 *            入参|入参数据|{@link java.util.Map}
	 * @param param
	 *            入参|校验参数值|{@link java.lang.String}
	 * @since rspData
	 *        出参|返回数据|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "ErrorCode", comment = "后台成功标识", type = java.lang.String.class),
			@Param(name = "reqData", comment = "入参数据", type = java.util.Map.class),
			@Param(name = "param", comment = "校验参数值", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "rspData", comment = "返回数据", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "校验返回数据赋值", style = "判断型", type = "同步组件", date = "2019-08-30 09:45:05")
	public static TCResult B_checkData(String ErrorCode, Map reqData, String param) {
		logger.debug("csisHeaderMap--------" + reqData);
		String string = String.valueOf(reqData.get("ErrorMsg"));
		logger.debug("ErrorMsg--------" + string);
		if (ErrorCode.equals(reqData.get(param))) {
			reqData.put(param, "AAAAAAAAAA");
		}
		// 结果集Map转Dict
		JavaDict resultDict = JavaDictUtil.mapToDict(reqData);
		logger.debug("csisHeaderMap--------" + reqData);
		return TCResult.newSuccessResult(resultDict);
	}

	/**
	 * @category 发送短信
	 * @param reqData
	 *            入参|入参数据|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param initData
	 *            入参|初始入参|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since rspData
	 *        出参|出参数据|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	
	@InParams(param = {
			@Param(name = "reqData", comment = "入参数据", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "initData", comment = "初始入参", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = {
			@Param(name = "rspData", comment = "出参数据", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "发送短信", style = "判断型", type = "同步组件", comment = "发送短信", date = "2019-12-26 03:29:41")
	public static TCResult B_sendMail(JavaDict reqData, JavaDict initData) {
		logger.info("-------开始发送短信----------");
		String authcode = reqData.getStringItem("authCode");//认证码
		String devno = initData.getStringItem("termID");//设备号
		String templateno = "CSI_000006";//短信模板编号
		String msgtype = "1";//短信类型
		JavaDict msgDict = new JavaDict();
		JavaDict resultDict = new JavaDict();
		ArrayList msgList = new ArrayList();
		msgDict.put("authcode", authcode);
		msgDict.put("devno", devno);
		resultDict.put("templateno", templateno);
		resultDict.put("msgtype", msgtype);
		msgList.add(msgDict);
		resultDict.put("msg_list", msgList);
		return TCResult.newSuccessResult(resultDict);
	}

}
