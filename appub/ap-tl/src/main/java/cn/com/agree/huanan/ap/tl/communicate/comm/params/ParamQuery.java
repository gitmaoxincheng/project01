package cn.com.agree.huanan.ap.tl.communicate.comm.params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

/**
 * @author luo.hp
 *
 */
@Component
public class ParamQuery{
	/**
	 * 参数查询器
	 */
	
	@Autowired
	DbOperator dbOper;
	
	/**
	 * @return DB操作对象
	 */
	public DbOperator getQueryOper(){
	    return dbOper;
	}

}
