package cn.com.agree.huanan.ap.al.APTL.service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.dao.DataDictItemDao;
import cn.com.agree.huanan.ap.al.APTL.dao.DataDictTypeDao;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictItem;
import cn.com.agree.huanan.ap.al.APTL.po.DataDictType;
import cn.com.agree.huanan.ap.tl.logging.Logger;

@Component
public class DataDictService {
    @Autowired
    private DataDictTypeDao dataDictTypeDao;
    @Autowired
    private DataDictItemDao dataDictItemDao;
    
    public void procDataDictType(String alId, BiConsumer<DataDictType, List<DataDictItem>> consumer) {
        // 查询数据字典类型
        List<DataDictType> ddtList = dataDictTypeDao.findByAlId(alId);
        // 查询数据字典项
        List<DataDictItem> ddiList = dataDictItemDao.findByAlId(alId);
        // 处理
        for (DataDictType ddt : ddtList) {
            // 传递给消费者处理
            List<DataDictItem> ddiGroup = ddiList.stream()
                    .filter(e -> e.getTypeName().equals(ddt.getTypeName()))
                    .collect(Collectors.toList());
            consumer.accept(ddt, ddiGroup);
        }
    }
}
