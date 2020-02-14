package cn.com.agree.huanan.ap.tl.util;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JUN
 */
public class FileParserWriterTest {

    @Test
    public void testWriteFile() throws IOException {
        FileParserWriter writer = new FileParserWriter("./src/test/java/cn/com/agree/huanan/ap/tl/util/tmp.txt",",");
        List<String> writeList = new ArrayList<>();
        writeList.add("aaa");
        writeList.add("bbb");

        writer.writeFile(writeList);
        File file = new File("./src/test/java/cn/com/agree/huanan/ap/tl/util/tmp.txt");
        Assert.assertEquals(true,file.exists());
        writer.close();

    }


}
