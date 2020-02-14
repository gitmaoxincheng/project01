package cn.com.agree.huanan.ap.al.csitrd.base.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.agree.huanan.ap.al.csitrd.base.dao.DrowBoardDao;
import cn.com.agree.huanan.ap.al.csitrd.base.po.Drowboard;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.busi.ApIllegalParamException;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Service
public class DrowboardService {
	@Autowired DbOperator dbOperator;
	@Autowired DrowBoardDao drowBoardDao;
	private Logger logger = Logger.getLogger(DrowboardService.class);
	public Map<String,Object> findDrowBoard(String strtellerno,String begdate,String enddate,Integer pageflag,Integer maxnum) {
		if(pageflag < 1) {
			logger.error("页码不能小于1");
			throw new ApIllegalParamException("页码"+pageflag+"输入有误");
		}
		if (maxnum < 1) {
			logger.error("每页查询记录数不可小于1");
			throw new ApIllegalParamException("查询记录数"+maxnum+"不正确");	
		}
		Map<String,Object> result = drowBoardDao.findDrowBoard(strtellerno, begdate, enddate, pageflag, maxnum);
		if(result==null) {
			throw new ApIllegalParamException("查不到对应记录");
		}
		return result;
	}
	public int weihuDrowBoard(String optflag,Drowboard drowboard) {
		int count = 0;
		if(optflag != null || !optflag.equals("")) {
			if(optflag.equals("0") ) {
				if(drowboard.getImagepath().equals(""))
					throw new ApIllegalParamException("imagepath不能为空");
				count = drowBoardDao.insertDrowBoard(drowboard);
			}else if(optflag.equals("1") ) {
				if(drowboard.getImagepath().equals(""))
					throw new ApIllegalParamException("imagepath不能为空");
				count = drowBoardDao.delDrowBoard(drowboard.getImagepath());
			}else {
				logger.error("请输入正确的操作类型0-保存、1-删除");
				throw new ApIllegalParamException("请输入正确的操作类型0-保存、1-删除");
			}
		}else {
			logger.error("操作类型不能为空");
			throw new ApIllegalParamException("操作类型不能为空");
		}
		return count;
	}
}
