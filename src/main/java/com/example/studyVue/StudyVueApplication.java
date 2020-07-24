package com.example.studyVue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.studyVue.web.dao")
@EntityScan("com.example.studyVue.web.entity")
public class StudyVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyVueApplication.class, args);
	}

}
