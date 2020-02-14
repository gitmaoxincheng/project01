package cn.com.agree.huanan.ap.al.csiusr.branch.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

/**
 * 机构表操作Dao
 * @author HCP
 *
 */
public interface BranchDao {

	/**
	 * 根据机构号查询机构
	 * @param branchNo 机构号
	 * @return 机构信息
	 */
    public Branch queryBranchByNo(String branchNo);
       
        
	/**
	 * 查询柜员是否存在
	 * @param tellerNo
	 * @return
	 */
    public Branch isExistBranch(String branchNo);
    
	/**
	 * 根据机构号查询机构
	 * @param brno 机构号
	 * @param type 类型
	 * @param busta 营业状态
	 * @return
	 */
    public Branch queryBranchByCond(String brno,String type,String busta);
    
    /**
     * 根据机构号查询机构状态为正常的机构
     * @param brno 机构号
     * @param brsta 机构状态
     * @return
     */
    public Branch queryBranchByCondBrsta(String brno, String brsta);
    
    /**
     * @summary 根据机构号查询上级支行
     * @param strbrno 机构号
     * @return
     */
	public String getSuperBranch(String strbrno);
	
	/**
	 * @summary 根据上级支行查询上级分行
	 * @param mbrno 上级支行
	 * @return
	 */
	public String getLastSuperBranch(String mbrno);

	/**
	 * 机构信息查询
	 * @param curPage 当前页码
	 * @param pageSize 每页最多记录数
	 * @param strBrNo 查询机构号
	 * @return 机构信息列表
	 */
	public IPage<Map<String, Object>> queryBranchInfo(int curPage, int pageSize, String strBrNo);
	
	/**
	 * 根据机构号更新信息
	 * @param brNo 机构号
	 * @param paramMap 
	 * @return
	 */
	public int updateBranchInfo(String brNo, Map<String, Object> paramMap);

	/**
	 * 新增机构
	 * @param branch 机构对象
	 * @return 
	 */
	public int insertBranch(Map<String,Object>branchMap);
	
	/**
	 * 根据机构号更新机构状态
	 * @param brNo 机构号
	 * @param brSta 机构状态
	 * @return
	 */
	public int updateBranchStatus(String brNo,String brSta);
	
	
	/**
	 * 根据机构号修改机构类型和管辖机构号
	 * @param brno 机构号
	 * @param type 机构类型
	 * @param upBrno 管辖机构号
	 * @return 机构信息
	 */
    public int insertBranchByNo(String brno,Map<String, Object> branchMap);   
    /**
	 * 新增机构号
	 * @param brno 机构号
	 */
    public int insertBrno(String brno);
    
    
	/**
	 * 根据机构号删除机构类型和管辖机构号
	 * @param branchNo 机构号
	 * @param type 机构类型
	 * @param upBrno 管辖机构号
	 * @return 机构信息
	 */
    public int deleteBranchByNo(Map<String, Object> branchMap);
    /**
	 * 删除机构号
	 * @param brno 机构号
	 */
    public int deleteBrno(String brno);
    
    
	/**
	 * 根据机构号修改机构类型和管辖机构号
	 * @param branchMap 机构信息
	 * @param brno 机构号
	 * @param type 机构类型
	 * @param upBrno 管辖机构号
	 */
	public int updateBranchNo(Map<String, Object> branchMap);
    /**
	 * 修改机构号
	 * @param brno 机构号
	 */
    public int updateBrno(String brno);

    /**
     * 查询所有分行信息
     * @param curPage 当前页数
     * @param pageSize 页大小
     * @param myBank 法人号
     * @return 所有分行信息
     */
	public IPage<Map<String, Object>> queryZoneBranchInfo(int curPage, int pageSize, String myBank);


	/**
	 * 查询[机构信息生成]所需要的字段数据
	 */
	public List<Map<String, Object>> findBranchInfoGenerate();

	/**
	 * 查询网点
	 * @param brno 机构号
	 * @param brgp 机构分类
	 * @param brsta 机构状态
	 * @return
	 */
    public Branch queryBranchOfNetWork(String brno, String brgp, String brsta);
	
}
