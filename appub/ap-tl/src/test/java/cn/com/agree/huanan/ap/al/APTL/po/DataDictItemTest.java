package cn.com.agree.huanan.ap.al.APTL.po;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class DataDictItemTest {

    @Test
    public void test(){
        DataDictItem item = new DataDictItem();
        item.setAlId("");
        item.setTypeName("");
        item.setItemName("");
        item.setItemCnName("");
        item.setDataType("");
        item.setDataEnum("");
        item.setMinLen(0);
        item.setMaxLen(1);
        item.setExtItem("");


        Assert.assertEquals("",item.getAlId());
        Assert.assertEquals("",item.getTypeName());
        Assert.assertEquals("",item.getItemName());
        Assert.assertEquals("",item.getItemCnName());
        Assert.assertEquals("",item.getDataType());
        Assert.assertEquals("",item.getDataEnum());
        Assert.assertEquals(0,item.getMinLen());
        Assert.assertEquals(1,item.getMaxLen());
        Assert.assertEquals("",item.getExtItem());

    }
}
