package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository txnRepo;

	public List<Transaction> getDetails() {
		return (List<Transaction>) txnRepo.findAll();
	}
}
