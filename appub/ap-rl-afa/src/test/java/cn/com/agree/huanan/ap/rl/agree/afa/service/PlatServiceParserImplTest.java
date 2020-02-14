package cn.com.agree.huanan.ap.rl.agree.afa.service;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class PlatServiceParserImplTest {

    @Mock
    private Logger logger;

    PlatServiceParserImpl parser;

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);

        when(Logger.getLogger(PlatServiceParserImpl.class)).thenReturn(logger);
        parser = new PlatServiceParserImpl();

    }

    @Test
    public void testInnerUnpack(){
        Object actual ;
        Map<String,Object> map = new HashMap<>();
        map.put("k1","v1");
        List<Object> list = new ArrayList<>();
        list.add(map);
        ArrayList<String> sublist = new ArrayList<>();
        sublist.add("xxx");
        list.add(sublist);
        list.add("sss");

        actual = parser.unpack(list,"");
//        List<Object> expected = new ArrayList<>();
//        expected.add()
//        System.out.println(actual.toString());
        Assert.assertEquals("{__NonMapParams__=[[xxx], sss], k1=v1}",actual.toString());
    }


    @Test
    public void testPack(){
        Map<String,Object> map = new HashMap<>();
        map.put("k1","v1");

        Object actual = parser.pack(map,"");
        Assert.assertEquals(map.toString(),actual.toString());
    }

}
