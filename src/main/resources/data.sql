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

INSERT INTO CATEGORY (name, titleImage) VALUES ('Outdoor', 'https://static.homegoods.com/content/v1/static_content/images/homepage/23_APR_WK1/Summer_Site_CatTiles_1322771_D_Outdoor.jpg'),
 ('Furniture & Lighting', 'https://static.homegoods.com/content/v1/static_content/images/homepage/23_APR_WK1/Summer_Site_CatTiles_1322771_D_FurnLighting.jpg'),
 ('Rugs', 'https://static.homegoods.com/content/v1/static_content/images/homepage/23_APR_WK1/Summer_Site_CatTiles_1322771_D_Rugs.jpg'),
 ('Decor & Pillows', 'https://static.homegoods.com/content/v1/static_content/images/homepage/23_APR_WK1/Summer_Site_CatTiles_1322771_D_DecorPillows.jpg'),
 ('Bed & Bath', 'https://static.homegoods.com/content/v1/static_content/images/homepage/23_APR_WK1/Summer_Site_CatTiles_1322771_D_Bedding.jpg'),
 ('Kitchen & Dining', 'https://static.homegoods.com/content/v1/static_content/images/homepage/23_APR_WK1/Summer_Site_CatTiles_1322771_D_KitchenDining.jpg');

INSERT INTO PRODUCT (productId, name, price, quantity, sku, faceImage, description, categoryId) VALUES
          (1, 'bear', 12.9, 25, 'GY90j', 'http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png', 'description', 4 ),
          (2, 'Sounds of Summer 2023', 9.9, 10, 'GY90j', '', 'description', 4 ),
          (3, 'Chemical', 12.9, 45, 'Z5679', '', 'Pop Music', 6 ),
          (4, 'HUGGIES', 12.9, 25, 'B07MP6VXRN', '', 'Huggies Little Snugglers Diapers', 5),
          (5, 'The Science of Spice', 18.9, 15, '1465475575', '', 'Understand Flavor Connections and Revolutionize Your Cooking', 5 ),
          (6, 'SAMSUNG Galaxy S23 Ultra Cell Phone', 999.00, 10, 'B0BLP45GY8', '', 'Factory Unlocked Android Smartphone, 256GB, 200MP Camera, Night Mode, Long Battery Life, S Pen, US Version, 2023, Phantom Black', 3 ),
          (7, 'First Time Knitting', 11.9, 25, '1589238052', '', 'absolute beginners guide book, learning to knit is within reach. Like having your very own instructor, this book guides you carefully from your first nervous cast-on to confident knitting. With descriptions and guides.', 5 ),
          (8, 'INSIGNIA 32-inch Class F20 Series Smart HD', 79.99, 5, 'B09ZLTMWWH', '', '720p resolution View your favorite movies, shows and games in high definition.', 3 ),
          (9, 'Tree of Life Vitamin C', 19.0, 8, 'B014PGEEO2', '', 'Retinol and Hyaluronic Acid serum for Brightening, Firming, & Hydrating for Face - 3 Ct x 1 Fl Oz - Total Skin Reset, Anti Aging , Dark Spot Correcting', 1),
          (10, 'MADE IN INDIA', 249.99, 4, 'B0BZCKX7VL', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000020454_NS9861028],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '25in Bone Inlay Medallion Top Table With Wood Base', 2 ),
          (11, 'GAMZOO STEM Building', 39.9, 10, 'B07Q31WX1C', '', 'Toys for Kids with 2-in-1 Remote Control Racer Snap Together Engineering Kits Early Learning Racecar Building Blocks', 4 ),
          (12, 'THE FARMHOUSE BY RACHEL ASHWELL', 79.99, 12, 'B09C27ZDYL', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000030711_NS9861067],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '66in Adjustable Height Metal Floor Lamp', 2 ),
          (13, 'KUDES Ski Goggles', 9.9, 30, 'B0BF8XWHZC', '', 'UV Protection Snowboard Sunglasses, Cycling Motorcycle Snow Sports Gear Accessories for Kids', 6 ),
          (14, 'Stance Barracks', 32.9, 16, 'B0B7MLZKQN', '', '2-Pack Snow Sport Socks', 6),
          (15, 'Dell OptiPlex 9020',700.50, 5, 'B0BLTY5SZQ', '', 'Desktop Computer i7-4790 Small Form Factor PC, 16GB Ram 1TB M.2 MVMe', 3),
          (16, 'MADISON PARK', 199.99, 17, 'B0B123AARQ', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000024279_NS9861051],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '30in 2 Drawer Console Table', 2),
          (17, 'NAUTICA', 499.99, 3, 'TB324ASSK4', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000030299_NS10274978],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '2pk 37in Ashley Curved Wood Frame Counter Stools', 2),
          (18, 'MADE IN INDONESIA', 199.99, 7, 'B80HKSL24Q', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000028785_NS9861002],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '21x24 Woven 1 Drawer Side Table', 2),
          (19, 'TROY LIGHTING', 79.99, 12, 'L897SDFGW1', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000024917_NS9861109],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '8x24 Taylor 3 Light Glass Shade Vanity Light', 2),
          (20, 'LILLIAN BY LILLIAN AUGUST', 399.99, 4, 'TB12S4DDFA', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000028589_NS9860996],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '2pk 38in Rope Woven Counter Stools With Cushions', 2),
          (21, 'BROOKS BROTHERS', 499.99, 3, 'BR078SACQ1', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000023888_NS10657773],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3', '30.5in Leather Armchair With Wood Frame', 2);

INSERT INTO IMAGE ( productId, name, type, imageUrl)
VALUES (1, 'tree', 'png', 'http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/tree_2.png'),
       (1, 'Soda', 'png', 'https://us.coca-cola.com/content/dam/nagbrands/us/coke/en/products/coke-zero-sugar/kozs-plp-thumbnail.png'),
       (1, 'cream', 'jpg', 'https://pics.walgreens.com/prodimg/17163/900.jpg'),
       (1,'Curl Enhancer', 'png', 'https://www.barbersalon.com/media/catalog/product/cache/f6e6b1e75ba80be48e3706c64e276ab2/2/-/2-sheamoisture-28160.png'),
       (2, 'Camera', 'png', 'https://www.dahuasecurity.com/asset/upload/uploads/image/20181029/DH-IPC-PDBW5831-B360-E4_image_20181025_thumb.png'),
       (10, 'Table', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000020454_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (12, 'Lamp', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000030711_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (12, 'Lamp', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000030711_alt2],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (16, 'Drawer Table', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000024279_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (17, 'Stools', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000030299_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (17, 'Stools', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000030299_alt2],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (18, 'Drawer', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000028785_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (19, 'Lights', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000024917_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (19, 'Lights', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000024917_alt2],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (20, 'Stools', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000028589_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (20, 'Stools', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000028589_alt2],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (21, 'Armchair', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000023888_alt1],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3'),
       (21, 'Armchair', 'png', 'https://img.homegoods.com/homegoods?set=DisplayName[e8],prd[7000023888_alt2],ag[no]&call=url[file:tjxrPRD2_prod.chain]&v=3');

INSERT INTO ORDERTABLE (userId, orderNumber, orderDate, totalPrice) VALUES ( 1, 578446, '2023-02-24', 25.8 );

INSERT INTO ORDERPRODUCTS (order_Id, product_Id) VALUES (1, 1), (1, 1);

INSERT INTO REVIEW (comment, rating, productId, userId) VALUES ('Working Product', 5.0, 1, 1), ('Terrible', 1.0, 1, 2);
