package cn.com.agree.huanan.ap.al.APTL.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.po.DataDictType;
import cn.com.agree.huanan.ap.tl.db.orm.OrmOperator;

/**
 * 数据字典类型dao
 * 
 * @author tan.ch
 *
 */
@Component
public class DataDictTypeDao {
    @Autowired
    private OrmOperator ormOper;

    /**
     * 根据alId查询
     * 
     * @param alId alId
     * @return 数据字典类型列表
     */
    public List<DataDictType> findByAlId(String alId) {
        // 查询
        List<DataDictType> dataDictItemList = ormOper.getOrmSelecter(DataDictType.class)
            .where(w -> {
                w.setAlId(alId);
            })
            .orderBy(o -> {
                o.getAlId();
                o.getTypeName();
            })
            .fetchAll();
        // 返回
        return dataDictItemList;
    }
}
