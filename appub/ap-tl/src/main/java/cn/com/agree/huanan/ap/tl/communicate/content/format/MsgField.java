package cn.com.agree.huanan.ap.tl.communicate.content.format;

import lombok.Getter;

/**
 * @author xqq
 *
 */
@Getter
public class MsgField {
    /**
     * @param msgFieldType 字段类型
     * @param itemKey 字段key
     * @param itemLenth 字段长度
     * @param digits 小数位数
     * @param isRequired 是否必输
     * @param cName 中文名
     */
	public MsgField(String msgFieldType, String itemKey, int itemLenth,
			int digits, boolean isRequired, String cName) {
		super();
		MsgFieldType = msgFieldType;
		this.itemKey = itemKey;
		this.itemLenth = itemLenth;
		this.digits = digits;
		this.isRequired = isRequired;
		this.cName = cName;
	}

	String MsgFieldType;
	String itemKey;
	int itemLenth;
	int digits;
	boolean isRequired;
	String cName;
}
