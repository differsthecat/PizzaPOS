package teamdynamite.pizzapoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

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

        //Clicking "Soups and Salads opens up the sub menu of Soups/Salads.
        veggieWrap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SoupsSalads.this, RoastedVeggieWrap.class));
            }
        });

        antipasto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SoupsSalads.this, Antipasto.class));
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
                startActivity(new Intent(SoupsSalads.this, MainMenu.class));
            }
        });

    }

}
