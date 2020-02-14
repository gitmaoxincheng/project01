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
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;

@RunWith(PowerMockRunner.class)
public class InserterImplTest {
    @InjectMocks
    private Inserter oper = new InserterImpl();
    
    @Mock
    private DbConnection mockDbConn;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getSql_values_kvParams() {
        // init
        // execute
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = oper
            .insertInto("test_areainfo")
            .values("name", "china")
            .values("province", "guangdong")
            .getSql(sqlParams);
        // assert
        assertThat(sql, equalTo("insert into test_areainfo (name, province) values (?, ?)"));
        assertThat(sqlParams, equalTo(Arrays.asList("china", "guangdong")));
    }
    
    @Test
    public void getSql_values_kvMap() {
        // init
        Map<String, Object> kvInfo = new LinkedHashMap<String, Object>();
        kvInfo.put("name", "china");
        kvInfo.put("province", "guangdong");
        // execute
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = oper
            .insertInto("test_areainfo")
            .values(kvInfo)
            .getSql(sqlParams);
        // assert
        assertThat(sql, equalTo("insert into test_areainfo (name, province) values (?, ?)"));
        assertThat(sqlParams, equalTo(Arrays.asList("china", "guangdong")));
    }
    
    @Test
    public void execute_return_0() {
        // set
        int mockRet = 0;
        when(mockDbConn.execute(anyString(), anyList())).thenReturn(mockRet);
        // test
        int count = oper
            .insertInto("test_areainfo")
            .values("name", "china")
            .values("province", "guangdong")
            .execute();
        // assert
        assertThat(count, equalTo(mockRet));
        // verity
        verify(mockDbConn).execute("insert into test_areainfo (name, province) values (?, ?)", 
                Arrays.asList("china", "guangdong"));
    }
    
    @Test
    public void execute_return_2() {
        // set
        int mockRet = 2;
        when(mockDbConn.execute(anyString(), anyList())).thenReturn(mockRet);
        // test
        int count = oper
            .insertInto("test_areainfo")
            .values("name", "china")
            .values("province", "guangdong")
            .execute();
        // assert
        assertThat(count, equalTo(mockRet));
        // verity
        verify(mockDbConn).execute("insert into test_areainfo (name, province) values (?, ?)", 
                Arrays.asList("china", "guangdong"));
    }
}
