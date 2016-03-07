package teamdynamite.pizzapoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class InsalataCaprese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insalata_caprese);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addToOrder = (Button) findViewById(R.id.addtToOrder);
        Button backButton = (Button) findViewById(R.id.backButton);


        addToOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Needs to also add itm to order.
                startActivity(new Intent(InsalataCaprese.this, MainMenu.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(InsalataCaprese.this, SoupsSalads.class));
            }
        });

    }

}
