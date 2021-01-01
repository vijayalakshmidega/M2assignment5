package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.Account;

public interface AccountService {

	
	public List<Account> getAllAccounts();
	public Account addAccount(Account account);
	public Account transfer(int fromaccId,int toaccId,double amount);
	public Account deposit(int depositId,double amount);
	public Account withdraw(int dwithdrawId,double amount);
	public Account update(Account account);
	public Account delete(int id);
    public Account findAccountById(int id);
}
