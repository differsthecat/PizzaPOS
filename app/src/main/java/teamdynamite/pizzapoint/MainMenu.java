package teamdynamite.pizzapoint;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainMenu extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Button variables
        Button viewOrderBtn = (Button) findViewById(R.id.buttons10);
        Button SoupsSaladsBtn = (Button) findViewById(R.id.SoupsSaladsBtn);
        Button SubsSandBtn = (Button) findViewById(R.id.SubsSandBtn);
        Button ClassicsBtn = (Button) findViewById(R.id.classicsBtn);
        Button ForTheKidsBtn = (Button) findViewById(R.id.forTheKidsBtn);
        Button SpecialtyPizzasBtn = (Button) findViewById(R.id.specialtyPizzasBtn);
        Button CustomPizzasBtn = (Button) findViewById(R.id.customPizzasBtn);
        Button CalzonesBtn = (Button) findViewById(R.id.calzonesBtn);
        Button PizzaPopsBtn = (Button) findViewById(R.id.pizzaPopsBtn);
        Button appsSidesBtn = (Button) findViewById(R.id.appsSidesBtn);
        Button DrinksBtn = (Button) findViewById(R.id.drinksBtn);
        Button SpecialtyDishesBtn = (Button) findViewById(R.id.specialtyDishesBtn);
        Button BackBtn = (Button) findViewById(R.id.backBtn);

        //Extracting the data from the
        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");

        System.out.println("ORDER NUMBER FROM MAIN MENU: " + orderNumber);

        TextView displayOrderNum;
        TextView textElement = (TextView) findViewById(R.id.orderNumberDisp);
        textElement.setText("Order Number: " + orderNumber); //leave this line to assign a specific text

        //Clicking "View Order" brings you to a screen that allows
        // you to view items in the order.
        viewOrderBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, ViewOrder.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        //Clicking "Soups and Salads opens up the sub menu of Soups/Salads.
        SoupsSaladsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, SoupsSalads.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        //Clicking "Subs and Sandwhiches" opens up the sub menu of Soups/Salads.
        SubsSandBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, SubsSandwhiches.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        //Clicking "Classics" opens up the sub menu of Classics.
        ClassicsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, Classics.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        //Clicking "For The Kids" opens up the sub menu of For the  Kids.
        ForTheKidsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, ForTheKids.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        SpecialtyPizzasBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, SpecialtyPizzas.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        CustomPizzasBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, CustomPizzas.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        CalzonesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, Calzones.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        appsSidesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Create the bundle to pass the order number
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(MainMenu.this, AppsAndSides.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);

            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(MainMenu.this);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainMenu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://teamdynamite.pizzapoint/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainMenu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://teamdynamite.pizzapoint/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
