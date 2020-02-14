package cn.com.agree.huanan.ap.tl.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

/**
 * 
 * @author xiaot 2018年8月14日 下午3:15:38
 *
 */

public class MoneyUtil {

	/**
	 * 删除千分符
	 * 
	 * @param amount
	 *            金额
	 * @return 金额
	 */
	public static String deleteComma(String amount) {
		amount = amount.replaceAll(",", "");
		return amount;
	}

	/**
	 * 元转分
	 * 
	 * @param amount
	 *            元为单位金额
	 * @return 分为单位金额
	 */
	public static String yuanToFen(String amount) {

		// 删除千分符
		amount = amount.replaceAll(",", "");

		// 空则直接返回
		if (("").equals(amount)) {
			return "0";
		}

		// 去掉符号位
		String sign = "";
		if (amount.startsWith("-")) {
			sign = "-";
			amount = amount.substring(1);
		} else if (amount.startsWith("+")) {
			sign = "";
			amount = amount.substring(1);
		}

		String left = "";
		String right = "";

		String[] items = amount.split("\\.");

		if (items.length == 1) {
			left = items[0];
			right = "00";
		} else if (items.length == 2) {
			left = items[0];
			right = items[1];
		} else {
			// Logger.error("非法金额：%s", amount);
			throw new ApIllegalParamException(String.format("非法金额：%s", amount));
		}
		// 处理左侧
		if (!"".equals(left)) {
			if (!isNumeric(left)) {
				throw new ApIllegalParamException(String.format("非法金额：%s", amount));
			}
		}
		// 处理右侧
		if ("".equals(right)) {
			right = "00";
		} else {
			if (!isNumeric(right)) {
				throw new ApIllegalParamException(String.format("非法金额：%s", amount));
			}
			try {
				right = right.length() >= 2 ? right.substring(0, 2) : right + "0";
			} catch (Exception e) {

			}
		}
		// 返回结果
		return String.format("%s%s%s", sign, left, right);
	}

	/**
	 * 分转元，不插千分符
	 * 
	 * @param amount
	 *            金额
	 * @return 金额
	 * 
	 */
	public static String fenToYuan(String amount) {
		return fenToYuan(amount, false);
	}

	/**
	 * 分转元
	 * 
	 * @param amount
	 *            金额
	 * @param insComma
	 *            千分符标识
	 * @return 金额
	 * 
	 */
	public static String fenToYuan(String amount, Boolean insComma) {
		if (insComma == null) {
			insComma = false;
		}
		// 空则直接返回
		if ("".equals(amount)) {
			return "0.00";
		}
		String sign = "";
		// 去掉符号位
		if (amount.startsWith("-")) {
			sign = "-";
			amount = amount.substring(1);
		} else if (amount.startsWith("+")) {
			sign = "";
			amount = amount.substring(1);
		}
		if (!isNumeric(amount)) {
			throw new ApIllegalParamException(String.format("非法金额：%s", amount));
		}

		String left = "";
		String right = "";

		if (amount.length() > 2) {
			left = amount.substring(0, amount.length() - 2);
			right = amount.substring(amount.length() - 2);
		} else if (amount.length() == 2) {
			left = "0";
			right = amount;
		} else if (amount.length() == 1) {
			left = "0";
			right = "0" + amount;
		} else {
			throw new ApIllegalParamException(String.format("非法金额：%s", amount));
		}
		// 添加千分符
		if (insComma) {
			left = String.format(Locale.US, "%,d", Long.parseLong(left));
		}
		// 返回结果
		return String.format("%s%s.%s", sign, left, right);
	}

	/**
	 * 插入千分符
	 * 
	 * @param amount
	 *            金额
	 * @return 千分符金额
	 */
	public static String insertComma(String amount) {
		return fenToYuan(yuanToFen(amount), true);
	}

	/**
	 * 删除前缀0
	 * 
	 * @param amount
	 *            金额
	 * @return 金额
	 */
	public static String deletePreZero(String amount) {
		// 删除前缀0
		String sign = "";
		// 去掉符号位
		if (amount.startsWith("-")) {
			sign = "-";
			amount = amount.substring(1);
		} else if (amount.startsWith("+")) {
			sign = "";
			amount = amount.substring(1);
		}
		// 处理左侧
		if (!"".equals(amount)) {
			try {
				amount = amount.replaceAll("^(0+)", "");
			} catch (Exception e) {
				throw new ApIllegalParamException(String.format("非法金额：%s", amount));
			}
			if (amount.startsWith(".")) {
				amount = "0" + amount;
			}
		} else {
			amount = "0";
		}
		if ("".equals(amount)) {
			amount = "0";
		}
		// 返回结果
		return String.format("%s%s", sign, amount);
	}

	/**
	 * 分割符号金额
	 * 
	 * @param amount
	 *            金额
	 * @param positiveSign
	 *            标识
	 * @return 金额
	 */
	public static ArrayList splitSign(String amount, String positiveSign) {
		String sign = positiveSign;
		if (amount.startsWith("-")) {
			sign = "-";
			amount = amount.substring(1);
		} else if (amount.startsWith("+")) {
			sign = "";
			amount = amount.substring(1);
		}

		ArrayList<String> amountList = new ArrayList<String>();
		amountList.add(sign);
		amountList.add(amount);
		return amountList;
	}

	/**
	 * 校验必须为正金额
	 * 
	 * @param amount
	 *            金额
	 * @return 布尔型
	 */
	public static Boolean checkAmount(String amount) {
		ArrayList<String> amountList = splitSign(amount, "");

		String sign = amountList.get(0);
		amount = amountList.get(1);

		if (sign.startsWith("-") || ("0".equals(amount))) {
			throw new ApIllegalParamException(String.format("非法金额：%s", amount));
		}
		return true;
	}

	/**
	 * 转换金额大写
	 * 
	 * @param amount
	 *            金额
	 * @return 金额大写
	 */
	public static String digitUppercase(String amount) {
		if ("".equals(amount)) {
			throw new ApIllegalParamException(String.format("非法金额：%s", amount));
		}
		Double n = Double.valueOf(amount);

		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

		String head = n < 0 ? "负" : "";
		n = Math.abs(n);

		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
		}
		if (s.length() < 1) {
			s = "整";
		}
		int integerPart = (int) Math.floor(n);

		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && n > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
		}
		return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$",
				"零元整");
	}

	/**
	 * 金额运算
	 * 
	 * @param oper
	 *            操作
	 * @param a
	 *            金额a
	 * @param b
	 *            金额b
	 * @param rounding
	 *            循环数
	 * @return 金额
	 */
	public static String calcAmount(String oper, String a, String b, String rounding) {
		BigDecimal ad = new BigDecimal(Double.valueOf(a));
		BigDecimal bd = new BigDecimal(Double.valueOf(b));

		BigDecimal ret;
		int round;

		if ("".equals(rounding)) {
			round = BigDecimal.ROUND_HALF_UP;
		}
		// 小数点后有数字全去掉
		else if ("0".equals(rounding)) {
			round = BigDecimal.ROUND_DOWN;
		} else if ("1".equals(rounding)) {
			round = BigDecimal.ROUND_HALF_UP;
		}
		// 小数点只要有数字就进1
		else if ("2".equals(rounding)) {
			round = BigDecimal.ROUND_UP;
		} else {
			throw new ApIllegalParamException(String.format("非法标识：%s", rounding));
		}
		if ("+".equals(oper)) {
			ret = ad.add(bd);
		} else if ("-".equals(oper)) {
			ret = ad.subtract(bd);
		} else if ("*".equals(oper)) {
			ret = ad.multiply(bd);
		} else if ("/".equals(oper)) {
			ret = ad.divide(bd, 0, round);
			return ret.toPlainString();
		} else {
			throw new ApIllegalParamException(String.format("非法标识：%s", rounding));
		}
		return String.valueOf(Math.round(ret.doubleValue()));

	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 *            金额
	 * @return 布尔型
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param amount
	 *            金额
	 * @return 金额
	 */
	public static String fenToWan(String amount) {
		return fenToWan(amount, false);
	}

	/**
	 * @param amount
	 *            金额
	 * @param insComma
	 *            千分符标识
	 * @return 金额
	 */
	public static String fenToWan(String amount, Boolean insComma) {
		if (amount.length() <= 4) {
			return "0.00";
		}
		amount = amount.substring(0, amount.length() - 4);
		return fenToYuan(amount, insComma);
	}

	/**
	 * 左去0
	 * 
	 * @param amount
	 *            金额
	 * @return 金额
	 */
	public static String lRemoveZero(String amount) {
		amount = amount.replaceFirst("^0+", "");
		if ("".equals(amount.trim())) {
			return "0";
		} else {
			return amount;
		}
	}

	/**
	 * 比较两个金额
	 * 
	 * @param amount1
	 *            金额1
	 * @param amount2
	 *            金额2
	 * @return 负数小于 0等于 正数大于
	 */
	public static int compareTwoAmounts(String amount1, String amount2) {
		BigDecimal bd1 = new BigDecimal(amount1);
		BigDecimal bd2 = new BigDecimal(amount2);
		return bd1.compareTo(bd2);
	}
}
