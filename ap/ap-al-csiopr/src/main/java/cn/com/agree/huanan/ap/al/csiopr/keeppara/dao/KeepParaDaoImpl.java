package cn.com.agree.huanan.ap.al.csiopr.keeppara.dao;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.po.KeepPara;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class KeepParaDaoImpl implements KeepParaDao{

	private static String TABLE="csis_keep_para";
	public final Logger logger = Logger.getLogger(KeepParaDaoImpl.class);

	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;

	/**
	 * 查询最大的代保管品种类编号
	 * */
	@Override
	public String getMaxKeepTypeNo() {
		Map<String,Object> map = dbo.getSelecter().from(TABLE).select("max(keeptypeno) as maxno").fetchOne();
		String maxKeepTypeNo = "0001";
		if(null != map && map.size()>0 ) {
			String temp = String.valueOf(map.get("maxno"));
			if(!StringUtils.isEmpty(temp)) {
				maxKeepTypeNo = String.valueOf((Integer.valueOf(temp)+1));
			}
		}

		switch(maxKeepTypeNo.length()) {
		case 1:
			maxKeepTypeNo = "000"+maxKeepTypeNo;
			break;
		case 2:
			maxKeepTypeNo = "00"+maxKeepTypeNo;
			break;
		case 3:
			maxKeepTypeNo = "0"+maxKeepTypeNo;
			break;
		} 

		return maxKeepTypeNo;
	}

	/**
	 * 插入代保管物品参数记录
	 * 
	 * */
	@Override
	public int insertKeepPara(KeepPara keepPara) {
		int count = dbo.getInserter().insertInto(TABLE).values(KeepPara.getMap(keepPara)).execute();
		return count;
	}


	/**
	 * 根据原代保管品种类编号修改代保管物品参数记录
	 * 
	 * */
	public int modifyKeepPara(KeepPara keepPara,String oldkeeptypeno) {

		if(StringUtils.isEmpty(oldkeeptypeno)) {
			throw new ApIllegalParamException("oldkeeptypeno");
		}

		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("keeptypeno",oldkeeptypeno);}).set(KeepPara.getMap(keepPara)).execute();		
		//int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("CHNLCODE", chlInfo.getChnlCode());}).set(ChlInfo.getMap(chlInfo)).execute();		
		return count;

	}

	/**
	 * 根据原代保管品种类编号查找代保管物品参数记录
	 * 
	 * */
	@Override
	public KeepPara queryKeepParaByKeeptypeno(String keeptypeno) {
		OrmSelecter<KeepPara> ormSelecter = ormOper.getOrmSelecter(KeepPara.class);
		KeepPara keepPara = ormSelecter.where(w ->{
			w.setKeepTypeNo(keeptypeno);
		}).fetchOne();
		return keepPara;
	}

	/**
	 * 根据原代保管品种类编号删除代保管物品参数记录
	 * 
	 * */
	public int deleteKeepParaByKeepTypeNo(String keeptypeno) {
		if (StringUtils.isEmpty(keeptypeno)){
			throw new ApIllegalParamException("keeptypeno");
		}

		int count = dbo.getDeleter().deleteFrom(TABLE).where(w -> {
			w.eq("keeptypeno",keeptypeno);
		}).execute();

		return count;
	}
	
	/**
	 * 查询代保管品参数记录
	 * */
	@Override
	public IPage<Map<String, Object>> getKeepParaList(int pageflag, int maxnum, String keeptypeno, String keeptype,String recorddate , String myBank) {
		
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(keeptypeno)) {
					w.eq("KEEPTYPENO", keeptypeno);
				}
				if (!StringUtils.isEmpty(keeptype)) {
					w.eq("KEEPTYPE", keeptype);
				}
				if (!StringUtils.isEmpty(recorddate)) {
					w.eq("RECORDDATE", recorddate);
				}
				if(!StringUtils.isEmpty(myBank)) {
					w.eq("MYBANK", myBank);
				}
			};
		};
		
		String[] selectList = new String[] {
				"keeptypeno as keeptypeno",
				"keeptype as keeptype",
				"unit as unit",
				"CurrType as CurrType",
				"remarks as remarks",
				"tellerno as strtellerno",
				"recorddate as recorddate",
				"mybank as mybank"
		};                   

		Selecter selecter = dbo.getSelecter()
							.select(selectList)
							.from(TABLE)
							.where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageflag,maxnum);
		return iPage;

	}




}
