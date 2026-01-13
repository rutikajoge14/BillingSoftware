package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Customer;
import com.billing.billingsoftware.exception.ResourceNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

//        private final List<Customer> customers = new ArrayList<>();
//        private int customerId = 1;
//
//        public Customer save(Customer customer) {
//            customer.setCustomerId(customerId++);
//            customers.add(customer);
//            return customer;
//        }
//
//        public List<Customer> findAll() {
//            return customers;
//        }
//
//        public Customer findById(int id) {
//            return customers.stream()
//                    .filter(c -> c.getCustomerId() == id)
//                    .findFirst()
//                    .orElse(null);
//        }


        private final JdbcTemplate jdbc;

        public CustomerRepository(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }

        public Customer save(Customer customer) {
            String sql = "INSERT INTO customers (customer_name, customer_phone, customer_email, customer_address) VALUES (?, ?, ?, ?)";
            jdbc.update(
                    sql,
                    customer.getCustomerName(),
                    customer.getCustomerPhoneNo(),
                    customer.getCustomerEmail(),
                    customer.getCustomerAddress()
            );
            return customer;
        }


        public List<Customer> findAll() {
            String sql = "SELECT * FROM customers";
            return jdbc.query(sql, (rs, rowNum) -> new Customer(
                    rs.getInt("customer_id"),  // make sure column name matches your table
                    rs.getString("customer_name"),
                    rs.getString("customer_phone"),
                    rs.getString("customer_email"),
                    rs.getString("customer_address")
            ));
        }


        public Customer findById(int id) {
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            try {
                return jdbc.queryForObject(
                        sql,
                        new Object[]{id},
                        (rs, rowNum) -> new Customer(
                                rs.getInt("customer_id"),
                                rs.getString("customer_name"),
                                rs.getString("customer_phone"),
                                rs.getString("customer_email"),
                                rs.getString("customer_address")
                        )
                );
            } catch (org.springframework.dao.EmptyResultDataAccessException e) {
                // If no customer found, throw custom exception
                throw new ResourceNotFoundException("Customer not found with ID: " + id);
            }
        }
    }
