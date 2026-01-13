package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Customer;
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

    public Customer save(Customer customer){
        jdbc.update(
                "INSERT INTO customers (name, phone, email, address)   VALUES (?,?,?,?)",
                customer.getCustomerName(),
                customer.getCustomerPhoneNo(),
                customer.getCustomerEmail(),
                customer.getCustomerAddress()
        );
        return customer;
    }

    public List<Customer> findAll(){
        return jdbc.query("SELECT * FROM customers" ,(rs, rowNum) -> new Customer(
                rs.getInt("id"), rs.getString("name"),rs.getString("phone"),rs.getString("email"),
                rs.getString("address")
        ));
    }

    public Customer findById(int id){
        return jdbc.queryForObject("SELECT * FROM customers WHERE id=?",
                new Object[]{id},
                (rs, rowNum) -> new Customer(
                        rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone"),
                                rs.getString("email"),
                                rs.getString("address")
                )
        );
    }
}


