package cn.com.agree.huanan.ap.rl.aptl.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AptlExceptMapperInfo {
    private String exceptionId;
    private int seriNo;
    private String errorCode;
    private String errorMsg;
}
