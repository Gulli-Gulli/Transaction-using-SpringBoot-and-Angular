package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Bank;
import com.example.demo.repository.BankRepository;

@Service
public class BankService {
	@Autowired
	BankRepository bankRepository;

	public List<Bank> getAllAccountDetails() {
		return (List<Bank>) bankRepository.findAll();
	}

	public Bank getBankDetailsById(long id) {
		Optional<Bank> findById = bankRepository.findById(id);
		if (findById.isEmpty()) {
			throw new NoSuchElementException("No Bank account found with given id");
		}
		return findById.get();
	}

	public void addCustomerDetails(Bank bank) {
		bankRepository.save(bank);
	}

	public void delete(long id) {
		bankRepository.deleteById(id);
	}

	public void saveOrUpdate(Bank bank) {
		bankRepository.save(bank);
	}

	public Bank updateDet(long customer_id, Bank bank) {
		// TODO Auto-generated method stub
		Bank bankObj = bankRepository.findById(customer_id).get();

		bankObj.setClear_balance_inr_credit(bank.getClear_balance_inr_credit());
//		bankObj.setAccount_holder_name(bank.getAccount_holder_name());
//		bankObj.setOverdraft(bank.getOverdraft());
//		bankObj.setTransfer_type(bank.getTransfer_type());

		return bankRepository.save(bankObj);
	}
}
