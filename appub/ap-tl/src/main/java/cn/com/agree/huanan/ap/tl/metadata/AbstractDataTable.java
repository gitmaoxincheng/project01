package cn.com.agree.huanan.ap.tl.metadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 数据表（抽象）
 * 
 * @author tan.ch
 *
 */
public abstract class AbstractDataTable implements DataTable {
    /**
     * 数据表构造器
     * 
     * @author tan.ch
     *
     */
    protected static class DataTableBuilder {
        private String tabComment;
        private String dataTabSpace;
        private String indexTabSpace;
        private List<DataDictItem> fieldsList = new ArrayList<>();
        private DataTableIndex primaryKey;
        private List<DataTableIndex> indexesList = new ArrayList<>();

        public DataTableBuilder() {
        }

        public DataTableBuilder setTabComment(String tabComment) {
            this.tabComment = tabComment;
            return this;
        }

        public DataTableBuilder setDataTabSpace(String dataTabSpace) {
            this.dataTabSpace = dataTabSpace;
            return this;
        }

        public DataTableBuilder setIndexTabSpace(String indexTabSpace) {
            this.indexTabSpace = indexTabSpace;
            return this;
        }

        public DataTableBuilder setFieldsList(Consumer<List<DataDictItem>> consumer) {
            consumer.accept(fieldsList);
            return this;
        }

        public DataTableBuilder setPrimaryKey(Consumer<List<DataDictItem>> consumer) {
            List<DataDictItem> pkFieldsList = new ArrayList<>();
            consumer.accept(pkFieldsList);
            primaryKey = DefaultDataTableIndex.ofPrimaryKey(pkFieldsList);
            return this;
        }

        public DataTableBuilder addIndex(boolean isUnique,
                Consumer<List<DataDictItem>> consumer) {
            List<DataDictItem> fl = new ArrayList<>();
            consumer.accept(fl);
            if (!fl.isEmpty()) {
                indexesList.add(DefaultDataTableIndex.ofIndex(isUnique, fl));
            }
            return this;
        }
    }

    protected static DataTableBuilder getBuilder() {
        return new DataTableBuilder();
    }

    private final String tabName;
    private final String tabComment;
    private final String dataTabSpace;
    private final String indexTabSpace;
    private final List<DataDictItem> fieldsList;
    private final DataTableIndex primaryKey;
    private final List<? extends DataTableIndex> indexesList;

    /**
     * 构造方法
     * 
     * @param builder 生成器
     */
    protected AbstractDataTable(DataTableBuilder builder) {
        this.tabName = initTabName();
        this.tabComment = builder.tabComment;
        this.dataTabSpace = builder.dataTabSpace;
        this.indexTabSpace = builder.indexTabSpace;
        this.fieldsList = builder.fieldsList;
        this.primaryKey = builder.primaryKey;
        this.indexesList = builder.indexesList;
    }

    @Override
    public String getTabName() {
        return tabName;
    }

    @Override
    public String getTabComment() {
        return tabComment;
    }

    @Override
    public String getDataTabSpace() {
        return dataTabSpace;
    }

    @Override
    public String getIndexTabSpace() {
        return indexTabSpace;
    }

    @Override
    public List<DataDictItem> getFieldsList() {
        return fieldsList;
    }

    @Override
    public DataTableIndex getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public List<? extends DataTableIndex> getIndexesList() {
        return indexesList;
    }

    private String initTabName() {
        return getClass().getSimpleName().toLowerCase();
    }
}
