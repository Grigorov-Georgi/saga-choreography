package com.midnightsun.customerservice.web;

import com.midnightsun.customerservice.model.Customer;
import com.midnightsun.customerservice.service.CustomerService;
import com.midnightsun.customerservice.service.dto.CustomerDTO;
import com.midnightsun.customerservice.service.mapper.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getOne(@PathVariable Long id){
        Customer customer = customerService.findOne(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerMapper.toDTO(customer));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.save(customerMapper.toEntity(customerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDTO(customer));
    }
}
