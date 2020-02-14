/**
 * 
 */
package cn.com.agree.huanan.ap.tl.communicate.comm.params;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import cn.com.agree.huanan.ap.tl.communicate.comm.exception.NoCommParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

import com.alibaba.fastjson.JSON;

/**
 * @author xqq tcp通讯参数
 */

public class SimpleTcpParam extends CommParam{
	private final static HashMap<String, Object> SIMPLETCPPARAMEXT = new HashMap<String, Object>();
	static{
		//默认值
		SIMPLETCPPARAMEXT.put("headType", 0);
		SIMPLETCPPARAMEXT.put("headSize", 8);
		SIMPLETCPPARAMEXT.put("containHeadLength", false);
		SIMPLETCPPARAMEXT.put("socketCloseTimeOut", 30000);
		SIMPLETCPPARAMEXT.put("socketReadTimeOut", 30000);
	}
    /**
     * 日志句柄
     */
    public Logger logger =  Logger.getLogger(SimpleTcpParam.class);
	/**
	 * 报文长度是包含报文头 
	 */
	@Setter
	@Getter
	public boolean containHeadLength;

	
	/**
	 * 报文头长度
	 */
	@Setter
	@Getter
	public Integer headSize;


	/**
	 * 报文头类型 0->int 1->4子节数值 2->2子节数值
	 */
	@Setter
	@Getter
	public int headType;
	
	/**
	 * socket关闭超时
	 */
	@Setter
	@Getter
	public int socketCloseTimeOutMilliseconds;

	
	/**
	 * socket数据读取超时
	 */
	@Setter
	@Getter
	public int socketReadTimeOutMilliseconds;
	
	public SimpleTcpParam() {
		// TODO 自动生成的构造函数存根
		SetCommHttpParam(SIMPLETCPPARAMEXT);
	}

	// 初始化
	@Override
	public CommParam init(CommParam param) {
		super.init(param);
		// 待添加获取HTTP参数
		Map<String, Object> paramsMap = SpringUtil.getBean(ParamQuery.class)
				.getQueryOper().getSelecter().select("EXTPARAJSONSTRING")
				.from("t_comm_param_ext").where(w -> {
					w.eq("nodeName", param.getNodeName());
					w.eq("appId", param.getAppId());
					w.eq("commItem", param.getCommItem());
				}).fetchOne();
		if (!paramsMap.isEmpty()) {
			String extParaJson = paramsMap.get("EXTPARAJSONSTRING").toString();
			@SuppressWarnings("unchecked")
			Map <String , Object> extParaMap = JSON.parseObject(extParaJson, HashMap.class);
			logger.info("配置的通讯参数:" + extParaMap);
			SetCommHttpParam(extParaMap);
		}else{
            logger.error("未配置通信参数");
            throw NoCommParamException.getException();
		}
		return this;
	}

	protected void SetCommHttpParam(Map<String, Object> jsonParaString) {
		jsonParaString.forEach((k, v) -> {
			switch (k) {
			case "headType":
				this.headType = Integer.valueOf(v.toString());
				break;
			case "headSize":
				this.headSize = Integer.valueOf(v.toString());
				break;
			case "containHeadLength":
				this.containHeadLength = Boolean.valueOf(v.toString());
				break;
			case "socketCloseTimeOut":
				this.socketCloseTimeOutMilliseconds = Integer.valueOf(v.toString());
				break;
			case "socketReadTimeOut":
				this.socketReadTimeOutMilliseconds = Integer.valueOf(v.toString());
				break;
			default:
				break;
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println(JSON.toJSON(SIMPLETCPPARAMEXT));
	}

}
