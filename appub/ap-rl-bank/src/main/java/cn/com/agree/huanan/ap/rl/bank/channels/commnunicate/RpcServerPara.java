package cn.com.agree.huanan.ap.rl.bank.channels.commnunicate;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.ParamQuery;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

import com.alibaba.fastjson.JSON;

public class RpcServerPara {
	private final Logger logger = Logger.getLogger(RpcServerPara.class);
	
	@Getter
	private Map<String, Object> paraMap = new HashMap();
	
	public RpcServerPara() {
		// TODO 自动生成的构造函数存根
	}
	public boolean builderPara(String nodeName, String appId, String commItem){
		// 获取RPC参数
		Map<String, Object> paramsMap = SpringUtil.getBean(ParamQuery.class)
				.getQueryOper().getSelecter().select("EXTPARAJSONSTRING")
				.from("t_comm_param_ext").where(w -> {
					w.eq("nodeName", nodeName);
					w.eq("appId", appId);
					w.eq("commItem", commItem);
				}).fetchOne();
		if (!paramsMap.isEmpty()) {
			String extParaJson = paramsMap.get("EXTPARAJSONSTRING").toString();
			this.paraMap = JSON.parseObject(extParaJson, HashMap.class);
			return true;
		}else{
			logger.debug("没有配置RPC交易参数信息");
			return false;
		}
	}
	
}
