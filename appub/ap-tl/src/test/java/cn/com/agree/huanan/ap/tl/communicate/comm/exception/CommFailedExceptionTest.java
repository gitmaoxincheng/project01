package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class CommFailedExceptionTest {

    @Test
    public void test(){
        CommFailedException exception = CommFailedException.getException();
        Assert.assertTrue(exception instanceof  CommFailedException);
    }
}
