package com.chinasofti.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chinasofti.springcloud.entity.User;
import com.chinasofti.springcloud.entity.UserMessage;

@RestController
public class MovieController {
	
  @Autowired
  private RestTemplate restTemplate;

  @Value("${user.userServicePath}")
  private String userServicePath;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
	  
    //return this.restTemplate.getForObject("http://localhost:7900/user/simple/" + id, User.class);
	  System.out.println("========================");
	  System.out.println(userServicePath);
	return this.restTemplate.getForObject(userServicePath + id, User.class);
  }
  
  
  @GetMapping("/getList")
  public List<UserMessage> getList(){
	  System.out.println("=========");
	  return (List<UserMessage>) this.restTemplate.getForObject("http://localhost:7900/user/getList", UserMessage.class);
	  
  }
  
  @GetMapping("/getStr")
  public String getStr(){
	  return this.restTemplate.getForObject("http://localhost:7900/user/getStr", String.class);
  }
  
  
}
