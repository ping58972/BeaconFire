use aw;


-- 1. Find the total Internet sales tax amount.
select sum(TaxAmt) as "Total Internet Sales Tax Amount" from FactInternetSales;


-- 2. Find the Internet sales amount per order by year and quarter of order date.
 select CalendarYear, CalendarQuarter, sum(SalesAmount) as "Seles Amount" from ((select OrderDateKey, SalesAmount from FactInternetSales) as S join
  (select TimeKey, CalendarYear, CalendarQuarter from DimTime) as T 
  on S.OrderDateKey = T.TimeKey) group by CalendarYear, CalendarQuarter 
  order by CalendarYear, CalendarQuarter; 
  
  
  
-- 3. Find the percentage of sales amount for each order over total sales amount of
-- that month by shipping date.

-- ------------- Practice -------------
select STE.SalesOrderNumber, round(STE.TotalSalesAmountPerOrderNumber/STT.TotalSalesAmountPerMonth * 100, 2) 
as PercentageOfSalesAmountPerOrderOverMonth, STT.MonthNumberOfYear, STT.CalendarYear from
(select T.CalendarYear, T.MonthNumberOfYear, sum(S.SalesAmount) as TotalSalesAmountPerOrderNumber, S.SalesOrderNumber 
from (select ProductKey, SalesAmount, ShipDateKey, SalesOrderNumber  from FactInternetSales) as S join
(select TimeKey, MonthNumberOfYear, CalendarYear from DimTime) as T on S.ShipDateKey = T.TimeKey 
group by S.SalesOrderNumber, T.CalendarYear, T.MonthNumberOfYear)
 as STE  left join
(select T.CalendarYear, T.MonthNumberOfYear, sum(S.SalesAmount) as TotalSalesAmountPerMonth from 
(select ProductKey, SalesAmount, ShipDateKey from FactInternetSales) as S join
(select TimeKey, MonthNumberOfYear, CalendarYear from DimTime) as T on S.ShipDateKey = T.TimeKey 
group by T.MonthNumberOfYear, T.CalendarYear) as STT on STE.MonthNumberOfYear = STT.MonthNumberOfYear 
and STE.CalendarYear = STT.CalendarYear; 
-- ------------------------------

create or replace view TotalSalesPerOrder as
(select T.CalendarYear, T.MonthNumberOfYear, sum(S.SalesAmount) as TotalSalesAmountPerOrderNumber, S.SalesOrderNumber 
from (select ProductKey, SalesAmount, ShipDateKey, SalesOrderNumber  from FactInternetSales) as S join
(select TimeKey, MonthNumberOfYear, CalendarYear from DimTime) as T on S.ShipDateKey = T.TimeKey 
group by S.SalesOrderNumber, T.CalendarYear, T.MonthNumberOfYear);

create or replace view TotalSalesAmountPerMonth as
(select T.CalendarYear, T.MonthNumberOfYear, sum(S.SalesAmount) as TotalSalesAmountPerMonth from 
(select ProductKey, SalesAmount, ShipDateKey from FactInternetSales) as S join
(select TimeKey, MonthNumberOfYear, CalendarYear from DimTime) as T on S.ShipDateKey = T.TimeKey 
group by T.MonthNumberOfYear, T.CalendarYear);

select STE.SalesOrderNumber, round(STE.TotalSalesAmountPerOrderNumber/STT.TotalSalesAmountPerMonth * 100, 2) 
as PercentageOfSalesAmountPerOrderOverMonth, STT.MonthNumberOfYear, STT.CalendarYear from TotalSalesPerOrder 
as STE  left join TotalSalesAmountPerMonth as STT on STE.MonthNumberOfYear = STT.MonthNumberOfYear 
and STE.CalendarYear = STT.CalendarYear; 


-- 4. Display the full name, age, address(City, State, Country) and marital status of all
-- customers who live in the US

create or replace view Customer as
select concat(FirstName, " ", LastName) as FullName,
 round(datediff(CURDATE(), BirthDate)/365.25) as age, BirthDate,  AddressLine1 as address, GeographyKey, MaritalStatus from DimCustomer;
 
select FullName, age, address, City, State, Country, MaritalStatus from ((select * from Customer) as C inner join 
(select GeographyKey, City, StateProvinceName as State, EnglishCountryRegionName as Country from DimGeography) as G
on C.GeographyKey = G.GeographyKey) where Country = "United States";

-- 5. Create a view with product sold amount by subcategory by category by year and
-- month of order date.
create or replace view ProductSoldAmountBySCYM as
select ST.ProductKey, ST.SalesAmount, ST.MonthNumberOfYear, ST.CalendarYear, PPS.ProductSubcategoryKey, PPS.ProductCategoryKey  from
(select ProductKey, SalesAmount, MonthNumberOfYear, CalendarYear from
(select ProductKey, SalesAmount, OrderDateKey from FactInternetSales) as S join
(select TimeKey, MonthNumberOfYear, CalendarYear from DimTime) as T on S.OrderDateKey = T.TimeKey) as ST
left join 
(select P.ProductKey, P.ProductSubcategoryKey, PS.ProductCategoryKey
  from (select ProductKey, ProductSubcategoryKey from DimProduct) as P left join 
(select ProductSubcategoryKey, ProductCategoryKey from DimProductSubcategory) as PS 
on P.ProductSubcategoryKey = PS.ProductSubcategoryKey) as PPS on ST.ProductKey = PPS.ProductKey;

-- ------------- Practice -------------
create or replace view ProductSoldAmountByCategory as
select PPS.ProductCategoryKey  from 
(select ProductKey, SalesAmount, OrderDateKey from FactInternetSales) as F left join 
(select P.ProductKey, P.ProductSubcategoryKey, PS.ProductCategoryKey
  from (select ProductKey, ProductSubcategoryKey from DimProduct) as P left join 
(select ProductSubcategoryKey, ProductCategoryKey from DimProductSubcategory) as PS 
on P.ProductSubcategoryKey = PS.ProductSubcategoryKey) 
as PPS on F.ProductKey = PPS.ProductKey ;  


-- product sold amount by subcategory
create or replace view ProductSoldAmountBySubcategory as
select P.ProductSubcategoryKey, sum(F.SalesAmount) as TotalSales from (select ProductKey, SalesAmount from FactInternetSales) as F left join 
(select ProductKey, ProductSubcategoryKey from DimProduct) as P  on F.ProductKey = P.ProductKey 
group by P.ProductSubcategoryKey order by P.ProductSubcategoryKey;

-- product sold amount by category
create or replace view ProductSoldAmountByCategory as
select PPS.ProductCategoryKey, sum(F.SalesAmount) as TotalSales  from 
(select ProductKey, SalesAmount from FactInternetSales) as F left join 
(select P.ProductKey, P.ProductSubcategoryKey, PS.ProductCategoryKey
  from (select ProductKey, ProductSubcategoryKey from DimProduct) as P left join 
(select ProductSubcategoryKey, ProductCategoryKey from DimProductSubcategory) as PS 
on P.ProductSubcategoryKey = PS.ProductSubcategoryKey) 
as PPS on F.ProductKey = PPS.ProductKey group by PPS.ProductCategoryKey;


-- product sold amount by year and month of order date.
create or replace view TotalSalesAmountPerMonthYear as
(select sum(S.SalesAmount) as TotalSalesAmountPerMonth, T.MonthNumberOfYear, T.CalendarYear  from 
(select ProductKey, SalesAmount, OrderDateKey from FactInternetSales) as S join
(select TimeKey, MonthNumberOfYear, CalendarYear from DimTime) as T on S.OrderDateKey = T.TimeKey 
group by T.MonthNumberOfYear, T.CalendarYear order by T.CalendarYear, T.MonthNumberOfYear);

-- -----------------------------------------------

-- 6. Use the view created to display product sold amount by category by year of order date.
create or replace view ProductSoldAmountByCY as
select ProductKey, ProductCategoryKey,  CalendarYear from ProductSoldAmountBySCYM;

-- 7. Group the customers into different age groups: < 30, 30-50, 50+. 
-- Get the total number of customers and total number of Internet sales in each group.

create or replace view CustomerAge as
(select CustomerKey, 
 round(datediff(CURDATE(), BirthDate)/365.25) as age from DimCustomer);


select count(distinct(F.CustomerKey)) from
(select CustomerKey, SalesOrderNumber from FactInternetSales) as F inner join
 (select * from CustomerAge where age < 30) as CA on F.CustomerKey = CA.CustomerKey;
 
 
  select count(F.CustomerKey) from
(select CustomerKey, SalesOrderNumber from FactInternetSales) as F inner join
 (select * from CustomerAge where age < 30) as CA on F.CustomerKey = CA.CustomerKey;

select count(distinct(F.CustomerKey)) from
(select CustomerKey, SalesOrderNumber from FactInternetSales) as F inner join
 (select * from CustomerAge where age between 30 and 50) as CA on F.CustomerKey = CA.CustomerKey;
 
  
  select count(F.CustomerKey) from
(select CustomerKey, SalesOrderNumber from FactInternetSales) as F inner join
 (select * from CustomerAge where age between 30 and 50) as CA on F.CustomerKey = CA.CustomerKey;

select count(distinct(F.CustomerKey)) from
(select CustomerKey, SalesOrderNumber from FactInternetSales) as F left join
 (select * from CustomerAge where age > 50) as CA on F.CustomerKey = CA.CustomerKey;
 
  select count(F.CustomerKey) from
(select CustomerKey, SalesOrderNumber from FactInternetSales) as F left join
 (select * from CustomerAge where age > 50) as CA on F.CustomerKey = CA.CustomerKey;
  

 /*
 8. Write a SQL query to find the most recent salary of each employee. In other words,
given the Employee table and Salary table, construct a query to output the Output
table.
 */
 select employee_id, name, effective_date, salary from (select * from Employee) as E left join
 (select distinct(employee_id), effective_date, salary from Salary group by employee_id 
 having effective_date in( select effective_date from Salary order by effective_date desc limit 0)) 
 as S on E.employee_id = S.employee_id;
 
