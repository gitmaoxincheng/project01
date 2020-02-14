package cn.com.agree.huanan.ap.al.csiusr.branch.po;

import java.io.Serializable; 
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.al.csiusr.branch.po.Branch.csis_branch;
import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 机构信息Bean
 * @author HCP
 */
@Getter
@Setter
@ToString
@Table(csis_branch.class)
public class Branch implements Serializable {

	private static final long serialVersionUID = -1946850003911319710L;
	
	private String brno;// 机构号
	private String myBank;// 法人号
	private String upBrno;// 管辖机构号-总行、分行号、支行号
	private String oBrno;// 旧机构号
	private String brnas;// 机构简称
	private String brsta;// 机构状态 0-无效、1-有效"
	private String brna;// 机构全称
	private String enBrna;// 机构英文全称
	private String brgp;// 机构分类 0-核算机构、1-汇总机构"
	private String brpry;// 机构性质0-对内、1-对外"
	private String brtp;// 机构类型0-其他;1-社区小微;2-金库;3-营业部;4-清算中心
	private String type;// 机构层级0-总行;01-总行本部汇总;02-总行部室汇总;1-分行汇总;11-分行本部汇总;12-分行部室汇总;2-支行汇总;3-网点;30-网点汇总;4-片区汇总;5-团队;(暂时不用)6-部室;
	private String areaCode;// 国家地区代码
	private String brAddrPro;// 机构地址所在省
	private String brAddrCy;// 机构地址所在市
	private String brAddrAr;// 机构地址所在区/镇
	private String brAddr;// 机构详细地址
	private String enBrAddr;// 机构英文详细地址
	private String post;// 邮政编码
	private String branchLong;// 机构经度
	private String branchLang;// 机构纬度
	private String brallowc;// 金融机构许可证
	private String brcodc;// 金融机构代码证
	private String obrcodc;// 变更前金融机构代码证
	private String batcodc;// 统一信用代码证
	private String bkcod;// 人行联行号(二代支付)
	private String arcd33;// 银联机构号
	private String safefinCode;// 外管局金融机构代码
	private String safefinidtfyNo;// 外管局金融机构识别码
	private String swiftNo;// SWIFT编号
	private String princCertType;// 负责人证件类型
	private String busta;// 营业状态 01-预登记、02-营业、03-停业、04-合并
	private String merBrno;// 合并机构号
	private String busamTime;// 工作日公司业务上午开始营业时间
	private String busamendTime;// 工作日公司业务上午结束营业时间
	private String buspmTime;// 工作日公司业务下午开始营业时间
	private String buspmendTime;// 工作日公司业务下午结束营业时间
	private String strTime;// 工作日个人开始营业时间
	private String endTime;// 工作日个人结束营业时间
	private String satTime;// 星期六营业时间
	private String satendTime;// 星期六结束营业时间
	private String sunTime;// 星期日营业时间
	private String sunendTime;// 星期日结束营业时间
	private String build;// 成立日期时间
	private String dutyNa;// 负责人姓名
	private String dutyPh;// 负责人联系电话
	private String duty;// 负责人职务
	private String isgp;// 是否团体管理机构 0-否、1-是
	private String setDate;// 登记日期时间
	private String effDate;// 生效日期时间
	private String sdDate;// 停用日期时间
	private String merDate;// 合并日期时间
	private String outPhone;// 对外公布的联系电话
	private String loginStatus;// 签到状态 0签退、1签到
	private String brTreSta;// 机构树同步状态0-未同步、1-同步
	private String updDate;// 更新日期
	private String updTime;// 更新时间
	private String princCertNo;// 负责人证件号码

    public static class csis_branch {
        
    }
    
	/**
     * @param map 数据map，key:属性名(全大写) value：属性值
     * @return DutyInfo
     */
    public static Branch instance(Map<String, Object> map){
        return null;
    }	
    
    public static Map<String, Object> getMap(Branch branch){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("brno", branch.getBrno());// 机构号
    	map.put("mybank", branch.getMyBank());// 法人号
    	map.put("upbrno", branch.getUpBrno());// 管辖机构号-总行、分行号、支行号
    	map.put("obrno", branch.getOBrno());// 旧机构号
    	map.put("brnas", branch.getBrnas());// 机构简称
    	map.put("brsta", branch.getBrsta());// 机构状态 0-无效、1-有效"
    	map.put("brna", branch.getBrna());// 机构全称
    	map.put("enbrna", branch.getEnBrna());// 机构英文全称
    	map.put("brgp", branch.getBrgp());// 机构分类 0-核算机构、1-汇总机构"
    	map.put("brpry", branch.getBrpry());// 机构性质0-对内、1-对外"
    	map.put("brtp", branch.getBrtp());// 机构类型0-其他;1-社区小微;2-金库;3-营业部;4-清算中心
    	map.put("type", branch.getType());// 机构层级0-总行;01-总行本部汇总;02-总行部室汇总;1-分行汇总;11-分行本部汇总;12-分行部室汇总;2-支行汇总;3-网点;30-网点汇总;4-片区汇总;5-团队;(暂时不用)6-部室;
    	map.put("areacode", branch.getAreaCode());// 国家地区代码
    	map.put("braddrpro", branch.getBrAddrPro());// 机构地址所在省
    	map.put("braddrcy", branch.getBrAddrCy());// 机构地址所在市
    	map.put("braddrar", branch.getBrAddrAr());// 机构地址所在区/镇
    	map.put("braddr", branch.getBrAddr());// 机构详细地址
    	map.put("enbraddr", branch.getEnBrAddr());// 机构英文详细地址
    	map.put("post", branch.getPost());// 邮政编码
    	map.put("branchlong", branch.getBranchLong());// 机构经度
    	map.put("branchlang", branch.getBranchLang());// 机构纬度
    	map.put("brallowc", branch.getBrallowc());// 金融机构许可证
    	map.put("brcodc", branch.getBrcodc());// 金融机构代码证
    	map.put("obrcodc", branch.getObrcodc());// 变更前金融机构代码证
    	map.put("batcodc", branch.getBatcodc());// 统一信用代码证
    	map.put("bkcod", branch.getBkcod());// 人行联行号(二代支付)
    	map.put("arcd33", branch.getArcd33());// 银联机构号
    	map.put("safefincode", branch.getSafefinCode());// 外管局金融机构代码
    	map.put("safefinidtfyno", branch.getSafefinidtfyNo());// 外管局金融机构识别码
    	map.put("swiftno", branch.getSwiftNo());// SWIFT编号
    	map.put("princcerttype", branch.getPrincCertType());// 负责人证件类型
    	map.put("busta", branch.getBusta());// 营业状态 01-预登记、02-营业、03-停业、04-合并
    	map.put("merbrno", branch.getMerBrno());// 合并机构号
    	map.put("busamtime", branch.getBusamTime());// 工作日公司业务上午开始营业时间
    	map.put("busamendtime", branch.getBusamendTime());// 工作日公司业务上午结束营业时间
    	map.put("buspmtime", branch.getBuspmTime());// 工作日公司业务下午开始营业时间
    	map.put("buspmendtime", branch.getBuspmendTime());// 工作日公司业务下午结束营业时间
    	map.put("strtime", branch.getStrTime());// 工作日个人开始营业时间
    	map.put("endtime", branch.getEndTime());// 工作日个人结束营业时间
    	map.put("sattime", branch.getSatTime());// 星期六营业时间
    	map.put("satendtime", branch.getSatendTime());// 星期六结束营业时间
    	map.put("suntime", branch.getSunTime());// 星期日营业时间
    	map.put("sunendtime", branch.getSunendTime());// 星期日结束营业时间
    	map.put("build", branch.getBuild());// 成立日期时间
    	map.put("dutyna", branch.getDutyNa());// 负责人姓名
    	map.put("dutyph", branch.getDutyPh());// 负责人联系电话
    	map.put("duty", branch.getDuty());// 负责人职务
    	map.put("isgp", branch.getIsgp());// 是否团体管理机构 0-否、1-是
    	map.put("setdate", branch.getSetDate());// 登记日期时间
    	map.put("effdate", branch.getEffDate());// 生效日期时间
    	map.put("sddate", branch.getSdDate());// 停用日期时间
    	map.put("merdate", branch.getMerDate());// 合并日期时间
    	map.put("outphone", branch.getOutPhone());// 对外公布的联系电话
    	map.put("loginstatus", branch.getLoginStatus());// 签到状态 0签退、1签到
    	map.put("brtresta", branch.getBrTreSta());// 机构树同步状态0-未同步、1-同步
    	map.put("upddate", branch.getUpdDate());// 更新日期
    	map.put("updtime", branch.getUpdTime());// 更新时间
    	map.put("princcertno", branch.getPrincCertNo());// 负责人证件号码

    	return map;
    }
}
