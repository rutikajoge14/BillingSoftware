package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

        private final List<Product> products = new ArrayList<>();
        private int productId = 1;

        public Product save(Product product) {
            product.setProductId(productId++);
            products.add(product);
            return product;
        }

        public List<Product> findAll() {
            return products;
        }

        public Product findById(int id) {
            return products.stream()
                    .filter(p -> p.getProductId() == id)
                    .findFirst()
                    .orElse(null);
        }

        public void delete(Product product) {
            products.remove(product);
        }
    }


