package com.chinasofti.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.springcloud.UserFeignClient;
import com.chinasofti.springcloud.entity.User;

@RestController
public class MovieController {

  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
	  return userFeignClient.findById(id);
  }
  
  @GetMapping("/test")
  public User test( User user) {
	  return userFeignClient.postUser(user);
  }

}
