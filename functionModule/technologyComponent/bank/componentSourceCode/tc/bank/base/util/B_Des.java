package tc.bank.base.util;

import cn.com.agree.afa.jcomponent.ErrorCode;    
import cn.com.agree.afa.svc.javaengine.TCResult;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.util.des.P_Des;


/**
 * des加密     yfk
 * 
 * @date 2019-10-22 17:30:2
 */
@ComponentGroup(level = "银行", groupName = "des加密")
public class B_Des {
	private static String charset = "UTF-8";
	private static final String KFT_DES = "DES";
	private static final String DES_ECB_PKCS5PADDING_MODE = "DES/ECB/PKCS5Padding";
	private static String byte2hex(byte[] b) {

		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();

	}


	/**
	 * @category des加密
	 * @param sourceStr
	 *            入参|原字符串|{@link java.lang.String}
	 * @param key
	 *            入参|密钥|{@link java.lang.String}
	 * @since destStr 出参|密文|{@link java.lang.String}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 */
	@InParams(param = { @Param(name = "sourceStr", comment = "原字符串", type = java.lang.String.class),
			@Param(name = "key", comment = "密钥", type = java.lang.String.class) })
	@OutParams(param = { @Param(name = "destStr", comment = "密文", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功") })
	@galaxy.ide.tech.cpt.Component(label = "des加密", style = "判断型", type = "同步组件", author = "bodadmin", date = "2019-10-22 05:32:50")
	public static TCResult B_desEncrypt(String sourceStr, String key) {
		String destStr = null;
		try {
			destStr = byte2hex(P_Des.desEncrypt(sourceStr.getBytes(charset), key,
					DES_ECB_PKCS5PADDING_MODE, KFT_DES));
		} catch (Exception e) {
			return TCResult.newFailureResult(ErrorCode.HANDLING, e);
		}
		return TCResult.newSuccessResult(destStr);
	}

}
