package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yxq
 * @data 2021/7/4 23:34
 */
public interface LoadBalancer {

    ServiceInstance instance (List<ServiceInstance> serviceInstances);
}
