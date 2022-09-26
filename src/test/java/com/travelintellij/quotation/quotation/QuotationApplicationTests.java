package com.travelintellij.quotation.quotation;

import com.travelintellij.quotation.entity.Customer;
import com.travelintellij.quotation.entity.QuoteItem;
import com.travelintellij.quotation.service.QuotationGenerateService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class QuotationApplicationTests {


	@Test
	void contextLoads() {
		System.out.println("Context Loaded ");
	}

	@Test
	void generatePdf(){

	}

}
