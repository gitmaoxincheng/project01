package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import org.apache.http.conn.HttpClientConnectionManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
public class ApacheIdleConnectionMonitorThreadTest {
    @InjectMocks
    ApacheIdleConnectionMonitorThread monitorThread;
    @Mock
    HttpClientConnectionManager manager;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testRun(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                monitorThread.run();
            }
        });
        thread.start();
        monitorThread.shutdown();
//        verify(monitorThread).run();
//        verify(monitorThread).shutdown();
    }

}
