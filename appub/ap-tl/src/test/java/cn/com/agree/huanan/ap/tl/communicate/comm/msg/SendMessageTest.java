package cn.com.agree.huanan.ap.tl.communicate.comm.msg;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class SendMessageTest {
    private Logger logger;

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);
        when(Logger.getLogger(Message.class)).thenReturn(logger);

    }

    @Test
    public void testConstruct(){
        SendMessage message1 = new SendMessage("xxx");
        SendMessage message2 = new SendMessage("xxx".getBytes());
        SendMessage message3 = new SendMessage("xxx","UTF-8");
        SendMessage message4 = new SendMessage("xxx".getBytes(),"UTF-8");

    }


}
