package tc.platform.util.json;

import java.util.Map;

import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import ap.ide.techcomp.TechComp;
import ap.ide.utils.JavaDictUtil;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.afa.svc.javaengine.context.JavaDict;
import cn.com.agree.huanan.ap.tl.util.JsonUtil;

/**
 * JSON转换
 * 
 * @date 2018-08-21 13:53:9
 */
@ComponentGroup(level = "平台", groupName = "JSON报文")
public class P_Json {

    /**
     * @category MAP转JSON
     * @param jsonMap 入参|JSON报文MAP|{@link java.util.Map}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
        @Param(name = "jsonMap", comment = "JSON报文MAP", type = java.util.Map.class)
    })
    @OutParams(param = {
        @Param(name = "jsonString", comment = "JSON格式报文", type = java.lang.String.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "MAP转JSON", style = "判断型", type = "同步组件", comment = "MAP转JSON", author = "Administrator", date = "2018-08-22 02:30:05")
    public static TCResult P_MapToJson(Map<String, Object> jsonMap) {
        return TechComp.call(() -> {
            return new Object[] {
                JsonUtil.getUtil().mapToJsonString(jsonMap)
            };
        });
    }
	   /**
     * @category JSON转MAP
     * @param jsonString
     *            入参|JSON格式报文|{@link java.lang.String}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = { @Param(name = "jsonString", comment = "JSON格式报文", type = java.lang.String.class) })
    @OutParams(param = { @Param(name = "jsonMap", comment = "JSON报文MAP", type = java.util.Map.class) })
    @Returns(returns = { @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功") })
    @Component(label = "JSON转MAP", style = "判断型", type = "同步组件", comment = "JSON转MAP", author = "luo.hp", date = "2018-08-21 01:56:46")
    public static TCResult P_JsonToMap(String jsonString) {
        return TechComp.call(()->{
            return new Object[]{JsonUtil.getUtil().jsonStringToMap(jsonString)};
        });
    }
	
    /**
     * @category JavaDict转JSON
     * @param ctx 入参|报文装载容器|
     *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
     * @return 0 失败<br/>
     *         1 成功<br/>
     */
    @InParams(param = {
        @Param(name = "ctx", comment = "报文装载容器", logLevel = "0", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class)
    })
    @OutParams(param = {
        @Param(name = "jsonString", comment = "JSON格式报文", type = java.lang.String.class)
    })
    @Returns(returns = {
            @Return(id = "0", desp = "失败"),
            @Return(id = "1", desp = "成功")
    })
    @Component(label = "JavaDict转JSON", style = "判断型", type = "同步组件", comment = "JavaDict转JSON", author = "Administrator", date = "2018-08-22 02:55:53")
    public static TCResult P_DictToJson(JavaDict ctx) {
        return TechComp.call(() -> {
            return new Object[] {
                    JsonUtil.getUtil().mapToJsonString(JavaDictUtil.dictToMap(ctx, String.class, Object.class))
            };
        });
    }
	
	/**
	 * @category JSON转JavaDict
	 * @param jsonString
	 *            入参|JSON格式报文|{@link java.lang.String}
	 * @param ctx
	 *            入参|报文装载容器|
	 *            {@link cn.com.agree.afa.svc.javaengine.context.JavaDict}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "jsonString", comment = "JSON格式报文", type = java.lang.String.class),
			@Param(name = "ctx", comment = "报文装载容器", logLevel = "0", type = cn.com.agree.afa.svc.javaengine.context.JavaDict.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "JSON转JavaDict", style = "判断型", type = "同步组件", comment = "JSON转JavaDict", author = "luo.hp", date = "2018-08-21 03:21:52")
	public static TCResult P_JsonToDict(String jsonString, JavaDict ctx) {
		return TechComp.call(() -> {
		    ctx.putAll(JavaDictUtil.mapToDict(JsonUtil.getUtil().jsonStringToMap(jsonString)));
			return new Object[]{};
		});
	}
	
	

}
