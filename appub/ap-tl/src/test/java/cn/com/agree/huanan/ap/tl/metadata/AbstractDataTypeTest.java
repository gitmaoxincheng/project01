package cn.com.agree.huanan.ap.tl.metadata;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTooLongException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTooShortException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
public class AbstractDataTypeTest {

    @Rule
    ExpectedException thrown= ExpectedException.none();

    @Test
    public void testGetRowType(){
        AbstractDataType dataType = new AbstractDataType() {
        };
        Assert.assertEquals(String.class,dataType.getRawType());

        thrown.expect(ApValueTypeUnsupportException.class);
        new AbstractDataType(boolean.class) {
        };

    }



    @Test
    public void tetValidate(){
        AbstractDataType dataType = new AbstractDataType() {
        };
        thrown.expect(ApValueTooShortException.class);
        dataType.validate("xxx",5,10);
        thrown.expect(ApValueTooLongException.class);
        dataType.validate("xxx",1,2);
        dataType.validateContent("");
    }
}
