package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class NoCommParamExceptionTest {

    @Test
    public void test(){
        NoCommParamException exception = NoCommParamException.getException();
        Assert.assertTrue(exception instanceof  NoCommParamException);
    }
}
