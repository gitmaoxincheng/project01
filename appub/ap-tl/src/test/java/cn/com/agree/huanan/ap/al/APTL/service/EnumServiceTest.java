package cn.com.agree.huanan.ap.al.APTL.service;

import cn.com.agree.huanan.ap.al.APTL.dao.DataDictItemDao;
import cn.com.agree.huanan.ap.al.APTL.dao.DataDictTypeDao;
import cn.com.agree.huanan.ap.al.APTL.dao.EnumInfoDao;
import cn.com.agree.huanan.ap.al.APTL.dao.EnumItemDao;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictType;
import cn.com.agree.huanan.ap.al.APTL.po.EnumInfo;
import cn.com.agree.huanan.ap.al.APTL.po.EnumItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author JUN
 */
public class EnumServiceTest {

    @InjectMocks
    EnumService service;
    @Mock
    private EnumInfoDao infoDao;
    @Mock
    private EnumItemDao ItemDao;
    @Mock
    BiConsumer<EnumInfo, List<EnumItem>> consumer;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
//        when(dataDictTypeDao.findByAlId(alId))
    }

    @Test
    public void testProcDataDictType(){
        EnumInfo info = new EnumInfo();
        info.setAlId("xxx");
        info.setEnumDesc("xxx");
        info.setEnumName("xxx");
        List<EnumInfo> enumInfoAllList = new ArrayList<>();
        enumInfoAllList.add(info);
        when(infoDao.findByAlId(anyString())).thenReturn(enumInfoAllList);

        List<EnumItem> enumItemAllList = new ArrayList<>();
        when(ItemDao.findByAlId(anyString())).thenReturn(enumItemAllList);
        service.procEnumInfo("",consumer);
        verify(consumer).accept(any(),any());


    }
}
