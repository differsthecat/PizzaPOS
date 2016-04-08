# PizzaPOS
Point of Sale system for Lucarelli's Pizza. Mobile Android companion.

Uses SQLite database engine

Database Structure:

Database title: Orders

There are two tables in Orders:

------------------------Orders---------------------------------
|                                                             |
|   ________Order________         _________Item_________      |
|   | int orderNum      |         | int orderNum       |      |
|   | String openDate   |         | String itemName    |      |
|   |                   |         | double price       |      |
|   |                   |         | String comments    |      |
|   |                   |         | String extras      |      |
|   |___________________|         |____________________|      |
|                                                             |
|                                                             |
---------------------------------------------------------------
