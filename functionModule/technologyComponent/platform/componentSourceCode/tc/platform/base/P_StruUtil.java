package tc.platform.base;

import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.jcomponent.ErrorCode;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.util.StrUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 字符操作库
 * 
 * @date 2018-08-21 20:36:21
 */
@ComponentGroup(level = "平台", groupName = "字符操作库")
public class P_StruUtil {

	/**
	 * @category 字节数组转字符串
	 * @param bArray
	 *            入参|字节数组|byte
	 * @param encoding
	 *            入参|字符编码|{@link java.lang.String}
	 * @since str 出参|字符串|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "bArray", comment = "字节数组", logLevel = "0", type = byte[].class),
			@Param(name = "encoding", comment = "字符编码", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "str", comment = "字符串", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@Component(label = "字节数组转字符串", style = "判断型", type = "同步组件", comment = "字节数组转字符串", author = "Administrator", date = "2018-08-21 09:12:29")
	public static TCResult P_byteArray2String(byte[] bArray, String encoding) {
		return TechComp.call(() -> {
			return new Object[] { StrUtil.byteArray2String(bArray, encoding) };
		});
	}

	/**
	 * @category 字符串截取
	 * @param inStr
	 *            入参|输入字符串|{@link java.lang.String}
	 * @param start
	 *            入参|开始位置|int
	 * @param end
	 *            入参|结束位置,-1代表到结束|int
	 * @since outStr 出参|截取后的字符串|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 */
	@InParams(param = { @Param(name = "inStr", comment = "输入字符串", type = java.lang.String.class),
			@Param(name = "start", comment = "开始位置", type = int.class),
			@Param(name = "end", comment = "结束位置,-1代表到结束", type = int.class) })
	@OutParams(param = { @Param(name = "outStr", comment = "截取后的字符串", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "字符串截取", style = "判断型", type = "同步组件", comment = "获取输入字符串的子串,取start到end-1的子串", date = "2019-08-15 05:45:51")
	public static TCResult P_subStr(String inStr, int start, int end) {
		if (inStr == null) {
			return TCResult.newFailureResult(ErrorCode.AGR, "输入字符串参数非法，为空");
		}
		if (end == -1) {
			return TCResult.newSuccessResult(inStr.substring(start));
		}
		return TCResult.newSuccessResult(inStr.substring(start, end));
	}

	/**
	 * @category 字符串拼接
	 * @param srcStr
	 *            入参|源字符串|{@link java.lang.String}
	 * @param separator
	 *            入参|分隔符|{@link java.lang.String}
	 * @param objStr
	 *            入参|要拼接的字符串|{@link java.lang.String}
	 * @since rspStr 出参|拼接后的字符串|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "srcStr", comment = "源字符串", type = java.lang.String.class),
			@Param(name = "separator", comment = "分隔符", type = java.lang.String.class),
			@Param(name = "objStr", comment = "要拼接的字符串", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "rspStr", comment = "拼接后的字符串", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "字符串拼接", style = "判断型", type = "同步组件", date = "2019-10-09 07:44:42")
	public static TCResult P_strJoint(String srcStr, String separator, String objStr) {
		if (srcStr == null) {
			return TCResult.newFailureResult(ErrorCode.AGR, "源字符串不能为空");
		}
		if (objStr == null) {
			return TCResult.newFailureResult(ErrorCode.AGR, "目标字符串不能为空");
		}
		if (separator == null) {
			return TCResult.newFailureResult(ErrorCode.AGR, "分隔符不能为空");
		}
		StringBuilder st = new StringBuilder(srcStr);
		if (srcStr.isEmpty()) {
			st.append(objStr);
		} else {
			st.append(separator).append(objStr);
		}
		return TCResult.newSuccessResult(new String(st));
	}

	/**
	 * @category 字符数组设值
	 * @param charArr
	 *            入参|字符数组|{@link Object}
	 * @param index
	 *            入参|字符数组索引|int
	 * @param value
	 *            入参|字符值|char
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "charArr", comment = "字符数组", type = Object.class),
			@Param(name = "index", comment = "字符数组索引", type = int.class),
			@Param(name = "value", comment = "字符值", type = char.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "字符数组设值", style = "判断型", type = "同步组件", comment = "字符数组设值", date = "2019-10-08 06:29:39")
	public static TCResult P_setCharArr(Object charArr, int index, char value) {
		char[] charArr2 = (char[]) charArr;
		charArr2[index] = value;
		charArr = charArr2;
		return TCResult.newSuccessResult();
	}
}
