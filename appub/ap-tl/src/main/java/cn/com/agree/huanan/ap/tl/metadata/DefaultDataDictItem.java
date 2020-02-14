package cn.com.agree.huanan.ap.tl.metadata;

import java.util.Objects;
import java.util.Optional;

/**
 * 数据字典项（默认实现）
 * 
 * @author tan.ch
 *
 */
class DefaultDataDictItem implements DataDictItem {
    private final String name;
    private final String cnName;
    private final DataType dataType;
    private final Optional<Class<? extends DataEnum>> dataEnum;
    private final int minLen;
    private final int maxLen;

    /**
     * 构造方法
     * 
     * @param name 名称
     * @param cnName 中文名称
     * @param dataType 数据类型
     * @param minLen 最小长度
     * @param maxLen 最大长度
     * @param dataEnum 数据枚举
     */
    protected DefaultDataDictItem(String name, String cnName, DataType dataType,
            int minLen, int maxLen, Class<? extends DataEnum> dataEnum) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(dataType);
        this.name = name;
        this.cnName = cnName;
        this.dataType = dataType;
        this.dataEnum = Optional.ofNullable(dataEnum);
        this.minLen = minLen;
        this.maxLen = maxLen;
    }

    /**
     * 构造方法（继承定义）
     * 
     * @param name 名称
     * @param cnName 中文名称
     * @param item 数据字典项
     */
    protected DefaultDataDictItem(String name, String cnName, DataDictItem item) {
        this(name, cnName, item.getDataType(), item.getMinLen(), item.getMaxLen(),
                item.getDataEnum().orElse(null));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCnName() {
        return cnName;
    }

    @Override
    public DataType getDataType() {
        return dataType;
    }

    @Override
    public Optional<Class<? extends DataEnum>> getDataEnum() {
        return dataEnum;
    }

    @Override
    public int getMinLen() {
        return minLen;
    }

    @Override
    public int getMaxLen() {
        return maxLen;
    }

    @Override
    public void validate(String input) {
        // 数据类型校验
        dataType.validate(input, minLen, maxLen);
        // 枚举值校验
        dataEnum.ifPresent(e -> DataEnum.get(e, input));
    }
}
