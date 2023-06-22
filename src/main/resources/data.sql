INSERT INTO ROLE (name) VALUES ('admin'), ('seller'), ('buyer');

INSERT INTO ADDRESS (city, street, state, postalCode, country)
     VALUES ('Charlotte', '123 Seezam street', 'NC', '28092', 'USA'),
     ('Charlotte', 'P.O. Box 5600', 'NC', '28092', 'USA'),
     ('Charlotte', '123 strawberry dr. ', 'NC', '28211', 'USA'),
     ('Melbourne', '1000 University Blvd', 'FL', '28092', 'USA'),
     ('Melbourne', 'P.O. Box 1000', 'FL', '28092', 'USA'),
     ('Austin', '123 Exchange Blvd', 'TX', '78634', 'USA'),
     ('Hutto', '3160 Limmer Loop', 'TX', '78634', 'USA'),
     ('Wasilla', '4900 Palmer-Wasilla Hwy', 'AK', '99654', 'USA'),
     ('Adairsville', '7439 Adairsville Hwy', 'GA', '30103', 'USA'),
     ('Amherst', '4498 Main St', 'NY', '14226', 'USA');

INSERT INTO USERTABLE (userId, firstName, lastName, username, email, shippingAddressId, billingAddressId, phoneNumber)
 VALUES (1, 'John', 'Smith', 'jsmith', 'jsmith@email.com', 2, 1, 'phone'),
 (2, 'Jane', 'Doe', 'jdoe', 'jdoe@email.com', 3, 3, 'phone'),
 (3, 'Robert', 'Johnson', 'mjonhson$', 'jdoe@email.com', 5, 4, 'phone'),
 (4, 'Mary', 'Williams', 'pwilliams2', 'jdoe@email.com', 6, 6, 'phone'),
 (5, 'Elizabeth', 'Jones', 'jjones67', 'jdoe@email.com', 7, 7, 'phone'),
 (6, 'Anthony', 'Miller', 'amiller3', 'jdoe@email.com', 8, 8, 'phone'),
 (7, 'Frank', 'Davis', 'fdavis', 'jdoe@email.com', 9, 9, 'phone'),
 (8, 'Jeff', 'Martinez', 'Martinez45', 'jdoe@email.com', 10, 10, 'phone');

INSERT INTO USERROLES (role_Id, user_Id) VALUES (1, 1),(2, 1),(3,2),
    (3, 4), (3,5), (2, 6), (3, 6), (3, 7), (2, 8), (3, 8);

INSERT INTO CATEGORY (name) VALUES ('Clothes'), ('Tools'), ('Electronics'),
                                   ('Toys'), ('Books'), ('Snow Sports'),
                                   ('Baby'), ('Computer'), ('Music'),
                                   ('Personal Care');

INSERT INTO PRODUCT (productId, name, price, quantity, sku, description, categoryId) VALUES
          (1, 'bear', 12.9, 25, 'GY90j', 'description', 4 ),
          (2, 'Sounds of Summer 2023', 9.9, 10, 'GY90j', 'description', 4 ),
          (3, 'Chemical', 12.9, 45, 'Z5679', 'Pop Music', 9 ),
          (4, 'HUGGIES', 12.9, 25, 'B07MP6VXRN', 'Huggies Little Snugglers Diapers', 7),
          (5, 'The Science of Spice', 18.9, 15, '1465475575', 'Understand Flavor Connections and Revolutionize Your Cooking', 5 ),
          (6, 'SAMSUNG Galaxy S23 Ultra Cell Phone', 999.00, 10, 'B0BLP45GY8', 'Factory Unlocked Android Smartphone, 256GB, 200MP Camera, Night Mode, Long Battery Life, S Pen, US Version, 2023, Phantom Black', 3 ),
          (7, 'First Time Knitting', 11.9, 25, '1589238052', 'absolute beginners guide book, learning to knit is within reach. Like having your very own instructor, this book guides you carefully from your first nervous cast-on to confident knitting. With descriptions and guides.', 5 ),
          (8, 'INSIGNIA 32-inch Class F20 Series Smart HD', 79.99, 5, 'B09ZLTMWWH', '720p resolution View your favorite movies, shows and games in high definition.', 3 ),
          (9, 'Tree of Life Vitamin C', 19.0, 8, 'B014PGEEO2', 'Retinol and Hyaluronic Acid serum for Brightening, Firming, & Hydrating for Face - 3 Ct x 1 Fl Oz - Total Skin Reset, Anti Aging , Dark Spot Correcting', 10),
          (10, 'BBTFAA 𝟔𝟎𝐏𝐂𝐒 Under Eye Patches', 11.9, 4, 'B0BZCKX7VL', '24K Gold Collagen Eye Mask for Puffy Eyes', 10 ),
          (11, 'GAMZOO STEM Building', 39.9, 10, 'B07Q31WX1C', 'Toys for Kids with 2-in-1 Remote Control Racer Snap Together Engineering Kits Early Learning Racecar Building Blocks', 4 ),
          (12, 'DOWELL Magnetic Screwdriver Set', 25.9, 12, 'B09C27ZDYL', 'DOWELL Magnetic Screwdriver Set', 2 ),
          (13, 'KUDES Ski Goggles', 9.9, 30, 'B0BF8XWHZC', 'UV Protection Snowboard Sunglasses, Cycling Motorcycle Snow Sports Gear Accessories for Kids', 6 ),
          (14, 'Stance Barracks', 32.9, 16, 'B0B7MLZKQN', '2-Pack Snow Sport Socks', 6),
          (15, 'Dell OptiPlex 9020',700.50,5, 'B0BLTY5SZQ', 'Desktop Computer i7-4790 Small Form Factor PC, 16GB Ram 1TB M.2 MVMe', 8);

INSERT INTO IMAGE ( productId,name, type, imageUrl)
VALUES (1, 'brush', 'JPG', 'C:/images/brush1.jpg'),
       (1, 'tree', 'png', 'http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png'),
       (1, 'Soda', 'png', 'https://us.coca-cola.com/content/dam/nagbrands/us/coke/en/products/coke-zero-sugar/kozs-plp-thumbnail.png'),
       (1, 'cream', 'jpg', 'https://pics.walgreens.com/prodimg/17163/900.jpg'),
       (1,'Curl Enhancer', 'png', 'https://www.barbersalon.com/media/catalog/product/cache/f6e6b1e75ba80be48e3706c64e276ab2/2/-/2-sheamoisture-28160.png'),
       (2, 'Camera', 'png', 'https://www.dahuasecurity.com/asset/upload/uploads/image/20181029/DH-IPC-PDBW5831-B360-E4_image_20181025_thumb.png');

INSERT INTO ORDERTABLE (userId, orderNumber, orderDate, totalPrice) VALUES ( 1, 578446, '2023-02-24', 25.8 );

INSERT INTO ORDERPRODUCTS (order_Id, product_Id) VALUES (1, 1), (1, 1);

INSERT INTO REVIEW (comment, rating, productId, userId) VALUES ('Working Product', 5.0, 1, 1), ('Terrible', 1.0, 1, 2);
