/**
 * FileName: ContextUtil
 * Author:   Ren Xiaotian
 * Date:     2018/8/15 10:51
 */

package cn.com.agree.huanan.ap.tl.util;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 配置工具类
 */
public class ContextUtil {

//	private Logger logger = Logger.getLogger(ContextUtil.class);
	
    /**
     * map容器，存放配置信息
     */
    private static ConcurrentMap<String, Object> JavaDict = new ConcurrentHashMap<>();

    /**
     * 容器中设置值，如果key为空，则抛异常；如果key已有，则覆盖
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, String value) {
        try {
            JavaDict.put(key, value);
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * 根据键获取值
     *
     * @param key 指定键
     * @return 返回获取的值
     */
    public static Object get(String key) {
        try {
            return JavaDict.get(key);
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * 获取容器中所有键
     *
     * @return 返回容器中的所有键，set容器
     */
    public static Set<String> keys() {
        return JavaDict.keySet();
    }

    /**
     * 容器中设置值，如果key为空，则抛异常；如果key已有，则跳过
     *
     * @param key   键
     * @param value 值
     * @return 返回设置结果
     */
    public static String[] setnx(String key, String value) {

        Set<String> allKeys = JavaDict.keySet();
        if (allKeys.contains(key) == true) { // 如果当前键存在，则直接返回
            return new String[]{"false", "该键已存在"};
        } else {
            set(key, value);
            return new String[]{"true", "键-值设置成功"};
        }
    }

    /**
     * 批量将键值对加入JavaDict中
     *
     * @param map 要加入的键值对
     */
    public static void set(Map<String, String> map) {
        try {
            JavaDict.putAll(map);
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * 不覆盖设置多个kv,多个kv同时设置，只要有一个setnx失败，则失败
     *
     * @param map 待加入的键值对
     * @return String[0]为0，说明批量插入成功；String[0]为1，说明待加入的键在原集合中已存在
     */
    public static String[] setnx(Map<String, String> map) {
        Set<String> insert = map.keySet(); // 待插入的所有键
        Set<String> existingKeySey = JavaDict.keySet();

        if (beMixed(insert, existingKeySey)) { // 如果有交集，则直接返回
            return new String[]{"1", "待加入的键在原集合中已存在"};
        } else { // 如果两者没交集，则插入
            set(map); // 批量将键值对插入JavaDict
            return new String[]{"0", "kv集合设置成功"};
        }
    }

    /**
     * 判断两个set集合是否有交集
     *
     * @param set1 集合1
     * @param set2 集合2
     * @return 如果有交集，返回true；没交集返回false
     */
    private static boolean beMixed(Set<String> set1, Set<String> set2) {
        if (set1 == null) {
            return false;
        }
        if (set2 == null) {
            return false;
        }

        Set<String> tmp = new TreeSet<String>(); // 保存两个集合的交集

        tmp.clear();
        tmp.addAll(set1);
        tmp.retainAll(set2);
        if (tmp.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 往指定键的内容追加内容
     *
     * @param key   指定键
     * @param value 要追加的内容
     */
    public static void append(String key, String value) {
        StringBuffer oldValue = new StringBuffer((String) get(key));

        set(key, oldValue.append(value).toString());
    }

    /**
     * 得到指定键对应的值的长度
     *
     * @param key 指定键
     * @return 返回键对应的值的长度
     */
    public static int strlen(String key) {

        return ((String) JavaDict.get(key)).length();
    }

    /**
     * 删除指定键
     *
     * @param key 指定键
     * @return 返回删除结果，删除成功，String[0]为0；否则抛异常
     */
    public static String[] del(String key) {
        try {
            JavaDict.remove(key);
            return new String[]{"0", "删除指定键成功"};
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }
}
