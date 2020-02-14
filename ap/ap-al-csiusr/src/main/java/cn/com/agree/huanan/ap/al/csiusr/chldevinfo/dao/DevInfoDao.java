package cn.com.agree.huanan.ap.al.csiusr.chldevinfo.dao;

import java.util.List;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.chldevinfo.po.DevInfo;
import cn.com.agree.huanan.ap.tl.db.po.IPage;

public interface DevInfoDao {
	
	
	/**
	 * 自助设备查询
	 * @param pageFlag
	 * @param pageSize
	 * @param devtype
	 * @param devno
	 * @param status
	 * @param devip
	 * @param admbrno
	 * @param dstbrno
	 * @return
	 */
	public IPage<Map<String,Object>> selectDevInfo(int pageFlag, int pageSize,String devtype,String devno,
			String status ,String devtellerno,String admbrno,String dstbrno,String myBank );
	
	
	
	
	/**
	 * 自助设备查询
	 */
	public DevInfo queryDevInfo(String applyid);
	
	
	/**
	 * 根据设备号和设备类型查询设备信息
	 * @param devno 设备号
	 * @param devtype 设备类型
	 * @return
	 */
	public DevInfo CheckDevInfo(String devno,String devtype);
	
	/**
	 * 保存自助设备数据
	 * @param devInfo
	 * @return
	 */
	public int saveDevInfo(DevInfo devInfo);
	/**
	 * @summary 更新钱箱信息
	 */
	public int updateDevInfo(String devno,String devtype);
	
	/**
	 * @summary 自助设备修改
	 * @param map
	 * @return
	 */
	public int updateSelfDev(Map<String, Object> map,String devno,String devtype);
	
	/**
	 * @summary 自助设备改为启用状态
	 * @param status 状态
	 * @return
	 */
	public int selfdevUsing(String status);
	/**
	 * @summary 删除设备信息
	 * @param devno 设备号
	 * @param devtype 设备类型
	 */
	public int selfDevDelete(String devno, String devtype);



	/**
	 * 根据设备号查询设备信息
	 * @param devno 设备号
	 * @return
	 */
	public Map<String, Object> findDevInfo(String devno);



	/**
	 * 更新设备信息
	 * @param devno  设备号
	 * @param devtype 设备类型
	 * @param map	存储数据
	 * @return
	 */
	public int selfDevProperty(String devno, String devtype, Map<String, Object> map);



	/**
	 * 更新设备信息
	 * @param map  存储字段
	 * @param devno 设备号
	 * @param devtype 设备类型
	 * @return
	 */
	public int selfDevManage(Map<String, Object> map, String devno, String devtype);




	
	/**
	 * 虚拟柜员号查询设备信息
	 * @param tellerno
	 * @return
	 */
	public List<DevInfo> queryDevInfoByDeTelNo(String tellerno);
	
	/**
	 * 更新管理归属机构
	 * @param oldBrno 被撤并机构
	 * @param newBrno 合并机构
	 * @return
	 */
	public int updAdmBrno(String oldBrno,String newBrno);
	
	/**
	 * 更新资产归属机构
	 * @param oldBrno 被撤并机构
	 * @param newBrno 合并机构
	 * @return
	 */
	public int updDstrBrno(String oldBrno,String newBrno);

	/**
	 * 查询资产归属机构下设备数量
	 * @param strBrNo 机构号
	 * @return
	 */
	public int queryDevCountByAdmBrNo(String strBrNo);
	
	/**
	 * 查询管理归属机构下设备数量
	 * @param strBrNo 机构号
	 * @return
	 */
	public int queryDevCountByDstBrNo(String strBrNo);


	/**
	 * 根据柜员号查询设备信息
	 * @param tellerno 虚拟柜员号
	 * @return
	 */
	public int findDevInfoByTellerno(String tellerno);



	/**
	 * 根据设备号查询设备信息
	 * @param devno 设备号
	 * @return
	 */
	public DevInfo SelectDevInfo(String devno);
}
