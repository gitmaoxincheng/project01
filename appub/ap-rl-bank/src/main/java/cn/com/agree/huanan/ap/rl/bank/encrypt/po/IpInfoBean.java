package cn.com.agree.huanan.ap.rl.bank.encrypt.po;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author WB
 */
@ToString
@Getter
@Setter
public class IpInfoBean {
	//端口列表   需与地址列表一一对应
	private List<String> portList;
	//地址列表
	private List<Integer> ipList;
	//超时时间
	private String timeout;

    public static List<IpInfoBean> initInstances(List<Map<String, Object>> map){
        return null;
    }
   
    
}
