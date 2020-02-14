package cn.com.agree.huanan.ap.al.csitrd.fina.dao;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.fina.po.Tradfinamain;

/**
 * 基金定期定额Dao层
 * @author jiangzf
 */
@Component
public class FundDaoImpl extends BaseTradfinamainDaoImpl implements FundDao {

	/**
	 * 基金定期定额新增
	 */
	@Override
	public int addFundTrade(Tradfinamain tFina) {
		return this.stdInsertTradfinamain(tFina);
	}

	/**
	 * 基金定期定额记录更新
	 */
	@Override
	public int updataFundTrade(Tradfinamain tFina) {
		return this.stdUpdataTradfinamain(tFina);
	}

}
