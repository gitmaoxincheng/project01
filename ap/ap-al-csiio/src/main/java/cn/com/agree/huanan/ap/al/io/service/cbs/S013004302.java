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
 * BASESVC.S013004302 尾箱信息查询.机构尾箱状态查询 
 * S0130043.02 tl5242
 * 0005 新核心业务系统
 * @author CZP
 */
@Component
public class S013004302 extends EsbCoreChannelService {

	private static S013004302_I i = new S013004302_I();
	private static S013004302_O o = new S013004302_O();

	public S013004302() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S013004302_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("qry_prt_id", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_prt_id", 1,0, true, "查询打印标识" )))
					.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
					.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
					.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
					.addNode(new FieldNode("boot_prvg_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_prvg_ste", 1,0, false, "尾箱权限状态" )))
					.addNode(new FieldNode("boot_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_flg", 1,0, false, "尾箱标志" )))
					.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
					.addNode(new FieldNode("strt_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "strt_cnt_num", 10,0, true, "起始笔数" )))
					.addNode(new FieldNode("qry_cnt_num", new MsgField(ContentEnum.MessageType.INT.toString(), "qry_cnt_num", 10,0, true, "查询笔数" )))
					.addNode(new FieldNode("qry_scope", new MsgField(ContentEnum.MessageType.STRING.toString(), "qry_scope", 1,0, false, "查询范围" )))
					);
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S013004302_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("mber_qty", new MsgField(ContentEnum.MessageType.INT.toString(), "mber_qty", 10,0, false, "成员数量" )))
					.addNode(new ArrayNode("lstTl5242out_list",false)
							.addNode(new FieldNode("oprtg_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "oprtg_org", 12,0, false, "营业机构" )))
							.addNode(new FieldNode("tlr_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_code_num", 10,0, false, "柜员代号" )))
							.addNode(new FieldNode("boot_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_flg", 1,0, false, "尾箱标志" )))
							.addNode(new FieldNode("boot_class", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_class", 2,0, false, "尾箱类别" )))
							.addNode(new FieldNode("boot_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_num", 8,0, false, "尾箱号" )))
							.addNode(new FieldNode("boot_prvg_ste", new MsgField(ContentEnum.MessageType.STRING.toString(), "boot_prvg_ste", 1,0, false, "尾箱权限状态" )))
							.addNode(new FieldNode("cntpr_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_tlr", 10,0, false, "对方柜员" )))
							.addNode(new FieldNode("ctrl_list_tp", new MsgField(ContentEnum.MessageType.STRING.toString(), "ctrl_list_tp", 1,0, false, "控制列表类型" )))
							.addNode(new FieldNode("mntnc_org", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_org", 12,0, false, "维护机构" )))
							.addNode(new FieldNode("mntnc_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr", 10,0, false, "维护柜员" )))
							.addNode(new FieldNode("mntnc_dt", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_dt", 8,0, false, "维护日期" )))
							.addNode(new FieldNode("mntnc_tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "mntnc_tlr_rung_num", 32,0, false, "维护柜员流水号" )))
							.addNode(new FieldNode("athrzn_tlr", new MsgField(ContentEnum.MessageType.STRING.toString(), "athrzn_tlr", 10,0, false, "授权柜员" )))
							.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
							));
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
