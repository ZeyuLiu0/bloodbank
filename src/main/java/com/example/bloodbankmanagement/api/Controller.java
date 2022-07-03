package com.example.bloodbankmanagement.api;

import com.example.bloodbankmanagement.entity.Customer;
import com.example.bloodbankmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("findAll")
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @PostMapping("add")
    public Customer addNewCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return customer;
    }
    @GetMapping
    public String homePage(){
        return "Home page";
    }

}
