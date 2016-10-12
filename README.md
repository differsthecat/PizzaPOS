# PizzaPOS
Point of Sale system for Lucarelli's Pizza. Mobile Android companion.

Database
--------

Uses SQLite database engine

Database Structure:

Database title: Orders

There are two tables in Orders:
Table Orders: column int order_num, column String open_date, column int is_open (Functions as a boolean value)
Table Items: colum int orderNum, column String itemName, column double price, column String comments, column String extras  

class DBHelper conducts all database operations and including database methods and queries.
class Order contains getters and setters for table Orders.
class Item contains getters and setters for table Item.


![pizzaposdb](https://cloud.githubusercontent.com/assets/8926729/19327721/5f791758-909e-11e6-8f61-81ba7f6dedbd.png)
