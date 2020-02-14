package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import cn.com.agree.huanan.ap.rl.corp.MyMockTest;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import org.apache.http.impl.client.HttpRequestFutureTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author JUN
 */
public class ApacheFutherHandlerTest extends MyMockTest{
    @Mock
    HttpRequestFutureTask<CommContext> futherTask;

    private ApacheFutherHandler handler;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        handler = new ApacheFutherHandler(futherTask);
    }

    @Test
    public void testApacheFutherHandler(){
        Assert.assertEquals(futherTask,handler.futherTask);
    }
}
