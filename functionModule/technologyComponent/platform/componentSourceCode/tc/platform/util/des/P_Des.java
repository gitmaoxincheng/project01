package tc.platform.util.des;

import java.security.SecureRandom;  
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import galaxy.ide.tech.cpt.ComponentGroup;


/**
 * des加密  yfk
 * 
 * @date 2019-10-22 17:16:18
 */
@ComponentGroup(level = "平台", groupName = "des加密")
public class P_Des {
	private static String charset = "UTF-8";
	private static final String KFT_DES = "DES";
	private static final String KFT_DESEDE = "DESede";


	/**
	 * DES/DES3加密
	 * 
	 * @param 明文数据
	 * @param 密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] desEncrypt(byte[] data, String key, String decMode,
			String keyFactoryType) throws Exception {
		return doDes(data, initKey(key,keyFactoryType), decMode, keyFactoryType, Cipher.ENCRYPT_MODE);
	}

	/**
	 * 生成合法密钥
	 * 
	 * @param 密钥
	 * @param 加密模式(DES或者DESede)
	 * @return
	 * @throws Exception
	 */
	private static byte[] initKey(String key, String keyFactoryType) throws Exception {
		SecureRandom secureRandom = null;    
        if (key != null) {
        	byte[] buf = key.getBytes(charset);
        	if(KFT_DES.equals(keyFactoryType) && buf.length>=8)
        		return buf;
        	if(KFT_DESEDE.equals(keyFactoryType) && buf.length>=24)
        		return buf;
            secureRandom = new SecureRandom(buf);  
        } else {  
            secureRandom = new SecureRandom(keyFactoryType.getBytes(charset));  
        }  
        KeyGenerator kg = KeyGenerator.getInstance(keyFactoryType);  
        kg.init(secureRandom);  
        SecretKey secretKey = kg.generateKey();  
		return secretKey.getEncoded();
	}
	
	
	
	private static byte[] doDes(byte[] data, byte[] key, String transformation,
			String keyFactoryType, int opmode) throws Exception {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(keyFactoryType);
		KeySpec keySpec = null;
		
		//DES方式
		if (KFT_DES.equals(keyFactoryType)) {
			keySpec = new DESKeySpec(key);
		}
		//DES3方式
		if (KFT_DESEDE.equals(keyFactoryType)) {
			keySpec = new DESedeKeySpec(key);
		}
		SecretKey desKey = keyFactory.generateSecret(keySpec);
		Cipher c = null;
		if (transformation!=null) {
			c = Cipher.getInstance(transformation);
			if(transformation.contains("/CBC/")){
				IvParameterSpec param = new IvParameterSpec(new byte[8]);
				c.init(opmode, desKey, param);
			}else{
				c.init(opmode, desKey);
			}
		} else {
			c = Cipher.getInstance(keyFactoryType);
			c.init(opmode, desKey);
		}
		return c.doFinal(data);
	}


}
