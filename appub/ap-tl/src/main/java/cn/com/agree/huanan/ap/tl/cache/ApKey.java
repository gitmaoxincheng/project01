package cn.com.agree.huanan.ap.tl.cache;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public class ApKey {
    private final Object targetKey;
    private final WeakReference<Callable<?>> valueLoader;

    public ApKey(Object targetKey, Callable<?> valueLoader) {
        this.targetKey = targetKey;
        this.valueLoader = new WeakReference<>(valueLoader);
    }
    
    public Object getTargetKey() {
        return this.targetKey;
    }

    public Object invoke() throws Exception {
        return valueLoader.get().call();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ApKey) {
            return this.targetKey.equals(((ApKey) other).targetKey);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.targetKey.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", getClass().getSimpleName(), this.targetKey);
    }
}
