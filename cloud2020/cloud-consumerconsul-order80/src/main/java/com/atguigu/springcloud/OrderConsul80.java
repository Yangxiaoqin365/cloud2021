package com.atguigu.springcloud;

import org.bouncycastle.pqc.math.linearalgebra.GF2nPolynomial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yxq
 * @data 2021/7/4 20:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul80.class, args);
    }
}
