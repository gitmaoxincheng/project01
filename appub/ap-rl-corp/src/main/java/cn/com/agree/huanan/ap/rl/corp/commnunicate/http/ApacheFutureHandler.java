package cn.com.agree.huanan.ap.rl.corp.commnunicate.http;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.impl.client.HttpRequestFutureTask;

import cn.com.agree.huanan.ap.tl.communicate.comm.context.CommContext;
import cn.com.agree.huanan.ap.tl.communicate.http.future.FurtherHandler;
import cn.com.agree.huanan.ap.tl.exception.tech.ApSystemException;

/**
 * @author luo.hp
 *
 */
public class ApacheFutureHandler implements FurtherHandler{
    
    HttpRequestFutureTask<CommContext> task;
    
    /**
     * @param task Http请求FurtureTask对象
     */
    public ApacheFutureHandler(HttpRequestFutureTask<CommContext> task) {
        // TODO 自动生成的构造函数存根
        this.task = task;
    } 
    
    /**
     * @return 通信结果
     */
    public CommContext get(){
        try {
            return task.get();
        } catch (InterruptedException | ExecutionException exception) {
            // TODO 自动生成的 catch 块
            throw new ApSystemException(exception);
        }
    }
    
    /**
     * @param timeout 超时时间
     * @param unit 时间单元
     * @return 通信结果
     */
    public CommContext get(long timeout, TimeUnit unit){
        try {
            return task.get(timeout, unit);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // TODO 自动生成的 catch 块
            throw new ApSystemException(e);
        }
    }
    
    /**
     * @param mayInterruptIfRunning 中断
     * @return 执行是否成功
     */
    public boolean cancel(boolean mayInterruptIfRunning){
        return task.cancel(mayInterruptIfRunning);
    }
    
}
