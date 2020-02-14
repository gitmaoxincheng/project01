package cn.com.agree.huanan.ap.al.csiusr.unitebranch.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import cn.com.agree.huanan.ap.al.csiusr.unitebranch.po.UniteBranch.csis_unitebranch;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 行所合并表Bean
 * @author maoxc
 */
@Getter
@Setter
@ToString
@Table(csis_unitebranch.class)
public class UniteBranch implements Serializable {
	private String wtStat;//回写状态 0-待回写1-回写成功2-回写失败
	private String wtCnt;//回写次数
	private String branChno;//被并网点号
	private String unbranchNo;//并入网点号
	private String brDate;//计划并入的日期
	private String status;//有效状态 0无效1有效
	private String note1;//备注1
	private String note2;//备注2
	private String unStatus;//合并状态 0未合并1已合并
	private String serialNo;//ifs并入流水号
	private String unbrSq;//svr并入流水号
	private String updDate;//更新日期
	private String updTime;//更新时间


    public static class csis_unitebranch {
        
    }
    
    public static Map<String, Object> getMap(UniteBranch  uniteBranch) {
    	Map<String, Object> map = new HashMap<>();
    	map.put("wtStat", uniteBranch.getWtCnt());
    	map.put("wtCnt", uniteBranch.getWtCnt());
    	map.put("unbranchNo", uniteBranch.getUnbranchNo());
    	map.put("brDate", uniteBranch.getBrDate());
    	map.put("status", uniteBranch.getStatus());
    	map.put("note1", uniteBranch.getNote1());
    	map.put("note2", uniteBranch.getNote2());
    	map.put("unStatus", uniteBranch.getUnStatus());
    	map.put("serialNo", uniteBranch.getSerialNo());
    	map.put("unbrSq", uniteBranch.getUnbrSq());
    	map.put("updDate", uniteBranch.getUpdDate());
    	map.put("updTime", uniteBranch.getUpdTime());
    	return map;
    }
    
}
