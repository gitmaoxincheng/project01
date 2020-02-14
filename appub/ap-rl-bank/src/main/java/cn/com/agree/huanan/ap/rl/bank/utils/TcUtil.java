package cn.com.agree.huanan.ap.rl.bank.utils;

import com.transfer.Constants;
import com.transfer.MessageBean;
import com.transfer.TransParam;
import com.transfer.Transfer;

/**
 * TC文件传输工具
 * @author YYX
 */
public class TcUtil {

	/**
	 * 以用户密码连接TC发起传输GET,直接拉取文件
	 * 
	 * @param pNodeIp 主节点IP地址
	 * @param pNodePort 主节点端口
	 * @param pNodeUserName 主节点用户名
	 * @param pNodePassword 主节点密码
	 * @param sourceFile 源文件名（带绝对路径）
	 * @param destinationFile 目标文件名（带绝对路径）
	 * @param sNodeName 次节点名称
	 * @param srcOS 源文件的操作系统类型
	 * @param desOS 目标文件的操作系统类型
	 * @return MessageBean 响应消息Bean
	 */
	public static MessageBean get(String pNodeIp, String pNodePort, String pNodeUserName, String pNodePassword,
			String sourceFile, String destinationFile, String sNodeName, String srcOS, String desOS) {
		TransParam tp = new TransParam(pNodeIp, pNodePort, pNodeUserName, pNodePassword, sourceFile, destinationFile,
				sNodeName, srcOS, desOS);
		return Transfer.execute(tp, Constants.DIRECTION_GET);
	}

	/**
	 * 以用户密码连接TC发起传输PUT,直接推送文件
	 * 
	 * @param pNodeIp 主节点IP地址
	 * @param pNodePort 主节点端口
	 * @param pNodeUserName 主节点用户名
	 * @param pNodePassword 主节点密码
	 * @param sourceFile 源文件名（带绝对路径）
	 * @param destinationFile 目标文件名（带绝对路径）
	 * @param sNodeName 次节点名称
	 * @param srcOS 源文件的操作系统类型
	 * @param desOS 目标文件的操作系统类型
	 * @return MessageBean 响应消息Bean
	 */
	public static MessageBean put(String pNodeIp, String pNodePort, String pNodeUserName, String pNodePassword,
			String sourceFile, String destinationFile, String sNodeName, String srcOS, String desOS) {
		TransParam tp = new TransParam(pNodeIp, pNodePort, pNodeUserName, pNodePassword, sourceFile, destinationFile,
				sNodeName, srcOS, desOS);
		return Transfer.execute(tp, Constants.DIRECTION_PUT);
	}

	/**
	 * 以用户密码连接TC发起传输MK_GET,即先在远端建立目录,再拉取
	 * 
	 * @param pNodeIp 主节点IP地址
	 * @param pNodePort 主节点端口
	 * @param pNodeUserName 主节点用户名
	 * @param pNodePassword 主节点密码
	 * @param sourceFile 源文件名（带绝对路径）
	 * @param destinationFile 目标文件名（带绝对路径）
	 * @param sNodeName 次节点名称
	 * @param srcOS 源文件的操作系统类型
	 * @param desOS 目标文件的操作系统类型
	 * @return MessageBean 响应消息Bean
	 */
	public static MessageBean mkGet(String pNodeIp, String pNodePort, String pNodeUserName, String pNodePassword,
			String sourceFile, String destinationFile, String sNodeName, String srcOS, String desOS) {
		TransParam tp = new TransParam(pNodeIp, pNodePort, pNodeUserName, pNodePassword, sourceFile, destinationFile,
				sNodeName, srcOS, desOS);
		return Transfer.execute(tp, Constants.DIRECTION_MK_GET);
	}

	/**
	 * 以用户密码连接TC发起传输MK_PUT,即先在远端建立目录,再推送
	 * 
	 * @param pNodeIp 主节点IP地址
	 * @param pNodePort 主节点端口
	 * @param pNodeUserName 主节点用户名
	 * @param pNodePassword 主节点密码
	 * @param sourceFile 源文件名（带绝对路径）
	 * @param destinationFile 目标文件名（带绝对路径）
	 * @param sNodeName 次节点名称
	 * @param srcOS 源文件的操作系统类型
	 * @param desOS 目标文件的操作系统类型
	 * @return MessageBean 响应消息Bean
	 */
	public static MessageBean mkPut(String pNodeIp, String pNodePort, String pNodeUserName, String pNodePassword,
			String sourceFile, String destinationFile, String sNodeName, String srcOS, String desOS) {
		TransParam tp = new TransParam(pNodeIp, pNodePort, pNodeUserName, pNodePassword, sourceFile, destinationFile,
				sNodeName, srcOS, desOS);
		return Transfer.execute(tp, Constants.DIRECTION_MK_PUT);
	}

}
