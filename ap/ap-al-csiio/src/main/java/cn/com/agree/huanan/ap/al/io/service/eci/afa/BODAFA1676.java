package cn.com.agree.huanan.ap.al.io.service.eci.afa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * BASESVC BODAFA1676  社保卡挂失补卡申请 
 *  BODAFA1676 881003
 *  综合前置
 * @author XZF
 */
@Component
public class BODAFA1676 extends EciChannelService {

	private static BODAFA1676_I i = new BODAFA1676_I();
	private static BODAFA1676_O o = new BODAFA1676_O();
	public BODAFA1676() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class BODAFA1676_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("APPBody",true,"Body")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("sbkh", new MsgField(ContentEnum.MessageType.STRING.toString(), "sbkh", 1024,0, false, "社保卡号" )))
					.addNode(new FieldNode("zjhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "zjhm", 1024,0, false, "证件号码" )))
					.addNode(new FieldNode("yhbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhbh", 1024,0, false, "发卡银行编号" )))
					.addNode(new FieldNode("yhwdbh", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdbh", 1024,0, false, "银行网点编号" )))
					.addNode(new FieldNode("yhwdmc", new MsgField(ContentEnum.MessageType.STRING.toString(), "yhwdmc", 1024,0, false, "银行网点名称" )))
					.addNode(new FieldNode("xm", new MsgField(ContentEnum.MessageType.STRING.toString(), "xm", 1024,0, false, "姓名" )))
					.addNode(new FieldNode("zxhzh", new MsgField(ContentEnum.MessageType.STRING.toString(), "zxhzh", 1024,0, false, "照相回执号" )))
					.addNode(new FieldNode("zzdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "zzdh", 1024,0, false, "住宅电话" )))
					.addNode(new FieldNode("bgdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "bgdh", 1024,0, false, "办公电话" )))
					.addNode(new FieldNode("sjdh", new MsgField(ContentEnum.MessageType.STRING.toString(), "sjdh", 1024,0, false, "手机电话" )))
					.addNode(new FieldNode("acctno", new MsgField(ContentEnum.MessageType.STRING.toString(), "acctno", 1024,0, false, "金融账号" )))
					.addNode(new FieldNode("optflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "optflag", 1024,0, false, "补换标志" )))
					.addNode(new FieldNode("idcdflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "idcdflag", 1024,0, false, "是否修改证件号码" )))
					.addNode(new FieldNode("gatflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "gatflag", 1024,0, false, "是否居民" )))
					.addNode(new FieldNode("shbzhm", new MsgField(ContentEnum.MessageType.STRING.toString(), "shbzhm", 1024,0, false, "社会保障号" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}

	}

	public static class BODAFA1676_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode
			.addStructNode(new StructNode("Body",true,"APPBody")
					.addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024,0, false, "渠道备注信息" )))
					.addNode(new FieldNode("SBKH", new MsgField(ContentEnum.MessageType.STRING.toString(), "SBKH", 30,0, false, "社保卡号" )))
					.addNode(new FieldNode("ZJHM", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZJHM", 50,0, false, "证件号码" )))
					.addNode(new FieldNode("YHBH", new MsgField(ContentEnum.MessageType.STRING.toString(), "YHBH", 20,0, false, "发卡银行编号" )))
					.addNode(new FieldNode("YHWDBH", new MsgField(ContentEnum.MessageType.STRING.toString(), "YHWDBH", 20,0, false, "银行网点编号" )))
					.addNode(new FieldNode("YHWDMC", new MsgField(ContentEnum.MessageType.STRING.toString(), "YHWDMC", 100,0, false, "银行网点名称" )))
					.addNode(new FieldNode("JKTZSH", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKTZSH", 50,0, false, "缴款通知书号码" )))
					.addNode(new FieldNode("ZSDWMC", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZSDWMC", 100,0, false, "执收单位名称" )))
					.addNode(new FieldNode("ZSDWBM", new MsgField(ContentEnum.MessageType.STRING.toString(), "ZSDWBM", 50,0, false, "执收单位编码" )))
					.addNode(new FieldNode("PJDWGR", new MsgField(ContentEnum.MessageType.STRING.toString(), "PJDWGR", 120,0, false, "缴款单位个人名称" )))
					.addNode(new FieldNode("JKXMBM", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKXMBM", 50,0, false, "缴款项目编号" )))
					.addNode(new FieldNode("JKXMMC", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKXMMC", 120,0, false, "缴款项目名称" )))
					.addNode(new FieldNode("JFBZ", new MsgField(ContentEnum.MessageType.STRING.toString(), "JFBZ", 20,0, false, "缴款标准" )))
					.addNode(new FieldNode("JKSL", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKSL", 10,0, false, "缴款数量" )))
					.addNode(new FieldNode("JKJE", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKJE", 18,0, false, "缴款金额" )))
					.addNode(new FieldNode("HMJYM", new MsgField(ContentEnum.MessageType.STRING.toString(), "HMJYM", 50,0, false, "号码校验码" )))
					.addNode(new FieldNode("QSJYM", new MsgField(ContentEnum.MessageType.STRING.toString(), "QSJYM", 50,0, false, "全书校验码" )))
					.addNode(new FieldNode("JKYH1", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH1", 20,0, false, "缴款银行1" )))
					.addNode(new FieldNode("JKZHMC1", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC1", 100,0, false, "缴款账户名称1" )))
					.addNode(new FieldNode("JKZH1", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH1", 40,0, false, "缴款账号1" )))
					.addNode(new FieldNode("JKYH2", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH2", 20,0, false, "缴款银行2" )))
					.addNode(new FieldNode("JKZHMC2", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC2", 100,0, false, "缴款账户名称2" )))
					.addNode(new FieldNode("JKZH2", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH2", 40,0, false, "缴款账号2" )))
					.addNode(new FieldNode("JKYH3", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH3", 20,0, false, "缴款银行3" )))
					.addNode(new FieldNode("JKZHMC3", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC3", 100,0, false, "缴款账户名称3" )))
					.addNode(new FieldNode("JKZH3", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH3", 40,0, false, "缴款账号3" )))
					.addNode(new FieldNode("JKYH4", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH4", 20,0, false, "缴款银行4" )))
					.addNode(new FieldNode("JKZHMC4", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC4", 100,0, false, "缴款账户名称4" )))
					.addNode(new FieldNode("JKZH4", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH4", 40,0, false, "缴款账号4" )))
					.addNode(new FieldNode("JKYH5", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH5", 20,0, false, "缴款银行5" )))
					.addNode(new FieldNode("JKZHMC5", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC5", 100,0, false, "缴款账户名称5" )))
					.addNode(new FieldNode("JKZH5", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH5", 40,0, false, "缴款账号5" )))
					.addNode(new FieldNode("JKYH6", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH6", 20,0, false, "缴款银行6" )))
					.addNode(new FieldNode("JKZHMC6", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC6", 100,0, false, "缴款账户名称6" )))
					.addNode(new FieldNode("JKZH6", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH6", 40,0, false, "缴款账号6" )))
					.addNode(new FieldNode("JKYH7", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH7", 20,0, false, "缴款银行7" )))
					.addNode(new FieldNode("JKZHMC7", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC7", 100,0, false, "缴款账户名称7" )))
					.addNode(new FieldNode("JKZH7", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH7", 40,0, false, "缴款账号7" )))
					.addNode(new FieldNode("JKYH8", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH8", 20,0, false, "缴款银行8" )))
					.addNode(new FieldNode("JKZHMC8", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC8", 100,0, false, "缴款账户名称8" )))
					.addNode(new FieldNode("JKZH8", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH8", 40,0, false, "缴款账号8" )))
					.addNode(new FieldNode("JKYH9", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH9", 20,0, false, "缴款银行9" )))
					.addNode(new FieldNode("JKZHMC9", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC9", 100,0, false, "缴款账户名称9" )))
					.addNode(new FieldNode("JKZH9", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH9", 40,0, false, "缴款账号9" )))
					.addNode(new FieldNode("JKYH10", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKYH10", 20,0, false, "缴款银行10" )))
					.addNode(new FieldNode("JKZHMC10", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZHMC10", 100,0, false, "缴款账户名称10" )))
					.addNode(new FieldNode("JKZH10", new MsgField(ContentEnum.MessageType.STRING.toString(), "JKZH10", 40,0, false, "缴款账号10" )))
					);
			return messageNode;
		}
		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}
}

