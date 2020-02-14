package cn.com.agree.huanan.ap.al.atmp.atm.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.atmp.atm.po.AtmpMachineRegister.atmp_machine_register;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(atmp_machine_register.class)
public class AtmpMachineRegister implements Serializable{
	private static final long serialVersionUID = 1L;
	private String srcserialno;		//源请求方交易流水号
	private String globalserialno;	//全局交易流水号
	private String transdt;			//交易日期
	private String transtm;			//交易时间
	private String termid;			//终端号
	private String cardno;			//交易卡号
	private String transamt;		//交易金额
	private String transtp;			//交易类型
	private String transstatus;		//交易状态
	private String extrancode;		//外部请求服务码
	private String scncode;			//外部请求场景码
	private String extranname;		//交易名
	private String platcode;		//内部模板码
	private String svrcode;			//内部应用码  
	private String mcid ;			//商户号
	private String systrn;			//系统跟踪码
	private String cardtype;		//卡类型
	private String brno;			//机构号
	private String channelcode;		//系统代码
	private String inacctno;		//转入账号

	
	public static class atmp_machine_register {
        
	}
	public static Map<String, Object> getMap(AtmpMachineRegister atmpMachineRegister) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("srcserialno",atmpMachineRegister.getSrcserialno());
	    map.put("globalserialno",atmpMachineRegister.getGlobalserialno());
	    map.put("transdt",atmpMachineRegister.getTransdt());
	    map.put("transtm",atmpMachineRegister.getTranstm());
	    map.put("termid",atmpMachineRegister.getTermid());
	    map.put("cardno",atmpMachineRegister.getCardno());
	    map.put("transamt",atmpMachineRegister.getTransamt());
	    map.put("transtp",atmpMachineRegister.getTranstp());
	    map.put("transstatus",atmpMachineRegister.getTransstatus());
	    map.put("extrancode",atmpMachineRegister.getExtrancode());
	    map.put("scncode",atmpMachineRegister.getScncode());
	    map.put("extranname",atmpMachineRegister.getExtranname());
	    map.put("platcode",atmpMachineRegister.getPlatcode());
	    map.put("svrcode",atmpMachineRegister.getSvrcode());
	    map.put("mcid",atmpMachineRegister.getMcid());
	    map.put("systrn",atmpMachineRegister.getSystrn());
	    map.put("cardtype",atmpMachineRegister.getCardtype());
	    map.put("brno", atmpMachineRegister.getBrno());
	    map.put("channelcode", atmpMachineRegister.getChannelcode());
	    map.put("inacctno", atmpMachineRegister.getInacctno());
	    return map;
	}	
}
