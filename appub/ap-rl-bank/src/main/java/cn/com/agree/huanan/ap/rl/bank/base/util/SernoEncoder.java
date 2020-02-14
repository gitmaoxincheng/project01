package cn.com.agree.huanan.ap.rl.bank.base.util;

/**
 * 流水号编码器
 * 
 * @author 谭楚杭
 *
 */
public class SernoEncoder {
    private final char[] charList;
    private final int sernoLen;
    private int counter = 0;

    public SernoEncoder(String letters, int sernoLen) {
        this.charList = letters.toCharArray();
        this.sernoLen = sernoLen;
    }

/*    public String getNext() {
        // 累加计数
        counter++;
        // 重置
        if (counter < 1) {
            counter = 1;
        }
        // 编码
        return SernoUtil.encodeInt(charList, sernoLen, counter);
    }*/
    
    public static SernoEncoder get62Encoder(int sernoLen) {
        String letters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return new SernoEncoder(letters, sernoLen);
    }
    
    public static SernoEncoder get36Encoder(int sernoLen) {
        String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return new SernoEncoder(letters, sernoLen);
    }
}
