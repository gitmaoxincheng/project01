package cn.com.agree.huanan.ap.al.csiusr.mutitable.dao;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Selecter;
import cn.com.agree.huanan.ap.tl.db.std.subexp.JoinType;
import cn.com.agree.huanan.ap.tl.db.std.subexp.WhereExp;
import cn.com.agree.huanan.ap.tl.db.util.SqlUtil;

@Component
public class DevInfoMutiDaoImpl implements DevInfoMutiDao{
	@Autowired DbOperator dbo;
	
	@Override
	public Map<String, Object> getDevInfo(String devType, String devip,String devno) {
		// 连接机构表
		Consumer<WhereExp> onExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("cd.ADMBRNO", SqlUtil.getSqlExp("br1.BRNO"));
			}
		};
		Consumer<WhereExp> onExp2 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				w.eq("cd.DSTBRNO", SqlUtil.getSqlExp("br2.BRNO"));
			}
		};
		Consumer<WhereExp> whereExp=null;
		if(devno.equals("")) {
			whereExp = new Consumer<WhereExp>() {
				@Override
				public void accept(WhereExp w) {
					w.eq("cd.DEVTYPE", devType);
					w.eq("cd.DEVIP", devip);
				}
			};
		}else {
			whereExp = new Consumer<WhereExp>() {
				@Override
				public void accept(WhereExp w) {
					w.eq("cd.DEVNO", devno);
				}
			};
		}
		
		String[] tables= new String[] {"csis_channel_devinfo cd", "csis_branch br1", "csis_branch br2"};
		String[] selectList = new String[] {"cd.DEVNO as devno","cd.DEVTYPE as devtype","cd.DEVTYPENO as devtypeno","cd.DEVTELLERNO as devtellerno"
				,"cd.ADMBRNO as admbrno","br1.BRNAS as admbrnoname","cd.DSTBRNO as dstbrno","br2.BRNAS as dstbrnoname"
				,"cd.CSHBOXFLG as cshboxflg","cd.VCHBOXFLG as vchboxflg","cd.CSHBOXNO as cshboxno","cd.VCHBOXNO as vchboxno"
				,"cd.AREACODE as areacode","cd.OFFLINEFLG as offlineflg"};
		
		Selecter selecter = dbo.getSelecter()
							.select(selectList)
							.from(tables[0])
							.join(JoinType.LeftJoin, tables[1], onExp1)
							.join(JoinType.LeftJoin, tables[2], onExp2)
							.where(whereExp)
							.orderBy("cd.DEVNO")
							.orderBy("cd.DEVTYPE");
		Map<String, Object> devInfoMap = selecter.fetchOne();
		return devInfoMap;
	}
	public List<Map<String,Object>> getModuleInfosByDevid(String devTypeno) {
		Selecter selecter = dbo.getSelecter();
		Consumer<WhereExp> whereExp = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				// TODO 自动生成的方法存根
				if (!org.springframework.util.StringUtils.isEmpty(devTypeno)) {
					w.eq("DEVTYPENO",devTypeno);
				}
			};
		};
		Consumer<WhereExp> whereExp1 = new Consumer<WhereExp>() {
			@Override
			public void accept(WhereExp w) {
				 w.eq("t1.devmodulenum", SqlUtil.getSqlExp("t2.devmodulenum"));
				};
		};
		String[] selectList = new String[] {"t1.devmodulenum as devmodulenum","t2.devmodulename as devmodulename","t2.devmodulestapath as devmodulestapath"};
		selecter = dbo.getSelecter().from("csis_channel_devmod t1").join(JoinType.LeftJoin, "csis_channel_moduleinfo t2", whereExp1).select(selectList)
				 .where(whereExp);
		List<Map<String,Object>> result=selecter.fetchAll();
		return result;
	}

}
