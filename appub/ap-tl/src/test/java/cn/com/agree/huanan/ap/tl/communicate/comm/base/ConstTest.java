package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class ConstTest {

    @Test
    public void testAll(){
        Assert.assertEquals(500,Const.DEFAULT_CONNECT_TIMEOUT);
        Assert.assertEquals(2000,Const.DEFAULT_SOCKET_TIMEOUT);
        Assert.assertEquals(1024,Const.DEFAULT_MAX_READ_BYTES);
        Assert.assertEquals(1024,Const.DEFAULT_MAX_WRITE_BYTES);
        Assert.assertEquals(1024*1024,Const.DEFAULT_MAX_BYTES);
    }
}
