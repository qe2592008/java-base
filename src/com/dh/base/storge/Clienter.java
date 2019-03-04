package com.dh.base.storge;

import java.util.Date;

/**
 * 测试类
 */
public class Clienter {
    public static void main(String[] args) throws InterruptedException {
        Target target = new Target("huahua", new Date());
        System.out.println("保存之前的数据：name="+target.getName() + ",date="+ target.getDate());
        Storge storge = new Storge(target.store());
        Thread.sleep(1000L);
        target.setName("caocao");
        target.setDate(new Date());
        System.out.println("修改之后的数据：name="+target.getName() + ",date="+ target.getDate());
        target.back(storge.getLinshi());
        System.out.println("恢复之后的数据：name="+target.getName() + ",date="+ target.getDate());
    }
}
