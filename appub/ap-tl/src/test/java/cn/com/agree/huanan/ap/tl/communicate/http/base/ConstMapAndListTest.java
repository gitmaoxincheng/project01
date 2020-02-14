package cn.com.agree.huanan.ap.tl.communicate.http.base;

import cn.com.agree.huanan.ap.tl.communicate.http.handler.HttpGetHandler;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author JUN
 */
public class ConstMapAndListTest {

    @Test
    public void test(){

        Map<String,Class<?>> HTTP_OPERATOR_SUPPORT = ConstMapAndList.HTTP_OPERATOR_SUPPORT;
        Assert.assertEquals(HttpGetHandler.class,HTTP_OPERATOR_SUPPORT.get("GET"));

    }

}
