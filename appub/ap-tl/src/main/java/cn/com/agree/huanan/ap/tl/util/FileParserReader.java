/**
 * FileName: FileParser
 * Author:   Liu Tao
 * Date:     2018/8/21 19:22
 */

package cn.com.agree.huanan.ap.tl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * @author liutao
 * 文件解析
 */
public class FileParserReader {

	private Logger logger = Logger.getLogger(FileParserReader.class);
	private List<List<String>> parserFields;
	private String splitFlag;
	private int rows;
	private File file;
	private LineNumberReader line = null;

	/**
	 * 
	 * @param filePath
	 *            文件全路径
	 * @param fields
	 *            解析每个字段的字段名以及规则 格式为：List<List<String>> List集合中内容格式为
	 *            "字段名","字段长度（按字节算）","是否必输（M-必输，N-非必输）"
	 * @param split
	 *            分隔符
	 */
	public FileParserReader(String filePath, List<List<String>> fields, String split) {
		// TODO 自动生成的构造函数存根
		this.parserFields = fields;
		this.splitFlag = split;
		intializeFile(filePath);
		this.rows = getRows(file);
	}
	
	private void intializeFile(String filePath){
		file = new File(filePath);
		try {
			line = new LineNumberReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * 获取文件的行数
	 * 
	 * @param file 文件名
	 * @return 行数
	 */
	private int getRows(File file) {
		if (!file.exists()) {
			return 0;
		}
		LineNumberReader reader = null;
		int rows = 0;
		try {
			// 目前没找到其他的读取文件行数的方法，暂时先用这个
			reader = new LineNumberReader(new FileReader(file));
			// String info = "";
			while (reader.readLine() != null) {
			}
			rows = reader.getLineNumber();
			return rows;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

	/**
	 * 获取文件行数
	 * 
	 * @return 总行数
	 */
	public int getFileLineNum() {
		return rows;
	}
	
	/**
	 * 判断是否有下一行
	 * @return 是，否有下一行
	 */
	public boolean hasNext(){
		
		return line.getLineNumber() < rows;
	}

	/**
	 * 逐行转换文件内容。每调用一次方法转换一次。转换成功后返回map
	 * map中额外有errorCode和errorMsg字段。用于描述是否转换成功；
	 * 错误代码有0000（转化成功）、0001（传入的校验规则不符合规范）、0002（文件内容校验不成功）
	 * @return 处理后map集合
	 * @throws Exception 异常
	 */
	public Map<String, String> nextLine() throws Exception {
		
		String info = "";
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("errorCode", "0000");
			map.put("errorMsg", "转换成功");
			// 先给每个字段赋值空
			Map<String, String> infoMap = new HashMap<String, String>();
			for (List<String> x : parserFields) {
				infoMap.put(x.get(0), "");// 先给map赋空值
			}

			if ((info = line.readLine()) != null) {
				String[] str = info.split(splitFlag);
				for (int i = 0; i < str.length; i++) {
					List<String> rule = parserFields.get(i);
					if (!rule.get(1).matches("[0-9]{1,}")) {
						//System.out.println("填写的字段长度规则不符合规范！");
						logger.error("填写的字段长度校验规则不符合规范！");
						map.put("errorCode", "0001");
						map.put("errorMsg", "填写的字段长度校验规则不符合规范！");
						return map;
					}
					int length = Integer.parseInt(rule.get(1));//
					if (str[i].getBytes("GBK").length > length) {
						//System.out.println("文件第" + line.getLineNumber() + "行字段长度不符合规范！");
						logger.error(rule.get(0)+"字段，内容长度不符合规范！");
						map.put("errorCode", "0002");
						map.put("errorMsg", rule.get(0)+"字段，内容长度不符合规范！");
						return map;
					}
					
					infoMap.put(rule.get(0), str[i]);
				}
				for (List<String> rule : parserFields) {
					String checkInfo = infoMap.get(rule.get(0));
					String isMust = rule.get(2);//字段是否必输
					if(!isMust.matches("[MN]{1}")){//校验规则是否合法
						logger.error("校验规则未填写是否必输校验！");
						map.put("errorCode", "0001");
						map.put("errorMsg", "校验规则未填写是否必输校验！");
						return map;
					}
					if("M".equals(isMust)){
						if(checkInfo.length() == 0){
							logger.error(rule.get(0)+"字段为必输项,不能为空!");
							map.put("errorCode", "0002");
							map.put("errorMsg", rule.get(0)+"字段为必输项,不能为空!");
							return map;
						}
					}
				}
				if("0000".equals(map.get("errorCode"))){
					map.putAll(infoMap);
				}
			}else{
				throw new NullPointerException();
			}
			return map;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			//System.out.println("over");
			//return null;
			throw e;
		}

	}

	/**
	 * 关闭写文件流
	 * 
	 * @throws IOException 异常
	 */
	public void close() throws IOException {

		if (line != null) {
			line.close();
		}

	}

}
