package cn.com.agree.huanan.ap.rl.bank.schedule.po;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author acz
 * 字典类
 */
@Getter
@Setter
@ToString
@Table(ScheduleFlow.csis_schedule_flow.class)
public class ScheduleFlow {
    private String seriNo; //调度标识
    private String tradeDate; //交易是济南
    private String tradeTime; //调度英文名称
    private String jobId; //调度标识
    private String jobName; //调度名称
    private String jobType; //任务类型
    private String svcCode;  //服务码
    private String scnCode;  //场景码
    private String svcGroup; //服务分组
    private String reCommit; //是否可重提
    private String status; //状态码
    private String errorCode; //错误码
    private String errorMsg; //错误信息
    private int time;       //调度次数
    private String server; //状态码
    private String serverLog; //状态码
    private String processId; //状态码

    public static class csis_schedule_flow{

    }
    public static Map<String,Object> getMap(ScheduleFlow scheduleFlow){
        Map<String,Object> mapData = new HashMap<>();
        mapData.put("serino",scheduleFlow.getSeriNo());
        mapData.put("tradeDate",scheduleFlow.getTradeDate());
        mapData.put("tradeTime",scheduleFlow.getTradeTime());
        mapData.put("jobId",scheduleFlow.getJobId());
        mapData.put("jobName",scheduleFlow.getJobName());
        mapData.put("jobType",scheduleFlow.getJobType());
        mapData.put("svcCode",scheduleFlow.getSvcCode());
        mapData.put("scnCode",scheduleFlow.getScnCode());
        mapData.put("svcGroup",scheduleFlow.getSvcGroup());
        mapData.put("reCommit",scheduleFlow.getReCommit());
        mapData.put("status",scheduleFlow.getStatus());
        mapData.put("errorCode",scheduleFlow.getErrorCode());
        mapData.put("errorMsg",scheduleFlow.getErrorMsg());
        mapData.put("time",scheduleFlow.getTime());
        mapData.put("server",scheduleFlow.getServer());
        mapData.put("serverLog",scheduleFlow.getServerLog());
        mapData.put("processId",scheduleFlow.getProcessId());
        return mapData;
    }


}
