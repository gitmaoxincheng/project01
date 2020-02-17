package tc.bank.entry;

import cn.com.agree.afa.svc.context.IContext;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.util.StringUtils;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.base.exception.IllegalReqFormatException;
import cn.com.agree.huanan.ap.rl.bank.base.util.SernoGenUtil;
import cn.com.agree.huanan.ap.rl.bank.trade.service.TradeFlowService;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;

public class EntryProc {
    public static final Logger logger = Logger.getLogger(EntryProc.class);
    // 处理返回字段,复制
    private static String[] csisheadList = new String[] {
        	"VrsNo",
        	"ScnNo",
        	"SrcDate",
        	"SrcTime",
        	"SrcSysId",
        	"SrcCalCod",
        	"GloSeqNo",
        	"GloEndTime",
        	"ReqNo",
        	"TellerNo",
        	"TellerTp",
        	"MyBank",
        	"BrNo",
        	"ZoneNo",
        	"SrcIP1",

    };
    // 处理返回字段,复制
    private static String[] headerList = new String[] {
        	"Action",
        	"Address",
    };
    
    /**
     * 业务交易开始
     * @param req
     * @param rsp
     */
    public static void entryInit(JavaDict req, JavaDict rsp) {
        logger.info("应答容器初始化");
        if (!rsp.hasKey(CommConstant.CSIS_HEADER)) {
            rsp.put(CommConstant.CSIS_HEADER, new JavaDict());
        }
        if (!rsp.hasKey(CommConstant.HEADER)) {
            rsp.put(CommConstant.HEADER, new JavaDict());
        }
        if (!rsp.hasKey(CommConstant.APP_HEADER)) {
            rsp.put(CommConstant.APP_HEADER, new JavaDict());
        }             
        if (!rsp.hasKey(CommConstant.APP_BODY)) {
            rsp.put(CommConstant.APP_BODY, new JavaDict());
        }
    }

    /**
     * 业务交易结束
     * @param req
     * @param rsp
     */
    public static void entryExit(JavaDict req, JavaDict rsp,String status) {
    	logger.info("应答容器报文拼接");
		logger.info(rsp.toString());
        JavaDict csisHeader = rsp.getDictItem(CommConstant.CSIS_HEADER,new JavaDict());
        // 应用已处理状态值，平台不做处理
        if (!StringUtils.isNullOrEmpty(csisHeader.getStringItem(CommConstant.STATUS))) {
            if(csisHeader.get(CommConstant.ERROR_CODE) == null){
                IContext context = EnvContextHolder.getHolder().getContext();
            	csisHeader.put(CommConstant.ERROR_CODE, context.getProperty("ERR_CODE"));
            	csisHeader.put(CommConstant.ERROR_MSG, context.getProperty("ERR_MSG"));
            }
/*        	switch (csisHeader.getStringItem(CommConstant.STATUS)) {
			case "U":
	            csisHeader.put(CommConstant.ERROR_CODE, csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.UNKNOWCODE));
	            csisHeader.put(CommConstant.ERROR_MSG, csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.UNKNOWMSG));
				break;
			case "P":
	            csisHeader.put(CommConstant.ERROR_CODE, csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.PARTSCODE));
	            csisHeader.put(CommConstant.ERROR_MSG, csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.PARTSMSG));
				break;
			case "I":
	            csisHeader.put(CommConstant.ERROR_CODE, csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.HANDCODE));
	            csisHeader.put(CommConstant.ERROR_MSG, csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.HANDMSG));
				break;
			default:
				break;
			}*/
        }// 成功
        else if ("S".equals(status)) {
        	logger.info("设置成功错误码");
            String ErrorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.SUCCCODE);
            String ErrorMsg= csisHeader.getStringItem(CommConstant.ERROR_MSG,CommConstant.SUCCMSG);
            csisHeader.put(CommConstant.STATUS, status);
            csisHeader.put(CommConstant.ERROR_CODE, ErrorCode);
            csisHeader.put(CommConstant.ERROR_MSG, ErrorMsg);
        }
        else {// 失败/异常
        	logger.error("设置失败错误码");
            IContext context = EnvContextHolder.getHolder().getContext();
            csisHeader.put(CommConstant.STATUS, status);
            if(csisHeader.get(CommConstant.ERROR_CODE) == null){
            	csisHeader.put(CommConstant.ERROR_CODE, context.getProperty("ERR_CODE")==null ? CommConstant.FAILCODE:context.getProperty("ERR_CODE"));
            }
            if(csisHeader.get(CommConstant.ERROR_MSG) == null ){
            	csisHeader.put(CommConstant.ERROR_MSG, context.getProperty("ERR_MSG")==null ? CommConstant.FAILMSG:context.getProperty("ERR_MSG"));
            }
        }
		
        // 处理返回字段,复制
        copyVars(csisheadList, req.getDictItem(CommConstant.CSIS_HEADER), csisHeader);
        
        JavaDict body = rsp.getDictItem(CommConstant.APP_BODY, new JavaDict());
        JavaDict appHeader = rsp.getDictItem(CommConstant.APP_HEADER, new JavaDict());

        rsp.clear();
        rsp.setItem(CommConstant.HEADER, req.getDictItem(CommConstant.HEADER, new JavaDict()));
        rsp.setItem(CommConstant.APP_HEADER, appHeader);	//XXX
        rsp.setItem(CommConstant.CSIS_HEADER, csisHeader);
        rsp.setItem(CommConstant.APP_BODY, body);
		logger.info(rsp.toString());

    }

    /**
     * 接入层交易开始
     * @param req
     * @param rsp
     */
    public static void entryInit2(JavaDict req, JavaDict rsp) {
        logger.info("应答容器初始化");
        if (!rsp.hasKey(CommConstant.CSIS_HEADER)) {
            rsp.put(CommConstant.CSIS_HEADER, new JavaDict());
        }
        JavaDict csisHeader = req.getDictItem(CommConstant.CSIS_HEADER); //XXX
        csisHeader.put(CommConstant.SERINO, SernoGenUtil.getRspSerno()); //生成平台交易流水号
        if (!rsp.hasKey(CommConstant.HEADER)) { //XXX
            rsp.put(CommConstant.HEADER, new JavaDict());
        }
        if (!rsp.hasKey(CommConstant.APP_HEADER)) {
            rsp.put(CommConstant.APP_HEADER, new JavaDict());
        }             
        if (!rsp.hasKey(CommConstant.APP_BODY)) {
            rsp.put(CommConstant.APP_BODY, new JavaDict());
        }
        if (!req.hasKey(CommConstant.CSIS_HEADER) ||!req.hasKey(CommConstant.HEADER) ) {
			throw new IllegalReqFormatException("报文头缺失");
		}
        if (!req.hasKey(CommConstant.APP_HEADER)) {
        	req.put(CommConstant.APP_HEADER, new JavaDict());
        }    
        req.put("__TRADETIME__", System.currentTimeMillis()); //记录交易时间
    }
    
    
    /**
     * 接入层交易开始
     * @param req
     * @param rsp
     */  
    public static void entryExit2(JavaDict req, JavaDict rsp,String status) {
    	
		logger.debug("应答容器报文拼接");
        JavaDict csisHeader = rsp.getDictItem(CommConstant.CSIS_HEADER,new JavaDict());
    	//TODO 把第三种状态N处理一下
        // 应用处理
        if (!StringUtils.isNullOrEmpty(csisHeader.getStringItem(CommConstant.STATUS))) {
        }// 成功
        else if (status.equals("S")) {
        	logger.info("设置成功错误码");
            String ErrorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE,CommConstant.SUCCCODE);
            String ErrorMsg= csisHeader.getStringItem(CommConstant.ERROR_MSG,CommConstant.SUCCMSG);
            csisHeader.put(CommConstant.STATUS, status);
            csisHeader.put(CommConstant.ERROR_CODE, ErrorCode);
            csisHeader.put(CommConstant.ERROR_MSG, ErrorMsg);
        }
        else {// 失败/异常
        	logger.info("设置失败错误码");
            IContext context = EnvContextHolder.getHolder().getContext();
            csisHeader.put(CommConstant.STATUS, status);
            if(csisHeader.get(CommConstant.ERROR_CODE) == null){
            	//屏蔽AFA平台返回码ACMP0E001
            	csisHeader.put(CommConstant.ERROR_CODE, context.getProperty("ERR_CODE")==null ? CommConstant.FAILCODE:CommConstant.AFAFAIL.equals(context.getProperty("ERR_CODE"))?CommConstant.FAILCODE:context.getProperty("ERR_CODE"));
            }
            if(csisHeader.get(CommConstant.ERROR_MSG) == null ){
            	csisHeader.put(CommConstant.ERROR_MSG, context.getProperty("ERR_MSG")==null ? CommConstant.FAILMSG:context.getProperty("ERR_MSG"));
            }
        }
		// 设置返回流水号和服务方交易日期
		csisHeader.setItem("RspNo", req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.SERINO));//使用平台流水号作为返回流水号，日志流水考虑优化XXX
		csisHeader.remove("SerialNo");
		csisHeader.setItem("SrvTranDt", DateTimeUtil.getSysDate());

        copyVars(csisheadList, req.getDictItem(CommConstant.CSIS_HEADER), csisHeader);
        JavaDict rspHeader = new JavaDict();
        copyVars(headerList, req.getDictItem(CommConstant.HEADER), rspHeader);

        JavaDict body = rsp.getDictItem(CommConstant.APP_BODY, new JavaDict());
        JavaDict httpHeader = rsp.getDictItem(cn.com.agree.huanan.ap.tl.communicate.http.base.Const.HEADER_KEY); //针对参数平台开发环境直连需要跨域的处理，后面正式应该去掉。
        JavaDict appHeader = rsp.getDictItem(CommConstant.APP_HEADER, new JavaDict());
        rsp.clear();
        rsp.setItem(CommConstant.HEADER, rspHeader);
        rsp.setItem(CommConstant.APP_HEADER, appHeader);
        rsp.setItem(CommConstant.CSIS_HEADER, csisHeader);
        rsp.setItem(CommConstant.APP_BODY, body);
		if ( httpHeader!= null) {
	        rsp.setItem(cn.com.agree.huanan.ap.tl.communicate.http.base.Const.HEADER_KEY, httpHeader);
		}
		if (null != req.getItem("__REGFLOW__")) {
			logger.info("更新渠道请求流水");
			// CsisHeader上的内容
			TradeFlowService tradeFlowService = SpringUtil.getBean(TradeFlowService.class);
			String reqSerialNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.REQNO);// 请求交易流水号
			String reqSysId = req.getDictItem(CommConstant.HEADER).getStringItem(CommConstant.ADDRESS);//请求渠道编号
			String tradeStatus = csisHeader.getStringItem(CommConstant.STATUS);
			String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE);
			String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG);
			int tolTime = (int) (System.currentTimeMillis() - req.getLongItem("__TRADETIME__")); //交易耗时
			tradeFlowService.updateTradeFlow(reqSysId,reqSerialNo,tradeStatus,errorCode,errorMsg,tolTime);
			
		}else if(null != req.getItem("__REGFLOW2__")){
			// CsisHeader上的内容
			TradeFlowService tradeFlowService = SpringUtil.getBean(TradeFlowService.class);
			String reqSerialNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.REQNO);// 请求交易流水号
			String reqSysId = req.getDictItem(CommConstant.HEADER).getStringItem(CommConstant.ADDRESS);//请求渠道编号
			String errorCode = csisHeader.getStringItem(CommConstant.ERROR_CODE);
			String errorMsg = csisHeader.getStringItem(CommConstant.ERROR_MSG);
			try {
				String regflag = req.getDictItem(CommConstant.HEADER).getStringItem(CommConstant.REGFLG);
				logger.info("regflag",regflag);
				if(regflag.equals("2")) {	//regflag为2，则更新
					logger.info("更新超时交易流水");
					tradeFlowService.updateTimeOut(reqSysId,reqSerialNo,status,errorCode,errorMsg,100);
				}
			}catch(Exception e) {
				logger.info("更新超时交易捕获异常 : ",e.getMessage());
			}
		}

    }    


    
    private static void copyVars(String[] namesList, JavaDict srcCtx, JavaDict dstCtx) {
        for (String name : namesList) {
            Object value = (srcCtx == null) ? "" : srcCtx.getItem(name, "");
            dstCtx.put(name, value);
        }
    }
}
