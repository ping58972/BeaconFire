CREATE DATABASE IF NOT EXISTS jdbc_demo;
USE jdbc_demo;

DROP TABLE IF EXISTS Pastry;

CREATE TABLE IF NOT EXISTS Pastry (
	id int auto_increment PRIMARY KEY,
    name varchar(42),
    price float
);

INSERT INTO Pastry (name, price) VALUES 
('cinnamon roll', 42.42),
('chocolate truffle', 12.34),
('mango sorbet', 1.23),
('apple cider donut', 3.14),
('strawberry cake', 6.50);

SELECT * FROM Pastry;