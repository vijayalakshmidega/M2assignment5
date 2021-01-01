package com.bankapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountType;
import com.bankapp.model.service.AccountService;

@EnableAspectJAutoProxy
@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class }) 
public class Bankapp2Application implements CommandLineRunner{

	@Autowired
	private AccountService accountService;
	//private DataSource dataSource;
//	@Autowired
//	private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(Bankapp2Application.class, args);
	}
//it call this method when spring boot is intialized
	@Override
	public void run(String... args) throws Exception {
//        		if(dataSource!=null)
//        			System.out.println("Data source is configured....!");
//        		if(em!=null)
//        	System.out.println("Entity Manger is configured....!");
		
		
		Account account=new Account("Manisha","Delhi",3098.23,AccountType.SA);
		Account account1=new Account("Varsha","Pune",10000.23,AccountType.SA);

		Account account2=new Account("Rishi","Mumbai",20000.23,AccountType.CA);

		Account account3=new Account("Vishnu","Hyd",7000.23,AccountType.SA);
		accountService.addAccount(account);
		accountService.addAccount(account1);
		accountService.addAccount(account2);
		accountService.addAccount(account3);
		
		
	}

}
