package cn.com.agree.huanan.ap.rl.bank.encrypt.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.union.api.TUnionTransInfo;
import com.union.api.UnionEsscAPI;

import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.rl.bank.encrypt.exception.MacCheckException;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.message.base.BeanPath;

/**
 *@author WB
 *秘钥获取服务层
 **/
@Service
public class UnionAPIService {
	@Autowired private Logger logger;
	@Autowired private DictDao dictDao;
	@Autowired private BeanPath beanPath;
	public UnionEsscAPI getConnection()  {
		String nodeName = beanPath.getNodeName()!=null?beanPath.getNodeName():Const.DEFAULT_NODE_NAME;
		Map<String,Object> map=dictDao.selectDict("encrypt_"+nodeName);
		List<String> ipList=new ArrayList<>();
		List<Integer> portList=new ArrayList<>();
		String ips=(String) map.get("ips");
	    String ports=(String) map.get("ports");
		logger.info("ips:"+ips+"ports:"+ports);
		if(ips.contains(",")) {
			String[] ipsArr=ips.split(",");
			String[] portsArr=ports.split(",");
			for(int i=0;i<ipsArr.length;i++) {
				ipList.add(ipsArr[i]);
				portList.add(Integer.parseInt(portsArr[i]));
				logger.info("连接安全平台地址：" + ipsArr[i] + ":" + portsArr[i]);
			}
		}else {
			ipList.add(ips);
			portList.add(Integer.parseInt(ports));
			logger.info("连接安全平台地址：" + ips + ":" + ports);
		}
		UnionEsscAPI shortApi = null;
		Integer timeOut = Integer.parseInt((String)map.get("timeout"));
		String sysID = (String)map.get("sysID");
		String appID = (String)map.get("appID");
		logger.info("系统id为："+sysID+",应用Id为："+appID);
		shortApi = new UnionEsscAPI(ipList, portList, timeOut, sysID, appID);		
		return shortApi;
	}
	/**
	 * 获取密码平台相关信息
	 * @return
	 */
	public Map<String,Object> getSysAndAppId(){
		String nodeName = beanPath.getNodeName()!=null?beanPath.getNodeName():Const.DEFAULT_NODE_NAME;
		Map<String,Object> map=dictDao.selectDict("encrypt_"+nodeName);
		if(map==null)
			throw new ApSelectNotFoundException("密码平台相关参数");
		return map;
	}

	/**
	 * 获取工作秘钥mac
	 * @param map 获取工作密钥pin请求参数
	 * @return
	 */
	public Map<String, Object> getWorkMacKey(String idOfAtm,UnionEsscAPI shortApi) {
		TUnionTransInfo transInfo = null;
		 logger.info("idOfAtm:"+idOfAtm+"GenerateAtmTA");
	     transInfo = shortApi.GenerateAtmTAK(
	 	     	idOfAtm   //终端号
	 	     );
	     Map<String, Object> rspMap = new HashMap<String, Object>();
 	     if (transInfo.getIsSuccess() == 1)
 	     {
 	         logger.info("返回密钥密文:"+transInfo.getReturnBody().getKeyValue()); 
 	         logger.info("返回校验值:"+transInfo.getReturnBody().getCheckValue());
 	         rspMap.put("my",transInfo.getReturnBody().getKeyValue());
	         rspMap.put("jyz",transInfo.getReturnBody().getCheckValue());
 	     }	
 	     else
 	     {
 	         logger.error("调用GenerateAtmTAK失败：");  //错误信息
 	         logger.error("错误信息："+transInfo.getResponseRemark());  //错误信息
 	         logger.error("错误码："+transInfo.getResponseCode());   //错误码
 	         logger.error("错误日志："+transInfo.getLog());
 	         rspMap.put("ErrorMsg", transInfo.getResponseRemark());
 	         rspMap.put("ErrorCode", transInfo.getResponseCode());
 	     }
 	     return rspMap;
	}
	/**
	 * 获取工作秘钥pin
	 * @param map 获取工作密钥pin请求参数
	 * @return
	 */
	public Map<String, Object> getWorkPinKey(String idOfAtm,UnionEsscAPI shortApi) {
		TUnionTransInfo transInfo = null;
	     logger.info("idOfAtm:"+idOfAtm+"GenerateAtmTPK");
	     transInfo = shortApi.GenerateAtmTPK(
	 	     	idOfAtm   //终端号
	 	     );
	     Map<String, Object> rspMap = new HashMap<String, Object>();
	     if (transInfo.getIsSuccess() == 1)
	     {
	         logger.info("返回密钥密文:"+transInfo.getReturnBody().getKeyValue()); 
	         logger.info("返回校验值:"+transInfo.getReturnBody().getCheckValue()); 
	         rspMap.put("my",transInfo.getReturnBody().getKeyValue());
	         rspMap.put("jyz",transInfo.getReturnBody().getCheckValue());
	     }	
	     else
	     {
	         logger.error("调用GenerateAtmTPK失败：");  //错误信息
	         logger.error("错误信息："+transInfo.getResponseRemark());  //错误信息
	         logger.error("错误码："+transInfo.getResponseCode());   //错误码
	         logger.error("错误日志："+transInfo.getLog());
	         rspMap.put("ErrorMsg", transInfo.getResponseRemark());
 	         rspMap.put("ErrorCode", transInfo.getResponseCode());
	     };
	     return rspMap;
	}
	/**
	 * 获取主秘钥
	 * @param map 获取主密钥mac请求参数
	 * @return
	 */
	public Map<String, Object> getMainKey(String idOfAtm,UnionEsscAPI shortApi) {
		TUnionTransInfo transInfo = null;
		logger.info("idOfAtm:"+idOfAtm+"GenerateAtmTMK");
	     transInfo = shortApi.GenerateAtmTMK(
	     	idOfAtm   //终端号
	     );
	     Map<String, Object> rspMap = new HashMap<String, Object>();
	     if (transInfo.getIsSuccess() == 1)
	     {
	         logger.info("返回密钥密文:"+transInfo.getReturnBody().getKeyValue()); 
	         logger.info("返回校验值:"+transInfo.getReturnBody().getCheckValue()); 
	         rspMap.put("my",transInfo.getReturnBody().getKeyValue());
	         rspMap.put("jyz",transInfo.getReturnBody().getCheckValue());
	     }	
	     else
	     {
	         logger.error("调用GenerateAtmTPK失败：");  //错误信息
	         logger.error("错误信息："+transInfo.getResponseRemark());  //错误信息
	         logger.error("错误码："+transInfo.getResponseCode());   //错误码
	         logger.error("错误日志："+transInfo.getLog());
	         rspMap.put("ErrorMsg", transInfo.getResponseRemark());
 	         rspMap.put("ErrorCode", transInfo.getResponseCode());
	     }
	     return rspMap;
	}
	
	/**
	 * 校验mac
	 * @param devNo  设备号
	 * @param reqString 请求报文
	 * @param mac  
	 * */
	public void macCheck(String devNo , String reqString , String mac) {
		logger.info("mac:%s",mac);
		//MD5加密
		String md5 = DigestUtils.md5DigestAsHex(reqString.getBytes(StandardCharsets.UTF_8)).toUpperCase();
		logger.info("md5:%s",md5);
		//连接密码平台
		UnionEsscAPI shortApi = getConnection();
		TUnionTransInfo transInfo = shortApi.VerifyAtmMAC(devNo, md5, mac);
		
		//校验是否成功 1为成功
		if (transInfo.getIsSuccess() != 1) {
			logger.info("MAC校验失败,原因：%s",transInfo.getLog());
			logger.info(transInfo.getLog());//识别失败信息
			throw new MacCheckException();
		}else {
			logger.info("MAC校验通过");
		}
		
	}
	
}


