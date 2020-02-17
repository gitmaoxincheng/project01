package ap.ide.techcomp;

import java.util.Arrays;
import java.util.Objects;

import cn.com.agree.afa.svc.javaengine.TCResult;
import cn.com.agree.huanan.ap.tl.db.std.operator.DbOperator;
import cn.com.agree.huanan.ap.tl.exception.ApException;
import cn.com.agree.huanan.ap.tl.exception.ExceptionUtil;
import cn.com.agree.huanan.ap.tl.logging.Logger;
import cn.com.agree.huanan.ap.tl.spring.SpringUtil;

/**
 * 技术组件
 * 
 * @author tan.ch
 *
 */
public class TechComp {
    /** 日志 */
    private static final Logger logger = Logger.getLogger(TechComp.class);
    private static DbOperator dbo = SpringUtil.getBean(DbOperator.class);


    /**
     * 调用
     * 
     * @param tcRunner 执行代码
     * @return 技术组件结果
     */
    public static TCResult call(TechCompRunner.TcRunner tcRunner) {
        try {
            // run
            Object[] ret = tcRunner.run();
            dbo.commit();
            // return
            return TCResult.newSuccessResult(ret);
        } catch (Exception ex) {
            return procFail(ex);
        }
    }
    
    /**
     * 调用
     * 
     * @param tcRunner 执行代码
     * @return 技术组件结果
     */
    public static TCResult call(boolean returnIncludeCase,TechCompRunner.TcRunner tcRunner) {
        try {
            // run
            Object[] ret = tcRunner.run();
            
            // 返回不含分支
            if (!returnIncludeCase) {
                dbo.commit();
                return TCResult.newSuccessResult(ret);
            }

            // 不含分支，继续分离出参
            // {1, "outA", "outB"}
            Objects.requireNonNull(ret);
            // 第一个元素为分支
            int caseIndex = (int) ret[0];
            // 其他为出参
            if (ret.length > 1) {
                // 截取
                ret = Arrays.copyOfRange(ret, 1, ret.length);
            } else {
                // 空
                ret = new Object[] {};
            }
            // return
            dbo.commit();
            return new TCResult(caseIndex, Arrays.asList(ret));
        } catch (Exception ex) {
            return procFail(ex);
        }
    }


    /**
     * 调用（自动获取bean）
     * 
     * @param returnIncludeCase 返回包含分支
     * @param beanType bean类型
     * @param tcRunner 执行代码
     * @return 技术组件结果
     */
    public static <T> TCResult callWithBean(boolean returnIncludeCase, Class<T> beanType,
            TechCompRunner.TcBeanRunner<T> tcRunner) {
        try {
            // get bean
            T bean = SpringUtil.getBean(beanType);

            // run
            Object[] ret = tcRunner.run(bean);

            // 返回不含分支
            if (!returnIncludeCase) {
                dbo.commit();
                return TCResult.newSuccessResult(ret);
            }

            // 不含分支，继续分离出参
            // {1, "outA", "outB"}
            Objects.requireNonNull(ret);
            // 第一个元素为分支
            int caseIndex = (int) ret[0];
            // 其他为出参
            if (ret.length > 1) {
                // 截取
                ret = Arrays.copyOfRange(ret, 1, ret.length);
            } else {
                // 空
                ret = new Object[] {};
            }
            // 返回
            return new TCResult(caseIndex, Arrays.asList(ret));
        } catch (Exception ex) {
            return procFail(ex);
        }
    }

    /**
     * 调用（自动获取bean）
     * 
     * @param beanType bean类型
     * @param tcRunner 执行代码
     * @return 技术组件结果
     */
    public static <T> TCResult callWithBean(Class<T> beanType,
            TechCompRunner.TcBeanRunner<T> tcRunner) {
        return callWithBean(false, beanType, tcRunner);
    }

    private static TCResult procFail(Exception ex) {
        //
        logger.exception(ex);
        //
        dbo.rollback();
        ApException apEx = null;
        try {
            apEx = ExceptionUtil.convert(ex);
        } catch (Throwable ex2) {
            ex.addSuppressed(ex2);
            throw new RuntimeException(ex);
        }
        //
        return TCResult.newFailureResult(apEx.getErrorCode(), apEx.getErrorMsg());
    }
}
