CREATE TABLE IF NOT EXISTS customers(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    phone BIGINT,
    email VARCHAR(100),
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100),
    price INT,
    gst_percentage DOUBLE,
    stock_quantity INT
);
