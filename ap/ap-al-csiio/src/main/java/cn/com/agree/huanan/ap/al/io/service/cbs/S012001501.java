package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * S0120015.01 网点关机  交易码：br5322
 * @author HCP
 */
@Component
public class S012001501 extends EsbCoreChannelService{
	
	private static S012001501_I i = new S012001501_I();
	private static S012001501_O o = new S012001501_O();
	public S012001501() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S012001501_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode oprtg_org = new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构"));
			FieldNode wthr_enfrc_stdw = new FieldNode("wthr_enfrc_stdw", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_enfrc_stdw", 1,0, false, "是否强制关机" ));
			BODY.addNode(oprtg_org);
			BODY.addNode(wthr_enfrc_stdw);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S012001501_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			BODY.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 30,0, false, "提示信息")));
			BODY.addNode(new FieldNode("org_dly_stlmt_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "org_dly_stlmt_flg", 1,0, false, "机构日结标记")));
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
