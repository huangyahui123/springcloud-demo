package com.chinasofti.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaServer
//@ComponentScan
public class EurekaApplication {
	
  public static void main(String[] args) {
	  
	  SpringApplication.run(EurekaApplication.class, args);
  }

}