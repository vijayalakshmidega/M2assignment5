package com.bankapp.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;

import java.util.*;


@RestController
@RequestMapping("clerks")
public class AccountController {
  	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}


	@GetMapping(path="account" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccount() {
		List<Account> accounts=accountService.getAllAccounts();
		return accounts;
	}
	@GetMapping(path="account/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Account getAccount(@PathVariable("id")int id) {
		Account accountsbyId=accountService.findAccountById(id);
		return accountsbyId;
	}
	@PostMapping(path="account ",
	produces=MediaType.APPLICATION_JSON_VALUE,
	consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account addAccounts(@RequestBody Account account) {
		Account accountadd=accountService.addAccount(account);
		return accountadd;
}
	@PutMapping(path="account/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Account updateAccounts(@RequestBody Account account,@PathVariable("id") int id) {
		Account accUpdate=accountService.update(account);
		return accUpdate;
	}
	

	@DeleteMapping(path="account/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Account getDeleteAccount(@PathVariable("id")int id) {
		Account accountdeletebyId=accountService.findAccountById(id);
		return accountdeletebyId;
	}
	
}
