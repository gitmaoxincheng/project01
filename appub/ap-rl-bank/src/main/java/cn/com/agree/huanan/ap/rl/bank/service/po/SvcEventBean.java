package cn.com.agree.huanan.ap.rl.bank.service.po;

import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.rl.bank.service.service.PubTrdTransfer;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author acz 服务事件
 */
@Setter
@Getter
@ToString
public class SvcEventBean {
    /**
     * 服务事件表
     */
    public static final String TableName = "CSIS_SERVICE_EVENT";
    /**
     * 服务时间序列
     */
    public static final String SVC_EVENT_SEQ = "SEQ_CSIS_EVENT";
    private String SER_NO;  //流水号
    private String WORK_DATE;   //工作日期
    private String WORK_TIME;   //工作时间
    private String CHL_DATE;    //渠道日期
    private String CHL_TIME;    //渠道时间
    private String CHL_SERNO;   //渠道流水号
    private String CHL_PRESERNO;    //渠道原流水号
    private String CHL_SYSNO;   //渠道请求系统编号
    private String CHL_CODE;    //渠道代码
    private String CHL_SUBCODE; //渠道细分代码
    private String SEL_SCNSUBCODE;  //选择场景细分代码
    private String COMM_TYPE;   //通讯类型
    private String ORI_SYSID;   //源系统编号
    private String REQ_SYSID;   //请求系统编号
    private String BUSI_SERNO;  //业务流水号
    private String PRE_BUSISERNO;   //原业务流水号
    private String LAW_MAN; //法人
    private String BRACH_NO;    //机构号
    private String TEL_NO;  //柜员号
    private String USER_NO; //用户号
    private String DEV_ID;  //背夹设备号
    private String TERM_ID; //终端代号
    private String AUTH_FLAG;   //授权标记
    private String AUTH_TELNO;  //授权柜员
    private String TRADE_CODE;  //交易码
    private String SAFE_NODE;   //安全节点
    private String MAC_NODE;    //MAC节点
    private String MAC; //MAC值
    private String CC_ID;   //能力中心ID
    private String SVC_CODE;    //服务代码
    private String SCN_CODE;    //场景代码
    private String STATUS;  //状态 0-成功 1-失败 2-异常
    private String ERROR_CODE;  //错误代码
    private String ERROR_MSG;   //错误信息
    private String RSP_DATE;//响应日期
    private String RSP_TIME;//响应时间
    private String TOTAL_TIME;//交易总耗时


    /**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return serviceBean
     */
    public static SvcEventBean initInstance(Map<String, Object> map) {
        SvcEventBean seb = new SvcEventBean();
        seb.setSER_NO(map.get("SER_NO").toString());
        seb.setWORK_DATE(map.get("WORK_DATE").toString());
        seb.setWORK_TIME(map.get("WORK_TIME").toString());
        seb.setCHL_DATE(map.get("CHL_DATE").toString());
        seb.setCHL_TIME(map.get("CHL_TIME").toString());
        seb.setCHL_SERNO(map.get("CHL_SERNO").toString());
        seb.setCHL_PRESERNO(map.get("CHL_PRESERNO").toString());
        seb.setCHL_SYSNO(map.get("CHL_SYSNO").toString());
        seb.setCHL_CODE(map.get("CHL_CODE").toString());
        seb.setCHL_SUBCODE(map.get("CHL_SUBCODE").toString());
        seb.setSEL_SCNSUBCODE(map.get("SEL_SCNSUBCODE").toString());
        seb.setCOMM_TYPE(map.get("COMM_TYPE").toString());
        seb.setORI_SYSID(map.get("ORI_SYSID").toString());
        seb.setREQ_SYSID(map.get("REQ_SYSID").toString());
        seb.setBUSI_SERNO(map.get("BUSI_SERNO").toString());
        seb.setPRE_BUSISERNO(map.get("PRE_BUSISERNO").toString());
        seb.setLAW_MAN(map.get("LAW_MAN").toString());
        seb.setBRACH_NO(map.get("BRACH_NO").toString());
        seb.setTEL_NO(map.get("TEL_NO").toString());
        seb.setUSER_NO(map.get("USER_NO").toString());
        seb.setDEV_ID(map.get("DEV_ID").toString());
        seb.setTERM_ID(map.get("TERM_ID").toString());
        seb.setAUTH_FLAG(map.get("AUTH_FLAG").toString());
        seb.setAUTH_TELNO(map.get("AUTH_TELNO").toString());
        seb.setTRADE_CODE(map.get("TRADE_CODE").toString());
        seb.setSAFE_NODE(map.get("SAFE_NODE").toString());
        seb.setMAC_NODE(map.get("MAC_NODE").toString());
        seb.setMAC(map.get("MAC").toString());
        seb.setCC_ID(map.get("CC_ID").toString());
        seb.setSVC_CODE(map.get("SVC_CODE").toString());
        seb.setSCN_CODE(map.get("SCN_CODE").toString());
        seb.setSTATUS(map.get("STATUS").toString());
        seb.setERROR_CODE(map.get("ERROR_CODE").toString());
        seb.setERROR_MSG(map.get("ERROR_MSG").toString());
        seb.setRSP_DATE(map.get("RSP_DATE").toString());
        seb.setRSP_TIME(map.get("RSP_TIME").toString());
        seb.setTOTAL_TIME(map.get("TOTAL_TIME").toString());
        return seb;
    }
    
    /**
     * @param seb 初始化数据
     * @return Map key 字段名  value 数据
     */
    public static Map<String, Object> initData(SvcEventBean seb){
        PubTrdTransfer ptt = SpringUtil.getBean(PubTrdTransfer.class);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("WORK_DATE",seb.getWORK_DATE());
        map.put("WORK_TIME",seb.getWORK_TIME());
        map.put("CHL_DATE",seb.getCHL_DATE());
        map.put("CHL_TIME",seb.getCHL_TIME());
        map.put("CHL_SERNO",seb.getCHL_SERNO());
        map.put("CHL_PRESERNO",seb.getCHL_PRESERNO());
        map.put("CHL_SYSNO",seb.getCHL_SYSNO());
        map.put("CHL_CODE",seb.getCHL_CODE());
        map.put("CHL_SUBCODE",seb.getCHL_SUBCODE());
        map.put("SEL_SCNSUBCODE",seb.getSEL_SCNSUBCODE());
        map.put("COMM_TYPE",seb.getCOMM_TYPE());
        map.put("ORI_SYSID",seb.getORI_SYSID());
        map.put("REQ_SYSID",seb.getREQ_SYSID());
        map.put("BUSI_SERNO",seb.getBUSI_SERNO());
        map.put("PRE_BUSISERNO",seb.getPRE_BUSISERNO());
        map.put("LAW_MAN",seb.getLAW_MAN());
        map.put("BRACH_NO",seb.getBRACH_NO());
        map.put("TEL_NO",seb.getTEL_NO());
        map.put("USER_NO",seb.getUSER_NO());
        map.put("DEV_ID",seb.getDEV_ID());
        map.put("TERM_ID",seb.getTERM_ID());
        map.put("AUTH_FLAG",seb.getAUTH_FLAG());
        map.put("AUTH_TELNO",seb.getAUTH_TELNO());
        map.put("TRADE_CODE",seb.getTRADE_CODE());
        map.put("SAFE_NODE",seb.getSAFE_NODE());
        map.put("MAC_NODE",seb.getMAC_NODE());
        map.put("MAC",seb.getMAC());
        map.put("CC_ID",seb.getCC_ID());
        map.put("SVC_CODE",seb.getSVC_CODE());
        map.put("SCN_CODE",seb.getSCN_CODE());
        map.put("STATUS",seb.getSTATUS());
        map.put("ERROR_CODE",seb.getERROR_CODE());
        map.put("ERROR_MSG",seb.getERROR_MSG());
        map.put("RSP_DATE",seb.getRSP_DATE());
        map.put("RSP_TIME",seb.getRSP_TIME());
        map.put("TOTAL_TIME",seb.getTOTAL_TIME());
        
        return map;
    }
}
