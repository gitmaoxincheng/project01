package cn.com.agree.huanan.ap.al.csitrd.device.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.device.po.TradeDeviceInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class TradeDeviceDaoImpl implements TradeDeviceDao{
	
	private static String TABLE1="TRADEINFO_DEVICE_MAIN";
    public final Logger logger = Logger.getLogger(TradeDeviceDaoImpl.class);
    @Autowired OrmOperator  ormOper;
    @Autowired DbOperator dbo;

    //新增设备信息记录
	@Override
	public int insertTradeDeviceInfo(TradeDeviceInfo tradeDeviceInfo) {
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE1).values(TradeDeviceInfo.getMap(tradeDeviceInfo)).execute();
		return count;
	}

	//修改设备信息记录
	@Override
	public int updateTradeDeviceInfo(Map<String, Object> paramMap) {
		//参数校验
		if (null == paramMap.get("tradeDate") || StringUtils.isEmpty(paramMap.get("tradeDate"))) {
			throw new ApIllegalParamException("tradeDate");	
		}
		
		if (null == paramMap.get("serialNo") || StringUtils.isEmpty(paramMap.get("serialNo"))) {
			throw new ApIllegalParamException("serialNo");	
		}
		//更新数据
		int count = dbo.getUpdater().update(TABLE1).where(w -> {
			w.eq("tradeDate", paramMap.get("tradeDate"));
			w.eq("serialNo", paramMap.get("serialNo"));
		}).set(paramMap).execute();
		
		return count;
	}

}
