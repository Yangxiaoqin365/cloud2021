package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author yxq
 * @data 2021/6/27 16:46
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("客户端插入数据");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    //返回对象为响应体中数据转化成的对象，基本上可以理解为Json
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("客户端查询数据");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }
    //返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity =restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else {
            return new CommonResult(444,"操作失败");
        }
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> postPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment,CommonResult.class);
        //return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment,CommonResult.class).getBody();
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB()
    {
        //获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance =loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb" , String.class);
    }
}
