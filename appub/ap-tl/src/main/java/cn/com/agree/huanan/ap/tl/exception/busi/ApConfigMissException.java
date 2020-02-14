package cn.com.agree.huanan.ap.tl.exception.busi;

import cn.com.agree.huanan.ap.tl.exception.ApException;

/**
 * @author bodadmin
 * 配置文件缺少
 */
public class ApConfigMissException extends ApException {
    private static final long serialVersionUID = -1;

    public ApConfigMissException(String configName, String key) {
        super(new Object[] {
                configName,
                key
        });
    }
}
