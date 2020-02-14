package cn.com.agree.huanan.ap.tl.util;

import cn.com.agree.huanan.ap.tl.exception.tech.ApFileNotFoundException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class PropUtil {


    public static Properties getProperties(String filename) throws Exception {
        return getProperties(filename,null);
    }

    /**
     * 根据项目路径下的配置文件获取Properties
     */
    public static Properties getProperties(String filename,String charset) {
            String url = new PropUtil().getClass().getResource("/"+filename).getFile();
            if(url == null || "".equals(url)){
                throw new ApFileNotFoundException(new FileNotFoundException("Properties file not exist"));
            }
            return getProp(url,charset);
    }
    /**
     * 根据绝对路径下的配置文件获取Properties
     */
    public static Properties getProperties(String path,String filename,String charset){
        String url = path + "/"+filename;
        if(url == null || "".equals(url)|| !(new File(url)).exists()){
                throw new ApFileNotFoundException(new FileNotFoundException("Properties file not exist"));
        }
        return  getProp(url,charset);
    }

    public static Properties getProp(String filePath,String charset ) {
        InputStreamReader inr=null;
        Properties prop = new Properties();
        try {
        	InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            if (charset==null){
                inr = new InputStreamReader(in);
            }else {
                inr = new InputStreamReader(in,charset);
            }
            prop.load(inr);
            return  prop;
        } catch (FileNotFoundException e) {
            throw new ApFileNotFoundException(e);
        } catch (IOException e) {
            throw new ApIOException(e);
        }finally {
            try{
            	inr.close();
            } catch (IOException e) {
                throw new ApIOException(e);
            }
        }
    }



    public static void updateProperties(String path,String filename,Map<String,String> keyValueMap){

        Properties properties = new Properties();
        BufferedReader br = null;
        BufferedWriter bw = null;
        String url = path + "/"+filename;
        if(url == null || "".equals(url)){
            throw new ApFileNotFoundException(new FileNotFoundException("Properties file not exist"));
        }
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
            properties.load(br);
            br.close();

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url)));
            properties.clear();

            for(String key : keyValueMap.keySet())
                properties.setProperty(key,keyValueMap.get(key));
            properties.store(bw,"");
            bw.close();
        } catch (FileNotFoundException e) {
            throw new ApFileNotFoundException(e);
        } catch (IOException e) {
            throw new ApIOException(e);
        } finally {
            try{
                br.close();
                bw.close();
            } catch (IOException e) {
                throw new ApIOException(e);
            }
        }
    }
}

