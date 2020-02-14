package cn.com.agree.huanan.ap.tl.metadata;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.ApCommandLineApplication;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * 元数据生成器
 * 
 * @author tan.ch
 *
 */
@Component
public class MetaDataGenerator implements ApCommandLineApplication {
    /**
     * 入口
     * 
     * @param args 参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        SpringUtil.runApplication(MetaDataGenerator.class, args);
    }

    @Autowired
    private Logger logger;

    @Autowired
    private MetaDataEnumGenerator enumGen;

    @Autowired
    private MetaDataDataDictGenerator dataDictGen;
    
    @Autowired
    private MetaDataDdlGenerator tableGen;
    
    @Value("${ap.alId:APTL}")
    private String alId;

    @Override
    public void run(String[] args) throws Exception {
        // 处理枚举
        enumGen.procEnum(alId, MetaDataGenerator::writeJavaCode);
        // 处理数据字典
        dataDictGen.procDataDict(alId, MetaDataGenerator::writeJavaCode);
        // 处理数据表
        tableGen.procDdl(alId, MetaDataGenerator::writeSql);
    }

    private static void writeJavaCode(String path, String javaCode) {
        writeFile(path, javaCode, StrUtil.CHARSET_UTF8);
    }

    private static void writeSql(String path, String sqlCode) {
        writeFile(path, sqlCode, StrUtil.CHARSET_UTF8);
    }

    private static void writeFile(String path, String content, Charset charset) {
        byte[] contents = content.getBytes(charset);
        try {
            Files.write(Paths.get(path), contents);
        } catch (Exception ex) {
            throw ExceptionUtil.convert(ex);
        }
    }
}
