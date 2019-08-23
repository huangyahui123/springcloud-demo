package com.chinasofti.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chinasofti.springcloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod="findByIdFallback")
  public User findById(@PathVariable Long id) {
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return this.restTemplate.getForObject("http://microservice-provider-user/user/simple/" + id, User.class);
  }
  
  //hystrix 断路器的回函,参数和返回值一样
  public User findByIdFallback(Long id){
	  User user = new User();
	  user.setId(0L);
	  user.setName("默认用户啦");
	  return user;
  }

}
