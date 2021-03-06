package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.dto.CustomerForm;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {

        return customerService.getCustomerByUsername(username);
    }

    @PostMapping
    public Customer postCustomer(@RequestBody CustomerForm customerForm) {
        return customerService.saveCustomer(customerForm);
    }

    @PutMapping
    public Customer putCustomer(@RequestBody CustomerForm customerForm) {

        Customer customer = customerService.getCustomerByUsername(customerForm.getUsername());
        customerService.update(customer, customerForm);

        return customer;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String username) {
        Customer customer = customerService.getCustomerByUsername(username);
        customerService.delete(customer.getUsername());

        return ResponseEntity.ok(HttpStatus.OK);
    }
}