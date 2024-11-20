-- Inserting data into category table
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Electronics items including gadgets and accessories', 'Electronics');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Clothing and fashion accessories', 'Fashion');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Groceries including perishable and non-perishable food items', 'Groceries');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Furniture items including home and office furniture', 'Furniture');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Books across various genres and categories', 'Books');

-- Inserting data into product table (linked to the respective categories)

-- Products for Electronics
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Smartphone with 128GB storage', 'Smartphone X', 100, 699.99, (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Wireless noise-cancelling headphones', 'Headphones Z', 50, 299.99, (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), '4K Ultra HD Smart TV', 'Smart TV Y', 30, 899.99, (SELECT id FROM category WHERE name = 'Electronics'));

-- Products for Fashion
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Men''s leather jacket', 'Leather Jacket', 75, 199.99, (SELECT id FROM category WHERE name = 'Fashion'));
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Women''s cotton summer dress', 'Summer Dress', 120, 49.99, (SELECT id FROM category WHERE name = 'Fashion'));

-- Products for Groceries
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Pack of organic brown rice', 'Brown Rice', 200, 10.99, (SELECT id FROM category WHERE name = 'Groceries'));
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Cold-pressed olive oil, 1L', 'Olive Oil', 180, 14.99, (SELECT id FROM category WHERE name = 'Groceries'));

-- Products for Furniture
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Ergonomic office chair', 'Office Chair', 45, 129.99, (SELECT id FROM category WHERE name = 'Furniture'));
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Wooden dining table set', 'Dining Table Set', 15, 499.99, (SELECT id FROM category WHERE name = 'Furniture'));

-- Products for Books
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Fiction novel by famous author', 'The Great Adventure', 300, 19.99, (SELECT id FROM category WHERE name = 'Books'));
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES (nextval('product_seq'), 'Self-help book on productivity', 'Productivity Mastery', 150, 24.99, (SELECT id FROM category WHERE name = 'Books'));
