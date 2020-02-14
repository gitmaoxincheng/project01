package cn.com.agree.huanan.ap.tl.message.impl;

import cn.com.agree.huanan.ap.tl.communicate.http.base.Const;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.mockito.Mockito.*;
/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class HttpParserImplTest {
    @Mock
    private Logger logger;

    HttpParserImpl httpParser;

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);

        httpParser = new HttpParserImpl();

        when(Logger.getLogger(HttpParserImpl.class)).thenReturn(logger);
        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());

    }

    @Test
    public void testUnpack(){
        Map<String, Object> actual = httpParser.unpack(null,"");
        Assert.assertNull(actual);
    }

    @Test
    public void testPack() throws UnsupportedEncodingException {
        Map<String, Object> msgMap = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("k1","v1");
        msgMap.put(Const.HEADER_KEY,map1);
        msgMap.put(Const.CONTENT_KEY,"xxx");

        Object rs = httpParser.pack(msgMap,"UTF-8");
        String actual = new String((byte[]) rs).replaceAll("\r|\n", "");

        String expected = new String("HTTP/1.1 200 \r" +
                "k1: v1\r" +
                "Content-Length: 3\r" +
                "\r" +
                "xxx\r").replaceAll("\r|\n", "");
        Assert.assertEquals(expected,actual);


    }


}
