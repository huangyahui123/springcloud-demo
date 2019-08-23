package com.chinasofti.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.springcloud.entity.User;
import com.chinasofti.springcloud.entity.UserMessage;
import com.chinasofti.springcloud.repository.UserRepository;
import com.chinasofti.springcloud.service.UserMessageService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	
  public static ObjectMapper objectMapper = new ObjectMapper();
	
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private UserMessageService userMessageService;
  

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable String id) {
    return this.userRepository.findOne(Integer.valueOf(id));
    
  }
  
  @PostMapping("/postUser")
  public User postUser(@RequestBody User user){
	  return user;
 }
  
  @GetMapping("/getList")
  public List<UserMessage> getList(){
	  return userMessageService.getList();
  }
  
  @GetMapping("/getStr")
  public String getStr(){
	  return "goodmorning huang yahui";
  }
  
  @GetMapping("/deleteUserById")
  public int deleteUserById(@RequestParam String id){
	  return userMessageService.deleteUserById(id);
  }
  
}
