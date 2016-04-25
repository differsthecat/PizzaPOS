package teamdynamite.pizzapoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class italianBeef extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_beef);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addToOrder = (Button) findViewById(R.id.addtToOrder);
        Button backButton = (Button) findViewById(R.id.backButton);

        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");
        final EditText comments = (EditText) findViewById(R.id.italianBeefComments);



        TextView displayOrderNum;
        TextView textElement = (TextView) findViewById(R.id.orderNumberDisp);
        textElement.setText("Order Number: " + orderNumber); //leave this line to assign a specific text

        final DBHandler db = new DBHandler(this);
        final int itemNum = (db.newItemNum() + 1);

        //Clicking "add to order" add the item to the order.
        addToOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(italianBeef.this, MainMenu.class));


                db.addItem(new Item(comments.getText().toString() , "N/A", orderNumber , "Italian Beef", 10.95, itemNum));

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(italianBeef.this, MainMenu.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);
            }
        });

    }

}
