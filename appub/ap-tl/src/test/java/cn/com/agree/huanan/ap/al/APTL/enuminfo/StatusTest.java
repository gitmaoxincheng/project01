package cn.com.agree.huanan.ap.al.APTL.enuminfo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class StatusTest {

    @Test
    public void testStatus(){
        Status status = Status.SUCCESS;
        Assert.assertEquals("S",status.getCode());
    }
}
