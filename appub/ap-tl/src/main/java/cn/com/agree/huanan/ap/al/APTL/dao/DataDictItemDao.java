package cn.com.agree.huanan.ap.al.APTL.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;

/**
 * 数据字典项dao
 * 
 * @author tan.ch
 *
 */
@Component
public class DataDictItemDao {
    @Autowired
    private OrmOperator ormOper;

    /**
     * 根据alId查询
     * 
     * @param alId alId
     * @return 数据字典项列表
     */
    public List<DataDictItem> findByAlId(String alId) {
        // 查询
        List<DataDictItem> dataDictItemList = ormOper.getOrmSelecter(DataDictItem.class)
            .where(w -> {
                w.setAlId(alId);
            })
            .orderBy(o -> {
                o.getAlId();
                o.getTypeName();
                o.getItemName();
            })
            .fetchAll();
        // 返回
        return dataDictItemList;
    }
}
