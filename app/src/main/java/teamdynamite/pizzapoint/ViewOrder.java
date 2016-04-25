package teamdynamite.pizzapoint;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class ViewOrder extends AppCompatActivity {


    final DBHandler db = new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");


        //Buttons that
        Button completeBtn = (Button) findViewById(R.id.completeBtn);
        Button onHoldBtn = (Button) findViewById(R.id.onHoldbtn);


        //Populate the ListView with the items that have the same orderNum
        //as the one that was used to open this activity.
        double price = db.orderTotal(orderNumber);
        TextView displayOrderNum = (TextView) findViewById(R.id.orderNumDisp);
        TextView totalPrice = (TextView) findViewById(R.id.orderTotalDisp);
        displayOrderNum.setText("Order Number: " + orderNumber); //Fills in Order Number
        totalPrice.setText("Order Total: $" + price);

        //Cursor loops through 'Items' in the database and populates the
        //list view with items that have the same order number
        Cursor cursor = db.itemListView(orderNumber);
        String[] fromFieldNames = new String[]{DBHandler.KEY_ITEM_NAME, DBHandler.KEY_COMMENTS, DBHandler.KEY_PRICE, DBHandler.KEY_ID};
        int[] toViewOrders = new int[]{R.id.itemName, R.id.itemComments, R.id.itemPrice, R.id.itemId};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.view_items_layout, cursor, fromFieldNames, toViewOrders, 0);
        ListView myList = (ListView) findViewById(R.id.listView2);
        myList.setAdapter(myCursorAdapter);

        //OnClick listener for each item int the list
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Get the itemId from the item clicked on
                TextView itemNum = (TextView) view.findViewById(R.id.itemId);
                System.out.println("ITEM NUM FROM VIEW: "+ itemNum);
                String itemId = itemNum.getText().toString();
                int itId = Integer.parseInt(itemId);
                //delete that item from the database
                db.deleteItem(itId);

                loadList();
            }
        });
        //If the complete button is licked, the isOpen value for that
        //item is set to 1 via the closeOrder(int) method from
        //DBHandler
        completeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.closeOrder(orderNumber);
                Intent intent = new Intent (ViewOrder.this, New_Order.class);
                startActivity(intent);
            }
        });
        //If the order is placed on hold, the isOpen value is
        //left the same, and the order will still appear int the list
        //of Open Orders
        onHoldBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (ViewOrder.this, New_Order.class);
                startActivity(intent);
            }
        });

    }
    public void loadList(){

        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");

        //Reset the price
        double price = db.orderTotal(orderNumber);
        TextView totalPrice = (TextView) findViewById(R.id.orderTotalDisp);
        totalPrice.setText("Order Total: $" + price);

        //Reload the list
        Cursor cursor = db.itemListView(orderNumber);
        String[] fromFieldNames = new String[]{DBHandler.KEY_ITEM_NAME, DBHandler.KEY_COMMENTS, DBHandler.KEY_PRICE, DBHandler.KEY_ID};
        int[] toViewOrders = new int[]{R.id.itemName, R.id.itemComments, R.id.itemPrice, R.id.itemId};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.view_items_layout, cursor, fromFieldNames, toViewOrders, 0);
        ListView myList = (ListView) findViewById(R.id.listView2);
        myList.setAdapter(myCursorAdapter);

        //OnClick listener for each item int the list
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Get the itemId from the item clicked on
                TextView itemNum = (TextView) view.findViewById(R.id.itemId);
                String itemId = itemNum.getText().toString();
                int itId = Integer.parseInt(itemId);
                //delete that item from the database
                db.deleteItem(itId);

                loadList();

            }
    });

    }
}
