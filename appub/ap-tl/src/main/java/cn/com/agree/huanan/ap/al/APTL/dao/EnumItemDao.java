package cn.com.agree.huanan.ap.al.APTL.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.po.EnumItem;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;

/**
 * 枚举项dao
 * 
 * @author tan.ch
 *
 */
@Component
public class EnumItemDao {
    @Autowired
    private OrmOperator ormOper;

    /**
     * 根据alId查询
     * 
     * @param alId alId
     * @return 枚举项列表
     */
    public List<EnumItem> findByAlId(String alId) {
        // 查询
        List<EnumItem> enumItemList = ormOper.getOrmSelecter(EnumItem.class)
                .where(w -> {
                    w.setAlId(alId);
                })
                .orderBy(o -> {
                    o.getAlId();
                    o.getEnumName();
                    o.getItemNo();
                })
                .fetchAll();
        return enumItemList;
    }
}
