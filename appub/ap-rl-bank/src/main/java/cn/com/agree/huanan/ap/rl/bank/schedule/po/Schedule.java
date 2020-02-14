package cn.com.agree.huanan.ap.rl.bank.schedule.po;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HCP
 * 字典类
 */
@Getter
@Setter
@ToString
@Table(Schedule.csis_schedule.class)
public class Schedule {
    private String jobId; //调度标识
    private String jobName; //调度名称
    private String jobEname; //调度英文名称
    private String jobType; //任务类型
    private String svcCode;  //服务码
    private String scnCode;  //场景码
    private String svcGroup; //服务分组
    private String reCommit; //是否可重提
    private String curDate; //最新调度日期
    private String curSerno; //最新调度流水
    private int curCount; //当日调起次数
    private int timeOut;     //超时时间
    private int interval;    //重提间隔时间
    private int  maxCommit;  //重提次数
    private int times;       //调度次数
    private String status;   //调度
    private String remark;   //备注

    public static class csis_schedule{

    }
/*    public static Map<String,Object> getMap(Schedule schedule){
        Map<String,Object> mapData = new HashMap<>();
        mapData.put("jobId",schedule.getJobId());
        mapData.put("jobName",schedule.getJobName());
        mapData.put("jobEname",schedule.getJobEname());
        mapData.put("jobType",schedule.getJobType());
        mapData.put("svcCode",schedule.getSvcCode());
        mapData.put("scnCode",schedule.getScnCode());
        mapData.put("svcGroup",schedule.getSvcGroup());
        mapData.put("reCommit",schedule.getReCommit());
        mapData.put("curDate",schedule.getCurDate());
        mapData.put("curSerno",schedule.getCurSerno());
        mapData.put("timeOut",schedule.getTimeOut());
        mapData.put("interval",schedule.getInterval());
        mapData.put("maxCommit",schedule.getMaxCommit());
        mapData.put("times",schedule.getTimes());
        mapData.put("status",schedule.getStatus());
        mapData.put("remark",schedule.getRemark());
        return mapData;
    }*/
    
}
