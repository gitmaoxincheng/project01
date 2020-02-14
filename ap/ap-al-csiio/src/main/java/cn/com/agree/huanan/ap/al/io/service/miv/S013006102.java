package cn.com.agree.huanan.ap.al.io.service.miv;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC.S013006102 联网核查企业信息查询.获取工商登记联网核查结果 
 * S0130061.02 043709
 * 0437 企业信息联网核查模块
 * @author XZF
 */
@Component
public class S013006102 extends EsbChannelService {

	private static S013006102_I i = new S013006102_I();
	private static S013006102_O o = new S013006102_O();
	public S013006102() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013006102_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("origchannelcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchannelcode", 3,0, true, "原渠道代码" )))
					.addNode(new FieldNode("origchanneldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchanneldate", 8,0, true, "原渠道日期" )))
					.addNode(new FieldNode("origchannelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "origchannelserno", 40,0, true, "原渠道流水" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class S013006102_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("chekstep", new MsgField(ContentEnum.MessageType.STRING.toString(), "chekstep", 1,0, true, "核查进度" )))
					.addNode(new FieldNode("result", new MsgField(ContentEnum.MessageType.STRING.toString(), "result", 4,0, false, "登记信息核查结果" )))
					.addNode(new FieldNode("dataresrcdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "dataresrcdt", 8,0, false, "数据源日期" )))
					.addNode(new FieldNode("entityname", new MsgField(ContentEnum.MessageType.STRING.toString(), "entityname", 100,0, false, "字号名称" )))
					.addNode(new FieldNode("unisoccdtcd", new MsgField(ContentEnum.MessageType.STRING.toString(), "unisoccdtcd", 18,0, false, "统一社会信用代码" )))
					.addNode(new FieldNode("companytype", new MsgField(ContentEnum.MessageType.STRING.toString(), "companytype", 128,0, false, "市场主体类型" )))
					.addNode(new FieldNode("domicile", new MsgField(ContentEnum.MessageType.STRING.toString(), "domicile", 512,0, false, "经营场所" )))
					.addNode(new FieldNode("regcptl", new MsgField(ContentEnum.MessageType.INT.toString(), "regcptl", 17,2, false, "资金数额" )))
					.addNode(new FieldNode("establishdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "establishdate", 8,0, false, "成立日期" )))
					.addNode(new FieldNode("opprdfrom", new MsgField(ContentEnum.MessageType.STRING.toString(), "opprdfrom", 8,0, false, "经营期限自" )))
					.addNode(new FieldNode("opprdto", new MsgField(ContentEnum.MessageType.STRING.toString(), "opprdto", 8,0, false, "经营期限至" )))
					.addNode(new FieldNode("status", new MsgField(ContentEnum.MessageType.STRING.toString(), "status", 128,0, false, "登记状态" )))
					.addNode(new FieldNode("lawcna", new MsgField(ContentEnum.MessageType.STRING.toString(), "lawcna", 200,0, false, "经营者姓名" )))
					.addNode(new FieldNode("busiscope", new MsgField(ContentEnum.MessageType.STRING.toString(), "busiscope", 128,0, false, "经营范围" )))
					.addNode(new FieldNode("regauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "regauth", 300,0, false, "登记机关" )))
					.addNode(new FieldNode("approvaldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "approvaldate", 8,0, false, "核准日期" )))
					.addNode(new FieldNode("tradedate", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradedate", 8,0, false, "核查日期" )))
					.addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 30,0, false, "核查流水" )))
					.addNode(new FieldNode("totalinvestornum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalinvestornum", 6,0, false, "投资人总记录数" )))
					.addNode(new FieldNode("investornum", new MsgField(ContentEnum.MessageType.STRING.toString(), "investornum", 6,0, false, "当前页投资人记录数" )))
					.addNode(new FieldNode("totalmanagernum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalmanagernum", 6,0, false, "高管总记录数" )))
					.addNode(new FieldNode("managernum", new MsgField(ContentEnum.MessageType.STRING.toString(), "managernum", 6,0, false, "当前页高管记录数" )))
					.addNode(new FieldNode("totalchangenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalchangenum", 6,0, false, "历史变更总记录数" )))
					.addNode(new FieldNode("changenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "changenum", 6,0, false, "当前页历史变更记录数" )))
					.addNode(new FieldNode("totalabnmlnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalabnmlnum", 6,0, false, "异常经营总记录数" )))
					.addNode(new FieldNode("abnmlnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmlnum", 6,0, false, "当前页异常经营记录笔数" )))
					.addNode(new FieldNode("totalillegalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totalillegalnum", 6,0, false, "严重违法失信总记录数" )))
					.addNode(new FieldNode("illegalnum", new MsgField(ContentEnum.MessageType.STRING.toString(), "illegalnum", 6,0, false, "当前页严重违法失信记录数" )))
					.addNode(new FieldNode("totallicensenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "totallicensenum", 6,0, false, "营业执照作废总记录数" )))
					.addNode(new FieldNode("licensenum", new MsgField(ContentEnum.MessageType.STRING.toString(), "licensenum", 6,0, false, "当前页营业执照作废记录数" )))
					.addNode(new ArrayNode("investor_list",false)
							.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 6,0, true, "数据序号" )))
							.addNode(new FieldNode("naturalperflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "naturalperflag", 4,0, false, "自然人标识" )))
							.addNode(new FieldNode("invtrnm", new MsgField(ContentEnum.MessageType.STRING.toString(), "invtrnm", 200,0, false, "投资人名称" )))
							.addNode(new FieldNode("invtrid", new MsgField(ContentEnum.MessageType.STRING.toString(), "invtrid", 50,0, false, "投资人证件号码或证件编号" )))
							.addNode(new FieldNode("subscrcptlconamt", new MsgField(ContentEnum.MessageType.INT.toString(), "subscrcptlconamt", 17,2, false, "认缴出资额" )))
							.addNode(new FieldNode("actlcptlconamt", new MsgField(ContentEnum.MessageType.INT.toString(), "actlcptlconamt", 17,2, false, "实缴出资额" )))
							.addNode(new FieldNode("subscrcptlconfm", new MsgField(ContentEnum.MessageType.STRING.toString(), "subscrcptlconfm", 200,0, false, "认缴出资方式" )))
							.addNode(new FieldNode("subscrcptlcondt", new MsgField(ContentEnum.MessageType.STRING.toString(), "subscrcptlcondt", 8,0, false, "认缴出资日期" )))
							).addNode(new ArrayNode("manager_list",false)
									.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 6,0, true, "数据序号" )))
									.addNode(new FieldNode("managernm", new MsgField(ContentEnum.MessageType.STRING.toString(), "managernm", 200,0, false, "姓名" )))
									.addNode(new FieldNode("position", new MsgField(ContentEnum.MessageType.STRING.toString(), "position", 128,0, false, "职务" )))
									).addNode(new ArrayNode("change_list",false)
											.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 6,0, true, "数据序号" )))
											.addNode(new FieldNode("chngitm", new MsgField(ContentEnum.MessageType.STRING.toString(), "chngitm", 128,0, false, "变更事项" )))
											.addNode(new FieldNode("bfchng", new MsgField(ContentEnum.MessageType.STRING.toString(), "bfchng", 4000,0, false, "变更前内容" )))
											.addNode(new FieldNode("aftchng", new MsgField(ContentEnum.MessageType.STRING.toString(), "aftchng", 4000,0, false, "变更后内容" )))
											.addNode(new FieldNode("dtofchng", new MsgField(ContentEnum.MessageType.STRING.toString(), "dtofchng", 8,0, false, "变更日期" )))
											).addNode(new ArrayNode("abnml_list",false)
													.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 6,0, true, "数据序号" )))
													.addNode(new FieldNode("abnmlcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmlcause", 200,0, false, "列入经营异常名录原因类型" )))
													.addNode(new FieldNode("abnmldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmldate", 8,0, false, "列入日期" )))
													.addNode(new FieldNode("abnmlcausedcsnauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmlcausedcsnauth", 128,0, false, "列入决定机关" )))
													.addNode(new FieldNode("rmvcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmvcause", 200,0, false, "移出经营异常名录原因" )))
													.addNode(new FieldNode("rmvdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmvdate", 8,0, false, "移出日期" )))
													.addNode(new FieldNode("rmvcausedcsnauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmvcausedcsnauth", 128,0, false, "移出决定机关" )))
													).addNode(new ArrayNode("illegal_list",false)
															.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 6,0, true, "数据序号" )))
															.addNode(new FieldNode("abnmlcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmlcause", 200,0, false, "列入事由或情形" )))
															.addNode(new FieldNode("abnmldate", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmldate", 8,0, false, "列入日期" )))
															.addNode(new FieldNode("abnmlcausedcsnauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "abnmlcausedcsnauth", 128,0, false, "列入决定机关" )))
															.addNode(new FieldNode("rmvcause", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmvcause", 200,0, false, "移出事由" )))
															.addNode(new FieldNode("rmvdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmvdate", 8,0, false, "移出日期" )))
															.addNode(new FieldNode("rmvcausedcsnauth", new MsgField(ContentEnum.MessageType.STRING.toString(), "rmvcausedcsnauth", 128,0, false, "移出决定机关" )))
															).addNode(new ArrayNode("license_list",false)
																	.addNode(new FieldNode("seqno", new MsgField(ContentEnum.MessageType.STRING.toString(), "seqno", 6,0, true, "数据序号" )))
																	.addNode(new FieldNode("orgnlorcp", new MsgField(ContentEnum.MessageType.STRING.toString(), "orgnlorcp", 4,0, false, "正副本标识" )))
																	.addNode(new FieldNode("licnullstmcntt", new MsgField(ContentEnum.MessageType.STRING.toString(), "licnullstmcntt", 2000,0, false, "声明内容" )))
																	.addNode(new FieldNode("licnullstmdt", new MsgField(ContentEnum.MessageType.STRING.toString(), "licnullstmdt", 8,0, false, "声明日期" )))
																	.addNode(new FieldNode("rplsts", new MsgField(ContentEnum.MessageType.STRING.toString(), "rplsts", 4,0, false, "补领标识" )))
																	.addNode(new FieldNode("rpldt", new MsgField(ContentEnum.MessageType.STRING.toString(), "rpldt", 8,0, false, "补领日期" )))
																	.addNode(new FieldNode("liccpnb", new MsgField(ContentEnum.MessageType.STRING.toString(), "liccpnb", 50,0, false, "营业执照副本编号" )))
																	));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

