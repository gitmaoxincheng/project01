package cn.com.agree.huanan.ap.al.APTL.datadict;

import cn.com.agree.huanan.ap.tl.metadata.DataDictItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class DataEnumTest {

    @Test
    public void testFields(){
        DataDictItem enumCnName=DataEnum.enumCnName;
        DataDictItem enumName  =DataEnum.enumName;
        DataDictItem itemCnName=DataEnum.itemCnName;
        DataDictItem itemCode  =DataEnum.itemCode;
        DataDictItem itemName  =DataEnum.itemName;

        Assert.assertEquals("枚举项中文名称",itemCnName.getCnName());


    }
}
