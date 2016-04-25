package teamdynamite.pizzapoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RoastedVeggieWrap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roasted_veggie_wrap);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addToOrder = (Button) findViewById(R.id.addtToOrder);
        Button backButton = (Button) findViewById(R.id.backButton);
        final EditText comments = (EditText) findViewById(R.id.VeggieWrapComments);

        final String vegComments = comments.getText().toString();
        System.out.println(vegComments);
        System.out.println(vegComments);
        System.out.println(vegComments);
        System.out.println(vegComments);


        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");


        TextView displayOrderNum;
        TextView textElement = (TextView) findViewById(R.id.orderNumberDisp);
        textElement.setText("Order Number: " + orderNumber); //leave this line to assign a specific text

        final DBHandler db = new DBHandler(this);
        final int itemNum = (db.newItemNum() + 1);

        //Clicking "Soups and Salads opens up the sub menu of Soups/Salads.
        addToOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Needs to also add itm to order.
                System.out.println(vegComments);

                db.addItem(new Item(comments.getText().toString() , "N/A", orderNumber , "Roasted Veggie Wrap", 8.95, itemNum));

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(RoastedVeggieWrap.this, MainMenu.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });


    }

}
