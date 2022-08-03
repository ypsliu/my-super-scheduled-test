package com.gyx.superscheduled.common.utils.proxyTest;

public abstract class PointTest {
    /**
     * 定时任务名
     */
    private String superScheduledName;



    /**
     * 执行顺序
     */
    private Integer order;

    /**
     * 内部执行顺序
     */


    /**
     * 抽象的执行方法，使用代理实现
     *
     * @param runnable 定时任务执行器
     */
    public abstract Object invoke(SuperScheduledRunnableTest runnable);

    public String getSuperScheduledName() {
        return superScheduledName;
    }

    public void setSuperScheduledName(String superScheduledName) {
        this.superScheduledName = superScheduledName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}