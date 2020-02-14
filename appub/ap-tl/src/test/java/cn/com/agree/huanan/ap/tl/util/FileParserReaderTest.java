package cn.com.agree.huanan.ap.tl.util;

import cn.com.agree.huanan.ap.tl.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Logger.class
})
public class FileParserReaderTest {

    @Mock
    Logger logger;

    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        mockStatic(Logger.class);
        MockitoAnnotations.initMocks(this);

        when(Logger.getLogger(FileParserReader.class)).thenReturn(logger);
        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());

    }

    @Test
    public void testGetFileLineNum(){
        List<List<String>> parserFields = new ArrayList<>();
        List<String> sublist = new ArrayList<>();
        sublist.add(";");
        FileParserReader reader = new FileParserReader("./src/main/java/cn/com/agree/huanan/ap/tl/util/CallbackUtil.java",parserFields,"");
        int line = reader.getFileLineNum();
        Assert.assertEquals(100,line);


    }


    @Test
    public void testNextLine() throws Exception {
        List<List<String>> parserFields = new ArrayList<>();
        List<String> sublist = new ArrayList<>();
        sublist.add(" ");
        sublist.add("100");
        sublist.add("M");

        parserFields.add(sublist);
        FileParserReader reader = new FileParserReader("./src/main/java/cn/com/agree/huanan/ap/tl/util/CallbackUtil.java",parserFields,";");
        Map<String, String> actual = reader.nextLine();
        Assert.assertEquals("{ =package cn.com.agree.huanan.ap.tl.util, errorCode=0000, errorMsg=转换成功}",actual.toString());


        List<String> sublist1 = new ArrayList<>();
        sublist1.add(" ");
        sublist1.add("10");
        sublist1.add("M");
        parserFields.clear();
        parserFields.add(sublist1);
        reader = new FileParserReader("./src/main/java/cn/com/agree/huanan/ap/tl/util/CallbackUtil.java",parserFields,";");
        actual = reader.nextLine();
        Assert.assertEquals("{errorCode=0002, errorMsg= 字段，内容长度不符合规范！}",actual.toString());

        reader.close();
    }



}
