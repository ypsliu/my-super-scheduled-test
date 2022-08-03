package com.gyx.superscheduled.common.utils.proxyTest;

import java.util.List;

public class ChainTest {
    private List<PointTest> list;
    private int index = -1;

    public List<PointTest> getList() {
        return list;
    }

    public void setList(List<PointTest> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    /**
     * 索引自增1
     */
    public int incIndex() {
        return ++index;
    }

    /**
     * 索引还原
     */
    public void resetIndex() {
        this.index = -1;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ChainTest() {
    }

    public ChainTest(List<PointTest> list) {
        this.list = list;
    }
}
