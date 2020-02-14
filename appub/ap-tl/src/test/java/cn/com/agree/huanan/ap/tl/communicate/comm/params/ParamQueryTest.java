package cn.com.agree.huanan.ap.tl.communicate.comm.params;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author JUN
 */
public class ParamQueryTest {
    @InjectMocks
    ParamQuery query;
    @Mock
    DbOperator dbOper;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetQueryOper(){
        DbOperator actual = query.getQueryOper();
        Assert.assertEquals(dbOper,actual);
    }
}
