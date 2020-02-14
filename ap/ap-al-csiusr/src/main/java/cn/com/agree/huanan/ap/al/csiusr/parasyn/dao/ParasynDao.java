package cn.com.agree.huanan.ap.al.csiusr.parasyn.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.parasyn.po.Parasyn;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 * 综合后管同步登记表Dao
 * @author xuzhen
 *
 */
public interface ParasynDao {
	
	/**
	 * 登记操作信息
	 * @param parasysMap 登记信息
	 * @return
	 */
	public int insert(Map<String,Object>parasynMap);

	/**
	 * 根据操作流水号更新同步登记表信息
	 * @param serialNo 交易流水号
	 * @param parasynMap 登记信息
	 * @return
	 */
	public int updateParasynInfo(String serialNo,Map<String,Object>parasynMap);
	
	/**
	 * 根据操作流水号查询该操作流水号的信息
	 * @param serialNo
	 * @return
	 */
	public Parasyn queryBySerialNo(String serialNo);
	
//	/**
//	 * 根据推送批次号查询该操作流水号的信息
//	 * @param batchNo 推送批次号
//	 * @return
//	 */
//	public Parasyn queryByBatchNo(String batchNo);
	
	/**
	 * 查询机构撤并明细列表
	 * @param strbrno 被撤并机构号
	 * @param unbrno 并入机构号
	 * @param strdate 日期
	 * @param strstatus 处理状态
	 * @param pagenum 查询页码
	 * @param pagesize 查询条数
	 * @return
	 */
	public IPage<Map<String, Object>> queryDetailInfo(String strbrno, String unbrno, String strdate, String strstatus,
			int pagenum, int pagesize);

	/**
	 * 更新撤并状态
	 * @param serialno 流水号
	 * @param optdate 操作日期
	 * @param updInfo 状态信息
	 */
	public int updateMergeSta(String serialno, String optdate, Map<String, Object> updInfo);
	
	/**
	 * 根据网点号和操作类型查询该操作信息
	 * @param brNo 网点号
	 * @param optType 操作类型
	 * @return
	 */
	public List<Parasyn> queryByBrNoAndOptType(String brNo, String optType);
	
	/**
	 * 查询被并机构撤并记录数
	 * @param strBrNo 被并机构
	 * @return
	 */
	public int queryParaInfoNum(String strBrNo);
	
	/**
	 * 查询所有需回写的同步记录
	 * @param wtnum 回写次数
	 * @return
	 */
	public List<Map<String,Object>>queryBackWriteList(int wtnum);
	
	/**
	 * 获取所有当日待执行的撤并记录
	 * @param nowDate 当前日期
	 * @return
	 */
	public List<Map<String,Object>>queryBackoutList(String nowDate);
	
	/**
	 * 更新超期未处理状态
	 * @param nowDate 当前日期
	 * @return
	 */
	public int updOutOfDate(String nowDate);

}
