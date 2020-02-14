package cn.com.agree.huanan.ap.al.APTL.datadict;

import cn.com.agree.huanan.ap.tl.metadata.DataDictItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class JavaTest {

    @Test
    public void testFields(){
        DataDictItem className = Java.className;
        DataDictItem classSimpleName = Java.classSimpleName;
        Assert.assertEquals("类简单名",classSimpleName.getCnName());
    }
}
