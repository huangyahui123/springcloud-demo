package com.chinasofti.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.springcloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	
	  @RequestMapping(value="/user/simple/{id}",method=RequestMethod.GET)
	//@GetMapping("/user/simple/{id}")
	public User findById(@PathVariable("id") Long id); //Feign两个坑   1.@GetMapping不支持  2.@PathVariable得设置value
	  
	  
	  @RequestMapping(value = "/user/postUser" , method=RequestMethod.POST)
	  public User postUser(@RequestBody User user);

}



