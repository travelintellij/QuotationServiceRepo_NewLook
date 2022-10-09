package com.travelintellij.quotation.quotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaAuditing
//@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
//@EnableJpaRepositories(basePackages = {"com.travelintellij.quotation.entity"})
//@EnableConfigurationProperties
//@ComponentScan
//@ComponentScan(basePackages="com.travelintellij.quotation")
//@EntityScan(basePackages = {"com.travelintellij.quotation.entity"})



@EnableJpaAuditing
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
@EnableJpaRepositories(basePackages = {"com.travelintellij.quotation.*"})
@EnableConfigurationProperties
@ComponentScan(basePackages="com.travelintellij.quotation.*")
@EntityScan(basePackages ={"com.travelintellij.quotation.*", "com.travelintellij.request.*"})
public class QuotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotationApplication.class, args);
	}

}
