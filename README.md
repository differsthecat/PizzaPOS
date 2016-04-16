# PizzaPOS
Point of Sale system for Lucarelli's Pizza. Mobile Android companion.
***Please view raw version to see database structure***

Uses SQLite database engine

Database Structure:

Database title: Orders

There are two tables in Orders:

------------------------Orders---------------------------------
|                                                             |
|   ________Orders_______         _________Item_________      |
|   | int orderNum      |         | int orderNum       |      |
|   | String openDate   |         | String itemName    |      |
|   | int isOpen        |         | double price       |      |
|   |                   |         | String comments    |      |
|   |                   |         | String extras      |      |
|   |___________________|         |____________________|      |
|                                                             |
|                                                             |
---------------------------------------------------------------
