package cn.com.agree.huanan.ap.tl.communicate.comm.context;

import cn.com.agree.huanan.ap.tl.communicate.comm.base.Const;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.AbandonException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.BaseException;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.base.FailedException;
import cn.com.agree.huanan.ap.tl.exception.ExceptionMapper;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.mockito.Mockito.*;
/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        SpringUtil.class
})
public class CommContextTest {

    CommContext context;
    @Mock
    ExceptionMapper exceptionMapper;

    @Before
    public void setUp(){
        mockStatic(SpringUtil.class);
        MockitoAnnotations.initMocks(this);
        when(SpringUtil.getBean(ExceptionMapper.class)).thenReturn(exceptionMapper);
        //when(exceptionMapper.map(anyString(),any())).thenReturn(new String[]{"1","2"});
    }


    @Test
    public void testGetCommContext() {
        context = CommContext.getCommContext();
        Assert.assertEquals(Const.ERROR_TYPE_SUCCESS, context.getStatus());
        context = CommContext.getFailedCommContext();
        Assert.assertEquals(Const.ERROR_TYPE_FAILED,context.getStatus());
//        Assert.assertTrue(context.getException() instanceof FailedException);
        context = CommContext.getCommAbandonContext();
//        Assert.assertEquals(Const.ERROR_TYPE_ABAND,context.getStatus());
        Assert.assertTrue(context.getException() instanceof AbandonException);

//        Assert.assertNull(context.getMessage());
        Assert.assertFalse(context.isSuccess());
        Assert.assertFalse(context.isFailed());
        Assert.assertTrue(context.isAbandon());

    }

}
