package cn.com.agree.huanan.ap.tl.communicate.content.build;

import cn.com.agree.huanan.ap.tl.communicate.comm.exception.validator.VaildateFailureException;
import cn.com.agree.huanan.ap.tl.communicate.content.format.FieldNode;

/**
 * @author xqq hcp
 * 标准输入检查方法
 */
public class StandardFieldCheck {

    private static String INT_REX = "^\\d+";//整型正则
    private static String DECIMAL_REX = "\\d+(\\.?\\d+)?";
    private static String AMOUNT_REX = "((-|\\+)?[0-9]\\d*\\.?\\d*)";
/*    private ValidatorConstant constant = new ValidatorConstant();

    public StandardFieldCheck(ValidatorConstant constant) {
        this.constant = constant;
    }*/

    //	@Override
    public static boolean check(String fieldValue, FieldNode toCheckNode) {

        String nodeName = toCheckNode.getNodeName();
        String fieldName = toCheckNode.getMesField().getItemKey();
        int fieldLength = toCheckNode.getMesField().getItemLenth();
        int digScale = toCheckNode.getMesField().getDigits();

        switch (toCheckNode.getMesField().getMsgFieldType()) {
            case "string":
/*					try {
						String checkByte = new String(fieldValue.getBytes(constant.getEncoding()));
						if(checkByte.length() > fieldLength){
							throw new VaildateFailureException(new String[]{fieldName,"字符类型字段超长,映射Key:"+nodeName+"编码:"+constant.getEncoding()});
						}
					} catch (UnsupportedEncodingException e) {
						throw new ApUnsupportedEncodingException(e);
					}*/
                if (fieldValue.length() > fieldLength) {
                    throw new VaildateFailureException(new String[]{nodeName, "字符类型字段超长,映射Key:" + fieldName});
                }
                break;
            case "int":
                if (fieldValue.length() > fieldLength) {
                    throw new VaildateFailureException(new String[]{nodeName, "数值类型字段超长,映射Key:" + fieldName});
                }
                if (!fieldValue.matches(INT_REX))
                    throw new VaildateFailureException(new String[]{nodeName, "数值类型字段格式错误,映射Key:" + fieldName});
                break;
            case "decimals":
                if (!fieldValue.matches(DECIMAL_REX))
                    throw new VaildateFailureException(new String[]{nodeName, "浮点类型字段格式错误,映射Key:" + fieldName});
                int index = fieldValue.indexOf(".");
                if (index > 0) {
                    if (index > fieldLength) {
                        throw new VaildateFailureException(new String[]{nodeName, "浮点类型字段整数位超长,映射Key:" + fieldName});
                    }
                    if ((fieldValue.length() - index - 1) > digScale) {
                        throw new VaildateFailureException(new String[]{nodeName, "浮点类型字段小数位超长,映射Key:" + fieldName});
                    }
                } else {
                    if (fieldValue.length() > fieldLength) {
                        throw new VaildateFailureException(new String[]{nodeName, "浮点类型字段超长,映射Key:" + fieldName});
                    }
                }
                break;
            case "amount":
                if (fieldValue.length() > fieldLength) {
                    throw new VaildateFailureException(new String[]{nodeName, "金额类型字段超长,映射Key:" + fieldName});
                }
                if (!fieldValue.matches(AMOUNT_REX))
                    throw new VaildateFailureException(new String[]{nodeName, "浮点类型字段格式错误,映射Key:" + fieldName});
                break;
            case "encipher": //加密类型
                break;
            default:
                break;
        }

        return true;
    }

}
