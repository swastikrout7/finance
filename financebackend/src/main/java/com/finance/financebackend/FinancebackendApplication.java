package com.finance.financebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //combination of 3 annotation
//-enable auto configuration
//-component scan
//-configurartion
public class FinancebackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancebackendApplication.class, args);
	}

}
