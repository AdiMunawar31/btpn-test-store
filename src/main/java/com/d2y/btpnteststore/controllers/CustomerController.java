package com.d2y.btpnteststore.controllers;


import com.d2y.btpnteststore.dto.CustomerDto;
import com.d2y.btpnteststore.dto.ResponseDto;
import com.d2y.btpnteststore.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<ResponseDto<CustomerDto>> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return ResponseEntity.ok(new ResponseDto<>("Customer created successfully", createdCustomer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<CustomerDto>> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(new ResponseDto<>("Customer updated successfully", updatedCustomer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<CustomerDto>> getCustomerById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(new ResponseDto<>("Customer retrieved successfully", customerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<CustomerDto>> deleteCustomer(@PathVariable Long id) {
        CustomerDto customerDto = customerService.deleteCustomer(id);
        return ResponseEntity.ok(new ResponseDto<>("Customer deleted successfully", customerDto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<CustomerDto>>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(new ResponseDto<>("Customers retrieved successfully", customers));
    }
}
