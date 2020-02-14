package cn.com.agree.huanan.ap.rl.agree.afa.logging;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.InjectionPoint;

import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
public class AfaLoggerFactoryTest {
    @Mock
    AfaLoggerFactory factory;
    Logger logger;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        logger = new AfaLogger(AfaLoggerFactoryTest.class);
    }

    @Test
    public void testGetLogger(){
        when(factory.getLogger(any(InjectionPoint.class))).thenReturn(logger);
        Logger actual = factory.getLogger((InjectionPoint) null);
        Assert.assertNull(actual);

        actual = factory.getLogger(AfaLoggerFactoryTest.class);
        Assert.assertNull(actual);
    }


}
