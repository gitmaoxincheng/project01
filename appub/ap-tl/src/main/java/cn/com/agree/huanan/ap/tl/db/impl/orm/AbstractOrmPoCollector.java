package cn.com.agree.huanan.ap.tl.db.impl.orm;

import java.lang.reflect.Method;

import cn.com.agree.huanan.ap.tl.util.StrUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

abstract class AbstractOrmPoCollector<T> implements MethodInterceptor {
    /** 类型 */
    private final Class<T> type;
    /** 代理 */
    private T proxy;

    public AbstractOrmPoCollector(Class<T> type) {
        this.type = type;
    }

    /**
     * 获取代理对象
     * 
     * @return 代理对象
     */
    @SuppressWarnings("unchecked")
    public T getProxy() {
        if (proxy == null) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(type);
            enhancer.setCallback(this);
            this.proxy = (T) enhancer.create();
        }
        return proxy;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {
        // public String getXy();
        // public void setXy(Sring xy);
        String methodName = method.getName();
        if (methodName.startsWith("get") && args.length == 0) {
            // getXy -> xy
            String fieldName = StrUtil.firstCharToLowerCase(methodName.substring(3));
            // 调用子类处理
            procGetterCall(method.getReturnType(), fieldName);
        } else if (methodName.startsWith("set") && args.length == 1) {
            // setXy -> xy
            String fieldName = StrUtil.firstCharToLowerCase(methodName.substring(3));
            // 调用子类处理
            procSetterCall(method.getParameterTypes()[0], fieldName, args[0]);
        } else {
            throw new IllegalAccessException(methodName);
        }
        return null;
    }
    
    protected void procGetterCall(Class<?> fieldType, String fieldName) throws Throwable {
        throw new IllegalAccessException(fieldName);
    }
    
    protected void procSetterCall(Class<?> fieldType, String fieldName, Object fieldValue) throws Throwable {
        throw new IllegalAccessException(fieldName);
    }
}
