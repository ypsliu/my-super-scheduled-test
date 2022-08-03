package com.gyx.superscheduled.common.utils.proxyTest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SuperScheduledRunnableTest {
    protected final Log logger = LogFactory.getLog(getClass());

    /**
     * 增强器的调用链
     */
    private ChainTest chain;

    private int getSize()
    {
        return chain.getList().size();
    }

    public Object invoke() {
        Object result = null;

            //索引自增1
            if (chain.incIndex() == chain.getList().size()) {
                //调用链中的增强方法已经全部执行结束
                    //调用链索引初始化
                    chain.resetIndex();
                    //执行原本的方法
                    result =getSize();
            } else {
                //获取被代理后的方法增强
                PointTest point = chain.getList().get(chain.getIndex());
                //执行增强方法
                result = point.invoke(this);
            }

        return result;
    }


    public ChainTest getChain() {
        return chain;
    }

    public void setChain(ChainTest chain) {
        this.chain = chain;
    }


}
