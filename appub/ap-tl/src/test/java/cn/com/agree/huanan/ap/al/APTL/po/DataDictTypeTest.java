package cn.com.agree.huanan.ap.al.APTL.po;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class DataDictTypeTest {

    @Test
    public void test(){
        DataDictType type = new DataDictType();
        type.setAlId("");
        type.setTypeName("");
        type.setTypeCnName("");

        Assert.assertEquals("",type.getAlId());
        Assert.assertEquals("",type.getTypeName());
        Assert.assertEquals("",type.getTypeCnName());


    }
}
