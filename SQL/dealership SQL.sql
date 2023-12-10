CREATE DATABASE vehicle;

#Dealership table
CREATE TABLE dealerships(
dealershipID INT AUTO_INCREMENT,
name VARCHAR(50),
address VARCHAR(50),
phone VARCHAR(12),
PRIMARY KEY (dealershipID)
);

#Vehicle Table
CREATE TABLE vehicles(
vehicleID INT,
make VARCHAR(255),
model VARCHAR(255),
year INT,
VIN VARCHAR(17),
Color VARCHAR(50),
mileage INT,
price DECIMAL(10, 2),
availability BIT,
PRIMARY KEY (vehicleID)
);

#inventory Table
CREATE TABLE inventory(
inventoryID INT AUTO_INCREMENT PRIMARY KEY,
dealershipID INT,
VIN VARCHAR(17),
FOREIGN KEY (dealershipID) REFERENCES dealerships (dealershipID),
FOREIGN KEY (VIN) REFERENCES vehicles (VIN)
);

#Sales Contract Table
CREATE TABLE sales_contract(
ContractID INT,
CustomerID INT,
ContractDate DATE,
VehicleID INT,
LoanTerm INT,
InterestRate FLOAT,
MonthlyPayment FLOAT,
PRIMARY KEY (ContractID), 
FOREIGN KEY (VehicleID) REFERENCES vehicles (VehicleID)
);

#populate tables with data
INSERT INTO dealerships (name, address, phone)
VALUES ('SmooveWay dealership', '7101 OBlock', '738-3498'); 

INSERT INTO vehicles (vehicleID, make, model, year, VIN, color, mileage, price, availability)
VALUES
(1, 'Toyota', 'Camry', 2022, 'ABC123456789DEF01', 'Blue', 15000, 25000.00, 1),
(2, 'Honda', 'Civic', 2021, 'XYZ987654321ABC01', 'Silver', 20000, 22000.00, 1),
(3, 'Ford', 'Mustang', 2023, 'LMN456789012GHI01', 'Red', 8000, 35000.00, 1);

INSERT INTO inventory (dealershipID, VIN)
VALUES
    (1, 'ABC123456789DEF01'),
    (2, 'XYZ987654321ABC01'),
    (1, 'LMN456789012GHI01');

INSERT INTO sales_contract(ContractID, CustomerID, VehicleID, LoanTerm, InterestRate, MonthlyPayment, ContractDate)
VALUES
    (1, 101, 1, 36, 4.5, 600.00, '2023-10-20'),
    (2, 102, 2, 48, 3.9, 550.00, '2023-11-25'),
    (3, 103, 3, 60, 5.2, 700.00, '2023-12-10');
    
#Test
#1 Get all dealerships
SELECT * 
FROM dealerships;

#2 Find all vehicles for a specific dealership
SELECT v.*
FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
JOIN dealerships d ON i.dealershipID = d.dealershipID
WHERE d.name = 'SmooveWay dealership';

#3 Find a car by VIN
SELECT *
FROM inventory
WHERE VIN = 'ABC123456789DEF01';

#4 Find the dealership where a certain car is located by VIN
SELECT d.*
FROM dealerships d
JOIN inventory i ON d.dealershipID = i.dealershipID
WHERE i.VIN = 'ABC123456789DEF01';

#5 Find all Dealerships that have a certain car type
SELECT DISTINCT d. *
FROM dealerships d
JOIN inventory i ON d.dealershipID = i.dealershipID
JOIN vehicles v ON i.VIN = v.VIN
WHERE make = 'Camry';

#6 Get all sales information for a specific dealer for a specific date range
SELECT
    s.ContractID,
    c.CustomerID,
    v.Make,
    v.Model,
    s.ContractDate,
    s.LoanTerm,
    s.InterestRate,
    s.MonthlyPayment
FROM
    sales_contract s
JOIN
    vehicles v ON s.VehicleID = v.VehicleID
JOIN
    customers c ON s.CustomerID = c.CustomerID
JOIN
    inventory i ON v.VIN = i.VIN
    WHERE
    d.name = 'SmooveWay dealership'
    AND s.ContractDate BETWEEN '2023-01-01' AND '2023-12-31';

