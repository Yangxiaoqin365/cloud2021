package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author yxq
 * @data 2021/7/4 16:48
 */
@SpringBootApplication
public class OrderZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80.class, args);
    }

}
