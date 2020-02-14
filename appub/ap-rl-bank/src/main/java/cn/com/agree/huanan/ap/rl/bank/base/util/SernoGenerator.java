package cn.com.agree.huanan.ap.rl.bank.base.util;

import java.util.HashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.util.SernoUtil;
import cn.com.agree.huanan.ap.tl.util.StrUtil;

/**
 * 流水号生成器
 * @author tanchuhang1
 *
 */
public class SernoGenerator {
    /** 序列名 */
    private final String seqName;
    /** 后缀长度 */
    private final int suffixLen;
    /** 后缀最大值 */
    private final int suffixMax;
    /** 后缀列表 */
    private final String[] suffixList;
    
    /**
     * 流水号长度
     * 
     * @author tanchuhang1
     *
     */
    private static class SernoInfo {
        /** 前缀 */
        public long prefixInt;
        /** 后缀 */
        public int suffixInt;
        
        public SernoInfo() {
            this.prefixInt = -1;
            this.suffixInt = -1;
        }
    }
    
    /** 流水号信息映射，长度：流水号信息*/
    private Map<Integer, SernoInfo> sernoInfoMap = new HashMap<Integer, SernoInfo>();
    
    
    public SernoGenerator(String seqName, int suffixLen) {
        // 保存
        this.seqName = seqName;
        this.suffixLen = suffixLen;
        // 后缀最大值：(10 ^ 2) - 1 = 100 - 1 = 99
        suffixMax = (int)Math.pow(10, suffixLen) - 1;
        // 生成后缀列表：{ 00, 01, 02, ..., 99 }
        suffixList = new String[suffixMax + 1];
        for (int i = 0; i <= suffixMax; i++) {
            suffixList[i] = StrUtil.zfill(i, suffixLen);
        }
    }
    
    public String getSerno(String poolName, int seqLen) {
        // 获取流水号：{ 前缀, 后缀 }
        Object[] item = getSernoInternal(poolName, seqLen);
        
        // 前缀
        String s0 = (String)item[0];
        // 后缀
        String s1 = suffixList[(Integer)item[1]];
        
        // 返回结果
        return s0 + s1;
    }
    
    private synchronized Object[] getSernoInternal(String poolName, int seqLen) {
        // 获取长度对应的流水信息
        SernoInfo sernoInfo = sernoInfoMap.get(seqLen);
        if (sernoInfo == null) {
            // 生成流水信息
            sernoInfo = new SernoInfo();
            // 保存
            sernoInfoMap.put(seqLen, sernoInfo);
        }
        // 累加后缀
        sernoInfo.suffixInt++;
        // 超过最大值
        if (sernoInfo.suffixInt > suffixMax) {
            // 重置前缀
            sernoInfo.prefixInt = -1;
            // 重置后缀
            sernoInfo.suffixInt = 0;
        }
        
        String prefixStr;
        // 前缀未初始化
        if (sernoInfo.prefixInt < 0) {
            // 从DB获取流水号
            prefixStr = SernoUtil.getSerno(poolName,seqName, seqLen - suffixLen);
            // 转换为整形
            sernoInfo.prefixInt = Long.parseLong(prefixStr);
        }
        // 前缀已初始化
        else {
            prefixStr = StrUtil.zfill(sernoInfo.prefixInt, seqLen - suffixLen);
        }
        
        // 前缀 & 后缀都为0
        if (sernoInfo.prefixInt == 0 && sernoInfo.suffixInt == 0) {
            // 累加后缀
            sernoInfo.suffixInt++;
        }
        
        // 返回
        return new Object[] {prefixStr, sernoInfo.suffixInt};
    }
    

   
}
