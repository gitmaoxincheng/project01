package tc.platform.component.communicate;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.CIResult;
import tc.platform.util.ConvertUtils;

/**
 * Json处理类组件
 * 
 * @date 2019-05-21 8:51:59
 */
@ComponentGroup(level = "平台", groupName = "通讯类组件")
public class P_Json {

	/**
	 * @category JSON拆包
	 * @param from
	 *            入参|目标容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param target
	 *            入参|取键|{@link java.lang.String}
	 * @param flag
	 *            入参|是否拆报文体|boolean
	 * @since to 出参|存储容器|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "from", comment = "目标容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "target", comment = "取键", type = java.lang.String.class),
			@Param(name = "flag", comment = "是否拆报文体", type = boolean.class) })
	@OutParams(param = { @Param(name = "to", comment = "存储容器", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "JSON拆包", style = "判断型", type = "同步组件", comment = "解析Json格式的__REQ__['__RCVPCK__']", date = "2019-05-28 04:46:26")
	public static TCResult P_JsonUnpack(JavaDict from, String target, boolean flag) {
		AppLogger.info("---------------json拆包 P_JsonUnpack() 开始-------------------");
		try {
			String __RCVPCK__ = new String((byte[]) from.getItem(target));
			AppLogger.info("[info]-打印json请求报文string:" + __RCVPCK__);
			JSONObject jsonObject = null;
			try {
				jsonObject = JSON.parseObject(__RCVPCK__);
			} catch (Exception e) {
				AppLogger.error("[error]-json报文转JSONObejct失败 : " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.STRING_TO_JSONOBJECT_ERROR);
			}
			AppLogger.info("[info]-jsonObject: " + jsonObject);
			JavaDict jsonDict = null;
			try {
				jsonDict = ConvertUtils.json2Dict(jsonObject);
			} catch (Exception e) {
				AppLogger.error("[error]-json报文转JavaDict失败 : " + e);
				AppLogger.error(e);
				return CIResult.newFailureResult(CommonErrorCodeEnum.JSONOBJECT_TO_DICT_ERROR);
			}
			AppLogger.info("[info]-打印解析后请求报文dict: " + jsonDict);
//			jsonDict = CommService.msgUnpackHandler(jsonDict, CommConstant.COMMPRO_JSON, flag);
			jsonDict = null; //XXX 待完善
			JavaDict __REQ__ = (JavaDict) EnvContextHolder.getHolder().getContext().getRequest();
			jsonDict.setItem(CommConstant.SRVPORT, __REQ__.getItem(CommConstant.SRVPORT));
			AppLogger.info("[info]-打印处理后请求报文dict: " + jsonDict);
			return CIResult.newSuccessResult(jsonDict);
		}  catch (Exception e) {
			AppLogger.info("[error]-P_JsonUnpack(): " + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.UNPACK_JSON_ERR);
		} finally {
			AppLogger.info("---------------json拆包  P_JsonUnpack() 结束-------------------");
		}
	}

	/**
	 * @category JSON拼包
	 * @param fromReq
	 *            入参|请求交易容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param fromRsp
	 *            入参|返回交易容器|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @since to 出参|返回容器|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = {
			@Param(name = "fromReq", comment = "请求交易容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "fromRsp", comment = "返回交易容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@OutParams(param = { @Param(name = "to", comment = "返回容器", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "JSON拼包", style = "判断型", type = "同步组件", comment = "拼接JSON报文", date = "2019-05-23 09:35:03")
	public static TCResult P_JsonPacket(JavaDict fromReq, JavaDict fromRsp) {
		AppLogger.info("---------------json拼包  P_JsonPacket() 开始-------------------");
		try {
			Map<String, Object> dict = null; //XXX 待完善
			AppLogger.info("[info]-打印拼包后json报文dict：" + dict);
			return CIResult.newSuccessResult(JSON.toJSONString(dict));
		} catch (Exception e) {
			AppLogger.info("[error]-P_JsonPacket():" + e);
			AppLogger.error(e);
			return CIResult.newFailureResult(CommonErrorCodeEnum.PACKET_JSON_ERR);
		} finally {
			AppLogger.info("---------------json拼包  P_JsonPacket() 结束-------------------");
		}
	}

}
