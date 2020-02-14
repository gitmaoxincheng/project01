package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import cn.com.agree.huanan.ap.rl.corp.MyMockTest;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherCallbackHandler;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
public class ApacheFutureCallbackTest extends MyMockTest{
    @Mock
    FurtherCallbackHandler<CommContext> callback;


    private ApacheFutureCallback apacheFutureCallback;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        //初始化被测对象
        apacheFutureCallback = new ApacheFutureCallback(callback);

    }

    @Test
    public void testCompleted(){
        doNothing().when(callback).completed(any());
        apacheFutureCallback.completed(null);
        verify(callback).completed(any());
    }

    @Test
    public void testFailed(){
        doNothing().when(callback).failed(any());
        apacheFutureCallback.failed(null);
        verify(callback).failed(any());
    }


    @Test
    public void testCancelled(){
        doNothing().when(callback).cancelled();
        apacheFutureCallback.cancelled();
        verify(callback).cancelled();
    }



}
