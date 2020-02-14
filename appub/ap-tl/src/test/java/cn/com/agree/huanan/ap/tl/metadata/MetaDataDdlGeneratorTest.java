package cn.com.agree.huanan.ap.tl.metadata;

import cn.com.agree.huanan.ap.tl.config.ApTlBaseConfig;
import cn.com.agree.huanan.ap.tl.config.ApTlDdlConfig;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.ReflectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author JUN
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        ReflectionUtil.class
})
public class MetaDataDdlGeneratorTest {
    @InjectMocks
    private MetaDataDdlGenerator generator;
    @Mock
    private Logger logger;

    @Mock
    private ApTlBaseConfig baseConfig;

    @Mock
    private ApTlDdlConfig ddlConfig;


    @Before
    public void setUp(){
        mockStatic(ReflectionUtil.class);
        MockitoAnnotations.initMocks(this);

        doNothing().when(logger).info(anyString());
        doNothing().when(logger).debug(anyString());
        doNothing().when(logger).error(anyString());
//        doNothing().when(ReflectionUtil.scanSubTypeList("",any(),any()));
    }

    @Test
    public void testProcDdl(){
        generator.procDdl("", new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {

            }
        });

//        verify(ReflectionUtil.scanSubTypeList("",any(),any()));
    }


//    @Test
//    public void testGenTableSql(){
//        AbstractDataTable table;
//        AbstractDataTable.DataTableBuilder builder;
//        Consumer<List<DataDictItem>> fieldConsumer = new Consumer<List<DataDictItem>>() {
//            @Override
//            public void accept(List<DataDictItem> dataDictItems) {
//
//            }
//        };
//        Consumer<List<DataDictItem>> pkConsumer = new Consumer<List<DataDictItem>>() {
//            @Override
//            public void accept(List<DataDictItem> dataDictItems) {
//
//            }
//        };
//        builder = new AbstractDataTable.DataTableBuilder();
//        builder.setDataTabSpace("xxx");
//        builder.setTabComment("xxx");
//        builder.setIndexTabSpace("xxx");
//        builder.setFieldsList(fieldConsumer);
//        builder.setPrimaryKey(pkConsumer);
//        table = new AbstractDataTable(builder){
//            @Override
//            public String getTabName() {
//                return super.getTabName();
//            }
//
//            @Override
//            public String getTabComment() {
//                return super.getTabComment();
//            }
//
//            @Override
//            public String getDataTabSpace() {
//                return super.getDataTabSpace();
//            }
//
//            @Override
//            public String getIndexTabSpace() {
//                return super.getIndexTabSpace();
//            }
//
//            @Override
//            public List<DataDictItem> getFieldsList() {
//                return super.getFieldsList();
//            }
//
//            @Override
//            public DataTableIndex getPrimaryKey() {
//                return super.getPrimaryKey();
//            }
//
//            @Override
//            public List<? extends DataTableIndex> getIndexesList() {
//                return super.getIndexesList();
//            }
//        };
////        generator.genTableSql(table);
//    }

}


