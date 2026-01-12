package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

        private final List<Customer> customers = new ArrayList<>();
        private int customerId = 1;

        public Customer save(Customer customer) {
            customer.setCustomerId(customerId++);
            customers.add(customer);
            return customer;
        }

        public List<Customer> findAll() {
            return customers;
        }

        public Customer findById(int id) {
            return customers.stream()
                    .filter(c -> c.getCustomerId() == id)
                    .findFirst()
                    .orElse(null);
        }
    }


