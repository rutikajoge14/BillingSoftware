CREATE TABLE IF NOT EXISTS customers (
 customer_id INT PRIMARY KEY AUTO_INCREMENT,
 customer_name VARCHAR(100),
 customer_phone VARCHAR(20),
 customer_email VARCHAR(100),
 customer_address VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100),
    price INT,
    gst_percentage DOUBLE,
    stock_quantity INT
);

CREATE TABLE IF NOT EXISTS invoices (
 invoice_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT,
  total_amount DOUBLE,
  tax_amount DOUBLE,
 discount DOUBLE,
 final_amount DOUBLE,
 invoice_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS invoice_items (
item_id INT PRIMARY KEY AUTO_INCREMENT,
invoice_id INT,
product_id INT,
quantity INT,
price DOUBLE,
tax DOUBLE,
total DOUBLE
);

