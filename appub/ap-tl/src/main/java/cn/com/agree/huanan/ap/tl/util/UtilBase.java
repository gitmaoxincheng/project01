package cn.com.agree.huanan.ap.tl.util;

import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * @author luo.hp
 * @param <T> 类模板
 * @category 工具类基类
 *
 */
public class UtilBase<T> {
    private T util;
    
    protected UtilBase(Class<T> type){
        util = SpringUtil.getBean(type);
    }
    
    protected T thisUtil(){
        return util;
    }
}
