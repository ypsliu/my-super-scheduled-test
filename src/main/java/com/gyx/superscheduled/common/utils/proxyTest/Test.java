package com.gyx.superscheduled.common.utils.proxyTest;

import com.gyx.superscheduled.common.utils.proxy.ProxyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haizliu
 * @date 03/08/2022 15:38
 */
public class Test {

    public static void main(String[] args) {

        SuperScheduledRunnableTest scheduledRunnableTest =new SuperScheduledRunnableTest();

        List<PointTest> points = new ArrayList<>(2);

        BaseStrengthenTest  one= new LogBaseStrengthenIm("YPSLIU");
        BaseStrengthenTest   two = new LogBaseStrengthenIm("admin");

        PointTest oneproxy = ProxyUtils.getInstance(PointTest.class, new RunnableBaseInterceptorTest(one, scheduledRunnableTest));
        oneproxy.setSuperScheduledName("one");
        PointTest twoproxy = ProxyUtils.getInstance(PointTest.class, new RunnableBaseInterceptorTest(two, scheduledRunnableTest));
        twoproxy.setSuperScheduledName("two");

        points.add(oneproxy);
        points.add(twoproxy);

        scheduledRunnableTest.setChain(new ChainTest(points));


       System.out.println(scheduledRunnableTest.invoke());









    }
}
