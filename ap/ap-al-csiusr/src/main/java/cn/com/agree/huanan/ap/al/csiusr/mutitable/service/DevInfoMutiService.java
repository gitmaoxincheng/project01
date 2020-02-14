package cn.com.agree.huanan.ap.al.csiusr.mutitable.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csiusr.branch.dao.BranchDao;
import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch;
import cn.com.agree.huanan.ap.al.csiusr.mutitable.dao.DevInfoMutiDao;
import cn.com.agree.huanan.ap.rl.bank.base.dao.SysParaDao;
import cn.com.agree.huanan.ap.tl.exception.busi.ApSelectNotFoundException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class DevInfoMutiService {

	@Autowired DevInfoMutiDao devInfoMutiDao;
	@Autowired BranchDao branchDao;
	@Autowired SysParaDao sysParaDao;
	@Autowired Logger logger;
	
	/**
	 * 获取设备信息
	 * @param devNo 自助设备号
	 * @param devType 设备类型
	 * @param dev 设备型号
	 * @return 设备信息
	 */
	public Map<String, Object> getDevInfo(String devType, String devip,String devno) {
		Map<String, Object> devInfo = devInfoMutiDao.getDevInfo(devType, devip,devno);
		if (null == devInfo || devInfo.isEmpty()) {
			throw new ApSelectNotFoundException("设备信息");
		}
		return devInfo;
	}
	/**
	 * 获取设备的支行、分行号
	 * 
	 */
	public Map<String ,String> getMAndZNo(String brno){
		Map<String,String> map=new HashMap<>();
		Branch branch=branchDao.queryBranchByNo(brno);
		if(branch==null) {
			throw new ApSelectNotFoundException("设备的机构号");
		}
		map.put("myBank", branch.getMyBank());
		//本身是分行
		if(branch.getType().equals("1")) {
			map.put("Zno",brno);
		}//本身是总行
		else if(branch.getType().equals("0")) {
			
		}//本身是支行
		else if(branch.getType().equals("2")) {
			map.put("Mno", brno);
			String Zno=branchDao.getLastSuperBranch(brno);
			map.put("Zno", Zno);
		}//本身是网点
		else{
			String Mno=branchDao.getSuperBranch(brno);
			String Zno=branchDao.getLastSuperBranch(Mno);
			map.put("Mno", Mno);
			map.put("Zno", Zno);
		}
		return map;
	}
	//根据设备id查询出所有的模板信息
	public List<Map<String,Object>> getModuleInfosByDevno(String devno){
		  return devInfoMutiDao.getModuleInfosByDevid(devno);
	  }
}
