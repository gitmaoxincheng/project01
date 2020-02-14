package cn.com.agree.huanan.ap.al.APTL.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.po.EnumInfo;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;

/**
 * 枚举信息dao
 * 
 * @author tan.ch
 *
 */
@Component
public class EnumInfoDao {
    @Autowired
    OrmOperator ormOper;

    /**
     * 根据alId查询
     * 
     * @param alId alId
     * @return 枚举信息列表
     */
    public List<EnumInfo> findByAlId(String alId) {
        // 查询
        List<EnumInfo> enumInfoList = ormOper.getOrmSelecter(EnumInfo.class).where(w -> {
            w.setAlId(alId);
        }).orderBy(o -> {
            o.getAlId();
            o.getEnumName();
        }).fetchAll();
        // 返回
        return enumInfoList;
    }
}
