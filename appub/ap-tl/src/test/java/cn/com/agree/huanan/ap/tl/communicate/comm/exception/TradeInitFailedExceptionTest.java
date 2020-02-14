package cn.com.agree.huanan.ap.tl.communicate.comm.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class TradeInitFailedExceptionTest {

    @Test
    public void test(){
        TradeInitFailedException exception = TradeInitFailedException.getException();
        Assert.assertTrue(exception instanceof  TradeInitFailedException);
    }
}
