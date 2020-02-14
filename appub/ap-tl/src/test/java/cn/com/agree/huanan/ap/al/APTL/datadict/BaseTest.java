package cn.com.agree.huanan.ap.al.APTL.datadict;

import cn.com.agree.huanan.ap.tl.metadata.DataDictItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author JUN
 */
public class BaseTest {

    @Test
    public void testFields(){
        DataDictItem alId = Base.alId;
//        System.out.println(alId.getCnName());
        Assert.assertEquals("应用标识", alId.getCnName());
        DataDictItem cnKeywordName = Base.cnKeywordName;
        Assert.assertEquals("中文关键字名称", cnKeywordName.getCnName());
        DataDictItem dataLen = Base.dataLen;
        Assert.assertEquals("数据长度",dataLen.getCnName());
        DataDictItem enKeywordName = Base.enKeywordName;
        Assert.assertEquals("英文关键字名称",enKeywordName.getCnName());
        DataDictItem seqNo = Base.seqNo;
        Assert.assertEquals("序号",seqNo.getCnName());

    }

}
