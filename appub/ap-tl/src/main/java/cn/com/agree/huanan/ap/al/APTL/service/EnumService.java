package cn.com.agree.huanan.ap.al.APTL.service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.agree.huanan.ap.al.APTL.dao.EnumInfoDao;
import cn.com.agree.huanan.ap.al.APTL.dao.EnumItemDao;
import cn.com.agree.huanan.ap.al.APTL.po.EnumInfo;
import cn.com.agree.huanan.ap.al.APTL.po.EnumItem;

@Component
public class EnumService {
    @Autowired
    EnumInfoDao enumInfoDao;
    @Autowired
    EnumItemDao enumItemDao;

    public void procEnumInfo(String alId, BiConsumer<EnumInfo, List<EnumItem>> consumer) {
        // 查询枚举信息
        List<EnumInfo> enumInfoAllList = enumInfoDao.findByAlId(alId);
        // 查询枚举项
        List<EnumItem> enumItemAllList = enumItemDao.findByAlId(alId);
        // 处理
        for (EnumInfo enumInfo : enumInfoAllList) {
            // 根据enumName筛选
            String enumName = enumInfo.getEnumName();
            List<EnumItem> enumItemList = enumItemAllList.stream()
                .filter(ei -> ei.getEnumName().equals(enumName))
                .collect(Collectors.toList());
            // 传递给消费者处理
            consumer.accept(enumInfo, enumItemList);
        }
    }
}
