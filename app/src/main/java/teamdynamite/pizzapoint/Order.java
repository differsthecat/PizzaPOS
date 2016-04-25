package teamdynamite.pizzapoint;

//This file contains all of the getters and setters for the database items.

//This class contains the getters and setters for the Order class
public class Order {

    private int orderNumber;
    private String openDate;
    private int isOpen;

    public Order(){

    }
    public Order(int orderNum, String openDate, int isOpen){

        this.orderNumber = orderNum;
        this.openDate = openDate;
        this.isOpen = isOpen;

    }

    public void setOrderNum(int orderNum){

        this.orderNumber = orderNum;
    }

    public void setOpenDate(String openDate){

        this.openDate = openDate;
    }

    public void setIsOpen(int isOpen){

        this.isOpen = isOpen;

    }
    public int getOrderNumber(){

        return orderNumber;
    }
    public String getOpenDate(){

        return openDate;
    }
    public int getIsOpen(){

        return isOpen;
    }
}
//Getters and setters for the Item class.
class Item {

    private String comments;
    private String extras;
    private int orderNum;
    private String itemName;
    private double price;
    private int _id;


    public Item(){

    }

    //Getters and setters for the item columns
    public Item(String comments, String extras, int orderNum, String itemName, double price, int _id){

        this.comments= comments;
        this.extras = extras;
        this.orderNum = orderNum;
        this.itemName = itemName;
        this.price = price;
        this._id = _id;

    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }


    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



}
