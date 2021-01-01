package com.bankapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.model.service.AccountService;

public class DemoMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		AccountService accounts=(AccountService) ctx.getBean("accountService");
		accounts.transfer(1, 2, 300);
		
	}

}
