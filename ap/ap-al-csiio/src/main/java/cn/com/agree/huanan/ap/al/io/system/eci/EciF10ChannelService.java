package cn.com.agree.huanan.ap.al.io.system.eci;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.util.StringUtils;

import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommParam;
import cn.com.agree.huanan.ap.rl.bank.base.constant.ContentEnum;
import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.service.IOService;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgBody;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgField;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgHeader;
import cn.com.agree.huanan.ap.tl.communicate.content.format.MsgSegment;
import cn.com.agree.huanan.ap.tl.communicate.content.format.Node;
import cn.com.agree.huanan.ap.tl.communicate.content.format.StructNode;
import lombok.Getter;

/**
 * @author XZF
 * ECI.AFA F10,F98,F16 综合理财平台对外发布服务
 * 不包括部分F51
 * json报文
 */
public class EciF10ChannelService extends IOService {

    private static Ctrl_I i = new Ctrl_I();
    private static PubBodyI i2 = new PubBodyI();
    private static Ctrl_O o = new Ctrl_O();
    private static Header_I headerI = new Header_I();
    private static Header_O headerO = new Header_O();

    public EciF10ChannelService() {
        requestFormat.add(i);
        requestFormat.add(headerI);
        requestFormat.add(i2);
        responseFormat.add(o);
        responseFormat.add(headerO);
        initServieConf();
    }

    @Override
    public String isTradeSuccess(Map<String, Object> tradeContext) {
        String errorCode = getErrorCode(tradeContext);
        if ("AAAAAAAAAA".equals(errorCode)) {
            return CommConstant.SUCCSTATUS;
        }
        if (StringUtils.isEmpty(errorCode) || errorCode.startsWith("COMM9")) {  //前置系统标识状态异常或未知的错误码开头为 "COMM9"
            return CommConstant.UNKNOWSTATUS;
        } else {
            return CommConstant.FAILSTATUS;
        }
    }


    @Override
    public String getErrorCode(Map<String, Object> tradeContext) {
        String errorCode = (((Map) tradeContext.get("Ctrl")).get("errorCode").toString());
        if ("00000000".equals(errorCode)) {
            errorCode = "AAAAAAAAAA";
        }
        return errorCode;
    }

    @Override
    public String getErrorMessage(Map<String, Object> tradeContext) {
        return (((Map) tradeContext.get("Ctrl")).get("errorMsg").toString());
    }

    @Override
    public void initServieConf() {
        setAppId("ECI");
        setCommItem("ECI");
        setMessageType("ECIXML");
        setRequestEncoding("UTF-8");
        setResponseEncoding("UTF-8");
    }


    public void initContent(Map<String, Object> tradeContext) {
//		.addNode(new FieldNode("eciSeverId", new MsgField(ContentEnum.MessageType.STRING.toString(), "eciSeverId", 10,0, true, "ECI服务接口ID" )))
//		.addNode(new FieldNode("xmlflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "xmlflag", 1,0, true, "报文标识" )))
//		.addNode(new FieldNode("templateCodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateCodeName", 6,0, true, "模板名称" )))
//		.addNode(new FieldNode("transCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "transCode", 6,0, true, "交易代码" )))
//		.addNode(new FieldNode("sysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysId", 6,0, true, "系统标识" )))
//		.addNode(new FieldNode("channelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelCode", 3,0, true, "渠道分类" )))
//		.addNode(new FieldNode("subchannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchannelCode", 3,0, true, "渠道标识" )))
//		.addNode(new FieldNode("tradeFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeFlag", 1,0, true, "是否需要勾兑" )))
//		.addNode(new FieldNode("checkFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkFlag", 1,0, true, "是否需要判重" )))
//		.addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 10,0, true, "渠道处理码" )))
//		.addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40,0, true, "渠道分类流水号" )))
//		
        /**
         * ECI系统的接口的特殊映射关系
         */

        Map<String, Object> appHeader = (Map) tradeContext.get("AppHeader");
        Map<String, Object> csisHeader = (Map) tradeContext.get("CsisHeader");
        appHeader.putAll(csisHeader);
        if (null != appHeader.get("tagsysheader")) {
            appHeader.putAll((Map<String, Object>) appHeader.get("tagsysheader"));
        }
        appHeader.put("eciSeverId", tradeContext.get("AtSysSvc"));
        appHeader.put("prcscd", tradeContext.get("AtSysScn"));
        appHeader.put("transCode", tradeContext.get("AtExtCode"));
        appHeader.put("channelserno", csisHeader.get(CommConstant.__REQNO__) == null ? SernoGenUtil.getSerno(CommParam.ATOM_SEQ) : csisHeader.get(CommConstant.__REQNO__));
        appHeader.put("subchannelCode", "CSI");
        appHeader.put("channelCode", "011");

        appHeader.put("GloSeqNo", csisHeader.get("GloSeqNo"));
        appHeader.put("SrcCalCod", csisHeader.get("SrcCalCod"));
        appHeader.put("SrcChannelDate", csisHeader.get("SrcDate"));
        appHeader.put("SrcChannelSerno", csisHeader.get("ReqNo"));
        appHeader.put("vm_tellerflag", StringUtils.isEmpty(appHeader.get("vm_tellerflag")) ? '1' : appHeader.get("vm_tellerflag")); //如果没有虚拟柜员标识，则默认为使用真实柜员
        appHeader.put("MyBank", csisHeader.get("MyBank"));


        if (!"0".equals(appHeader.get("vm_tellerflag"))) {
            appHeader.put("zoneno", StringUtils.isEmpty(csisHeader.get("ZoneNo")) ? appHeader.get("zoneno") : csisHeader.get("ZoneNo"));
            appHeader.put("mbrno", StringUtils.isEmpty(csisHeader.get("MbrNo")) ? StringUtils.isEmpty(appHeader.get("MbrNo")) ? appHeader.get("mbrno") : appHeader.get("MbrNo") : csisHeader.get("MbrNo"));
            appHeader.put("brno", StringUtils.isEmpty(csisHeader.get("BrNo")) ? appHeader.get("brno") : csisHeader.get("BrNo"));
            appHeader.put("tellerno", StringUtils.isEmpty(csisHeader.get("TellerNo")) ? appHeader.get("tellerno") : csisHeader.get("TellerNo"));
            appHeader.put("tellertp", StringUtils.isEmpty(csisHeader.get("TellerTp")) ? appHeader.get("tellertp") : csisHeader.get("TellerTp"));
        } else {
            appHeader.put("vm_zoneno", appHeader.get("vm_zoneno"));
            appHeader.put("vm_mbrno", appHeader.get("vm_mbrno"));
            appHeader.put("vm_brno", appHeader.get("vm_brno"));
            appHeader.put("vm_tellerno", appHeader.get("vm_tellerno"));
            appHeader.put("vm_tellertp", appHeader.get("vm_tellertp"));
        }
    }

    @Override
    public Map<String, Object> buildInMessageContext(Map<String, Object> tradeContext) {
        tradeContext = super.buildInMessageContext(tradeContext);
        initContent(tradeContext);
        return tradeContext;
    }


    public static class Ctrl_I extends MsgHeader {
        private MsgSegment msgSegment = init();

        private MsgSegment init() {
            MsgSegment messageNode = new MsgSegment();
            StructNode ctrlStruct = new StructNode("AppHeader", true, "Ctrl");
            ctrlStruct
                    .addNode(new FieldNode("GloSeqNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "GloSeqNo", 30, 0, true, "全局流水号")))
                    .addNode(new FieldNode("SrcCalCod", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcCalCod", 3, 0, true, "源请求方渠道编号")))
                    .addNode(new FieldNode("SrcChannelDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcChannelDate", 8, 0, true, "源请求方渠道日期")))
                    .addNode(new FieldNode("SrcChannelSerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "SrcChannelSerno", 30, 0, true, "源请求方渠道流水")))
                    .addNode(new FieldNode("eciSeverId", new MsgField(ContentEnum.MessageType.STRING.toString(), "eciSeverId", 10, 0, true, "ECI服务接口ID")))
                    .addNode(new FieldNode("xmlflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "xmlflag", 1, 0, false, "报文标识")))    //继续确认
                    .addNode(new FieldNode("templateCodeName", new MsgField(ContentEnum.MessageType.STRING.toString(), "templateCodeName", 6, 0, false, "模板名称")))//继续确认
                    .addNode(new FieldNode("transCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "transCode", 6, 0, false, "交易代码")))//继续确认
                    .addNode(new FieldNode("sysId", new MsgField(ContentEnum.MessageType.STRING.toString(), "sysId", 6, 0, false, "系统标识")))//继续确认
                    .addNode(new FieldNode("channelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelCode", 3, 0, false, "渠道分类")))//继续确认
                    .addNode(new FieldNode("subchannelCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "subchannelCode", 3, 0, false, "渠道标识")))//继续确认
                    .addNode(new FieldNode("tradeFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "tradeFlag", 1, 0, false, "是否需要勾兑")))//继续确认
                    .addNode(new FieldNode("checkFlag", new MsgField(ContentEnum.MessageType.STRING.toString(), "checkFlag", 1, 0, false, "是否需要判重")))//继续确认
                    .addNode(new FieldNode("prcscd", new MsgField(ContentEnum.MessageType.STRING.toString(), "prcscd", 20, 0, true, "渠道处理码")))
                    .addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40, 0, true, "渠道分类流水号")))
                    .addNode(new FieldNode("vm_tellerflag", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerflag", 1, 0, false, "柜员使用标志")))
                    .addNode(new FieldNode("vm_sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_sessid", 32, 0, false, "虚拟柜员会话标识")))
                    .addNode(new FieldNode("vm_zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_zoneno", 10, 0, false, "虚拟柜员操作分行")))
                    .addNode(new FieldNode("vm_mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_mbrno", 10, 0, false, "虚拟柜员操作支行")))
                    .addNode(new FieldNode("vm_brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_brno", 10, 0, false, "虚拟柜员操作网点")))
                    .addNode(new FieldNode("vm_tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellerno", 10, 0, false, "虚拟柜员")))
                    .addNode(new FieldNode("vm_tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_tellertp", 1, 0, false, "虚拟柜员柜员类别")))
                    .addNode(new FieldNode("vm_csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_csbxno", 10, 0, false, "虚拟柜员柜员钱箱")))
                    .addNode(new FieldNode("vm_dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutytp", 10, 0, false, "虚拟柜员岗位类型")))
                    .addNode(new FieldNode("vm_dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "vm_dutyno", 20, 0, false, "虚拟柜员岗位编号")))
                    .addNode(new FieldNode("sessid", new MsgField(ContentEnum.MessageType.STRING.toString(), "sessid", 32, 0, false, "会话标识")))
                    .addNode(new FieldNode("zoneno", new MsgField(ContentEnum.MessageType.STRING.toString(), "zoneno", 10, 0, false, "操作分行")))
                    .addNode(new FieldNode("mbrno", new MsgField(ContentEnum.MessageType.STRING.toString(), "mbrno", 10, 0, false, "操作支行")))
                    .addNode(new FieldNode("brno", new MsgField(ContentEnum.MessageType.STRING.toString(), "brno", 10, 0, false, "操作网点")))
                    .addNode(new FieldNode("MyBank", new MsgField(ContentEnum.MessageType.STRING.toString(), "MyBank", 10, 0, true, "法人号"))) //新核心接口新增法人号
                    .addNode(new FieldNode("tellerno", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellerno", 10, 0, false, "操作柜员")))
                    .addNode(new FieldNode("tellertp", new MsgField(ContentEnum.MessageType.STRING.toString(), "tellertp", 1, 0, false, "柜员类别")))
                    .addNode(new FieldNode("csbxno", new MsgField(ContentEnum.MessageType.STRING.toString(), "csbxno", 10, 0, false, "柜员钱箱号")))
                    .addNode(new FieldNode("dutytp", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutytp", 10, 0, false, "岗位类型")))
                    .addNode(new FieldNode("dutyno", new MsgField(ContentEnum.MessageType.STRING.toString(), "dutyno", 20, 0, false, "实体岗位编号")))
                    .addNode(new FieldNode("authno", new MsgField(ContentEnum.MessageType.STRING.toString(), "authno", 10, 0, false, "授权员")))
                    .addNode(new FieldNode("authpw", new MsgField(ContentEnum.MessageType.STRING.toString(), "authpw", 64, 0, false, "授权员密码")))
                    .addNode(new FieldNode("authmg", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmg", 512, 0, false, "授权员指纹")))
                    .addNode(new FieldNode("authce", new MsgField(ContentEnum.MessageType.STRING.toString(), "authce", 4, 0, false, "授权员验证类型")))
                    .addNode(new FieldNode("authmanfttype", new MsgField(ContentEnum.MessageType.STRING.toString(), "authmanfttype", 1, 0, false, "授权员指纹厂商")))
                    .addNode(new FieldNode("replyquery", new MsgField(ContentEnum.MessageType.STRING.toString(), "replyquery", 20, 0, false, "请求应答队列名")));
            messageNode.addStructNode(ctrlStruct);
            return messageNode;
        }

        @Override
        public ArrayList<Node> listNode() {
            // TODO 自动生成的方法存根
            return msgSegment.getNodeList();
        }
    }

    public static class Ctrl_O extends MsgHeader {
        private MsgSegment msgSegment = init();

        private MsgSegment init() {
            MsgSegment messageNode = new MsgSegment();
            StructNode ctrlStruct = new StructNode("Ctrl", true, "AppHeader");
            ctrlStruct.addNode(new FieldNode("errorCode", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorCode", 8, 0, false, "返回代码")))
                    .addNode(new FieldNode("errorMsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "errorMsg", 255, 0, false, "返回信息")))
                    .addNode(new FieldNode("workdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "workdate", 8, 0, false, "综合前置日期")))
                    .addNode(new FieldNode("worktime", new MsgField(ContentEnum.MessageType.STRING.toString(), "worktime", 6, 0, false, "综合前置时间")))
                    .addNode(new FieldNode("serialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "serialno", 10, 0, false, "综合前置流水")))
                    .addNode(new FieldNode("sverretcod", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverretcod", 8, 0, false, "后台服务返回代码")))
                    .addNode(new FieldNode("sverretmsg", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverretmsg", 255, 0, false, "后台服务返回信息")))
                    .addNode(new FieldNode("sverworkdate", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverworkdate", 8, 0, false, "后台服务返回日期")))
                    .addNode(new FieldNode("sverworktime", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverworktime", 6, 0, false, "后台服务返回时间")))
                    .addNode(new FieldNode("sverserialno", new MsgField(ContentEnum.MessageType.STRING.toString(), "sverserialno", 20, 0, false, "后台服务返回流水")))
                    .addNode(new FieldNode("channelserno", new MsgField(ContentEnum.MessageType.STRING.toString(), "channelserno", 40, 0, false, "渠道分类流水号")));
            messageNode.addStructNode(ctrlStruct);
            return messageNode;
        }

        @Override
        public ArrayList<Node> listNode() {
            return msgSegment.getNodeList();
        }
    }

    public static class Header_I extends MsgHeader {
        private MsgSegment msgSegment = init();

        private MsgSegment init() {
            MsgSegment messageNode = new MsgSegment();
            StructNode headStruct = new StructNode("APPBody", true, "Head");
            headStruct
                    .addNode(new FieldNode("FunctionId", new MsgField(ContentEnum.MessageType.STRING.toString(), "FunctionId", 20, 0, true, "交易代码")))
                    .addNode(new FieldNode("ExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExSerial", 30, 0, false, "发起方流水号")))
                    .addNode(new FieldNode("BankNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BankNo", 20, 0, false, "银行编号")))
                    .addNode(new FieldNode("BranchNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "BranchNo", 100, 0, false, "交易机构")))
                    .addNode(new FieldNode("Channel", new MsgField(ContentEnum.MessageType.STRING.toString(), "Channel", 10, 0, true, "交易渠道")))
                    .addNode(new FieldNode("TermNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "TermNo", 30, 0, false, "终端代码")))
                    .addNode(new FieldNode("OperNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "OperNo", 10, 0, false, "交易柜员")))
                    .addNode(new FieldNode("AuthOper", new MsgField(ContentEnum.MessageType.STRING.toString(), "AuthOper", 10, 0, false, "授权柜员")))
                    .addNode(new FieldNode("AuthPwd", new MsgField(ContentEnum.MessageType.STRING.toString(), "AuthPwd", 20, 0, false, "授权密码")))
                    .addNode(new FieldNode("TransDate", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransDate", 8, 0, false, "交易日期")))
                    .addNode(new FieldNode("TransTime", new MsgField(ContentEnum.MessageType.STRING.toString(), "TransTime", 16, 0, false, "交易时间")))
                    .addNode(new FieldNode("PrdType", new MsgField(ContentEnum.MessageType.STRING.toString(), "PrdType", 10, 0, false, "产品类别")))
                    .addNode(new FieldNode("Reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve", 100, 0, false, "交易附加信息")))
                    .addNode(new FieldNode("Reserve1", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve1", 100, 0, false, "附加信息1")))
                    .addNode(new FieldNode("Reserve2", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve2", 100, 0, false, "附加信息2")))
                    .addNode(new FieldNode("OpenBranch", new MsgField(ContentEnum.MessageType.STRING.toString(), "OpenBranch", 10, 0, false, "银行账号开户机构")));
            messageNode.addStructNode(headStruct);
            return messageNode;
        }

        @Override
        public ArrayList<Node> listNode() {
            // TODO 自动生成的方法存根
            return msgSegment.getNodeList();
        }
    }

    public static class Header_O extends MsgHeader {
        private MsgSegment msgSegment = init();

        private MsgSegment init() {
            MsgSegment messageNode = new MsgSegment();
            StructNode headStruct = new StructNode("Head", true, "APPBody");
            headStruct
                    .addNode(new FieldNode("FunctionId", new MsgField(ContentEnum.MessageType.STRING.toString(), "FunctionId", 20, 0, false, "交易代码")))
                    .addNode(new FieldNode("ExSerial", new MsgField(ContentEnum.MessageType.STRING.toString(), "ExSerial", 30, 0, false, "发起方流水号")))
                    .addNode(new FieldNode("ErrorNo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorNo", 20, 0, false, "错误代码")))
                    .addNode(new FieldNode("ErrorInfo", new MsgField(ContentEnum.MessageType.STRING.toString(), "ErrorInfo", 100, 0, false, "错误信息")))
                    .addNode(new FieldNode("Reserve", new MsgField(ContentEnum.MessageType.STRING.toString(), "Reserve", 100, 0, false, "交易附加信息")));
            messageNode.addStructNode(headStruct);
            return messageNode;
        }

        @Override
        public ArrayList<Node> listNode() {
            // TODO 自动生成的方法存根
            return msgSegment.getNodeList();
        }
    }

    public static class PubBodyI extends MsgBody {
        private MsgSegment msgSegment = init();

        private MsgSegment init() {
            MsgSegment messageNode = new MsgSegment();
            messageNode.addStructNode(new StructNode("APPBody", true, "Body")
                    .addNode(new FieldNode("Eciorgbuf", new MsgField(ContentEnum.MessageType.STRING.toString(), "Eciorgbuf", 1024, 0, false, "渠道备注信息"), ""))
            );
            return messageNode;
        }

        @Override
        public ArrayList<Node> listNode() {
            return msgSegment.getNodeList();
        }
    }

}
