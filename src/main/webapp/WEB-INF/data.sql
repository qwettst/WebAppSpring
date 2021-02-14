-- ************************************** `Store`

INSERT INTO Store
  (Address)
VALUES
  ('Lloyds Office'),
  ('London Office'),
  ('Bristol Office');

-- ************************************** `Product`

INSERT INTO Product
  ( Name,Description)
VALUES
  ('Milk','Moloko'),
  ('Coffee', 'Kofe'),
  ('Tea', 'Chai');

-- ************************************** `Warehouse`

INSERT INTO Warehouse
  ( idStore, Quantity, idProduct)
VALUES
  (1, 20, 1),
  (2, 15, 1),
  (3, 10, 1),
  (2, 200, 2),
  (3, 200, 2);

-- ************************************** `Staff`

INSERT INTO Staff
  ( FirstName, LastName, Salary, idStore)
VALUES
  ('Petya', 'Petrov', 20000, 1),
  ('Ivan', 'Ivanov', 5000, 1),
  ('Kolya', 'Nikolaev', 60000, 2),
  ('Kostya', 'Konstantinov', 210000, 2),
  ('Vadim', 'Vadimovich', 20000, 3),
  ('Gosha', 'Ivanov', 203000, 3);

-- ************************************** `Consumer`

INSERT INTO Consumer
  ( FirstName, LastName, Phone)
VALUES
  ('Pokupatel_1', 'Petrov', 1324234),
  ('Pokupatel_2', 'Ivanov', 321411),
  ('Pokupatel_3', 'Nikolaev', 2);

-- ************************************** `Feedback`

INSERT INTO Feedback
  ( Comment, Rating, idConsumer, idStore)
VALUES
  ('Klass', 5, 1, 1),
  ('Kruto', 3, 1, 2),
  ('Ne ochen', 1, 2, 3);

-- ************************************** `Cart`

INSERT INTO Cart
  ( idConsumer, idStaff, TotalAmount)
VALUES
  (1, 2, 0),
  (1, 3, 0),
  (2, 1 ,0);

-- ************************************** `CartItem`

INSERT INTO CartItem
  ( idProduct, idCart, idStore, Quantity, Price)
VALUES
  (1, 1, 3, 20, 150),
  (2, 1, 3, 20, 200),
  (2, 2, 2, 10, 10),
  (3, 3, 1, 0, 0);