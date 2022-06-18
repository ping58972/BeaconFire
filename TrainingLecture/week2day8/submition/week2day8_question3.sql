use aw;

-- a. Return all columns and data regarding employees only.
SELECT * FROM aw.DimEmployee;

-- b. Return all the names of customers in adventureworks (all 3 columns).
select FirstName, MiddleName, LastName from aw.DimCustomer;

-- c. List all customers whose first name is Eugene.
select * from aw.DimEmployee where FirstName = "Eugene";