package cn.com.agree.huanan.ap.rl.bank.base.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author acz
 * 字典类
 */
@Getter
@Setter
@ToString
public class DictBean {
    private String eName; //分类
    private String keyName;
    private String keyValue;
    private String remark;
}
