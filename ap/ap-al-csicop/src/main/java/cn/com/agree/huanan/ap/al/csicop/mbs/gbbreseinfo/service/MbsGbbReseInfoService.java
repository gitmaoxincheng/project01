package cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.CardIsExistException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.IdentityCheckException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.gbbreseinfo.dao.MbsGbbReseInfoDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
/**
 * 亲子卡service层
 * @author xuzhen
 *
 */
@Service
public class MbsGbbReseInfoService {
	@Autowired
	private MbsGbbReseInfoDao mbsGbbReseInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 联网核查结果校验
	 * 
	 * @param checkResult
	 *            身份联网核查结果代码
	 */
	public void checkIdCardInfo(String checkResult) {
		logger.info("身份联网核查结果校验");
		// 身份联网核查结果校验
		if ("02".equals(checkResult)) {
			logger.debug("身份联网核查失败,姓名不一致");
			throw new IdentityCheckException("姓名不一致");
		} else if ("03".equals(checkResult)) {
			logger.debug("身份联网核查失败,身份证号不存在");
			throw new IdentityCheckException("身份证号不存在");
		} else if ("04".equals(checkResult)) {
			logger.debug("身份联网核查失败,未知错误");
			throw new IdentityCheckException("未知错误");
		} else if ("00".equals(checkResult) || "01".equals(checkResult)) {
			logger.debug("联网核查通过");
		}
	}

	/**
	 * 亲子卡申请信息录入
	 * 
	 * @param mbsGbbMap
	 *            亲子卡申请信息
	 * @return
	 */
	public Map<String, Object> addGbbCardInfo(Map<String, Object> mbsGbbMap) {
		logger.info("亲子卡申请信息录入");
		// 插入亲子卡申请信息记录
		int count = mbsGbbReseInfoDao.insertInfo(mbsGbbMap);
		if (count != 1) {
			throw new InsertException("插入亲子卡申请信息记录失败");
		}
		dbo.commit();
		// 返回信息
		Map<String, Object> map = new HashMap<>();
		map.put("branchnames", mbsGbbMap.get("branchnames"));
		map.put("status", mbsGbbMap.get("status"));
		return map;
	}

	/**
	 * 查询用户是否存在申领卡记录
	 * 
	 * @param idtftp
	 *            证件类型
	 * @param idtfno
	 *            证件号码
	 * @return
	 */
	public Map<String, Object> queryAllRese(String idtftp, String idtfno) {
		logger.info("查询用户是否存在申领卡记录");
		// 查询用户所有开卡记录
		List<Map<String, Object>> allRese = mbsGbbReseInfoDao.findAllRese(idtftp, idtfno);
		// 判断是否有开卡记录
		String isFirst = "Y";
		if (allRese.size() > 0) {
			// 不是首次开卡
			isFirst = "N";
			// 判断是否存在有效的申领卡记录
			for (Map<String, Object> map : allRese) {
				String status = map.get("status").toString();
				if ("0".equals(status) || "1".equals(status)) {
					logger.error("存在有效的申领卡记录但未领卡,暂不支持再申请银行卡");
					throw new CardIsExistException("存在有效的申领卡记录但未领卡,暂不支持再申请银行卡");
				}
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("isfirst", isFirst);
		return map;
	}

	/**
	 * 亲子卡申请信息查询
	 * 
	 * @param tellerno_brno
	 *            柜员所属机构号
	 * @param tobrno
	 *            查询信息所属机构号
	 * @param status
	 *            申请状态
	 * @param card_type
	 *            申领卡类型
	 * @param idtfno
	 *            证件号码
	 * @param phone
	 *            手机号码
	 * @param pagesize
	 *            每页条数
	 * @param pagenum
	 *            查询页面号
	 * @return
	 */
	public Map<String, Object> findParentChildCardApplyInformations(String tellerno_brno, String tobrno, String status,
			String card_type, String idtfno, String phone, String pagesize, String pagenum,
			List<Map<String, Object>> list) {
		logger.info("亲子卡申请信息查询");
		if (!"0010102301".equals(tellerno_brno)) {
			boolean sign = false;
			a: for (int count = 0; count < list.size(); count++) {
				Map<String, Object> map = list.get(count);
				if (tobrno.equals(map.get("strbrno")))
					sign = !sign;
				if (sign) {
					break a;
				}
			}
			if (!sign) {
				logger.info("查询无记录");
				throw new SelectException("查询无记录");
			}
		}
		// 查询总记录数
		int totalnum = mbsGbbReseInfoDao.findParentChildCardApplyInformationCount(tobrno, status, card_type, idtfno,
				phone);
		int intPagenum = Integer.parseInt(pagenum);
		int intpagesize = Integer.parseInt(pagesize);
		if (intPagenum < 1) {
			logger.info("页大小不能小于1");
			throw new SelectException("页大小不能小于1");
		}
		if (((intPagenum - 1) * intpagesize + 1) > totalnum) {
			logger.info("第" + intPagenum + "页没有对应的数据");
			throw new SelectException("第" + intPagenum + "页没有对应的数据");
		}
		List<Map<String, Object>> data = mbsGbbReseInfoDao.findParentChildCardApplyInformations(tobrno, status,
				card_type, idtfno, phone, pagesize, pagenum);
		// 本次查询记录数
		int listnm = data.size();
		if (listnm < 1) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data_list", data);
		resultMap.put("listnm", listnm);
		resultMap.put("pagecount", totalnum);
		return resultMap;
	}

	/**
	 * 初始化批量更新领卡状态
	 * 
	 * @param date
	 *            领卡截止日期
	 */
	public void initialUpdateGetCardStatus(String date) {
		List<Map<String, Object>> gbb = mbsGbbReseInfoDao.findGBB_TYPE(date);
		if (gbb.size() < 0) {
			logger.info("查询无记录");
			throw new SelectException("查询无记录");
		}
		logger.info("批量更新亲子卡申请状态");
		for (int i = 0; i < gbb.size(); i++) {
			String gbb_type = (String) gbb.get(i).get("gbb_type");
			String tradedate = (String) gbb.get(i).get("tradedate");
			String serialno = (String) gbb.get(i).get("serialno");
			String status = "3";
			if ("Y".equals(gbb_type))
				status = "2";
			int count = mbsGbbReseInfoDao.updateStatus(tradedate, serialno, status);
			if (count == 1) {
				dbo.commit();
			} else {
				dbo.rollback();
			}
		}
	}
	/**
	 * 获取可办卡数量
	 * @param brno 机构号
	 * @param cardType 申领卡类型
	 * @param bodrcd 凭证信息
	 * @return
	 */
	public Map<String,Object> getCardNum(String brno,String cardType, List<Map<String, Object>> bodrcd){
		//获取核心凭证数量
		int dcmtnm = 0;
		for (int i = 0; i < bodrcd.size(); i++) {
			Map<String,Object> bod = bodrcd.get(i);
			dcmtnm = dcmtnm+(int)bod.get("vchr_vol");
		}
		//判断核心凭证数量是否大于0
		int cardnum = 0;
		if(dcmtnm>0) {
			//获取机构已预约卡数量
			int count = mbsGbbReseInfoDao.findParentChildCardApplyInformationCount(brno, "0", cardType, "", "");
			//计算可办卡数量
			cardnum = dcmtnm - count ;
		}
		//判断可办卡数量
		if(cardnum<=0) {
			cardnum = 0	;
		}
		Map<String,Object>rsp = new HashMap<>();
		rsp.put("brno", brno);
		rsp.put("card_type", cardType);
		rsp.put("cardnum", cardnum+"");
		return rsp;
	}


}
