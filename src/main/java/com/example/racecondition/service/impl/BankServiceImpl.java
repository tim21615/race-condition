package com.example.racecondition.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.racecondition.entity.BankAccount;
import com.example.racecondition.repository.BankAccountRepository;
import com.example.racecondition.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankAccountRepository repository;

	@Override
	@Transactional
	public void transferMoney() {
		BankAccount account2 = repository.findLockedById(2);
		BankAccount account1 = repository.findLockedById(1);
		
		account2.addMoney(100);
		account1.addMoney(-100);
		
		repository.saveAll(Arrays.asList(account2, account1));
	}
}
