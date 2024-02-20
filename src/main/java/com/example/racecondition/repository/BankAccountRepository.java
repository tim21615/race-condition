package com.example.racecondition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.racecondition.entity.BankAccount;

import jakarta.persistence.LockModeType;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT t FROM BankAccount t WHERE t.accountId = ?1")
	BankAccount findLockedById(Integer id);
}
