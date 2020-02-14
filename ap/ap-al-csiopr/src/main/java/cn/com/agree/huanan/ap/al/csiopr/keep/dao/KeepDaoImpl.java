package cn.com.agree.huanan.ap.al.csiopr.keep.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class KeepDaoImpl implements KeepDao{

	private static String TABLE="csis_keep";
	private static String TABLE_BRANCH="csis_branch";
	private static String TABLE_CSIS_SYSPARA = "csis_syspara";
	public final Logger logger = Logger.getLogger(KeepDaoImpl.class);

	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;


	/**
	 * 生成代保管编号
	 * 
	 * */
	@Override
	public String getKeepNo(String keepDate) {
		//查出当天最大的代保管编号
		Map<String,Object> map = dbo.getSelecter().from(TABLE).select("max(KEEPNO) as keepNo").where(w ->{
			w.op("KEEPNO", "like", keepDate+"%");
		}).fetchOne();
		String keepNo = keepDate+"0001";
		if( null != map && map.size()>0 ) {
			String temp = String.valueOf(map.get("keepNo"));
			if(!StringUtils.isEmpty(temp)) {
				String num = String.valueOf(Integer.valueOf(temp.substring(9))+1);
				switch(num.length()) {
				case 1:
					num = "000"+num;
					break;
				case 2:
					num = "00"+num;
					break;
				case 3:
					num = "0"+num;
					break;
				} 
				keepNo = keepDate+num;
				logger.info("测试生成的keepNo"+keepNo);
			}

		}	
		return keepNo;
	}


	/**
	 * 插入代保管物品信息记录
	 * 
	 * */
	@Override
	public int insertKeep(Keep keep) {
		int count = dbo.getInserter().insertInto(TABLE).values(Keep.getMap(keep)).execute();
		return count;
	}


	/**
	 * 根据代保管编号查询代保管物品
	 * */
	@Override
	public Keep queryKeepByKeepNo(String keepNo) {

		OrmSelecter<Keep> ormSelecter = ormOper.getOrmSelecter(Keep.class);
		Keep keep = ormSelecter.where(w ->{
			w.setKeepNo(keepNo);
		}).fetchOne();

		return keep;
	}


	/**
	 * 根据代保管编号更新代保管物品
	 * */
	@Override
	public int updateKeep(Keep keep) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("KEEPNO",keep.getKeepNo());}).set(Keep.getMap(keep)).execute();
		return count;
	}


	@Override
	public IPage<Map<String, Object>> getKeepParaList(Integer pageflag, Integer maxnum, String keepno, String keeptype,
			String keepname, String strstatus, String begkeepdate, String endkeepdate, String strbrno) {

		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				if (!StringUtils.isEmpty(keepno)) {
					w.eq("KEEPNO", keepno);
				}
				if (!StringUtils.isEmpty(keeptype)) {
					w.eq("KEEPTYPE", keeptype);
				}
				if (!StringUtils.isEmpty(keepname)) {
					w.eq("KEEPNAME", keepname);
				}
				if(!StringUtils.isEmpty(strstatus)) {
					w.eq("STATUS", strstatus);
				}
				if(!StringUtils.isEmpty(strbrno)) {
					w.eq("BRANCHNO", strbrno);
				}
				if((!StringUtils.isEmpty(begkeepdate))&(!StringUtils.isEmpty(endkeepdate))) {
					w.between("KEEPDATE", begkeepdate, endkeepdate);
				}
				if((StringUtils.isEmpty(begkeepdate))&(!StringUtils.isEmpty(endkeepdate))) {
					w.op("KEEPDATE", "<=", endkeepdate);
				}
				if((!StringUtils.isEmpty(begkeepdate))&(StringUtils.isEmpty(endkeepdate))) {
					w.op("KEEPDATE", ">=", begkeepdate);
				}
			};
		};

		String[] selectList = new String[] {
				"keepno as keepno",
				"keeptype as keeptype",
				"keepnum as keepnum",
				"unit as unit",
				"status as strstatus", //代保管品状态
				"keepdate as keepdate",
				"keepname  as keepname",
				"keepphone as keepphone",
				"insummary as insummary",
				"outdate as outdate",
				"reciname as reciname",
				"reciidtype as reciidtype",
				"reciidno as reciidno",
				"reciphone as reciphone",
				"outsummary as outsummary",
				"branchno as strbranchno",
				"intellerno as intellerno",
				"outtellerno as outtellerno",
				"authtellerno as strauthtellerno", //出库授权柜员
				"keeptlrno as keeptlrno"  //保管人
		}; 

		Selecter selecter = dbo.getSelecter()
				.select(selectList)
				.from(TABLE)
				.where(whereExp);
		IPage<Map<String, Object>> iPage = selecter.selectMapsPage(pageflag,maxnum);
		return iPage;
	}

	//查询网点号的机构类型
	public String queryTypeofBranch(String brno){
		Map<String,Object> type = dbo.getSelecter().from(TABLE_BRANCH).select("type").where((w)->{
			w.eq("brno", brno);
		}).fetchOne();

		return (String)type.get("type");
	}

	//查询csis_syspara 参数表  主键000004具有总行查询代保管品权限
	public String queryBrnoFromSysPara() {
		Map<String,Object> para = dbo.getSelecter().from(TABLE_CSIS_SYSPARA).select("paracode").where((w)->{
			w.eq("paraitem", "000004"); //参数类别000004
		}).fetchOne();

		return (String)para.get("paracode");
	}

	/**
	 * 根据代保管物品类型查询代保管物品信息
	 * */
	public List<Keep> queryKeepByKeepType(String keeptype) {

		OrmSelecter<Keep> ormSelecter = ormOper.getOrmSelecter(Keep.class);
		List<Keep> keep = ormSelecter.where(w ->{
			w.setKeepType(keeptype);
		}).fetchAll();

		return keep;
	}
	
	/**
	 * 根据代保管编号修改代保管物品的保管人
	 * */
	public int updateKeepTlrNoByKeepNo(String keepNo,String keeptlrno) {
		int count = dbo.getUpdater().update(TABLE).where(w -> {w.eq("KEEPNO",keepNo);}).set("KEEPTLRNO", keeptlrno).execute();
		return count;
	}


}
