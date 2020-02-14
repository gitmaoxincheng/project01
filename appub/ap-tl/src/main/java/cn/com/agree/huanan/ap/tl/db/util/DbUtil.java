package cn.com.agree.huanan.ap.tl.db.util;

import cn.com.agree.huanan.ap.tl.db.impl.orm.annotation.Table;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.exception.tech.ApIOException;
import cn.com.agree.huanan.ap.tl.util.PojoUtil;
import cn.com.agree.huanan.ap.tl.util.PojoUtil.PojoFieldInfo;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;
import javax.sql.rowset.serial.SerialClob;

/**
 * @author hcp
 * @category 数据库工具类
 */
public class DbUtil {


    /**
     * 用于转换从数据库查询得出的数据为key:value的 Map格式
     *
     * @param selectList 查询数据列
     * @param rowSet     元数据
     * @return 返回数据列表
     */
    public static List<Map<String, Object>> transferDbMaps(List<String> selectList, List<List<Object>> rowSet) {
        if (rowSet.isEmpty()) {
            return Collections.emptyList();
        }
        List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>(rowSet.size());
        for (List<Object> row : rowSet) {
            Map<String, Object> dataMap = new LinkedHashMap<String, Object>(row.size());
            for (int i = 0; i < selectList.size(); i++) {
                String key = selectList.get(i);
                int n = key.lastIndexOf(' ');
                if (n >= 0) {
                    key = key.substring(n + 1);
                }
                Object value = row.get(i);
                dataMap.put(key, value);
            }
            dataMapList.add(dataMap);
        }
        return dataMapList;
    }


    /**
     * 将查询返回的数据封装为 Bean
     *
     * @param poType 类队形
     * @param rowSet 行记录
     * @param <T>    泛型入参，为需要封装的Do类
     * @return 封装后的对象列表
     */
    public static <T> List<T> transferDbPos(Class<T> poType, List<Map<String, Object>> rowSet) {
        if (rowSet.isEmpty()) {
            return Collections.emptyList();
        }
        // 获取表名
        Table tabAnnotation = poType.getAnnotation(Table.class);

        Class<?> tabObj = tabAnnotation.value();
        String tabName = tabObj.getSimpleName().toLowerCase();
        // 获取字段信息
        Map<String, PojoFieldInfo> poFieldInfo = PojoUtil.getPojoFieldInfo(poType);
        // 转换为po
        List<T> poList = new ArrayList<T>(rowSet.size());
        for (Map<String, Object> row : rowSet) {
            // 创建po
            T poInstance = PojoUtil.createInstance(poType);
            // 转换
            row.entrySet().stream().forEach(entry -> {
                PojoFieldInfo info = poFieldInfo.get(entry.getKey());
                Object value = entry.getValue();
                // 处理Number
                if (value instanceof Number) {
                    Number num = (Number) value;
                    if (info.fieldType == int.class) {
                        value = num.intValue();
                    } else if (info.fieldType == long.class) {
                        value = num.longValue();
                    }
                }
                // 调用setter
                try {
                    info.setMethod.invoke(poInstance, value);
                } catch (ReflectiveOperationException ex) {
                    throw ExceptionUtil.convert(ex);
                }
            });
            // 保存
            poList.add(poInstance);
        }
        //
        return poList;

    }

    /**
     * @param blob blob类型
     * @return byte[] 字节数组
     * @throws SQLException sql异常
     */
    public static byte[] blobToByte(Blob blob) throws SQLException, IOException {
        BufferedInputStream bis = null;
        byte[] bytes = null;
        try {
            bis = new BufferedInputStream(blob.getBinaryStream());
            bytes = new byte[(int) blob.length()];
            int len = bytes.length;
            int offset = 0;
            int readByte = 0;
            while (offset < len && (readByte = (bis.read(bytes, offset, len - offset))) >= 0) {
                offset += readByte;
            }
            return bytes;//返回字节数组
        } finally {
            try {
                bis.close();//关闭缓冲流，
            } catch (IOException e) {
                e.printStackTrace();
                throw new ApIOException(e);
            }
        }

    }
    /**
     * @param clob clob类型
     * @return 字符串
     * @throws SQLException sql异常
     */
    public static String clobToString(Clob clob) throws SQLException {
        return clob != null ? clob.getSubString(1, (int) clob.length()) : null;
    }

    /**
     * @param str 字符串
     * @return Clob 类型
     */
    public static Clob stringToClob(String str) throws SQLException {
        return str != null ? new SerialClob(str.toCharArray()) : null; //字符串转clob异常
    }


}
