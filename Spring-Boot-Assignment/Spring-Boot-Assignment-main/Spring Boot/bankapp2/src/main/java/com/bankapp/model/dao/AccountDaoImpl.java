package com.bankapp.model.dao;

import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl implements AccountDao{
      
	private Map<Integer,Account> accounts=new HashMap<Integer,Account>();
	private int count=0;
	{
		accounts.put(1, new Account(++count,"Sree","Nellore",6000.90,AccountType.SA));
		accounts.put(2, new Account(++count,"vyshu","Nellore",7000.90,AccountType.SA));
	}
	@Override
	public List<Account> getAllAccounts() {
		return new ArrayList<>(accounts.values());
	}

	@Override
	public Account addAccount(Account account) {
      account.setId(++count);
      accounts.put(count, account);
		return account;
	}

	@Override
	public Account update(Account account) {
		return accounts.put(account.getId(), account);
	}

	@Override
	public Account delete(int id) {
		
		return accounts.remove(id);
	}

	@Override
	public Account findAccountById(int id) {
	
		return accounts.get(id);
	}

}
