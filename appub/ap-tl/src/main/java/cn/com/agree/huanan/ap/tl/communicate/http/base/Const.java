package cn.com.agree.huanan.ap.tl.communicate.http.base;

public class Const {
	
	// 默认通信报文格式
	public static final String DEFAULT_CONTENT_TYPE = "JSON";
	
	// 默认操作
    public static final String DEFAULT_HTTP_OPERATOR = "POST";
    
	// 默认版本
	public static final String DEFAULT_HTTP_VERSION_TYPE = "HTTP/1.1";
	
	 /**
     * Horizontal space
     */
	public static final byte SP = 32;

    /**
     * Carriage return
     */
	public static final byte CR = 13;

    /**
     * Line feed character
     */
	public static final byte LF = 10;

    /**
     * Colon ':'
     */
	public static final byte COLON = 58;

	public static final String HTTP_SUCCESS_CODE = "200";
	
	public static String PCK_LENGTH = "Content-Length";

	public static final byte[] CRLF = { CR, LF };
	
	public static final byte[] HEADER_SEPARATOR = { COLON, SP };
	
	// Package Key Name
	public static final String HEADER_KEY = "HTTP_HEADER";
	
	public static final String CONTENT_KEY = "HTTP_CONTENT";

}
