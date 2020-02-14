package cn.com.agree.huanan.ap.tl.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author liutao
 *	文件写入
 */
public class FileParserWriter {

	private BufferedWriter out = null;
	private String path;
	private String splitflag;

	/**
	 * @param filePath 文件全路径
	 * @param split   分隔符
	 */
	public FileParserWriter(String filePath, String split) {
		this.path = filePath;
		this.splitflag = split;
	}

	/**
	 * 把List集合中存储的内容写入到文件中
	 * @param writeList
	 *            存放写入数据的List集合 list格式为 [[],[],[],....]
	 * @throws IOException 
	 */
	public void writeFile(List<String> writeList) throws IOException {
		// BufferedWriter out = null;

			if (out == null) {
				//System.out.println(path);
				File writeFile = new File(path);
				if (!writeFile.exists()) {
					writeFile.createNewFile(); // 创建新文件
				}
				out = new BufferedWriter(new FileWriter(writeFile, true));
			}
			StringBuffer info = new StringBuffer();
			for (String str : writeList) {
				info.append(str).append(splitflag);
			}
			//StringBuffer sbf = new StringBuffer();
			
			//去除最后一个分隔符
			String result = info.toString();
			if (result.length() > splitflag.length()) {
				result = result.substring(0, info.length() - splitflag.length());
			}
			out.write(result); // 写入内容
			out.newLine(); // 文件新建一行
			out.flush(); // 把缓存区内容压入文件
	}

	public void close() throws IOException {
		if (out != null) {
			out.close();
		}
	}
}
