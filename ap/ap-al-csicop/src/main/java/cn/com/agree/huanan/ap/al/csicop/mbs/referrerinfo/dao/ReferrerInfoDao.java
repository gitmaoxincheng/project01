package cn.com.agree.huanan.ap.al.csicop.mbs.referrerinfo.dao;

import java.util.List;
import java.util.Map;

/**
 * 推荐人信息表dao
 * 
 * @author guyulong
 */
public interface ReferrerInfoDao {
	/**
	 * 查询推荐人信息
	 * 
	 * @param reftype
	 *            推荐人类型
	 * @param refname
	 *            推荐人姓名
	 * @param persno
	 *            人事编号
	 * @param brno
	 *            机构号
	 * @param refphone
	 *            推荐人手机号
	 * @param stagductcode
	 *            分期产品代码
	 * @param instjectcode
	 *            分期项目代码
	 * @param rebankno
	 *            收款账户开户行号
	 * @param reaccount
	 *            收款账号
	 * @param reaccount_name
	 *            收款账号户名
	 * @param projno
	 *            项目编号
	 * @param entename
	 *            代发企业名称
	 * @param cardbranch
	 *            固定机构网点号
	 * @return
	 */
	Map<String, Object> findReferrerInfo(String reftype, String refname, String persno, String brno, String refphone,
			String stagductcode, String instjectcode, String rebankno, String reaccount, String reaccount_name,
			String projno, String entename, String cardbranch);

	/**
	 * 新增推荐人信息
	 * 
	 * @param referrerInfo
	 *            推荐人信息
	 * @return
	 */
	int insertInfo(Map<String, Object> referrerInfo);

	/**
	 * 推荐人信息查询
	 * 
	 * @param reftype
	 *            推荐人类型
	 * @param refname
	 *            推荐人名字
	 * @param refphone
	 *            推荐人手机
	 * @param refidno
	 *            推荐人证件号
	 * @param persno
	 *            人事编号
	 * @param projno
	 *            项目编号
	 * @param refid
	 *            推荐人id
	 * @param stagductcode
	 *            分期产品代码
	 * @param instjectcode
	 *            分期项目代码
	 * @return
	 */
	List<Map<String, Object>> findReferrerInfo(String reftype, String refname, String refphone, String refidno,
			String persno, String projno, String refid, String stagductcode, String instjectcode);

	/**
	 * 推荐人信息查询(aweb)
	 * 
	 * @param refid
	 *            推荐人id
	 * @return
	 */
	Map<String, Object> findReferrerInfo(String refid);

	/**
	 * 查询身份类型
	 * 
	 * @param refid
	 *            推荐人id
	 * @return
	 */
	Map<String, Object> findReftype(String refid);

	/**
	 * 推荐人信息删除
	 * 
	 * @param refid
	 *            推荐人id
	 * @return
	 */
	int deleteQRInfo(String refid);
}
