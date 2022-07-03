package com.example.bloodbankmanagement.repository;

import com.example.bloodbankmanagement.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    List<Customer> findAll();
}
