package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.dutyinfo.po.DutyInfoInit.csis_dutyinfo_init;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员岗位Bean
 * @author lixq
 */
@Getter
@Setter
@ToString
@Table(csis_dutyinfo_init.class)
public class DutyInfoInit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;//类型
	private String dutyNo;//编号
	private String dutyName;//名称
	//private String dutyDesc;//描述
	private String status;//状态 0-无效,1-有效
	private String propty;//岗位类型属性 0-虚拟岗位类型,1-实体岗位类型,2-半实体岗位类型 
	private String dutyLevel;//岗位类型级别 O-操作岗,C-复核岗,A-授权岗 
	private String upDutyNo;//上级岗位类型
	private String note1;//备注1
	private String note2;//备注2
	private String cityNo;//所属分行
	private String branchType;//小微岗位类别-1 非社区/小微2 社区/小微3 通用
	private String cshBoxFlg;//是否有现金钱箱 0否1是
	private String vchBoxFlg;//是否有凭证钱箱 0否1是
	private String updDate;//更新日期
	private String updTime;//更新时间
	private String mobmktflg;//是否移动营销岗 0-否 1-是
	private String warehouserFlg;//是否库管员 0-否 1-是
	private String specialFlg;//是否特殊岗位 0-否 1-是
	private String cashFlg;//是否现金岗 0-否1-是
	private String bankFlag;//是否村镇银行：0-东莞银行，1-村镇银行
	private String adminFlg;//是否管理员 0否1是
    public static class csis_dutyinfo_init {
        
    }
	
	
	
    /**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return DutyInfo
     */
    public static DutyInfoInit instance(Map<String, Object> map){
    	DutyInfoInit spb=new DutyInfoInit();
        spb.setType(map.get("type").toString());
        spb.setDutyNo(map.get("dutyNo").toString());
        spb.setDutyName(map.get("dutyName").toString());
        //spb.setDutyDesc(map.get("dutyDesc").toString());
        spb.setStatus(map.get("status").toString());
        spb.setPropty(map.get("propty").toString());
        spb.setDutyLevel(map.get("dutyLevel").toString());
        spb.setUpDutyNo(map.get("upDutyNo").toString());
        spb.setNote1(map.get("note1").toString());
        spb.setNote2(map.get("note2").toString());
        spb.setCityNo(map.get("cityNo").toString());
        spb.setBranchType(map.get("branchType").toString());
        spb.setCshBoxFlg(map.get("cshBoxFlg").toString());
        spb.setVchBoxFlg(map.get("vchBoxFlg").toString());
        spb.setUpdDate(map.get("updDate").toString());
        spb.setUpdTime(map.get("updTime").toString());
        spb.setMobmktflg(map.get("mobmktflg").toString());
        spb.setWarehouserFlg(map.get("warehouserFlg").toString());
        spb.setSpecialFlg(map.get("specialFlg").toString());
        spb.setCashFlg(map.get("cashFlg").toString());
        spb.setBankFlag(map.get("bankFlag").toString());
        spb.setAdminFlg(map.get("adminFlg").toString());
        return spb;
    }
    
    public static Map<String, Object> getMap(DutyInfoInit dutyInfo) {
		
    	Map<String, Object> map = new HashMap<>();
    	map.put("type", dutyInfo.getType());
    	map.put("dutyNo", dutyInfo.getDutyNo());
    	map.put("dutyName", dutyInfo.getDutyName());
    	//map.put("dutyDesc", dutyInfo.getDutyDesc());
    	map.put("status", dutyInfo.getStatus());
    	map.put("propty", dutyInfo.getPropty());
    	map.put("dutyLevel", dutyInfo.getDutyLevel());
    	map.put("upDutyNo", dutyInfo.getUpDutyNo());
    	map.put("note1", dutyInfo.getNote1());
    	map.put("note2", dutyInfo.getNote2());
    	map.put("cityNo", dutyInfo.getCityNo());
    	map.put("branchType", dutyInfo.getBranchType());
    	map.put("cshBoxFlg", dutyInfo.getCshBoxFlg());
    	map.put("vchBoxFlg", dutyInfo.getVchBoxFlg());
    	map.put("updDate", dutyInfo.getUpdDate());
    	map.put("updTime", dutyInfo.getUpdTime());
    	map.put("mobmktflg", dutyInfo.getMobmktflg());
    	map.put("warehouserFlg", dutyInfo.getWarehouserFlg());
    	map.put("specialFlg", dutyInfo.getSpecialFlg());
    	map.put("cashFlg", dutyInfo.getCashFlg());
    	map.put("bankFlag", dutyInfo.getBankFlag());
    	map.put("adminFlg", dutyInfo.getAdminFlg());
    	return map;
    }
}
