package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.base.dao.CertarCodeDao;
import cn.com.agree.huanan.ap.al.csitrd.base.po.CertarCode;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApFileNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 发证机关服务
 * @author liaowen
 */
@Service
public class CertarCodeService {
	@Autowired CertarCodeDao certarCodeDao;
	private Logger logger = Logger.getLogger(CertarCodeService.class);

	/**
	 * 查询发证机关代码
	 * @param certarcode 发证机关代码
	 * @param certarname 发证机关名称
	 * @return
	 */
	public Map<String, Object> queryCertarInfo(String certarcode, String certarname) {
		if(StringUtils.isEmpty(certarcode) && StringUtils.isEmpty(certarname)) {
			logger.error("发证机关代码与发证机关名称不能同时为空");
			throw new ApIllegalParamException("certarcode与certarname不能同时为空");
		}
		CertarCode certar = certarCodeDao.queryCertarCode(certarcode,certarname);
		logger.info("查询结果："+certar);
		
		Map<String, Object> result = new HashMap<>();
		result.put("certarcode", certar.getCertarcode());
		result.put("certarname", certar.getCertarname());
		return result;
	}
	
	/**
	 * 发证机关代码生成
	 */
	public void certarInfoGenerate() {
		List<CertarCode> certarCodeList = certarCodeDao.queryCertarCodeAll();
		
		File file = new File("/export/file/STM/certar_code/certar_code.txt");
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
		}
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			
			//遍历打印
			for(CertarCode certarCode : certarCodeList) {
				StringBuffer sbuf = new StringBuffer();

				sbuf.append(certarCode.getCertarcode());
				sbuf.append("|");
				sbuf.append(certarCode.getCertarname());
				sbuf.append("\n");
				
				pw.write(sbuf.toString());
				pw.flush();
			}
			
		} catch (FileNotFoundException e) {
			logger.error("文件未找到");
			throw new ApFileNotFoundException(e);
		}finally {
			if(pw != null) {
				pw.close();
			}
		}
		
		logger.info("打印结束");
		if(file.exists()) {
			logger.info("生成文件成功");
		}else {
			logger.error("生成文件失败");
			throw new ApFileNotFoundException(new FileNotFoundException());
		}
		
	}
	
	

}
