package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csicop.mbs.exception.SelectException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.DeleteException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.InsertException;
import cn.com.agree.huanan.ap.al.csicop.mbs.exception.UpdateException;
import cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.dao.QRCodeInfoDao;
import cn.com.agree.huanan.ap.al.csicop.mbs.referrerinfo.dao.ReferrerInfoDao;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;

/**
 * 二维码信息表service
 * 
 * @author guyulong
 */
@Service
public class QRCodeInfoService {
	@Autowired
	private QRCodeInfoDao qRCodeInfoDao;
	@Autowired
	private ReferrerInfoDao referrerInfoDao;
	@Autowired
	private DbOperator dbo;
	@Autowired
	private Logger logger;

	/**
	 * 二维码参数查询
	 * 
	 * @param key
	 *            唯一值 生成二维码时返回的key值
	 * @param funcid
	 *            功能值 由微网点定义的固定值 00000002-企业网银生成二维码
	 * @param patype
	 *            申成方式
	 * @return
	 */
	public Map<String, Object> findParamas(String key, String funcid, String patype) {
		logger.info("二维码参数查询");
		Map<String, Object> map = qRCodeInfoDao.findParamas(key, funcid, patype);
		if (map.size() < 1) {
			logger.error("二维码参数查询失败");
			throw new SelectException("二维码参数查询失败");
		}
		return map;
	}

	/**
	 * 二维码信息更新
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @param updateMap
	 *            更新信息
	 * @return
	 */
	public void updateQRInfo(String serialno, String tradedate, Map<String, Object> updateMap) {
		logger.info("二维码信息查询");
		int count = qRCodeInfoDao.findQRCode(serialno, tradedate);
		if (count == 0) {
			logger.error("二维码信息查询无记录");
			throw new SelectException("二维码信息查询无记录");
		}
		logger.info("二维码信息更新");
		count = qRCodeInfoDao.updateQRInfo(serialno, tradedate, updateMap);
		if (count != 1) {
			logger.error("二维码信息更新失败");
			dbo.rollback();
			throw new UpdateException("二维码信息更新失败");
		}
		dbo.commit();
	}

	/**
	 * 二维码信息删除
	 * 
	 * @param serialno
	 *            交易流水号
	 * @param tradedate
	 *            交易日期
	 * @return
	 */
	public void deleteQRInfo(String serialno, String tradedate) {
		logger.info("二维码信息查询");
		int count = qRCodeInfoDao.findQRCode(serialno, tradedate);
		if (count == 0) {
			logger.error("二维码信息查询无记录");
			throw new SelectException("二维码信息查询无记录");
		}
		logger.info("二维码信息删除");
		Map<String, Object> map = qRCodeInfoDao.findRefid(serialno, tradedate);
		count = qRCodeInfoDao.deleteQRInfo(serialno, tradedate);
		if (count != 1) {
			logger.error("二维码信息删除失败");
			dbo.rollback();
			throw new DeleteException("二维码信息删除失败");
		}
		count = referrerInfoDao.deleteQRInfo((String) map.get("refid"));
		if (count == 0) {
			logger.error("推荐人信息删除失败");
			dbo.rollback();
			throw new DeleteException("推荐人信息删除失败");
		}
		dbo.commit();
	}

	/**
	 * 根据paramas查询二维码
	 * 
	 * @param paramas
	 *            二维码参数
	 * @return
	 */
	public Map<String, Object> findQRCode(String paramas) {
		logger.info("根据paramas查询二维码");
		return qRCodeInfoDao.findQRCode(paramas);
	}

	/**
	 * 根据paramas更新二维码
	 * 
	 * @param stat
	 *            状态
	 * @param tcodeimg
	 *            二维码图片
	 * @param paramas
	 *            参数
	 * @return
	 */
	public void updateQRCode(String paramas, Map<String, Object> updateMap) {
		logger.info("根据paramas更新二维码");
		int count = qRCodeInfoDao.updateQRCode(paramas, updateMap);
		if (count != 1) {
			logger.error("根据paramas更新二维码失败");
			dbo.rollback();
			throw new UpdateException("根据paramas更新二维码失败");
		}
		dbo.commit();
	}

	/**
	 * 生成二维码
	 * 
	 * @param insertMap
	 *            二维码信息
	 * @return
	 */
	public void insertQRCode(Map<String, Object> insertMap) {
		logger.info("生成二维码");
		int count = qRCodeInfoDao.insertQRCode(insertMap);
		if (count != 1) {
			logger.error("生成二维码失败");
			dbo.rollback();
			throw new InsertException("生成二维码失败");
		}
		dbo.commit();
	}

	/**
	 * 查询二维码
	 * 
	 * @param paramas
	 *            参数
	 * @param patype
	 *            生成方式
	 * @param funcid
	 *            功能id
	 * @return
	 */
	public Map<String, Object> findQRCode(String paramas, String patype, String funcid) {
		return qRCodeInfoDao.findQRCode(paramas, patype, funcid);
	}

	/**
	 * 更新二维码
	 * 
	 * @param paramas
	 *            二维码参数
	 * @param updateMap
	 *            更新信息
	 * @return
	 */
	public void updateQRCode(String paramas, String patype, String funcid, Map<String, Object> updateMap) {
		logger.info("更新二维码");
		int count = qRCodeInfoDao.updateQRCode(paramas, patype, funcid, updateMap);
		if (count != 1) {
			logger.error("更新二维码失败");
			dbo.rollback();
			throw new UpdateException("更新二维码失败");
		}
		dbo.commit();
	};
}
