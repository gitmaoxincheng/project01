package cn.com.agree.huanan.ap.tl.util;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import cn.com.agree.huanan.ap.tl.config.ApTlBaseConfig;
import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.base.DbType;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfEnumException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    SpringUtil.class
})
public class SernoUtilTest {
    @Mock
    private ApTlBaseConfig mockApTlBaseConfig;
    @Mock
    private DbConnection mockDbConn;
    
    @Before
    public void setUp() throws Exception {
        // 初始化
        mockStatic(SpringUtil.class);
        MockitoAnnotations.initMocks(this);
        // 条件返回
        when(SpringUtil.getBean(ApTlBaseConfig.class)).thenReturn(mockApTlBaseConfig);
        when(mockApTlBaseConfig.getDbType()).thenReturn(DbType.ORACLE);
        when(SpringUtil.getBean(DbConnection.class)).thenReturn(mockDbConn);
    }
    
    @Test
    public void getSerno_dbType_oracle() {
        // set
        when(mockApTlBaseConfig.getDbType()).thenReturn(DbType.ORACLE);
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn((Long)1L));
        // test
        String serno = SernoUtil.getSerno("test_seq", 5);
        // verify
        assertThat(serno, equalTo("00001"));
        verify(mockDbConn).query("select test_seq.nextval from dual");
    }
    
    @Test
    public void getSerno_dbType_db2() {
        // set
        when(mockApTlBaseConfig.getDbType()).thenReturn(DbType.DB2);
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn((Long)1L));
        // test
        String serno = SernoUtil.getSerno("test_seq", 5);
        // verify
        assertThat(serno, equalTo("00001"));
        verify(mockDbConn).query("select nextval for test_seq from sysibm.sysdummy1");
    }
    
    @Test(expected=ApValueOutOfEnumException.class)
    public void getSerno_dbType_null() {
        // set
        when(mockApTlBaseConfig.getDbType()).thenReturn(null);
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn((Long)1L));
        // test
        String serno = SernoUtil.getSerno("test_seq", 5);
        // verify
    }
    
    @Test
    public void getSerno_returnLong() {
        // set
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn((Long)1L));
        // test
        String serno = SernoUtil.getSerno("test_seq", 5);
        // verify
        assertThat(serno, equalTo("00001"));
    }
    
    @Test
    public void getSerno_returnInteger() {
        // set
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn((Integer)1));
        // test
        String serno = SernoUtil.getSerno("test_seq", 5);
        // verify
        assertThat(serno, equalTo("00001"));
    }
    
    @Test(expected=ApValueTypeUnsupportException.class)
    public void getSerno_returnString() {
        // set
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn("1"));
        // test
        String serno = SernoUtil.getSerno("test_seq", 5);
        // verify
    }
    
    @Test
    public void getSerno_tooLong_truncate() {
        // set
        when(mockDbConn.query(anyString())).thenReturn(getDbReturn((Long)123456L));
        // test
        String serno = SernoUtil.getSerno("test_seq", 6);
        // verify
        assertThat(serno, equalTo("123456"));
    }
    
    private List<List<Object>> getDbReturn(Object obj) {
        List<List<Object>> dbRetList = new ArrayList<List<Object>>();
        dbRetList.add(Arrays.asList(obj));
        return dbRetList;
    }
}
