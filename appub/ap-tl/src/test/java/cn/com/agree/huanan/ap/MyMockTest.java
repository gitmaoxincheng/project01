package cn.com.agree.huanan.ap;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * @author JUN
 */
public class MyMockTest {
    @Mock
    protected DbOperator dbOper;
    @Mock
    protected Inserter inserter;
    @Mock
    protected Selecter selecter;
    @Mock
    protected Updater updater;
    @Mock
    protected Logger logger;

    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Before
    public  void  setUp() throws Exception {
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
        init();

    }


    public void init(){
        //初始化挡板
        when(dbOper.getInserter()).thenReturn(inserter);
        when(inserter.insertInto(anyString())).thenReturn(inserter);
        when(inserter.values(anyMap())).thenReturn(inserter);
        //子类继承需要设置返回结果
//        when(inserter.execute()).thenReturn(1);

        when(dbOper.getSelecter()).thenReturn(selecter);
        //1
        when(selecter.select(anyString())).thenReturn(selecter);
        //3
        when(selecter.select(anyString(),anyString(),anyString())).thenReturn(selecter);
        //8
        when(selecter.select(anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(selecter);
        //9
        when(selecter.select(anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(selecter);
        //14
        when(selecter.select(anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(selecter);
        when(selecter.from(anyString())).thenReturn(selecter);
        when(selecter.where(any())).thenReturn(selecter);
        //子类继承需要设置返回map对象
//        when(selecter.fetchOne()).thenReturn(map);

        when(dbOper.getUpdater()).thenReturn(updater);
        when(updater.update(anyString())).thenReturn(updater);
        when(updater.set(anyString(),anyString())).thenReturn(updater);
        when(updater.where(any())).thenReturn(updater);
        //子类继承需要设设置返回结果
//        when(updater.execute()).thenReturn(1);

        doNothing().when(dbOper).commit();
        doNothing().when(dbOper).rollback();
        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());
    }

}
