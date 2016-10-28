# PizzaPOS
Point of Sale system for Lucarelli's Pizza. Mobile Android companion.

Database
-------
Pizza POS uses SQLite database engine for storing orders.

Database Structure:

There are two tables in the Orders database:

```sql
Create Table Orders (
	order_num int,
	open_date text,
	is_open int -- Effectively boolean
);

Create Table Items (
	order_num int,
	itemName text,
	price double,
	comments text,
	extras text
);

```


The `DBHelper` class conducts all database operations and including database methods and queries.
The  `Order` class contains getters and setters for the `Orders` table.
The `Item` class contains getters and setters for the `Item` table.


![pizzaposdb](https://cloud.githubusercontent.com/assets/8926729/19327721/5f791758-909e-11e6-8f61-81ba7f6dedbd.png)
