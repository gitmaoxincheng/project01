package tc.platform.component.db;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;

import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;

/**
 * 对象转换类组件
 * 
 * @date 2015-09-07 19:59:50
 */
public class P_ObjectTranslator {

	/**
	 * @category blob转字节数组
	 * @param blob
	 *            入参|blob|{@link java.sql.Blob}
	 * @param bytes
	 *            出参|字节数组|byte
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	public static TCResult BlobToByte(Blob blob) {
		BufferedInputStream bis = null ;
		byte[] bytes = null ;
		try{
			bis = new BufferedInputStream(blob.getBinaryStream());
			bytes = new byte[(int)blob.length()];
			int len = bytes.length;
			int offset = 0 ;
			int readByte = 0 ;
			while(offset < len &&(readByte = (bis.read(bytes,offset,len - offset))) >= 0){
				offset += readByte ;
			}
			//关闭缓冲流，返回字节数组
			bis.close();
			return TCResult.newSuccessResult(bytes);
		}catch(SQLException e){
			AppLogger.info(e);
			return TCResult.newFailureResult("", "访问 BLOB值时发生错误");
		}catch(Exception e){
			try {
				bis.close();
			} catch (IOException e1) {
				AppLogger.info(e1);
				return TCResult.newFailureResult("", "缓冲流关闭发生异常");
			}
			AppLogger.info(e);
			return TCResult.newFailureResult("", "blob转字节数组异常");
		}
	}
	
	/**
	 * @category clob转字符串
	 * @paramc lob
	 *            入参|clob|{@link java.sql.Clob}
	 * @param bytes
	 *            出参|字符串|str
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	public static TCResult ClobToString(Clob clob) {
		try{
			String  str =  clob!=null ? clob.getSubString(1,( int) clob.length()):null;
			return TCResult.newSuccessResult(str);
		}catch(Exception e){
			AppLogger.info(e);
			return TCResult.newFailureResult("", "clob转字符串异常");
		}
	}
	
	/**
	 * @category 字符串转clob
	 *   @param bytes
	 *            入参|字符串|str
	 * @paramc lob
	 *            出参|clob|{@link java.sql.Clob}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	public static TCResult StringToClob(String str) {
		Clob clob=null ;
		try{
			clob = str!=null ?new SerialClob(str.toCharArray()):null;
			return TCResult.newSuccessResult(clob);
		}catch(Exception e){
			AppLogger.info(e);
			return TCResult.newFailureResult("", "字符串转clob异常");
		}
	}

}
