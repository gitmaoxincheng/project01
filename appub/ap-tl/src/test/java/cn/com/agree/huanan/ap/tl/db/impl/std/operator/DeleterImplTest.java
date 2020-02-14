package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.std.operator.Deleter;

@RunWith(PowerMockRunner.class)
public class DeleterImplTest {
    @InjectMocks
    private Deleter oper = new DeleterImpl();
    
    @Mock
    private DbConnection mockDbConn;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getSql_base() {
        // init
        // execute
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = oper
            .deleteFrom("test_areainfo")
            .where(w -> {
                w.eq("name", "china");
            })
            .getSql(sqlParams);
        // assert
        assertThat(sql, equalTo("delete from test_areainfo where name = ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china")));
    }
    
    @Test
    public void execute_return_0() {
        // set
        int mockRet = 0;
        when(mockDbConn.execute(anyString(), anyList())).thenReturn(mockRet);
        // test
        int count = oper
            .deleteFrom("test_areainfo")
            .where(w -> {
                w.eq("name", "china");
            })
            .execute();
        // assert
        assertThat(count, equalTo(mockRet));
        // verity
        verify(mockDbConn).execute("delete from test_areainfo where name = ?", 
                Arrays.asList("china"));
    }
    
    @Test
    public void execute_return_2() {
        // set
        int mockRet = 2;
        when(mockDbConn.execute(anyString(), anyList())).thenReturn(mockRet);
        // test
        int count = oper
            .deleteFrom("test_areainfo")
            .where(w -> {
                w.eq("name", "china");
            })
            .execute();
        // assert
        assertThat(count, equalTo(mockRet));
        // verity
        verify(mockDbConn).execute("delete from test_areainfo where name = ?", 
                Arrays.asList("china"));
    }
    
}
