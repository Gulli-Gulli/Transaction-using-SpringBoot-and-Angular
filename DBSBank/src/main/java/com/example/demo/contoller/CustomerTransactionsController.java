package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.CustomerTransactions;
import com.example.demo.service.CustomerTransactionsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/lets-transact/transactions/")
public class CustomerTransactionsController {
	@Autowired
	private CustomerTransactionsService service;

	@PostMapping("/save")
	public CustomerTransactions savingData(@RequestBody CustomerTransactions customer) {
		return service.saveData(customer);
	}

	@GetMapping
	public List<CustomerTransactions> getAllCustomerTransactions() {
		return service.getData();
	}
}
