package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.base.dao.AreaCodeDao;
import cn.com.agree.huanan.ap.al.csitrd.base.po.AreaCode;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApFileNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


/**
 * 区域代码服务
 * @author liaowen
 */
@Service
public class AreaCodeService {
	@Autowired AreaCodeDao areaCodeDao;
	private Logger logger = Logger.getLogger(AreaCodeService.class);
	
	/**
	 * 查询区域代码
	 * @param query 查询类型
	 * @param querycont 查询要素
	 * @return
	 */
	public Map<String, Object> queryAreaCode(String query, String querycont) {
		List<Map<String, Object>> list = null;
		
		if(query.equals("0")) {
			if(!querycont.isEmpty()) {
				logger.error("查询省级时查询要素送空");
				throw new ApIllegalParamException("查询省级时查询要素送空");
			}
		}
		if(query.equals("1")) {
			if(querycont.isEmpty() || !querycont.substring(2).equals("0000")) {
				logger.error("查询市级时应上送的省级区域代码");
				throw new ApIllegalParamException("查询市级时应上送的省级区域代码");
			}
		}
		if(query.equals("2")) {
			if(querycont.isEmpty() ||!querycont.substring(4).equals("00") || querycont.substring(2).equals("0000")) {
				logger.error("查询县级时应上送的市级区域代码");
				throw new ApIllegalParamException("查询县级时应上送的市级区域代码");
			}
		}
		list = areaCodeDao.queryAreaCode(querycont,query);
		
		Map<String, Object> result = new HashMap<>();
		result.put("listnm", list.size());
		result.put("area_list", list);
		return result;
	}
	
	
	/**
	 * 行政区域代码生成
	 */
	public void areaCodeGenerate() {
		List<AreaCode> areaCodeList = areaCodeDao.queryAreaCodeAll();
		
		File file = new File("/export/file/STM/area_code/area_code.txt");
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
		}
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			
			//遍历打印
			for(AreaCode areaCode : areaCodeList) {
				StringBuffer sbuf = new StringBuffer();

				sbuf.append(areaCode.getAreacode());
				sbuf.append("|");
				sbuf.append(areaCode.getAreaname());
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
