package com.chinasofti.springcloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chinasofti.springcloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		
		HystrixClientFactory.LOGGER.info("fallback: reason was:{}",cause.getMessage());
		
		return new UserFeignClientWithFactory() {
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				user.setName("黄生测试feign with hystrix");
				return user;
			}
		};
	}

}
