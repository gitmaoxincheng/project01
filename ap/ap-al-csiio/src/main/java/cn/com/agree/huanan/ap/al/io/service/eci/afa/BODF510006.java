package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciFINChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODF510006  当日撤单 
 *  BODF510006 regflw
 *  综合前置
 * @author XZF
 */
@Component
public class BODF510006 extends EciFINChannelService {

	private static BODF510006_I i = new BODF510006_I();
	private static BODF510006_O o = new BODF510006_O();
	public BODF510006() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODF510006_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("gsdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsdm", 4,0, false, "公司代码" )))
					.addNode(new FieldNode("cpdm", new MsgField(ContentEnum.MessageType.STRING.toString(), "cpdm", 10,0, false, "险种代码" )))
					.addNode(new FieldNode("yjyje", new MsgField(ContentEnum.MessageType.STRING.toString(), "yjyje", 15,0, false, "原交易金额（保费）" )))
					.addNode(new FieldNode("yjylsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yjylsh", 20,0, false, "原交易流水号" )))
					.addNode(new FieldNode("ybxlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ybxlsh", 20,0, false, "原保险公司流水号" )))
					.addNode(new FieldNode("bdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdh", 30,0, false, "保单号" )))
					.addNode(new FieldNode("bdmm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bdmm", 16,0, false, "保单密码" )))
					.addNode(new FieldNode("jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyzh", 20,0, false, "交易账号" )))
					.addNode(new FieldNode("jymm", new MsgField(ContentEnum.MessageType.STRING.toString(), "jymm", 16,0, false, "交易密码" )))
					.addNode(new FieldNode("khlx", new MsgField(ContentEnum.MessageType.STRING.toString(), "khlx", 1,0, false, "客户类型" )))
					.addNode(new FieldNode("bankcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "bankcode", 10,0, false, "银行代码" )))
					.addNode(new FieldNode("ptlsh", new MsgField(ContentEnum.MessageType.STRING.toString(), "ptlsh", 30,0, false, "交易流水号" )))
					.addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 8,0, false, "地区邮编" )))
					.addNode(new FieldNode("tbdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "tbdh", 15,0, false, "投保单号" )))
					.addNode(new FieldNode("bxgsjydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxgsjydm", 8,0, false, "保险公司交易代码" )))
					.addNode(new StructNode("jyxx",true,"jyxx_list")
							.addNode(new FieldNode("jyxx_khlb", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyxx_khlb", 3,0, false, "客户类别" )))
							.addNode(new FieldNode("jyxx_jyzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "jyxx_jyzh", 32,0, false, "交易帐号" )))
							));
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODF510006_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("yjyje", new MsgField(ContentEnum.MessageType.STRING.toString(), "yjyje", 15,0, false, "原交易金额（保费）" )))
					.addNode(new FieldNode("gsmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "gsmc", 60,0, false, "保险公司名称" )))
					.addNode(new FieldNode("pzdywjm", new MsgField(ContentEnum.MessageType.STRING.toString(), "pzdywjm", 250,0, false, "凭证打印文件名" )))
					.addNode(new FieldNode("bxgsresp", new MsgField(ContentEnum.MessageType.STRING.toString(), "bxgsresp", 2500,0, false, "保险公司返回的报文" )))
					.addNode(new FieldNode("resp_insure_serial", new MsgField(ContentEnum.MessageType.STRING.toString(), "resp_insure_serial", 30,0, false, "交易流水号" )))
					.addNode(new FieldNode("resp_resultcode", new MsgField(ContentEnum.MessageType.STRING.toString(), "resp_resultcode", 8,0, false, "结果码" )))
					.addNode(new FieldNode("resp_err_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "resp_err_info", 2500,0, false, "结果描述" )))
					.addNode(new FieldNode("resp_yhdjydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "resp_yhdjydm", 8,0, false, "银行交易代码" )))
					.addNode(new FieldNode("resp_jydm", new MsgField(ContentEnum.MessageType.STRING.toString(), "resp_jydm", 8,0, false, "保险公司交易代码" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

