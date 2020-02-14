package cn.com.agree.huanan.ap.tl.metadata;

import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.po.EnumInfo;
import cn.com.agree.huanan.ap.al.APTL.po.EnumItem;
import cn.com.agree.huanan.ap.al.APTL.service.EnumService;
import cn.com.agree.huanan.ap.tl.logging.Logger;


@Component
public class MetaDataEnumGenerator {
    @Autowired
    private Logger logger;

    @Autowired
    private EnumService enumService;
    
    public void procEnum(String alId, BiConsumer<String, String> javaCodeHandler) {
        logger.info("处理枚举信息");
        // 逐个处理
        enumService.procEnumInfo(
                alId,
                (enumInfo, enumItemList) -> {
                    logger.info("proc enum: %s", enumInfo);
                    // 枚举项
                    String enumItemCode = String.join(
                            "\n",
                            enumItemList.stream()
                                .map(MetaDataEnumGenerator::getEnumItemCode)
                                .collect(Collectors.toList()));
                    // 完整代码
                    String javaCode = getEnumJavaCode(enumInfo, enumItemCode);
                    // logger.info(javaCode);
                    // 文件路径
                    String path = String.format(
                            "src/main/java/cn/com/agree/huanan/ap/al/APTL/enuminfo/%s.java",
                            enumInfo.getEnumName());
                    // 传递给处理器
                    javaCodeHandler.accept(path, javaCode);
                });
    }

    private static String getEnumItemCode(EnumItem enumItem) {
        // join
        String[] lineList = {
                "    /** %s */",
                "    %s(\"%s\"),"
        };
        String javaCode = String.join("\n", lineList);
        // format
        javaCode = String.format(javaCode, enumItem.getItemDesc(), enumItem.getItemName(),
                enumItem.getItemCode());
        //
        return javaCode;
    }

    private static String getEnumJavaCode(EnumInfo enumInfo, String enumItemCode) {
        // join
        String[] lineList = {
                "package cn.com.agree.huanan.ap.al.APTL.enuminfo;",
                "",
                "import cn.com.agree.huanan.ap.tl.metadata.DataEnum;",
                "",
                "/**",
                " * %s",
                " * ",
                " * @author MetaDataGenerator",
                " *",
                " */",
                "public enum %s implements DataEnum {",
                "%s",
                "    ;",
                "    ",
                "    /** 代码 */",
                "    private final String code;",
                "    ",
                "    /**",
                "     * 构造方法",
                "     * ",
                "     * @param code 代码",
                "     */",
                "    private Status(String code) {",
                "        this.code = code;",
                "    }",
                "",
                "    @Override",
                "    public String getCode() {",
                "        return code;",
                "    }",
                "}",
                "",
                "",
        };
        String javaCode = String.join("\n", lineList);
        // format
        javaCode = String.format(javaCode, enumInfo.getEnumDesc(), enumInfo.getEnumName(),
                enumItemCode);
        //
        return javaCode;
    }
}
