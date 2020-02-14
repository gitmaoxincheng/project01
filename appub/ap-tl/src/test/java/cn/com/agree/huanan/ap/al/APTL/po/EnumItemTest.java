package cn.com.agree.huanan.ap.al.APTL.po;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class EnumItemTest {


    @Test
    public void test(){
        EnumItem item = new EnumItem();
        item.setAlId("");
        item.setEnumName("");
        item.setItemCode("");
        item.setItemName("");
        item.setItemDesc("");
        item.setItemNo(0);


        Assert.assertEquals("",item.getAlId());
        Assert.assertEquals("",item.getEnumName());
        Assert.assertEquals("",item.getItemCode());
        Assert.assertEquals("",item.getItemName());
        Assert.assertEquals("",item.getItemDesc());
        Assert.assertEquals(0,item.getItemNo());

    }
}
