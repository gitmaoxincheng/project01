package cn.com.agree.huanan.ap.rl.agree.afa.comm;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cn.com.agree.afa.jcomponent.ShortSocketClient;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.SocketAdapter;
import cn.com.agree.huanan.ap.tl.communicate.comm.adapter.impl.SocketAdapterImpl;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommFlowUtil;
import cn.com.agree.huanan.ap.tl.communicate.comm.base.CommResult;
import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.comm.params.CommParam;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueOutOfRangeException;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import cn.com.agree.huanan.ap.tl.util.FlowUtil.StatusCtrl;

@Component
@Primary
public class AfaSocketAdapter implements SocketAdapter {
	@Autowired
	private Logger logger;

	@Override
	public CommContext comm(CommParam param, byte[] msg, Map<String, Object> additionParam) {
		return SpringUtil.getBean(SocketAdapterImpl.class).comm(param, msg);
	}

	@Override
	public CommContext comm(CommParam param, String msg, Map<String, Object> additionParam) {
		return SpringUtil.getBean(SocketAdapterImpl.class).comm(param, msg);
	}

	@Override
	public CompletableFuture<Supplier<CommResult<byte[]>>> commAsync(CommParam param, String msg,
			Map<String, Object> additionParam) {
		logger.debug("运行：AfaSocketAdapter.commAsync");

		// 执行异步通讯流程
		return CommFlowUtil.runCommAsyncFlow((ctrl) -> {
			return commAsync0(param, msg, additionParam, ctrl);
		});
	}

	private CompletableFuture<Supplier<CommResult<byte[]>>> commAsync0(CommParam param, String msg, Map<String, Object> additionParam, StatusCtrl ctrl) {

		logger.debug("运行：AfaSocketAdapter.commAsync0");

		// String -> byte[]
		byte[] data;
		try {
			data = msg.getBytes(param.getEncoding());
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex);
		}

		// 标记异常
		ctrl.setAbend();

		// 异步通讯
		TCResult tcRet = AfaCommUtil.callCommAsyncAPI("ShortSocketClient.asynRequest", () -> {
			return ShortSocketClient.asynRequest(param.getIdentifier(), 
					param.getServerIp(), 
					param.getServerPort(), 
					data, 
					param.getSockTimeOut());
		});

		// 处理异步结果
		return AfaCommUtil.procAsyncCommResult(tcRet, List.class,param,(rspList) -> {
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
			return msgBody;
		});
	}

}
