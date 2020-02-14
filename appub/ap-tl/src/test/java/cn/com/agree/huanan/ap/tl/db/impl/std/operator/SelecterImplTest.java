package cn.com.agree.huanan.ap.tl.db.impl.std.operator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import cn.com.agree.huanan.ap.tl.config.ApTlBaseConfig;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.base.DbType;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;


@RunWith(PowerMockRunner.class)
public class SelecterImplTest {
    @InjectMocks
    private Selecter oper = new SelecterImpl();
    
    @Mock
    private DbConnection mockDbConn;
    
    @Mock
    private ApTlBaseConfig mockApTlBaseConfig;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getSql_normal() {
        // init
        // execute
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = oper
            .select("name", "province")
            .from("test_areainfo")
            .where(w -> {
                w.eq("name", "china");
            })
            .orderBy("name", "province")
            .getSql(sqlParams);
        // assert
        assertThat(sql, equalTo("select name, province from test_areainfo where name = ? order by name, province"));
        assertThat(sqlParams, equalTo(Arrays.asList("china")));
    }
    
    @Test
    public void fetch_empty() {
        // set
        when(mockDbConn.query(anyString(), anyList(), anyInt())).thenReturn(Collections.emptyList());
        // test
        List<Map<String, Object>> rowSet = oper
            .select("name", "province")
            .from("test_areainfo")
            .where(w -> {
                w.eq("name", "china");
            })
            .orderBy("name", "province")
            .fetch(0);
        // assert
        assertThat(rowSet, sameInstance(Collections.emptyList()));
        // verify
        verify(mockDbConn).query("select name, province from test_areainfo where name = ? order by name, province", Arrays.asList("china"), 0);
    }
    
    @Test
    public void fetch_2() {
        // set
        List<Map<String, Object>> mockMap = new ArrayList<Map<String, Object>>();
        mockMap.add(asMap("name", "china", "province", "guangdong"));
        mockMap.add(asMap("name", "china", "province", "hunan"));
        List<List<Object>> mockList = mapToList(mockMap);
        when(mockDbConn.query(anyString(), anyList(), anyInt())).thenReturn(mockList);
        // test
        List<Map<String, Object>> rowSet = oper
            .select("name", "province")
            .from("test_areainfo")
            .where(w -> {
                w.eq("name", "china");
            })
            .orderBy("name", "province")
            .fetch(2);
        // assert
        assertThat(rowSet, equalTo(mockMap));
        // verify
        verify(mockDbConn).query("select name, province from test_areainfo where name = ? order by name, province", Arrays.asList("china"), 2);
    }
    
    @Test
    public void inner_join_1() {
        // set
        List<Map<String, Object>> mockMap = new ArrayList<Map<String, Object>>();
        mockMap.add(asMap("name", "china", "province", "guangdong"));
        mockMap.add(asMap("name", "china", "province", "hunan"));
        List<List<Object>> mockList = mapToList(mockMap);
        when(mockDbConn.query(anyString(), anyList(), anyInt())).thenReturn(mockList);
        // test
        List<Map<String, Object>> rowSet = oper
            .select("name", "province")
            .from("test_areainfo area", "test_cityinfo city")
            .where(w -> {
                w.eq("name", "china");
                w.eq("area.cityId", SqlUtil.getSqlExp("city.cityId"));
            })
            .orderBy("name", "province")
            .fetch(2);
        // assert
        assertThat(rowSet, equalTo(mockMap));
        // verify
        verify(mockDbConn).query("select name, province from test_areainfo area, test_cityinfo city where name = ? and area.cityId = city.cityId order by name, province", Arrays.asList("china"), 2);
    }
    
    @Test
    public void count_1() {
        // set
        List<Map<String, Object>> mockMap = new ArrayList<Map<String, Object>>();
        mockMap.add(asMap("ap_cnt", new BigDecimal(100)));
        List<List<Object>> mockList = mapToList(mockMap);
        when(mockDbConn.query(anyString(), anyList(), anyInt())).thenReturn(mockList);
        // test
        long cnt = oper
                .from("test_areainfo")
                .where(w -> {
                    w.eq("name", "china");
                })
                .count();
        // assert
        assertThat(cnt, equalTo(100L));
        // verify
        verify(mockDbConn).query("select count(*) ap_cnt from test_areainfo where name = ?", Arrays.asList("china"), 1);
    }
    
    @Test
    public void countAndFetch() {
        // sql
        String countSql = "select count(*) ap_cnt from test_areainfo where name = ?";
        String selectSql = "select name, province from test_areainfo where name = ?";
        // set
        List<Map<String, Object>> mockMapList1 = new ArrayList<Map<String, Object>>();
        mockMapList1.add(asMap("ap_cnt", new BigDecimal(100)));
        List<Map<String, Object>> mockMapList2 = new ArrayList<Map<String, Object>>();
        mockMapList2.add(asMap("name", "china", "province", "guangdong"));
        when(mockDbConn.query(eq(countSql), anyList(), anyInt())).thenReturn(mapToList(mockMapList1));
        when(mockDbConn.query(eq(selectSql), anyList(), anyInt())).thenReturn(mapToList(mockMapList2));
        // test
        long cnt = oper
                .select("name", "province")
                .from("test_areainfo")
                .where(w -> {
                    w.eq("name", "china");
                })
                .count();
        Map<String, Object> ret = oper.fetchOne();
        // assert
        assertThat(cnt, equalTo(100L));
        assertThat(ret, equalTo(mockMapList2.get(0)));
        // verify
        verify(mockDbConn).query(countSql, Arrays.asList("china"), 1);
        verify(mockDbConn).query(selectSql, Arrays.asList("china"), 1);
    }
    
    @Test
    public void fetchWithOracle() {
        // set
        when(mockApTlBaseConfig.getDbType()).thenReturn(DbType.ORACLE);
        // test
        oper
                .select("name", "province")
                .from("test_areainfo")
                .where(w -> {
                    w.eq("name", "china");
                })
                .fetch(0, 10);
        oper.fetch(10, 10);
        // assert
        // verify
        String pageSql = "select * from (select ap_tab.*, rownum ap_rn from (\n    select name, province from test_areainfo where name = ?\n) ap_tab) where ap_rn > ? and rownum <= ?";
        verify(mockDbConn).query(pageSql, Arrays.asList("china", 0, 10), 10);
        verify(mockDbConn).query(pageSql, Arrays.asList("china", 10, 10), 10);
    }
    
    private Map<String, Object> asMap(Object... kvPairs) {
        Map<String, Object> data = new LinkedHashMap<>();
        for (int i = 0; i <= kvPairs.length / 2; i += 2) {
            data.put((String)kvPairs[i], kvPairs[i+1]);
        }
        return data;
    }
    
    private List<List<Object>> mapToList(List<Map<String, Object>> dataMapList) {
        return dataMapList.stream().map(dataMap -> {
            return dataMap.values().stream().collect(Collectors.toList());
        }).collect(Collectors.toList());
    }
}
