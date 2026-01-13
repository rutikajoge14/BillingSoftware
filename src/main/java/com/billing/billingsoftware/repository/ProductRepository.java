package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

//        private final List<Product> products = new ArrayList<>();
//        private int productId = 1;
//
//        public Product save(Product product) {
//            product.setProductId(productId++);
//            products.add(product);
//            return product;
//        }
//
//        public List<Product> findAll() {
//            return products;
//        }
//
//        public Product findById(int id) {
//            return products.stream()
//                    .filter(p -> p.getProductId() == id)
//                    .findFirst()
//                    .orElse(null);
//        }
//
//        public void delete(Product product) {
//            products.remove(product);
//        }

        private final JdbcTemplate jdbc;

        public ProductRepository(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }

        public Product save(Product product) {
            jdbc.update(
                    "INSERT INTO products (product_name, price, gst_percentage, stock_quantity) VALUES (?,?,?,?)",
                    product.getProductName(),
                    product.getPrice(),
                    product.getGstPercentage(),
                    product.getStockQuantity()
            );
            return product;
        }

        public List<Product> findAll() {
            return jdbc.query(
                    "SELECT * FROM products",
                    (rs, rowNum) -> new Product(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getInt("price"),
                            rs.getDouble("gst_percentage"),
                            rs.getInt("stock_quantity")
                    )
            );
        }

        public Product findById(int id) {
            return jdbc.queryForObject(
                    "SELECT * FROM products WHERE product_id=?",
                    new Object[]{id},
                    (rs, rowNum) -> new Product(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getInt("price"),
                            rs.getDouble("gst_percentage"),
                            rs.getInt("stock_quantity")
                    )
            );
        }

        public void update(int id, Product product) {
            jdbc.update(
                    "UPDATE products SET price=?, gst_percentage=?, stock_quantity=? WHERE product_id=?",
                    product.getPrice(),
                    product.getGstPercentage(),
                    product.getStockQuantity(),
                    id
            );
        }

        public void delete(int id) {
            jdbc.update("DELETE FROM products WHERE product_id=?", id);
        }
    }





