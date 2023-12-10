SELECT * FROM northwind.products;
#CRUD

#Create
INSERT INTO products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES ('Pluots',25, 7, '1 piece of fruit', 30, 50, 10, 0, 0);

#update
UPDATE products
SET UnitsInStock = 100, UnitsInStock = 20
WHERE ProductId = 83;

CREATE TABLE pokemon(
	PokemonID INT AUTO_INCREMENT, 
    MoveSet VARCHAR(100) NOT NULL,
    Type VARCHAR(10) NOT NULL,
    Name VARCHAR(50) NOT NULL,
    Hp INT NOT NULL,
    Weaknesses VARCHAR(100) NOT NULL,
    PRIMARY KEY (PokemonID)
    );
    
    ALTER TABLE pokemon
    ADD Location VARCHAR(50) NOT NULL;
    
    ALTER TABLE pokemon
    DROP COLUMN location;

#delete
DELETE
FROM products
WHERE ProductID = 81 AND 82;

#Creating a foreign Key
CREATE TABLE Author(
AuthorID INT AUTO_INCREMENT,
AuthorName VARCHAR(100),
PRIMARY KEY (AuthorID)
);

CREATE TABLE books (
BookID INT AUTO_INCREMENT,
BookTitle VARCHAR(255),
AuthorID INT,
PRIMARY KEY (BookID),
FOREIGN KEY (AuthorID) REFERENCES author (AuthorID)
);

INSERT INTO Author(AuthorName)
VALUES('Isaac Asimov');

INSERT INTO books(BookTitle, AuthorID)
VALUES('Foundation End', 1);



