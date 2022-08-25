package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CustomerTransactions;
import com.example.demo.repository.CustomerTransactionsRepository;

@Service
public class CustomerTransactionsService {
	@Autowired
	private CustomerTransactionsRepository ctRepo;

	public CustomerTransactions saveData(CustomerTransactions customer) {
		return ctRepo.save(customer);
	}

	public List<CustomerTransactions> getData() {
		return (List<CustomerTransactions>) ctRepo.findAll();
	}
}
