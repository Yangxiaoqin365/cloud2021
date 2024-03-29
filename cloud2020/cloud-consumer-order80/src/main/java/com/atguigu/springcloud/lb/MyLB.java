package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yxq
 * @data 2021/7/4 23:35
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger();

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current =this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("*****第几次访问next:" +next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index =getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
