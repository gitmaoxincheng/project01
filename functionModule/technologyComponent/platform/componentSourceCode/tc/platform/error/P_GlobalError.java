package tc.platform.error;

import ap.ide.error.GlobalError;
import ap.ide.techcomp.TechComp;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;

/**
 * 全局错误
 * 
 * @date 2018-09-10 9:12:16
 */
@ComponentGroup(level = "平台", groupName = "全局错误")
public class P_GlobalError {

    /**
     * @category 设置全局错误
     * @param errorCtx 入参|全局错误容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @param errorTypeKey 入参|错误类型关键字|{@link java.lang.String}
     * @param errorCodeKey 入参|错误代码关键字|{@link java.lang.String}
     * @param errorMsgKey 入参|错误信息关键字|{@link java.lang.String}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
            @Param(name = "errorCtx", comment = "全局错误容器", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class),
            @Param(name = "errorTypeKey", comment = "错误类型关键字", type = java.lang.String.class),
            @Param(name = "errorCodeKey", comment = "错误代码关键字", type = java.lang.String.class),
            @Param(name = "errorMsgKey", comment = "错误信息关键字", type = java.lang.String.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "设置全局错误", style = "判断型", type = "同步组件", comment = "设置全局错误", author = "Administrator", date = "2018-09-10 09:16:14")
    public static TCResult P_PutGlobalError(JavaDict errorCtx, String errorTypeKey,
            String errorCodeKey, String errorMsgKey) {
        return TechComp.call(() -> {
            GlobalError.getGlobalError().putGlobalErrorToDict(errorCtx, errorTypeKey, errorCodeKey, errorMsgKey);
            return new Object[] {};
        });
    }
}
