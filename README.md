# PizzaPOS
Point of Sale system for Lucarelli's Pizza. Mobile Android companion.

***Please view raw version to see database structure***

Uses SQLite database engine

Database Structure:

Database title: Orders

There are two tables in Orders:
Table Orders: column int order_num, column String open_date, column int is_open (Functions as a boolean value)
Table Items: colum int orderNum, column String itemName, column double price, column String comments, column String extras  

class DBHelper conducts all database operations and including database methods and queries.
class Order contains getters and setters for table Orders.
class Item contains getters and setters for table Item.


***Please view raw version to see database structure***

---------------------------Orders------------------------------
|                                                             |
|   ________Orders_______         _________Item_________      |
|   | int order_Num     |         | int orderNum       |      |
|   | String openDate   |         | String itemName    |      |
|   | int isOpen        |         | double price       |      |
|   |                   |         | String comments    |      |
|   |                   |         | String extras      |      |
|   |___________________|         |____________________|      |
|                                                             |
|                                                             |
---------------------------------------------------------------
