package com.gyx.superscheduled.common.utils.proxyTest;

import com.gyx.superscheduled.model.ScheduledRunningContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;

/**
 * @author haizliu
 * @date 03/08/2022 15:46
 */
public class LogBaseStrengthenIm implements BaseStrengthenTest {

    private String name;

    public LogBaseStrengthenIm(String name)
    {
        this.name=name;
    }

    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    public void before(Object bean, Method method, Object[] args, ScheduledRunningContext context) {
        PointTest point = (PointTest) bean;
        logger.info(name+ ":定时任务" + point.getSuperScheduledName() + "开始执行");
    }

    @Override
    public void after(Object bean, Method method, Object[] args, ScheduledRunningContext context) {

        PointTest point = (PointTest) bean;
        logger.info(name+":定时任务" + point.getSuperScheduledName() + "执行结束");

    }

    @Override
    public void exception(Object bean, Method method, Object[] args, ScheduledRunningContext context) {

    }

    @Override
    public void afterFinally(Object bean, Method method, Object[] args, ScheduledRunningContext context) {

    }
}
