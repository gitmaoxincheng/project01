package cn.com.agree.huanan.ap.rl.bank.ias.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunyard.client.SunEcmClientApi;
import com.sunyard.client.bean.ClientBatchBean;
import com.sunyard.client.bean.ClientBatchFileBean;
import com.sunyard.client.bean.ClientBatchIndexBean;
import com.sunyard.client.bean.ClientFileBean;
import com.sunyard.client.bean.ClientHeightQuery;
import com.sunyard.client.impl.SunEcmClientSocketApiImpl;
import com.sunyard.util.OptionKey;

import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.rl.bank.base.dao.DictDao;
import cn.com.agree.huanan.ap.rl.bank.ias.dao.IasDao;
import cn.com.agree.huanan.ap.rl.bank.ias.exception.IasDownLoadException;
import cn.com.agree.huanan.ap.rl.bank.ias.exception.IasLogoutException;
import cn.com.agree.huanan.ap.rl.bank.ias.exception.IasQueryException;
import cn.com.agree.huanan.ap.rl.bank.ias.exception.IasUpdateException;
import cn.com.agree.huanan.ap.rl.bank.ias.exception.IasUploadException;
import cn.com.agree.huanan.ap.rl.bank.ias.exception.IasloginException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author cts
 * 影像平台 上传和查询
 * */
@Service
public class IasService {

	@Autowired private Logger logger;
	@Autowired private DictDao dictDao;
	@Autowired private IasDao iasDao;

	/**
	 * 影像平台登入
	 * 
	 * */
	private void login(SunEcmClientApi clientApi, String userName, String passWord) throws IasloginException,Exception{
		logger.info("userName:"+userName+" passWord:"+passWord);
		String resultMsg = clientApi.login(userName, passWord);
		logger.debug("登陆返回的信息[" + resultMsg + "]");

		if("FAIL".equals(resultMsg)) {
			throw new IasloginException();
		}
	}

	/**
	 * 影像平台登出
	 * */
	private void logout(SunEcmClientApi clientApi,String userName)  throws IasLogoutException,Exception{
		logger.info("userName:"+userName);
		String resultMsg = clientApi.logout(userName);
		logger.debug("登出返回的信息[" + resultMsg + "]");

		if("FAIL".equals(resultMsg)) {
			throw new IasLogoutException();
		}
	}

	/**
	 *  获取特定标签的Element集合
	 *  @param rootElement 根标签元素
	 *  @param name 需要查找的标签名
	 * */
	private ArrayList<Element> selectElement(Element rootElement,String name,ArrayList<Element> list) {
		for(Iterator iter =rootElement.elementIterator() ; iter.hasNext();) {
			Element element = (Element) iter.next();
			if(name.equals(element.getName())) {
				list.add(element);
			}else{
				selectElement(element, name ,list);
			}
		}
		return list;
	}

	/**
	 * 查询影像平台参数
	 * */
	public Map<String, Object> queryIasParam() {
		return dictDao.selectDict("IAS"); 
	}

	/**
	 * 上传到影像平台
	 *   
	 * @return
	 * @throws Exception
	 */
	public String upload(JavaList urlList ,JavaDict param ,String modelCodeString) {
		logger.info("urlList:"+urlList.toString());
		if(urlList.size()<1) {
			throw new IasUploadException("该图片不存在");
		}

		//通过查询数据库获取影像平台参数
		Map<String, Object> iasParam = dictDao.selectDict("IAS"); 
		String ip = (String)iasParam.get("ip");//影像平台ip
		String userName = (String)iasParam.get("username");//影像平台 用户名
		String passWord = (String)iasParam.get("password");//影像平台 用户密码
		int socketPort = Integer.parseInt((String)iasParam.get("socketport"));//影像平台 端口
		//根据枚举值查模型码
		String modelCode = iasDao.queryModelCodeFromSysPara(modelCodeString,"000011");//模型代码 参数类别为000011
		logger.info("modelCodeString:"+modelCodeString+"  modeCode:"+modelCode);
		//根据枚举值查文档部件模型代码
		String filePartName = iasDao.queryModelCodeFromSysPara(modelCodeString, "000013");//文档部件模型代码 参数类别为000013
		logger.info("filePartName:"+filePartName);

		ClientBatchBean clientBatchBean = new ClientBatchBean();//新建批次信息
		//建立连接
		SunEcmClientApi clientApi = new SunEcmClientSocketApiImpl(ip, socketPort);
		clientBatchBean.setModelCode(modelCode);// 设置内容模型
		clientBatchBean.setUser(userName);// 设置用户名
		clientBatchBean.setPassWord(passWord);// 设置密码
		clientBatchBean.setBreakPoint(false); // 是否作为断点续传上传
		clientBatchBean.setOwnMD5(false); // 是否为批次下的文件添加MD5码
		//		clientBatchBean.setToken_code("39BB237324570861DF5F56FB2A31EF17");//设置令牌号
		logger.info("iasParam:"+iasParam);

		// =========================设置索引对象信息=========================
		ClientBatchIndexBean clientBatchIndexBean = new ClientBatchIndexBean();// 新建索引对象
		clientBatchIndexBean.setAmount(String.valueOf(urlList.size()));// 必要信息,设置上传的批次文件数量
		clientBatchIndexBean.addCustomMap("CREATEDATE", param.getStringItem("BUSI_START_DATE"));// 必要信息,自定义属性中必须有一个8位数字字段,用以分表,从内容模型模板中获取字段名
		clientBatchIndexBean.addCustomMap("BUSI_SERIAL_NO",param.getStringItem("BUSI_SERIAL_NO"));//
		clientBatchIndexBean.addCustomMap("AMOUNT", String.valueOf(urlList.size()));// 目录数显示批次文件数量
		clientBatchIndexBean.addCustomMap("ORGAN_NAME", "001");//机构号
		clientBatchIndexBean.addCustomMap("APPID", "CSIS");//应用号
		clientBatchIndexBean.addCustomMap("BUSI_SCANUSER", "csis");//扫描人
		clientBatchIndexBean.addCustomMap("UPDATE_USER", "APIcsis");//扫描人
		clientBatchIndexBean.addCustomMap("CONTENT_STATUS", "1");//状态
		// =========================设置文档部件信息开始=========================
		ClientBatchFileBean clientBatchFileBean = new ClientBatchFileBean();// 新建一个文档部件
		clientBatchFileBean.setFilePartName(filePartName);// 必要信息,设置文档对象的内容模型名称
		// =========================设置文档部件信息结束=========================

		// =========================添加文件=========================
		for(int i=0; i<urlList.size() ;i++) {
			ClientFileBean fileBean = new ClientFileBean();// 新建文档对象
			File file = new File((String)(urlList.get(i)));
			String fileName = file.getName();  //文件名
			String fileAbPath = file.getAbsolutePath(); //文件路径
			fileBean.setFileName(fileAbPath);// 必要信息,设置文件的全路径
			fileBean.setFileFormat(fileAbPath.substring(fileAbPath.lastIndexOf(".")+1));// 必要信息,设置文件后缀
			logger.info("文件后缀"+fileAbPath.substring(fileAbPath.lastIndexOf(".")+1));
			fileBean.setOptionType("U_ADD");// 操作类型
			fileBean.addOtherAtt("FILE_LOCAL_NAME", fileName);
			logger.info("文件名称："+fileName);

			if("02".equals(modelCodeString)||"00".equals(modelCodeString)) { //STM和MMP的无纸化上传设置
				//判断类型
				if(fileName.contains("FM")) {  //1 正面 0反面
					fileBean.addOtherAtt("FILEFACE", "0");
				}else {
					fileBean.addOtherAtt("FILEFACE", "1");
				}

				if(fileName.contains("ZJFM")) { //证件反面
					fileBean.addOtherAtt("FILEFORM", "ZJFM");
					fileBean.addOtherAtt("SHOWNAME", "身份证反面");
					fileBean.addOtherAtt("TRUENAME","身份证反面"+fileName);
				}else if(fileName.contains("ZJZM")) { //证件正面
					fileBean.addOtherAtt("FILEFORM", "ZJZM");
					fileBean.addOtherAtt("SHOWNAME", "身份证正面");
					fileBean.addOtherAtt("TRUENAME","身份证正面"+fileName);
				}else if(fileName.contains("LWHC")) { //联网核查
					fileBean.addOtherAtt("FILEFORM", "LWHC");
					fileBean.addOtherAtt("SHOWNAME", "联网核查");
					fileBean.addOtherAtt("TRUENAME","联网核查"+fileName);
				}else if(fileName.contains("XCHZ")) { //客户现场
					fileBean.addOtherAtt("FILEFORM", "XCHZ");
					fileBean.addOtherAtt("SHOWNAME", "客户现场");
					fileBean.addOtherAtt("TRUENAME","客户现场"+fileName);
				}else if(fileName.contains("JZD")){ //进账单  
					fileBean.addOtherAtt("FILEFORM", "JZD");
					fileBean.addOtherAtt("SHOWNAME", "进账单");
					fileBean.addOtherAtt("TRUENAME","进账单"+fileName);
				}else if(fileName.contains("ZPZM")){ //支票正面  
					fileBean.addOtherAtt("FILEFORM", "ZPZM");
					fileBean.addOtherAtt("SHOWNAME", "支票正面");
					fileBean.addOtherAtt("TRUENAME","支票正面"+fileName);
				}else if(fileName.contains("ZPFM")){ //支票反面
					fileBean.addOtherAtt("FILEFORM", "ZPFM");
					fileBean.addOtherAtt("SHOWNAME", "支票反面");
					fileBean.addOtherAtt("TRUENAME","支票反面"+fileName);
				}else {
					fileBean.addOtherAtt("FILEFORM", "00");
					fileBean.addOtherAtt("SHOWNAME", fileName);
					fileBean.addOtherAtt("TRUENAME",fileName);
				}
				fileBean.addOtherAtt("FILEATTR", "0");//文件类型0-仅原图 1-有缩略图 2-排序批注文件
			}
			if("03".equals(modelCodeString)) { //MMP信审平台设置
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSsss");
				String dateTag = sdf.format(date);
				fileBean.addOtherAtt("TRUENAME", "001-0000" + i + "-" + i + fileAbPath.substring(fileAbPath.lastIndexOf(".")+1));
				if(fileName.contains("KE01")) {
					fileBean.addOtherAtt("FILEFORM","KE01");
					fileBean.addOtherAtt("SHOWNAME", "客户证件"+dateTag+i);
				}
				if(fileName.contains("KE02")){
					fileBean.addOtherAtt("FILEFORM","KE02");
					fileBean.addOtherAtt("SHOWNAME", "客户申请表正面"+dateTag+i);
				}
				if(fileName.contains("KE03")){
					fileBean.addOtherAtt("FILEFORM","KE03");
					fileBean.addOtherAtt("SHOWNAME", "客户申请表反面"+dateTag+i);
				}
				if(fileName.contains("KE121")){
					fileBean.addOtherAtt("FILEFORM","KE121");
					fileBean.addOtherAtt("SHOWNAME", "网申卡领卡确认函"+dateTag+i);
				}
				if(fileName.contains("KE176")){
					fileBean.addOtherAtt("FILEFORM","KE176");
					fileBean.addOtherAtt("SHOWNAME", "工作证明材料"+dateTag+i);
				}
				if(fileName.contains("KE177")){
					fileBean.addOtherAtt("FILEFORM","KE177");
					fileBean.addOtherAtt("SHOWNAME", "产权资料"+dateTag+i);
				}
				if(fileName.contains("KE178")){
					fileBean.addOtherAtt("FILEFORM","KE178");
					fileBean.addOtherAtt("SHOWNAME", "用途材料"+dateTag+i);
				}
				if(fileName.contains("KE179")){
					fileBean.addOtherAtt("FILEFORM","KE179");
					fileBean.addOtherAtt("SHOWNAME", "现场照片"+dateTag+i);
				}
				if(fileName.contains("KE04")){
					fileBean.addOtherAtt("FILEFORM","KE04");
					fileBean.addOtherAtt("SHOWNAME", "其它"+dateTag+i);
				}
				if(fileName.contains("KE05")){
					fileBean.addOtherAtt("FILEFORM","KE05");
					fileBean.addOtherAtt("SHOWNAME", "补件资料"+dateTag+i);
				}
				fileBean.addOtherAtt("FILEATTR", "1");//文件类型0-仅原图 1-有缩略图 2-排序批注文件
			}

			clientBatchFileBean.addFile(fileBean);// 文档对象与文档部件相关联
			logger.info("文档对象与文档部件相关联");
		}

		// =========================添加文件=========================
		clientBatchBean.setIndex_Object(clientBatchIndexBean);// 将文档索引信息和文档部件信息与批次信息关联
		clientBatchBean.addDocument_Object(clientBatchFileBean);
		String resultMsg = null;
		String contentID = null;
		try {
			//影像平台登入
			login(clientApi,userName,passWord);
			logger.info("开始上传");
			resultMsg = clientApi.upload(clientBatchBean, "影像服务器组");
			logger.info("上传结束");
			logger.info("上传批次返回的信息["+resultMsg+"]");
			//影像平台登出
			logout(clientApi,userName);
		}catch (Exception e) {
			throw new IasUploadException();
		}
		if("false".equals(resultMsg)) {
			throw new IasUploadException();
		}

		String[] result = resultMsg.split("<<::>>");
		contentID = result[1];

		if(!"SUCCESS".equals(result[0])) {
			throw new IasUploadException(); 
		}
		logger.info("resultMsg:"+resultMsg);
		logger.info("contentID:"+contentID);
		return contentID;
	}

	/**
	 * 查询影像平台
	 * 
	 * */
	public List<Map<String, String>> query(String tradedate, String contentId ,String modelCodeString) {
		logger.info("tradedate:"+tradedate+" contentId:"+contentId);
		//通过查询数据库获取影像平台参数
		Map<String, Object> iasParam = dictDao.selectDict("IAS"); 
		String ip = (String)iasParam.get("ip");//影像平台ip
		String userName = (String)iasParam.get("username");//影像平台 用户名
		String passWord = (String)iasParam.get("password");//影像平台 用户密码
		int socketPort = Integer.valueOf((String)iasParam.get("socketport"));//影像平台 端口
		//根据枚举值查模型码
		String modeCode = iasDao.queryModelCodeFromSysPara(modelCodeString,"000011");//模型代码 参数类别为000011
		logger.info("modelCodeString:"+modelCodeString+"  modeCode:"+modeCode);
		//根据枚举值查文档部件模型代码
		String filePartName = iasDao.queryModelCodeFromSysPara(modelCodeString, "000013");//文档部件模型代码 参数类别为000013
		logger.info("filePartName:"+filePartName);
		logger.info("iasParam:"+iasParam);
		//建立连接
		SunEcmClientApi clientApi = new SunEcmClientSocketApiImpl(ip, socketPort);

		ClientBatchBean clientBatchBean = new ClientBatchBean();
		clientBatchBean.setModelCode(modeCode); //模型代码
		clientBatchBean.setUser(userName);// 设置用户名
		clientBatchBean.setPassWord(passWord);// 设置密码
		clientBatchBean.getIndex_Object().setContentID(contentId);// 设置批次号

		// 02 无纸化 时间通过BUSI_START_DATE 来设置
		if("02".equals(modelCodeString)) {
			clientBatchBean.getIndex_Object().addCustomMap("BUSI_START_DATE",tradedate);// 必要信息,自定义属性中必须有一个8位数字字段,用以分表,从内容模型模板中获取字段名
			logger.info("设置BUSI_START_DATE");
		}else {
			clientBatchBean.getIndex_Object().addCustomMap("CREATEDATE",tradedate);// 必要信息,自定义属性中必须有一个8位数字字段,用以分表,从内容模型模板中获取字段名
			logger.info("设置CREATEDATE");
		}

		ClientBatchFileBean batchFileBean= new ClientBatchFileBean();
		batchFileBean.setFilePartName(filePartName);
		clientBatchBean.addDocument_Object(batchFileBean);

		String resultMsg = null;
		String groupName = "影像服务器组"; // 内容存储服务器组名(可以为null) 

		try {
			//影像平台登入
			login(clientApi,userName,passWord);
			logger.info("开始查询");
			resultMsg = clientApi.queryBatch(clientBatchBean, groupName);
			//影像平台登出
			logout(clientApi,userName);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new IasQueryException();
		}

		logger.info("查询批次返回的信息[" + resultMsg + "]");
		//获取影像平台返回结果xml
		String xml = resultMsg.split("<<::>>")[1];
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		Document document = null;
		//判断结果是否为空
		if(StringUtils.isEmpty(xml)) {
			throw new IasQueryException("影像平台查询无结果");
		}
		try {
			document = DocumentHelper.parseText(xml);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new IasQueryException("影像平台查询结果解析失败");
		}

		Element rootElement = document.getRootElement();
		ArrayList<Element> element = new ArrayList<>();
		ArrayList<Element> elementlist = new ArrayList<Element>();
		//查根标元素下特定的元素
		elementlist = selectElement(rootElement, "FileBean", elementlist);

		if(elementlist.size() < 1) {
			throw new IasQueryException("影像平台查询无结果");
		}

		for(int i=0; i<elementlist.size();i++) {
			Map<String, String> map = new HashMap<>();
			map.put("version", elementlist.get(i).attributeValue("VERSION"));
			map.put("upload_time", elementlist.get(i).attributeValue("UPLOAD_TIME"));
			map.put("file_format", elementlist.get(i).attributeValue("FILE_FORMAT"));
			map.put("file_no", elementlist.get(i).attributeValue("FILE_NO"));
			map.put("save_name", elementlist.get(i).attributeValue("SAVE_NAME"));
			map.put("content_id", elementlist.get(i).attributeValue("CONTENT_ID"));
			map.put("file_status", elementlist.get(i).attributeValue("FILE_STATUS"));
			map.put("option_type", elementlist.get(i).attributeValue("OPTION_TYPE"));
			map.put("file_size", elementlist.get(i).attributeValue("FILE_SIZE"));
			map.put("server_id", elementlist.get(i).attributeValue("SERVER_ID"));
			map.put("group_id", elementlist.get(i).attributeValue("GROUP_ID"));
			map.put("url", elementlist.get(i).attributeValue("URL"));

			element = selectElement(rootElement, "FILE_LOCAL_NAME" ,element);
			if(element.size() < 1) {
				map.put("file_name", "");
			}else {
				String str = element.get(i).elementText("string");
				logger.info("FILE_LOCAL_NAME标签下 string 的值："+str);
				map.put("file_name", str);				
			}		

			result.add(map);
		}
		logger.info("影像平台返回结果："+result);
		return result;
	}

	/**
	 * 影像平台更新
	 * */
	public String update(String tradedate, String contentId ,String modelCodeString , String trandate ,String serialno ,String brNo , String optflag, ArrayList<Map<String, String>> file_list){
		//通过查询数据库获取影像平台参数
		Map<String, Object> iasParam = dictDao.selectDict("IAS");
		String ip = (String)iasParam.get("ip");//影像平台ip
		String userName = (String)iasParam.get("username");//影像平台 用户名
		String passWord = (String)iasParam.get("password");//影像平台 用户密码
		int socketPort = Integer.parseInt((String)iasParam.get("socketport"));//影像平台 端口
		logger.info("iasParam:"+iasParam); //输出检查
		//根据枚举值查模型码
		String modelCode = iasDao.queryModelCodeFromSysPara(modelCodeString,"000011");//模型代码 参数类别为000011
		logger.info("modelCodeString:"+modelCodeString+"  modeCode:"+modelCode);
		//根据枚举值查文档部件模型代码
		String filePartName = iasDao.queryModelCodeFromSysPara(modelCodeString, "000013");//文档部件模型代码 参数类别为000013
		logger.info("filePartName:"+filePartName);

		//建立连接
		SunEcmClientApi clientApi = new SunEcmClientSocketApiImpl(ip, socketPort);
		ClientBatchBean clientBatchBean = new ClientBatchBean();
		clientBatchBean.setModelCode(modelCode);
		// 必选字段，设置登录用户名
		clientBatchBean.setUser(userName);
		// 必选字段，设置用户名密码
		clientBatchBean.setPassWord(passWord);
		// 必选字段，设置文件传输是否需要MD5的校验。True 需要；false 不需要
		clientBatchBean.setOwnMD5(false);
		clientBatchBean.getIndex_Object().addCustomMap("CREATEDATE",tradedate);
		// 必选字段，设置内容ID
		clientBatchBean.getIndex_Object().setContentID(contentId);
		// 必选字段，创建文档对象Bean
		ClientBatchFileBean batchFileBean = new ClientBatchFileBean();
		// 必选字段，设置文档对象英文名
		batchFileBean.setFilePartName(filePartName);
		
		//1-替换更新     2-追加更新
		if("1".equals(optflag)) { 
			for (int i = 0; i < file_list.size(); i++) {
				Map<String, String> fileMap = (Map<String, String>) file_list.get(i);
				File file = new File(fileMap.get("filepath"));
				String fileAbPath = file.getAbsolutePath(); //文件路径
				logger.info("文件路径:"+fileAbPath);
				// 新增一个文件
				ClientFileBean clientFileBean = new ClientFileBean();
				// 必选字段，设置操作类型为替换
				clientFileBean.setOptionType(OptionKey.U_REPLACE);
				// 必选字段，设置文件路径
				clientFileBean.setFileName(fileAbPath);
				// 必选字段，设置文件格式
				clientFileBean.setFileFormat(fileAbPath.substring(fileAbPath.lastIndexOf(".")+1));
				//可选字段，设置需要被替换文件的文件标识
				clientFileBean.setFileNO(fileMap.get("fileno"));
				//设置文件名
				clientFileBean.addOtherAtt("FILE_LOCAL_NAME", fileAbPath.substring(fileAbPath.lastIndexOf("/")+1));
				// 必选字段，将文档对象添加到索引对象中
				batchFileBean.addFile(clientFileBean);
			}
		}else if("2".equals(optflag)) { 
			for (int i = 0; i < file_list.size(); i++) {
				Map<String, String> fileMap = (Map<String, String>) file_list.get(i);
				File file = new File(fileMap.get("filepath"));
				String fileAbPath = file.getAbsolutePath(); //文件路径
				logger.info("文件路径:"+fileAbPath);
				// 新增一个文件
				ClientFileBean clientFileBean = new ClientFileBean();
				// 必选字段，设置操作类型为追加
				clientFileBean.setOptionType(OptionKey.U_ADD);
				// 必选字段，设置文件路径
				clientFileBean.setFileName(fileAbPath);
				// 必选字段，设置文件格式
				clientFileBean.setFileFormat(fileAbPath.substring(fileAbPath.lastIndexOf(".")+1));
				//设置文件名
				clientFileBean.addOtherAtt("FILE_LOCAL_NAME", fileAbPath.substring(fileAbPath.lastIndexOf("/")+1));
				// 必选字段，将文档对象添加到索引对象中
				batchFileBean.addFile(clientFileBean);
			}
		}
		
		clientBatchBean.addDocument_Object(batchFileBean);
		String groupName = "影像服务器组";
		String resultMsg = "";
		try {
			login(clientApi,userName,passWord);//影像平台登入
			logger.info("开始影像更新");
			resultMsg = clientApi.update(clientBatchBean, groupName,true);
			logger.info("#######更新批次返回的信息[" + resultMsg + "]#######");
			logout(clientApi,userName);//影像平台登出
		} catch (Exception e) {
			e.printStackTrace();
		}

		//输出为 "SUCCESS" 才是更新成功，更新成功后不改变批次号和上传日期
		if(!"SUCCESS".equals(resultMsg)) {
			throw new IasUpdateException();
		}
		return resultMsg;
	}

	/**
	 * 影像下载
	 * @param urlList 影像查询返回的集合
	 * */
	public void download(List<Map<String, String>> urlList) {
		String pathString = null;       //服务器路径前缀
		String savePath = null;         //图像全路径
		String file_name = null;		//文件名
		String url = null; 				//文件url
		String file_format;
		String file_no;
		//通过查询数据库获取影像平台参数
		Map<String, Object> iasParam = dictDao.selectDict("IAS");
		pathString = (String)iasParam.get("downloadpath");
		for (int i = 0; i < urlList.size(); i++) {
			Map<String, String> map = urlList.get(i);
			file_name = map.get("file_name");
			url = map.get("url");
			file_format = map.get("file_format");
			file_no = map.get("file_no");
			logger.info(i+" url:"+url);
			logger.info("file_no:"+file_no+"  file_format:"+file_format);
			savePath = pathString+"/"+file_no+"."+file_format.toLowerCase();
			logger.info(i+" 下载到："+savePath);
			downloadUsingStream(url , savePath);				
		}	

	}


	/**
	 * 影像下载具体方法
	 * @param urlStr 下载的url
	 * @param savePath 	文件路径
	 * */
	private void downloadUsingStream(String urlStr , String savePath) {

		try {

			URL url = new URL(urlStr);  //通过URL建立连接
			BufferedInputStream bis = new BufferedInputStream(url.openStream()); //获得影像的输入流
			FileOutputStream fis = new FileOutputStream(savePath);   //建立输出流   savePath为输出到的绝对路径
			byte[] buffer = new byte[1024];
			int count = 0;

			while((count = bis.read(buffer, 0, 1024)) != -1) {   //输出文件
				fis.write(buffer , 0 ,count); 
				fis.flush();
			}

			fis.close();
			bis.close();

		} catch (IOException e) {
			logger.info(e.getMessage());
			throw new IasDownLoadException();
		}
	}

	/**
	 * 影像高级查询，通过流水号serialno查询批次信息
	 * 
	 * */
	public String heightQueryExample(String modelCodeString, String serialno , String tradedate) {

		//通过查询数据库获取影像平台参数
		Map<String, Object> iasParam = dictDao.selectDict("IAS");
		String ip = (String)iasParam.get("ip");//影像平台ip
		String userName = (String)iasParam.get("username");//影像平台 用户名
		String passWord = (String)iasParam.get("password");//影像平台 用户密码
		int socketPort = Integer.parseInt((String)iasParam.get("socketport"));//影像平台 端口
		logger.info("iasParam:"+iasParam); //输出检查
		//根据枚举值查模型码
		String modelCode = iasDao.queryModelCodeFromSysPara(modelCodeString,"000011");//模型代码 参数类别为000011
		logger.info("modelCodeString:"+modelCodeString+"  modeCode:"+modelCode);
		//建立连接
		SunEcmClientApi clientApi = new SunEcmClientSocketApiImpl(ip, socketPort);
		String groupName = "影像服务器组";
		ClientHeightQuery heightQuery = new ClientHeightQuery();// 批次信息描述对象
		heightQuery.setUserName(userName);// 设置用户名
		heightQuery.setPassWord(passWord);// 设置密码
		heightQuery.setLimit(10);// 必要信息,设置行数
		heightQuery.setPage(1);// 必要信息,设置页码
		heightQuery.setModelCode(modelCode);// 必要信息,设置内容模型名
		heightQuery.addCustomAtt("BUSI_SERIAL_NO", serialno);
		heightQuery.addCustomAtt("CREATEDATE", tradedate);// 必要信息,自定义属性中必须有一个8位数字字段,用以分表,从内容模型模板中获取字段名BUSI_START_DATE

		String resultMsg ;
		try {
			login(clientApi,userName,passWord);//影像平台登入
			resultMsg = clientApi.heightQuery(heightQuery, groupName);
			logger.info("高级搜索返回的信息:" + resultMsg);
			logout(clientApi,userName);//影像平台登出
		} catch (Exception e) {
			throw new IasQueryException();
		}

		String xml = resultMsg.split("<<::>>")[1];
		Document document = null;
		//判断结果是否为空
		if(StringUtils.isEmpty(xml)) {
			throw new IasQueryException("影像平台查询无结果");
		}
		try {
			document = DocumentHelper.parseText(xml);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new IasQueryException("影像平台查询结果解析失败");
		}

		Element rootElement = document.getRootElement();
		ArrayList<Element> elementlist = new ArrayList<Element>();
		//查根标元素下特定的元素
		elementlist = selectElement(rootElement, "BatchIndexBean", elementlist);
		
		String contendId = "";
		if(elementlist.size() < 1) {
			logger.info("影像平台查询无结果");
		}else {
			contendId = elementlist.get(0).attributeValue("CONTENT_ID");
			logger.info("高级查询返回的批次号："+contendId);
		}
		
		return contendId;

	}

}


























