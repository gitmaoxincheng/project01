package cn.com.agree.huanan.ap.tl.db.util;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

import cn.com.agree.huanan.ap.tl.db.impl.base.ProcElement;
import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIllegalArgumentException;

/**
 * @author luo.hp
 * @category 存储过程处理工具
 * 
 */
public class ProcUtil {
    
    private ProcUtil() {
    }

    /**
     * @param cstmt CallableStatement对象
     * @param param 存储过程参数
     * @param paramIndex 参数序号
     */
    public static void setInParam(CallableStatement cstmt, ProcElement param, int paramIndex) {
        try{
            switch (param.getParamValueType()){
            case Types.INTEGER:
                cstmt.setInt(paramIndex, (Integer)param.getParamValue());
                break;
            case Types.BIGINT:
                cstmt.setLong(paramIndex, (Long)param.getParamValue());
                break;
            case Types.VARCHAR:
                cstmt.setString(paramIndex, (String)param.getParamValue());
                break;
            case Types.DATE:
                cstmt.setDate(paramIndex, (Date)param.getParamValue());
                break;
            case Types.TIME:
                cstmt.setTime(paramIndex, (Time)param.getParamValue());
                break;
            case Types.TIMESTAMP:
                cstmt.setTimestamp(paramIndex, (Timestamp)param.getParamValue());
                break;
            case Types.CLOB:
                cstmt.setClob(paramIndex, (Clob)param.getParamValue());
                break;
            case Types.BLOB:
                cstmt.setBlob(paramIndex, (Blob)param.getParamValue());
                break;
            default:
                throw new ApValueTypeUnsupportException(param.getParamValue());
            }
        }
        catch (SQLException e) {
            // TODO 自动生成的 catch 块
            throw new ApIllegalArgumentException(e);
        }
    }
}
