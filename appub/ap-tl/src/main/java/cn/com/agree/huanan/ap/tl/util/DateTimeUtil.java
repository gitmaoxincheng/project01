package cn.com.agree.huanan.ap.tl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;

/**
 * @author xiaot 日期操作类
 */
@Component
public class DateTimeUtil {

    /**
     * 数据库查询器
     */
    @Autowired
    public Selecter selecter;

    /**
     * @param fmt 格式化
     * @return 日期
     */
    public static String getSysDateTime(String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Calendar calendar = Calendar.getInstance();
        String datetime = sdf.format(calendar.getTime());
        return datetime;
    }

    /**
     * @param fmt 格式化
     * @return 日期
     */
    public static String getSysDateTime() {
        return getSysDateTime("yyyyMMdd");
    }
    
    /**
     * 获取系统日期
     *
     * @return 格式为"yyyyMMdd"的系统日期
     */
    public static String getSysDate() {
        return getSysDateTime("yyyyMMdd");
    }

    /**
     * 获取系统日期
     *
     * @return 格式为"yyMMdd"的系统日期
     */
    public static String getCSysDate() {
        return getSysDateTime("yyMMdd");
    }


    /**
     * @param fmt  日期格式
     * @param days
     * @return
     */
    public static String getSysDateTime(String fmt, int days) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        Date date = cal.getTime();
        String dateStr = sdf.format(date);
        return dateStr;
    }


    /**
     * 获取系统时间
     *
     * @return 格式为"HHmmss"的系统时间
     */
    public static String getSysTime() {
        return getSysDateTime("HHmmss");
    }
    
    /**
     * 获取系统时间
     *
     * @return 格式为"HHmmss"的系统时间
     */
    public static String getCSysTime() {
        return getSysDateTime("yyMMddHHmmss");
    }
    

    /**
     * 获取时间差(秒)
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param retFlag   时间单位: "s"为"秒", "d"为"天"
     * @return 时间差
     */
    public static Long getTimeDelta(String beginTime, String endTime, String retFlag) {
        String fmt = "yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date beginDate = null;
        Date endDate = null;
        try {
            if (endTime == null || "".equals(endTime)) {
                endTime = getSysDateTime(fmt);
            }
            if (beginTime.length() == 8) {
                beginTime = beginTime + "000000";
            }
            if (endTime.length() == 8) {
                endTime = endTime + "000000";
            }
            beginDate = sdf.parse(beginTime);
            endDate = sdf.parse(endTime);
        } catch (ParseException e) {

            throw new ApIllegalParamException(String.format("非法入参"));
        }
        long diff = (endDate.getTime() - beginDate.getTime()) / 1000;

        if (retFlag.equals("s")) {

        } else if (retFlag.equals("d")) {
            diff = diff / 60 / 60 / 24;

        } else {

            throw new ApIllegalParamException(String.format("入参非法：%s", retFlag));
        }
        if (diff < 1) {
            diff = 0;
        }
        return diff;
    }

    /**
     * 添加时间(小时)
     *
     * @param datetime 源时间，格式为"yyyyMMddHHmmss"
     * @param hours    添加的小时
     * @return result 添加后的时间，格式为"yyyyMMddHHmmss"
     * @throws ParseException 解析异常
     */
    public static String addTimeByHour(String datetime, Integer hours) throws ParseException {
        if (datetime == null) {

            throw new ApIllegalParamException(String.format("入参非法：%s", datetime));

        }
        String fmt = "yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        long now = sdf.parse(datetime).getTime();
        now += (hours * 60 * 60 * 1000);
        Date date = new Date(now);
        String result = sdf.format(date);
        return result;
    }

    /**
     * 添加时间(日)
     *
     * @param sDate 源日期，格式为"yyyyMMdd"
     * @param sDays 添加的天数
     * @return 日期
     * @throws ParseException 解析异常
     */
    public static String calculateTime(String sDate, long sDays) throws ParseException {
        if (sDate == null) {

            throw new ApIllegalParamException(String.format("入参非法：%s", sDate));

        }
        String fmt = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        long now = sdf.parse(sDate).getTime();
        now += (sDays * 24 * 60 * 60 * 1000);
        Date date = new Date(now);
        String result = sdf.format(date);
        return result;
    }

    /**
     * 添加时间(月份)
     *
     * @param date   源日期，格式为"yyyyMMdd"
     * @param months 添加的月份
     * @return 日期
     */
    public static String _addTimeByMonth(String date, Integer months) {
        if (date == null) {

            throw new ApIllegalParamException(String.format("入参非法：%s", date));
        }
        int[] nDayInMonth = {
                31,
                28,
                31,
                30,
                31,
                30,
                31,
                31,
                30,
                31,
                30,
                31
        };
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(4, 6));
        int day = Integer.valueOf(date.substring(6, 8));
        int tmpY = year;
        int mm = Integer.valueOf(months);
        if (month == 12 || month + mm > 12) {
            year = year + 1;
            month = month - 12 + mm;
        } else {
            month = month + mm;
        }

        if (day > nDayInMonth[month - 1]) {
            day = nDayInMonth[month - 1];
            if (month == 2 && (tmpY % 400 == 0 || (tmpY % 4 == 0 && tmpY % 100 != 0))) {
                day = nDayInMonth[month - 1] + 1;
            }
        }
        String sEndDate = String.valueOf(year) + String.format("%02d", month)
                + String.format("%02d", day);
        return sEndDate;
    }

    /**
     * 转换日期格式
     *
     * @param src       需要转换格式的日期时间
     * @param srcFormat 源日期格式，默认为"yyyyMMdd"
     * @param dstFormat 目标日期格式，默认为"yyyyMMdd"
     * @return 日期
     */
    public static String convertDateFormat(String src, String srcFormat, String dstFormat) {
        if (srcFormat == null || "".equals(srcFormat)) {
            srcFormat = "yyyyMMdd";
        }
        if (dstFormat == null || "".equals(dstFormat)) {
            dstFormat = "yyyyMMdd";
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat(srcFormat);
        SimpleDateFormat sdf2 = new SimpleDateFormat(dstFormat);
        Date date = null;
        String datetime = null;
        try {
            date = sdf1.parse(src);
            datetime = sdf2.format(date);
        } catch (ParseException e) {

            throw new ApIllegalParamException(String.format("入参非法：%s", src));
        }
        return datetime;
    }

    /**
     * 获取历史日期
     *
     * @param day 设置day天
     * @return 日期
     */
    public static String getHisDate(int day) {

        //获取日历
        Calendar calendar = Calendar.getInstance();
        //根据频率，获取之前的日期
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        return sdf.format(calendar.getTime());
    }

    /**
     * isPrimeYear TODO 判断该年是不是
     *
     * @param year 年
     * @return boolean
     */
    public static boolean isNotPrimeYear(int year) {
        return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
    }

    /**
     * getDayOfMonth TODO 返回当月多少天
     *
     * @param year  年份
     * @param month 月份
     * @return int
     */
    public static int getDayOfMonth(int year, int month) {
        int[] days = {
                0,
                31,
                28,
                31,
                30,
                31,
                30,
                31,
                31,
                30,
                31,
                30,
                31
        };
        return isNotPrimeYear(year) && month == 2 ? days[month] + 1 : days[month];
    }

    /**
     * @param date 日期
     * @return 总共时间
     */
    public static long getTotal(String date) {
        int year;
        int month;
        int day;

        if (date == null || date.isEmpty()) {
            Calendar cld = Calendar.getInstance();
            year = cld.get(Calendar.YEAR);// 当前年数
            month = cld.get(Calendar.MONTH);// 当前月数
            day = cld.get(Calendar.DAY_OF_MONTH);// 当前天数
        } else {
            try {
                year = Integer.valueOf(date.substring(0, 4));
                month = Integer.valueOf(date.substring(4, 6));
                day = Integer.valueOf(date.substring(6, 8));
            } catch (Exception e) {

                throw new ApIllegalParamException(String.format("入参非法：%s", date));
            }

        }
        long sum = 0;
        for (int index = 1970; index < year; index++) {
            sum += 365;
            if (isNotPrimeYear(index))
                sum++;
        }
        for (int index = 0; index < month; index++) {
            sum += getDayOfMonth(year, index);
        }

        return sum + day;
    }

    /**
     * 判断业务日期是否在开始日期和结束日期之间
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @param busiDate  业务日期
     * @param flag      标识 flag: 1 开始时间=<当前时间<=结束时间 flag: 2 开始时间<当前时间<结束时间 flag: 3
     *                  开始时间<=当前时间<结束时间 flag: 4 开始时间<当前时间<=结束时间
     * @param fmt       日期格式
     * @return 检查结果
     */
    public static boolean chkDateIN(String beginDate, String endDate, String busiDate, int flag,
                                    String fmt) {
        if (fmt == null || fmt.isEmpty()) {
            fmt = "yyyyMMddHHmmss";
        }
        if (busiDate == null || busiDate.isEmpty()) {
            busiDate = getSysDateTime(fmt);
        }
        long begingTime = getTimestamp(beginDate, fmt);
        long endTime = getTimestamp(endDate, fmt);
        long currentTime = getTimestamp(busiDate, fmt);
        boolean ret = false;
        switch (flag) {
            case 1:
                if (begingTime <= currentTime && currentTime <= endTime) {
                    ret = true;
                }
                break;
            case 2:
                if (begingTime < currentTime && currentTime < endTime) {
                    ret = true;
                }
                break;
            case 3:
                if (begingTime <= currentTime && currentTime < endTime) {
                    ret = true;
                }
                break;
            case 4:
                if (begingTime < currentTime && currentTime <= endTime) {
                    ret = true;
                }
                break;

            default:
                throw new ApIllegalParamException(String.format("入参非法：flag %d", flag));
        }

        return ret;
    }

    /**
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param chkTime   业务时间
     * @param flag      标识 flag: 1 开始时间=<当前时间<=结束时间 flag: 2 开始时间<当前时间<结束时间 flag: 3
     *                  开始时间<=当前时间<结束时间 flag: 4 开始时间<当前时间<=结束时间
     * @param fmt       格式
     * @return 结果
     */
    public static boolean chkTimeIN(String beginTime, String endTime, String chkTime, int flag,
                                    String fmt) {

        if (fmt == null || fmt.isEmpty()) {
            fmt = "yyyyMMddHHmmss";
        } else {
            fmt = String.format("yyyyMMdd%s", fmt);
        }

        String date = getSysDate();
        return chkDateIN(String.format("%s%s", date, beginTime),
                String.format("%s%s", date, endTime), String.format("%s%s", date, chkTime), flag,
                fmt);

    }

    /**
     * @param date 日期
     * @param fmt  日期格式
     * @return 返回时间戳
     */
    public static long getTimestamp(String date, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        long timeStamp = 0;
        try {
            timeStamp = sdf.parse(date).getTime();
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            throw new ApIllegalParamException(String.format("入参非法：日期%s,日期格式%s", date, fmt));
        }
        return timeStamp;

    }

    /**
     * 节假日判断
     *
     * @param workdate 传入日期
     * @param type     类型
     * @return 是否节假日
     */
    public boolean isHoliday(String workdate, String type) {
        boolean isholiday = false;

        List<Map<String, Object>> res = selecter.select("HOLIDAYFLAG").from("T_HOLIDAY").where(w -> {
            w.eq("WORKDATE", workdate);
            w.eq("TYPE", type);
        }).fetchAll();
        if (res.get(0).get("HOLIDAYFLAG").equals("Y")) {
            isholiday = true;
        }

        return isholiday;
    }

    /**
     * @return selecter
     */
    public Selecter getSelecter() {
        return selecter;
    }

    /**
     * @param selecter 选择器
     */
    public void setSelecter(Selecter selecter) {
        this.selecter = selecter;
    }


//    public static void main(String[] args){
//    	System.out.println(getSysDateTime("HHmmss", 0));
//    }

}
