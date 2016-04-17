package teamdynamite.pizzapoint;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class New_Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Button variables
        Button NewOrderButton = (Button) findViewById(R.id.NewOrderButton);
        Button OpenOrderButton = (Button) findViewById(R.id.EditOrderButton);

        final DBHandler db = new DBHandler(this);



        //When 'New Order' is clicked, new order is created and the Main Menu opens
        NewOrderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Query database to find the highest order number
                int orderNum = db.newOrderNum();

                //Create a new orderId
                orderNum = (orderNum + 1);

                //For testing puposes. Appears in the log
                String log = "# " + orderNum;
                Log.d("New Order Number: ", log);

                //Create an instance of Calender
                Calendar c = Calendar.getInstance();

                //Get the date and format it
                SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm");
                String formattedDate = df.format(c.getTime());
                String date = "::::::: " + formattedDate;
                Log.d("Date: ", date);

                //Make a new entry into the database with new order #, date, and isOpen = 1
                db.addOrder(new Order(orderNum, formattedDate, 1));

                //This allows data to be passed across activities.
                //Need to bundle the data and send it with the Intent.
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNum);

                //Create the Intent
                Intent intentBundle = new Intent (New_Order.this, MainMenu.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);
            }
        });

        //When 'Edit Order' is clicked
        OpenOrderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(New_Order.this, OpenOrder.class));
            }
        });
    }

}
