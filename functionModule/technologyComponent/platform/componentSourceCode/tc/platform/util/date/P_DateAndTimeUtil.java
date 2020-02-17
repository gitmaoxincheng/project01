package tc.platform.util.date;

import galaxy.ide.tech.cpt.Component;
import galaxy.ide.tech.cpt.ComponentGroup;
import galaxy.ide.tech.cpt.InParams;
import galaxy.ide.tech.cpt.OutParams;
import galaxy.ide.tech.cpt.Param;
import galaxy.ide.tech.cpt.Return;
import galaxy.ide.tech.cpt.Returns;
import ap.ide.techcomp.TechComp;
import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.util.DateTimeUtil;


/**
 * Jun
 * 
 * @date 2019-03-13 18:57:56
 */
@ComponentGroup(level = "平台", groupName = "日期时间")
public class P_DateAndTimeUtil {

	/**
	 * @category 获取指定日期
	 * @param fmt
	 *            入参|日期格式|{@link java.lang.String}
	 * @param days
	 *            入参|天数|int
	 * @param date
	 *            出参|日期|{@link java.lang.String}
	 * @return 0 失败<br/>
	 *         1 成功<br/>
	 */
	@InParams(param = {
			@Param(name = "fmt", comment = "日期格式", type = java.lang.String.class),
			@Param(name = "days", comment = "天数", type = int.class) })
	@OutParams(param = { @Param(name = "date", comment = "日期", type = java.lang.String.class) })
	@Returns(returns = { @Return(id = "0", desp = "失败"),
			@Return(id = "1", desp = "成功") })
	@Component(label = "获取指定日期", style = "判断型", type = "同步组件", author = "JUN", date = "2019-03-13 07:30:19")
	public static TCResult P_GetSpecifiedDate(String fmt, int days) {
		return TechComp.call(() -> {
			String format = fmt;
			if(format==null||format.equals("")){
				format = "yyyyMMdd";
			}
			String date = DateTimeUtil.getSysDateTime(format, days);
			return new Object[] {
					date
			};
		});
	}

}
