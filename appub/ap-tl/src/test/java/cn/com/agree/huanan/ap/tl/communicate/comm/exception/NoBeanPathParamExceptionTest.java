package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class NoBeanPathParamExceptionTest {

    @Test
    public void test(){
        NoBeanPathParamException exception = NoBeanPathParamException.getException();
        Assert.assertTrue(exception instanceof  NoBeanPathParamException);
    }
}
