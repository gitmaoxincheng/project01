package cn.com.agree.huanan.ap.al.csiusr.teller.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TellerVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String brno;
	private String brnoname;
	private String dutyno;
	private String dutyname;
	private String entdutyno;
	private String entdutyname;
	private String mybank;
	private String cshBoxNo1;
	private String vchBoxNo1;
}
