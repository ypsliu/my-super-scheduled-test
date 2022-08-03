package com.gyx.superscheduled.common.utils.proxyTest;

import com.gyx.superscheduled.exception.SuperScheduledException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class RunnableBaseInterceptorTest implements MethodInterceptor {
    protected final Log logger = LogFactory.getLog(getClass());
    /**
     * 定时任务执行器
     */
    private SuperScheduledRunnableTest runnable;
    /**
     * 定时任务增强类
     */
    private BaseStrengthenTest strengthen;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result;
        List<String> methodName = Arrays.asList("invoke", "before", "after", "exception", "afterFinally");
        if (methodName.contains(method.getName())) {
            strengthen.before(obj, method, args, null);
            try {
                result = runnable.invoke();
            } catch (Exception e) {
                strengthen.exception(obj, method, args, null);
                throw new SuperScheduledException(strengthen.getClass() + "中强化执行时发生错误", e);
            } finally {
                strengthen.afterFinally(obj, method, args, null);
            }
            strengthen.after(obj, method, args, null);
        } else {
            result = methodProxy.invokeSuper(obj, args);
        }
        return result;
    }

    public RunnableBaseInterceptorTest(Object object, SuperScheduledRunnableTest runnable) {
        this.runnable = runnable;
        if (BaseStrengthenTest.class.isAssignableFrom(object.getClass())) {
            this.strengthen = (BaseStrengthenTest) object;
        } else {
            throw new SuperScheduledException(object.getClass() + "对象不是BaseStrengthen类型");
        }
    }

    public RunnableBaseInterceptorTest() {

    }
}
