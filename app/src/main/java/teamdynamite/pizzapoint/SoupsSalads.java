package teamdynamite.pizzapoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoupsSalads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soups_salads);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button backBtn = (Button) findViewById(R.id.backBtn);
        Button veggieWrap = (Button) findViewById(R.id.veggieWrapBtn);
        Button antipasto = (Button) findViewById(R.id.antipastoBtn);
        Button insalataCaprese = (Button) findViewById(R.id.insalataBtn);

        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");

        System.out.println("ORDER NUMBER FROM Soups and SALADS: " + orderNumber);

        TextView displayOrderNum;
        TextView textElement = (TextView) findViewById(R.id.orderNumberDisp);
        textElement.setText("Order Number: " + orderNumber); //leave this line to assign a specific text

        //Clicking "Soups and Salads opens up the sub menu of Soups/Salads.
        veggieWrap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(SoupsSalads.this, RoastedVeggieWrap.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        antipasto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(SoupsSalads.this, Antipasto.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);
            }
        });

        insalataCaprese.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SoupsSalads.this, InsalataCaprese.class));
            }
        });

        //Clicking "BACK" goes back to the main menu.
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(SoupsSalads.this);
            }
        });

    }

}
