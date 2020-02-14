package cn.com.agree.huanan.ap.tl.message.impl;

import cn.com.agree.huanan.ap.tl.message.std.NatpParser;
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
public class NatpParserImplTest {
    @InjectMocks
    private MyNatpParserImpl natpParser;
    @Mock
    private NatpParser parser;

    static class MyNatpParserImpl extends NatpParserImpl{

        @Override
        public Map<String, Object> natpToMap(byte[] natpMsg) {
            return null;
        }

        @Override
        public Map<String, Object> natpToMap(byte[] natpMsg, String encoding) {
            return null;
        }

        @Override
        public byte[] mapToNatp(Map<String, Object> natpMap) {
            return new byte[0];
        }

        @Override
        public byte[] mapToNatp(Map<String, Object> natpMap, String encoding) {
            return new byte[0];
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
        Map<String, Object> expected = new HashMap<>();
        Map<String, Object> actual = natpParser.unpack(jsonObject.toString().getBytes(),"UTF-8");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testPack(){
        Object actual = natpParser.pack(new HashMap<String, Object>(), "UTF-8");
        Assert.assertNull(actual);
    }

}
