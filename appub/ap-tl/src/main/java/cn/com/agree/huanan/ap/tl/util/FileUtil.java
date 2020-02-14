/**
 * FileName: FileUtil
 * Author:   Ren Xiaotian
 * Date:     2018/8/14 17:57
 */

package cn.com.agree.huanan.ap.tl.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.NullArgumentException;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.tl.exception.tech.ApFileNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 文件操作类
 */
public class FileUtil {

	private  static Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * 复制文件
	 *
	 * @param sourceFile
	 *            源文件
	 * @param targetFile
	 *            目标文件
	 */
	public static void copyFile(File sourceFile, File targetFile) {
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile)); // 源文件对应输入流
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetFile)); // 目标文件对应输出流

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = bufferedInputStream.read(b)) != -1) {
				bufferedOutputStream.write(b, 0, len);
			}

			bufferedOutputStream.flush(); // 刷新缓冲区数据到硬盘
		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
				if (bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}
	}

	/**
	 * 复制全部，包括子目录和文件
	 *
	 * @param src
	 *            源目录
	 * @param dest
	 *            目标目录
	 */
	public static void copyAll(String src, String dest) {
		File destDir = new File(dest);
		if (!destDir.exists()) {
			destDir.mkdirs(); // 可级联创建
		}

		File[] files = (new File(src)).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) { // 如果是文件，则直接复制
				copyFile(files[i].getAbsoluteFile(), new File(dest + "/" + files[i].getName()));
			} else if (files[i].isDirectory()) { // 如果是目录
				// 复制目录
				String sourceDir = src + "/" + files[i].getName();
				String targetDir = dest + "/" + files[i].getName();
				copyAll(sourceDir, targetDir);
			}
		}
	}

	/**
	 * 静态变量，保存listDirectory()递归产生的结果
	 */
	private static List<String> fileNameList = new ArrayList<String>();

	public static List<String> getFileNameList() {
		return fileNameList;
	}

	/**
	 * 递归便利指定目录，列出所有子目录和文件
	 *
	 * @param dir
	 *            指定目录
	 * @return 返回所有子目录和文件的列表
	 */
	private static List<String> listDirectory(File dir) {
		if (dir.isDirectory()) { // 如果是目录
			File lists[] = dir.listFiles();
			if (lists != null) {
				for (int i = 0; i < lists.length; i++) {
					listDirectory(lists[i]); // 递归地列出内容
				}
			}
		} else {
			fileNameList.add(dir.getAbsoluteFile().toString());
		}
		return fileNameList;
	}

	/**
	 * 查找文件
	 *
	 * @param dir
	 *            指定在这个目录中查找
	 * @param fileName
	 *            要查找的文件名
	 * @return 返回查找到的文件列表
	 */
	public static List<String> find(String dir, String fileName) {
		if (fileNameList.size() > 0) {
			fileNameList.clear(); // 清空之前的缓存
		}
		fileNameList = listDirectory(new File(dir)); // 采用工具类的静态变量存储递归结果

		List<String> retList = new LinkedList<String>();
		for (String fName : fileNameList) {
			String tmpName = (new File(fName)).getAbsoluteFile().toString();
			if (tmpName != null) {
				if (tmpName.indexOf(fileName) > 0) {
					((LinkedList<String>) retList).addLast(tmpName);
				}
			}
		}

		return retList;
	}

	/**
	 * 在指定文件中查找内容
	 *
	 * @param targetFileName
	 *            指定文件
	 * @param msg
	 *            要查找的内容
	 * @return 返回<行号 , 该行的内容>
	 */
	public static Map<Integer, String> searchMsgInFile(String targetFileName, String msg) {
		if (msg == null || "".equals(msg)) { // 如果要搜索的内容为空，则直接返回
			return null;
		}

		Map<Integer, String> retMap = new HashMap<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(targetFileName));
			String line = bufferedReader.readLine();
			int lineNum = 1; // 行号

			while (line != null) {
				if (line.contains(msg)) {
					// retMap.put(new Integer(lineNum), line); // <行号，内容>
					retMap.put(Integer.valueOf(lineNum), line); // <行号，内容>
				}
				line = bufferedReader.readLine();
				lineNum++;
			}
		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		}finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}

		return retMap;
	}

	/**
	 * 读取文件内容
	 *
	 * @param fileName
	 *            要读取的文件名
	 * @return 返回byte[]数组，文件的内容
	 */
	public static byte[] readFile(String fileName) {
		byte[] retBytes = null;
		FileInputStream fileInputStream = null;

		try {
			File file = new File(fileName);

			if (file.length() > Integer.MAX_VALUE) {
				throw new ApIOException(new IOException("file is too big: " + file.length()));
			}
			retBytes = new byte[(int) file.length()];

			fileInputStream = new FileInputStream(file);
			fileInputStream.read(retBytes);

		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}

		return retBytes;
	}

	/**
	 * 从文件中读取指定长度的内容
	 *
	 * @param fileName
	 *            要读取的文件名
	 * @param start
	 *            起始位置
	 * @param len
	 *            长度
	 * @return 返回byte[]数组，文件的内容
	 */
	public static byte[] readFile(String fileName, int start, int len) {
		byte[] retBytes = null;
		FileInputStream fileInputStream = null;

		try {
			File file = new File(fileName);

			if (len > Integer.MAX_VALUE) {
				throw new ApIOException(new IOException("what you read is too length: " + len));
			}
			retBytes = new byte[len];

			fileInputStream = new FileInputStream(file);
			fileInputStream.read(retBytes, start, len);

		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}

		return retBytes;
	}

	/**
	 * 写入byte[]内容到文件
	 *
	 * @param data
	 *            要写入的内容
	 * @param destFile
	 *            目标文件
	 * @return 返回true，写入成功；抛异常，写入失败
	 */
	public static boolean writeData2File(byte[] data, String destFile) {
		FileOutputStream fileOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(new File(destFile));
			fileOutputStream.write(data);
			return true;
		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}
	}

	/**
	 * 写入byte[]指定部分内容到文件
	 *
	 * @param data
	 *            要写入的内容
	 * @param start
	 *            起始位置
	 * @param len
	 *            长度
	 * @param destFile
	 *            目标文件
	 * @return 返回true，写入成功；抛异常，写入失败
	 */
	public static boolean writeData2File(byte[] data, int start, int len, String destFile) {
		FileOutputStream fileOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(new File(destFile));
			fileOutputStream.write(data, start, len);
			return true;
		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}
	}

	/**
	 * 
	 * @param data
	 * @param destFile
	 * @param append
	 * @param charset
	 * @return
	 */
	public static boolean writeData2File(String data, String destFile, boolean append, String charset) {
		File file = new File(destFile);
		if (!file.getParentFile().exists()) {
			// 如果父目录不存在，创建父目录
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				throw new ApIOException(e);
			}
		}

		OutputStreamWriter out = null;

		try {
			out = new OutputStreamWriter(new FileOutputStream(new File(destFile), append), charset);
			out.write(data);
			out.flush();
			return true;
		} catch (FileNotFoundException e) {
			throw new ApFileNotFoundException(e);
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}
	}

	/**
	 * 按行读取文件内容拼成字符串
	 * 
	 * @param fileName 文件名
	 * @param charset 文件编码
	 * @param split 分割每行内容
	 * @return
	 */
	public static String readFileLine(String fileName, String charset, String split) {
		BufferedReader reader = null;
		String lineInfo = null;
		String strFromFile = "";
		File file = new File(fileName);

		if (charset == null) {
			charset = "UTF-8";
		}
		if (!file.exists()) {
			return null;// 文件不存在返回空
		}
		if (file.length() == 0) {
			return null;// 文件内容为空返回空
		}
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			while ((lineInfo = reader.readLine()) != null) {
				strFromFile = strFromFile + lineInfo + split;
			}
			return strFromFile;
		} catch (IOException e) {
			throw new ApIOException(e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				throw new ApIOException(e);
			}
		}
	}
	


	//创建空文件
	public static boolean createFile(String filePath) throws IOException {
			File file = new File(filePath);
			if (file.exists()) {
				logger.error("文件"+filePath+"已存在");
				return false;
			}
			if(file.isDirectory()) {
				return file.mkdir();	
			}else {
				return file.createNewFile();
			}
	}

	
	
	//文件是否存在
	public static boolean existFile(String path,String resource) {
		if (StringUtils.isEmpty(path) || StringUtils.isEmpty(resource)) {
			throw new NullArgumentException("文件路径或文件名");
		}
		File file = new File(path+resource);
		return (file.exists() && file.isFile());
	} 
	
	

	//读取配置, XXX提供一个CfgUtil
	public static Map<String, Map<String, String>> readConfiguration(String path,String resource,String coding,String blockName) {
		Map<String,Map<String,String>> hashMaps = new HashMap<String,Map<String,String>>();
		FileInputStream fis = null;
		if (StrUtil.isNull(path)||StrUtil.isNull(resource)|| StrUtil.isNull(coding)) {
			throw new RuntimeException("文件路径或文件名和编码不能为空");
		}
		File file = new File(path+resource);
		if(!file.exists() || !file.isFile()) {
			throw new RuntimeException("路径"+path+"下的文件"+resource+"不存在!");
		}
		try {
			file = new File(path+resource);
			fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,coding));
			String line;
			while ((line = br.readLine()) != null) {
				StrUtil.handleLine(line);
			}
			if (StrUtil.isNull(blockName)) {
				logger.info("读取的是完整配置!");
				return hashMaps;
			}
			
			Map<String, Map<String, String>> maps = new HashMap<String, Map<String,String>>();
			maps.put(blockName, hashMaps.get(blockName));
			return maps;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}	
	
}
