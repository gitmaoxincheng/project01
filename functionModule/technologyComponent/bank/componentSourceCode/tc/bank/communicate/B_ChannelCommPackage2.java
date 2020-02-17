package tc.bank.communicate;

import java.net.ConnectException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;

import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.jcomponent.SdkBroker;
import cn.com.agree.afa.jcomponent.ShortSocketClient;
import cn.com.agree.afa.svc.holder.EnvContextHolder;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.afa.util.future.IFuture;
import cn.com.agree.huanan.ap.rl.agree.afa.comm.AfaCommUtil;
import cn.com.agree.huanan.ap.rl.agree.afa.comm.AfaSocketAdapter;
import cn.com.agree.huanan.ap.rl.agree.afa.concurrent.IFutureAdapter;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.rl.bank.channels.commnunicate.RpcServerPara;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResultUtil;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommStatus;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommConnectException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApCommTimeOutException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.FileUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import tc.platform.base.P_Logger;

/**
 * 消息服务
 * 
 * @date 2018-08-21 15:9:59
 */
@ComponentGroup(level = "银行", groupName = "测试组件")
public class B_ChannelCommPackage2 {
	static Logger logger = Logger.getLogger(B_ChannelCommPackage.class);
	private static final int FAILURE = 0;
	private static final int SUCCESS = 1;
	private static final int EXCEPTION = 2;
	private static final int UNKNOWN = 3;


	/**
	 * @category 测试异步通讯
	 * @since future 出参|错误信息|{@link Object}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 * 		2 未知业务状态<br>
	 * 		3 异常<br>
	 */
	@OutParams(param = { @Param(name = "future", comment = "错误信息", logLevel = "3", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "未知业务状态"), @Return(id = "3", desp = "异常") })
	@Component(label = "测试异步通讯", style = "选择型", type = "异步组件", date = "2019-10-25 10:33:31")
	public static TCResult B_TestAsyn() {
		JavaDict req = (JavaDict)EnvContextHolder.getHolder().getContext().getRequest();
		String gloSeqNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.GloSeqNo); 
		String msg = "00001277<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Ctrl><GloSeqNo>"+gloSeqNo+"</GloSeqNo><SrcCalCod>STM</SrcCalCod><SrcChannelDate>20191209</SrcChannelDate><SrcChannelSerno>20191209105503458898</SrcChannelSerno><eciSeverId>BODAFA0042</eciSeverId><xmlflag>1</xmlflag><templateCodeName>dsdfcm</templateCodeName><transCode>881004</transCode><sysId>33</sysId><channelCode>011</channelCode><subchannelCode>CSI</subchannelCode><tradeFlag>0</tradeFlag><checkFlag>0</checkFlag><prcscd>cd047</prcscd><channelserno>C0310201912090064106959</channelserno><vm_tellerflag>1</vm_tellerflag><vm_sessid></vm_sessid><vm_zoneno></vm_zoneno><vm_mbrno></vm_mbrno><vm_brno></vm_brno><vm_tellerno></vm_tellerno><vm_tellertp></vm_tellertp><vm_csbxno></vm_csbxno><vm_dutytp></vm_dutytp><vm_dutyno></vm_dutyno><sessid></sessid><zoneno>0019900000</zoneno><isreauth></isreauth><mbrno>0019996011</mbrno><brno>0019996011</brno><MyBank>001</MyBank><tellerno>001000132</tellerno><tellertp>1</tellertp><csbxno></csbxno><dutytp></dutytp><dutyno></dutyno><authno></authno><authpw></authpw><authmg></authmg><authce></authce><authmanfttype></authmanfttype><replyquery></replyquery></Ctrl><Body><cardno></cardno><keytype>01</keytype><custid>441302199003107317</custid><insflag>1</insflag></Body></Request>";
		logger.debug("发送报文："+msg);
		logger.debug("报文消息：字节数："+msg.getBytes().length);
		TCResult tcRet = ShortSocketClient.asynRequest("sockOut1", 
				"10.1.1.62", 
				10402, 
				msg.getBytes(), 
				5000);
		// 异常
		logger.debug("AAStatus:%s, Code:%s, Msg:%s",tcRet.getStatus(),tcRet.getErrorCode(),tcRet.getErrorMsg());
		logger.debug("BBBA");
		IFuture ifuture2 = (IFuture) tcRet.getOutputParams().get(0);
		SdkBroker.doFuture(ifuture2, EnvContextHolder.getHolder().getContext());
		CompletableFuture<Supplier<Object>> result = IFutureAdapter.getCompletableFuture(ifuture2);
		IFuture ifuture = IFutureAdapter.getIFuture(result, (commRet, ex) -> {
			FileUtil.writeData2File("BBB1\n", "/export/loglog.txt",true,"UTF-8");

			logger.debug("Step3： Future");
			// 异常
			if (ex != null) {
				logger.exception("通讯过程发生错误：", ex);
				// 返回
				return getCommTCResult(EXCEPTION, ex);
			}
			logger.debug("Step4： getResult");
			// 状态判断
			logger.debug("Step5： getResult");
			logger.debug("commRet type: "+commRet.getClass().getName());

			// 成功
			return TCResult.newSuccessResult(commRet);
		});

		return new TCResult(1, Arrays.asList(new Object[] { ifuture }));
	}


	public static TCResult B_TestAsyn_1() {
		JavaDict req = (JavaDict)EnvContextHolder.getHolder().getContext().getRequest();
		String gloSeqNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.GloSeqNo); 
		String msg = "00001277<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Ctrl><GloSeqNo>"+gloSeqNo+"</GloSeqNo><SrcCalCod>STM</SrcCalCod><SrcChannelDate>20191209</SrcChannelDate><SrcChannelSerno>20191209105503458898</SrcChannelSerno><eciSeverId>BODAFA0042</eciSeverId><xmlflag>1</xmlflag><templateCodeName>dsdfcm</templateCodeName><transCode>881004</transCode><sysId>33</sysId><channelCode>011</channelCode><subchannelCode>CSI</subchannelCode><tradeFlag>0</tradeFlag><checkFlag>0</checkFlag><prcscd>cd047</prcscd><channelserno>C0310201912090064106959</channelserno><vm_tellerflag>1</vm_tellerflag><vm_sessid></vm_sessid><vm_zoneno></vm_zoneno><vm_mbrno></vm_mbrno><vm_brno></vm_brno><vm_tellerno></vm_tellerno><vm_tellertp></vm_tellertp><vm_csbxno></vm_csbxno><vm_dutytp></vm_dutytp><vm_dutyno></vm_dutyno><sessid></sessid><zoneno>0019900000</zoneno><isreauth></isreauth><mbrno>0019996011</mbrno><brno>0019996011</brno><MyBank>001</MyBank><tellerno>001000132</tellerno><tellertp>1</tellertp><csbxno></csbxno><dutytp></dutytp><dutyno></dutyno><authno></authno><authpw></authpw><authmg></authmg><authce></authce><authmanfttype></authmanfttype><replyquery></replyquery></Ctrl><Body><cardno></cardno><keytype>01</keytype><custid>441302199003107317</custid><insflag>1</insflag></Body></Request>";
		logger.debug("发送报文!Q#："+msg);
		logger.debug("报文消息：字节数："+msg.getBytes().length);
		/*		TCResult tcRet = ShortSocketClient.asynRequest("sockOut1", 
		"10.1.1.62", 
		10402, 
		msg.getBytes(), 
		5000);*/
		CommParam param = new CommParam();
		param.init("ECI", "ECI", "COMMON");
		AfaSocketAdapter socketAdapter = SpringUtil.getBean(AfaSocketAdapter.class);
		CompletableFuture<Supplier<CommResult<byte[]>>> retFuture = socketAdapter.commAsync(param, msg,null);
		FileUtil.writeData2File("B_WWW8\n", "/export/loglog.txt",true,"UTF-8");
		IFuture ifuture = IFutureAdapter.getIFuture(retFuture, (commRet, ex) -> {

			FileUtil.writeData2File("B_WWW9\n", "/export/loglog.txt",true,"UTF-8");
			logger.debug("Step3： Future");
			// 异常
			if (ex != null) {
				logger.exception("通讯过程发生错误：", ex);
				// 返回
				return getCommTCResult(EXCEPTION, ex);
			}
			logger.debug("Step4： getResult");
			// 状态判断
			logger.debug("Step5： getResult");
			logger.debug("commRet type: "+commRet.getClass().getName());
			logger.debug("commRetRsp type: "+commRet.getResponse().getBody().getClass().getName());
			FileUtil.writeData2File("B_WWW10\n", "/export/loglog.txt",true,"UTF-8");

			// 成功
			return TCResult.newSuccessResult(commRet);
		});

		return new TCResult(1, Arrays.asList(new Object[] { ifuture }));
	}

	public static TCResult B_TestAsyn_4() {
		JavaDict req = (JavaDict)EnvContextHolder.getHolder().getContext().getRequest();
		String gloSeqNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.GloSeqNo); 
		String msg = "00001277<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Ctrl><GloSeqNo>"+gloSeqNo+"</GloSeqNo><SrcCalCod>STM</SrcCalCod><SrcChannelDate>20191209</SrcChannelDate><SrcChannelSerno>20191209105503458898</SrcChannelSerno><eciSeverId>BODAFA0042</eciSeverId><xmlflag>1</xmlflag><templateCodeName>dsdfcm</templateCodeName><transCode>881004</transCode><sysId>33</sysId><channelCode>011</channelCode><subchannelCode>CSI</subchannelCode><tradeFlag>0</tradeFlag><checkFlag>0</checkFlag><prcscd>cd047</prcscd><channelserno>C0310201912090064106959</channelserno><vm_tellerflag>1</vm_tellerflag><vm_sessid></vm_sessid><vm_zoneno></vm_zoneno><vm_mbrno></vm_mbrno><vm_brno></vm_brno><vm_tellerno></vm_tellerno><vm_tellertp></vm_tellertp><vm_csbxno></vm_csbxno><vm_dutytp></vm_dutytp><vm_dutyno></vm_dutyno><sessid></sessid><zoneno>0019900000</zoneno><isreauth></isreauth><mbrno>0019996011</mbrno><brno>0019996011</brno><MyBank>001</MyBank><tellerno>001000132</tellerno><tellertp>1</tellertp><csbxno></csbxno><dutytp></dutytp><dutyno></dutyno><authno></authno><authpw></authpw><authmg></authmg><authce></authce><authmanfttype></authmanfttype><replyquery></replyquery></Ctrl><Body><cardno></cardno><keytype>01</keytype><custid>441302199003107317</custid><insflag>1</insflag></Body></Request>";
		logger.debug("发送报文："+msg);
		logger.debug("报文消息：字节数："+msg.getBytes().length);
		CommParam param = new CommParam();
		param.init("ECI", "ECI", "COMMON");

		TCResult tcRet = ShortSocketClient.asynRequest("sockOut1", 
				"10.1.1.62", 
				10402, 
				msg.getBytes(), 
				5000);
		// 异常
		logger.debug("AAStatus:%s, Code:%s, Msg:%s",tcRet.getStatus(),tcRet.getErrorCode(),tcRet.getErrorMsg());
		logger.debug("RWA");
		CompletableFuture<Supplier<CommResult<byte[]>>> retFuture = AfaCommUtil.procAsyncCommResult(tcRet, List.class, param,(rspList) -> {
			FileUtil.writeData2File("B_WWW0\n", "/export/loglog.txt",true,"UTF-8");
			/**
			 * index-0：通讯耗时
			 * index-1：通讯报文
			 */
			if (rspList.size() < 2) {
				throw new ApValueOutOfRangeException(rspList.size());
			}
			Number commTime = (Number) rspList.get(0);
			long commTimeLong = commTime.longValue();
			byte[] msgBody = (byte[]) rspList.get(1);
			logger.info("耗时：%d.%03d", 
					commTimeLong / 1000,
					commTimeLong % 1000
					);
			FileUtil.writeData2File("B_WWW1\n", "/export/loglog.txt",true,"UTF-8");
			return msgBody;
		});
		/////////
		FileUtil.writeData2File("B_WWW8\n", "/export/loglog.txt",true,"UTF-8");
		IFuture ifuture = IFutureAdapter.getIFuture(retFuture, (commRet, ex) -> {

			FileUtil.writeData2File("B_WWW9\n", "/export/loglog.txt",true,"UTF-8");
			logger.debug("Step3： Future");
			// 异常
			if (ex != null) {
				logger.exception("通讯过程发生错误：", ex);
				// 返回
				return getCommTCResult(EXCEPTION, ex);
			}
			logger.debug("Step4： getResult");
			// 状态判断
			logger.debug("Step5： getResult");
			logger.debug("commRet type: "+commRet.getClass().getName());
			logger.debug("commRetRsp type: "+commRet.getResponse().getBody().getClass().getName());
			FileUtil.writeData2File("B_WWW10\n", "/export/loglog.txt",true,"UTF-8");

			// 成功
			return TCResult.newSuccessResult(commRet);
		});

		return new TCResult(1, Arrays.asList(new Object[] { ifuture }));
	}


	public static <T> CompletableFuture<Supplier<CommResult<byte[]>>> procAsyncCommResult(TCResult tcRet, Class<T> rspType, Function<T, byte[]> action) {

		logger.debug("运行：AfaCommUtil.procAsyncCommResult：Step1"); 

		// 异常
		if (tcRet.getStatus() != 1) {
			return CommResultUtil.wrapByFuture(CommResultUtil.getAbendResult(tcRet.getErrorCode(), tcRet.getErrorMsg()));
		}
		// 提取future
		IFuture ifuture = (IFuture) tcRet.getOutputParams().get(0);

		logger.debug("运行：AfaCommUtil.procAsyncCommResult：Step2");
		// 包装
		CompletableFuture<Supplier<Object>> msgFuture = IFutureAdapter.getCompletableFuture(ifuture);
		logger.debug("运行：AfaCommUtil.procAsyncCommResult：Step3");
		CompletableFuture<Supplier<CommResult<byte[]>>> retFuture = new CompletableFuture<>();
		FileUtil.writeData2File("AfaCommUtil_WWW0\n", "/export/loglog.txt",true,"UTF-8");
		msgFuture.whenComplete((rspSupplier, futureEx) -> {
			FileUtil.writeData2File("B_WWW1\n", "/export/loglog.txt",true,"UTF-8");
			retFuture.complete(() -> {
				FileUtil.writeData2File("B_WWW2\n", "/export/loglog.txt",true,"UTF-8");

				boolean isFailed = false;
				try {
					FileUtil.writeData2File("B_WWW3\n", "/export/loglog.txt",true,"UTF-8");
					// 出现异常
					if (futureEx != null) {
						FileUtil.writeData2File("B_WWW4\n", "/export/loglog.txt",true,"UTF-8");
						// 判断是否失败
						Integer statusProp = (Integer) ifuture.getProperty(IFuture.STATUS);
						logger.error("afa future error: %s, %s", statusProp, futureEx);
						if (statusProp != null && statusProp.intValue() == IFuture.SEND_REQUEST_FAIL) {
							isFailed = true;
						}
						throw futureEx;
					}
					FileUtil.writeData2File("B_WWW5\n", "/export/loglog.txt",true,"UTF-8");
					// 获取结果
					Object rspObj = rspSupplier.get();
					if (!List.class.isInstance(rspObj)) {
						logger.error("通讯返回类型非法：[%s], %s", rspObj.getClass(), rspObj);
						throw new ApValueTypeUnsupportException(rspObj);
					}
					FileUtil.writeData2File("B_WWW6\n", "/export/loglog.txt",true,"UTF-8");

					// 处理结果：T -> byte[]
					byte[] msgBody = "TTTTTTTTTTTTTTT".getBytes();
					// 返回
					return CommResult.getSuccess(msgBody);
				}
				catch (Throwable ex) {
					FileUtil.writeData2File("B_WWW7\n", "/export/loglog.txt",true,"UTF-8");
					logger.exception(ex);
					// 超时
					if (ex instanceof TimeoutException) {
						ex = new ApCommTimeOutException("");
					}
					// 连接错误
					else if (ex instanceof ConnectException) {
						ex = new ApCommConnectException("");
					}
					// 返回
					return isFailed ? CommResultUtil.getFailedResult(ex) : CommResultUtil.getAbendResult(ex);
				}
			});
		});   
		logger.debug("运行：AfaCommUtil.procAsyncCommResult：Step10");
		// 
		return retFuture;
	}	


	public static TCResult B_TestAsyn_2() {
		JavaDict req = (JavaDict)EnvContextHolder.getHolder().getContext().getRequest();
		String gloSeqNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.GloSeqNo); 
		String msg = "00001277<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Ctrl><GloSeqNo>"+gloSeqNo+"</GloSeqNo><SrcCalCod>STM</SrcCalCod><SrcChannelDate>20191209</SrcChannelDate><SrcChannelSerno>20191209105503458898</SrcChannelSerno><eciSeverId>BODAFA0042</eciSeverId><xmlflag>1</xmlflag><templateCodeName>dsdfcm</templateCodeName><transCode>881004</transCode><sysId>33</sysId><channelCode>011</channelCode><subchannelCode>CSI</subchannelCode><tradeFlag>0</tradeFlag><checkFlag>0</checkFlag><prcscd>cd047</prcscd><channelserno>C0310201912090064106959</channelserno><vm_tellerflag>1</vm_tellerflag><vm_sessid></vm_sessid><vm_zoneno></vm_zoneno><vm_mbrno></vm_mbrno><vm_brno></vm_brno><vm_tellerno></vm_tellerno><vm_tellertp></vm_tellertp><vm_csbxno></vm_csbxno><vm_dutytp></vm_dutytp><vm_dutyno></vm_dutyno><sessid></sessid><zoneno>0019900000</zoneno><isreauth></isreauth><mbrno>0019996011</mbrno><brno>0019996011</brno><MyBank>001</MyBank><tellerno>001000132</tellerno><tellertp>1</tellertp><csbxno></csbxno><dutytp></dutytp><dutyno></dutyno><authno></authno><authpw></authpw><authmg></authmg><authce></authce><authmanfttype></authmanfttype><replyquery></replyquery></Ctrl><Body><cardno></cardno><keytype>01</keytype><custid>441302199003107317</custid><insflag>1</insflag></Body></Request>";
		logger.debug("发送报文："+msg);
		logger.debug("报文消息：字节数："+msg.getBytes().length);
		TCResult tcRet = ShortSocketClient.asynRequest("sockOut1", 
				"10.1.1.62", 
				10402, 
				msg.getBytes(), 
				5000);
		// 异常
		logger.debug("AAStatus:%s, Code:%s, Msg:%s",tcRet.getStatus(),tcRet.getErrorCode(),tcRet.getErrorMsg());
		logger.debug("YYA");
		IFuture ifuture2 = (IFuture) tcRet.getOutputParams().get(0);
		CompletableFuture<Supplier<Object>> result = IFutureAdapter.getCompletableFuture(ifuture2);
		CompletableFuture<Supplier<CommResult<byte[]>>> retFuture = new CompletableFuture<>();
		FileUtil.writeData2File("B_WWW0\n", "/export/loglog.txt",true,"UTF-8");
		result.whenComplete((rspSupplier, futureEx) -> {
			FileUtil.writeData2File("B_WWW1\n", "/export/loglog.txt",true,"UTF-8");
			retFuture.complete(() -> {
				FileUtil.writeData2File("B_WWW2\n", "/export/loglog.txt",true,"UTF-8");

				boolean isFailed = false;
				try {
					FileUtil.writeData2File("B_WWW3\n", "/export/loglog.txt",true,"UTF-8");
					// 出现异常
					if (futureEx != null) {
						FileUtil.writeData2File("B_WWW4\n", "/export/loglog.txt",true,"UTF-8");
						// 判断是否失败
						Integer statusProp = (Integer) ifuture2.getProperty(IFuture.STATUS);
						logger.error("afa future error: %s, %s", statusProp, futureEx);
						if (statusProp != null && statusProp.intValue() == IFuture.SEND_REQUEST_FAIL) {
							isFailed = true;
						}
						throw futureEx;
					}
					FileUtil.writeData2File("B_WWW5\n", "/export/loglog.txt",true,"UTF-8");
					// 获取结果
					Object rspObj = rspSupplier.get();
					if (!List.class.isInstance(rspObj)) {
						logger.error("通讯返回类型非法：[%s], %s", rspObj.getClass(), rspObj);
						throw new ApValueTypeUnsupportException(rspObj);
					}
					FileUtil.writeData2File("B_WWW6\n", "/export/loglog.txt",true,"UTF-8");

					// 处理结果：T -> byte[]
					byte[] msgBody = "TTTTTTTTTTTTTTT".getBytes();
					// 返回
					return CommResult.getSuccess(msgBody);
				}
				catch (Throwable ex) {
					FileUtil.writeData2File("B_WWW7\n", "/export/loglog.txt",true,"UTF-8");
					logger.exception(ex);
					// 超时
					if (ex instanceof TimeoutException) {
						ex = new ApCommTimeOutException("");
					}
					// 连接错误
					else if (ex instanceof ConnectException) {
						ex = new ApCommConnectException("");
					}
					// 返回
					return isFailed ? CommResultUtil.getFailedResult(ex) : CommResultUtil.getAbendResult(ex);
				}
			});
		});
		FileUtil.writeData2File("B_WWW8\n", "/export/loglog.txt",true,"UTF-8");
		IFuture ifuture = IFutureAdapter.getIFuture(retFuture, (commRet, ex) -> {

			FileUtil.writeData2File("B_WWW9\n", "/export/loglog.txt",true,"UTF-8");
			logger.debug("Step3： Future");
			// 异常
			if (ex != null) {
				logger.exception("通讯过程发生错误：", ex);
				// 返回
				return getCommTCResult(EXCEPTION, ex);
			}
			logger.debug("Step4： getResult");
			// 状态判断
			logger.debug("Step5： getResult");
			logger.debug("commRet type: "+commRet.getClass().getName());
			logger.debug("commRetRsp type: "+commRet.getResponse().getBody().getClass().getName());
			FileUtil.writeData2File("B_WWW10\n", "/export/loglog.txt",true,"UTF-8");

			// 成功
			return TCResult.newSuccessResult(commRet);
		});

		return new TCResult(1, Arrays.asList(new Object[] { ifuture }));
	}





	/**
	 * @category 测试异步通讯2
	 * @since future 出参|错误信息|{@link Object}
	 * @return 0 失败<br>
	 * 		1 成功<br>
	 * 		2 未知业务状态<br>
	 * 		3 异常<br>
	 */
	@OutParams(param = { @Param(name = "future", comment = "错误信息", logLevel = "3", type = Object.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "未知业务状态"), @Return(id = "3", desp = "异常") })
	@Component(label = "测试异步通讯2", style = "选择型", type = "异步组件", date = "2019-10-25 10:33:31")
	public static TCResult B_TestAsyn2() {
		JavaDict req = (JavaDict)EnvContextHolder.getHolder().getContext().getRequest();
		String gloSeqNo = req.getDictItem(CommConstant.CSIS_HEADER).getStringItem(CommConstant.GloSeqNo); 
		String msg = "00001277<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Ctrl><GloSeqNo>"+gloSeqNo+"</GloSeqNo><SrcCalCod>STM</SrcCalCod><SrcChannelDate>20191209</SrcChannelDate><SrcChannelSerno>20191209105503458898</SrcChannelSerno><eciSeverId>BODAFA0042</eciSeverId><xmlflag>1</xmlflag><templateCodeName>dsdfcm</templateCodeName><transCode>881004</transCode><sysId>33</sysId><channelCode>011</channelCode><subchannelCode>CSI</subchannelCode><tradeFlag>0</tradeFlag><checkFlag>0</checkFlag><prcscd>cd047</prcscd><channelserno>C0310201912090064106959</channelserno><vm_tellerflag>1</vm_tellerflag><vm_sessid></vm_sessid><vm_zoneno></vm_zoneno><vm_mbrno></vm_mbrno><vm_brno></vm_brno><vm_tellerno></vm_tellerno><vm_tellertp></vm_tellertp><vm_csbxno></vm_csbxno><vm_dutytp></vm_dutytp><vm_dutyno></vm_dutyno><sessid></sessid><zoneno>0019900000</zoneno><isreauth></isreauth><mbrno>0019996011</mbrno><brno>0019996011</brno><MyBank>001</MyBank><tellerno>001000132</tellerno><tellertp>1</tellertp><csbxno></csbxno><dutytp></dutytp><dutyno></dutyno><authno></authno><authpw></authpw><authmg></authmg><authce></authce><authmanfttype></authmanfttype><replyquery></replyquery></Ctrl><Body><cardno></cardno><keytype>01</keytype><custid>441302199003107317</custid><insflag>1</insflag></Body></Request>";
		logger.debug("发送报文："+msg);
		logger.debug("报文消息：字节数："+msg.getBytes().length);
		/*		TCResult tcRet = ShortSocketClient.asynRequest("sockOut1", 
				"10.1.1.62", 
				10402, 
				msg.getBytes(), 
				5000);*/
		CommParam param = new CommParam();
		param.init("ECI", "ECI", "COMMON");
		AfaSocketAdapter socketAdapter = SpringUtil.getBean(AfaSocketAdapter.class);
		CompletableFuture<Supplier<CommResult<byte[]>>> future = socketAdapter.commAsync(param, msg,null);
		// 转换
		IFuture ifuture = IFutureAdapter.getIFuture(future, (commRet, ex) -> {
			logger.debug("Step3： Future");
			// 异常
			if (ex != null) {
				logger.exception("通讯过程发生错误：", ex);
				// 返回
				return getCommTCResult(EXCEPTION, ex);
			}
			logger.debug("Step4： getResult");
			// 状态判断
			CommStatus commStatus = commRet.getCommStatus();
			Object commResult = commRet.getResponse().getBody();
			logger.debug("Step5： getResult");
			P_Logger.P_info(commResult);
			// 成功
			if (commStatus == CommStatus.SUCCESS) {
				return TCResult.newSuccessResult(commResult);
			}else {
				logger.debug("EEEEEEEEEE");
				throw new ApSystemException(new Exception());
			}
		});
		return new TCResult(1, Arrays.asList(new Object[] { ifuture }));
	}	


	/**
	 * @category 渠道通讯组件
	 * @param systemID
	 *            入参|系统标识-对应IO类所在service下的目录|{@link java.lang.String}
	 * @param mc
	 *            入参|交易服务码|{@link java.lang.String}
	 * @param tc
	 *            入参|交易场景码|{@link java.lang.String}
	 * @param REQ
	 *            入参|输入交易上下文|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|交易返回上下文|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param isCheckMessage
	 *            入参|是否校验报文字段|boolean
	 * @since errorCode 出参|错误码|{@link java.lang.String}
	 * @since errorMessage 出参|错误信息|{@link java.lang.String}
	 * @since tradeStatus 出参|返回状态|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 *         2 未知业务状态<br>
	 *         3 异常<br>
	 */
	@InParams(param = {
			@Param(name = "systemID", comment = "系统标识-对应IO类所在service下的目录", logLevel = "3", type = java.lang.String.class),
			@Param(name = "mc", comment = "交易服务码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tc", comment = "交易场景码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "REQ", comment = "输入交易上下文", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "交易返回上下文", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "isCheckMessage", comment = "是否校验报文字段", type = boolean.class) })
	@OutParams(param = { @Param(name = "errorCode", comment = "错误码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "errorMessage", comment = "错误信息", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tradeStatus", comment = "返回状态", logLevel = "3", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "未知业务状态"), @Return(id = "3", desp = "异常") })
	@Component(label = "渠道通讯组件", style = "选择型", type = "同步组件", comment = "在对应路径下根据需要通讯的系统,继承一个system里的父类,创建一个service服务类.*组件根据MC,TC找到对应的服务,实现对应的服务*涉及参数配置表:t_comm_param(这个必须配置)和t_comm_param_ext(这个不配自动取默认值)", author = "xqq", date = "2019-01-25 10:24:45")
	public static TCResult B_ChannelComm(String systemID, String mc, String tc, JavaDict REQ, JavaDict RSP,
			boolean isCheckMessage) {
		ChannelCommImpl channelComm = new ChannelCommImpl();
		JavaDict tradeRsp = null;
		JavaDict rspBody = null;
		JavaDict rspAppHeader = null;

		int tradeRst = FAILURE; //预定义失败
		String errCode = CommConstant.ERROR_CODE;
		String errMessage = CommConstant.ERROR_MSG;
		String errStatus = "U"; // 应该默认处理为未知
		try {
			channelComm.initService(systemID, mc, tc);
			// .initTradeContenxt(REQ);
			/*if (!isCheckMessage || true == REQ.getBooleanItem(("__IOCHECK__"), false)) {
				logger.debug("取消报文校验");
				channelComm.cancelCheck();
			}*/
			tradeRst = EXCEPTION;//通讯失败
			tradeRsp = channelComm.exchange(REQ); // 渠道通讯
			//Optional<JavaDict> dictOp = Optional.ofNullable(tradeRsp);
			// tradeRsp = dictOp.orElseGet(JavaDict::new);
			rspBody = tradeRsp.getDictItem(CommConstant.APP_BODY);
			rspAppHeader = tradeRsp.getDictItem(CommConstant.APP_HEADER);
			RSP.put(CommConstant.APP_BODY, rspBody);
			RSP.put(CommConstant.APP_HEADER, rspAppHeader);
			String tradeStatus = channelComm.getTradeStatus();
			logger.debug("交易结果状态:" + tradeStatus.toUpperCase());
			errCode = channelComm.getErrorCode();
			errMessage = channelComm.getErrorMessage();
			errStatus = tradeStatus;
			// 交易状态 0 成功 1 失败 2 异常
			switch (tradeStatus.toUpperCase()) {
			case "S":
				tradeRst = SUCCESS;
				break;
			case "F":
				tradeRst = FAILURE;
				break;
			case "U":
				tradeRst = UNKNOWN;
				break;
			default:
				break;
			}
			
			return new TCResult(tradeRst, Arrays.asList(new Object[] { errCode, errMessage, errStatus }));
		} catch (Exception e) {
			logger.exception("通讯组件异常",e);
			// 返回
			return getCommTCResult(tradeRst, e);
			/*			logger.exception(e);
			if (e instanceof ApException) {
				ApException apex = (ApException) e;
				logger.debug("业务异常:" + apex.getErrorMsg());
				tradeRst = FAILURE;
				errCode = apex.getErrorCode();
				errMessage = apex.getErrorMsg();
				errStatus = "F";
			} else {
				logger.debug("通讯组件异常:" + e.toString());
				tradeRst = EXCEPTION;
				errCode = "通讯组件异常:" + e.toString();
				errMessage = "通讯组件异常:" + e.toString();
				errStatus = "U";
			}*/
		}
	}

	/**
	 * @category 渠道异步通讯组件
	 * @param systemID
	 *            入参|系统标识-对应IO类所在service下的目录|{@link java.lang.String}
	 * @param mc
	 *            入参|交易服务码|{@link java.lang.String}
	 * @param tc
	 *            入参|交易场景码|{@link java.lang.String}
	 * @param REQ
	 *            入参|输入交易上下文|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param RSP
	 *            入参|交易返回上下文|{@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param isCheckMessage
	 *            入参|是否校验报文字段|boolean
	 * @since errorCode 出参|错误码|{@link java.lang.String}
	 * @since errorMessage 出参|错误信息|{@link java.lang.String}
	 * @since tradeStatus 出参|返回状态|{@link java.lang.String}
	 * @return 0 失败<br>
	 *         1 成功<br>
	 *         2 异常<br>
	 */
	@InParams(param = {
			@Param(name = "systemID", comment = "系统标识-对应IO类所在service下的目录", logLevel = "3", type = java.lang.String.class),
			@Param(name = "mc", comment = "交易服务码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tc", comment = "交易场景码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "REQ", comment = "输入交易上下文", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "RSP", comment = "交易返回上下文", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "isCheckMessage", comment = "是否校验报文字段", defaultParam = "true", type = boolean.class) })
	@OutParams(param = { @Param(name = "errorCode", comment = "错误码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "errorMessage", comment = "错误信息", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tradeStatus", comment = "返回状态", logLevel = "3", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "异常") })
	@Component(label = "渠道异步通讯组件", style = "选择型", type = "异步组件", comment = "在对应路径下根据需要通讯的系统,继承一个system里的父类,创建一个service服务类.*组件根据MC,TC找到对应的服务,实现对应的服务*涉及参数配置表:t_comm_param(这个必须配置)和t_comm_param_ext(这个不配自动取默认值)", date = "2019-09-06 03:26:33")
	public static TCResult B_ChannelCommAsync(String systemID, String mc, String tc, JavaDict REQ, JavaDict RSP,
			boolean isCheckMessage) {
		int tcStatus = FAILURE;
		try {
			// 预处理
			ChannelCommImpl channelComm = new ChannelCommImpl();
			channelComm.initService(systemID, mc, tc);
			// 标记异常
			tcStatus = EXCEPTION;
			// 通讯
			logger.debug("通讯前");
			CompletableFuture<Supplier<CommResult<JavaDict>>> future = channelComm.exchangeAsync(REQ);
			logger.debug("通讯后");
			// 转换
			IFuture ifuture = IFutureAdapter.getIFuture(future, (commRet, ex) -> {
				// 异常
				if (ex != null) {
					logger.exception("通讯过程发生错误：", ex);
					// 返回
					return getCommTCResult(EXCEPTION, ex);
				}
				// 状态判断
				CommStatus commStatus = commRet.getCommStatus();
				// 成功
				if (commStatus == CommStatus.SUCCESS) {
					// 通讯成功，处理业务结果
					JavaDict tradeRsp = commRet.getResponse().getBody();
					JavaDict rspBody = tradeRsp.getDictItem(CommConstant.APP_BODY);
					JavaDict rspAppHeader = tradeRsp.getDictItem(CommConstant.APP_HEADER);
					RSP.put(CommConstant.APP_BODY, rspBody);
					RSP.put(CommConstant.APP_HEADER, rspAppHeader);
					String tradeStatus = channelComm.getTradeStatus();
					logger.debug("交易结果状态:",tradeStatus.toUpperCase());
					String errCode = channelComm.getErrorCode();
					String errMessage = channelComm.getErrorMessage();
					String errStatus = tradeStatus;
					// 交易状态 0 成功 1 失败 2 异常
					int tradeRst = EXCEPTION;
					switch (tradeStatus.toUpperCase()) {
					case "S":
						tradeRst = SUCCESS;
						break;
					case "F":
						tradeRst = FAILURE;
						break;
					case "U":
						tradeRst = UNKNOWN;
						break;
					default:
						break;
					}
					return getCommTCResult(tradeRst, errCode, errMessage, errStatus);
				}
				// 失败
				else if (commStatus == CommStatus.FAILED) {
					return getCommTCResult(FAILURE, commRet.getErrorCode(), commRet.getErrorMsg());
				}
				// 异常
				else {
					return getCommTCResult(EXCEPTION, commRet.getErrorCode(), commRet.getErrorMsg());
				}
			});
			// 返回成功
			return TCResult.newSuccessResult(ifuture);
		} catch (Exception ex) {
			logger.exception(ex);
			// 返回
			return getCommTCResult(tcStatus, ex);
		}
	}

	private static TCResult getCommTCResult(int tcStatus, Throwable ex) {
		// 转换
		ApException apEx = ExceptionUtil.convert(ex);
		// 转发
		return getCommTCResult(tcStatus, apEx.getErrorCode(), apEx.getErrorMsg());
	}

	private static TCResult getCommTCResult(int tcStatus, String errorCode, String errorMsg) {
		return getCommTCResult(tcStatus, errorCode, errorMsg, null);
	}

	private static TCResult getCommTCResult(int tcStatus, String errorCode, String errorMsg, String errStatus) {
		// 转换状态
		if (errStatus == null) {
			errStatus = convertStatus(tcStatus);
		}
		// 返回
		List<Object> outParams = Arrays.asList(errorCode, errorMsg, errStatus);
		return new TCResult(tcStatus, errorCode, errorMsg, outParams);
	}

	private static String convertStatus(int tcStatus) {
		if (tcStatus == SUCCESS) {
			return "S";
		} else if (tcStatus == FAILURE) {
			return "F";
		} else {
			return "U";
		}
	}

	/**
	 * @category 拼接报文-使用IO表
	 * @param REQ
	 *            入参|交易上下文| {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param systemID
	 *            入参|系统标识-对应service下的目录|{@link java.lang.String}
	 * @param mc
	 *            入参|交易服务码|{@link java.lang.String}
	 * @param tc
	 *            入参|交易场景码|{@link java.lang.String}
	 * @param isCheckMessage
	 *            入参|是否校验报文字段|{@link boolean}
	 * @param requestMessage
	 *            出参|请求报文|{@link java.lang.String}
	 * @return 1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "REQ", comment = "交易上下文", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "systemID", comment = "系统标识-对应service下的目录", logLevel = "3", type = java.lang.String.class),
			@Param(name = "mc", comment = "交易服务码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tc", comment = "交易场景码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "isCheckMessage", comment = "是否校验报文字段", defaultParam = "true", type = boolean.class) })
	@OutParams(param = { @Param(name = "requestMessage", comment = "请求报文", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@Component(label = "拼接报文-使用IO表", style = "处理型", type = "同步组件", comment = "在cn.com.agree.huanan.ap.rl.bank.gnxcomm.io路径下根据需要通讯的系统,继承一个system里的父类,创建一个service服务类.*组件根据MC,TC找到对应的服务,实现对应的服务", author = "xqq", date = "2019-03-06 05:30:39")
	public static TCResult B_packMessage(JavaDict REQ, String systemID, String mc, String tc, boolean isCheckMessage) {
		return TechComp.call(() -> {
			ChannelCommImpl channelComm = new ChannelCommImpl();
			channelComm.initService(systemID, mc, tc).initTradeContenxt(REQ);
			return new Object[] { channelComm.getRequest() };
		});
	}

	/**
	 * @category 获取Rpc通讯参数
	 * @param appId
	 *            入参|应用编号|{@link java.lang.String}
	 * @param commItem
	 *            入参|报文类型|{@link java.lang.String}
	 * @param paraDict
	 *            出参|配置的参数| {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 1 成功<br/>
	 */
	@InParams(param = { @Param(name = "appId", comment = "应用编号", type = java.lang.String.class),
			@Param(name = "commItem", comment = "报文类型", type = java.lang.String.class) })
	@OutParams(param = {
			@Param(name = "paraDict", comment = "配置的参数", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "1", desp = "成功") })
	@Component(label = "获取Rpc通讯参数", style = "处理型", type = "同步组件", comment = "涉及参数配置表:t_comm_param_ext,必须配置", author = "CHAOJIGUITAI08", date = "2019-01-14 08:16:51")
	public static TCResult B_InitRpcPara(String appId, String commItem) {
		return TechComp.call(() -> {
			RpcServerPara rpcPara = new RpcServerPara();
			rpcPara.builderPara("COMMON", appId, commItem);
			JavaDict paraDict = JavaDictUtil.mapToDict(rpcPara.getParaMap());
			return new Object[] { paraDict };
		});
	}

	/**
	 * @category 拆解报文-使用IO表
	 * @param jsonMessage
	 *            入参|json报文字符串|{@link java.lang.String}
	 * @param systemID
	 *            入参|系统标识-对应service下的目录|{@link java.lang.String}
	 * @param mc
	 *            入参|交易服务码|{@link java.lang.String}
	 * @param tc
	 *            入参|交易场景码|{@link java.lang.String}
	 * @param isCheckMessage
	 *            入参|是否校验报文字段|{@link boolean}
	 * @param messageInfo
	 *            出参|拆分后的报文容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param rsponseBodyContext
	 *            出参|响应报文体容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @param errorCode
	 *            出参|错误码|{@link java.lang.String}
	 * @param errorMessage
	 *            出参|错误信息|{@link java.lang.String}
	 * @param tradeStatus
	 *            出参|返回状态|{@link java.lang.String}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 *         2 未知业务状态<br/>
	 *         3 异常<br/>
	 */
	@InParams(param = {
			@Param(name = "jsonMessage", comment = "json报文字符串", logLevel = "3", type = java.lang.String.class),
			@Param(name = "systemID", comment = "系统标识-对应service下的目录", logLevel = "3", type = java.lang.String.class),
			@Param(name = "mc", comment = "交易服务码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tc", comment = "交易场景码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "isCheckMessage", comment = "是否校验报文字段", defaultParam = "true", type = boolean.class) })
	@OutParams(param = {
			@Param(name = "messageInfo", comment = "拆分后的报文容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "rsponseBodyContext", comment = "响应报文体容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
			@Param(name = "errorCode", comment = "错误码", logLevel = "3", type = java.lang.String.class),
			@Param(name = "errorMessage", comment = "错误信息", logLevel = "3", type = java.lang.String.class),
			@Param(name = "tradeStatus", comment = "返回状态", logLevel = "3", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"), @Return(id = "1", desp = "成功"),
			@Return(id = "2", desp = "未知业务状态"), @Return(id = "3", desp = "异常") })
	@Component(label = "拆解报文-使用IO表", style = "选择型", type = "同步组件", comment = "在cn.com.agree.huanan.ap.rl.bank.gnxcomm.io路径下根据需要通讯的系统,继承一个system里的父类,创建一个service服务类.*组件根据MC,TC找到对应的服务,实现对应的服务", author = "xqq", date = "2019-03-06 05:31:00")
	public static TCResult B_unpackMessage(String jsonMessage, String systemID, String mc, String tc,
			boolean isCheckMessage) {
		ChannelCommImpl channelComm = new ChannelCommImpl();
		JavaDict responseDict = new JavaDict();
		JavaDict responseBodyDict = new JavaDict();
		int tradeRst = EXCEPTION;
		String errCode = "9999";
		String errMessage = "未知异常";
		String errStatus = "2";
		try {
			responseDict = channelComm.getResponse();
			String tradeStatus = channelComm.getTradeStatus();
			logger.debug("交易结果状态:" + tradeStatus.toUpperCase());
			responseBodyDict = channelComm.getResponseBodyDict();
			errCode = channelComm.getErrorCode();
			errMessage = channelComm.getErrorMessage();
			errStatus = tradeStatus;
			switch (tradeStatus.toUpperCase()) {
			case "0":
				tradeRst = SUCCESS;
				break;
			case "1":
				tradeRst = FAILURE;
				break;
			case "2":
				tradeRst = UNKNOWN;
				break;
			default:
				tradeRst = EXCEPTION;
				errCode = "9999";
				errMessage = "错误的交易状态信息";
				errStatus = "3";
				break;
			}
		} catch (Exception e) {
			if (e instanceof ApException) {
				ApException apex = (ApException) e;
				logger.debug("业务异常:" + apex.getErrorMsg());
				tradeRst = FAILURE;
				errCode = apex.getErrorCode();
				errMessage = apex.getErrorMsg();
				errStatus = "2";
			} else {
				logger.debug("拆解RPC响应报文异常:" + e.getMessage());
				tradeRst = EXCEPTION;
				errCode = "9999";
				errMessage = e.getMessage();
				errStatus = "2";
			}
		}
		return new TCResult(tradeRst,
				Arrays.asList(new Object[] { responseDict, responseBodyDict, errCode, errMessage, errStatus }));
	}



}
