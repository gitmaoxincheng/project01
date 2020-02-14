package cn.com.agree.huanan.ap.al.csitrd.rcpt.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.afa.util.TimeUtil;
import cn.com.agree.huanan.ap.al.csitrd.rcpt.po.TradeBillImageInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;
@Component
public  class TradeBillImageInfoDaoImpl implements TradeBillImageInfoDao{
	private static String TABLE = "tradeinfo_bill_image";
	@Autowired
	DbOperator dbo;
	@Autowired OrmOperator  ormOper;
	@Override
	public int insertTradeBillImageInfo(TradeBillImageInfo tradeBillImageInfo) {
		int count = dbo.getInserter().insertInto(TABLE).values(TradeBillImageInfo.getMap(tradeBillImageInfo)).execute();
		return count;
	}

	@Override
	public int updateTradeBillImageInfo(Map<String, Object> map) {
		// 检验参数
		if (StringUtils.isEmpty(map)) {
			throw new ApIllegalParamException("map");
		}
		
		//更新数据
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("bill", map.get("bill"));
		w.eq("imageType", map.get("imagetype"));
		}).set(map).execute();
		return count;
	}

	@Override
	public List<TradeBillImageInfo> queryTradeBillImageInfos(String bill) {
		// TODO 自动生成的方法存根
		OrmSelecter<TradeBillImageInfo> ormSelecter=ormOper.getOrmSelecter(TradeBillImageInfo.class);
		List<TradeBillImageInfo> billImages = ormSelecter.where(w ->{
    		w.setBill(bill);
    	}).fetchAll();
		return billImages;
	}

	@Override
	public TradeBillImageInfo queryTradeBillImageInfoByType(String bill, String type) {
		OrmSelecter<TradeBillImageInfo> ormSelecter=ormOper.getOrmSelecter(TradeBillImageInfo.class);
		TradeBillImageInfo billImage=ormSelecter.where(w ->{
    		w.setBill(bill);
    		w.setImageType(type);
    	}).fetchOne();
		// TODO 自动生成的方法存根
		return billImage;
	}

	@Override
	public int insertBatchTradeBillImageInfo(List<Map<String,Object>> list,String bill) {
		StringBuilder sb=new StringBuilder();
		sb.append("insert all");
		String date=DateTimeUtil.getSysDate();
		for(Map<String,Object> map:list) {
			String time=DateTimeUtil.getSysTime();
			sb.append("into tradeinfo_bill_image(BILL, IMAGETYPE, SERVECODE, UPDTIME, UPDDATE)  values('"+bill+"', '"+map.get("imagetype")+"', '"+map.get("imagepath")+"', '"+time+"', '"+date+"')");
		}
		sb.append("select 1 from dual");
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectBillImageInfo(String bill) {
		//拼接查询条件参数
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {

			@Override
			public void accept(WhereExp w) {
				// TODO 自动生成的方法存根
				if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
					w.eq("bill", bill);
				}
			}
		};
		//拼接查询字段
		String[] selectList = new String[] {
				"imageType as imagetype",
				"imagepath as imagepath"
		};
		//查询返回数据
		List<Map<String, Object>> billImageList = dbo.getSelecter()
														.select(selectList)
														.from(TABLE)
														.where(whereExp).orderBy("imagetype")
														.fetchAll();
		return billImageList;
	}

	@Override
	public List<Map<String, Object>> selectBillImageInfosDate(String bill) {
		//拼接查询条件参数
				Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {

					@Override
					public void accept(WhereExp w) {
						// TODO 自动生成的方法存根
						if(!StringUtils.isEmpty(bill) && !"".equals(bill)) {
							w.eq("bill", bill);
						}
					}
				};
				//拼接查询字段
				String[] selectList = new String[] {
						"imageType as imagetype",
						"imagepath as imagepath",
						"upddate as upddate"
				};
				//查询返回数据
				List<Map<String, Object>> billImageList = dbo.getSelecter()
																.select(selectList)
																.from(TABLE)
																.where(whereExp).orderBy("imagetype")
																.fetchAll();
				return billImageList;
	}

}
