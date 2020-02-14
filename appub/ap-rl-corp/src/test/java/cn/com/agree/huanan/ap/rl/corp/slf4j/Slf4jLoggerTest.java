package cn.com.agree.huanan.ap.rl.corp.slf4j;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
        LoggerFactory.class
})
public class Slf4jLoggerTest {
    @InjectMocks
    Slf4jLogger slf4jLogger;

    @Mock
    private Logger logger;

    @Before
    public void setUp(){
        mockStatic(LoggerFactory.class);
        MockitoAnnotations.initMocks(this);
        when(LoggerFactory.getLogger((Class<?>) any())).thenReturn(logger);
    }

    @Test
    public void initLogger() {
        slf4jLogger.initLogger();
//        verify(slf4jLogger).initLogger();
    }
}
