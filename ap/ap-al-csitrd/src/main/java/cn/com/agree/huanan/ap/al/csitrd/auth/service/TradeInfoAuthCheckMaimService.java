package cn.com.agree.huanan.ap.al.csitrd.auth.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.al.csitrd.auth.dao.TradeInfoAuthCheckMaimDao;
import cn.com.agree.huanan.ap.al.csitrd.auth.exception.CheckAuthlevelFailException;
import cn.com.agree.huanan.ap.al.csitrd.auth.exception.CheckEntdutyDutyInfoFail;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.DutyInfo;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.Entduty;
import cn.com.agree.huanan.ap.al.csitrd.auth.po.TradeInfoAuthCheckMaim;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeModificationException;
import cn.com.agree.huanan.ap.al.csitrd.fina.exception.TradeRegisterException;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import ocx.SMUtil;

@Service
public class TradeInfoAuthCheckMaimService {

	@Autowired DbOperator dbo;
	@Autowired Logger logger;
	@Autowired TradeInfoAuthCheckMaimDao tradeInfoAuthCheckMaimDao;

	/**
	 * 更新信息
	 * @param paramMap
	 * @return
	 */
	public int updateTradeInfoAuthCheckMaimDao(Map<String, Object> paramMap) {

		logger.info("审核授权登记簿 更新接口开始");
		int count = tradeInfoAuthCheckMaimDao.updateByDate(paramMap);
		if(count < 1) {
			logger.error("审核授权登记簿 更新失败");
			dbo.rollback();
			throw new TradeRegisterException("审核授权登记簿 更新异常");
		}
		dbo.commit();

		return count;
	}

	/**
	 * 根据验印任务号更新信息
	 * @param paramMap
	 * @return
	 */
	public int updateSealInfoDao(Map<String, Object> paramMap) {

		logger.info("审核授权登记簿 更新接口开始");
		int count = tradeInfoAuthCheckMaimDao.updateByTaskid(paramMap);
		if(count != 1) {
			logger.error("审核授权登记簿 更新失败");
			dbo.rollback();
			throw new TradeRegisterException("审核授权登记簿 更新异常");
		}
		dbo.commit();

		return count;
	}

	/**
	 * 保存信息入库
	 * @param tradeInfoAuthCheckMaim
	 * @return
	 */
	public int insertTradeInfoAuthCheckMaimDao(TradeInfoAuthCheckMaim tradeInfoAuthCheckMaim) {

		logger.info("审核授权登记簿保存接口开始");
		logger.info("reqSysId:"+tradeInfoAuthCheckMaim.getReqSysId());
		int count = tradeInfoAuthCheckMaimDao.insertTradeInfoAuthCheckMaim(tradeInfoAuthCheckMaim);
		if(count < 1) {
			logger.error("审核授权登记簿保存失败");
			dbo.rollback();
			throw new TradeModificationException("审核授权登记簿保存失败");
		}
		dbo.commit();

		return count;
	}


	/**
	 * 认证类型转换
	 * 
	 * */
	public String typeChange(String stringItem) {

		if(StringUtils.isEmpty(stringItem)) {
			return "0000";
		}

		char[] arr = stringItem.toCharArray();
		logger.info(arr.toString());
		int count = 10;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 1) {
				count = i;
				logger.info("测试:"+i);
				break;
			}
		}
		String pwdtp = String.valueOf(count);
		return pwdtp;
	}

	/**
	 * SM4解密
	 * @param randKey 随机因子
	 * @param password SM4+SM2密文
	 * @throws DecoderException 
	 * 
	 * */
	public String decryptSM4(String randKey, String password)  {
		String pass = null;
		try {
			pass = SMUtil.decryptSM4(randKey, password);
		}catch(DecoderException e) {
			throw new TradeModificationException("SM4解码失败");
		}
		return pass;
	}

	/**
	 * 岗位号、网点号、在岗状态和岗位类型级别判断是否能进行授权
	 * */
	public void authCheck(String brNo, String tellerno, String authlevel,HashMap<String, String> entity, HashMap<String, String> duty) {
		logger.info("entity:"+entity);
		logger.info("duty:"+duty);
		logger.info("根据岗位号、网点号、在岗状态、岗位类型级别和授权等级判断是否能进行授权");
		if((StringUtils.isEmpty(brNo)) || (StringUtils.isEmpty(tellerno))) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号不正确");
		}
		//实体岗查询没有数据
		if("0".equals(entity.get("listnm"))) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号不正确");
		}
		//判断是否为1-在岗
		String status = entity.get("status");
		if(!"1".equals(status)) {
			throw new CheckEntdutyDutyInfoFail("该柜员不在岗");
		}

		//获取岗位类型级别是否为A
		String dutylevel = duty.get("dutylevel");
		if(!"A".equals(dutylevel)) {
			throw new CheckEntdutyDutyInfoFail("该柜员不是授权岗");
		}

		//authlevel授权等级为空  则默认为  2-二级授权权限
		if(StringUtils.isEmpty(authlevel)) {
			authlevel = "2";
		}

		//授权等级只能为 1 或 2
		if (! ((authlevel.equals("1")) || (authlevel.equals("2"))) ) {
			throw new CheckAuthlevelFailException("授权等级不正确");
		}

		//获取该岗位的授权等级
		String level = duty.get("authlevel");
		logger.info("柜员的授权等级为："+level);
		if(StringUtils.isEmpty(level)) {
			throw new CheckEntdutyDutyInfoFail("该柜员的授权等级异常");
		}

		//需要的授权等级
		int checkLevel = Integer.parseInt(authlevel);
		//该岗位的授权等级
		int theLevel = Integer.parseInt(level);
		//该岗位的授权等级 需要大于或等于 执行的授权等级
		if( theLevel < checkLevel ) {
			throw new CheckAuthlevelFailException("该岗位授权等级不足");
		}

		logger.info("校验通过进行授权");
	}

	/**
	 * 岗位号、网点号、在岗状态和岗位类型级别判断是否能进行授权
	 * */
	public void checkEntdutyDutyinfo(String brNo, String tellerno) {

		logger.info("根据岗位号、网点号、在岗状态和岗位类型级别判断是否能进行授权");
		if((StringUtils.isEmpty(brNo)) || (StringUtils.isEmpty(tellerno))) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号不正确");
		}
		Entduty entduty = tradeInfoAuthCheckMaimDao.queryEntdutyByCond(tellerno, brNo);
		if(null == entduty) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号不正确");
		}
		logger.info("实体岗entduty:"+entduty.toString());
		//判断是否为1-在岗
		String status = entduty.getStatus();
		if(!"1".equals(status)) {
			throw new CheckEntdutyDutyInfoFail("该柜员不在岗");
		}

		//获取所属岗位类型编号
		String dutyno = entduty.getDutyno();
		DutyInfo dutyInfo = tradeInfoAuthCheckMaimDao.queryByDutyNo(dutyno);
		if(null == dutyInfo) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号所属的岗位类型不存在");
		}
		logger.info("岗位类型："+dutyInfo.toString());
		//获取岗位类型级别是否为A
		String dutylevel = dutyInfo.getDutyLevel();
		if(!"A".equals(dutylevel)) {
			throw new CheckEntdutyDutyInfoFail("该柜员不是授权岗");
		}

		logger.info("岗位号、网点号、在岗状态和岗位类型级别检查通过，可以进行授权");

	}

	/**
	 * 授权校验
	 * */
	public void checkAuthlevel(String brNo, String tellerno, String authlevel) {
		logger.info("根据柜员号、网点号以及授权等级进行授权等级检查");
		if((StringUtils.isEmpty(brNo)) || (StringUtils.isEmpty(tellerno))) {
			throw new CheckAuthlevelFailException("该岗位号和网点号不正确");
		}

		//authlevel授权等级为空  则默认为  2-二级授权权限
		if(StringUtils.isEmpty(authlevel)) {
			authlevel = "2";
		}

		//授权等级只能为 1 或 2
		if (! ((authlevel.equals("1")) || (authlevel.equals("2"))) ) {
			throw new CheckAuthlevelFailException("授权等级不正确");
		}


		//查实体岗
		Entduty entduty = tradeInfoAuthCheckMaimDao.queryEntdutyByCond(tellerno, brNo);
		if(null == entduty) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号不正确");
		}
		logger.info("实体岗entduty:"+entduty.toString());
		//判断是否为1-在岗
		String status = entduty.getStatus();
		if(!"1".equals(status)) {
			throw new CheckEntdutyDutyInfoFail("该柜员不在岗");
		}

		//获取所属岗位类型编号
		String dutyno = entduty.getDutyno();
		DutyInfo dutyInfo = tradeInfoAuthCheckMaimDao.queryByDutyNo(dutyno);
		if(null == dutyInfo) {
			throw new CheckEntdutyDutyInfoFail("该岗位号和网点号所属的岗位类型不存在");
		}
		logger.info("岗位类型："+dutyInfo.toString());
		//获取岗位类型级别是否为A
		String dutylevel = dutyInfo.getDutyLevel();
		if(!"A".equals(dutylevel)) {
			throw new CheckEntdutyDutyInfoFail("该柜员不是授权岗");
		}
		//获取该岗位的授权等级
		String level = dutyInfo.getAuthLevel();
		logger.info("柜员的授权等级为："+level);
		if(StringUtils.isEmpty(level)) {
			throw new CheckEntdutyDutyInfoFail("该柜员的授权等级异常");
		}
		//授权等级
		int checkLevel = Integer.parseInt(authlevel);
		//该岗位的授权等级
		int theLevel = Integer.parseInt(level);
		//该岗位的授权等级 需要大于或等于 执行的授权等级
		if( theLevel < checkLevel ) {
			throw new CheckAuthlevelFailException("该岗位授权等级不足");
		}
		logger.info("根据柜员号、网点号以及授权等级进行授权等级检查，检查通过");
	}

}














