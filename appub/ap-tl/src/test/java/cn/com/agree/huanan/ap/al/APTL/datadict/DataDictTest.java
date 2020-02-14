package cn.com.agree.huanan.ap.al.APTL.datadict;

import cn.com.agree.huanan.ap.tl.metadata.DataDictItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class DataDictTest {

    @Test
    public void testAllField(){
        DataDictItem dataEnum   =DataDict.dataEnum  ;

        DataDictItem dataType   =DataDict.dataType  ;

        DataDictItem extItem    =DataDict.extItem   ;

        DataDictItem itemCnName =DataDict.itemCnName;

        DataDictItem itemName   =DataDict.itemName  ;

        DataDictItem maxLen     =DataDict.maxLen    ;

        DataDictItem minLen     =DataDict.minLen    ;

        DataDictItem typeCnName =DataDict.typeCnName;

        DataDictItem typeName   =DataDict.typeName  ;

        Assert.assertEquals("数据枚举",dataEnum.getCnName());


    }
}
