package cn.com.agree.huanan.ap.al.csiusr.teller.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.teller.po.TellerInfo;


/**
 * 柜员操作Dao
 * @author HCP
 *
 */
public interface TellerDao {

    /**
	 * 根据柜员号查询柜员
	 * @param tellerNo
	 * @return
	 */
    public List<TellerInfo> selectTellerByTellerNo(String tellerNo);
    
    /**
	 * 根据网点号查询柜员
	 * @param brNo
	 * @return
	 */
    public List<TellerInfo> selectTellerByBrNo(String brNo);

	/**
	 * 根据主键查询柜员
	 * @param tellerNo
	 * @param brno
	 * @return
	 */
    public TellerInfo queryTellerByNo(String tellerNo,String brno);
    
	/**
	 * 新增柜员信息
	 * @param tellerInfo
	 * @return
	 */
    public int insertTeller(TellerInfo tellerInfo);
    
	/**
	 * 查询柜员是否存在
	 * @param tellerNo
	 * @return
	 */
    public TellerInfo isExistTeller(String tellerNo);
	
	/**
	 * 删除柜员
	 * @param tellerNo
	 * @param brno
	 * @return
	 */
    public int deleteByCon(String tellerNo,String brno);
    
    /**
     * 更改柜员所属网点
     * @param strTellerNo	柜员号
     * @param brNo	网点号
     * @param map	更改信息
     * @return
     */
    public int updateTelInfoByTeNoABrNo(String strTellerNo, String brNo, Map<String, Object> map);


	/**
	 * 根据网点查询柜员信息表，获取该网点的柜员数量
	 * @param brno 网点号
	 */
	public int selectTellerCountByTellerno(String brno);
	
    /**
     *  更改柜员类型
     * @param strTellerNo
     * @param tellertype
     * @param strbrno 
     * @return
     */
    public int updateTellerByTellerNo(String strTellerNo, String tellertype, String strbrno);


    /**
     *  更改柜员状态为注销
     * @param tellerno  柜员号
     * @param admBrno	管理机构
     * @return
     */
	public int updateTellerInfo(String tellerno,String admBrno);
    
	/**
	 * 更新柜员所属机构号,支行号,分行号
	 * @param oldBrno 被并机构号
	 * @param newBrno 主机构行属信息
	 * @return 
	 * @author xuzhen
	 */
    public int updateTellerBrno(String oldBrno,Map<String,Object> newBrno);
    
    /**
     * 查询网点正常柜员数量
     * @param brno 机构号
     * @return
     */
    public int queryNormalTellerByBrNo(String brno);

    
}
