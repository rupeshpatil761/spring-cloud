package com.rupesh.microservices.limitsservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rupesh.microservices.limitsservice.bean.LimitsConfig;
import com.rupesh.microservices.limitsservice.config.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

    @Autowired
    LimitsConfiguration configuration;

    @GetMapping("/limits")
    public LimitsConfig getLimitsConfig(){
        return new LimitsConfig(configuration.getMinimum(),configuration.getMaximum());
    }
    
    @GetMapping("/faultToleranceExample")
    @HystrixCommand(fallbackMethod="retrieveDefaultConfig")
    public LimitsConfig retrieveConfig(){
        throw new RuntimeException("Not available");
    }
    
    public LimitsConfig retrieveDefaultConfig(){
        return new LimitsConfig(1,100);
    }

}
