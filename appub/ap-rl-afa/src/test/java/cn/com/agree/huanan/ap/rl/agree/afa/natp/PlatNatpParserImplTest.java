package cn.com.agree.huanan.ap.rl.agree.afa.natp;

import cn.com.agree.afa.jcomponent.NatpCodec;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
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

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class,
        NatpCodec.class
})
public class PlatNatpParserImplTest {
    @Mock
    private Logger logger;

    PlatNatpParserImpl parser;
    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        mockStatic(NatpCodec.class);
        MockitoAnnotations.initMocks(this);

        when(Logger.getLogger(PlatNatpParserImpl.class)).thenReturn(logger);
        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());

        parser = new PlatNatpParserImpl();
    }


    @Test
    public void testNatpToMap() {
        TCResult result = new TCResult(1);
        when(NatpCodec.decode(any(JavaDict.class), anyString())).thenReturn(result);
        Map<String, Object> actual = parser.natpToMap("message".getBytes());
        System.out.println(actual);

        result.setStatus(0);
        thrown.expect(PlatNatpException.class);
        parser.natpToMap("message".getBytes());

    }

    @Test
    public void testMapToNatp(){
        TCResult result = new TCResult(1);
        when(NatpCodec.encode(any(JavaDict.class), anyString())).thenReturn(result);
        Map<String,Object> map = new HashMap<>();
        map.put("__SNDPCK__","msg".getBytes());
        byte[] actual = parser.mapToNatp(map,"");
        Assert.assertEquals("msg",new String(actual));
        result.setStatus(0);
        thrown.expect(PlatNatpException.class);
        parser.mapToNatp(map,"");


    }
}
