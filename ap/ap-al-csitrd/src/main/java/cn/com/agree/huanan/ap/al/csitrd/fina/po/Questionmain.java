package cn.com.agree.huanan.ap.al.csitrd.fina.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Questionmain.TRADEINFO_RISK_SCORE;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author liyong
 *
 */
@Setter
@Getter
@ToString
@Table(TRADEINFO_RISK_SCORE.class)
public class Questionmain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3344962821604259580L;
    // 公共部分
	private String clienttype;//客户类别
	private String clientgroup;//客户组别
	private String papertype;//问卷类型
	private String paperno;//试卷编号
	private String question;//问题编号
	private String riskoption;//选择项
	private String subject;//提示内容
	private String score;//分数
	private String questiontype;//问题类型
	private String prdtype;//业务类型
	private String updtime;//更新时间
	private String upddate;//更新日期
	
	public static class TRADEINFO_RISK_SCORE{
		
	}
	
	public static Map<String, Object> getMap(Questionmain questionmain){
		 Map<String, Object> map = new HashMap<>();
		 map.put("clienttype",questionmain.getClienttype());
		 map.put("clientgroup",questionmain.getClientgroup());
		 map.put("papertype",questionmain.getPapertype());
		 map.put("paperno",questionmain.getPaperno());
		 map.put("question",questionmain.getQuestion());
		 map.put("riskoption",questionmain.getRiskoption());
		 map.put("subject",questionmain.getSubject());
		 map.put("score",questionmain.getScore());
		 map.put("questiontype",questionmain.getQuestiontype());
		 map.put("prdtype",questionmain.getPrdtype());
		 map.put("updtime",questionmain.getUpdtime());
		 map.put("upddate",questionmain.getUpddate());

		 return map;
		
	}
}
