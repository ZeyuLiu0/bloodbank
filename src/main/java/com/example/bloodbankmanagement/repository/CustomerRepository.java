package com.example.bloodbankmanagement.repository;

import com.example.bloodbankmanagement.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    List<Customer> findAll();
    List<Customer> findByFnameAndLname(String fname, String lname);
}
