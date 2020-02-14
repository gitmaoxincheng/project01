package cn.com.agree.huanan.ap.tl.util;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
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

import static org.mockito.Mockito.*;

/**
 * @author xiaot
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        SpringUtil.class,
        JsonUtil.class
})
public class CallbackUtilTest {
    @Mock
    private Selecter selecter;
    @Mock
    private Inserter inserter;
    @Mock
    private JsonUtil jsonUtil;
    
    @Before
    public void setUp(){
        // 初始化
        mockStatic(SpringUtil.class);
        mockStatic(JsonUtil.class);
        MockitoAnnotations.initMocks(this);
        //条件返回
        when(SpringUtil.getBean(Selecter.class)).thenReturn(selecter);
        when(JsonUtil.getUtil()).thenReturn(jsonUtil);
        when(selecter.select(anyString())).thenReturn(selecter);
        when(selecter.select(anyString(),anyString(),anyString())).thenReturn(selecter);
        when(selecter.from(anyString())).thenReturn(selecter);
        when(selecter.where(any())).thenReturn(selecter);
//        when(selecter.fetchOne())
    }

    @Test
    public void testCountCallbackInfo(){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(new HashMap<String,Object>());
        list.add(new HashMap<String,Object>());
        list.add(new HashMap<String,Object>());
        when(selecter.fetchAll()).thenReturn(list);

        int actual = CallbackUtil.countCallbackInfo("","","");
        Assert.assertEquals(3,actual);

    }

    @Test
    public void testGetCallbackInfo(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        Map<String,Object> map2 = new HashMap<String,Object>();
        Map<String,Object> map3 = new HashMap<String,Object>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        when(selecter.fetchAll()).thenReturn(list);

        List<Map<String,Object>> actual = CallbackUtil.getCallbackInfo("","","");
        Assert.assertEquals(list,actual);

    }



    @Test
    public void testInsertCallbackInfo(){
        when(SpringUtil.getBean(Inserter.class)).thenReturn(inserter);
        when(inserter.insertInto(anyString())).thenReturn(inserter);
        when(inserter.values(anyMap())).thenReturn(inserter);
        when(inserter.execute()).thenReturn(1);
        Map<String,Object> map = new HashMap<>();
        map.put("k1","v1");
        boolean actual = CallbackUtil.insertCallbackInfo("","","","","","",map);
        Assert.assertEquals(true,actual);
        when(inserter.execute()).thenReturn(0);
        actual = CallbackUtil.insertCallbackInfo("","","","","","",map);
        Assert.assertEquals(false,actual);
    }


}
