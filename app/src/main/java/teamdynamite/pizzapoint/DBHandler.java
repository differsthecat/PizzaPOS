package teamdynamite.pizzapoint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Orders";

    // Order table name
    private static final String TABLE_ORDER = "Order";
    // Order table Columns names
    private static final String KEY_ORDER_NUMBER= "order_num";
    private static final String KEY_DATE= "open_date";

    //Item table name
    private static final String TABLE_ITEM = "Item";

    //ITem table column names
    private static final String KEY_ORDER_NUM = "order_num";
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_COMMENTS = "comments";
    private static final String KEY_EXTRAS = "extras";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creates the 'Order' table
        String CREATE_ORDER_TABLE = "CREATE TABLE " + TABLE_ORDER + "("
                + KEY_ORDER_NUMBER + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT " + ")";
        db.execSQL(CREATE_ORDER_TABLE);

        //Creates the 'Items' table
        String CREATE_TABLE_ITEM = "CREATE TABLE" + TABLE_ITEM + "("
                + KEY_ITEM_NAME + " TEXT, " + KEY_PRICE + " REAL, " + KEY_COMMENTS + " TEXT, "
                + KEY_EXTRAS + " TEXT, " + "FOREIGN KEY (" + KEY_ORDER_NUM + ") REFERNECES "
                + TABLE_ORDER + "(" + KEY_ORDER_NUMBER + ")" +");" ;
        db.execSQL(CREATE_TABLE_ITEM);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
        onCreate(db);

    }

}