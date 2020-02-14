package cn.com.agree.huanan.ap.al.csicop.mbs.zcd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.zcd.dao.ZcdReservedInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.zcd.po.ZcdReservedInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 政采贷预约信息表service层
 * 
 * @author guyulong
 */
@Service
public class ZcdReservedInfoService {
	@Autowired
	private ZcdReservedInfoDao zcdReservedInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 向政财贷预约信息表中插入预约信息
	 * 
	 * @param zcdReservedInfo
	 *            预约信息
	 * @return
	 */
	public Map<String, Object> insertInfo(Map<String, Object> zcdReservedInfo) {
		logger.info("向政财贷预约信息表中插入预约信息");
		int count = zcdReservedInfoDao.insertInfo(zcdReservedInfo);
		if (count != 1) {
			logger.error("插入数据失败");
			dbo.rollback();
			throw new InsertException("插入数据失败");
		}
		dbo.commit();
		// 返回数据结果集
		Map<String, Object> map = new HashMap<>();
		map.put("appserialno", zcdReservedInfo.get("serialno"));
		map.put("status", zcdReservedInfo.get("status"));
		return map;
	}

	/**
	 * 政采贷申请概要信息查询
	 * 
	 * @param busiNo
	 *            营业执照号码
	 * @param status
	 *            状态
	 * @param staDate
	 *            起始日期
	 * @param endDate
	 *            截止日期
	 * @param pageSize
	 *            每页查询条数
	 * @param pageNumb
	 *            查询页码
	 * @param linkPhone
	 *            联系人手机号码
	 * @return
	 */
	public Map<String, Object> findOutlineInfos(String busiNo, String status, String staDate, String endDate,
			String pageSize, String pageNumb, String linkPhone) {
		logger.info("查询政采贷申请概要信息");
		// 查询总记录数
		int totalnum = zcdReservedInfoDao.findOutlineInfoAll(busiNo, status, staDate, endDate, linkPhone);
		int pagenumb = Integer.parseInt(pageNumb);
		int pagesize = Integer.parseInt(pageSize);
		if (pagenumb < 1) {
			logger.info("页大小不能小于1");
			throw new SelectException("页大小不能小于1");
		}
		if (((pagenumb - 1) * pagesize + 1) > totalnum) {
			logger.info("第" + pagenumb + "页没有对应的数据");
			throw new SelectException("第" + pagenumb + "没有对应的数据");
		}
		List<Map<String, Object>> data = zcdReservedInfoDao.findOutlineInfos(busiNo, status, staDate, endDate, pageSize,
				pageNumb, linkPhone);
		// 本次查询记录数
		int listnm = data.size();
		if (listnm < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data_list", data);
		resultMap.put("listnm", listnm);
		resultMap.put("totalnum", totalnum);
		return resultMap;
	}

	/**
	 * 政采贷申请明细信息查询
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	public Map<String, Object> findDetailedInfo(String serialno, String tradedate) {
		logger.info("查询申请明细信息");
		// 查询预约登记新表记录
		ZcdReservedInfo zcdInfo = zcdReservedInfoDao.findDetailedInfo(serialno, tradedate);
		if (zcdInfo == null) {
			logger.error("查询失败,数据不存在");
			throw new SelectException("查询失败,数据不存在");
		}
		// 预填单业务明细信息
		Map<String, Object> map = new HashMap<>();
		map.put("status", zcdInfo.getStatus());
		map.put("busino", zcdInfo.getBusino());
		map.put("compname", zcdInfo.getCompname());
		map.put("finaname", zcdInfo.getFinaname());
		map.put("mobitl", zcdInfo.getLinkphone());
		map.put("succitem", zcdInfo.getSuccitem());
		map.put("succmoney", zcdInfo.getSuccmoney());
		map.put("finamoney", zcdInfo.getFinamoney());
		map.put("result", zcdInfo.getResult());
		return map;
	}

	/**
	 * 更改政采贷审核申请信息
	 * 
	 * @param tradeDate
	 *            交易日期
	 * @param serialno
	 *            交易流水号
	 * @param updateInfo
	 *            更改信息
	 * @return
	 */
	public void updateInfo(String tradeDate, String serialNo, Map<String, Object> updateInfo) {
		logger.info("更改政采贷审核申请信息");
		int count = zcdReservedInfoDao.findInfo(serialNo, tradeDate);
		if (count < 1) {
			logger.error("数据库无对应信息");
			dbo.rollback();
			throw new SelectException("数据库无对应信息");
		}
		count = zcdReservedInfoDao.updateInfo(tradeDate, serialNo, updateInfo);
		if (count != 1) {
			logger.error("更改政采贷审核申请信息失败");
			dbo.rollback();
			throw new UpdateException("更改政采贷审核申请信息失败");
		}
		dbo.commit();
	}

	/**
	 * MNTW0020 政采贷数据同步 对应的 MBS021 政财贷待办事宜查询
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradeDate
	 *            交易日期
	 * @param pageSize
	 *            每页查询条数
	 * @return
	 */
	public Map<String, Object> findWaitHandleInfos(String serialNo, String tradeDate, String pageSize) {
		logger.info("政采贷数据同步(政采贷待办事宜查询)");
		// 查询总记录数
		int totalnum = zcdReservedInfoDao.findWaitHandleInfoAll(serialNo, tradeDate);
		if (1 > totalnum) {
			logger.info("没有对应的数据");
			throw new SelectException("没有对应的数据");
		}
		List<Map<String, Object>> data = zcdReservedInfoDao.findWaitHandleInfos(serialNo, tradeDate, pageSize);
		// 本次查询记录数
		int listnm = data.size();
		if (listnm < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data_list", data);
		resultMap.put("listnm", listnm);
		resultMap.put("totalnum", totalnum);
		return resultMap;
	}

	/**
	 * 查询手机号
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	public String findPhoneNumber(String serialno, String tradedate) {
		logger.info("查询手机号");
		Map<String, Object> map = zcdReservedInfoDao.findPhoneNumber(serialno, tradedate);
		return (String) map.get("linkphone");
	}
}
