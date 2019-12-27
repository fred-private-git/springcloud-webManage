package com.zkml.official_facade;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by fanghui on 2019/4/16.
 */
@EnableSwagger2Doc
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zkml")
//@EnableRedisHttpSession
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableScheduling
@ComponentScan("com.zkml") //如果jar里面也包含了bean，需要设置下扫描的路径
public class OfficialFacadeApplication {
    public static void main(String[] args) {
        SpringApplication.run(OfficialFacadeApplication.class, args);
    }

}
