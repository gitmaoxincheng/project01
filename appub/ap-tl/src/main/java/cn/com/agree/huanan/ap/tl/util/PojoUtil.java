package cn.com.agree.huanan.ap.tl.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;

/**
 * pojo工具
 * 
 * @author tan.ch
 *
 */
public class PojoUtil {
    /**
     * pojo字段信息
     * 
     * @author tan.ch
     *
     */
    public static class PojoFieldInfo {
        /** 字段名称 */
        public final String fieldName;
        /** 字段类型 */
        public final Class<?> fieldType;
        /** get方法 */
        public final Method getMethod;
        /** set方法 */
        public final Method setMethod;

        /**
         * 构造方法
         * 
         * @param fieldName 字段名称
         * @param fieldType 字段类型
         * @param getMethod get方法
         * @param setMethod set方法
         */
        public PojoFieldInfo(String fieldName, Class<?> fieldType, Method getMethod,
                Method setMethod) {
            this.fieldName = fieldName;
            this.fieldType = fieldType;
            this.getMethod = getMethod;
            this.setMethod = setMethod;
        }
    }

    /**
     * 获取pojo字段信息
     * 
     * @param type 类型
     * @return 字段信息
     */
    public static Map<String, PojoFieldInfo> getPojoFieldInfo(Class<?> type) {
        // 字段信息
        Map<String, PojoFieldInfo> fieldInfoMap = new LinkedHashMap<String, PojoFieldInfo>();
        // 扫描方法
        // public String getXy();
        // public void setXy(String xy);
        for (Method getMethod : type.getMethods()) {
            // 获取getter名称：getXy -> Xy
            String name = getGetterName(getMethod);
            if (name != null) {
                // 字段类型
                Class<?> fieldType = getMethod.getReturnType();
                // 获取setter
                Method setMethod;
                try {
                    setMethod = type.getMethod("set" + name, fieldType);
                } catch (NoSuchMethodException | SecurityException ex) {
                    // 无对应setter，跳过
                    continue;
                }
                // 检查属性
                if (!checkMethodProp(setMethod)) {
                    continue;
                }
                // 保存
                String fieldName = StrUtil.firstCharToLowerCase(name);
                PojoFieldInfo pfi = new PojoFieldInfo(fieldName, getMethod.getReturnType(),
                        getMethod, setMethod);
                fieldInfoMap.put(fieldName, pfi);
            }
        }
        // 返回
        return fieldInfoMap;
    }

    /**
     * 创建实例
     * 
     * @param type 类型
     * @return 实例
     */
    public static <T> T createInstance(Class<T> type) {
        try {
            return type.newInstance();
        } catch (ReflectiveOperationException ex) {
            throw ExceptionUtil.convert(ex);
        }
    }

    private static boolean checkMethodProp(Method method) {
        // 跳过Object
        if (method.getDeclaringClass() == Object.class) {
            return false;
        }
        // 跳过static
        int mod = method.getModifiers();
        if (Modifier.isStatic(mod)) {
            return false;
        }
        // 通过
        return true;
    }

    private static String getGetterName(Method method) {
        // 检查属性
        if (!checkMethodProp(method)) {
            return null;
        }
        // 参数个数
        if (method.getParameterCount() != 0) {
            return null;
        }
        // 检查名字：getXy...
        String methodName = method.getName();
        if (methodName.startsWith("get") && methodName.length() >= 5) {
            // 检查参数
            char c = methodName.charAt(3);
            if (c >= 'A' && c <= 'Z') {
                // getXy -> Xy
                return methodName.substring(3);
            }
        }
        // 不通过
        return null;
    }
}
