package cn.com.agree.huanan.ap.tl.message.std;

import cn.com.agree.huanan.ap.tl.message.base.BeanPath;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.mockito.Mockito.*;
/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        SpringUtil.class
})
public class MessageParserManagerTest {

    BeanPath cfg = new BeanPath();

    @Before
    public void setUp(){
        mockStatic(SpringUtil.class);
        HashMap<String,String> map = new HashMap<>();
        map.put("STRING","java.lang.String");
        cfg.setParser(map);
        when(SpringUtil.getBean(BeanPath.class)).thenReturn(cfg);
        when(SpringUtil.getBean(String.class)).thenReturn(null);
    }


    @Test
    public void testGetParser() throws ClassNotFoundException {
        MessageParser parser = MessageParserManager.getParser("String");
        Assert.assertNull(parser);
    }


}
