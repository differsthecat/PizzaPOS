package teamdynamite.pizzapoint;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class OpenOrder extends AppCompatActivity {

    final DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button openOrderBtn = (Button) findViewById(R.id.openOrderBtn);



    }

    private void populateOrders(){

        Cursor cursor = db.orderListView();
        String[] fromFieldNames = new String[] {DBHandler.KEY_ORDER_NUMBER, DBHandler.KEY_DATE};
        int[] toViewOrders = new int[] {R.id.orderNumT, R.id.orderDateT};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.custom_layout, cursor, fromFieldNames, toViewOrders, 0);
       // ListView myList = (ListView) findViewById(R.id.listViewDisp);
       // myList.setAdapter(myCursorAdapter);
    }
}
