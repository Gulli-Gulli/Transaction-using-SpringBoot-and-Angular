/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

}
