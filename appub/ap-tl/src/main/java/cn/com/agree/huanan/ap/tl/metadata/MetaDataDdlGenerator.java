package cn.com.agree.huanan.ap.tl.metadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.config.ApTlBaseConfig;
import cn.com.agree.huanan.ap.tl.config.ApTlDdlConfig;
import cn.com.agree.huanan.ap.tl.db.base.DbType;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueMissException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueRepeatException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.ReflectionUtil;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

@Component
public class MetaDataDdlGenerator {
    @Autowired
    private Logger logger;
    
    @Autowired
    private ApTlBaseConfig baseConfig;
    
    @Autowired
    private ApTlDdlConfig ddlConfig;

    /** 表名规则 */
    private Pattern tabNamePattern;

    /** 列名规则 */
    private Pattern colNamePattern;

    @PostConstruct
    private void init() {
        tabNamePattern = Pattern.compile(ddlConfig.getTabNameRegex());
        colNamePattern = Pattern.compile(ddlConfig.getColNameRegex());
    }
    
    public void procDdl(String alId, BiConsumer<String, String> sqlCodeHandler) {
        logger.info("处理DDL");
        ReflectionUtil.scanSubTypeList("cn.com.agree.huanan.ap.al.APTL.ddl", DataTable.class, tabType -> {
            DataTable tab = ReflectionUtil.newInstance(tabType);
            logger.info("proc table: %s", tab.getTabName());
            String tabSql = genTableSql(tab);
            //logger.info("\n%s", tabSql);
            String path = String.format(ddlConfig.getSqlFilePathFormat(), tab.getTabName());
            sqlCodeHandler.accept(path, tabSql);
        });
    }

    private String genTableSql(DataTable tab) {
        // 校验表名
        validateId(tab.getTabName(), tabNamePattern);
        // 获取主键
        List<DataDictItem> pkFieldsList = tab.getPrimaryKey().getFieldsList();
        // 处理字段列表
        checkFieldsRepeat(tab.getFieldsList());
        StringJoiner fieldsDefineSqlList = new StringJoiner(",\n");
        StringJoiner fieldsCommentSqlList = new StringJoiner("\n");
        tab.getFieldsList().forEach(field -> {
            // 主键字段则强制NOT NULL
            boolean forceNotNull = pkFieldsList.contains(field);
            // 校验字段名
            validateId(field.getName(), colNamePattern);
            // 字段定义
            String fieldDefineSql = getFieldDefineSql(field, forceNotNull);
            fieldsDefineSqlList.add(fieldDefineSql);
            // 字段描述
            String fieldCommentSql = getFieldDefineCommentSql(tab.getTabName(), field);
            fieldsCommentSqlList.add(fieldCommentSql);
        });
        // 表空间
        String tabSpaceSql = getTabSpaceSql(tab);
        // 主键
        String primaryKeySql = getPrimaryKeySql(tab);
        // 索引
        String indexesSql = getIndexesSql(tab);
        if (!indexesSql.isEmpty()) {
            indexesSql = "\n" + indexesSql;
        }
        // 表描述
        String tableCommentSql = getTabCommentSql(tab);
        // 格式化
        String[] fmtArray = {
                "",
                "-- %s",                // description
                "",
                "-- drop table %s;",    // -- drop table xxx
                "create table %s",      // create table xxx
                "(",
                "%s",                   // alId varchar(6),
                ")",
                "%s",                   // in TS_DAT index in TS_IDX
                ";",
                "",
                "",
                "%s",                   // primary key
                "%s",                   // index
                "",
                "%s",                   // comment on table
                "%s",                   // comment on column
                "",
        };
        Object[] argArray = {
                tab.getTabComment(),
                tab.getTabName(),
                tab.getTabName(),
                fieldsDefineSqlList.toString(),
                tabSpaceSql,
                primaryKeySql,
                indexesSql,
                tableCommentSql,
                fieldsCommentSqlList,
        };
        return String.format(String.join("\n", fmtArray), argArray);
    }

    private String getFieldDefineSql(DataDictItem field, boolean forceNotNull) {
        String typeText;
        // 检查类型
        Class<?> rawType = field.getDataType().getRawType();
        if (rawType == String.class) {
            typeText = String.format("varchar(%s)", field.getMaxLen());
        } else if (rawType == int.class) {
            typeText = isOracle() ? "number(10, 0)" : "int";
        } else if (rawType == long.class) {
            typeText = isOracle() ? "number(19, 0)" : "bigint";
        } else {
            throw new ApValueTypeUnsupportException(rawType);
        }
        String nullText = (isOracle() && !forceNotNull) ? "null" : "not null";
        String sql = String.format("    %-28s %-16s %s", field.getName(), typeText, nullText);
        return sql;
    }

    private String getFieldDefineCommentSql(String tabName, DataDictItem field) {
        String sql = String.format("comment on column %s.%-28s is '%s';", tabName, field.getName(),
                field.getCnName());
        return sql;
    }

    private String getTabCommentSql(DataTable tab) {
        String sql = String.format("comment on table  %s %-28s is '%s';", tab.getTabName(),
                "", tab.getTabComment());
        return sql;
    }

    private String getDataTabSpace(DataTable tab) {
        return StrUtil.orElse(tab.getDataTabSpace(), ddlConfig.getDefDataTabSpace());
    }

    private String getIndexTabSpace(DataTable tab) {
        return StrUtil.orElse(tab.getIndexTabSpace(), ddlConfig.getDefIndexTabSpace());
    }

    private String getTabSpaceSql(DataTable tab) {
        if (isOracle()) {
            return String.format("tablespace %s", getDataTabSpace(tab));
        } else {
            return String.format("in %s\nindex in %s", getDataTabSpace(tab),
                    getIndexTabSpace(tab));
        }
    }

    private String getPrimaryKeySql(DataTable tab) {
        String sql = String.format("-- alter table %s drop constraint %s_pk;\n",
                tab.getTabName(), tab.getTabName());
        List<DataDictItem> pkFieldsList = tab.getPrimaryKey().getFieldsList();
        if (pkFieldsList.isEmpty()) {
            logger.error("主键字段不能为空");
            throw new ApValueMissException("primary key fields");
        }
        String fieldsText = joinFieldsList(tab, pkFieldsList);
        if (isOracle()) {
            sql += String.format(
                    "alter table %s add constraint %s_pk primary key (%s) using index tablespace %s;",
                    tab.getTabName(), tab.getTabName(), fieldsText,
                    getIndexTabSpace(tab));
        } else {
            sql += String.format("alter table %s add constraint %s_pk primary key (%s);",
                    tab.getTabName(), tab.getTabName(), fieldsText);
        }
        return sql;
    }

    private String getIndexesSql(DataTable tab) {
        StringJoiner sqlJoinner = new StringJoiner("\n");
        int tabIndexNo = 0;
        for (DataTableIndex tabIndex : tab.getIndexesList()) {
            // 累加序号
            tabIndexNo++;
            // 索引名称
            String tabIndexName = String.format("%s_idx%s", tab.getTabName(), tabIndexNo);
            // 字段列表
            List<DataDictItem> indexFielsList = tabIndex.getFieldsList();
            if (indexFielsList.isEmpty()) {
                break;
            }
            // 注释
            sqlJoinner.add(String.format("-- drop index %s;", tabIndexName));
            // 唯一
            String uniqueText = tabIndex.isUnique() ? "unique " : "";
            // 字段列表
            String fieldsText = joinFieldsList(tab, indexFielsList);
            if (isOracle()) {
                sqlJoinner.add(String.format("create %sindex %s on %s (%s) tablespace %s;",
                        uniqueText, tabIndexName, tab.getTabName(), fieldsText,
                        getIndexTabSpace(tab)));
            } else {
                sqlJoinner.add(String.format("create %sindex %s on %s (%s);", uniqueText,
                        tabIndexName, tab.getTabName(), fieldsText));
            }
            sqlJoinner.add("");
        }
        return sqlJoinner.toString();
    }

    private boolean isOracle() {
        return baseConfig.getDbType() == DbType.ORACLE;
    }

    private void validateId(String idValue, Pattern idPattern) {
        if (!idPattern.matcher(idValue).matches()) {
            logger.error("值检查不通过：[%s] [%s]", idValue, idPattern);
            throw new ApValueOutOfRangeException(idValue);
        }
    }

    private void checkFieldsRepeat(List<DataDictItem> fieldsList) {
        // 分组
        Map<DataDictItem, Long> groupInfo = fieldsList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        // 收集重复字段名
        List<String> repeatList = groupInfo.entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey().getCnName()).collect(Collectors.toList());
        // 报错
        if (!repeatList.isEmpty()) {
            logger.error("字段重复定义");
            String repeatText = String.join(", ", repeatList);
            throw new ApValueRepeatException(repeatText);
        }
    }

    private String joinFieldsList(DataTable tab, List<DataDictItem> fieldsList) {
        // 检查字段重复
        checkFieldsRepeat(fieldsList);
        // 处理字段未定义
        List<DataDictItem> fieldsListCopy = new ArrayList<>(fieldsList);
        fieldsListCopy.removeAll(tab.getFieldsList());
        if (!fieldsListCopy.isEmpty()) {
            logger.error("字段超出定义列表");
            String repeatText = fieldsListCopy.stream().map(e -> e.getName())
                    .collect(Collectors.joining(", "));
            throw new ApValueOutOfRangeException(repeatText);
        }
        // 连接字段
        return fieldsList.stream().map(e -> e.getName()).collect(Collectors.joining(", "));
    }
}
