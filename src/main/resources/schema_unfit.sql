-- ************************************** `Store`

CREATE TABLE `Store`
(
 `idStore` int NOT NULL AUTO_INCREMENT,
 `Address`  varchar(45) NOT NULL ,

PRIMARY KEY (`idStore`)
);

-- ************************************** `Product`

CREATE TABLE `Product`
(
 `idProduct`   int NOT NULL AUTO_INCREMENT,
 `Name`        varchar(45) NOT NULL ,
 `Description` varchar(45) NOT NULL ,

PRIMARY KEY (`idProduct`)
);

-- ************************************** `Warehouse`

CREATE TABLE `Warehouse`
(
 `idWarehouse` int NOT NULL AUTO_INCREMENT,
 `idStore`     int NOT NULL ,
 `Quantity`    int NULL ,
 `idProduct`   int NOT NULL ,

PRIMARY KEY (`idWarehouse`),
FOREIGN KEY (`idStore`) REFERENCES `Store` (`idStore`),
FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`)
);

-- ************************************** `Staff`

CREATE TABLE `Staff`
(
 `idStaff`   int NOT NULL AUTO_INCREMENT,
 `FirstName` varchar(45) NOT NULL ,
 `LastName`  varchar(45) NOT NULL ,
 `Salary`    int NOT NULL ,
 `idStore`   int NOT NULL ,

PRIMARY KEY (`idStaff`),
FOREIGN KEY (`idStore`) REFERENCES `Store` (`idStore`)
);

-- ************************************** `Consumer`

CREATE TABLE `Consumer`
(
 `idConsumer` int NOT NULL AUTO_INCREMENT,
 `FirstName`  varchar(45) NOT NULL ,
 `LastName`   varchar(45) NOT NULL ,
 `Phone`      varchar(45) NOT NULL ,

PRIMARY KEY (`idConsumer`)
);

-- ************************************** `Feedback`

CREATE TABLE `Feedback`
(
 `idFeedBack` int NOT NULL AUTO_INCREMENT,
 `Comment`    varchar(45) NOT NULL ,
 `Rating`     int NOT NULL ,
 `idConsumer` int NOT NULL ,
 `idStore` int NOT NULL ,

PRIMARY KEY (`idFeedBack`),
FOREIGN KEY (`idConsumer`) REFERENCES `Consumer` (`idConsumer`),
FOREIGN KEY (`idStore`) REFERENCES `Store` (`idStore`)
);

-- ************************************** `Cart`

CREATE TABLE `Cart`
(
 `idCart`      int NOT NULL AUTO_INCREMENT,
 `idConsumer`  int NOT NULL ,
 `idStaff`     int NOT NULL ,
 `TotalAmount` int ,

PRIMARY KEY (`idCart`),
FOREIGN KEY (`idConsumer`) REFERENCES `Consumer` (`idConsumer`),
FOREIGN KEY (`idStaff`) REFERENCES `Staff` (`idStaff`)
);


-- ************************************** `CartItem`

CREATE TABLE `CartItem`
(
 `idProduct` int NOT NULL ,
 `idCart`    int NOT NULL ,
 `idStore`   int NOT NULL ,
 `Quantity`  int ,
 `Price`     int ,

PRIMARY KEY (`idStore`, `idCart`, `idProduct`),
FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`),
FOREIGN KEY (`idCart`) REFERENCES `Cart` (`idCart`),
FOREIGN KEY (`idStore`) REFERENCES `Store` (`idStore`)
);