package cn.com.agree.huanan.ap.rl.aptl.dao;

import cn.com.agree.huanan.ap.rl.aptl.MyMockTest;
import cn.com.agree.huanan.ap.rl.aptl.po.AptlExceptMapperInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @author JUN
 */
public class AptlExceptMapperInfoDaoTest extends MyMockTest{


    private AptlExceptMapperInfoDao dao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        dao = new AptlExceptMapperInfoDao();
        dao.dbOper = dbOper;

    }


    @Test
    public void testFindById(){
        Map<String,Object> map = new HashMap<>();
        when(selecter.fetchOne()).thenReturn(map);
        AptlExceptMapperInfo actual = dao.findById("");
        Assert.assertNull(actual);
        map.put("errorCode","errcode001");
        map.put("errorMsg","errmsg001");
        actual = dao.findById("exc001");
        AptlExceptMapperInfo expected = new AptlExceptMapperInfo();
        expected.setExceptionId("exc001");
        expected.setErrorCode("errcode001");
        expected.setErrorMsg("errmsg001");
        Assert.assertEquals(expected.toString(),actual.toString());

    }

}
