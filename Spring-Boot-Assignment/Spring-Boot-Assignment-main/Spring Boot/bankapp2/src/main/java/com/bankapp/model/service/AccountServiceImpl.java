package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
private AccountDao accountdao;
private static int MIN_BALANCE=1000;
@Autowired
public AccountServiceImpl(AccountDao accountdao) {
	this.accountdao=accountdao;
}
	@Override
	public List<Account> getAllAccounts() {
		return accountdao.getAllAccounts();
	}

	@Override
	public Account addAccount(Account account) {
		return accountdao.addAccount(account);
	}

	@Override
	public Account update(Account account) {
		return accountdao.update(account);
	}

	@Override
	public Account delete(int id) {
		return accountdao.delete(id);
	}

	@Override
	public Account findAccountById(int id) {
		return accountdao.findAccountById(id);
	}
	@Override
	public Account transfer(int fromaccId, int toaccId, double amount) {
      Account fromAcc=accountdao.findAccountById(fromaccId);
      Account toAcc=accountdao.findAccountById(toaccId);
      fromAcc.setBalance(fromAcc.getBalance()-amount);
      toAcc.setBalance(toAcc.getBalance()+amount);
      accountdao.update(fromAcc);
      accountdao.update(toAcc);
      return fromAcc;
      
	}
	@Override
	public Account deposit(int depositId, double amount) {
		Account accDeposit=accountdao.findAccountById(depositId);
		accDeposit.setBalance(accDeposit.getBalance()+amount);
		return accountdao.update(accDeposit);
	}
	@Override
	public Account withdraw(int withdrawId, double amount) {
		Account accWithdraw=accountdao.findAccountById(withdrawId);
		if(MIN_BALANCE>=1000)
		{
		accWithdraw.setBalance(accWithdraw.getBalance()-amount);
		}
		return accountdao.update(accWithdraw);
	}

}
