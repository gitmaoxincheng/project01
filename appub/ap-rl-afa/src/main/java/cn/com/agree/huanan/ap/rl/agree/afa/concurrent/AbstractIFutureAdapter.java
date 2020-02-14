package cn.com.agree.huanan.ap.rl.agree.afa.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import cn.com.agree.afa.util.future.IFuture;
import cn.com.agree.afa.util.future.IFutureListener;

public abstract class AbstractIFutureAdapter implements IFuture {

    @Override
    public boolean isDone() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isCancelled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        throw new UnsupportedOperationException();
    }

//    @Override
//    public Object get() throws InterruptedException, ExecutionException {
//        // TODO Auto-generated method stub
//        return null;
//    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IFuture removeListener(IFutureListener arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSuccess() {
        // 统一返回成功，由应用层处理结果
        return true;
    }

    @Override
    public Object getProperty(String arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getNow() {
        // 获取结果
        try {
            return get();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Throwable cause() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean awaitUninterruptibly(long arg0, TimeUnit arg1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IFuture awaitUninterruptibly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean await(long arg0, TimeUnit arg1) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IFuture await() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addProperty(String arg0, Object arg1) {
        throw new UnsupportedOperationException();
    }
    
//    @Override
//    public IFuture addListener(IFutureListener var1) {
//        // TODO Auto-generated method stub
//        return null;
//    }
}
