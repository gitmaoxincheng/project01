package cn.com.agree.huanan.ap.rl.bank.service.po;


import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author acz
 *
 */
@Setter
@Getter
@ToString
public class AtomicServiceBean {
    public static final String TableName="CSIS_ATOMIC_SERVICE";
    
    private String AT_SVCID;
    private String AT_SVCCODE;
    private String AT_SVCNAME;
    private String AT_SCNCODE;
    private String AT_SCNNAME;
    private String SYS_CODE;
    private String SYS_NAME;
    private String SYS_SVCCODE;
    private String SYS_SVCNAME;
    private String SYS_SCNCODE;
    private String EXT_CODE;
    private String SYS_SCNNAME;
    private String IS_ECTIP;
    private String  STATUS;
    private String  REMARK;
    
    
    /**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return serviceBean
     */
    public static AtomicServiceBean initInstance(Map<String, Object> map){
        AtomicServiceBean asb = new AtomicServiceBean();
        asb.setAT_SVCID(map.get("AT_SVCID").toString());
        asb.setAT_SVCCODE(map.get("AT_SVCCODE").toString());
        asb.setAT_SVCNAME(map.get("AT_SVCNAME").toString());
        asb.setAT_SCNCODE(map.get("AT_SCNCODE").toString());
        asb.setAT_SCNNAME(map.get("AT_SCNNAME").toString());
        asb.setSYS_CODE(map.get("SYS_CODE").toString());
        asb.setSYS_NAME(map.get("SYS_NAME").toString());
        asb.setSYS_SVCCODE(map.get("SYS_SVCCODE").toString());
        asb.setSYS_SVCNAME(map.get("SYS_SVCNAME").toString());
        asb.setSYS_SCNCODE(map.get("SYS_SCNCODE").toString());
        asb.setSYS_SCNCODE(map.get("SYS_SCNCODE").toString());
        asb.setEXT_CODE(map.get("EXT_CODE").toString());
        asb.setIS_ECTIP(map.get("IS_ECTIP").toString());
        asb.setSTATUS(map.get("STATUS").toString());
        asb.setREMARK(map.get("REMARK").toString());
        return asb;
    }
  
}
