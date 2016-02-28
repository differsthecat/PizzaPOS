package teamdynamite.pizzapoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText userNameText = (EditText) findViewById(R.id.userNameText);
        Button loginButton = (Button) findViewById(R.id.button);
        final TextView IncorrectID = (TextView) findViewById(R.id.IncorrectEmpId);

            loginButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if(userNameText.getText().toString().equals("1234567")) {
                        startActivity(new Intent(MainActivity.this, New_Order.class));
                    }
                    else{
                        IncorrectID.setVisibility(View.VISIBLE);

                    }
                }
            });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
