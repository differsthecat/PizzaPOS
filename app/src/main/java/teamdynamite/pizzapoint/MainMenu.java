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

        //Clicking "Subs and Sandwhiches" opens up the sub menu of Soups/Salads.
        SubsSandBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, SubsSandwhiches.class));
            }
        });

        //Clicking "Classics" opens up the sub menu of Classics.
        ClassicsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Classics.class));
            }
        });

        //Clicking "For The Kids" opens up the sub menu of For the  Kids.
        ForTheKidsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, ForTheKids.class));
            }
        });

        SpecialtyPizzasBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, SpecialtyPizzas.class));
            }
        });

        CustomPizzasBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, CustomPizzas.class));
            }
        });

        CalzonesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Calzones.class));
            }
        });

        appsSidesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, AppsAndSides.class));
            }
        });

    }

}
