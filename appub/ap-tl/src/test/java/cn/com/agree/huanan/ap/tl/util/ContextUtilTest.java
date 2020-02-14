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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class ContextUtilTest {

    @Mock
    Logger logger;

    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);

        when(Logger.getLogger(ContextUtil.class)).thenReturn(logger);
        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());

    }

    @Test
    public void testSetString(){
        ContextUtil.set("k1","v1");
        String actual = (String) ContextUtil.get("k1");
        Assert.assertEquals("v1",actual);
    }


    @Test
    public void testKeys(){
        ContextUtil.set("k1","v1");
        ContextUtil.set("k2","v2");
        ContextUtil.set("k3","v3");

        Set<String> keys = ContextUtil.keys();
        int i = 1;
        for(String item:keys){
            String key = "k"+i;
            Assert.assertEquals(key,item);
            i++;
        }
    }


    @Test
    public void testSetnx(){
        ContextUtil.set("k1","v1");
        String[] actual;
        String[] expected;
        actual = ContextUtil.setnx("k1","v1");
        expected = new String[]{"false", "该键已存在"};
        Assert.assertArrayEquals(expected,actual);
        actual = ContextUtil.setnx("k10","v10");
        expected = new String[]{"true", "键-值设置成功"};
        Assert.assertArrayEquals(expected,actual);
//        Assert.assertArrayEquals();

    }


    @Test
    public void testSetMap(){
        Map<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");

        ContextUtil.set(map);
        Set<String> keys = ContextUtil.keys();
        int i = 1;
        for(String item : keys){
            String key = "k"+i;
            String value = "v"+i;
            Assert.assertEquals(key,item);
            Assert.assertEquals(value,ContextUtil.get(item));
            i++;
        }



    }


    @Test
    public void testSetnxMap(){
        ContextUtil.set("k1","v1");
        ContextUtil.set("k2","v2");
        ContextUtil.set("k3","v3");

        Map<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");

        String[] actual ;
        String[] expected;
        actual = ContextUtil.setnx(map);
        expected = new String[]{"1", "待加入的键在原集合中已存在"};
        Assert.assertArrayEquals(expected,actual);

        Map<String,String> map1 = new HashMap<>();
        map1.put("k4","v4");
        map1.put("k5","v5");
        map1.put("k6","v6");

        actual = ContextUtil.setnx(map1);
        expected = new String[]{"0", "kv集合设置成功"};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void setAppend(){
        ContextUtil.set("k1","v1");
        ContextUtil.append("k1","v2");

        String actual = (String) ContextUtil.get("k1");
        Assert.assertEquals("v1v2",actual);
    }

    @Test
    public void testStrlen(){
        ContextUtil.set("k1","v1");
        int actual = ContextUtil.strlen("k1");
        Assert.assertEquals(2,actual);
    }

    @Test
    public void testDel(){
        ContextUtil.set("k1","v1");
        String[] actual = ContextUtil.del("k1");
        String[] expected = {"0", "删除指定键成功"};
        Assert.assertArrayEquals(expected,actual);


    }



}
