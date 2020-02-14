package cn.com.agree.huanan.ap.tl.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.function.Consumer;

import org.reflections.Reflections;

import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;

/**
 * 反射工具
 * 
 * @author tan.ch
 *
 */
public class ReflectionUtil {
    private ReflectionUtil() {
    }

    /**
     * 扫描子类型列表
     * 
     * @param packageName 包名
     * @param type 类型
     * @param consumer 处理器
     */
    public static <T> void scanSubTypeList(String packageName, Class<T> type,
            Consumer<Class<? extends T>> consumer) {
        Reflections reflections = new Reflections(packageName);
        reflections.getSubTypesOf(type).stream().filter(tabType -> {
            // 排除接口及抽象类
                return !Modifier.isAbstract(tabType.getModifiers()) && !tabType.isInterface();
            }).forEach(consumer);
    }

    /**
     * 创建新实例
     * 
     * @param type 类型
     * @return 实例
     */
    public static <T> T newInstance(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw ExceptionUtil.convert(ex);
        }
    }

    public static <T> T getProxy(Class<T> type, InvocationHandler handler) {
        @SuppressWarnings("unchecked")
        T proxy = (T) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class<?>[] {
            type
        }, handler);
        return proxy;
    }
}
