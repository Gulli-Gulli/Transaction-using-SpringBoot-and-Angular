package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.CustomerTransactions;

public interface CustomerTransactionsRepository extends CrudRepository<CustomerTransactions, UUID> {

}
