/**
 * FileName: StrUtil
 * Author:   Ren Xiaotian
 * Date:     2018/8/14 11:17
 */

package cn.com.agree.huanan.ap.tl.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import cn.com.agree.huanan.ap.tl.exception.busi.ApNullArgsException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIllegalArgumentException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApNumberFormatException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;

/**
 * String工具类：字符串操作类
 */
public class StrUtil {
    private StrUtil() {
    }

    /** UTF-8编码 */
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    /** GBK编码 */
    public static final Charset CHARSET_GBK = Charset.forName("GBK");

    /** 模式.数字 */
    private static final Pattern PAT_DIGITS = Pattern.compile("\\d+");

    /**
     * 替换字符串前缀
     * @param str 待处理字符串
     * @param regex 替换前缀正则
     * @param replacement 替换内容
     * @return 替换字后的字符串
     */
    public static String replacePrex(String str, String regex,String replacement ){
	    return str.replaceAll("^(("+regex+"+))", replacement);
	}
	
    
    /**
     * 去掉字符串收尾的空格
     *
     * @param msg 带操作的字符串
     * @return 返回去掉空格后的字符串
     */
    public static String trimAll(String msg) {
        if (msg == null || "".equals(msg)) {
            return null;
        } else {
            return msg.trim();
        }
    }

    /**
     * String[]数组转换为String
     *
     * @param strs String[]数组
     * @param split 各元素间的分隔符
     * @return 返回以split为分隔符的String
     */
    public static String array2String(String[] strs, String split) {
        StringBuffer sql = new StringBuffer();
        for (String str : strs) {
            sql.append(str);
            sql.append(split);
        }
        return sql.toString();
    }

    /**
     * 将字符串中的旧字符串替换为新字符串
     *
     * @param mainString 源字符串
     * @param oldString 旧字符串
     * @param newString 新字符串
     * @return 返回替换后的新字符串
     */
    public static String replaceString(String mainString, String oldString, String newString) {
        if (mainString == null) {    //如果源字符串为空，则返回null
            return null;
        }
        if ((oldString == null) || (oldString.length() == 0)) {    //如果要替换的字符串为空或长度为0，则直接返回源字符串
            return mainString;
        }
        if (newString == null) {    //如果新字符串为空，则认为要将旧字符串替换掉为""
            newString = "";
        }

        int i = mainString.lastIndexOf(oldString);    //从后往前搜索查找
        if (i < 0) {    //如果i<0，说明没找到，则直接返回源字符串
            return mainString;
        }

        StringBuffer sb = new StringBuffer(mainString);
        while (i >= 0) {
            sb.replace(i, i + oldString.length(), newString);
            i = mainString.lastIndexOf(oldString, i - 1);
        }

        return sb.toString();
    }

    /**
     * 将String[]数组转换为String
     *
     * @param src 源String[]数组
     * @return 默认返回以逗号分隔的String
     */
    public static String toString(String[] src) {
        if (src == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < src.length; i++) {
            if (i == 0) {
                sb.append(src[i]);
            } else {
                sb.append(",");
                sb.append(src[i]);
            }
        }

        return sb.toString();
    }

    /**
     * 将String转换为String[]数组
     *
     * @param src 源String字符串
     * @return 返回拆分成的String[]数组
     */
    public static String[] toArray(String src) {
        if (src == null)
            return null;
        return src.split(",");
    }

    /**
     * 将字符串按照指定的字符拆分
     *
     * @param src 源字符串
     * @param splitStr 按照该字符拆分，如果传入为空或为""，则设为默认值，","
     * @return 返回拆分成的String[]数组
     */
    public static String[] toArraySplitDefine(String src, String splitStr) {
        if (src == null) {
            return null;
        }
        if (splitStr == null || "".equals(splitStr)) {
            splitStr = ",";
        }

        return src.split(splitStr);
    }

    /**
     * 将null转换为String
     *
     * @param s 可能为null的字符串
     * @return 整理之后的字符串，如果为null则返回""
     */
    public static String null2str(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    /**
     * 将null转换为String，如果为空则返回默认值
     *
     * @param s 可能为null的字符串
     * @param defaultValue 如果s为空，则返回该参数
     * @return 整理之后的字符串，如果为null则返回defaultValue
     */
    public static String null2str(String s, String defaultValue) {
        if (s == null) {
            return defaultValue;
        }
        return s;
    }

    /**
     * 判断字符串是否为空，这里由空格组成的字符串不认为是null
     *
     * @param s 待判断的字符串
     * @return 为空，返回true；否则返回false
     */
    public static boolean isNull(String s) {
        if (s == null || "".equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否为空，这里由空格组成的字符串不认为是null
     *
     * @param s 待判断的字符串
     * @return 为空，返回true；否则返回false
     */
    public static void isNull(String[] values,String[] keys) {
    	if (values.length != keys.length) {
			throw new ApIllegalArgumentException(new Exception());
		}
    	for (int i = 0; i < values.length; i++) {
            if (values[i] == null || "".equals(values[i])) {
    			throw new ApNullArgsException(keys[i],values[i]);
            } 
		}

    }
    
    /**
     * 判断字符串是否为空，由空格组成的字符串也为空
     *
     * @param s 待判断的字符串
     * @return 为空，返回true；否则返回false
     */
    public static boolean isNullAndFilledBlank(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否为空，如果一个字符串为"null"也被认为是空
     *
     * @param s 待判断的字符串
     * @return 为空，返回true；否则返回false
     */
    public static boolean isNullIfnull(String s) {
        if (s == null || "".equals(s.trim()) || "null".equals(s.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将字符串转换为int类型
     *
     * @param s 待转换的字符串
     * @return 返回对应的int数值
     */
    public static int String2Int(String s) {
        int ret = 0;
        if (!isNull(s)) {    // 如果待操作的字符串不为空，则进行后续处理
            try {
                ret = new Integer(s).intValue();
            } catch (NumberFormatException e) {    //如果new Integer()失败，则直接将异常抛出
                throw new ApNumberFormatException(e);
            }
        }

        return ret;
    }

    /**
     * 将指定进制的字符串转换为int
     *
     * @param s 待转换的字符串
     * @param radix 字符串的进制，默认10进制
     * @return 返回对应的int数值
     */
    public static int String2Int(String s, int radix) {
        int ret = 0;
        if (radix < 2) {    //如果进制数传入小于2，则默认设为10进制
            radix = 10;
        }
        if (!isNull(s)) {
            try {
                ret = Integer.parseInt(s, radix);
            } catch (NumberFormatException e) {
                throw new ApNumberFormatException(e);
            }
        }
        return ret;
    }

    /**
     * 将指定的字符串转换为Integer
     *
     * @param s 待转换的字符串
     * @return 返回对应的Integer
     */
    public static Integer String2Integer(String s) {
        Integer ret = new Integer(0);
        if (!isNull(s)) {
            try {
                ret = new Integer(s);
            } catch (NumberFormatException e) {
                throw new ApNumberFormatException(e);
            }
        }
        return ret;
    }

    /**
     * 将指定的字符串转换为Long类型
     *
     * @param s 待转换的字符串
     * @return 返回对应的Long类型
     */
    public static long String2Long(String s) {
        long ret = 0L;
        if (!isNull(s)) {
            try {
                ret = new Long(s).longValue();
            } catch (NumberFormatException e) {
                throw new ApNumberFormatException(e);
            }
        }
        return ret;
    }

    /**
     * 将byte[]数组转换为String
     *
     * @param b byte[]数组
     * @param charset 指定字符集，默认为UTF-8
     * @return 返回生成的String
     */
    public static String byteArray2String(byte[] b, String charset) {
        if (charset == null || "".equals(charset)) {
            charset = "UTF-8";
        }
        try {
            return new String(b, charset);
        } catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
        }
    }

    /**
     * 将byte[]数组的指定部分转换为String
     *
     * @param b byte[]数组
     * @param start 起始位置
     * @param length 起始长度
     * @param charset 指定字符集，默认为UTF-8
     * @return 返回生成的String
     */
    public static String byteArray2String(byte[] b, int start, int length, String charset) {
        if (charset == null || "".equals(charset)) {
            charset = "UTF-8";
        }
        try {
            return new String(b, start, length, charset);
        } catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
        }
    }

    /**
     * 获取UUID
     *
     * @return 返回生成的UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 执行将一个字符重复多遍
     *
     * @param ch 要重复的字符
     * @param repeat 重复多少遍
     * @return 返回新的字符串
     */
    private static String repeat(char ch, int repeat) {
        char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }

    /**
     * 获取字符串生成byte[]数组的长度
     *
     * @param str 源字符串
     * @param encoding 指定字符集，默认为UTF-8
     * @return 返回byte[]数组的长度
     */
    public static int getByteLen(String str, String encoding) {
        if (encoding == null || "".equals(encoding.trim())) {
            encoding = "UTF-8";
        }

        try {
            return str.getBytes(encoding).length;
        } catch (UnsupportedEncodingException e) {
            throw new ApUnsupportedEncodingException(e);
        }
    }

    /**
     * 字符串左侧填充指定的字符
     *
     * @param mainString 源字符串
     * @param paddingLen 要填充的长度
     * @param ch 要填充的字符
     * @return 填充后的字符串
     */
    public static String leftPadding(String mainString, int paddingLen, char ch) {
        if (paddingLen < 0) {
            throw new ApIllegalArgumentException(new IllegalArgumentException("要填充的长度不能小于0"));
        }

        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < paddingLen; i++) {
            sb.append(ch);
        }
        sb.append(mainString);
        return sb.toString();
    }

    /**
     * 字符串右侧填充指定的字符
     *
     * @param mainString 源字符串
     * @param paddingLen 要填充的长度
     * @param ch 要填充的字符
     * @return 填充后的字符串
     */
    public static String rightPadding(String mainString, int paddingLen, char ch) {
        if (paddingLen < 0) {
            throw new ApIllegalArgumentException(new IllegalArgumentException("要填充的长度不能小于0"));
        }

        StringBuffer sb = new StringBuffer(mainString);
        for (int i = 0; i < paddingLen; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
    
    /**
     * 右填充空格
     * @param value 值
     * @param valueLen 值填充长度
     * @return 填充结果
     */
    public static String sfill(String value, int valueLen) {
        return StrUtil.rightPadding(value, valueLen - value.length(), ' ');
    }

    /**
     * 左填充0
     * 
     * @param value 值
     * @param valueLen 值填充长度
     * @return 填充结果
     */
    public static String zfill(String value, int valueLen) {
        return StrUtil.leftPadding(value, valueLen - value.length(), '0');
    }

    /**
     * 左填充0
     * 
     * @param value 值
     * @param valueLen 值填充长度
     * @return 填充结果
     */
    public static String zfill(int value, int valueLen) {
        return zfill(String.valueOf(value), valueLen);
    }

    /**
     * 左填充0
     * 
     * @param value 值
     * @param valueLen 值填充长度
     * @return 填充结果
     */
    public static String zfill(long value, int valueLen) {
        return zfill(String.valueOf(value), valueLen);
    }

    
    /**
     * 右调整补全
     * @param value 值
     * @param valueLen 值填充长度
     * @param str 填充字符
     * @return 填充结果
     */
    public static String rJust(String value, int valueLen,char str) {
        return StrUtil.rightPadding(value, valueLen - value.length(), str);
    }

    /**
     * 左填充0
     * 
     * @param value 值
     * @param valueLen 值填充长度
     * @param str 填充字符 
     * @return 填充结果
     */
    public static String lJust(String value, int valueLen,char str) {
        return StrUtil.leftPadding(value, valueLen - value.length(), str);
    }    
    
    /**
     * 判断是否数字字符
     * 
     * @param input 输入
     * @return 是否数字
     */
    public static boolean isDigits(String input) {
        return PAT_DIGITS.matcher(input).matches();
    }

    /**
     * 判断是否ASCII字符
     * 
     * @param input 输入
     * @return 是否ASCII字符
     */
    public static boolean isAscii(String input) {
        return input.chars().allMatch(c -> c < 0x80);
    }

    /**
     * 获取字符个数
     * 
     * @param input 输入
     * @return 字符个数
     */
    public static int getCharsCount(String input) {
        return input.codePointCount(0, input.length());
    }

    /**
     * 判断是否相等
     * 
     * @param left 左
     * @param right 右
     * @return 是否相等
     */
    public static boolean isEquals(String left, String right) {
        if (left != null) {
            return left.equals(right);
        } else {
            return (right == null);
        }
    }

    /**
     * 判断是否为空
     * 
     * @param input 输入
     * @return null或空则返回{@code true}，否则返回{@code false}
     */
    public static boolean isEmpty(String input) {
        return (input == null) || input.isEmpty();
    }

    /**
     * 字符串空值判断返回
     * 
     * @param input 输入
     * @param defaultValue 默认值
     * @return {@code input}非空则返回{@code input}，否则返回{@code defaultValue}
     */
    public static String orElse(String input, String defaultValue) {
        return isEmpty(input) ? defaultValue : input;
    }

    /**
     * 首字母小写
     * 
     * @param input 输入
     * @return 首字母小写
     */
    public static String firstCharToLowerCase(String input) {
        return input.substring(0, 1).toLowerCase() + input.substring(1);
    }

    /**
     * 首字母大写
     * 
     * @param input 输入
     * @return 首字母大写
     */
    public static String firstCharToUpperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    

	public static Map<String, String> hashMap = new HashMap<>();
	public static Map<String,Map<String,String>> hashMaps = new HashMap<String,Map<String,String>>();
	public static String block_name = null;
	public static Pattern blankPattern = Pattern.compile("^\\s*$");
	public static Pattern commentPattern = Pattern.compile("^\\s*#.*$");
	public static Pattern block_pattern = Pattern.compile("^\\s*\\[\\s*\\S+\\s*\\].*$");
	public static Pattern line_pattern = Pattern.compile("(\\s*.+:.+\\s*)|(\\s*.+=.*\\s*)");
	public static Pattern split_pattern = Pattern.compile("(\\s*:\\s*)|(\\s*=\\s*)");
	   
    
    
    

	public static void handleLine(String line) {
		
		if (isBlank(line)) {
			return;
		}
		else if (isComment(line)) {
			return;
		}
		else if (isBlock(line)) {
			block_name = line.substring(line.indexOf('[') + 1, line.indexOf(']')).trim();
			hashMap = new HashMap<>();
			hashMaps.put(block_name, hashMap);
			return;
		}
		else if (isItem(line)) {
			String kv[] = line.split(split_pattern.pattern(), 2);
			String key = (kv[0]).trim();
			String value = (kv[1]).trim();
			hashMap.put(key, value);
		}
		else {
			/*if (lastK==null) return;
			hashMaps.put(block_name, hashMap);
			String oldValue = hashMap.get(lastK);
			line = "\n" + line;
			hashMap.put(lastK, oldValue + line);*/
		}
	}
	
	public static boolean isBlank(String line) {
		return blankPattern.matcher(line).matches();
	}
	
	public static boolean isComment(String line) {
		return commentPattern.matcher(line).matches();
	}
	
	public static boolean isBlock(String line) {
		return block_pattern.matcher(line).matches();
	}
	
	public static boolean isItem(String line) {
		return line_pattern.matcher(line).matches();
	}

    
}
