package com.bankapp.model.dao;
import java.util.*;
public interface AccountDao {
	
	public List<Account> getAllAccounts();
	public Account addAccount(Account account);
	public Account update(Account account);
	public Account delete(int id);
    public Account findAccountById(int id);
    
}
