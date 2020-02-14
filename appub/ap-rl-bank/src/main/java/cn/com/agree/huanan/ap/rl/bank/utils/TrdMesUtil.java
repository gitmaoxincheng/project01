package cn.com.agree.huanan.ap.rl.bank.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 报文工具类
 * 
 * @author
 */
public class TrdMesUtil {

	/**
	 * 获取标准报文头--前37个字段 但不包括
	 *  02--SERIALNO--登记平台流水 
	 *  06--SERVECODE_OUT--外部服务码
	 * 07--SCENECODE_OUT--外部场景码 
	 * 08--SERVECODE--服务码 
	 * 09--SCENECODE--场景码
	 * 11--REQCALCOD--请求方渠道编码
	 *  25--RESPSTS--交易状态 28--BACKSERVECODE--后台服务码
	 * 29--BACKSCENECODE--后台场景码
	 *  30--BACKSYSDATE--后台交易日期 
	 *  31--BACKSYSNO--后台交易流水
	 * 32--BACKSYSSTS--后台交易状态 
	 * 33--BACKSYSERRORCODE--后台消息码
	 * 34--BACKSYSERRORMSG--后台消息码描述 
	 * 35--UPDDATE--更新日期
	 *  36--UPDTIME--更新时间
	 * 
	 * @param dataSource
	 *            数据源--报文体
	 * @return map 需要获取的键值对
	 */
	public static Map<String, String> getStdHeader(JavaDict messageBody) {

		// AppHeader数据
		JavaDict appHeaderSource = messageBody.getDictItem(CommConstant.APP_HEADER);
		// CsisHeader数据
		JavaDict csisHeaderSource = messageBody.getDictItem(CommConstant.CSIS_HEADER);
		// Header数据
		JavaDict headerSource = messageBody.getDictItem(CommConstant.HEADER);

		Map<String, String> map = new HashMap<>();
		// 登记平台日期
		map.put("tradeDate", DateTimeUtil.getSysDate());
		// 登记平台时间
		map.put("tradeTime", DateTimeUtil.getSysTime());
		// 子交易事务标识,0不适用1强事务2弱事务，目前默认为：0不适用，主要用来控制流程组件交易的一致性，暂时不涉及。
		map.put("subtransFlag", "0");
		// 应用报文头APPheader的billno-单据号
		map.put("bussceNo", appHeaderSource.getStringItem(CommConstant.BILLNO, ""));
		// JSON标准头中的：address字段
		map.put("reqSysId", headerSource.getStringItem(CommConstant.ADDRESS, ""));
		// CsisHeader-渠道整标准报文头中中的：SrcDate
		map.put("reqDate", csisHeaderSource.getStringItem(CommConstant.SRCDATE, ""));
		// CsisHeader-渠道整标准报文头中中的：SrcTime
		map.put("reqTime", csisHeaderSource.getStringItem(CommConstant.SRCTIME, ""));
		// CsisHeader-渠道整标准报文头中中的：ReqNo
		map.put("reqSerialNo", csisHeaderSource.getStringItem(CommConstant.REQNO, ""));
		// CsisHeader-渠道整标准报文头中中的：SrcSysId
		map.put("scrSysId", csisHeaderSource.getStringItem(CommConstant.SRCSYSID, ""));
		// CsisHeader-渠道整标准报文头中中的：SrcCalCod
		map.put("scrCalCod", csisHeaderSource.getStringItem(CommConstant.SRCCALCOD, ""));
		// CsisHeader-渠道整标准报文头中中的：GloSeqNo
		map.put("golSeqNo", csisHeaderSource.getStringItem(CommConstant.GloSeqNo, ""));
		// CsisHeader-渠道整标准报文头中中的：TellerNo
		map.put("tellerNo", csisHeaderSource.getStringItem(CommConstant.TLRNO, ""));
		// CsisHeader-渠道整标准报文头中中的：TellerTp
		map.put("tellerTp", csisHeaderSource.getStringItem(CommConstant.TLRTP, ""));
		// CsisHeader-渠道整标准报文头中中的：MyBank
		map.put("myBank", csisHeaderSource.getStringItem(CommConstant.MYBANK, ""));
		// CsisHeader-渠道整标准报文头中中的：ZoneNo
		map.put("zoneNo", csisHeaderSource.getStringItem(CommConstant.ZONENO, ""));
		// APPHeader-渠道整合应用报文头：mbrno
		map.put("mbrNo", appHeaderSource.getStringItem(CommConstant.MBRNO, ""));
		// CsisHeader-渠道整标准报文头中中的：BrNo
		map.put("brNo", csisHeaderSource.getStringItem(CommConstant.BRNO, ""));
		// APPHeader-渠道整合应用报文头：devno
		map.put("devNo", appHeaderSource.getStringItem(CommConstant.DEVNO, ""));
		// APPHeader-渠道整合应用报文头：authbrno
		map.put("authTellerNo", appHeaderSource.getStringItem(CommConstant.AUTHNO, ""));
		// CsisHeader-渠道整标准报文头中的
		map.put("errorCode", csisHeaderSource.getStringItem(CommConstant.ERROR_CODE, ""));
		// CsisHeader-渠道整标准报文头中中的：
		map.put("errorMsg", csisHeaderSource.getStringItem(CommConstant.ERROR_MSG, ""));

		return map;
	}

	/**
	 * 从报文dataSource中获取map中指定的值
	 * @param dataSource
	 * @param fields
	 * @return
	 */
	public static Map<String, String> getMessageBody(JavaDict dataSource, Map<String, String> fields) {

		HashMap<String, String> map = new HashMap<>();

		// 循环数组对数据源dataSource获取所有的参数 返回的默认值为空
		// poKey PO类的键,mesField报文的值
		fields.forEach((poKey, mesField) -> {
			map.put(poKey,dataSource.getStringItem(mesField, ""));
		});

		return map;
	}

	/**
	 * 
	 * @param clazz
	 *            Po的类对象
	 * @param map
	 *            对Po对象填充的数据
	 * @return
	 * @throws IllegalAccessException 
	 */
	public static <T> T mapToPoIntance(Class<T> clazz, Map<String, String> map) throws ClassNotFoundException {
		T PO;
		// 创建一个Po类
		try {
			PO = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// 创建Po失败返回null
			throw new ClassNotFoundException("创建"+clazz.getName()+"实例失败");
		}

		// 对遍历map中的值，并尝试对PO的属性赋值
		map.forEach((key, value) -> {
			try {
				PropertyDescriptor proper = new PropertyDescriptor(key, clazz);
				proper.getWriteMethod().invoke(PO, value);
			} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// PO对象中没有key这个属性
				// 跳过,不做任何处理
			}
		});

		return PO;
	}
}
