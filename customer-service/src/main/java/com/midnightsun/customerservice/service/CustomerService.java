package com.midnightsun.customerservice.service;

import com.midnightsun.customerservice.model.Customer;
import com.midnightsun.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findOne(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseGet(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}
