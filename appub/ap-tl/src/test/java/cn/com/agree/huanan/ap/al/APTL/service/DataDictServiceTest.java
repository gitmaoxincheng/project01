package cn.com.agree.huanan.ap.al.APTL.service;

import cn.com.agree.huanan.ap.al.APTL.dao.DataDictItemDao;
import cn.com.agree.huanan.ap.al.APTL.dao.DataDictTypeDao;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
public class DataDictServiceTest {
    @InjectMocks
    DataDictService service;
    @Mock
    private DataDictTypeDao dataDictTypeDao;
    @Mock
    private DataDictItemDao dataDictItemDao;
    @Mock
    BiConsumer<DataDictType, List<DataDictItem>> consumer;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
//        when(dataDictTypeDao.findByAlId(alId))
    }

    @Test
    public void testProcDataDictType(){
        DataDictType type = new DataDictType();
        type.setAlId("xxx");
        type.setTypeCnName("xxx");
        type.setTypeName("xxx");
        List<DataDictType> ddtList = new ArrayList<>();
        ddtList.add(type);
        when(dataDictTypeDao.findByAlId(anyString())).thenReturn(ddtList);

        List<DataDictItem> ddiList = new ArrayList<>();
        when(dataDictItemDao.findByAlId(anyString())).thenReturn(ddiList);
        service.procDataDictType("",consumer);
        verify(consumer).accept(any(),any());


    }


}
