package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Bank;
import com.example.demo.service.BankService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/lets-transact/")
public class BankController {
	@Autowired
	private BankService service;

	@GetMapping("/allAccountDetails")
	private List<Bank> getAllAccountDetails() {

		List<Bank> bankList = service.getAllAccountDetails();
		System.out.print(bankList);

		return bankList;
	}

	@GetMapping("/getAccountDetailsof/{customer_id}")
	private Bank getSepcificAccountDetails(@PathVariable(value = "customer_id") long customer_id) {
		return service.getBankDetailsById(customer_id);

	}

	@DeleteMapping("/removeAccount/{customer_id}")
	private void deleteBankAccount(@PathVariable("customer_id") long customer_id) {
		service.delete(customer_id);
	}

	@PostMapping("/addNewAccountDetails")
	private void saveNewAccountDetails(@RequestBody Bank bank) {
		service.addCustomerDetails(bank);
	}

	@PutMapping("/updateAccDetails/{customer_id}")
	private Bank updateAccountDetails(@PathVariable long customer_id, @RequestBody Bank bank) {
		return service.updateDet(customer_id, bank);

	}

}
