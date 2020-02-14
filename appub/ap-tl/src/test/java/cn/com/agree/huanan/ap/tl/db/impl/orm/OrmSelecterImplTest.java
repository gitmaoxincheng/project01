package cn.com.agree.huanan.ap.tl.db.impl.orm;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
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
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

@RunWith(PowerMockRunner.class)
public class OrmSelecterImplTest {
    
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

    private static final String[] personFieldList = new String[] {
            "idCode",
            "name"
    };

    @InjectMocks
    private OrmSelecter<Person> ormSelecter = new OrmSelecterImpl<Person>(Person.class);
    
    private ArgumentCaptor<String> captorSelectList;
    
    @Mock
    DbOperator mockDbOper;
    @Mock
    Selecter mockSelecter;
    @Mock
    WhereExp mockWhere;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetch0_return_empty() {
        // set
        setMockInfo(Collections.emptyList());
        // test
        int idCode = 1;
        String name = "agree";
        List<Person> personList = ormSelecter.where(w -> {
            w.setIdCode(idCode);
            w.setName(name);
        })
        .orderBy(o -> {
            o.getIdCode();
            o.getName();
        })
        .fetch(0);
        // assert
        assertThat(personList, sameInstance(Collections.emptyList()));
        // verify
        verifyMockInfo(idCode, name);
    }

    @Test
    public void fetch0_return_2() {
        // set
        List<Person> personList = Arrays.asList(new Person(1, "agree1"), new Person(2, "agree2"));
        List<Map<String, Object>> rowSet = Arrays.asList(
                asMap("name", personList.get(0).getName(), "idCode", personList.get(0).getIdCode()),
                asMap("name", personList.get(1).getName(), "idCode", personList.get(1).getIdCode()));
        setMockInfo(rowSet);
        // test
        int idCode = 1;
        String name = "agree";
        List<Person> actualPersonalList = ormSelecter.where(w -> {
            w.setIdCode(idCode);
            w.setName(name);
        })
        .orderBy(o -> {
            o.getIdCode();
            o.getName();
        })
        .fetch(0);
        // assert
        assertThat(actualPersonalList, equalTo(personList));
        // verify
        verifyMockInfo(idCode, name);
    }
    
    private void setMockInfo(List<Map<String, Object>> rowSet) {
        // captor
        captorSelectList = ArgumentCaptor.forClass(String.class);
        // set
        when(mockDbOper.getSelecter()).thenReturn(mockSelecter);
        when(mockSelecter.select(any(String.class))).thenReturn(mockSelecter);
        when(mockSelecter.from(anyString())).thenReturn(mockSelecter);
        when(mockSelecter.where(any())).thenAnswer(invocation -> {
            Consumer<WhereExp> consumer = invocation.getArgument(0);
            consumer.accept(mockWhere);
            return mockSelecter;
        });
        when(mockSelecter.orderBy(anyList())).thenReturn(mockSelecter);
        when(mockSelecter.fetch(anyInt())).thenReturn(rowSet);
    }
    
    private void verifyMockInfo(int idCode, String name) {
        // verify
        verify(mockSelecter).select(captorSelectList.capture());
        verify(mockSelecter).from("test_tab");
        verify(mockSelecter).where(any());
        verify(mockSelecter).orderBy(Arrays.asList("idCode", "name"));
        verify(mockSelecter).fetch(0);
        verify(mockWhere).eq("idCode", idCode);
        verify(mockWhere).eq("name", name);
        
        assertSelectList(captorSelectList.getAllValues());
    }

    private Map<String, Object> asMap(Object... kvPairs) {
        Map<String, Object> data = new LinkedHashMap<>();
        for (int i = 0; i <= kvPairs.length / 2; i += 2) {
            data.put((String) kvPairs[i], kvPairs[i + 1]);
        }
        return data;
    }

    private void assertSelectList(List<String> actual) {
        // select无序
        assertThat(Arrays.asList(personFieldList),
                containsInAnyOrder(actual.toArray(new String[actual.size()])));
    }
}
