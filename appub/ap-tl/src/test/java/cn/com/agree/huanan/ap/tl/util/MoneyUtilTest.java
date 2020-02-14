package cn.com.agree.huanan.ap.tl.util;

import static org.junit.Assert.*;

import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import org.junit.Rule;
import org.junit.Test;

import cn.com.agree.huanan.ap.tl.util.MoneyUtil;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

/**
 * 
 * @author xiaot
 *
 */
@RunWith(PowerMockRunner.class)
public class MoneyUtilTest {

	@Rule
	protected ExpectedException thrown= ExpectedException.none();
	/**
	 * 删除千分符测试案例
	 */
	@Test
	public void deleteComma() {

		assertEquals(MoneyUtil.deleteComma("2,34"), "234");
	}

	/**
	 * 元转分测试案例
	 */
	@Test
	public void yuanToFen() {

		assertEquals( "3400",MoneyUtil.yuanToFen("34"));
		assertEquals("0", MoneyUtil.yuanToFen(""));
		assertEquals( "-3400",MoneyUtil.yuanToFen("-34"));
		assertEquals( "3400",MoneyUtil.yuanToFen("+34"));
		assertEquals( "3413",MoneyUtil.yuanToFen("34.13"));
		thrown.expect(ApIllegalParamException.class);
		MoneyUtil.yuanToFen("34.13.11");
		MoneyUtil.yuanToFen(" .13");
		MoneyUtil.yuanToFen("34. ");
	}
	

	
	
	/**
	 * 测试分转元,不插千分符
	 */
	@Test
	public void fenToYuan()   {
		assertEquals("0.00",MoneyUtil.fenToYuan("",null));
		assertEquals("-100.00",MoneyUtil.fenToYuan("-10000",null));
		assertEquals("100.00",MoneyUtil.fenToYuan("+10000",null));
		assertEquals("0.10",MoneyUtil.fenToYuan("+10",null));
		assertEquals("0.01",MoneyUtil.fenToYuan("+1",true));




	}
	
	/**
	 * 删除数据前的0;
	 * 案例：金额不包括小数点
	 */
	@Test
	public void deletePreZero()   {
		assertEquals("3400015",MoneyUtil.deletePreZero("000003400015"));
		assertEquals("3400015",MoneyUtil.deletePreZero("+000003400015"));
		assertEquals("-3400015",MoneyUtil.deletePreZero("-000003400015"));
		assertEquals("0",MoneyUtil.deletePreZero(""));


	}
	
	
	/**
	 * 删除数据前的0;
	 * 案例：金额包括小数点

	 */
	@Test
	public void deletePreZero_2()   {

		assertEquals(MoneyUtil.deletePreZero("0000034000.15"), "34000.15");
		
	}
	
	
	/**
	 * 删除数据前的0;
	 * 案例：金额包括小数点，存在千分符
	 */
	@Test
	public void deletePreZero_3()   {

		assertEquals(MoneyUtil.deletePreZero("0000034,000.15"), "34,000.15");
		
	}




	@Test
	public void testSplitSign(){
		ArrayList<String> actual = MoneyUtil.splitSign("+11.11","+");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("");
		expected.add("11.11");
		assertEquals(expected, actual);
		actual = MoneyUtil.splitSign("-11.11","+");
		expected.remove(0);
		expected.remove(0);
		expected.add("-");
		expected.add("11.11");
		assertEquals(expected,actual);

	}



	@Test
	public void testCheckAmount(){
		thrown.expect(ApIllegalParamException.class);
		MoneyUtil.checkAmount("0");

	}




	@Test
	public void testCalcAmount(){
		assertEquals("6",MoneyUtil.calcAmount("+","4","2","") );
		assertEquals("6",MoneyUtil.calcAmount("+","4","2","0"));
		assertEquals("6",MoneyUtil.calcAmount("+","4","2","1"));
		assertEquals("6",MoneyUtil.calcAmount("+","4","2","2"));
		assertEquals("2",MoneyUtil.calcAmount("-","4","2","2"));
		assertEquals("8",MoneyUtil.calcAmount("*","4","2","2"));
		assertEquals("2",MoneyUtil.calcAmount("/","4","2","2"));
	}



	@Test
	public void testIsNumeric(){
		boolean actual = MoneyUtil.isNumeric("1111");
		assertEquals(true,actual);
	}

	
	/**
	 * 小写转大写金额
	 * 案例：金额包括小数点，存在千分符
	 */
	@Test
	public void digitUppercase()   {

		assertEquals(MoneyUtil.digitUppercase("34"), "叁拾肆元整");
		
	}
	
	/**
	 * 小写转大写金额
	 * 案例：金额包括小数点，存在千分符
	 */
	@Test
	public void digitUppercase_2()   {

		assertEquals(MoneyUtil.digitUppercase("12334.13"), "壹万贰仟叁佰叁拾肆元壹角叁分");
		
	}
	
}
