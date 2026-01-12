package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.entity.Customer;
import com.billing.billingsoftware.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

        private final CustomerService service;

        public CustomerController(CustomerService service) {
            this.service = service;
        }

        @PostMapping
        public Customer add(@RequestBody Customer customer) {
            return service.add(customer);
        }

        @GetMapping
        public List<Customer> getAll() {
            return service.getAll();
        }

        @GetMapping("/{id}")
        public Customer getById(@PathVariable int id) {
            return service.getById(id);
        }

        @PutMapping("/{id}")
        public Customer update(@PathVariable int id,
                               @RequestBody Customer customer) {
            return service.update(id, customer);
        }
    }


