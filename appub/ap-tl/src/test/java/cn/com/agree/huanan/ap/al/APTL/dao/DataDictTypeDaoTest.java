package cn.com.agree.huanan.ap.al.APTL.dao;

import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictType;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.orm.OrmUpdater;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author JUN
 */
public class DataDictTypeDaoTest {
    @InjectMocks
    DataDictTypeDao dao;
    @Mock
    private OrmOperator ormOper;
    @Mock
    protected OrmSelecter selecter;
    @Mock
    protected OrmUpdater updater;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        when(ormOper.getOrmSelecter(any())).thenReturn(selecter);
        when(selecter.where(any())).thenReturn(selecter);
        when(selecter.orderBy(any())).thenReturn(selecter);
//        when(selecter.fetchAll())

    }

    @Test
    public void testFindByAlId(){
        List<DataDictType> dataDictItemList = new ArrayList<>();
        DataDictType item = new DataDictType();
        dataDictItemList.add(item);
        when(selecter.fetchAll()).thenReturn(dataDictItemList);

        List<DataDictType> actual = dao.findByAlId("");
        Assert.assertEquals(dataDictItemList,actual);

    }
}
