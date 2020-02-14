package cn.com.agree.huanan.ap.al.csiopr.keeppara.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csiopr.keep.dao.KeepDao;
import cn.com.agree.huanan.ap.al.csiopr.keep.po.Keep;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.dao.KeepParaDao;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.DeleteKeepParaFailException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.FindNoDataException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.GetKeepParaListFailException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.InsertKeepParaFailException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.KeepParaException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.KeepParaExistException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.KeepParaNotExistException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.exception.ModifyKeepParaFailException;
import cn.com.agree.huanan.ap.al.csiopr.keeppara.po.KeepPara;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class KeepParaService {
	@Autowired KeepParaDao keepParaDao;
	@Autowired OrmOperator ormOper;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired KeepDao keepDao;

	/**
	 * 插入代保管物品参数表
	 * 
	 * */
	public String insertKeepPara(KeepPara keepPara) {

		String maxKeepTypeNo = keepParaDao.getMaxKeepTypeNo();

		// 检查是否已存在参数信息
		KeepPara keep = keepParaDao.queryKeepParaByKeeptypeno(maxKeepTypeNo);
		if(null != keep) {
			throw new KeepParaExistException(maxKeepTypeNo);
		}

		keepPara.setKeepTypeNo(maxKeepTypeNo);
		int count = keepParaDao.insertKeepPara(keepPara);
		if(count != 1) {
			logger.error("插入代保管物品参数表失败");
			throw new InsertKeepParaFailException();
		}
		logger.error("插入代保管物品参数表成功");
		logger.info("提交");
		dbo.commit();
		return maxKeepTypeNo;

	}




	/**
	 * 根据原代保管品种类编号修改代保管物品参数记录
	 * 
	 * */
	public int modifyKeepPara(KeepPara keepPara,String oldkeeptypeno) {

		// 检查是否已存在代保管参数信息
		KeepPara keep = keepParaDao.queryKeepParaByKeeptypeno(oldkeeptypeno);
		if(StringUtils.isEmpty(keep)) {
			throw new KeepParaNotExistException(oldkeeptypeno);
		}
		
		//法人隔离，检查法人号是否一致
		String oldMyBank = keep.getMyBank();
		logger.info("oldMyBank"+oldMyBank+"  MyBank"+keepPara.getMyBank());
		if(!oldMyBank.equals(keepPara.getMyBank())) {
			throw new ModifyKeepParaFailException("法人号不相同");
		}

		//当查出来的物品参数不为空 ，且该物品参数类型的物品信息有记录，那么不允许修改
		List<Keep> tempKeeps = keepDao.queryKeepByKeepType(keep.getKeepType());
		logger.info("该物品参数类型的物品信息记录数："+tempKeeps.size());
		if(tempKeeps.size() > 0) {
			logger.debug("已存在入库数据的代保管物品种类所有要素不得修改");
			throw new ModifyKeepParaFailException("已存在入库数据的代保管物品种类所有要素不得修改");
		}

		//检查新代保管品种类编号是否已存在
		String newKeepTypeNo = keepPara.getKeepTypeNo();
		//当新旧代保管种类编号不一样时，才检查新编号是否已经存在
		if(!oldkeeptypeno.equals(newKeepTypeNo)) {
			KeepPara newKeep = keepParaDao.queryKeepParaByKeeptypeno(newKeepTypeNo);
			if(!StringUtils.isEmpty(newKeep)) {
				throw new KeepParaExistException(newKeepTypeNo);
			}
		}

		//检查是否修改成功
		int count = keepParaDao.modifyKeepPara(keepPara, oldkeeptypeno);
		if(1 != count) {
			logger.error("根据原代保管品种类编号修改代保管物品参数失败");
			throw new ModifyKeepParaFailException();
		}
		logger.error("根据原代保管品种类编号修改代保管物品参数成功");
		logger.info("提交");
		dbo.commit();
		return count;
	}


	/**
	 * 根据原代保管品种类编号删除代保管物品参数记录
	 * 
	 * */
	public int deleteKeepParaByKeepTypeNo(String keeptypeno , String newMyBank) {
		KeepPara keepPara = keepParaDao.queryKeepParaByKeeptypeno(keeptypeno);

		if(null == keepPara) {
			logger.error("需要删除的代保管物品参数不存在，删除失败");
			throw new KeepParaNotExistException(keeptypeno);
		}
		
		//法人隔离
		String oldMyBank = keepPara.getMyBank();
		logger.info("oldMyBank"+oldMyBank+" newMyBank"+newMyBank);
		if(!newMyBank.equals(oldMyBank)) {
			throw new ModifyKeepParaFailException("法人号不相同");
		}
		
		//当查出来的物品参数不为空 ，且该物品参数类型的物品信息有记录，那么不允许删除
		List<Keep> tempKeeps = keepDao.queryKeepByKeepType(keepPara.getKeepType());
		logger.info("该物品参数类型的物品信息记录数："+tempKeeps.size());
		if(tempKeeps.size() > 0) {
			logger.debug("已存在入库数据的代保管物品种类的参数不允许删除");
			throw new DeleteKeepParaFailException("已存在入库数据的代保管物品种类的参数不允许删除");
		}

		int count = keepParaDao.deleteKeepParaByKeepTypeNo(keeptypeno);
		if(1 != count) {
			logger.error("根据原代保管品种类编号删除代保管物品参数记录失败");
			throw new DeleteKeepParaFailException();
		}
		logger.info("提交");
		dbo.commit();
		return count;
	}

	/**
	 * 查询代保管物品参数列表
	 * 
	 * */
	public Map<String, Object> getKeepParaList(int pageflag ,int maxnum, String keeptypeno, String keeptype , String recorddate ,String myBank){

		if(pageflag < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new GetKeepParaListFailException("pageflag");
		}
		if(maxnum < 1) {
			logger.error("每页最多记录数");
			throw new GetKeepParaListFailException("maxnum");
		}

		Map<String,Object> result = new HashMap<>();
		IPage<Map<String,Object>> pageInfo = keepParaDao.getKeepParaList(pageflag,maxnum,keeptypeno,keeptype,recorddate,myBank);

		if(0 == pageInfo.getSize()) {
			throw new FindNoDataException();
		}

		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("keep_list", pageInfo.getRecords());// 返回数据
		return result;

	}

	/**
	 * 代保管参数由总行部门维护，校验是否为总行
	 * */
	public void checkBrno(String localBrno) {
		
		logger.info("代保管参数由总行部门维护，校验是否为总行");
		//总行可以查询所有代保管品  机构类型为0表示总行
		String type = keepDao.queryTypeofBranch(localBrno);
		logger.info("机构类型："+type);
		if(!"0".equals(type)) {
			throw new KeepParaException("代保管参数维护由总行部门维护");
		}
		logger.info("代保管参数维护机构为总行部门，校验通过");

	}

}








