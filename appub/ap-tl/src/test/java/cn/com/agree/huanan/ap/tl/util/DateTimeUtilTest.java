package cn.com.agree.huanan.ap.tl.util;

import static org.junit.Assert.*;

import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaot
 *
 */
@RunWith(PowerMockRunner.class)
public class DateTimeUtilTest {

    @Rule
    protected ExpectedException thrown= ExpectedException.none();

    @Test
    public void testChkDateIN(){
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(dt.getTime()-1);

        boolean actual = DateTimeUtil.chkDateIN(date,date,"",1,"yyyyMMdd");
        Assert.assertEquals(true,actual);
        actual = DateTimeUtil.chkDateIN(date,date,"",2,"yyyyMMdd");
        Assert.assertEquals(false,actual);
        actual = DateTimeUtil.chkDateIN(date,date,"",3,"yyyyMMdd");
        Assert.assertEquals(false,actual);
        actual = DateTimeUtil.chkDateIN(date, date, "", 4, "yyyyMMdd");
        Assert.assertEquals(false,actual);
        thrown.expect(ApIllegalParamException.class);
        DateTimeUtil.chkDateIN(date, date, "", 5, "yyyyMMdd");
//        System.out.println(actual);

    }


    @Test
    public void testGetDayOfMonth(){
        int actual = DateTimeUtil.getDayOfMonth(2018,11);
        Assert.assertEquals(30,actual);
    }


    @Test
    public void testGetTotal(){
        DateTimeUtil.getTotal("");
        long actual = DateTimeUtil.getTotal("20181107");
        Assert.assertEquals(17843,actual);
    }

    @Test
    public void testChkTimeIN(){
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(dt);

        boolean actual = DateTimeUtil.chkTimeIN(date,date,date,1,"");
        Assert.assertEquals(true,actual);
        actual = DateTimeUtil.chkTimeIN(date, date, date, 1, "HHmmss");
        Assert.assertEquals(true,actual);
    }


    @Test
    public void testGetTimeDelta(){
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(dt);

        Long actual = DateTimeUtil.getTimeDelta(date,date,"s");
        actual = DateTimeUtil.getTimeDelta(date,date,"d");

        sdf = new SimpleDateFormat("yyyyMMdd");
        date = sdf.format(dt);
        actual = DateTimeUtil.getTimeDelta(date,date,"s");

        thrown.expect(ApIllegalParamException.class);
        DateTimeUtil.getTimeDelta(date,"","y");


    }


    @Test
    public void testAddTimeByHour() throws ParseException {

        Date date = new Date();
        String fmt = "yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String datetime = sdf.format(date);
        long tmp = sdf.parse(datetime).getTime();
        tmp +=  (1 * 60 * 60 * 1000);
        String expected = sdf.format(new Date(tmp));
        String actual = DateTimeUtil.addTimeByHour(datetime,1);

        Assert.assertEquals(actual,expected);


        thrown.expect(ApIllegalParamException.class);
        DateTimeUtil.addTimeByHour(null,1);


    }


    @Test
    public void testCalculateTime() throws ParseException {
        String fmt = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String sDate = sdf.format(new Date());
        long now = sdf.parse(sDate).getTime();
        now += (1 * 24 * 60 * 60 * 1000);
        Date date = new Date(now);
        String expected = sdf.format(date);
        String actual = DateTimeUtil.calculateTime(sDate,1);

        Assert.assertEquals(expected,actual);
        thrown.expect(ApIllegalParamException.class);
        DateTimeUtil.calculateTime(null,1);


    }



    @Test
    public void test_addTimeByMonth(){

        String actual = DateTimeUtil._addTimeByMonth("20161232",1);
        Assert.assertEquals("20170131",actual);
        DateTimeUtil._addTimeByMonth("20180101",1);
        thrown.expect(ApIllegalParamException.class);
        DateTimeUtil._addTimeByMonth(null,1);
    }


    @Test
    public void testConvertDateFormat(){

        String actual = DateTimeUtil.convertDateFormat("20181108", "", "");
        Assert.assertEquals("20181108",actual);
    }



//    @test


    /**
     * 案例： 开始日期和结束日期为同一天，业务日期获取系统时间 flag: 1 开始时间=<当前时间<=结束时间
     */
    /*@Test
    public void chkDateIN_1() {

        assertEquals(DateTimeUtil.chkDateIN("20180817000000", "20180817230000", "", 1, ""), false);
        assertEquals(
                DateTimeUtil.chkDateIN("20180817000000", "20180817230000", "20180817240000", 1, ""),
                false);
    }*/

   /* *//**
     * 案例： 开始日期和结束日期为同一天，业务日期为入参 flag: 1 开始时间=<当前时间<=结束时间
     *//*
    @Test
    public void chkDateIN_2() {

        assertEquals(
                DateTimeUtil.chkDateIN("20180817000000", "20180817230000", "20180817240000", 1, ""),
                false);
    }

    *//**
     * 案例：
     *
     *//*
    @Test
    public void isHoliday_1() {

        //assertEquals(DateTimeUtil.chkDateIN("20180817000000", "20180817230000", "20180817240000", 1, ""),false);
    }

    *//**
     * 案例：
     *
     *//*
    @Test
    public void chkTimeIN_1() {

        assertEquals(DateTimeUtil.chkTimeIN("090000", "100000", "095959", 1,""),true);
    }

    *//**
     * 案例：边界值
     * 测试10点是不是在090000-1000000区间
     *//*
    @Test
    public void chkTimeIN_2() {

        assertEquals(DateTimeUtil.chkTimeIN("090000", "100000", "090000",1, ""),true);
    }*/
}
