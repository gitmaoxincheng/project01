package cn.com.agree.huanan.ap.al.io.service.eci.npp;

import java.util.ArrayList;

import org.springframework.stereotype.Component;


import cn.com.agree.huanan.ap.al.io.system.eci.EciChannelService;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.tl.communicate.content.format.ArrayNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;


/**
 * BASESVC BODNPP0002  BODNPP0002 
 *  BODNPP0002 ecip.seal.0001.02
 *  综合前置
 * @author YFK
 */	
@Component
public class BODNPP0002 extends EciChannelService {

		private static BODNPP0002_I i = new BODNPP0002_I();
		private static BODNPP0002_O o = new BODNPP0002_O();
		public BODNPP0002() {
			requestFormat.add(i);
			responseFormat.add(o);
		}
	
		
		public static class BODNPP0002_I extends MsgBody {
			private MsgSegment  msgSegment = init();
			private MsgSegment init(){
				MsgSegment messageNode = new MsgSegment();
				messageNode.addStructNode(new StructNode("APPBody",true,"Body")
						.addNode(new ArrayNode("SYS_HEAD",true)
								.addNode(new FieldNode("TransServiceCode",new MsgField(ContentEnum.MessageType.STRING.toString(),"TransServiceCode" ,30,0, false, "服务码" )))
								.addNode(new FieldNode("RequestDate",new MsgField(ContentEnum.MessageType.STRING.toString(),"RequestDate" ,8,0, false, "服务请求日期" )))
								.addNode(new FieldNode("RequestTime",new MsgField(ContentEnum.MessageType.STRING.toString(),"RequestTime" ,6,0, false, "服务请求时间" )))
								.addNode(new FieldNode("ConsumerIP",new MsgField(ContentEnum.MessageType.STRING.toString(),"ConsumerIP" ,20,0, false, "发起方IP" )))
								.addNode(new FieldNode("ConsumerId",new MsgField(ContentEnum.MessageType.STRING.toString(),"ConsumerId" ,3,0, false, "发起方系统编号" )))
								.addNode(new FieldNode("ServerIP",new MsgField(ContentEnum.MessageType.STRING.toString(),"ServerIP" ,20,0, false, "目标服务器IP" )))
								.addNode(new FieldNode("TranMode",new MsgField(ContentEnum.MessageType.STRING.toString(),"TranMode" ,6,0, false, "交易模式" )))
								.addNode(new FieldNode("MacValue",new MsgField(ContentEnum.MessageType.STRING.toString(),"MacValue" ,16,0, false, "Mac值" )))
								.addNode(new FieldNode("Reserve",new MsgField(ContentEnum.MessageType.STRING.toString(),"Reserve" ,256,0, false, "保留域" )))
								.addNode(new FieldNode("TdgBrah",new MsgField(ContentEnum.MessageType.STRING.toString(),"TdgBrah" ,30,0, false, "交易机构代码" )))
								.addNode(new FieldNode("TranTellerNo",new MsgField(ContentEnum.MessageType.STRING.toString(),"TranTellerNo" ,10,0, false, "交易柜员号" )))
								)
						.addNode(new ArrayNode("REQ_BODY",true)		
								.addNode(new FieldNode("VOUTYPE",new MsgField(ContentEnum.MessageType.STRING.toString(),"VOUTYPE" ,20,0, false, "凭证种类" )))
								.addNode(new FieldNode("SCENECODE",new MsgField(ContentEnum.MessageType.STRING.toString(),"SCENECODE" ,20,0, false, "场景码" )))
								.addNode(new FieldNode("RETURNTYPE",new MsgField(ContentEnum.MessageType.STRING.toString(),"RETURNTYPE" ,2,0, false, "印章返回类型" )))
								.addNode(new FieldNode("SERIALNO",new MsgField(ContentEnum.MessageType.STRING.toString(),"SERIALNO" ,40,0, false, "第三方业务流水号" )))
								.addNode(new FieldNode("BRNONAME",new MsgField(ContentEnum.MessageType.STRING.toString(),"BRNONAME" ,20,0, false, "机构名称" )))
								.addNode(new FieldNode("TRADECODE",new MsgField(ContentEnum.MessageType.STRING.toString(),"TRADECODE" ,20,0, false, "交易代码" )))
								.addNode(new FieldNode("TRADENAME",new MsgField(ContentEnum.MessageType.STRING.toString(),"TRADENAME" ,20,0, false, "交易场景名称" )))
								.addNode(new FieldNode("ACCOUNT",new MsgField(ContentEnum.MessageType.STRING.toString(),"ACCOUNT" ,20,0, false, "账号" )))
								.addNode(new FieldNode("ACCNAME",new MsgField(ContentEnum.MessageType.STRING.toString(),"ACCNAME" ,20,0, false, "户名" )))
								.addNode(new FieldNode("AMOUNT",new MsgField(ContentEnum.MessageType.STRING.toString(),"AMOUNT" ,40,0, false, "金额" )))
								.addNode(new FieldNode("VOUNO",new MsgField(ContentEnum.MessageType.STRING.toString(),"VOUNO" ,30,0, false, "凭证号码" )))
								.addNode(new FieldNode("REMARK1",new MsgField(ContentEnum.MessageType.STRING.toString(),"REMARK1" ,32,0, false, "备用1" )))
								.addNode(new FieldNode("REMARK2",new MsgField(ContentEnum.MessageType.STRING.toString(),"REMARK2" ,64,0, false, "备用2" )))
								.addNode(new FieldNode("REMARK3",new MsgField(ContentEnum.MessageType.STRING.toString(),"REMARK3" ,128,0, false, "备用3" )))
								.addNode(new FieldNode("LISTNUM",new MsgField(ContentEnum.MessageType.STRING.toString(),"LISTNUM" ,3,0, false, "循环条数" )))
								.addNode(new ArrayNode("struct",true)	
										.addNode(new FieldNode("ABSERIALNO",new MsgField(ContentEnum.MessageType.STRING.toString(),"ABSERIALNO" ,40,0, false, "前端流水" )))
										.addNode(new FieldNode("ABTRADENAME",new MsgField(ContentEnum.MessageType.STRING.toString(),"ABTRADENAME" ,100,0, false, "前端子交易名称" )))
										.addNode(new FieldNode("ABACCOUNT",new MsgField(ContentEnum.MessageType.STRING.toString(),"ABACCOUNT" ,40,0, false, "前端子交易账号" )))
										.addNode(new FieldNode("ABACCNAME",new MsgField(ContentEnum.MessageType.STRING.toString(),"ABACCNAME" ,300,0, false, "前端子交易户名" )))
										.addNode(new FieldNode("ABCURRTYPE",new MsgField(ContentEnum.MessageType.STRING.toString(),"ABCURRTYPE" ,150,0, false, "前端子交易币种" )))
										.addNode(new FieldNode("ABAMOUNT",new MsgField(ContentEnum.MessageType.STRING.toString(),"ABAMOUNT" ,40,0, false, "前端子交易金额" )))
										.addNode(new FieldNode("REMARK",new MsgField(ContentEnum.MessageType.STRING.toString(),"REMARK" ,512,0, false, "备用" )))
								))
						);
						return messageNode;
			}
			
		@Override
		public ArrayList<Node> listNode() {
				return msgSegment.getNodeList();
			}		
		}
		
		
		public static class BODNPP0002_O extends MsgBody {
			private MsgSegment  msgSegment = init();
			private MsgSegment init(){
				MsgSegment messageNode = new MsgSegment();
				messageNode.addStructNode(new StructNode("Body",true,"APPBody")
						.addNode(new FieldNode("SEALTYPE1",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALTYPE1" ,2,0, false, "印章类型1" )))
						.addNode(new FieldNode("SEALTYPE2",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALTYPE2" ,2,0, false, "印章类型2" )))
						.addNode(new FieldNode("SEALTYPE3",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALTYPE3" ,2,0, false, "印章类型3" )))
						.addNode(new FieldNode("SEALTYPE4",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALTYPE4" ,2,0, false, "印章类型4" )))
						.addNode(new FieldNode("SEALTYPE5",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALTYPE5" ,2,0, false, "印章类型5" )))
						.addNode(new FieldNode("SEALPRINT1",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALPRINT1" ,20,0, false, "印章打印位置1" )))
						.addNode(new FieldNode("SEALPRINT2",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALPRINT2" ,20,0, false, "印章打印位置2" )))
						.addNode(new FieldNode("SEALPRINT3",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALPRINT3" ,20,0, false, "印章打印位置3" )))
						.addNode(new FieldNode("SEALPRINT4",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALPRINT4" ,20,0, false, "印章打印位置4" )))
						.addNode(new FieldNode("SEALPRINT5",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALPRINT5" ,20,0, false, "印章打印位置5" )))
						.addNode(new FieldNode("SEALMODELID1",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELID1" ,10,0, false, "印模ID1" )))
						.addNode(new FieldNode("SEALMODELID2",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELID2" ,10,0, false, "印模ID2" )))
						.addNode(new FieldNode("SEALMODELID3",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELID3" ,10,0, false, "印模ID3" )))
						.addNode(new FieldNode("SEALMODELID4",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELID4" ,10,0, false, "印模ID4" )))
						.addNode(new FieldNode("SEALMODELID5",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELID5" ,10,0, false, "印模ID5" )))
						.addNode(new FieldNode("VERIFICATIONCODE1",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERIFICATIONCODE1" ,12,0, false, "印章标识码1" )))
						.addNode(new FieldNode("VERIFICATIONCODE2",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERIFICATIONCODE2" ,12,0, false, "印章标识码2" )))
						.addNode(new FieldNode("VERIFICATIONCODE3",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERIFICATIONCODE3" ,12,0, false, "印章标识码3" )))
						.addNode(new FieldNode("VERIFICATIONCODE4",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERIFICATIONCODE4" ,12,0, false, "印章标识码4" )))
						.addNode(new FieldNode("VERIFICATIONCODE5",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERIFICATIONCODE5" ,12,0, false, "印章标识码5" )))
						.addNode(new FieldNode("SEALDATA1",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALDATA1" ,15000,0, false, "印章图片数据1" )))
						.addNode(new FieldNode("SEALDATA2",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALDATA2" ,15000,0, false, "印章图片数据2" )))
						.addNode(new FieldNode("SEALDATA3",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALDATA3" ,15000,0, false, "印章图片数据3" )))
						.addNode(new FieldNode("SEALDATA4",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALDATA4" ,15000,0, false, "印章图片数据4" )))
						.addNode(new FieldNode("SEALDATA5",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALDATA5" ,15000,0, false, "印章图片数据5" )))
						.addNode(new FieldNode("SEALMODELDESC1",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELDESC1" ,4000,0, false, "印模文字描述1" )))
						.addNode(new FieldNode("SEALMODELDESC2",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELDESC2" ,4000,0, false, "印模文字描述2" )))
						.addNode(new FieldNode("SEALMODELDESC3",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELDESC3" ,4000,0, false, "印模文字描述3" )))
						.addNode(new FieldNode("SEALMODELDESC4",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELDESC4" ,4000,0, false, "印模文字描述4" )))
						.addNode(new FieldNode("SEALMODELDESC5",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALMODELDESC5" ,4000,0, false, "印模文字描述5" )))
						.addNode(new FieldNode("VERCODELAYOUT1",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERCODELAYOUT1" ,15,0, false, "回单标识码打印位置1" )))
						.addNode(new FieldNode("VERCODELAYOUT2",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERCODELAYOUT2" ,15,0, false, "回单标识码打印位置2" )))
						.addNode(new FieldNode("VERCODELAYOUT3",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERCODELAYOUT3" ,15,0, false, "回单标识码打印位置3" )))
						.addNode(new FieldNode("VERCODELAYOUT4",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERCODELAYOUT4" ,15,0, false, "回单标识码打印位置4" )))
						.addNode(new FieldNode("VERCODELAYOUT5",new MsgField(ContentEnum.MessageType.STRING.toString(),"VERCODELAYOUT5" ,15,0, false, "回单标识码打印位置5" )))
						.addNode(new FieldNode("SEALFILEPATH",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALFILEPATH" ,100,0, false, "印章文件路径" )))
						.addNode(new FieldNode("SEALFILE1",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALFILE1" ,100,0, false, "印章文件1" )))
						.addNode(new FieldNode("SEALFILE2",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALFILE2" ,100,0, false, "印章文件2" )))
						.addNode(new FieldNode("SEALFILE3",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALFILE3" ,100,0, false, "印章文件3" )))
						.addNode(new FieldNode("SEALFILE4",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALFILE4" ,100,0, false, "印章文件4" )))
						.addNode(new FieldNode("SEALFILE5",new MsgField(ContentEnum.MessageType.STRING.toString(),"SEALFILE5" ,100,0, false, "印章文件5" )))
						);
				return messageNode;
			}
			@Override
			public ArrayList<Node> listNode() {
				return msgSegment.getNodeList();
			}
		}
	
}	

