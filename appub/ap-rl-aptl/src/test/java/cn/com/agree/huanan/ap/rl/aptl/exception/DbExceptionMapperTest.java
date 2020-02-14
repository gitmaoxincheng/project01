package cn.com.agree.huanan.ap.rl.aptl.exception;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cn.com.agree.huanan.ap.rl.aptl.MyMockTest;
import cn.com.agree.huanan.ap.rl.aptl.dao.AptlExceptMapperInfoDao;
import cn.com.agree.huanan.ap.rl.aptl.po.AptlExceptMapperInfo;

public class DbExceptionMapperTest extends MyMockTest{
    @Mock
    private AptlExceptMapperInfoDao dao;

    private DbExceptionMapper exceptionMapper;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
        //初始化被测对象
        exceptionMapper = new DbExceptionMapper();
        exceptionMapper.dao = dao;
        exceptionMapper.logger = logger;


    }

    @Test
    public void testMap(){
        AptlExceptMapperInfo po = new AptlExceptMapperInfo();
        po.setExceptionId("exc001");
        po.setErrorCode("errcode001");
        po.setErrorMsg("errmsg001");

        when(dao.findById(anyString())).thenReturn(po);
        String[] errorMsgArgs = {"1","2","3"};
        String[] actual = exceptionMapper.map("",errorMsgArgs);
        Assert.assertEquals("errcode001",actual[0]);
        Assert.assertEquals("errmsg001",actual[1]);

        when(dao.findById(anyString())).thenReturn(null);
        actual = exceptionMapper.map("",errorMsgArgs);
        Assert.assertEquals("A0001",actual[0]);
        Assert.assertEquals("错误码没配置",actual[1]);

        po.getErrorCode();
        po.getErrorMsg();
        po.getExceptionId();


    }
}
