package tc.platform.service.communication.base;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseException;

public class EciHeader {

	public static Map<String, Object> buildRequestMessagHeader(JavaDict reqDict)
			throws BaseException {

		//可以看做参数检查,后期改进
		JavaList notNullInput = new JavaList("eciSeverId", "templateCodeName",
				"transCode", "sysId", "channelCode", "subchannelCode",
				"prcscd", "channelserno");

		for (int i = 0; i < notNullInput.size(); i++) {

			String checkString = reqDict.getStringItem(notNullInput
					.getStringItem(i));

			if (checkString == null || checkString.isEmpty()) {
				AppLogger.error("buildRequestMessagHeader拼包字段["
						+ notNullInput.getStringItem(i) + "]不能为空");
				throw new BaseException(CommonErrorCodeEnum.MESSAGE_FIELD_EMPTY,
						"buildRequestMessagHeader拼包字段["
								+ notNullInput.getStringItem(i) + "]不能为空");
				
			}
		}
		
		// -------------------------EciHeader-----------------------------------
		Map<String, Object> eciHeader = new LinkedHashMap<String, Object>();
		eciHeader.put("eciSeverId", reqDict.getStringItem("eciSeverId"));
		eciHeader.put("xmlflag", "1");
		eciHeader.put("templateCodeName",
				reqDict.getStringItem("templateCodeName"));
		eciHeader.put("transCode", reqDict.getStringItem("transCode"));
		eciHeader.put("sysId", reqDict.getStringItem("sysId"));
		eciHeader.put("channelCode", reqDict.getStringItem("channelCode"));
		eciHeader
				.put("subchannelCode", reqDict.getStringItem("subchannelCode"));
		eciHeader.put("tradeFlag", reqDict.getStringItem("tradeFlag", "0"));
		eciHeader.put("checkFlag", reqDict.getStringItem("checkFlag", "0"));
		eciHeader.put("prcscd", reqDict.getStringItem("prcscd"));
		eciHeader.put("channelserno", reqDict.getStringItem("channelserno"));
		eciHeader.put("vm_tellerflag",
				reqDict.getStringItem("vm_tellerflag", "0"));
		eciHeader.put("vm_sessid", reqDict.getStringItem("vm_sessid", ""));
		eciHeader.put("vm_zoneno", reqDict.getStringItem("vm_zoneno", ""));
		eciHeader.put("vm_mbrno", reqDict.getStringItem("vm_mbrno", ""));
		eciHeader.put("vm_brno", reqDict.getStringItem("vm_brno", ""));
		eciHeader.put("vm_tellerno", reqDict.getStringItem("vm_tellerno", ""));
		eciHeader.put("vm_tellertp", reqDict.getStringItem("vm_tellertp", ""));
		eciHeader.put("vm_csbxno", reqDict.getStringItem("vm_csbxno", ""));
		eciHeader.put("vm_dutytp", reqDict.getStringItem("vm_dutytp", ""));
		eciHeader.put("vm_dutyno", reqDict.getStringItem("vm_dutyno", ""));
		eciHeader.put("sessid", reqDict.getStringItem("sessid", ""));
		eciHeader.put("zoneno", reqDict.getStringItem("zoneno", ""));
		eciHeader.put("mbrno", reqDict.getStringItem("mbrno", ""));
		eciHeader.put("brno", reqDict.getStringItem("brno", ""));
		eciHeader.put("tellerno", reqDict.getStringItem("tellerno", ""));
		eciHeader.put("tellertp", reqDict.getStringItem("tellertp", ""));
		eciHeader.put("csbxno", reqDict.getStringItem("csbxno", ""));
		eciHeader.put("dutytp", reqDict.getStringItem("dutytp", ""));
		eciHeader.put("dutyno", reqDict.getStringItem("dutyno", ""));
		eciHeader.put("authno", reqDict.getStringItem("authno", ""));
		eciHeader.put("authpw", reqDict.getStringItem("authpw", ""));
		eciHeader.put("authmg", reqDict.getStringItem("authmg", ""));
		eciHeader.put("authce", reqDict.getStringItem("authce", ""));
		eciHeader.put("authmanfttype",
				reqDict.getStringItem("authmanfttype", ""));

		return eciHeader;
		
	}
	
}
