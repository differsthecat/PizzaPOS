package teamdynamite.pizzapoint;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.Intent;
import android.widget.Button;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button viewOrderBtn = (Button) findViewById(R.id.buttons10);
        Button SoupsSaladsBtn = (Button) findViewById(R.id.SoupsSaladsBtn);

        //Clicking "View Order" brings you to a screen that allows
        // you to view items in the order.
        viewOrderBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, ViewOrder.class));
            }
        });

        //Clicking "Soups and Salads opens up the sub menu of Soups/Salads.
        SoupsSaladsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, SoupsSalads.class));
            }
        });


    }

}
