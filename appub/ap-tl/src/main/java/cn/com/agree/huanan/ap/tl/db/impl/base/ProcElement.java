package cn.com.agree.huanan.ap.tl.db.impl.base;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

import cn.com.agree.huanan.ap.tl.exception.busi.ApValueTypeUnsupportException;
import cn.com.agree.huanan.ap.tl.db.impl.base.ProcParamTypeEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


/**
 * 存储过程参数
 * 
 * @author luo.hp
 *
 */
@Getter
@Setter
public class ProcElement {
    // 参数类型
    @Setter(AccessLevel.PROTECTED) ProcParamTypeEnum  paramType;
    
    // 参数名称
    String paramName;
    
    // 参数值
    Object paramValue;
    
    // 值类型
    int paramValueType;
    
    private void setParamValueType(Class<?> cls){
        if (Integer.class.isAssignableFrom(cls)){
            paramValueType = Types.INTEGER;
        }
        else if (Long.class.isAssignableFrom(cls)){
            paramValueType = Types.BIGINT;
        }
        else if (String.class.isAssignableFrom(cls)){
            paramValueType = Types.VARCHAR;
        }
        else if (Date.class.isAssignableFrom(cls)){
            paramValueType = Types.DATE;
        }
        else if (Time.class.isAssignableFrom(cls)){
            paramValueType = Types.TIME;
        }
        else if (Timestamp.class.isAssignableFrom(cls)){
            paramValueType = Types.TIMESTAMP;
        }
        else if (Clob.class.isAssignableFrom(cls)){
            paramValueType = Types.CLOB;
        }
        else if (Blob.class.isAssignableFrom(cls)){
            paramValueType = Types.BLOB;
        }
        else{
            throw new ApValueTypeUnsupportException(cls.getName());
        }
    }
    /**
     * @param paramName 参数名称
     * @param cls 参数值类型
     */
    public ProcElement(String paramName, Class<?> cls){
        this.paramType = ProcParamTypeEnum.OUT_PARAM;
        this.paramName = paramName;
        setParamValueType(cls);
    }
    /**
     * @param paramType 参数类型
     * @param paramName 参数名称
     * @param paramValue 参数值
     */
    public ProcElement(ProcParamTypeEnum  paramType, String paramName, Object paramValue){
        this.paramType = paramType;
        this.paramName = paramName;
        this.paramValue = paramValue;
        setParamValueType(paramValue.getClass());
    }
}
