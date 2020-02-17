package tc.platform.util.db;

import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;

public class SqlUtils {
	 private static final String SQL_PARAM_PLACEHOLDER = "?";
	 
	    private static final String PROCEDURE_PREFIX = "{call %s(";
	    
	    private static final String PROCEDURE_POSTFIX = ")}";
	    
	    private SqlUtils() {
	    }
	    
	    public interface SqlExp {
	    }
	    
	    public static SqlExp getSqlExp(String sqlExp) {
	        return new SqlExp() {
	            @Override
	            public String toString() {
	                return sqlExp;
	            }
	        };
	    }

	    public static String formatValue(Object value) {
	        // String
	        if (value instanceof String) {
	            // a'b -> a''b
	            String strValue = ((String) value).replaceAll("'", "''");
	            // ab -> 'ab'
	            return String.format("'%s'", strValue);
	        }
	        // int/long
	        else if (value instanceof Integer || value instanceof Long) {
	            return value.toString();
	        }
	        // SqlExp
	        else if (value instanceof SqlExp) {
	            return value.toString();
	        }
	        // unknown
	        else {
	            throw new ApValueTypeUnsupportException(value);
	        }
	    }
	    
	    public static String formatValue(Object value, List<Object> sqlParams) {
	        if ((sqlParams == null) || (value instanceof SqlExp)) {
	            return formatValue(value);
	        } else {
	            sqlParams.add(value);
	            return SQL_PARAM_PLACEHOLDER;
	        }
	    }

	    public static String formatSql(String sql, List<Object> sqlParams) {
	        // 无参数
	        if (sqlParams == null || sqlParams.isEmpty()) {
	            return sql;
	        }
	        // 替换占位符：? -> %s
	        sql = sql.replaceAll("\\?", "%s");
	        // 替换参数
	        String[] args = new String[sqlParams.size()];
	        for (int i = 0; i < sqlParams.size(); i++) {
	            args[i] = formatValue(sqlParams.get(i));
	        }
	        // 格式化
	        sql = String.format(sql, (Object[]) args);
	        //
	        return sql;
	    }
	    
	    public static String formatProcedure(String procName, List<?> procParams) {
	        StringJoiner joiner = new StringJoiner(" ");
	        joiner.add(String.format(PROCEDURE_PREFIX, procName));
	        // 无参数
	        if (procParams != null) {
	            joiner.add(String.join(",", procParams.stream().map(w->(SQL_PARAM_PLACEHOLDER)).collect(Collectors.toList())));
	        }
	        joiner.add(PROCEDURE_POSTFIX);
	        return joiner.toString();
	        
	    }
	    
	    /**
	     * 正则表达式修改sql
	     * @param sql
	     * @param regularString
	     * @return
	     */
		public static String sqlRegular(String sql,String regularString) {
			Matcher matcher = Pattern.compile(regularString).matcher(sql);
			while(matcher.find()) {
				String find = matcher.group();
				sql = sql.replace(find, "?");
				System.out.println(find);
			}
			System.out.println(sql);
			return sql;
		}

		
}
