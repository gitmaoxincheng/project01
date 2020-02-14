package cn.com.agree.huanan.ap.tl.metadata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author JUN
 */
public class AbstractDataTableTest {
    AbstractDataTable table;
    AbstractDataTable.DataTableBuilder builder;
    Consumer<List<DataDictItem>> fieldConsumer = new Consumer<List<DataDictItem>>() {
        @Override
        public void accept(List<DataDictItem> dataDictItems) {

        }
    };

    Consumer<List<DataDictItem>> pkConsumer = new Consumer<List<DataDictItem>>() {
        @Override
        public void accept(List<DataDictItem> dataDictItems) {

        }
    };



    @Before
    public void setUp(){
        builder = new AbstractDataTable.DataTableBuilder();
        builder.setDataTabSpace("xxx");
        builder.setTabComment("xxx");
        builder.setIndexTabSpace("xxx");
        builder.setFieldsList(fieldConsumer);
        builder.setPrimaryKey(pkConsumer);
        table = new AbstractDataTable(builder){
            @Override
            public String getTabName() {
                return super.getTabName();
            }

            @Override
            public String getTabComment() {
                return super.getTabComment();
            }

            @Override
            public String getDataTabSpace() {
                return super.getDataTabSpace();
            }

            @Override
            public String getIndexTabSpace() {
                return super.getIndexTabSpace();
            }

            @Override
            public List<DataDictItem> getFieldsList() {
                return super.getFieldsList();
            }

            @Override
            public DataTableIndex getPrimaryKey() {
                return super.getPrimaryKey();
            }

            @Override
            public List<? extends DataTableIndex> getIndexesList() {
                return super.getIndexesList();
            }
        };
    }

    @Test
    public void testSet(){

        Assert.assertEquals("xxx",table.getDataTabSpace());
        Assert.assertEquals("xxx",table.getTabComment());
        Assert.assertEquals("xxx", table.getIndexTabSpace());
        Assert.assertEquals(0,table.getFieldsList().size());
    }

}


