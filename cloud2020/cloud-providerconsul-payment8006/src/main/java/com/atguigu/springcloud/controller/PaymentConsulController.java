package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author yxq
 * @data 2021/7/4 19:59
 */
@RestController
public class PaymentConsulController {

    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentInfo(){
          return "springcloud with consul: "+serverPort+"\t\t"+ UUID.randomUUID().toString();
    };
}
