package zooapp.jmdel.fr.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import zooapp.jmdel.fr.zooapp.activity.animal.AnimalActivity;
import zooapp.jmdel.fr.zooapp.activity.enclos.EnclosActivity;
import zooapp.jmdel.fr.zooapp.activity.food.FoodActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton animal = (FloatingActionButton) findViewById(R.id.animal);
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,AnimalActivity.class);
                startActivity(intent);
                //((TextView)findViewById(R.id.message)).setText("Animals");
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
            }
        });

        FloatingActionButton enclosure = (FloatingActionButton) findViewById(R.id.enclosure);
        enclosure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EnclosActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton food = (FloatingActionButton) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FoodActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton ticket = (FloatingActionButton) findViewById(R.id.ticket);
        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ((TextView)findViewById(R.id.message)).setText("Tickets");
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
