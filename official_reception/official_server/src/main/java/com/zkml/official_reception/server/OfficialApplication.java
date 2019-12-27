package com.zkml.official_reception.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.zkml"})
@MapperScan({"com.zkml.official_reception.**.dao"})
public class OfficialApplication {

	public static void main(String[] args) {

		SpringApplication.run(OfficialApplication.class,args);
	}

}
