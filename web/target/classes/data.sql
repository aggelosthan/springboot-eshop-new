-- Insert sample customers
INSERT INTO customer (name, email, address) VALUES
('John Doe', 'john@example.com', '123 Main St, New York, NY 10001'),
('Jane Smith', 'jane@example.com', '456 Oak Ave, Los Angeles, CA 90001'),
('Bob Johnson', 'bob@example.com', '789 Pine Rd, Chicago, IL 60601'),
('Alice Brown', 'alice@example.com', '321 Elm St, Houston, TX 77001'),
('Charlie Wilson', 'charlie@example.com', '654 Maple Dr, Phoenix, AZ 85001');

-- Insert sample products
INSERT INTO product (name, description, price, stock) VALUES
('Laptop Pro X', 'High-performance laptop with 16GB RAM and 512GB SSD', 999.99, 10),
('Smartphone Y', 'Latest model smartphone with 5G capability', 699.99, 15),
('Wireless Headphones', 'Noise-cancelling wireless headphones with 30-hour battery', 199.99, 20),
('Smart Watch', 'Fitness tracking smartwatch with heart rate monitor', 299.99, 12),
('Tablet Z', '10-inch tablet with retina display', 499.99, 8);

-- Insert sample orders
INSERT INTO orders (customer_id, order_date, total_amount) VALUES
(1, '2024-03-17', 1199.98),
(1, '2024-03-16', 699.99),
(2, '2024-03-17', 199.99),
(3, '2024-03-15', 799.98),
(4, '2024-03-17', 499.99);

-- Insert sample order items
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 999.99),  -- Laptop Pro X
(1, 3, 1, 199.99),  -- Wireless Headphones
(2, 2, 1, 699.99),  -- Smartphone Y
(3, 3, 1, 199.99),  -- Wireless Headphones
(4, 1, 1, 999.99),  -- Laptop Pro X
(4, 4, 1, 299.99),  -- Smart Watch
(5, 5, 1, 499.99);  -- Tablet Z 