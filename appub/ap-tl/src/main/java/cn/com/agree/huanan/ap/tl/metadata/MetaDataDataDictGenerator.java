package cn.com.agree.huanan.ap.tl.metadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictType;
import cn.com.agree.huanan.ap.al.APTL.service.DataDictService;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

@Component
public class MetaDataDataDictGenerator {
    @Autowired
    private Logger logger;

    @Autowired
    private DataDictService dataDictService;

    public void procDataDict(String alId, BiConsumer<String, String> javaCodeHandler) {
        logger.info("处理数据字典");
        // 逐个处理
        dataDictService.procDataDictType(alId, (ddt, ddiList) -> {
            logger.info("proc data type: %s", ddt.getTypeName());
            // item
                List<String> ddiCodeList = new ArrayList<>();
                ddiList.forEach(ddi -> {
                    String ddiCode = getDataDictItemJavaCode(ddi);
                    ddiCodeList.add(ddiCode);
                });
                // 完整代码
                String ddtName = StrUtil.firstCharToUpperCase(ddt.getTypeName());
                String javaCode = getDataDictTypeJavaCode(ddtName, String.join("\n", ddiCodeList));
                // logger.info(javaCode);
                // 文件路径
                String path = String.format(
                        "src/main/java/cn/com/agree/huanan/ap/al/APTL/datadict/%s.java", ddtName);
                // 传递给处理器
                javaCodeHandler.accept(path, javaCode);
            });
    }

    private static String getDataDictItemJavaCode(DataDictItem ddi) {
        // join
        String[] lineList1 = {
                "    /** %s */",
                "    public static final DataDictItem %s = MetaDataUtil.getDataDictItem(\"%s\", \"%s\", %s, %s, %s, null);",

        };
        String[] lineList2 = {
                "    /** %s */",
                "    public static final DataDictItem %s = MetaDataUtil.getDataDictItem(\"%s\", \"%s\", %s);",

        };
        String javaCode;
        String itemName = StrUtil.sfill(ddi.getItemName(), 20);
        // 原子
        if (ddi.getExtItem().isEmpty()) {
            // dataType
            String[] dataTypeItemList = ddi.getDataType().split(":");
            if (dataTypeItemList.length != 2) {
                throw new ApValueOutOfRangeException(dataTypeItemList);
            }
            String dataType = String.format("%s.%s", "AptlDataTypeList", dataTypeItemList[1]);
            // join
            javaCode = String.format(String.join("\n", lineList1), ddi.getItemCnName(), itemName,
                    ddi.getItemName(), ddi.getItemCnName(), dataType, ddi.getMinLen(), ddi.getMaxLen());
        }
        // 继承
        else {
            // check
            if (!ddi.getDataType().isEmpty()) {
                throw new ApValueOutOfRangeException(ddi.getDataType());
            }
            if (ddi.getMinLen() != 0) {
                throw new ApValueOutOfRangeException(ddi.getMinLen());
            }
            if (ddi.getMaxLen() != 0) {
                throw new ApValueOutOfRangeException(ddi.getMaxLen());
            }
            // extItem
            String[] dataExtItemList = ddi.getExtItem().split(":");
            if (dataExtItemList.length != 3) {
                throw new ApValueOutOfRangeException(dataExtItemList);
            }
            String dataExt = String.format("%s.%s",
                    StrUtil.firstCharToUpperCase(dataExtItemList[1]), dataExtItemList[2]);
            // join
            javaCode = String.format(String.join("\n", lineList2), ddi.getItemCnName(), itemName,
                    ddi.getItemName(), ddi.getItemCnName(), dataExt);
        }
        //
        return javaCode;
    }

    private static String getDataDictTypeJavaCode(String ddtName, String ddiCode) {
        String[] lineList = {
                "package cn.com.agree.huanan.ap.al.APTL.datadict;",
                "",
                "import cn.com.agree.huanan.ap.tl.metadata.AptlDataTypeList;",
                "import cn.com.agree.huanan.ap.tl.metadata.DataDictItem;",
                "import cn.com.agree.huanan.ap.tl.metadata.MetaDataUtil;",
                "",
                "/**",
                " * 数据字典",
                " * ",
                " * @author MetaDataGenerator",
                " *",
                " */",
                "public class %s {",
                "%s",
                "}",
                "",
                "",
        };
        String javaCode = String.format(String.join("\n", lineList), ddtName, ddiCode);
        return javaCode;
    }

}
