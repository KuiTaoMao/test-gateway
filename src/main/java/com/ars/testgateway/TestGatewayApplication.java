package com.ars.testgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 类名称：TestGatewayApplication
 * @author maokt
 * @since 2019/11/06
 */
@EnableAutoConfiguration
@ComponentScan(basePackages ={"com.ars.testgateway", "com.ars.paas.rosefinch"})
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.ars.testgateway.core.repository")
public class TestGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestGatewayApplication.class, args);
    }

}
