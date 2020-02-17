package tc.platform.message;

import ap.ide.message.IdeMessageParser;
import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 平台报文
 * 
 * @date 2018-08-21 16:39:40
 */
@ComponentGroup(level = "平台", groupName = "平台报文")
public class P_Message {

    /**
     * @category 接收报文拆包
     * @param msgCtx 入参|拆包结果容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param bDebug 入参|是否Debug容器信息|boolean
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "msgCtx", comment = "拆包结果容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "debug", comment = "是否打印容器信息", logLevel = "3", type = boolean.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "接收报文拆包", style = "判断型", type = "同步组件", comment = "接收报文拆包", author = "luo.hp", date = "2018-08-29 03:12:30")
    public static TCResult P_MessageUnpack(JavaDict msgCtx, boolean bDebug) {
        return TechComp.call(() -> {
            IdeMessageParser.unpack(msgCtx, bDebug);
            return new Object[]{};
        });
    }

    /**
     * @category 发送报文拼包
     * @param msgCtx 入参|拼包报文容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param origCtx 入参|原请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param bDebug 入参|是否Debug容器信息|boolean
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "msgCtx", comment = "拼包报文容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "origCtx", comment = "原请求容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "debug", comment = "是否Debug容器信息", logLevel = "3", type = boolean.class)
    })
    @OutParams(param = {
        @Param(name = "rspObj", comment = "拼包结果", logLevel = "0", type = Object.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "发送报文拼包", style = "判断型", type = "同步组件", comment = "发送报文拼包", author = "luo.hp", date = "2018-08-29 03:14:28")
    public static TCResult P_MessagePack(JavaDict msgCtx, JavaDict origCtx, boolean bDebug) {
        return TechComp.call(() -> {
            return new Object[] {
                IdeMessageParser.pack(msgCtx, origCtx, bDebug)
            };
        });
    }

    
    
    /**
     * @category 初始化Spring并拆包
     * @param msgCtx 入参|拆包结果容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param bDebug 入参|是否Debug容器信息|boolean
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "msgCtx", comment = "拆包结果容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "debug", comment = "是否打印容器信息", logLevel = "3", type = boolean.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "初始化Spring并拆包", style = "判断型", type = "同步组件", comment = "初始化Spring并拆包", author = "hcp", date = "2019-06-29 03:12:30")
    public static TCResult P_InitSpringAndUnpack(JavaDict req, boolean bDebug) {
        String msg = String.format("进入交易统一入口：%s.%s", req.getStringItem("__MC__", ""), req.getStringItem("__TC__", ""));
        AppLogger.info(msg);
//    	AppLogger.info("初始化类加载器");
        // 初始化类加载器
        Thread.currentThread().setContextClassLoader(P_Message.class.getClassLoader());  
        loadSpring();
        return TechComp.call(() -> {
            IdeMessageParser.unpack(req, bDebug);
            return new Object[]{};
        });
    }

    
    /**
     * @category 初始化Spring并拆包2
     * @param msgCtx 入参|拆包结果容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param bDebug 入参|是否Debug容器信息|boolean
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "msgCtx", comment = "拆包结果容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "debug", comment = "是否打印容器信息", logLevel = "3", type = boolean.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "初始化Spring并拆包2", style = "判断型", type = "同步组件", comment = "初始化Spring并拆包，用于透传拆包", author = "hcp", date = "2019-06-29 03:12:30")
    public static TCResult P_InitSpringAndUnpack2(JavaDict req, boolean bDebug) {
        String msg = String.format("进入交易统一入口：%s.%s", req.getStringItem("__MC__", ""), req.getStringItem("__TC__", ""));
        AppLogger.info(msg);
//    	AppLogger.info("初始化类加载器");
        // 初始化类加载器
        Thread.currentThread().setContextClassLoader(P_Message.class.getClassLoader());  
        loadSpring();
        return TechComp.call(() -> {
            IdeMessageParser.unpack2(req, bDebug);
            return new Object[]{};
        });
    }    

    /**
     * @category 拼包并发送报文
     * @param msgCtx 入参|拼包报文容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param origCtx 入参|原请求容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param bDebug 入参|是否Debug容器信息|boolean
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "msgCtx", comment = "拼包报文容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "origCtx", comment = "原请求容器", logLevel = "3", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "debug", comment = "是否Debug容器信息", logLevel = "3", type = boolean.class)
    })
    @OutParams(param = {
        @Param(name = "rspObj", comment = "拼包结果", logLevel = "0", type = Object.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "拼包并发送报文", style = "判断型", type = "同步组件", comment = "拼包并发送报文", author = "luo.hp", date = "2018-08-29 03:14:28")
    public static TCResult P_packAndSendMsg(JavaDict rsp, JavaDict req, boolean bDebug) {
    	
        return TechComp.call(() -> {
            // 拼包
            try {
            	Object __SNDPCK__ = IdeMessageParser.pack(rsp, req, bDebug);
                rsp.put("__SNDPCK__", __SNDPCK__);        
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        	return null;
        });

        
    }

    static void loadSpring() {
        AppLogger.info("init spring...");
        SpringUtil.initContext();
        AppLogger.info("init spring done");
    }    
}
