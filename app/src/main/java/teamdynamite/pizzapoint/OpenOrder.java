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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OpenOrder extends AppCompatActivity {

    final DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        populateOrders();


    }

    //This class populates the listView of the Activity by querying the database
    //and filling i with the orders that are open.
    private void populateOrders(){

        Cursor cursor = db.orderListView();
        String[] fromFieldNames = new String[] {"_id", DBHandler.KEY_DATE};
        int[] toViewOrders = new int[] {R.id.orderNumT, R.id.orderDateT};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.custom_layout, cursor, fromFieldNames, toViewOrders, 0);
        ListView myList = (ListView) findViewById(R.id.listView);
        myList.setAdapter(myCursorAdapter);

        //This sets each list item to be clickable, and opens the main menu while
        //passing the order# as information to the new activity
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView orderNum = (TextView) view.findViewById(R.id.orderNumT);
                String itemId = orderNum.getText().toString();
                Intent objIndent = new Intent(getApplicationContext(),MainMenu.class);
                objIndent.putExtra("Order Number", Integer.parseInt( itemId));
                startActivity(objIndent);
            }
        });
    }
}
