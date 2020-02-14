package cn.com.agree.huanan.ap.al.csitrd.branchcode.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.branchcode.po.BranchCode.csis_branch_code;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 机构身份识别码表Bean 
 * @author lanshaojun
 */
@Getter
@Setter
@ToString
@Table(csis_branch_code.class)
public class BranchCode implements Serializable{
	
	private static final long serialVersionUID = -7445478145375165362L;
	
	private String Br_No;//网点号
	private String Br_Name;//网点名称
	private String Accfund_No;//公积金分配网点号
	private String Accfund_Name;//公积金分配网点名称
	private String Organ_IdNum;//机构身份识别码
	private String UpdDate;//更新日期
	private String UpdTime;//更新时间

	public static class csis_branch_code {
        
    }
    
	/**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return BranchCode
     */
    public static BranchCode instance(Map<String, Object> map){
        return null;
    }
    
    public static Map<String, Object> getMap(BranchCode branchCode) {
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("br_no",branchCode.getBr_No());
    	map.put("br_name",branchCode.getBr_Name());
    	map.put("accfund_no",branchCode.getAccfund_No());
    	map.put("accfund_name",branchCode.getAccfund_Name());
    	map.put("organ_idnum",branchCode.getOrgan_IdNum());
    	map.put("upddate",branchCode.getUpdDate());
    	map.put("updtime",branchCode.getUpdTime());
    	
    	return map;
    }
}
