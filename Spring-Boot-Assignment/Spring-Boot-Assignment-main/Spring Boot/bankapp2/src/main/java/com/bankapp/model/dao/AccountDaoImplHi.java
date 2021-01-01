package com.bankapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AccountDaoImplHi implements AccountDao{

	private EntityManager em;
	@Autowired
	public AccountDaoImplHi(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Account> getAllAccounts() {
		return em.createQuery("from Account").getResultList();
	}

	@Override
	public Account addAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Override
	public Account update(Account account) {
		em.merge(account);
		return account;
	}

	@Override
	public Account delete(int id) {
		Account accountToDelete=findAccountById(id);
		em.remove(accountToDelete);
		return accountToDelete;
	}

	@Override
	public Account findAccountById(int id) {
		Account accountId= em.find(Account.class, id);
		if(accountId==null)
			throw new AccountNotFoundException("Not Found");
		else
		return accountId;
	}

}
