package cn.com.agree.huanan.ap.rl.bank.file.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.transfer.Constants;
import com.transfer.MessageBean;

import cn.com.agree.afa.svc.context.IDict;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.rl.bank.file.exception.TcException;
import cn.com.agree.huanan.ap.rl.bank.utils.NetWorkUtil;
import cn.com.agree.huanan.ap.rl.bank.utils.TcUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApFileNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * TC文件传输服务层
 * 
 * @author YYX
 */
@Service
public class TcService {

	@Autowired
	private DictDao dictDao;

	@Autowired
	private Logger logger;

	/**
	 * 拉取文件
	 * 
	 * @param pNodeCode 主节点标识码
	 * @param sNodeCode 次节点标识码
	 * @param pFileDirCode 主节点文件目录标识码
	 * @param sFileDirCode 次节点文件目录标识码
	 * @param srcFile 源文件名称(可带相对路径)
	 * @param desFile 目标文件名称(可带相对路径; 若目标文件不存在目录,会先自动创建)
	 * @return
	 */
	public void getFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, String srcFile, String desFile) {
		Map<String, Object> tcMap = getTcConfig(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode);
		String pNodeIP = (String) tcMap.get("P_NODE_IP");
		String pNodePort = (String) tcMap.get("P_NODE_PORT");
		String pNodeUser = (String) tcMap.get("P_NODE_USER");
		String pNodePassword = (String) tcMap.get("P_NODE_PASSWORD");
		String pNodeFileDir = (String) tcMap.get("P_NODE_FILE_DIR");
		String sNodeFileDir = (String) tcMap.get("S_NODE_FILE_DIR");
		String sNodeName = (String) tcMap.get("S_NODE_NAME");

		logger.info("srcFile:%s, desFile:%s", srcFile, desFile);
		MessageBean messageBean = TcUtil.mkGet(pNodeIP, pNodePort, pNodeUser, pNodePassword,
				sNodeFileDir + srcFile, pNodeFileDir + desFile, sNodeName, Constants.UNIX, Constants.UNIX);

		handleTransferRsq(messageBean);
	}

	/**
	 * 推送文件
	 * 
	 * @param pNodeCode 主节点标识码
	 * @param sNodeCode 次节点标识码
	 * @param pFileDirCode 主节点文件目录标识码
	 * @param sFileDirCode 次节点文件目录标识码
	 * @param srcFile 源文件名称(可带相对路径)
	 * @param desFile 目标文件名称(可带相对路径; 若目标文件不存在目录,会先自动创建)
	 * @return
	 */
	public void putFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, String srcFile, String desFile) {
		Map<String, Object> tcMap = getTcConfig(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode);
		String pNodeIP = (String) tcMap.get("P_NODE_IP");
		String pNodePort = (String) tcMap.get("P_NODE_PORT");
		String pNodeUser = (String) tcMap.get("P_NODE_USER");
		String pNodePassword = (String) tcMap.get("P_NODE_PASSWORD");
		String pNodeFileDir = (String) tcMap.get("P_NODE_FILE_DIR");
		String sNodeFileDir = (String) tcMap.get("S_NODE_FILE_DIR");
		String sNodeName = (String) tcMap.get("S_NODE_NAME");

		String pNodeSrcFile = pNodeFileDir + srcFile;
		File file = new File(pNodeSrcFile);
		if (!file.exists())
			throw new ApFileNotFoundException(new FileNotFoundException("要推送的源文件\"" + pNodeSrcFile + "\"不存在"));

		logger.info("srcFile:%s, desFile:%s", srcFile, desFile);
		MessageBean messageBean = TcUtil.mkPut(pNodeIP, pNodePort, pNodeUser, pNodePassword,
				pNodeSrcFile, sNodeFileDir + desFile, sNodeName, Constants.UNIX, Constants.UNIX);

		handleTransferRsq(messageBean);
	}

	/**
	 * 拉取多个文件
	 * 
	 * @param pNodeCode 主节点标识码
	 * @param sNodeCode 次节点标识码
	 * @param pFileDirCode 主节点文件目录标识码
	 * @param sFileDirCode 次节点文件目录标识码
	 * @param fileMap 文件名称集合
	 */
	public void getMultiFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, JavaDict fileMap) {
		Map<String, Object> tcMap = getTcConfig(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode);
		String pNodeIP = (String) tcMap.get("P_NODE_IP");
		String pNodePort = (String) tcMap.get("P_NODE_PORT");
		String pNodeUser = (String) tcMap.get("P_NODE_USER");
		String pNodePassword = (String) tcMap.get("P_NODE_PASSWORD");
		String pNodeFileDir = (String) tcMap.get("P_NODE_FILE_DIR");
		String sNodeFileDir = (String) tcMap.get("S_NODE_FILE_DIR");
		String sNodeName = (String) tcMap.get("S_NODE_NAME");

		for (Object srcFile : fileMap.keySet()) {
			String desFile = (String) fileMap.get(srcFile);
			logger.info("srcFile:%s, desFile:%s", srcFile, desFile);
			MessageBean messageBean = TcUtil.mkGet(pNodeIP, pNodePort, pNodeUser, pNodePassword,
					sNodeFileDir + srcFile, pNodeFileDir + desFile, sNodeName, Constants.UNIX, Constants.UNIX);
			handleTransferRsq(messageBean);
		}
	}

	/**
	 * 推送多个文件
	 * 
	 * @param pNodeCode 主节点标识码
	 * @param sNodeCode 次节点标识码
	 * @param pFileDirCode 主节点文件目录标识码
	 * @param sFileDirCode 次节点文件目录标识码
	 * @param fileMap 文件名称集合
	 */
	public void putMultiFile(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode, JavaDict fileMap) {
		Map<String, Object> tcMap = getTcConfig(pNodeCode, sNodeCode, pFileDirCode, sFileDirCode);
		String pNodeIP = (String) tcMap.get("P_NODE_IP");
		String pNodePort = (String) tcMap.get("P_NODE_PORT");
		String pNodeUser = (String) tcMap.get("P_NODE_USER");
		String pNodePassword = (String) tcMap.get("P_NODE_PASSWORD");
		String pNodeFileDir = (String) tcMap.get("P_NODE_FILE_DIR");
		String sNodeFileDir = (String) tcMap.get("S_NODE_FILE_DIR");
		String sNodeName = (String) tcMap.get("S_NODE_NAME");

		for (Object srcFile : fileMap.keySet()) {
			String desFile = (String) fileMap.get(srcFile);
			logger.info("srcFile:%s, desFile:%s", srcFile, desFile);

			String pNodeSrcFile = pNodeFileDir + srcFile;
			File file = new File(pNodeSrcFile);
			if (!file.exists())
				throw new ApFileNotFoundException(new FileNotFoundException("要推送的源文件\"" + pNodeSrcFile + "\"不存在"));

			MessageBean messageBean = TcUtil.mkPut(pNodeIP, pNodePort, pNodeUser, pNodePassword,
					pNodeSrcFile, sNodeFileDir + desFile, sNodeName, Constants.UNIX, Constants.UNIX);
			handleTransferRsq(messageBean);
		}
	}

	/**
	 * 获取TC配置
	 * 
	 * @param pNodeCode 主节点标识码
	 * @param sNodeCode 次节点标识码
	 * @param pFileDirCode 主节点文件目录标识码
	 * @param sFileDirCode 次节点文件目录标识码
	 * @return
	 */
	private Map<String, Object> getTcConfig(String pNodeCode, String sNodeCode, String pFileDirCode, String sFileDirCode) {
		logger.info("获取TC服务配置");
		Map<String, Object> pNodeMap = dictDao.selectDict(pNodeCode);
		Map<String, Object> sNodeMap = dictDao.selectDict("TC_S_NODE");
		Map<String, Object> fileDirMap = dictDao.selectDict("TC_FILE_DIR");

		Map<String, Object> tcMap = new HashMap<String, Object>();
		tcMap.putAll(pNodeMap);
		tcMap.put("S_NODE_NAME", sNodeMap.get(sNodeCode));
		tcMap.put("P_NODE_FILE_DIR", fileDirMap.get(pFileDirCode));
		tcMap.put("S_NODE_FILE_DIR", fileDirMap.get(sFileDirCode));

		String pNodeIP = getAvailablePnodeIP(tcMap);
		tcMap.put("P_NODE_IP", pNodeIP);
		String pNodeFileDir = (String) tcMap.get("P_NODE_FILE_DIR");
		String sNodeFileDir = (String) tcMap.get("S_NODE_FILE_DIR");
		String sNodeName = (String) tcMap.get("S_NODE_NAME");
		logger.info("P_NODE_IP:%s, P_NODE_FILE_DIR:%s, S_NODE_NAME:%s, S_NODE_FILE_DIR:%s", pNodeIP, pNodeFileDir, sNodeName, sNodeFileDir);
		return tcMap;
	}

	/**
	 * 处理TC响应消息
	 * 
	 * @param messageBean
	 * @return
	 */
	private void handleTransferRsq(MessageBean messageBean) {
		boolean flag = messageBean.getFlag();
		String direction = messageBean.getDirection();
		logger.info("flag:%b, direction:%s", flag, direction);

		if (flag == false) {
			logger.error("exceptionDesc:%s, exceptionMsg:%s, processContent:%s", 
					messageBean.getExceptiondesc(), messageBean.getExceptionmsg(), messageBean.getProcessContent());

			if (direction.equals(Constants.DIRECTION_MK_PUT) || direction.equals(Constants.DIRECTION_PUT))
				throw new TcException("推送文件失败");
			else
				throw new TcException("拉取文件失败");
		}
	}

	/**
	 * 获取可用的TC主节点IP
	 * @param tcMap
	 * @return
	 */
	private String getAvailablePnodeIP(Map<String, Object> tcMap) {
		String pNodeIPStr = (String) tcMap.get("P_NODE_IP");

		if (StringUtils.isEmpty(pNodeIPStr))
			throw new TcException("TC服务未配置");

		int pNodeTimeOut = Integer.parseInt((String) tcMap.get("P_NODE_TIMEOUT"));
		logger.info("TC主节点IP列表:%s, TC主节点连接超时时间:%s毫秒", pNodeIPStr, pNodeTimeOut);
		List<String> pNodeIPList = new ArrayList<>();
		Collections.addAll(pNodeIPList, pNodeIPStr.split(","));

		IDict __REQ__ = EnvContextHolder.getHolder().getContext().getRequest();
		String pNodeIP = __REQ__.getStringItem("__LOCAL_IP__");
		logger.info("本机IP:%s", pNodeIP);

		int port = Integer.parseInt((String) tcMap.get("P_NODE_PORT"));
		boolean isTcServiceAvailable = false;

		if (!NetWorkUtil.isHostConnectable(pNodeIP, port, pNodeTimeOut)) {
			pNodeIPList.remove(pNodeIP);
			logger.info("本机TC服务[%s:%s]连接超时", pNodeIP, port);

			for (String testIp : pNodeIPList) {
				if (NetWorkUtil.isHostConnectable(testIp, port, pNodeTimeOut)) {
					pNodeIP = testIp;
					isTcServiceAvailable = true;
					logger.info("TC服务[%s:%s]连接成功", testIp, port);
					break;
				} else {
					logger.info("TC服务[%s:%s]连接超时", testIp, port);
				}
			}
		} else {
			logger.info("本机TC服务[%s:%s]连接成功", pNodeIP, port);
			isTcServiceAvailable = true;
		}

		if (!isTcServiceAvailable)
			throw new TcException("TC服务连接超时");

		return pNodeIP;
	}

}
