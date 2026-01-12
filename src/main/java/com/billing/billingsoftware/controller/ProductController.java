package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


        private final ProductService service;

        public ProductController(ProductService service) {
            this.service = service;
        }

        @PostMapping
        public Product add(@RequestBody Product product) {
            return service.add(product);
        }

        @GetMapping
        public List<Product> getAll() {
            return service.getAll();
        }

        @GetMapping("/{id}")
        public Product getById(@PathVariable int id) {
            return service.getById(id);
        }

        @PutMapping("/{id}")
        public Product update(@PathVariable int id,
                              @RequestBody Product product) {
            return service.update(id, product);
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable int id) {
            service.delete(id);
            return "Product deleted";
        }
    }


