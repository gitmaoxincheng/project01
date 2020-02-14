package cn.com.agree.huanan.ap.tl.db.impl.base;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import cn.com.agree.huanan.ap.tl.db.base.DbConnection;
import cn.com.agree.huanan.ap.tl.db.base.DbDataSource;
import cn.com.agree.huanan.ap.tl.exception.ExceptionMapper;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 测试
 * 
 * @author tan.ch
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
    SpringUtil.class
})
@PowerMockIgnore({
    "com.sun.crypto.*",
    "javax.crypto.*",
    "javax.management.*",
})
public class DefaultDbConnectionTest {
    @InjectMocks
    private DbConnection dbConn = new DefaultDbConnection();

    @Mock
    private Logger mockLogger;
    @Mock
    private ExceptionMapper mockExceptionMapper;
    @Mock
    private DbDataSource mockDbDataSrc;
    @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockStmt;
    
    /**
     * 初始化
     * 
     * @throws Exception 异常
     */
    @Before
    public void setUp() throws Exception {
        // 初始化
        mockStatic(SpringUtil.class);
        MockitoAnnotations.initMocks(this);
        // 条件返回
        when(SpringUtil.getBean(ExceptionMapper.class)).thenReturn(mockExceptionMapper);
       /* when(mockExceptionMapper.map(any(String.class), any(Object[].class))).thenAnswer(
                i -> new String[] {
                        i.getArgument(0),
                        i.getArgument(0)
                });*/
        when(mockExceptionMapper.map(any(String.class), 0, any(Object[].class))).thenAnswer(
                i -> new String[] {
                        i.getArgument(0),
                        i.getArgument(0)
                });
        when(mockDbDataSrc.getConnection(null)).thenReturn(mockConn);
        when(mockConn.prepareStatement(any(String.class))).thenReturn(mockStmt);
        // 清理
        dbConn.close();
    }

    /**
     * 清理
     * 
     * @throws Exception 异常
     */
    @After
    public void tearDown() throws Exception {
        // 清理
        dbConn.close();
    }

    /**
     * 获取连接：
     * <p>
     * 当连接非自动提交，必须设置为自动提交
     * 
     * @throws Exception 异常
     */
    @Test
    public void getConn_should_setAutoCommit() throws Exception {
        // set
        when(mockConn.getAutoCommit()).thenReturn(true);
        // test
        dbConn.execute("any sql");
        // verify
        verify(mockConn).getAutoCommit();
        verify(mockConn).setAutoCommit(false);
    }

    /**
     * 获取连接：
     * <p>
     * 当连接自动提交，不能设置定提交
     * 
     * @throws Exception 异常
     */
    @Test
    public void getConn_shouldNot_setAutoCommit() throws Exception {
        // set
        when(mockConn.getAutoCommit()).thenReturn(false);
        // test
        dbConn.execute("any sql");
        // verify
        verify(mockConn).getAutoCommit();
        verify(mockConn, never()).setAutoCommit(anyBoolean());
    }

    /**
     * 获取连接：
     * <p>
     * setAutoCommit抛出异常，需要屏蔽不扩散
     * 
     * @throws Exception 异常
     */
    @Test
    public void getConn_throwException_setAutoCommit() throws Exception {
        // set
        when(mockConn.getAutoCommit()).thenReturn(true);
        SQLException apiException = new SQLException("any sql exception");
        doThrow(apiException).when(mockConn).setAutoCommit(false);
        // test
        dbConn.execute("any sql");
        // verify
        verify(mockConn).getAutoCommit();
        verify(mockConn).setAutoCommit(false);
        // logger.exception("设置自动提交错误，忽略：", ex);
        verify(mockLogger).exception(anyString(), same(apiException));
    }

    /**
     * 关闭：
     * <p>
     * 连接关闭，直接返回
     * 
     * @throws Exception 异常
     */
    @Test
    public void close_returnWhen_ConnectionClosed() throws Exception {
        // set
        // test
        dbConn.close();
        // verify
        verify(mockDbDataSrc, never()).getConnection(null);
        verify(mockConn, never()).close();
    }

    /**
     * 关闭：
     * <p>
     * 带事务，执行提交
     * 
     * @throws Exception 异常
     */
    @Test
    public void close_commitWhen_ContainTransaction() throws Exception {
        // set
        // test
        dbConn.execute("any sql");
        dbConn.close();
        // verify
        verify(mockConn).commit();
        verify(mockConn).close();
        // logger.info("连接包含未提交的事务，请排查程序逻辑是否存在问题，本连接事务将会被提交");
        verify(mockLogger).error(anyString());
    }

    /**
     * 关闭：
     * <p>
     * 带事务，执行提交，不能抛出异常
     * 
     * @throws Exception 异常
     */
    @Test
    public void close_shouldNotThrowWhen_commit() throws Exception {
        // set
        SQLException apiException = new SQLException("any sql exception");
        doThrow(apiException).when(mockConn).commit();
        // test
        dbConn.execute("any sql");
        dbConn.close();
        // verify
        verify(mockConn).commit();
        verify(mockConn).close();
        // logger.exception("提交事务异常，忽略：", ex);
        verify(mockLogger).exception(anyString(), same(apiException));
    }

    /**
     * 关闭：
     * <p>
     * 不能抛出异常
     * 
     * @throws Exception 异常
     */
    @Test
    public void close_shouldNotThrowWhen_close() throws Exception {
        // set
        SQLException apiException = new SQLException("any sql exception");
        doThrow(apiException).when(mockConn).close();
        // test
        dbConn.execute("any sql");
        dbConn.close();
        // verify
        verify(mockConn).close();
        // logger.error("关闭连接错误，忽略：%s", connInfo);
        verify(mockLogger).error(anyString());
        // logger.exception(ex);
        verify(mockLogger).exception(same(apiException));
        
        // 再次执行close()，确保之前已经释放连接
        reset(mockConn);
        dbConn.close();
        verify(mockConn, never()).close();
    }

    /**
     * 关闭：
     * <p>
     * 不能抛出异常
     * 
     * @throws Exception 异常
     */
    @Test
    public void close_normal_close() throws Exception {
        // set
        // test
        dbConn.execute("any sql");
        dbConn.close();
        // verify
        verify(mockConn).close();
        
        // 再次执行close()，确保之前已经释放连接
        reset(mockConn);
        dbConn.close();
        verify(mockConn, never()).close();
    }



}
