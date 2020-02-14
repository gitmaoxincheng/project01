package cn.com.agree.huanan.ap.al.APTL.po;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class EnumInfoTest {

    @Test
    public void test(){
        EnumInfo info = new EnumInfo();
        info.setAlId("");
        info.setEnumName("");
        info.setEnumDesc("");

        Assert.assertEquals("",info.getAlId());
        Assert.assertEquals("",info.getEnumName());
        Assert.assertEquals("",info.getEnumDesc());
    }
}
