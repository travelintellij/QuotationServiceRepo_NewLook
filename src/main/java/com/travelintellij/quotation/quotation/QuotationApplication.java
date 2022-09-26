package com.travelintellij.quotation.quotation;

import com.travelintellij.quotation.entity.Customer;
import com.travelintellij.quotation.entity.QuoteItem;
import com.travelintellij.quotation.service.QuotationGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages="com.travelintellij.quotation")
public class QuotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotationApplication.class, args);
	}

}
