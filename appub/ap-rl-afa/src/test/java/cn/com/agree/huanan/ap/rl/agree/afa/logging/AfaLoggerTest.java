package cn.com.agree.huanan.ap.rl.agree.afa.logging;


import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
/**
 * @author JUN
 */
public class AfaLoggerTest {

    @Mock
    AfaLogger afaLogger;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitLogger(){
        afaLogger.initLogger();
        verify(afaLogger).initLogger();
    }



}
