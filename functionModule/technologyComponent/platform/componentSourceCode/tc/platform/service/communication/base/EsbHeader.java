package tc.platform.service.communication.base;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import tc.platform.constant.exception.CommonErrorCodeEnum;
import tc.platform.context.exception.BaseException;

/**
 * 拼接esb头文件信息
 * @author admin
 *
 */
public class EsbHeader {
	
	public static Map<String, Object> buildRequestMessagHeader(JavaDict reqDict)
			throws BaseException {
		
		//可以看做参数检查,后期改进
		JavaList notNullInput = new JavaList( "SrcDate", "SrcTime",
				"SrcSysId", "SrcCalCod", "GloSeqNo", "ReqNo" );
		
		for (int i = 0; i < notNullInput.size(); i++) {

			String checkString = reqDict.getStringItem(notNullInput.getStringItem(i));

			if (checkString == null || checkString.isEmpty()) {
				AppLogger.error("buildRequestMessagHeader拼包字段["
						+ notNullInput.getStringItem(i) + "]不能为空");
				throw new BaseException(CommonErrorCodeEnum.MESSAGE_FIELD_EMPTY,
						"buildRequestMessagHeader拼包字段["
								+ notNullInput.getStringItem(i) + "]不能为空");
			}
		}
		
		// -------------------------EsbHeader-----------------------------------
		Map<String, Object> esbHeader = new LinkedHashMap<String, Object>();
		esbHeader.put("VrsNo", reqDict.getStringItem("VrsNo", ""));// 服务版本号
		esbHeader.put("ScnNo", reqDict.getStringItem("ScnNo", ""));// 场景版本号
		esbHeader.put("SrcDate", reqDict.getStringItem("SrcDate"));// 源发起方日期
		esbHeader.put("SrcTime", reqDict.getStringItem("SrcTime"));// 源发起方时间
		esbHeader.put("SrcSysId", reqDict.getStringItem("SrcSysId"));// 源发起方系统标识
		esbHeader.put("SrcCalCod", reqDict.getStringItem("SrcCalCod"));// 源发起方渠道编号
		esbHeader.put("GloSeqNo", reqDict.getStringItem("GloSeqNo"));// 全局流水号
		esbHeader.put("GloEndTime", reqDict.getStringItem("GloEndTime"));// 全局截止时间
		esbHeader.put("ReqNo", reqDict.getStringItem("ReqNo"));// 上送流水号
		esbHeader.put("RspNo", "");// 返回流水号
		esbHeader.put("SrvTranDt", "");// 服务方交易日期
		esbHeader.put("TellerNo", reqDict.getStringItem("TellerNo"));// 柜员号
		esbHeader.put("TellerTp", reqDict.getStringItem("TellerTp"));// 柜员类别
		esbHeader.put("BrNo", reqDict.getStringItem("BrNo"));// 机构号
		esbHeader.put("ZoneNo", reqDict.getStringItem("ZoneNo"));// 分行号
		esbHeader.put("MyBank", reqDict.getStringItem("MyBank"));// 组织机构
		esbHeader.put("RespSts", "");// 状态码 S成功 F失败 U未知
		esbHeader.put("ErrorCode", "");// 消息码
		esbHeader.put("ErrorMsg", "");// 消息码描述
		esbHeader.put("TechFlwMsg", "");// 技术跟踪码
		esbHeader.put("SrcIP1", reqDict.getStringItem("SrcIP1"));	// 源请求方服务器IP
		esbHeader.put("SrcIP2", reqDict.getStringItem("SrcIP2"));	// 直接请求方服务器IP

		return esbHeader;
	}
}
