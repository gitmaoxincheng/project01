package cn.com.agree.huanan.ap.rl.aptl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.rl.aptl.po.AptlExceptMapperInfo;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;

@Component
public class AptlExceptMapperInfoDao {
    @Autowired
    DbOperator dbOper;

    public AptlExceptMapperInfo findById(String exceptionId) {
        // 查询
//    	System.out.println("查询:" + exceptionId);
        Map<String, Object> ret = dbOper.getSelecter()
            .select("exceptionId", "errorCode", "errorMsg")
            .from("Aptl_Except_MapperInfo")
            .where(w -> w.eq("exceptionId", exceptionId))
            .fetchOne()
            ;
        // 记录不存在
        if (ret.isEmpty()) {
            return null;
        }
        // ORM
        AptlExceptMapperInfo po = new AptlExceptMapperInfo();
        po.setExceptionId(exceptionId);
        po.setErrorCode((String)ret.get("errorCode"));
        po.setErrorMsg((String)ret.get("errorMsg"));
        return po;
    }

    public AptlExceptMapperInfo findException(String exceptionId,int index) {
        // 查询
//    	System.out.println("查询:" + exceptionId);
        Map<String, Object> ret = dbOper.getSelecter()
                .select("exceptionId","seriNo", "errorCode", "errorMsg")
                .from("Aptl_Except_MapperInfo")
                .where(w -> w.eq("exceptionId", exceptionId))
                .where(w -> w.eq("seriNo", index))
                .fetchOne()
                ;
        // 记录不存在
        if (ret.isEmpty()) {
            return null;
        }
        // ORM
        AptlExceptMapperInfo po = new AptlExceptMapperInfo();
        po.setExceptionId(exceptionId);
        po.setSeriNo(index);
        po.setErrorCode((String)ret.get("errorCode"));
        po.setErrorMsg((String)ret.get("errorMsg"));
        return po;
    }


}
