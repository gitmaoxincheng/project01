package cn.com.agree.huanan.ap.tl.communicate.comm.msg;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.UnsupportedEncodingException;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class MessageTest {
    Message message;
    Message message1;
    @Mock
    private Logger logger;

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);
        when(Logger.getLogger(Message.class)).thenReturn(logger);
        message = new Message(0, "UTF-8", "xxx");
        message1 = new Message(0,"gbk","xxx");
    }

    @Test
    public void testGetMsgType(){
        int actual = message.getMsgType();
        Assert.assertEquals(0,actual);
    }



    @Test
    public void testGetMsgContentType(){
        int actual = message.getMsgContentType();
        Assert.assertEquals(Const.MESSAGE_CONTENT_STRING_TYPE, actual);

    }


    @Test
    public void testGetEncoding(){
        String actual = message.getEncoding();
        Assert.assertEquals("UTF-8", actual);

    }

    @Test
    public void testGetStringMsg(){
        String actual = message.getStringMsg();
        Assert.assertEquals("xxx", actual);
        actual = message1.getStringMsg();
        Assert.assertEquals("xxx",actual);

    }

    @Test
    public void testGetBytesMsg() throws UnsupportedEncodingException {
        byte[] actual = message.getBytesMsg();
        Assert.assertArrayEquals("xxx".getBytes("UTF-8"), actual);
        actual = message1.getBytesMsg();
        Assert.assertArrayEquals("xxx".getBytes("gbk"),actual);

    }





}
