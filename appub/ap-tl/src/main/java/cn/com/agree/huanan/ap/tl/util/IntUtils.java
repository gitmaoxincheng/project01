/**
 * 
 */
package cn.com.agree.huanan.ap.tl.util;

/**
 * @author xqq 子节数据处理
 * @time 2018年12月19日
 */
public class IntUtils {

	/**
	 * 转为4子节数组
	 * @param value
	 * @return
	 */
	public static byte[] toFourBytes(int value) {
		return toBytes(value, 4);
	}

	/**
	 * 转为2子节数组
	 * @param value
	 * @return
	 */
	public static byte[] toTwoBytes(int value) {
		return toBytes(value, 2);
	}

	/**
	 * 转为指定长度子节数组
	 * @param value
	 * @param byteCount
	 * @return
	 */
	public static byte[] toBytes(int value, int byteCount) {
		byte[] bytes = new byte[byteCount];
		int i = 0;
		for (int j = byteCount - 1; i < byteCount; j--) {
			bytes[i] = ((byte) (value >>> 8 * j & 0xFF));
			i++;
		}
		return bytes;
	}

	/**
	 * 转为指定长度子节数值
	 * @param bytes
	 * @return
	 */
	public static int toInt(byte[] bytes) {
		int value = 0;
		int i = 0;
		for (int j = bytes.length - 1; i < bytes.length; j--) {
			value |= (bytes[i] & 0xFF) << 8 * j;
			i++;
		}
		return value;
	}
}
