package tc.platform.base;

import ap.ide.exception.InvalidInputParamException;
import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaList;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;

/**
 * 日志操作类组件
 * 
 * @date 2018-09-11 10:11:9
 */
@ComponentGroup(level = "平台", groupName = "日志操作类组件")
public class P_Logger {
    private static Logger logger = Logger.getLogger(P_Logger.class);

    /**
     * @category 信息日志
     * @param strOrList 入参|日志信息 string javalist|{@link Object}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
        @Param(name = "strOrList", comment = "日志信息 string|javadict|javalist", type = Object.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "信息日志", style = "判断型", type = "同步组件", author = "2n5ght", date = "2018-09-11 10:18:39")
    public static TCResult P_info(Object strOrList) {
        return TechComp.call(() -> {
            if(strOrList==null){
                throw new InvalidInputParamException();
            }
            
            if(strOrList instanceof JavaList){
                JavaList list = (JavaList)strOrList;
                for (Object object : list) {
                    logger.info(String.valueOf(object));
                }
            }else if (strOrList.getClass().isArray()) {
            	logger.info(new String((byte[])strOrList,"UTF-8"));	
			}else{
                logger.info(String.valueOf(strOrList));
            }
            
            return null;
        });
        
    }
    
}
