package cn.com.agree.huanan.ap.tl.metadata;

import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.al.APTL.service.DataDictService;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.StrUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        StrUtil.class
})
public class MetaDataDataDictGeneratorTest {
    @InjectMocks
    private MetaDataDataDictGenerator generator;
    @Mock
    private Logger logger;
    @Mock
    private DataDictService dataDictService;


    @Before
    public void setUp() {
        mockStatic(StrUtil.class);
        MockitoAnnotations.initMocks(this);
        when(StrUtil.firstCharToUpperCase(anyString())).thenReturn("xxx");
        doNothing().when(dataDictService).procDataDictType(anyString(), any());
    }

    @Test
    public void testProcDataDict() {
        generator.procDataDict("", null);
        verify(dataDictService).procDataDictType(anyString(), any());
    }

//    @Test
    public void testGetDataDictItemJavaCode() {
        DataDictItem dictItem = new DataDictItem();
        dictItem.setAlId("xxx");
        dictItem.setDataEnum("xxx");
        dictItem.setDataType("xxx");
        dictItem.setExtItem("xxx");
        dictItem.setItemCnName("xxx");
        dictItem.setItemName("xxx");
        dictItem.setMaxLen(1);
        dictItem.setMinLen(1);
        dictItem.setTypeName("xxx");

//        String actual =


    }


}
