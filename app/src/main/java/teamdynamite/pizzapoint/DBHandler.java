package teamdynamite.pizzapoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;


public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    public static final String DATABASE_NAME = "Orders";

    // Order table name
    public static final String TABLE_ORDER = "Orders";
    // Order table Columns names
    public static final String KEY_ROWID = "_id";
    public static final int COL_ROWID = 0;

    public static final String KEY_ORDER_NUMBER = "order_num";
    public static final String KEY_DATE = "open_date";
    public static final String KEY_ISOPEN = "is_open";

    //Item table name
    public static final String TABLE_ITEM = "Item";

    //ITem table column names
    public static final String KEY_ORDER_NUM = "forder_num";
    public static final String KEY_ITEM_NAME = "item_name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_COMMENTS = "comments";
    //Extras will handle special items like toppings.
    public static final String KEY_EXTRAS = "extras";


    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creates the 'Order' table
        String CREATE_ORDER_TABLE = "CREATE TABLE " + TABLE_ORDER + "("
                + KEY_ORDER_NUMBER + " INTEGER PRIMARY KEY, "
                + KEY_DATE + " TEXT, "
                + KEY_ISOPEN + " INTEGER )";
        db.execSQL(CREATE_ORDER_TABLE);

        //Creates the 'Items' table
        String CREATE_TABLE_ITEM = "CREATE TABLE " + TABLE_ITEM + "("
                + KEY_ORDER_NUM + " INTEGER, "
                + KEY_ITEM_NAME + " TEXT, "
                + KEY_PRICE + " REAL, "
                + KEY_COMMENTS + " TEXT, "
                + KEY_EXTRAS + " TEXT, "
                + "FOREIGN KEY (" + KEY_ORDER_NUM + ") REFERENCES "
                + TABLE_ORDER + "(" + KEY_ORDER_NUMBER + ")" + ");";
        db.execSQL(CREATE_TABLE_ITEM);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
        onCreate(db);

    }

    public DBHandler open() {
        SQLiteDatabase db = this.getWritableDatabase();
        return this;
    }


    // Adding new order
    public void addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ORDER_NUMBER, order.getOrderNumber()); // Order Number
        values.put(KEY_DATE, order.getOpenDate()); // open date
        values.put(KEY_ISOPEN, order.getIsOpen());// bool is open
        // Inserting Row
        db.insert(TABLE_ORDER, null, values);

    }

    public void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ORDER_NUM, item.getOrderNum());
        values.put(KEY_ITEM_NAME, item.getItemName());
        values.put(KEY_PRICE, item.getPrice());
        values.put(KEY_COMMENTS, item.getComments());
        values.put(KEY_EXTRAS, item.getExtras());
        //Inserting row
        db.insert(TABLE_ITEM, null, values);

    }

    // Getting one Order
    public int orderTotal() {
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT * FROM " + TABLE_ORDER;
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor != null && !cursor.isClosed()) {
            count = cursor.getCount();
            cursor.close();

        }
        return count;
    }

    public int newOrderNum() {

        SQLiteDatabase db = this.getReadableDatabase();

        final SQLiteStatement stmt = db
                .compileStatement("SELECT MAX(order_num) FROM Orders");

        return (int) stmt.simpleQueryForLong();

    }

    public Cursor orderListView() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT order_num AS _id, open_date FROM " + TABLE_ORDER + " WHERE is_open = 1 ";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public Cursor itemListView(int n) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+KEY_ORDER_NUM+" AS _id, "+KEY_ITEM_NAME+ " , "
                +KEY_COMMENTS+" , "+KEY_PRICE+" FROM " + TABLE_ITEM
                + " WHERE forder_num = " + n;
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public void deleteItem(){

    }

    public void closeOrder(int n){
        SQLiteDatabase db = this.getReadableDatabase();
        String strSQL = "UPDATE "+ TABLE_ORDER+" SET "+KEY_ISOPEN+" = 0 WHERE "+KEY_ORDER_NUMBER+" = "+ n;

        db.execSQL(strSQL);

    }

    public double orderTotal(int n){
        SQLiteDatabase db = this.getReadableDatabase();
        final SQLiteStatement stmt = db
                .compileStatement("SELECT SUM(Item.price) FROM Item WHERE Item.forder_num = "+ n);

        String s = (String) stmt.simpleQueryForString();
        double total = Double.parseDouble(s);
        return total;
    }

}