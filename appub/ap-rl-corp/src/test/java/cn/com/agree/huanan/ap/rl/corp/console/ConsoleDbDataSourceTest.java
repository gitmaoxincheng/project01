package cn.com.agree.huanan.ap.rl.corp.console;

import cn.com.agree.huanan.ap.tl.util.ReflectionUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        ReflectionUtil.class
})
public class ConsoleDbDataSourceTest {
    @InjectMocks
    ConsoleDbDataSource dataSource;

    @Mock
    private Environment env;
    @Mock
    private Connection dbConn;


    @Before
    public void setUp(){
        mockStatic(ReflectionUtil.class);
        MockitoAnnotations.initMocks(this);
//        when(dataSource)
        when(env.getProperty(anyString())).thenReturn("xxx");
    }

    @Test
    public void testGetConnection(){
        when(ReflectionUtil.getProxy(any(),any())).thenReturn(dbConn);
        Connection actual = dataSource.getConnection("");
        Assert.assertEquals(dbConn,actual);
    }


}
