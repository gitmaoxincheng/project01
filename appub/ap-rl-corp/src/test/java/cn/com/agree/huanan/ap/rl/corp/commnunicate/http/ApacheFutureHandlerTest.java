package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;
import org.apache.http.impl.client.HttpRequestFutureTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 * @author JUN
 */

public class ApacheFutureHandlerTest {
    @Mock
    HttpRequestFutureTask<CommContext> task;

    ApacheFutureHandler handler;
    CommContext commContext;

    @Before
    public  void  setUp() throws Exception{
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
        //初始化被测对象
        handler = new ApacheFutureHandler(task);

        //初始化返回结果
//        commContext = new CommContext(0,new BaseException(new Exception()),"msg001");


    }


    @Test
    public void testGet() throws Exception{
        when(task.get()).thenReturn(null);
        handler.get();
        verify(task).get();

    }

    @Test
    public void testGet1() throws Exception{
        when(task.get(anyInt(),any())).thenReturn(null);
        handler.get(1,null);
        verify(task).get(1,null);
    }


    @Test
    public void testCancel() {
        when(task.cancel(true)).thenReturn(true);
        when(task.cancel(false)).thenReturn(false);

        boolean actual = handler.cancel(true);
        Assert.assertEquals(true,actual);
        actual = handler.cancel(false);
        Assert.assertEquals(false,actual);


    }


}
