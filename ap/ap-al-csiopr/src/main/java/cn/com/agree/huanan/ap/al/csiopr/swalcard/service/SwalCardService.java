package cn.com.agree.huanan.ap.al.csiopr.swalcard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.afa.util.StringUtils;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.dao.CardBoxInfoDaoImp;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.dao.SwalCardDao;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.exception.SwalOprException;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.CardBoxInfo;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.SwalCard;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

/**
 * 卡吞没管理service层
 * 
 * @author Jiangzf
 */

@Service
public class SwalCardService {
	@Autowired
	SwalCardDao swalCardDao;
	@Autowired
	DbOperator dbo;
	@Autowired
	CardBoxInfoDaoImp cardBoxInfoDaoImp;
	@Autowired
	Logger logger;

	/**
	 * 吞没卡信息录入
	 * 
	 * @param swalCard
	 */
	public void insertSwalCard(SwalCard swalCard, String numflag, String cardboxnum) {

		// 卡箱类型
		String boxType;

		// numflag 不为0不计数
		if (numflag != null && Integer.parseInt(numflag) == 0) {

			if (StringUtils.isNullOrEmpty(cardboxnum)) {
				throw new SwalOprException("记数卡箱序列号不能为空");
			}

			// 计数
			
			/**
			 * 卡类型不会有key类型
			 * if (!"09".equals(swalCard.getCardType()))
			 *		boxType = "0";
			 * else
			 *  	boxType = "1";
			 **/
			
			boxType = "1";
			String devNo = swalCard.getDevNo();
			
			
			CardBoxInfo CBox = cardBoxInfoDaoImp.selectCardBoxInfoById(devNo,cardboxnum);
			if(CBox == null) {
				throw new SwalOprException("不存在该卡箱");
			}
			
			if (Integer.parseInt(CBox.getTotNum()) < 1) {
				throw new SwalOprException("卡箱已空");
			}
			
			// 组装参数
			Map<String, Object> paramMap = SwalCard.getMap(swalCard);
			String cardstr = (String)paramMap.get("card");
			paramMap.put("devid", devNo);
			paramMap.put("cardboxnum", cardboxnum);
			paramMap.put("boxtype", boxType);
			paramMap.put("card", cardstr.substring(6, cardstr.length()-1));

			int count = cardBoxInfoDaoImp.updateTakeCard(paramMap);
			if (count < 1) {
				dbo.rollback();
				throw new SwalOprException("记数卡箱失败");
			}
		}

		// 写入交易日期
		
		//非手工录入的设置为待清机
		if (swalCard.getRecoardType().equals("1")) {
			swalCard.setStatus(SwalCard.Status.FOR_TAKE_BACK.getStatus());
		}else {
			swalCard.setStatus(SwalCard.Status.FOR_CLEAR.getStatus());
		}
		swalCard.setUpdDate(DateTimeUtil.getSysDate());
		swalCard.setUpdTime(DateTimeUtil.getSysTime());
		// 插入
		int count = swalCardDao.insertSwalCard(swalCard);
		if (count != 1) {
			dbo.rollback();
			logger.error("插入吞没卡信息失败");
			throw new SwalOprException("柜员吞没卡领回失败");
		} else {
			dbo.commit();
			logger.info("吞没卡信息录入成功");
		}

		
		
	}

	/**
	 * 柜员吞没卡领回
	 * 
	 * @param card
	 * @param keeptellerno 
	 */
	public void takeSwalCard(SwalCard card, String keeptellerno) {

		SwalCard cardToTake = swalCardDao.selectSwalCardBySerialno(card.getSerialNo());
		if(cardToTake == null) {
			//领回凭证不存在
			throw new SwalOprException("没有该凭证信息");
		}
		// 非正常或者接受状态不可以领回
		if (!SwalCard.Status.FOR_TAKE_BACK.getStatus().equals(cardToTake.getStatus()) ) {
			throw new SwalOprException("卡号:" + cardToTake.getCard() + "不可以领回");
		}
		if (!cardToTake.getKeepTellerNo().equals(keeptellerno) ) {
			throw new SwalOprException("当前操作柜员与此吞没卡保管柜员不符，不可办理本交易！");
		}
		card.setStatus(SwalCard.Status.TAKED_BACK.getStatus());
		// 领回
		int count = swalCardDao.saveSwalCard(card);
		if (count != 1) {
			dbo.rollback();
			logger.error("柜员吞没卡领回失败");
			throw new SwalOprException("柜员吞没卡领回失败");
		} else {
			dbo.commit();
			logger.info("柜员吞没卡领回成功");
		}
	}

	/**
	 * 吞没卡信息调入信息更新
	 * 
	 * @param map
	 * @param serialno_list
	 */
	public void updateCalloutSwalCard(Map<String, Object> map, List<String> list) {
		logger.info("吞没卡信息调入开始");
		int count = swalCardDao.callinSwalCardupdate(map, list);
		if (count > 0) {
			dbo.commit();
			logger.info("吞没卡信息调入更新成功");
		} else {
			dbo.rollback();
			logger.info("吞没卡流水号不存在，调入更新失败");
			throw new SwalOprException("吞没卡流水号不存在，调入更新失败");
		}
	}

	/**
	 * 柜员吞没卡作废上缴信息更新
	 * 
	 * @param map
	 * @param serialno_list
	 */
	public void updateTurninSwalCard(Map<String, Object> map, List<String> serialno_list) {
		logger.info("柜员吞没卡作废上缴开始");
		int count = swalCardDao.turninSwalCardupdate(map, serialno_list);
		if (count > 0) {
			dbo.commit();
			logger.info("柜员吞没卡作废上缴成功");
		} else {
			dbo.rollback();
			logger.info("柜员吞没卡作废上缴失败");
			throw new SwalOprException("吞没卡信息调入更新失败");
		}
		logger.info("柜员吞没卡作废上缴结束");

	}

	/**
	 * 柜员吞没卡调出
	 * 
	 * @param card
	 *            吞没卡po对象
	 * @param inBrach
	 *            调入机构号
	 * @param takeOutOper 
	 */
	public void sendSwalCard(List<Map<String, String>> serialno_list, String outBrach, String inBrach, String takeOutOper) {

		// 遍历serialno_list
		serialno_list.forEach((serialno) -> {

			SwalCard cardToTake = swalCardDao.selectSwalCardBySerialno(serialno.get("serialno"));
			
			if (cardToTake == null) {
				throw new SwalOprException("吞没卡记录不存在");
			}
			
			// 非正常或者接受状态不可以调出
			if (!SwalCard.Status.FOR_TAKE_BACK.getStatus().equals(cardToTake.getStatus())) {
				throw new SwalOprException("卡号:" + cardToTake.getCard() + "不可以调出");
			}
			//本机构只能调出本机构
			if(!cardToTake.getKeepBranch().equals(outBrach)) {
				throw new SwalOprException("非本机构吞没卡不可以调出");
			}
			
			logger.info(serialno.get("serialno"));
			SwalCard sc = new SwalCard();
			sc.setOutlrNo(takeOutOper);
			sc.setOutBranch(outBrach);
			sc.setInBranch(inBrach);
			sc.setInDate("");
			sc.setSerialNo(serialno.get("serialno"));
			sc.setStatus("03");
			sc.setOutDate(DateTimeUtil.getSysDate());
			// 调出
			int count = swalCardDao.saveSwalCard(sc);
			if (count != 1) {
				dbo.rollback();
				logger.error("柜员吞没卡调出失败");
				throw new SwalOprException("卡号:" + cardToTake.getCard() + "调出失败");
			}
		});
		
		dbo.commit();
		logger.debug("柜员吞没卡调出成功");
	}

	/**
	 * 柜员吞没卡作废接收信息更新
	 * 
	 * @param map
	 * @param serialno
	 */
	public void addSwalCard(Map<String, Object> map, List serialno) {
		logger.info("柜员吞没卡作废接收开始");
		int count = swalCardDao.turninSwalCardupdate(map, serialno);
		if (count > 0) {
			dbo.commit();
			logger.info("柜员吞没卡作废接收成功");
		} else {
			dbo.rollback();
			logger.info("柜员吞没卡作废接收失败");
		}
		logger.info("柜员吞没卡作废接收结束");
	}

	/**
	 * 吞没卡作废接收查询
	 * 
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> queryRecordSwalCard(Map<String, Object> paramMap) {
		return swalCardDao.selectRecordSwalCard(paramMap);
	}

	/**
	 * 吞没卡作废接收查询
	 * 
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> queryUpSwalCard(Map<String, Object> paramMap) {
		return swalCardDao.selectUpSwalCard(paramMap);
	}

	/**
	 * 吞没卡作废调入查询
	 * 
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> queryIntSwalCard(Map<String, Object> paramMap) {
		return swalCardDao.selectIntSwalCard(paramMap);
	}

	/**
	 * 吞没卡信息查询
	 * 
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> querySwalCard(Map<String, Object> paramMap, List listBranch) {
		return swalCardDao.querySwalCard(paramMap, listBranch);
	}

	/**
	 * 查询机构号及其下属机构
	 * 
	 * @param curPage
	 * @param pageSize
	 * @param strBrNo
	 * @return
	 */
	public Map<String, Object> queryBranchInfo(int curPage, int pageSize, String strBrNo) {
		IPage<Map<String, Object>> pageInfo = swalCardDao.selectBranchInfo(curPage, pageSize, strBrNo);
		Map<String, Object> result = new HashMap<>();
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("bodrcd_list", pageInfo.getRecords());// 返回数据
		if (pageInfo.getTotal() == 0) {
			throw new SwalOprException("机构号不存在");
		}
		return result;
	}

	/**
	 * 根据流水号查询吞没
	 * 
	 * @param serialno
	 * @return
	 */
	public SwalCard querySwalCardBySerialno(String serialno) {
		return swalCardDao.selectSwalCardBySerialno(serialno);
	}

	/**
	 * 更新吞没卡维护
	 * 
	 * @param swalCard
	 *            Maoxc
	 */
	public void changeSwalCard(String serialno, String status) {
		// 参数检验
		if (StringUtils.isNullOrEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");
		} else if (StringUtils.isNullOrEmpty(status)) {
			throw new ApIllegalParamException("status");
		}
		// 参数
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("serialno", serialno);
		paramMap.put("status", status);
		paramMap.put("outdate", "");//清空调出日期
		paramMap.put("outlrno", "");//清空调出柜员	
		paramMap.put("outbranch", "");//清空调出机构
		paramMap.put("indate", "");//清空调入日期	
		paramMap.put("inbranch", "");//清空调入机构
		
		
		
		// 更新
		int count = swalCardDao.updateSwalCard(paramMap);
		if (count != 1) {
			logger.error("更新失败");
			dbo.rollback();
			throw new SwalOprException("更新失败");
		}
		dbo.commit();
		logger.info("更新成功");
	}

	/**
	 * 吞没卡作废接收
	 * 
	 * @param swalCard
	 *            Maoxc
	 */
	public void changeSwalCardRecord(String serialno, String status, String currentTime, String keeptellerno) {
		// 参数检验
		if (StringUtils.isNullOrEmpty(serialno)) {
			throw new ApIllegalParamException("serialno");
		} else if (StringUtils.isNullOrEmpty(status)) {
			throw new ApIllegalParamException("status");
		} else if (StringUtils.isNullOrEmpty(currentTime)) {
			throw new ApIllegalParamException("currentTime");
		} else if (StringUtils.isNullOrEmpty(keeptellerno)) {
			throw new ApIllegalParamException("keeptellerno");
		}
		// 参数
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("serialno", serialno);
		paramMap.put("status", status);
		paramMap.put("recvdate", currentTime);
		paramMap.put("keeptellerno", keeptellerno);
		// 更新
		int count = swalCardDao.updateSwalCard(paramMap);
		if (count != 1) {
			logger.error("更新失败");
			dbo.rollback();
			throw new SwalOprException("更新失败");
		}
		dbo.commit();
		logger.info("更新成功");
	}
	
	/**
	 * 检查调入机构是否跟调出机构相同
	 * @param serialno
	 */
	public void checkBranch(String serialno,String inBranch) {
		Map<String,Object> outBranch=swalCardDao.queryOutBranch(serialno);
		logger.info("outBranch"+outBranch);
		long count=swalCardDao.querySerialno(serialno);
		if(count==0) {
			throw new SwalOprException("该流水号"+serialno+"不存在");
		}
		if(StringUtils.isNullOrEmpty((String)outBranch.get("outbranch"))) {
			throw new NullPointerException("该流水号"+serialno+"对应的调出机构为空");
		}
		if(outBranch.get("outbranch").equals(inBranch)) {
			throw new SwalOprException("该流水号"+serialno+"对应的调入机构与调出机构相同");
		}
	}
	/**
	 * 检查当前机构柜员号是否与操作柜员一致
	 * @param serialno
	 * @param operTeller
	 */
	public void queryTellerNo(String serialno,String operTeller,String inBrach) {
		Map<String,Object> keeptellerno=swalCardDao.checkTellerNo(serialno);
		logger.info("keeptellerno"+keeptellerno);
		if(StringUtils.isNullOrEmpty((String)keeptellerno.get("keeptellerno"))) {
			throw new SwalOprException("该流水号"+serialno+"无对应记录");
		}
		if(!((String)keeptellerno.get("keepbranch")).equals(inBrach)) {
			throw new SwalOprException("当前机构号与该流水号"+serialno+"对应的保管机构不一致，不能上缴");
		}
		if(!((String)keeptellerno.get("keeptellerno")).equals(operTeller)) {
			throw new SwalOprException("输入柜员号与该流水号"+serialno+"对应的保管柜员号不一致，不能上缴");
		}
		if(!((String)keeptellerno.get("status")).equals("00")) {
			throw new SwalOprException("该流水号"+serialno+"对应的卡状态非法，不能上缴");
		}
		
	}
	/**
	 * 检查调入柜员与原来柜员是否相同
	 * @param serialno
	 * @param operTeller
	 * @param inBrach
	 */
	public void checkTellerNo(String serialno,String operTeller,String inBrach) {
		Map<String,Object> keeptellerno=swalCardDao.checkTellerNo(serialno);
		logger.info("keeptellerno ： "+keeptellerno);
		logger.info("operTeller ： "+operTeller);
		logger.info("inBrach ： "+inBrach);
		if(StringUtils.isNullOrEmpty((String)keeptellerno.get("keeptellerno"))) {
			throw new SwalOprException("该流水号"+serialno+"无对应记录");
		}
		if(StringUtils.isNullOrEmpty((String)keeptellerno.get("outbranch"))  && StringUtils.isNullOrEmpty((String)keeptellerno.get("outlrno"))) {
			throw new SwalOprException("该流水号"+serialno+"对应的吞没卡还未调出，不能调入");
		}
		if(((String)keeptellerno.get("outbranch")).equals(inBrach)) {
			if(((String)keeptellerno.get("outlrno")).equals(operTeller)) {
				throw new SwalOprException("该流水号"+serialno+"对应的当前吞没卡保管柜员号与调入操作柜员号一致，不能调入");
			}
		}
	}

	/**
	 * 吞没卡信息录入确认
	 * @param serialno	吞没流水
	 * @param swalCard	待更新吞没卡数据体
	 */
	public void repleSwal(String serialno,SwalCard swalCard) {
		SwalCard sc = swalCardDao.selectSwalCardBySerialno(serialno);
		if (sc == null) {
			throw new SwalOprException("该流水号"+serialno+"无对应记录");
		}
		if (!sc.getRecoardType().equals("0")) {
			throw new SwalOprException("该吞没卡交易非自助设备吞卡，不可修改");
		}
		if (!sc.getStatus().equals(SwalCard.Status.FOR_CLEAR.getStatus())) {
			throw new SwalOprException("该吞没卡交易当前状态不可修改");
		}
		swalCard.setSerialNo(serialno);
		swalCard.setStatus(SwalCard.Status.FOR_TAKE_BACK.getStatus());
		
		/**
		 * 手动适配updateSwalCard方法
		 */
		Map<String,Object> map = new HashMap<>();
		map.put("serialno", swalCard.getSerialNo());
		map.put("swalldate", swalCard.getSwallDate());
		map.put("swalltime", swalCard.getSwallTime());
		map.put("banktype", swalCard.getBankType());
		map.put("cardtype", swalCard.getCardType());
		map.put("card", swalCard.getCard());
		map.put("cardname", swalCard.getCardName());
		map.put("status", swalCard.getStatus());
		map.put("remarks", swalCard.getRemarks());
		
		int count = swalCardDao.updateSwalCard(map);
		if (count != 1) 
			throw new SwalOprException("吞没卡状态更新失败");
	}
	
	/**
	 * 自助设备领回交易
	 * @param swalCard
	 */
	public void updDeviceTakeBack(SwalCard swalCard) {
		
		swalCard.setStatus("02");	//代清机状态
		swalCard.setRecoardType("0");		//设备录入
		swalCard.setUpdDate(DateTimeUtil.getSysDate());
		swalCard.setUpdTime(DateTimeUtil.getSysTime());
		
		int updcount = swalCardDao.updateSwalCard("06",swalCard);
		
		if (updcount < 1) {
			dbo.rollback();
			throw new SwalOprException("无任何吞没卡可领回");
		}
		dbo.commit();
	}

	public int queryHoliday(String timeDay) {
		IPage<Map<String, Object>> pageInfo =  swalCardDao.selectHoliday(timeDay);			
		Map<String, Object> result = new HashMap<>();
		int count = (int) pageInfo.getTotal();
		logger.info("@server的count总行数:"+count);
		int Size =  (int) pageInfo.getSize();
		logger.info("@server的Size总记录数:"+Size);
		List<Map<String, Object>> list =  pageInfo.getRecords();	   
		logger.info("@server的list总记录数:"+list);
		int num = (int) list.get(0).get("count(*)");
		logger.info("@server的num总记录数:"+num);
		if(num != 0) {
			return 1;
		}
		return 0;
	}
}
