package com.auguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author yxq
 * @data 2021/7/4 11:24
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value= "/payment/zk")
    public String paymetZk(){
        return "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    };

}
