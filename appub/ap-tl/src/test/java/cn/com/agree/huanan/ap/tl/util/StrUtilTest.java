package cn.com.agree.huanan.ap.tl.util;

import cn.com.agree.huanan.ap.tl.exception.ExceptionMapper;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIllegalArgumentException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApNumberFormatException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApUnsupportedEncodingException;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.mockito.Mockito.*;
/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        SpringUtil.class
})
public class StrUtilTest {

    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        mockStatic(SpringUtil.class);

        ExceptionMapper mapper = new ExceptionMapper() {
            /*public String[] map(String exceptionId, Object[] errorMsgArgs) {
                return new String[]{"1","2"};
            }*/

			@Override
			public String[] map(String exceptionId, int index, Object[] errorMsgArgs) {
				return new String[]{"1","2"};
			}
        };
        when(SpringUtil.getBean(ExceptionMapper.class)).thenReturn(mapper);
    }

    @Test
    public void testTrimAll(){
        String actual = StrUtil.trimAll("");
        Assert.assertNull(actual);

        actual = StrUtil.trimAll("aaa ");
        Assert.assertEquals("aaa",actual);

    }


    @Test
    public void testArray2String(){
        String[] strArr = new String[]{"a", "b"};
        String actual = StrUtil.array2String(strArr,",");

        Assert.assertEquals("a,b,",actual);

    }


    @Test
    public void testReplaceString(){
        String actual;

        actual = StrUtil.replaceString(null,"","");
        Assert.assertNull(actual);
        actual = StrUtil.replaceString("xxx","","");
        Assert.assertEquals("xxx", actual);
        actual = StrUtil.replaceString("xxx,xxx", ",", null);
        Assert.assertEquals("xxxxxx", actual);
        actual = StrUtil.replaceString("x,x,x",".",",");
        Assert.assertEquals("x,x,x",actual);

    }


    @Test
    public void testToString(){
        String actual = StrUtil.toString(null);
        Assert.assertNull(actual);
        actual = StrUtil.toString(new String[]{"a","b"});
        Assert.assertEquals("a,b",actual);

    }

    @Test
    public void testToArray(){
        String[] actual = StrUtil.toArray(null);
        Assert.assertNull(actual);

        actual = StrUtil.toArray("a,b");

        Assert.assertArrayEquals(new String[]{"a","b"},actual);

    }


    @Test
    public void testToArraySplitDefine(){
        String[] actual = StrUtil.toArraySplitDefine(null, "");
        Assert.assertNull(actual);

        actual = StrUtil.toArraySplitDefine("a,b","");
        Assert.assertArrayEquals(new String[]{"a","b"},actual);
    }

    @Test
    public void testNull2str(){
        String actual = StrUtil.null2str(null);
        Assert.assertEquals("", actual);
        actual = StrUtil.null2str("a");
        Assert.assertEquals("a",actual);
        actual = StrUtil.null2str(null,"a");
        Assert.assertEquals("a",actual);
    }


    @Test
    public void testIsNull(){
        boolean actual = StrUtil.isNull("");
        Assert.assertEquals(true, actual);
        actual = StrUtil.isNull("a");
        Assert.assertEquals(false,actual);
    }


    @Test
    public void testIsNullAndFilledBlank(){
        boolean actual = StrUtil.isNullAndFilledBlank("  ");
        Assert.assertEquals(true, actual);
        actual = StrUtil.isNullAndFilledBlank("a");
        Assert.assertEquals(false,actual);

    }


    @Test
    public void testIsNullIfnull(){
        boolean actual = StrUtil.isNullIfnull(" null ");
        Assert.assertEquals(true, actual);
        actual = StrUtil.isNullIfnull("a");
        Assert.assertEquals(false,actual);
    }


    @Test
    public void testString2Int(){
        int actual = StrUtil.String2Int("1");
        Assert.assertEquals(1, actual);
        thrown.expect(ApNumberFormatException.class);
        StrUtil.String2Int("a");

        actual = StrUtil.String2Int("10",1);
        Assert.assertEquals(10, actual);
        thrown.expect(ApNumberFormatException.class);
        StrUtil.String2Int("aa",2);

    }


    @Test
    public void testString2Integer(){
        Integer actual = StrUtil.String2Integer("1");
        Assert.assertEquals(1,actual.intValue());
    }

    @Test
    public void testString2Long(){
        long actual = StrUtil.String2Long("1");
        Assert.assertEquals(1L,actual);
    }


    @Test
    public void testByteArray2String(){
        String actual = StrUtil.byteArray2String("xxx".getBytes(),"");
        Assert.assertEquals("xxx",actual);
        actual = StrUtil.byteArray2String("xxx".getBytes(),0,3,"");
        Assert.assertEquals("xxx", actual);
        thrown.expect(ApUnsupportedEncodingException.class);
        StrUtil.byteArray2String("xxx".getBytes(),0,3,"ddd");
    }


    @Test
    public void testGetByteLen(){
        int actual = StrUtil.getByteLen("xxx","");
        Assert.assertEquals(3,actual);
    }


    @Test
    public void testleftPadding(){
        String actual = StrUtil.leftPadding("xxx",1,' ');
        Assert.assertEquals(" xxx",actual);
        thrown.expect(ApIllegalArgumentException.class);
        StrUtil.leftPadding("xxx",-1,' ');

    }

    @Test
    public void testrightPadding(){
        String actual = StrUtil.rightPadding("xxx",1,' ');
        Assert.assertEquals("xxx ",actual);
        thrown.expect(ApIllegalArgumentException.class);
        StrUtil.leftPadding("xxx",-1,' ');

    }

    @Test
    public void testIsAscii(){
        boolean actual = StrUtil.isAscii("xxx");
        Assert.assertEquals(true,actual);
    }

    @Test
    public void testIsEquals(){
        boolean actual = StrUtil.isEquals(null,null);
        Assert.assertEquals(true, actual);
        actual = StrUtil.isEquals("a", "a");
        Assert.assertEquals(true, actual);

    }


    @Test
    public void testisEmpty(){
        boolean actual = StrUtil.isEmpty("");
        Assert.assertEquals(true,actual);
    }


    @Test
    public void testOrElse(){
        String actual = StrUtil.orElse("","a");
        Assert.assertEquals("a",actual);
    }








}
