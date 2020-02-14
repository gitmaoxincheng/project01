package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class CommAbandExceptionTest {

    @Test
    public void test(){
        CommAbandException exception = CommAbandException.getException();
        Assert.assertTrue(exception instanceof  CommAbandException);
    }
}
