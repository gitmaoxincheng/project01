package cn.com.agree.huanan.ap.rl.bank.service.po;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author acz
 * 服务表
 */
@Getter
@Setter
@ToString
@Table(ServiceRelation.csis_service_relation.class)
public class ServiceRelation {
    public static final String TableName="CSIS_SERVICE_RELATION";

    private String id; //标识ID
    private String svcCode; //服务码
    private String scnCode; //场景码
    private String svcGroup; //服务分组
    private String identifier;//适配器标识
    private String srcSvcCode; //消费方服务码
    private String srcScnCode; //消费方场景码
    private int timeOut; //调用超时时间
    private String remark;//备注

    public static class csis_service_relation {

    }

    /**
     *
     * @param serviceRelation 服务中心信息
     * @return map 数据map
     */
    public static Map<String, Object> getMap(ServiceRelation serviceRelation) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",serviceRelation.getId());
        map.put("svccode",serviceRelation.getSvcCode());
        map.put("scncode",serviceRelation.getScnCode());
        map.put("svcgroup",serviceRelation.getSvcGroup());
        map.put("identifier",serviceRelation.getIdentifier());
        map.put("srcsvccode",serviceRelation.getSrcSvcCode());
        map.put("srcscncode",serviceRelation.getSrcScnCode());
        map.put("timeout",serviceRelation.getTimeOut());
        map.put("remark",serviceRelation.getRemark());
        return map;
    }


    /**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return serviceBean
     */
    public static ServiceRelation initInstance(Map<String, Object> map){
        ServiceRelation sb=new ServiceRelation();
        sb.setId((String)map.get("id"));
        sb.setSvcCode((String)map.get("svccode"));
        sb.setScnCode((String)map.get("scncode"));
        sb.setSvcGroup((String)map.get("svcgroup"));
        sb.setIdentifier((String)map.get("identifier"));
        sb.setSrcSvcCode((String)map.get("srcsvccode"));
        sb.setSrcScnCode((String)map.get("srcscncode"));
        sb.setTimeOut((int)map.get("timeout"));
        sb.setRemark((String)map.get("remark"));
        return sb;
    }
}
