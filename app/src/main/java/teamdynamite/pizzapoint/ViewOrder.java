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

        Button completeBtn = (Button) findViewById(R.id.completeBtn);
        Button onHoldBtn = (Button) findViewById(R.id.onHoldbtn);

        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");

        double price = db.orderTotal(orderNumber);
        TextView displayOrderNum = (TextView) findViewById(R.id.orderNumDisp);
        TextView totalPrice = (TextView) findViewById(R.id.orderTotalDisp);
        displayOrderNum.setText("Order Number: " + orderNumber); //leave this line to assign a specific text
        totalPrice.setText("Order Total: $" + price);

        Cursor cursor = db.itemListView(orderNumber);
        String[] fromFieldNames = new String[]{DBHandler.KEY_ITEM_NAME, DBHandler.KEY_COMMENTS, DBHandler.KEY_PRICE};
        int[] toViewOrders = new int[]{R.id.itemName, R.id.itemComments, R.id.itemPrice};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.view_items_layout, cursor, fromFieldNames, toViewOrders, 0);
        ListView myList = (ListView) findViewById(R.id.listView2);
        myList.setAdapter(myCursorAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Button removeBtn = (Button) view.findViewById(R.id.removeButton);


            }
        });

        completeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.closeOrder(orderNumber);
                Intent intent = new Intent (ViewOrder.this, New_Order.class);
                startActivity(intent);
            }
        });

        onHoldBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (ViewOrder.this, New_Order.class);
                startActivity(intent);
            }
        });

    }
}
