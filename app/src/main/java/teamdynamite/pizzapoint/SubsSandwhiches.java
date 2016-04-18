package teamdynamite.pizzapoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubsSandwhiches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subs_sandwhiches);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button italianBeefBtn = (Button) findViewById(R.id.italianBeefBtn);
        Button backBtn = (Button) findViewById(R.id.backBtn);

        Bundle extrasBundle = getIntent().getExtras();

        final int orderNumber = extrasBundle.getInt("Order Number");

        System.out.println("ORDER NUMBER FROM MAIN MENU: " + orderNumber);

        TextView displayOrderNum;
        TextView textElement = (TextView) findViewById(R.id.orderNumberDisp);
        textElement.setText("Order Number: " + orderNumber); //leave this line to assign a specific text


        //Clicking "BACK" goes back to the main menu.
        italianBeefBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("Order Number", orderNumber);

                //Create the Intent
                Intent intentBundle = new Intent(SubsSandwhiches.this, italianBeef.class);
                intentBundle.putExtras(bundle);

                //Open Main Order Menu, along with the extra data
                startActivity(intentBundle);
            }
        });
    }
}
