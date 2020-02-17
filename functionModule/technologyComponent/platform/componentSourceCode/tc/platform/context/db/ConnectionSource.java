package tc.platform.context.db;

import java.sql.Connection;

import cn.com.agree.afa.jcomponent.DBConnProvider;
import cn.com.agree.afa.svc.javaengine.AppLogger;
import cn.com.agree.afa.util.StringUtils;

/**
 * 获取数据库连接
 * @author bodadmin
 *
 */
public class ConnectionSource {

	public static Connection getConnection(String source) {
		try {
			if (StringUtils.isNullOrEmpty(source)) {
				return DBConnProvider.getConnection();
			} else {
				return DBConnProvider.getConnection(source);
			}
		} catch (Exception e) {
			AppLogger.error("[ERROR]-获取数据库连接失败，" + e);
			return null;
		}
	}
}
