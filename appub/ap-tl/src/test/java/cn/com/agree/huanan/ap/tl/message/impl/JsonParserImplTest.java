package cn.com.agree.huanan.ap.tl.message.impl;

import cn.com.agree.huanan.ap.tl.message.std.JsonParser;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
public class JsonParserImplTest {
    @InjectMocks
    private MyJsonParserImp jsonParser;
    @Mock
    private JsonParser parser;


    static class MyJsonParserImp extends JsonParserImpl{

        @Override
        public Map<String, Object> jsonToMap(String jsonString) {

            return null;
        }

        @Override
        public String mapToJson(Map<String, Object> map) {
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
        Map<String,Object> actual = jsonParser.unpack(jsonObject.toString().getBytes(),"UTF-8");
        Map<String,Object> expected = new HashMap<>();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testPack(){
        Object actual = jsonParser.pack(new HashMap<String, Object>(), "UTF-8");
        Assert.assertNull(actual);
    }

}
