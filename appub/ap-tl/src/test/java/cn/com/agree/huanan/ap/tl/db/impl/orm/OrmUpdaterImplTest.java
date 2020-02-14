package cn.com.agree.huanan.ap.tl.db.impl.orm;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.tl.db.orm.OrmUpdater;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Updater;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

@RunWith(PowerMockRunner.class)
public class OrmUpdaterImplTest {
    
    public static class test_tab {
        
    }
    
    @Table(test_tab.class)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private int idCode;
        private String name;
    }

    @InjectMocks
    private OrmUpdater<Person> ormUpdater = new OrmUpdaterImpl<Person>(Person.class);

    private ArgumentCaptor<Map<String, Object>> captorSetInfo;
    
    @Mock
    DbOperator mockDbOper;
    @Mock
    Updater mockUpdater;
    @Mock
    WhereExp mockWhere;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void update_0() {
        // set
        int countExpect = 1;
        setMockInfo(countExpect);
        // test
        int idCode = 1;
        String name = "agree";
        int count = ormUpdater
                .set(s -> {
                    s.setIdCode(idCode);
                    s.setName(name);
                }).where(w -> {
                    w.setIdCode(idCode);
                    w.setName(name);
                })
                .execute();
        // assert
        assertThat(count, equalTo(countExpect));
        // verify
        verifyMockInfo(idCode, name);
    }

    private void setMockInfo(int count) {
        // captor
        captorSetInfo = ArgumentCaptor.forClass(Map.class);
        // set
        when(mockDbOper.getUpdater()).thenReturn(mockUpdater);
        when(mockUpdater.update(anyString())).thenReturn(mockUpdater);
        when(mockUpdater.set(anyString(), any())).thenReturn(mockUpdater);
        when(mockUpdater.set(anyMap())).thenReturn(mockUpdater);
        when(mockUpdater.where(any())).thenAnswer(invocation -> {
            Consumer<WhereExp> consumer = invocation.getArgument(0);
            consumer.accept(mockWhere);
            return mockUpdater;
        });
        when(mockUpdater.execute()).thenReturn(count);
    }
    
    private void verifyMockInfo(int idCode, String name) {
        // verify
        verify(mockUpdater).update("test_tab");
        verify(mockUpdater).set(captorSetInfo.capture());
        verify(mockUpdater).where(any());
        verify(mockUpdater).execute();
        verify(mockWhere).eq("idCode", idCode);
        verify(mockWhere).eq("name", name);
        // assert
        Map<String, Object> setInfo = asMap("idCode", idCode, "name", name);
        assertThat(captorSetInfo.getValue(), equalTo(setInfo));
    }

    private Map<String, Object> asMap(Object... kvPairs) {
        Map<String, Object> data = new LinkedHashMap<>();
        for (int i = 0; i <= kvPairs.length / 2; i += 2) {
            data.put((String) kvPairs[i], kvPairs[i + 1]);
        }
        return data;
    }
}
