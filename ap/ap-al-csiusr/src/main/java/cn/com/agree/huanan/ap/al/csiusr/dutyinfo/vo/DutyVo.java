package cn.com.agree.huanan.ap.al.csiusr.dutyinfo.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 柜员岗位VO
 * @author lixq
 */
@Getter
@Setter
@ToString
public class DutyVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7192474119714018212L;
	private String dutyNo;
	private String dutyName;
}
