package cn.com.agree.huanan.ap.rl.bank.utils;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 网络工具类
 * 
 * @author yuanyuanxing
 */
public class NetWorkUtil {

	/**
	 * 判断主机IP端口是否可连接
	 * 
	 * @param host
	 * @param port
	 * @param timeOut
	 * @return
	 */
	public static boolean isHostConnectable(String host, int port, int timeOut) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port), timeOut);
		} catch (Exception e) {
			return false;
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
