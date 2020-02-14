package cn.com.agree.huanan.ap.tl.util;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class JudgmentTest {
    @Mock
    Logger logger;

    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);

        when(Logger.getLogger(Judgment.class)).thenReturn(logger);
        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());

    }

    @Test
    public void testBoolFrame(){
        boolean actual = false;
        actual = Judgment.boolFrame(new Boolean(true));
        Assert.assertEquals(true,actual);
        actual = Judgment.boolFrame(new Boolean(false));
        Assert.assertEquals(false,actual);


        actual = Judgment.boolFrame(new Integer(1));
        Assert.assertEquals(true,actual);
        actual = Judgment.boolFrame(new Integer(0));
        Assert.assertEquals(false,actual);


        thrown.expect(NullPointerException.class);
        Judgment.boolFrame(null);


    }



}
