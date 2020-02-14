//package cn.com.agree.huanan.ap.tl.communicate.comm.adapter.context;
//
//import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.impl.HttpAdapterImpl;
//import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
//import cn.com.agree.huanan.ap.tl.communicate.comm.params.HttpCommParam;
//import cn.com.agree.huanan.ap.tl.logging.Logger;
//import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import static org.mockito.Mockito.*;
//import static org.powermock.api.mockito.PowerMockito.mockStatic;
//
///**
// * @author JUN
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({
//        SpringUtil.class,
//        Logger.class
//})
//public class AdapterContextTest {
//    AdapterContext context;
//    @Mock
//    private HttpCommParam commParam;
//    @Mock
//    private HttpAdapterImpl adapter;
//    @Mock
//    private Logger logger;
//
//
//    @Before
//    public void setUp() {
//        mockStatic(SpringUtil.class);
//        mockStatic(Logger.class);
//        when(SpringUtil.getBean(Logger.class,any())).thenReturn(logger);
////        when(Logger.getLogger(HttpAdapterImpl.class)).thenReturn(logger);
////        when(Logger.getLogger(HttpCommParam.class)).thenReturn(logger);
////        when(Logger.getLogger(CommParam.class)).thenReturn(logger);
//        MockitoAnnotations.initMocks(this);
//
//
//        context = new AdapterContext(adapter,commParam);
//
//        doNothing().when(adapter.comm(commParam, anyString()));
//        doNothing().when(adapter.comm(commParam, (byte[]) any()));
//
//        doNothing().when(logger).info(anyString());
//        doNothing().when(logger).debug(anyString());
//        doNothing().when(logger).error(anyString());
//
//
//
//    }
//
//    @Test
//    public void testComm() {
//        context.comm("".getBytes());
//        verify(adapter).comm(any(), (byte[]) any());
//        context.comm("");
//        verify(adapter).comm(any(), anyString());
//    }
//
//
//}
