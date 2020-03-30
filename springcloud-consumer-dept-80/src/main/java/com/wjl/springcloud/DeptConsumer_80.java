package com.wjl.springcloud;

import com.wjl.myrule.MyConfigRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候自动加载自定义负载均衡策略
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyConfigRule.class)
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
