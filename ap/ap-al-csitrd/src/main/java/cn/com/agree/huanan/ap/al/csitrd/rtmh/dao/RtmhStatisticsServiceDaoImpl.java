package cn.com.agree.huanan.ap.al.csitrd.rtmh.dao;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.csitrd.rtmh.po.StatisticslInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;
import cn.com.agree.huanan.ap.tl.db.orm.OrmSelecter;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.db.std.operator.Inserter;
import cn.com.agree.huanan.ap.tl.logging.Logger;



@Component
public class RtmhStatisticsServiceDaoImpl implements RtmhStatisticsServiceDao{

	private static String TABLE = "csis_statistical_form";
	public final Logger logger = Logger.getLogger(RtmhStatisticsServiceDaoImpl.class);
	@Autowired OrmOperator  ormOper;
	@Autowired DbOperator dbo;
	
	@Override
	public int dealInfoInsert(StatisticslInfo statisticslInfo) {
		//登记交易信息
		Inserter inserter = dbo.getInserter();
		int count = inserter.insertInto(TABLE).values(StatisticslInfo.getMap(statisticslInfo)).execute();
		dbo.commit();
		return count;
	}

	
	@Override
	//更新交易信息
	public StatisticslInfo selectStatistics(String sq_commitserno, String channelserno, String printdate, String printtime, String deviceip, 
												String deviceno, String printno, String acctno, String tardeno, String tellerno, 
												String tradename, String branch, String note1) {
		OrmSelecter<StatisticslInfo> ormSelecter = ormOper.getOrmSelecter(StatisticslInfo.class);
		StatisticslInfo statisticslInfo = ormSelecter.where(w->{
			w.setSq_Commitserno(sq_commitserno);
			w.setChannelSerno(channelserno);
			w.setPrintDate(printdate);
			w.setPrintTime(printtime);
			w.setDeviceIp(deviceip);
			w.setDeviceNo(deviceno);
			w.setPrintNo(printno);
			w.setAcctNo(acctno);
			w.setTardeNo(tardeno);
			w.setTradeName(tradename);
			w.setTellerNo(tellerno);
			w.setBranch(branch);
			w.setNote1(note1);
		}).fetchOne();
		return statisticslInfo;
	}
	
	
	@Override
	//更新交易信息
	public StatisticslInfo queryStatistics(String channelserno, String printdate, String printtime, String deviceip, 
												String deviceno, String printno, String acctno, String tardeno, String tellerno, 
												String tradename, String branch, String note1) {
		OrmSelecter<StatisticslInfo> ormSelecter = ormOper.getOrmSelecter(StatisticslInfo.class);
		StatisticslInfo statisticslInfo = ormSelecter.where(w->{
			w.setChannelSerno(channelserno);
			w.setPrintDate(printdate);
			w.setPrintTime(printtime);
			w.setDeviceIp(deviceip);
			w.setDeviceNo(deviceno);
			w.setPrintNo(printno);
			w.setAcctNo(acctno);
			w.setTardeNo(tardeno);
			w.setTradeName(tradename);
			w.setTellerNo(tellerno);
			w.setBranch(branch);
			w.setNote1(note1);
		}).fetchOne();
		return statisticslInfo;
	}
	


 
}
