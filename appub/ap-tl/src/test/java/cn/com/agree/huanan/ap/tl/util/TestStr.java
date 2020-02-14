package cn.com.agree.huanan.ap.tl.util;

import org.junit.Test;

public class TestStr {


    @Test
    public void testOrElse2(){
        String actual = "S0120019A01";
		String svcCode = actual.substring(0,8); //前八位
		String scnCode = actual.substring(9,11); //后两位
		System.out.println(svcCode);
		System.out.println(scnCode);
    }
    
    
}
