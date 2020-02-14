package cn.com.agree.huanan.ap.tl.communicate.http.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class HttpHeaderDefineTest {


    @Test
    public void test(){
        HttpHeaderDefine define = new HttpHeaderDefine();
        String contentType = define.getContentType();
        String contentLength = define.getContentLength();

        Assert.assertEquals("Content-Type",contentType);
        Assert.assertEquals("Content-Length",contentLength);

    }

}


