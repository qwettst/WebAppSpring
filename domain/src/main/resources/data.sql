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
  ( id_Store, Quantity, id_Product)
VALUES
  (1, 20, 1),
  (2, 15, 1),
  (3, 10, 1),
  (2, 200, 2),
  (3, 200, 2);

-- ************************************** `Staff`

INSERT INTO Staff
  ( First_Name, Last_Name, Salary, id_Store)
VALUES
  ('Petya', 'Petrov', 20000, 1),
  ('Ivan', 'Ivanov', 5000, 1),
  ('Kolya', 'Nikolaev', 60000, 2),
  ('Kostya', 'Konstantinov', 210000, 2),
  ('Vadim', 'Vadimovich', 20000, 3),
  ('Gosha', 'Ivanov', 203000, 3);

-- ************************************** `Consumer`

INSERT INTO Consumer
  ( First_Name, Last_Name, Phone)
VALUES
  ('Pokupatel_1', 'Petrov', 1324234),
  ('Pokupatel_2', 'Ivanov', 321411),
  ('Pokupatel_3', 'Nikolaev', 213124),
  ('Danil', 'Danilov', 3124123),
  ('Danil', 'Petrov', 5436),
  ('Pavel', 'Afanfnas', 6547),
  ('Kostya', 'Tomsk', 546),
  ('Denis', 'Ivanov', 234);

-- ************************************** `Feedback`

INSERT INTO Feedback
  ( Comment, Rating, id_Consumer, id_Store)
VALUES
  ('Klass', 5, 1, 1),
  ('Kruto', 3, 1, 2),
  ('Ne ochen', 1, 2, 3);

-- ************************************** `Cart`

INSERT INTO Cart
  ( id_Consumer, id_Staff, Total_Amount)
VALUES
  (1, 2, 0),
  (1, 3, 0),
  (2, 1 ,0);

-- ************************************** `CartItem`

INSERT INTO Cart_Item
  ( id_Product, id_Cart, id_Store, Quantity, Price)
VALUES
  (1, 1, 3, 20, 150),
  (2, 1, 3, 20, 200),
  (2, 2, 2, 10, 10),
  (3, 3, 1, 0, 0);