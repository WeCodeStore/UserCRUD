INSERT INTO ROLE (name) VALUES ('admin'), ('seller'), ('buyer');

INSERT INTO USERTABLE (userId, firstName, lastName, username, email, shippingAddressId, billingAddressId, phoneNumber) VALUES
(1, 'John', 'Smith', 'jsmith', 'jsmith@email.com', 'shipping', 'billing', 'phone');

INSERT INTO USERROLES (role_Id, user_Id) VALUES (1, 1),(2, 1);

INSERT INTO ADDRESS (city, street, state, postalCode, country) VALUES ('Charlotte', '123 Seezam street', 'NC', '28092', 'USA');

INSERT INTO CATEGORY (name) VALUES ('clothes'), ('tools'), ('electronics'), ('toys'), ('books');

INSERT INTO PRODUCT (productId, name, price, quantity, sku, image, description, categoryId) VALUES (1, 'bear', 12.9, 25, 'GY90j', 'img', 'description', 4 );

INSERT INTO ORDERTABLE (userId, orderNumber, orderDate, totalPrice) VALUES ( 1, 578446, '2023-02-24', 25.8 );

INSERT INTO ORDERPRODUCTS (order_Id, product_Id) VALUES (1, 1), (1, 1);

INSERT INTO REVIEW (comment, rating, productId, userId) VALUES ('Working Product', 5.0, 1, 1);