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
 * BASESVC.S011000310 凭证库存管理.凭证出库撤销 
 * S0110003.10 ce5166
 * 0005 新核心业务系统
 * @author ZS
 */
@Component
public class S011000310 extends EsbCoreChannelService {

	private static S011000310_I i = new S011000310_I();
	private static S011000310_O o = new S011000310_O();

	public S011000310() {
		requestFormat.add(i);
		responseFormat.add(o);
	}

	public static class S011000310_I extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			messageNode.addStructNode(new StructNode("APPBody",true)
					.addNode(new FieldNode("txn_dt_8", new MsgField(ContentEnum.MessageType.STRING.toString(), "txn_dt_8", 8,0, true, "交易日期" )))
					.addNode(new FieldNode("tlr_rung_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "tlr_rung_num", 32,0, true, "柜员流水号" )))
					.addNode(new FieldNode("inwd_otwd_br_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "inwd_otwd_br_flg", 1,0, true, "出入网点标记" )))
					.addNode(new FieldNode("cntpr_org_code_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "cntpr_org_code_num", 12,0, true, "对方机构代号" )))
					.addNode(new FieldNode("vchr_aply_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_aply_num", 30,0, false, "凭证申请编号" )))
					.addNode(new ArrayNode("listnm_list",false)
							.addNode(new FieldNode("wthr_flg", new MsgField(ContentEnum.MessageType.STRING.toString(), "wthr_flg", 1,0, false, "是否标志" )))
							.addNode(new FieldNode("vchr_catg", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_catg", 4,0, true, "凭证种类" )))
							.addNode(new FieldNode("par_val", new MsgField(ContentEnum.MessageType.INT.toString(), "par_val", 18,2, true, "面值" )))
							.addNode(new FieldNode("br_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "br_code", 4,0, false, "分行代码" )))
							.addNode(new FieldNode("vchr_btch_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_btch_num", 10,0, true, "凭证批号" )))
							.addNode(new FieldNode("vchr_unit", new MsgField(ContentEnum.MessageType.STRING.toString(), "vchr_unit", 1,0, true, "凭证单位" )))
							.addNode(new FieldNode("qty", new MsgField(ContentEnum.MessageType.INT.toString(), "qty", 10,0, true, "数量" )))
							.addNode(new FieldNode("strt_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "strt_vchr_serl_num", 32,0, false, "起始凭证序号" )))
							.addNode(new FieldNode("end_vchr_serl_num", new MsgField(ContentEnum.MessageType.STRING.toString(), "end_vchr_serl_num", 32,0, true, "终止凭证序号" )))
							.addNode(new FieldNode("vchr_vol", new MsgField(ContentEnum.MessageType.INT.toString(), "vchr_vol", 10,0, true, "凭证张数" )))
							).addNode(new FieldNode("abst_code", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_code", 10,0, false, "摘要代码" )))
					.addNode(new FieldNode("abst_dsc", new MsgField(ContentEnum.MessageType.STRING.toString(), "abst_dsc", 225,0, false, "摘要描述" )))
					.addNode(new FieldNode("remks_info", new MsgField(ContentEnum.MessageType.STRING.toString(), "remks_info", 300,0, false, "备注信息" )))
					);		
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

	public static class S011000310_O extends MsgBody {
		private MsgSegment msgSegment = init();

		private MsgSegment init(){
			MsgSegment messageNode = new MsgSegment();
			return messageNode;
		}

		@Override
		public ArrayList<Node> listNode() {
			return msgSegment.getNodeList();
		}
	}

}
