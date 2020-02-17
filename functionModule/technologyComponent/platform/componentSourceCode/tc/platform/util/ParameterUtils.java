package tc.platform.util;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.afa.util.StringUtils;
import tc.platform.context.exception.BaseRuntimeException;
import tc.platform.util.db.DBUtils;

public class ParameterUtils {
	
	/**
	 * 方法参数检查
	 * @param javaLists
	 */
	public static void checkParameters(JavaList...javaLists) {
		//TODO 是否有必要去捕捉runtimeException,还是让其走全局错误
		for (int i = 0; i < javaLists.length; i++) {
			switch (javaLists[i].getStringItem(0)) {
			case "checkStrings":
				checkStrings(javaLists[i]);
				break;
			case "checkJavaList":
				checkJavaList(javaLists[i]);
				break;
			case "checkJavaDict":
				checkJavaDict(javaLists[i]);
				break;
			case "checkListInString":
				checkListInString(javaLists[i]);
				break;
			case "checkListInList":	
				checkListInList(javaLists[i]);
				break;
			case "checkListInDict":	
				checkListInDict(javaLists[i]);
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * 参数检查  new String[]{"参数字段值","错误信息","是否允许为空"}
	 * @param strings
	 */
	public static void checkStrings(JavaList javaList) {
		javaList.stream().filter(s->s instanceof DBUtils).forEach(s->{
			if ((!((DBUtils)s).getAllowEmpty() && StringUtils.isNullOrEmpty(((DBUtils)s).getParam()) || (((DBUtils)s).getAllowEmpty() && ((DBUtils)s).getParam() == null))) {
				throw new BaseRuntimeException(((DBUtils)s).getErrorCodeEnum());
			}
		});
	}
	
	/**
	 * 参数检查 new DBUtils(参数字段值(JavaList),"错误信息",是否允许为空)
	 * @param DBUtils
	 */
	public static void checkJavaList(JavaList javaList) {
		javaList.stream().filter(s->s instanceof DBUtils).forEach(s->{
			if ((!((DBUtils)s).getAllowEmpty() && ((DBUtils)s).getJavaList().isEmpty()) || (((DBUtils)s).getAllowEmpty() && ((DBUtils)s).getJavaList() == null)) {
				throw new BaseRuntimeException(((DBUtils)s).getErrorCodeEnum());
			}
		});
	}
	
	/**
	 * 参数检查 new DBUtils(参数字段值(JavaDict),"错误信息",是否允许为空)
	 * @param DBUtils
	 */
	public static void checkJavaDict(JavaList javaList) {
		javaList.stream().filter(s->s instanceof DBUtils).forEach(s->{
			if ((!((DBUtils)s).getAllowEmpty() && ((DBUtils)s).getJavaDict().isEmpty()) || (((DBUtils)s).getAllowEmpty() && ((DBUtils)s).getJavaDict() == null)) {
				throw new BaseRuntimeException(((DBUtils)s).getErrorCodeEnum());
			}
		});
	}
	
	/**
	 * 测试JavaList的内参是否为String
	 * @param javaLists
	 */
	public static void checkListInString(JavaList javaList) {
		javaList.stream().filter(s->s instanceof DBUtils).forEach(s->{
			((DBUtils)s).getJavaList().stream().forEach(x->{
				if (!(x instanceof String)) {
					throw new BaseRuntimeException(((DBUtils)s).getErrorCodeEnum());
				}
			});
		});
	}
	
	/**
	 * 测试JavaList的内参是否为JavaList
	 * @param DBUtilss
	 */
	public static void checkListInList(JavaList javaList) {
		javaList.stream().filter(s->s instanceof DBUtils).forEach(s->{
			((DBUtils)s).getJavaList().stream().forEach(x->{
				if (!(x instanceof JavaList)) {
					throw new BaseRuntimeException(((DBUtils)s).getErrorCodeEnum());
				}
			});
		});
	}
	
	/**
	 * 测试JavaList的内参是否为JavaDict
	 * @param DBUtilss
	 */
	public static void checkListInDict(JavaList javaList) {
		javaList.stream().filter(s->s instanceof DBUtils).forEach(s->{
			((DBUtils)s).getJavaList().stream().forEach(x->{
				if (!(x instanceof JavaDict)) {
					throw new BaseRuntimeException(((DBUtils)s).getErrorCodeEnum());
				}
			});
		});
	}
	
}
