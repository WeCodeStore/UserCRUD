INSERT INTO ROLE (name) VALUES ('admin'), ('seller'), ('buyer');

INSERT INTO USERTABLE (userId, firstName, lastName, username, email, shippingAddressId, billingAddressId, phoneNumber) VALUES
(1, 'John', 'Smith', 'jsmith', 'jsmith@email.com', 'shipping', 'billing', 'phone');

INSERT INTO USERROLES (role_Id, user_Id) VALUES (1, 1),(2, 1);