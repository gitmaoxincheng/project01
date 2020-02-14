package cn.com.agree.huanan.ap.al.csiusr.tellerSchedule.dao;

import java.util.List;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.entduty.po.Entduty;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;
import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerLog;

/**
 * 柜员操作流水Dao
 * @author xzf
 *
 */
public interface TellerScheduleDao {
	/**
	 * 根据调出日期、服务id和状态查询柜员操作流水
	 * @param nowDate
	 * @param svrid
	 * @param transStatus
	 * @return
	 */
    public List<TellerLog> queryByAdjdateSvridAndTransstatus(String nowDate, String svrid,String transStatus);
    /**
     * 根据机构号查询
     * @param brno
     * @return
     */
    public Branch queryByBrno(String brno);
    /**
     * 根据实体岗编码查询状态
     * @param entDutyNo
     * @return  
     */
    public Entduty queryByTellernoAndBrno(String tellerno,String brno,int i);
    /**
     * 根据柜员号查询签退状态
     * @param tellerBrno
     * @return
     */
    public List<TellerInfo> queryByTellerNo(String tellerNo);
    /**
     * 根据柜员号和网点查询柜员信息
     * @param tellerNo
     * @param Brno
     * @return
     */
    public List<TellerInfo> queryByTellerNoAndBrno(String tellerNo,String Brno);
    /**
     * 根据柜员号更新信息
     * @param tellerNo
     * @param zoneno
     * @param mbrno
     * @param brno
     * @return
     */
    public int upDateByTellerNo(String brnoFrom, String tellerNo,String zoneno,String mbrno,String brno);
    /**
     * 根据操作流水号修改交易结果
     * @param serialno
     * @param transstatus
     * @return
     */
    public int upDateBySerialNo(String serialno,String transstatus);
}
