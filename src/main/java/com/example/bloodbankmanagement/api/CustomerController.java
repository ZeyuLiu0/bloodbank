package com.example.bloodbankmanagement.api;

import com.example.bloodbankmanagement.entity.Customer;
import com.example.bloodbankmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("findAll")
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @GetMapping("findId/{id}")
    public Customer findById(@PathVariable int id){
        return customerRepository.findById(id).orElse(null);
    }

    @GetMapping("findName/{fname}/{lname}")
    public List<Customer> findByName(@PathVariable String fname, @PathVariable String lname){
        return customerRepository.findByFnameAndLname(fname,lname);
    }

    @PostMapping("add")
    public Customer addNewCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    @PutMapping("updateAll")
    public Customer updateAll(@RequestBody Customer customer){
        Optional<Customer> dummyCustomer = customerRepository.findById(customer.getId());
        if(dummyCustomer.isPresent()){
            customerRepository.save(customer);
            return customer;
        }else{
            return null;
        }
    }

    @PatchMapping("donorUpdate/{id}/{count}")
    public Customer donorUpdate(@PathVariable int id, @PathVariable int count){
        Customer customer = findById(id);
        customer.setDonorUnit(customer.getDonorUnit()+count);
        customerRepository.save(customer);
        return customer;
    }

    @PatchMapping("requestUpdate/{id}/{count}")
    public Customer requestUpdate(@PathVariable int id, @PathVariable int count){
        Customer customer = findById(id);
        customer.setRequestUnit(customer.getRequestUnit()+count);
        customerRepository.save(customer);
        return customer;
    }

    @DeleteMapping("delete/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        Customer customer = findById(id);
        customerRepository.delete(customer);
        return customer;
    }
}
