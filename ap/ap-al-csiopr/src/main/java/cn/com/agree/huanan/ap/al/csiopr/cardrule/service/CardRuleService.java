package cn.com.agree.huanan.ap.al.csiopr.cardrule.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiopr.cardrule.dao.CardRuleInfoDao;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.dao.CardRuleOperDao;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.exception.CheckDataHasExistError;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleInfo;
import cn.com.agree.huanan.ap.al.csiopr.cardrule.po.CardRuleOper;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.CheckNotDataException;
import cn.com.agree.huanan.ap.al.csiopr.chlinfo.exception.HandleChlInfoFailException;
import cn.com.agree.huanan.ap.tl.db.po.IPage;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class CardRuleService {
	@Autowired CardRuleInfoDao cardRuleInfoDao;
	@Autowired CardRuleOperDao cardRuleOperDao;
	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	
	/**
	 * 行内卡规则新增
	 * @param map
	 */
	public int cardRuleAdd(Map<String, Object> map) {
		//查询行内卡规则信息是否存在，存在则报错返回
		String cardtype = (String) map.get("cardtype");
		CardRuleInfo cardRuleInfo = cardRuleInfoDao.findCardRuleInfo(cardtype);
		logger.info("Map<String, Object> cardRuleInfo = ; "+cardRuleInfo);
		if(cardRuleInfo!=null) {
			logger.info("行内卡规则信息已经存在,不能新增");
			throw new CheckDataHasExistError("行内卡规则信息已经存在,不能新增");
		}
		//行内卡规则审批记录是否有“待审批”的记录
		int operCount = cardRuleOperDao.findCardRuleOperInfo(cardtype,"0");
		if(operCount!=0) {
			logger.info("行内卡规则审批信息已经存在");
			throw new CheckDataHasExistError("行内卡规则审批信息已经存在");
		}
		//行内卡规则信息新增到审批表中
		logger.info("cardRuleOperDao.insertCardRuleToOper(map);");
		int result = cardRuleOperDao.insertCardRuleToOper(map);
		if(result!=1) {
			dbo.rollback();
			logger.info("行内卡规则信息插入到审批表中失败");
			throw new CheckNotDataException("行内卡规则信息插入到审批表中失败");
		}
		dbo.commit();
		return result;
		
	}

	/**
	 * 行内卡规则修改
	 * @param map
	 * @return
	 */
	public void cardRuleUpdate(String serino,String crtBrNo,String crtTlr,String crtdate,String crttime,String cardtype,String cardname,String cardlen,
			String featcode1,String featpos1,String featlen1,String featcode2,String featpos2,String featlen2,String featcode3,String featpos3,String featlen3,String featcode4,String featpos4,String featlen4,String featcode5,String featpos5,String featlen5) {
		Map<String, Object> map=new HashMap<>();
		map.put("serino", serino);
		map.put("opttype", "1");
		map.put("crtbrno", crtBrNo);
		map.put("crttlr", crtTlr);
		map.put("audstatus", "0");
		map.put("crtdate", crtdate);
		map.put("crttime", crttime);
		map.put("cardtype", cardtype);
		map.put("cardname", cardname);
		map.put("cardlen", cardlen);
		map.put("featcode1", featcode1);
		map.put("featpos1", featpos1);
		map.put("featlen1", featlen1);
		map.put("featcode2", featcode2);
		map.put("featpos2", featpos2);
		map.put("featlen2", featlen2);
		map.put("featcode3", featcode3);
		map.put("featpos3", featpos3);
		map.put("featlen3", featlen3);
		map.put("featcode4", featcode4);
		map.put("featpos4", featpos4);
		map.put("featlen4", featlen4);
		map.put("featcode5", featcode5);
		map.put("featpos5", featpos5);
		map.put("featlen5", featlen5);
		//查询行内卡规则信息是否存在，不存在则报错返回
		CardRuleInfo cardRuleInfo = cardRuleInfoDao.findCardRuleInfo(cardtype);
		if(cardRuleInfo==null) {
			logger.info("行内卡规则信息不存在");
			throw new CheckNotDataException("行内卡规则信息不存在");
		}
		//查询行内卡规则审批表中是否有“待审批”的记录
		int operCount = cardRuleOperDao.findCardRuleOperInfo(cardtype,"0");
		if(operCount!=0) {
			logger.info("行内卡规则审批信息已经存在");
			throw new CheckDataHasExistError("行内卡规则审批信息已经存在");
		}
		//行内卡规则修改信息增加到审批表中
		int result = cardRuleOperDao.insertCardRuleToOper(map);
		if(result!=1) {
			logger.info("行内卡规则修改信息插入到审批表中失败");
			throw new CheckNotDataException("行内卡规则修改信息插入到审批表中失败");
		}
		dbo.commit();
	}

	/**
	 * 行内卡规则删除
	 * @param cardtype
	 * @return
	 */
	public int cardRuleDelete(Map<String, Object> map) {
		//查询行内卡规则信息是否存在，并获取行内卡规则信息
		String cardtype = (String) map.get("cardtype");
		CardRuleInfo cardRuleInfo = cardRuleInfoDao.findCardRuleInfo(cardtype);
		if(cardRuleInfo.getCardType()==null) {
			logger.info("行内卡规则信息不存在");
			throw new CheckNotDataException("行内卡规则信息不存在");
		}		 
		//查询行内卡规则审批表中是否有“待审批”的记录
		int operCount = cardRuleOperDao.findCardRuleOperInfo(cardtype,"0");
		if(operCount!=0) {
			logger.info("行内卡规则审批信息已经存在");
			throw new CheckDataHasExistError("行内卡规则审批信息已经存在");
		}
		//行内卡规则删除信息新增到审批表中
		map.put("cardname", cardRuleInfo.getCardName());
		map.put("cardlen", cardRuleInfo.getCardLen());
		map.put("featcode1", cardRuleInfo.getFeatCode1());
		map.put("featpos1", cardRuleInfo.getFeatPos1());
		map.put("featlen1", cardRuleInfo.getFeatLen1());
		map.put("featcode2", cardRuleInfo.getFeatCode2());
		map.put("featpos2", cardRuleInfo.getFeatPos2());
		map.put("featlen2", cardRuleInfo.getFeatLen2());
		map.put("featcode3", cardRuleInfo.getFeatCode3());
		map.put("featpos3", cardRuleInfo.getFeatPos3());
		map.put("featlen3", cardRuleInfo.getFeatLen3());
		map.put("featcode4", cardRuleInfo.getFeatCode4());
		map.put("featpos4", cardRuleInfo.getFeatPos4());
		map.put("featlen4", cardRuleInfo.getFeatLen4());
		map.put("featcode5", cardRuleInfo.getFeatCode5());
		map.put("featpos5", cardRuleInfo.getFeatPos5());
		map.put("featlen5", cardRuleInfo.getFeatLen5());

		int result = cardRuleOperDao.insertCardRuleToOper(map);
		if(result!=1) {
			dbo.rollback();
			logger.info("行内卡规则修改信息插入到审批表中失败");
			throw new CheckNotDataException("行内卡规则修改信息插入到审批表中失败");
		}
		dbo.commit();
		return result;
	}

	/**
	 * 行内卡规则查询
	 * @param pageflag
	 * @param maxnum
	 * @param cardtype
	 * @param cardname
	 * @return
	 */
	public Map<String, Object> cardRuleQuery(String pageflag, String maxnum, String cardtype, String cardname) {
		logger.info("获取行内卡规则信息列表 开始");
		int curPage=Integer.parseInt(pageflag);
		if(curPage < 1) {
			logger.error("查询渠道信息待审批记录的页码不能小于1");
			throw new HandleChlInfoFailException();
		}
		IPage<Map<String,Object>> pageInfo = cardRuleInfoDao.findCardRuleList(pageflag,maxnum,cardtype,cardname);
		Map<String, Object> result = new HashMap<>();
		if (0 == pageInfo.getSize()) {
			throw new CheckNotDataException();
		}
		logger.info("获取行内卡规则信息列表   结束");
		result.put("rowcnt", pageInfo.getTotal());// 总笔数
		result.put("listnm", pageInfo.getSize());// 返回记录数
		result.put("card_list", pageInfo.getRecords());// 返回数据
		return result;
	}

	/**
	 * 行内卡规则审批查询
	 * @param cardtype
	 * @param audstatus
	 * @return
	 */
	public Map<String, Object> cardRuleOperQuery(Map<String,Object> map) {
		logger.info("获取行内卡规则审批信息列表 开始");	
		Map<String, Object> result = cardRuleOperDao.findCardRuleOperList(map);
		if (0 == ((List) result.get("oper_list")).size()) {
			throw new CheckNotDataException();
		}
		logger.info("获取行内卡规则审批信息列表 结束");		
		return result;
	}

	/**
	 * 行内卡规则变更审批
	 * @param map
	 * @return
	 */
	public void cardRuleOper(Map<String, Object> map) {
		String serino = (String)map.get("serino");
		String audstatus = (String)map.get("audstatus");
		String audate=(String)map.get("audate");
		String audtime=(String)map.get("audtime");
		String audbrno=(String)map.get("audbrno");
		String audtlr=(String)map.get("audtlr");
		String audremarks=(String)map.get("audremarks");
		//检查审批表中的审批状态是否为“待审批”
		CardRuleOper cardRuleInfo = cardRuleOperDao.checkCardRuleOper(serino);
		if(!"0".equals(cardRuleInfo.getAudStatus())) {
			logger.info("审批状态不是待审批");
			throw new CheckNotDataException("审批状态不是待审批");
		}
		//检查审批柜员是否为操作柜员
		logger.info("校验审批柜员是否与操作柜员相同");
		if (cardRuleInfo.getCrtTlr().equals(audtlr)) {
			logger.info("审批柜员与操作柜员不能相同");
			throw new ApIllegalParamException("审批柜员与操作柜员不能相同");
		}
		String opttype=cardRuleInfo.getOptType();
		CardRuleInfo cardRuleMap = new CardRuleInfo();
		cardRuleMap.setCardType(cardRuleInfo.getCardType());
		cardRuleMap.setCardName(cardRuleInfo.getCardName());
		cardRuleMap.setCardLen(cardRuleInfo.getCardLen());
		cardRuleMap.setFeatCode1(cardRuleInfo.getFeatCode1());
		cardRuleMap.setFeatPos1(cardRuleInfo.getFeatPos1());
		cardRuleMap.setFeatLen1(cardRuleInfo.getFeatLen1());
		cardRuleMap.setFeatCode2(cardRuleInfo.getFeatCode2());
		cardRuleMap.setFeatPos2(cardRuleInfo.getFeatPos2());
		cardRuleMap.setFeatLen2(cardRuleInfo.getFeatLen2());
		cardRuleMap.setFeatCode3(cardRuleInfo.getFeatCode3());
		cardRuleMap.setFeatPos3(cardRuleInfo.getFeatPos3());
		cardRuleMap.setFeatLen3(cardRuleInfo.getFeatLen3());
		cardRuleMap.setFeatCode4(cardRuleInfo.getFeatCode4());
		cardRuleMap.setFeatPos4(cardRuleInfo.getFeatPos4());
		cardRuleMap.setFeatLen4(cardRuleInfo.getFeatLen4());
		cardRuleMap.setFeatCode5(cardRuleInfo.getFeatCode5());
		cardRuleMap.setFeatPos5(cardRuleInfo.getFeatPos5());
		cardRuleMap.setFeatLen5(cardRuleInfo.getFeatLen5());
		//判断传入的审批状态,若为“2”,直接跟新审批表中的状态
		//若 为“1”，判断操作类型
		if("1".equals(audstatus)) {
			//根据操作类型进行数据库操作
			if("0".equals(opttype)) {
				//新增
				int addCount = cardRuleInfoDao.insertCardRule(cardRuleMap);
				if(addCount!=1) {
					logger.info("插入数据失败");
					throw new CheckNotDataException("插入数据失败");
				}
			}else if("1".equals(opttype)) {
				//修改
				int updateCount = cardRuleInfoDao.updateCardRule(cardRuleMap);
				if(updateCount!=1) {
					logger.info("修改数据失败");
					throw new CheckNotDataException("修改数据失败");
				}
			}else if("2".equals(opttype)) {
				//删除
				int deleteCount=cardRuleInfoDao.deleteCardRule((String)cardRuleInfo.getCardType());
				if(deleteCount!=1) {
					logger.info("删除数据失败");
					throw new CheckNotDataException("删除数据失败");
				}
			}
			dbo.commit();
		}
/*		["audstatus",
		 ["audremarks",
		 ["audbrno",
		 ["audtlr",
		 ["audate",
		 ["audtime",*/

		//更新审批表中的数据
		Map<String,Object> mapList = new HashMap<String, Object>();
		mapList.put("serino",serino);
		mapList.put("audstatus",audstatus);
		mapList.put("audremarks",audremarks);
		mapList.put("audbrno",audbrno);
		mapList.put("audtlr",audtlr);
		mapList.put("audate",audate);
		mapList.put("audtime",audtime);
		int count = cardRuleOperDao.updateCardRuleOper(mapList);
		if(count!=1) {
			dbo.rollback();
			logger.info("更新数据失败");
			throw new CheckNotDataException("更新数据失败");
		}
		dbo.commit();
	}
	
}
