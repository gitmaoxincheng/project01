package cn.com.agree.huanan.ap.al.csitrd.rcpt.po;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

public class ConvertBothClobToString {
	public static String ClobToString(Clob clob) throws SQLException, IOException{
	/*	Reader is=clob.getCharacterStream();
		BufferedReader br=new BufferedReader(is);
		StringBuffer sb=new StringBuffer();
		String s="";
		while(((s=br.readLine())!=null)){
			sb.append(s);
		}              
		return sb.toString();
		ps：百度查找了一下，发现这种方法效率贼底，废弃。
		*/
	    if(clob!=null) {
	    	return clob.getSubString((long)1,(int)clob.length());
	    }
	    return "";
	}
	public static Clob StringToClob(String content) throws SerialException, SQLException{
		if(content!=null&& !"".equals(content)){
			Clob c=new SerialClob(content.toCharArray());
			return c;
		}
		return null;
	}
}
