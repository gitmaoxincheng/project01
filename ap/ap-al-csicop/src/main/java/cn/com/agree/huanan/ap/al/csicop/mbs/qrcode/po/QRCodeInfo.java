package cn.com.agree.huanan.ap.al.csicop.mbs.qrcode.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import lombok.Data;
import oracle.sql.BLOB;

/**
 * 二维码信息表
 * 
 * @author guyulong
 */
@Data
@Table(QRCodeInfo.CSIS_NAC_QRCODE_INFO.class)
public class QRCodeInfo implements Serializable {
	private static final long serialVersionUID = 4442808240179096202L;

	private String serialno;// 交易流水号
	private String tradedate;// 交易日期
	private String tradetime;// 交易时间
	private String funcid;// 功能id
	private String paramas;// 二维码参数(功能ID+分隔符+推荐人ID
	private String tcodeurl;// 二维码url
	private BLOB tcodeimg;// 二维码图片
	private String patype;// 0--直接;1-映射
	private String stdate;// 生效日期
	private String endate;// 失效日期
	private String stat;// 状态 0-失效;1有效
	private String upddate;// 更新日期
	private String updtime;// 更新时间
	private String perpetual;// 永久有效标示 0-否;1-是
	private String refid;// 推荐人ID

	public static class CSIS_NAC_QRCODE_INFO {
	}

	public static Map<String, Object> getMap(QRCodeInfo qRCodeInfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("serialno", qRCodeInfo.getSerialno());
		map.put("tradedate", qRCodeInfo.getTradedate());
		map.put("tradetime", qRCodeInfo.getTradetime());
		map.put("funcid", qRCodeInfo.getFuncid());
		map.put("paramas", qRCodeInfo.getParamas());
		map.put("tcodeurl", qRCodeInfo.getTcodeurl());
		map.put("tcodeimg", qRCodeInfo.getTcodeimg());
		map.put("patype", qRCodeInfo.getPatype());
		map.put("stdate", qRCodeInfo.getStdate());
		map.put("endate", qRCodeInfo.getEndate());
		map.put("stat", qRCodeInfo.getStat());
		map.put("upddate", qRCodeInfo.getUpddate());
		map.put("updtime", qRCodeInfo.getUpdtime());
		map.put("perpetual", qRCodeInfo.getPerpetual());
		map.put("refid", qRCodeInfo.getRefid());
		return map;
	}
}
