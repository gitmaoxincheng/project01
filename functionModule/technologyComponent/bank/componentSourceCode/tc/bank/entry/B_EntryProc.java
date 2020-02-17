package tc.bank.entry;

import ap.ide.message.IdeMessageParser;
import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.rl.bank.base.constant.CommConstant;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * @date 2019-01-24 14:41:58
 */
@ComponentGroup(level = "银行", groupName = "出入口报文处理")
public class B_EntryProc {
	
    /**
     * @category 交易退出
     * @param req 入参|请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param rsp 入参|应答容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param status 入参|状态|{@link java.lang.String}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "status", comment = "状态", type = java.lang.String.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "交易退出", style = "判断型", type = "同步组件", author = "acz", date = "2019-01-24 02:54:12")
    public static TCResult B_tradeExit(JavaDict req, JavaDict rsp, String status) {
        return TechComp.call(() -> {
          EntryProc.entryExit(req, rsp,status);
            return null;
        });
    }

    /**
     * @category 渠道定制P端交易退出
     * @param req 入参|请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param rsp 入参|应答容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param status 入参|状态|{@link java.lang.String}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "status", comment = "状态", type = java.lang.String.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "接入层交易退出", style = "判断型", type = "同步组件", author = "acz", date = "2019-01-24 02:54:12")
    public static TCResult B_tradeExit2(JavaDict req, JavaDict rsp, String status) {
        return TechComp.call(() -> {
            EntryProc.entryExit2(req, rsp,status);
              return null;
          });
    }    
    
    

    /**
     * @category 平台异常退出
     * @param req 入参|请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param rsp 入参|应答容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param status 入参|状态|{@link java.lang.String}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "status", comment = "状态", type = java.lang.String.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "平台异常退出", style = "判断型", type = "同步组件", author = "huangchaopeng", date = "2019-12-05 02:54:12")
    public static TCResult B_tradeExcptExit(JavaDict req, JavaDict rsp, String status) {
        return TechComp.call(() -> { //应该改为原始的AFA实现
        		JavaDict csisHeader = req.getDictItem(CommConstant.CSIS_HEADER);
        		csisHeader.setItem(CommConstant.ERROR_CODE, CommConstant.UNKNOWCODE);
        		csisHeader.setItem(CommConstant.STATUS, CommConstant.UNKNOWSTATUS);
        		csisHeader.setItem(CommConstant.ERROR_MSG, CommConstant.UNKNOWMSG);
        		rsp.setItem(CommConstant.CSIS_HEADER, csisHeader);
        		rsp.setItem(CommConstant.HEADER, req.getDictItem(CommConstant.HEADER));
		        // 拼包
		        try {
		        	Object __SNDPCK__ = IdeMessageParser.pack(rsp, req,false);
		            rsp.put("__SNDPCK__", __SNDPCK__);        
		        } catch (ClassNotFoundException ex) {
		            throw new RuntimeException(ex);
		        }
              return null;
          });
    }
    
    
    /**
     * @category 交易开始
     * @param req 入参|请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param rsp 入参|应答容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "交易开始", style = "判断型", type = "同步组件", author = "acz,hcp", date = "2019-01-24 02:54:12")
    public static TCResult B_tradeStart(JavaDict req, JavaDict rsp) {
        return TechComp.call(() -> {
        	EntryProc.entryInit(req, rsp);
            return null;
            
        });
    }
    
    
    
    
    /**
     * @category 交易开始
     * @param req 入参|请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param rsp 入参|应答容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "接入层交易开始", style = "判断型", type = "同步组件", author = "acz,hcp", date = "2019-01-24 02:54:12")
    public static TCResult B_tradeStart2(JavaDict req, JavaDict rsp) {
        return TechComp.call(() -> {
        	EntryProc.entryInit2(req, rsp);
            return null;
            
        });
    }

    /**
     * @category 初始化Spring并开始交易
     * @param req 入参|请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param rsp 入参|应答容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "req", comment = "请求容器", defaultParam = "__REQ__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "rsp", comment = "应答容器", defaultParam = "__RSP__", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "初始化Spring并开始交易", style = "判断型", type = "同步组件", author = "hcp", date = "2019-01-24 02:54:12")
    public static TCResult B_InitSpringAndTradeStart(JavaDict req, JavaDict rsp) {
    	
        String msg = String.format("进入交易统一入口：%s.%s", req.getStringItem("__MC__", ""), req.getStringItem("__TC__", ""));
        AppLogger.info(msg);
//    	AppLogger.info("初始化类加载器");
        // 初始化类加载器
        Thread.currentThread().setContextClassLoader(B_EntryProc.class.getClassLoader());
        loadSpring(); //初始化Spring
//        AppLogger.info("打印REQ");
//        AppLogger.info(req);
//		String __RCVPCK__ = new String((byte[]) req.get("__RCVPCK__"));
//		AppLogger.info("打印json请求报文string:" + __RCVPCK__);
        return TechComp.call(() -> {
        	EntryProc.entryInit(req, rsp);
            return null;
            
        });
    }    
    
    static void loadSpring() {
        AppLogger.info("init spring...");
        SpringUtil.initContext();
        AppLogger.info("init spring done");
    }
  
    
}
