package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import org.apache.http.entity.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUN
 */
public class ConstTestAll {

    @Test
    public void testConst(){
        Assert.assertEquals(200,Const.DEFAULT_POOL_MAX_TOTAL);
        Assert.assertEquals(200,Const.DEFAULT_POOL_MAX_PER_ROUTE);
        Assert.assertEquals(500,Const.DEFAULT_CONNECT_REQUEST_TIMEOUT);
        Assert.assertEquals(2000,Const.DEFAULT_WAITTIME);
        Assert.assertEquals(60,Const.DEFAULT_INACTIVE_TIME);
    }

    @Test
    public void testConstMapAndList(){
        Map<String, ContentType> textMap = new HashMap<String, ContentType>() {
            {
                put("APPLICATION_ATOM_XML", ContentType.APPLICATION_ATOM_XML);
                put("APPLICATION_FORM_URLENCODED", ContentType.APPLICATION_FORM_URLENCODED);
                put("APPLICATION_JSON", ContentType.APPLICATION_JSON);
                put("APPLICATION_SVG_XML", ContentType.APPLICATION_SVG_XML);
                put("APPLICATION_XHTML_XML", ContentType.APPLICATION_XHTML_XML);
                put("APPLICATION_XML", ContentType.APPLICATION_XML);
                put("TEXT_HTML", ContentType.TEXT_HTML);
                put("TEXT_PLAIN", ContentType.TEXT_PLAIN);
                put("TEXT_XML", ContentType.TEXT_XML);
            }};
        Assert.assertEquals(textMap,ConstMapAndList.CONTENT_TYPE_TEXT_MAP);

        Map<String, ContentType> binaryMap = new HashMap<String, ContentType>(){{
            put("IMAGE_BMP", ContentType.IMAGE_BMP);
            put("IMAGE_GIF", ContentType.IMAGE_GIF);
            put("IMAGE_JPEG", ContentType.IMAGE_JPEG);
            put("IMAGE_PNG", ContentType.IMAGE_PNG);
            put("IMAGE_SVG", ContentType.IMAGE_SVG);
            put("IMAGE_TIFF", ContentType.IMAGE_TIFF);
            put("IMAGE_WEBP", ContentType.IMAGE_WEBP);
            put("MULTIPART_FORM_DATA", ContentType.MULTIPART_FORM_DATA);
        }};

        Assert.assertEquals(binaryMap,ConstMapAndList.CONTENT_TYPE_BINARY_MAP);
    }


//    public void test
}
