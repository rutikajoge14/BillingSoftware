package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.exception.ResourceNotFoundException;
import com.billing.billingsoftware.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

        private final ProductRepository repo;

        public ProductService(ProductRepository repo) {
            this.repo = repo;
        }

        public Product add(Product product) {
            return repo.save(product);
        }

        public List<Product> getAll() {
            return repo.findAll();
        }

        public Product getById(int id) {
            Product p = repo.findById(id);
            if (p == null) {
                throw new ResourceNotFoundException("Product not found");
            }
            return p;
        }

        public Product update(int id, Product updated) {
            Product p = getById(id);
            p.setPrice(updated.getPrice());
            p.setStockQuantity(updated.getStockQuantity());
            return p;
        }

        public void delete(int id) {
            Product p = getById(id);
            repo.delete(id);
        }
    }



