package teamdynamite.pizzapoint;

public class Order {

    private int orderNum;
    private String openDate;

    public Order(){

    }
    public Order(int orderNum, String openDate){

        this.orderNum = orderNum;
        this.openDate = openDate;

    }

    public void setOrderNum(int orderNum){
        this.orderNum = orderNum;
    }

    public void setOpenDate(String openDate){
        this.openDate = openDate;

    }

    public int getOrderNum(){
        return orderNum;
    }
    public String getOpenDate(){
        return openDate;
    }
}

class Item {

    private String comments;
    private String extras;
    private int orderNum;
    private String itemName;
    private double price;

    public Item(){

    }
    public Item(String comments, String extras, int orderNum, String itemName, double price){

        this.comments= comments;
        this.extras = extras;
        this.orderNum = orderNum;
        this.itemName = itemName;
        this.price = price;
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
