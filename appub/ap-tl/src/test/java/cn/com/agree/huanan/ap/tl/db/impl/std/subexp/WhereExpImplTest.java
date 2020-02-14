package cn.com.agree.huanan.ap.tl.db.impl.std.subexp;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;

public class WhereExpImplTest {

    private WhereExp getInstance() {
        return new WhereExpImpl();
    }

    @Test
    public void getExpItemCount_0() {
        // init
        WhereExp w = getInstance();
        // execute
        // collect
        int count = w.getExpItemCount();
        // assert
        assertThat(count, equalTo(0));
    }

    @Test
    public void getExpItemCount_1() {
        // init
        WhereExp w = getInstance();
        // execute
        w.eq("name", "china");
        // collect
        int count = w.getExpItemCount();
        // assert
        assertThat(count, equalTo(1));
    }

    @Test
    public void getExpItemCount_N() {
        // init
        WhereExp w = getInstance();
        // execute
        int N = 10;
        for (int i = 0; i < N; i++) {
            w.eq("name", "china");
        }
        // collect
        int count = w.getExpItemCount();
        // assert
        assertThat(count, equalTo(N));
    }

    @Test
    public void op_withoutParams() {
        // init
        WhereExp w = getInstance();
        // execute
        w.op("name", "!=", "china");
        // collect
        List<Object> sqlParams = null;
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name != 'china'"));
    }

    @Test
    public void op_withParams() {
        // init
        WhereExp w = getInstance();
        // execute
        w.op("name", "!=", "china");
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name != ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china")));
    }

    @Test
    public void eq_withParams() {
        // init
        WhereExp w = getInstance();
        // execute
        w.eq("name", "china");
        w.eq("province", "guangdong");
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name = ? and province = ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china", "guangdong")));
    }

    @Test
    public void between_toEq() {
        // init
        WhereExp w = getInstance();
        // execute
        w.between("name", "china", "china");
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name = ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china")));
    }

    @Test
    public void between_withParams() {
        // init
        WhereExp w = getInstance();
        // execute
        w.between("name", "china", "india");
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name between ? and ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china", "india")));
    }

    @Test
    public void in_toEq() {
        // init
        WhereExp w = getInstance();
        // execute
        w.in("name", "china");
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name = ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china")));
    }

    @Test
    public void in_withParams() {
        // init
        WhereExp w = getInstance();
        // execute
        w.in("name", "china", "india");
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name in (?, ?)"));
        assertThat(sqlParams, equalTo(Arrays.asList("china", "india")));
    }

    @Test
    public void eqAll_withParams() {
        // init
        WhereExp w = getInstance();
        // execute
        Map<String, Object> kvInfo = new LinkedHashMap<>();
        kvInfo.put("name", "china");
        kvInfo.put("province", "guangdong");
        w.eqAll(kvInfo);
        // collect
        List<Object> sqlParams = new ArrayList<Object>();
        String sql = w.getExp(sqlParams);
        // assert
        assertThat(sql, equalTo("name = ? and province = ?"));
        assertThat(sqlParams, equalTo(Arrays.asList("china", "guangdong")));
    }
}
