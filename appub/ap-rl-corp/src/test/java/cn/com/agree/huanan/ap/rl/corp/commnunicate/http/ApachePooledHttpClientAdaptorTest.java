package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * @author JUN
 */
public class ApachePooledHttpClientAdaptorTest {

    ApachePooledHttpClientAdaptor adaptor;

    @Before
    public void setUp(){
        adaptor = ApachePooledHttpClientAdaptor.getPooledHttpClientAdaptor();

    }

    @Test
    public void testGetHttpClient(){
        CloseableHttpClient client;
        client = adaptor.getHttpClient();
        client = adaptor.getHttpClient(2000);
        client = adaptor.getHttpClient(2000,3000);
        client = adaptor.getHttpClient(2000,2000,2000);
        adaptor.shutdown();
    }

}
