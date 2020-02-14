package cn.com.agree.huanan.ap.tl.communicate.comm.base;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author JUN
 */
public class ConstMapAndListTest {

    @Test
    public void testAll(){
        Map<String,String> actual = ConstMapAndList.COMMUNICATE_SUPPORT;
        Assert.assertEquals("Soecket",actual.get("SOCK"));
    }

}
