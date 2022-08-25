package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Transaction;
import com.example.demo.service.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
	@Autowired
	private TransactionService service;

	@GetMapping("getDetails")
	public List<Transaction> getDetails() {
		return service.getDetails();

	}

}
