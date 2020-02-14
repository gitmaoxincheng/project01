package cn.com.agree.huanan.ap.rl.agree.afa.javadict;

import cn.com.agree.afa.jcomponent.DBConnProvider;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class PlatSvcParserImplTest {

    @Mock
    private Logger logger;

    PlatSvcParserImpl parser;

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);

        when(Logger.getLogger(PlatSvcParserImpl.class)).thenReturn(logger);

        parser = new PlatSvcParserImpl();

    }

    @Test
    public void testDictConvertMap(){
        JavaDict dict = new JavaDict();
        dict.put("k1","v1");
        Map<String,Object> expected = new HashMap<>();
        expected.put("k1","v1");
        Map<String,Object> actual = parser.dictToMap(dict);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testMapConvertDict(){
        Map<String,Object> map = new HashMap<>();
        map.put("k1","v1");
        JavaDict expected = new JavaDict();
        expected.put("k1","v1");
        JavaDict actual = (JavaDict) parser.mapToDict(map);
        Assert.assertEquals(expected,actual);

    }




}
