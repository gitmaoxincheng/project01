package tc.platform.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import cn.com.agree.afa.svc.context.IDict;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import tc.platform.constant.exception.BaseErrorCode;
import tc.platform.util.ParameterUtils;

/**
 * 数据库工具类
 * @author bodadmin
 *
 */
public class DBUtils {
	
	public static final String PAGEDICT    = "0";
	public static final String PAGEFIRST   = "1";
	public static final String PAGEUP      = "2";
	public static final String PAGEDOWN    = "3";
	public static final String PAGELAST    = "4";
	public static final String DESC	    = "DESC";
	public static final String ASC		    = "ASC";
	public static final String LT		    = "<";
	public static final String LE		    = "<=";
	public static final String GT	        = ">";
	public static final String GE		    = ">=";
	public static final String EQ		    = "=";
	public static final String NE		    = "<>";
	public static final String BETWEEN	    = "BETWEEN";
	public static final String TO_NUMBER   = "TO_NUMBER";
	public static final String LTRIM	    = "LTRIM";
	public static final String RTRIM	    = "RTRIM";
	public static final String IN		    = "IN";
	public static final String NOTIN 	    = "NOT IN";
	public static final String INCHAR	    = "^";
	public static final String NOTINCHAR   = "!^";
	public static final String DOUBLESPLIT = "||";
	public static final String LK 			= "__%";
	public static final String ISNULL      = "__ISNULL";
	public static Connection connection  = null;
	public static PreparedStatement pstm = null;
	public static ResultSet rs           = null;
	
	private String param;
	private BaseErrorCode errorCodeEnum;
	private JavaDict javaDict;
	private JavaList javaList;
	//private String errorMsg;
	private Boolean allowEmpty;
	
	
	public DBUtils(String param, BaseErrorCode errorCodeEnum, Boolean allowEmpty) {
		super();
		this.param = param;
		this.errorCodeEnum = errorCodeEnum;
		this.allowEmpty = allowEmpty;
	}
	
	public DBUtils(JavaList javaList, BaseErrorCode errorCodeEnum, Boolean allowEmpty) {
		super();
		this.javaList = javaList;
		this.errorCodeEnum = errorCodeEnum;
		this.allowEmpty = allowEmpty;
	}
	
	public DBUtils(JavaDict javaDict, BaseErrorCode errorCodeEnum, Boolean allowEmpty) {
		super();
		this.javaDict = javaDict;
		this.errorCodeEnum = errorCodeEnum;
		this.allowEmpty = allowEmpty;
	}
	
	
	public DBUtils(JavaList javaList, BaseErrorCode errorCodeEnum) {
		super();
		this.javaList = javaList;
		this.errorCodeEnum = errorCodeEnum;
	}
	
	public DBUtils(JavaDict javaDict, BaseErrorCode errorCodeEnum) {
		super();
		this.javaDict = javaDict;
		this.errorCodeEnum = errorCodeEnum;
	}
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public JavaList getJavaList() {
		return javaList;
	}
	public void setJavaList(JavaList javaList) {
		this.javaList = javaList;
	}
	public BaseErrorCode getErrorCodeEnum() {
		return errorCodeEnum;
	}
	public void setErrorCodeEnum(BaseErrorCode errorCodeEnum) {
		this.errorCodeEnum = errorCodeEnum;
	}
	public Boolean getAllowEmpty() {
		return allowEmpty;
	}
	public void setAllowEmpty(Boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}
	
	public JavaDict getJavaDict() {
		return javaDict;
	}

	public void setJavaDict(JavaDict javaDict) {
		this.javaDict = javaDict;
	}


	
	/**
	 * 求字符串中指定字符出现的次数
	 * @param source 字符串
	 * @param find  指定字符
	 * @return
	 */
	public static int getStrCount(String source,String find) {
		int count = 0 ;
		while (source.indexOf(find)>=0) {
			source = source.substring(source.indexOf(find)+find.length());
			count ++;
		}
		return count;
	}
	
	
	/**
	 * 根据传入的参数类型组装sql语句中要求的值。字符类型加单引号('),数值类型原样返回，列表类型加BETWEEN v1 AND v2返回，其它对象类型抛出异常。
	 * @param value 要转换的值
	 * @param flag  要转换的类型标识
	 * @return String
	 */
	public static String tranType(Object value,String flag,String field) {
		AppLogger.info("方法(装换sql语句中要求的值) --- DBUtils.tranType--- start ---");
		//参数打印
		DBUtils.logParams("[tranType]:", value,flag,field);
	
		if (value == null) {
			throw new RuntimeException("[DBUtils.tranType]查询参数_value为空");
		}
		
		AppLogger.info("type:"+value.getClass().getSimpleName());
		switch (value.getClass().getSimpleName()) {
		
		case "String":
			value = ((String) value).replace("'", "''");
			return String.format("\'%s\'", value);
		
		case "JavaList":
			if (flag.equals("BETWEEN")) {
				int valueSize = ((JavaList)value).size();
				JavaList temp = new JavaList();
				if (valueSize > 2 || valueSize < 1) {
					throw new RuntimeException(String.format("列表中的元素[%s]只能是1个或2个", value.toString()));
				}
				
				//判断value格式
				for (Object obj:((JavaList)value)) {
					if (obj == null) {
						throw new RuntimeException("DBUtils.tranType]查询参数_value(JavaList)中的内参不能为空");
					}
					if (obj instanceof String) {
						obj = ((String) obj).replace("'", "''");
						temp.add(String.format("\'%s\'", obj));
					}
					if (obj instanceof Integer || obj instanceof Float) {
						temp.add(obj);
					}
				}	
				
				if (temp.size()==1) {
					return temp.getStringItem(0);
				}
				return String.format("%s %s AND %s", "BETWEEN",temp.getStringItem(0),temp.get(1).toString());
			}
			if (flag.equals("||")) {
				int valueSize = ((JavaList)value).size();
				if (valueSize != 2) {
					throw new RuntimeException(String.format("列表中的元素[%s]只能是2个", value.toString()));
				}
				for (Object obj:((JavaList)value)) {
					if (obj == null) {
						throw new RuntimeException("[DBUtils.tranType]查询参数_value(JavaList)中的内参不能为空");
					}
					if (!(obj instanceof String)) {
						throw new RuntimeException("[DBUtils.tranType]查询参数_value(JavaList)中的内参只能是字符串");
					}
				}
				
				if (field.equals(((JavaList)value).getStringItem(0))) {
					((JavaList)value).getStringItem(0).replace("'","''");
					return String.format("%s%s\'%s\'", ((JavaList)value).getStringItem(0),"||",((JavaList)value).getStringItem(1));
				}else if (field.equals(((JavaList)value).getStringItem(1))) {
					((JavaList)value).getStringItem(1).replace("'","''");
					return String.format("\'%s\'%s%s", ((JavaList)value).getStringItem(0),"||",((JavaList)value).getStringItem(1));
				}else {
					throw new RuntimeException("[DBUtils.tranType]没有要合并的字段");
				}
			}
			break;
			
		case "JavaDict":
			throw new RuntimeException(String.format("[DBUtils.tranType]字段的值[%s]类型不能为JavaDict", value.toString()));
		default:
			return String.valueOf(value);
		}
		
		AppLogger.info("方法(装换sql语句中要求的值) --- DBUtils.tranType--- end ---");
		return null;
	}
	
	
	/**
	 * 批量组装sql语句中要求的值。字符类型加单引号('),数值类型原样返回，，列表类型加BETWEEN v1 AND v2返回,其它对象类型抛出异常
	 * @param values 要转换的值
	 * @return
	 */
	public static JavaList tranTypes(JavaList values) {
		JavaList rtn = new JavaList();
		values.stream().forEach(value->rtn.add(tranType(value, "", "")));
		return rtn;
	}
	
	/**
	 * 根据查询结果字典将结果信息压入__RSP__ 返回包中
	 * @param tableName 表名 ,格式为"table1 t1,table2 t2,table3 t3"
	 * @param retDict 查询结果字典集
	 * @param response 返回数据包 __RSP__
	 */
	public static void setRspData(String tableName,JavaDict retDict,IDict response) {
		//参数检查
		boolean flag = false;
		String[] strings = tableName.split(",");
		JavaList dictKeys = retDict.getKeys();
		String[] keys = null;
		String[] tmpfields = null;
		String field = "";
		if (strings.length == 1) {strings[0] = strings[0].concat(" t");flag = true;}
		ParameterUtils.checkListInString(new JavaList(dictKeys,"[P_DBUtils.setRspData]retDict的key集合不是字符串类型"));
		for (String table:strings) {
			for (int i = 0; i < dictKeys.size(); i++) {
				keys = dictKeys.getStringItem(i).trim().split(".");
				field = keys.length==1?keys[0]:keys[1];
				tmpfields = field.trim().split("\\s+");
				field = tmpfields[-1];
				response.setItem(field, dictKeys.getStringItem(i));
			}
		}
	}
	
	/**
	 * 将查询结果集类型转换：JavaList->JavaDict
	 * @param srcJavaList 查询返回的结果集
	 * @param fields 查询条件字段,field的格式为"A" or "A as B" or "A B",先把" as "替换成" ",然后按" "切片
	 * @param aliasconv 是否支持别名("N","Y")
	 * @return
	 */
	public static JavaDict listToDict(JavaList srcJavaList,JavaList fields,String aliasconv) {
		//TODO 参数检查
		JavaDict retDict = new JavaDict();
		String[] stringFields = null;
		JavaList temp = new JavaList();
		String field = "";
		String val =  "";
		if (srcJavaList.isEmpty()) {
			return new JavaDict();
		}
		
		if (srcJavaList.getListItem(0).size() != fields.size()) {
			throw new RuntimeException("[P_DBUtils.listToDict]查询结果集与查询字段长度不匹配");
		}
		for(int i = 0;i<fields.size();i++) {
			field = fields.getStringItem(i);
			if (aliasconv.trim().equals("Y")) {
				//field的格式为"A" or "A as B" or "A B",先把" as "替换成" ",然后按" "切片
				stringFields = field.trim().split(" as ");
				if (stringFields.length == 2) {
					field = stringFields[1];
				}	
			}
			for (int j = 0; j < srcJavaList.size(); j++) {
				val = ((JavaList)srcJavaList.get(j)).getStringItem(i);
				temp.add(val);
			}
			retDict.setItem(field, temp);
			temp = new JavaList();
		}
		return retDict;
	}
	
	/**
	 * 参数打印
	 * @param className
	 * @param objects
	 */
	public static void logParams(String className,Object...objects) {
		AppLogger.info("--------------------"+className+"参数打印--------------------");
		for (int i = 0; i < objects.length; i++) {
			//如果传null,continue
			if(objects[i] == null) {
				AppLogger.info(className+":"+i+": null");
				continue;
			}
			AppLogger.info(className+":"+i+":"+objects[i].toString());
		}
		AppLogger.info("--------------------"+className+"参数打印--------------------");
	}
	
	/**
	 * strings中是否包含value
	 * @param value 要查看的数据
	 * @param strings 待排查的数据
	 * @return
	 */
	public static Boolean stringsContainValues(Object value,String[] strings) {
		return Arrays.asList(strings).contains((String)value);
	}
}

