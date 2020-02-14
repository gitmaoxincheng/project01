package cn.com.agree.huanan.ap.al.csitrd.rtmh.po;

import java.io.Serializable;   
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.StatisticslInfo.csis_statistical_form;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;





/**
 * 交易统计Bean
 * @author 
 */
@Getter
@Setter
@ToString
@Table(csis_statistical_form.class)
public class StatisticslInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sq_Commitserno;//打印流水
	private String channelSerno;//渠道流水
	private String printDate;//打印日期
	private String printTime;//打印时间
	private String deviceIp;//客户端IP
	private String deviceNo;//设备编号
	private String printNo;//打印笔数
	private String acctNo;//账号 卡号
	private String tardeNo;//P端交易代码
	private String tradeName;//交易名
	private String branch;//打印机构
	private String tellerNo;//打印柜员
	private String note1;//备注1
	private String note2;//备注1
	private String note3;//备注1
	
	public static class csis_statistical_form {
		
	}
	
	/**
	 * @param map 数据map，key:属性名(全大写) value：属性值
	 * @return 
	 */
	public static Map<String, Object> getMap(StatisticslInfo statisticslInfo) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("sq_Commitserno",statisticslInfo.getSq_Commitserno());
	    map.put("channelSerno",statisticslInfo.getChannelSerno());
	    map.put("printDate",statisticslInfo.getPrintDate());
	    map.put("printTime",statisticslInfo.getPrintTime());
	    map.put("deviceIp",statisticslInfo.getDeviceIp());
	    map.put("deviceNo",statisticslInfo.getDeviceNo());
	    map.put("printNo",statisticslInfo.getPrintNo());
	    map.put("acctNo",statisticslInfo.getAcctNo());
	    map.put("tardeNo",statisticslInfo.getTardeNo());
	    map.put("tradeName",statisticslInfo.getTradeName());
	    map.put("branch",statisticslInfo.getBranch());
	    map.put("tellerNo",statisticslInfo.getTellerNo());
	    map.put("note1",statisticslInfo.getNote1());
	    map.put("note2",statisticslInfo.getNote2());
	    map.put("note3",statisticslInfo.getNote3());
	    
		return map;
	    
	    
	}
	    
}
