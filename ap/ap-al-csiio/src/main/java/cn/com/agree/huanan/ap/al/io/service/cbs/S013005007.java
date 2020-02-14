package cn.com.agree.huanan.ap.al.io.service.cbs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.io.system.esb.EsbCoreChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;

/**
 * S0130050.07 现金尾箱碰库  交易码：tl5226
 * @author lixq 
 */
@Component
public class S013005007 extends EsbCoreChannelService {

	private static S013005007_I i = new S013005007_I();
	private static S013005007_O o = new S013005007_O();
	public S013005007() {
        requestFormat.add(i);
        responseFormat.add(o);
	}

	
	public static class S013005007_I extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			
			StructNode BODY = new StructNode("APPBody");
			FieldNode tlr_code_num = new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, true, "柜员代号" ));
			FieldNode tlr_boot_chk_flg = new FieldNode("tlr_boot_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_boot_chk_flg", 1,0, true, "柜员碰库标志"));					
			FieldNode ccy_code_num = new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号" ));
			FieldNode wthr_cfm_acct_oprn = new FieldNode("wthr_cfm_acct_oprn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_cfm_acct_oprn", 1,0, true, "是否平账操作"));					
			FieldNode strt_cnt_num = new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_cnt_num", 10,0, true, "起始笔数" ));
			FieldNode txn_cnt_num = new FieldNode("txn_cnt_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_cnt_num", 10,0, true, "交易笔数" ));

			BODY.addNode(tlr_code_num);
			BODY.addNode(tlr_boot_chk_flg);
			BODY.addNode(ccy_code_num);
			BODY.addNode(wthr_cfm_acct_oprn);
			BODY.addNode(strt_cnt_num);
			BODY.addNode(txn_cnt_num);
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
	
	public static class S013005007_O extends MsgBody {
		private MsgSegment  msgSegment = init();
		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			StructNode  BODY= new StructNode("APPBody");
			
			BODY.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别")));
			BODY.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号")));
			BODY.addNode(new FieldNode("tlr_boot_chk_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_boot_chk_flg", 1,0, false, "柜员碰库标志")));
			BODY.addNode(new FieldNode("hint_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "hint_info", 300,0, false, "提示信息")));
			BODY.addNode(new FieldNode("wthr_cfm_acct_oprn", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_cfm_acct_oprn", 1,0, false, "是否平账操作")));
			BODY.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.STRING.toString(), "mber_qty", 10,0, false, "成员数量")));

			
			ArrayNode arrayNode = new ArrayNode("listnm");
			arrayNode.addNode(new FieldNode("ccy_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "ccy_code_num", 3,0, false, "货币代号")));
			arrayNode.addNode(new FieldNode("cash_acct_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "cash_acct_class", 4,0, false, "现金账户类别")));
			arrayNode.addNode(new FieldNode("invty_bal", new MsgField(ContentEnum.MessageType.STRING.toString(), "invty_bal", 20,0, false, "库存余额")));
			arrayNode.addNode(new FieldNode("acct_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "acct_num", 40,0, false, "系统账号")));		
			BODY.addNode(arrayNode);
			
			messageNode.addStructNode(BODY);
			return messageNode;
		}  

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
		
	}
}
