package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import java.util.ArrayList;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.RtmhModelInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;


@Component
public class EquimentDaoImpl implements EquimentDao{

	public final Logger logger = Logger.getLogger(EquimentDaoImpl.class);
	@Autowired OrmOperator  ormOper;
	@Autowired DbOperator dbo;
	
	
	
	@Override
	public Map<String, Object> selectModelInfo(int pageFlag, int pageSize, String modelid,String modelstatus) {
		logger.info("开始查询数据");
		//检验参数
		if (StringUtils.isEmpty(pageFlag)) {
			throw new ApIllegalParamException("pageFlag");	
		}else if(pageSize<1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("pageSize");
		}
		//查询条件
		final  String orderColum = "t.modelid";
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if(!StringUtils.isEmpty(modelid)) {
					w.eq("t.MODELID", modelid);
				}
				if(!StringUtils.isEmpty(modelstatus)) {
					w.eq("t.MODELSTATUS", modelstatus);
				}				
			};
		};
		//查询
		String[] selectList = new String[]{"modelid as modelid","modelname as modelname","modelsx as modelsx","modelsp as modelsp",
											"modelstatus as modelstatus","remark1 as remark1",
											"modstatpath as modstatpath","dbfield as dbfield"};
		Selecter selecter = dbo.getSelecter()
				 .select(selectList)
				 .from("csis_sbm_devmodelinfo t")						 
				 .where(whereExp);
		
		long count = selecter.count();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();

		if ((pageFlag - 1) *  pageSize < count) {
			list = selecter.orderBy(orderColum).fetch((pageFlag - 1) *  pageSize,pageSize);
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
				
		resultMap.put("rowcnt", count);
		resultMap.put("listnm", list.size());
		resultMap.put("bodrcdlist", list);
		
		return resultMap;
		
	}



	@Override
	public RtmhModelInfo queryModelInfo(String modelid, String modelstatus) {
		//查询设备模型信息表
		OrmSelecter<RtmhModelInfo> ormSelecter = ormOper.getOrmSelecter(RtmhModelInfo.class);
		RtmhModelInfo rtmhModelInfo = ormSelecter.where(w->{
			if(!StringUtils.isEmpty(modelid)) {
				w.setModelId(modelid);
			}
			if(!StringUtils.isEmpty(modelstatus)) {
				w.setModelStatus(modelstatus);
			}
		}
		).fetchOne();		
		return rtmhModelInfo;
	}
	
	
}
