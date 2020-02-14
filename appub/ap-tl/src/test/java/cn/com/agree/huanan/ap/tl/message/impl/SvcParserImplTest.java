package cn.com.agree.huanan.ap.tl.message.impl;

import cn.com.agree.huanan.ap.tl.message.std.JsonParser;
import cn.com.agree.huanan.ap.tl.message.std.SvcParser;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUN
 */
public class SvcParserImplTest {
    @InjectMocks
    private MySvcParserImpl svcParser;
    @Mock
    private SvcParser parser;


    static class MySvcParserImpl extends SvcParserImpl{

        @Override
        public Map<String, Object> dictToMap(Object svcMsg) {
            return null;
        }

        @Override
        public Object mapToDict(Map<String, Object> svcMap) {
            return null;
        }
    }


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void testUnpack(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("k1","v1");
        Map<String,Object> actual = svcParser.unpack(jsonObject.toString().getBytes(),"UTF-8");
        Map<String,Object> expected = new HashMap<>();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testPack(){
        Object actual = svcParser.pack(new HashMap<String, Object>(), "UTF-8");
        Assert.assertNull(actual);
    }

}
