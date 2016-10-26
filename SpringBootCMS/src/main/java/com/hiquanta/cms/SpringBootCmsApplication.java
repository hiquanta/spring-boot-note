package com.hiquanta.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// 开启缓存请把下行取消注释
//@EnableCaching
public class SpringBootCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCmsApplication.class, args);
	}
}
