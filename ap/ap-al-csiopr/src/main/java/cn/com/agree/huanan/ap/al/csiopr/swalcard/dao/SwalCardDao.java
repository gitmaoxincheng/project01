package cn.com.agree.huanan.ap.al.csiopr.swalcard.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.al.csiopr.swalcard.po.SwalCard;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface SwalCardDao {

	/**
	 * 吞没卡信息录入
	 * @param swalCard 吞没卡信息
	 * @return 操作状态
	 */
	public int insertSwalCard(SwalCard swalCard);
	
	/**
	 * 吞没卡信息更改
	 * @param swalCard
	 * @return
	 */
	public int saveSwalCard(SwalCard swalCard);
	
	/**
	 * 柜员吞没卡调入信息更新
	 * @param map
	 * @param serialno_list
	 * @return
	 */
	public int callinSwalCardupdate(Map<String,Object> map,List<String> list);
	
	/**
	 * 柜员吞没卡作废上缴信息更新
	 * @param map
	 * @param serialno_list
	 * @return
	 */
	public int turninSwalCardupdate(Map<String,Object> map,List<String> serialno_list);
	
	/**
	 * 柜员吞没卡作废接收信息更新
	 * @param map
	 * @param serialno
	 * @return
	 */
	public int updateSwalCard(Map<String, Object> map, JavaList serialno);
	
		
	/**
	 * 吞没卡作废接收查询
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> selectRecordSwalCard( Map<String, Object> paramMap);
	
	
	/**
	 * 吞没卡作废上缴查询
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> selectUpSwalCard( Map<String, Object> paramMap);

	
	/**
	 * 吞没卡调入查询
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> selectIntSwalCard( Map<String, Object> paramMap);


	/**
	 * 吞没卡信息查询
	 * @param paramMap
	 * @param list
	 * @return
	 */
	public Map<String, Object> querySwalCard(Map<String, Object> paramMap,List listBranch);
	
	
	/**
	 * 查询机构号及其下属机构
	 * @param curPage
	 * @param pageSize
	 * @param strBrNo
	 * @return
	 */
	public IPage<Map<String, Object>> selectBranchInfo(int curPage, int pageSize, String strBrNo);
	
	
	/**
	 * 根据流水号查询吞卡
	 * @param serialno
	 * @return
	 */
	public SwalCard selectSwalCardBySerialno(String serialno);
	
		
	/**
	 * 更新吞没卡状态
	 * @param swalCard
	 * @return
	 */
	public int updateSwalCard(Map<String, Object> updateMap);
	
	/**
	 * 查找调出机构
	 * @param serialno
	 * @return
	 */
	public Map<String,Object> queryOutBranch(String serialno);
	
	/**
	 * 查找流水号
	 * @param serialno
	 * @return
	 */
	public long querySerialno(String serialno);
	
	/**
	 * 检查当前保管柜员
	 * @param serialno
	 * @return
	 */
	public Map<String,Object> checkTellerNo(String serialno);
	

	/**
	 * 
	 * @param status  
	 * @param data	吞卡类型、状态、设备、卡号map
	 * @return
	 */
	public int updateSwalCard(String status,SwalCard data);

	/**
	 * 判断是否为放假日期
	 * @param timeDay
	 * @return
	 */
	public IPage<Map<String, Object>> selectHoliday(String timeDay);
}
