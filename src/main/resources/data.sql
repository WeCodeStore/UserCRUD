INSERT INTO ROLE (name) VALUES ('admin'), ('seller'), ('buyer');

INSERT INTO USERTABLE (userId, firstName, lastName, username, email, shippingAddressId, billingAddressId, phoneNumber) VALUES
(1, 'John', 'Smith', 'jsmith', 'jsmith@email.com', 'shipping', 'billing', 'phone');

INSERT INTO USERROLES (role_Id, user_Id) VALUES (1, 1),(2, 1);



INSERT INTO ADDRESS (city, street, state, postalCode, country) VALUES ('Charlotte', '123 Seezam street', 'NC', '28092', 'USA');

INSERT INTO CATEGORY (name) VALUES ('clothes'), ('tools'), ('electronics'), ('toys'), ('books');

INSERT INTO PRODUCT (productId, name, price, quantity, sku, description, categoryId) VALUES (1, 'bear', 12.9, 25, 'GY90j', 'description', 4 );

INSERT INTO IMAGE ( productId,name, type, imageUrl) VALUES (1, 'brush', 'JPG', 'C:/images/brush1.jpg');
INSERT INTO IMAGE ( productId,name, type, imageUrl) VALUES (1, 'tree', 'png', 'http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png');
INSERT INTO IMAGE ( productId,name, type, imageUrl) VALUES (1, 'Soda', 'png', 'https://us.coca-cola.com/content/dam/nagbrands/us/coke/en/products/coke-zero-sugar/kozs-plp-thumbnail.png');
INSERT INTO IMAGE ( productId,name, type, imageUrl) VALUES (1, 'cream', 'jpg', 'https://pics.walgreens.com/prodimg/17163/900.jpg');
INSERT INTO IMAGE ( productId,name, type, imageUrl) VALUES (1,'Curl Enhancer', 'png', 'https://www.barbersalon.com/media/catalog/product/cache/f6e6b1e75ba80be48e3706c64e276ab2/2/-/2-sheamoisture-28160.png');
INSERT INTO IMAGE ( productId,name, type, imageUrl) VALUES (1, 'Camera', 'png', 'https://www.dahuasecurity.com/asset/upload/uploads/image/20181029/DH-IPC-PDBW5831-B360-E4_image_20181025_thumb.png');

INSERT INTO ORDERTABLE (userId, orderNumber, orderDate, totalPrice) VALUES ( 1, 578446, '2023-02-24', 25.8 );

INSERT INTO ORDERPRODUCTS (order_Id, product_Id) VALUES (1, 1), (1, 1);

INSERT INTO REVIEW (comment, rating, productId, userId) VALUES ('Working Product', 5.0, 1, 1);
